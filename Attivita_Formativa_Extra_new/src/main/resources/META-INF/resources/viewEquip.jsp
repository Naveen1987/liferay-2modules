<%@page import="com.roomservice.service.BookedEquipmentLocalServiceUtil"%>
<%@page import="com.roomservice.service.EquipmentLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp" %>
<%@page import="com.roomservice.model.*" %>
<%
String courseId=request.getParameter("courseId");
List<Equipment> equipList = EquipmentLocalServiceUtil.getEquipments(-1, -1);
List<BookedEquipment> bkequipList = BookedEquipmentLocalServiceUtil.getBookedEquipments(-1, -1);
%>


<style>
.btn-submit{
background-color: #008CBA;
color:white
}
.btn-submit:hover{
background-color:#024961;
color:white;
}

</style>
<script>
	function bookRoomDiv() {
		document.getElementById('bookRoomDiv').style.display = "block";
		//document.getElementById('equipDiv').style.display = "none";
	}

	function equipDiv() {
		document.getElementById('bookRoomDiv').style.display = "none";
		//document.getElementById('equipDiv').style.display = "block";
	}
</script>

<portlet:actionURL name="BookedEquipmentSubmit" var="BookedEquipmentSubmit">
<portlet:param name="mvcPath" value="/RoomAllocation.jsp" />
</portlet:actionURL>

<div class="container-fluid-1280">
<div class="row">
<div class="col-xs-12 ">
<div class="pull-right">
<table>
<tr>
<td><span class="btn btn-submit" id="btn-submit" onclick="bookRoomDiv()">Book Equipment</span></td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="btn btn-submit" id="btn-submit"  onclick="">View Allocated Equipment</span></td>
</tr>
<tr>
<td><br/></td>
</tr>
</table>
</div>
</div>

</div>
<div id="bookRoomDiv"  style="display: none;" class="row">
<div class="col-xs-12">
	<form action="<%=BookedEquipmentSubmit%>" method="Post" name="myForm" onsubmit="return validateForm()" >
			<%for(Equipment eq : equipList){ 
			int count=0;
			for(BookedEquipment bk: bkequipList){
				if(eq.getEquip_id()==bk.getEquip_id()){
					count = count+bk.getEquip_quantity();
				}
			}
			if(eq.getEquip_quantity()>count){
			%>
			<div class="form-group">
				<!-- <label for="course_Id">Course Id:</label>  --><input type="hidden"
					class="form-control" id="course_Id" value="<%=courseId%>" name="<portlet:namespace/>course_Id" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="equipmentName"><%=eq.getEquipment_name()%></br><font color="red">available:<%=eq.getEquip_quantity()-count%></font></label> <input type="text"
					class="form-control" id="equipmentName<%=eq.getEquipment_name()%>" placeholder="Number of <%=eq.getEquipment_name()%> Required"
					name="<portlet:namespace/><%=eq.getEquipment_name()%>">
			</div>
<%} }%>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
<br/>
</div>

</div>
</div>


