<%@page import="com.roomservice.service.BookedEquipmentLocalServiceUtil"%>
<%@page import="com.roomservice.service.EquipmentLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp" %>
<%@page import="com.roomservice.model.*" %>
<%
String courseId=request.getParameter("courseId");
%>
<%-- <%=courseId %> --%>
<%
List<Equipment> equipList = EquipmentLocalServiceUtil.getEquipments(-1, -1);
List<BookedEquipment> bkequipList = BookedEquipmentLocalServiceUtil.getBookedEquipments(-1, -1);
%>
<style>
* {
	box-sizing: border-box;
}
#myInput {
	background-image: url('/images/searchicon.png');
	background-position: 10px 10px;
	background-repeat: no-repeat;
	width: 100%;
	font-size: 16px;
	padding: 12px 20px 12px 40px;
	border: 1px solid #ddd;
	margin-bottom: 12px;
}

#myTable {
	border-collapse: collapse;
	width: 100%;
	border: 1px solid #ddd;
	font-size: 18px;
}

#myTable th, #myTable td {
	text-align: left;
	padding: 12px;
}

#myTable tr {
	border-bottom: 1px solid #ddd;
}

#myTable tr.header, #myTable tr:hover {
	background-color: #f1f1f1;
}
</style>

<style>
.btn-group button {
	background-color: #008CBA; /* Green background */
	border: 1px solid #008CBA; /* Green border */
	color: white; /* White text */
	padding: 10px 24px; /* Some padding */
	cursor: pointer; /* Pointer/hand icon */
	float: left; /* Float the buttons side by side */
}

/* Clear floats (clearfix hack) */
.btn-group:after {
	content: "";
	clear: both;
	display: table;
}

.btn-group button:not (:last-child ) {
	border-right: none; /* Prevent double borders */
}

/* Add a background color on hover */
.btn-group button:hover {
	background-color: #2e6da4;
}
</style>
<head>
<script>
	function bookRoomDiv() {
		document.getElementById('bookRoomDiv').style.display = "block";
		document.getElementById('equipDiv').style.display = "none";
	}

	function equipDiv() {
		document.getElementById('bookRoomDiv').style.display = "none";
		document.getElementById('equipDiv').style.display = "block";
	}
</script>
</head>
<div class="btn-group" style="width: 100%">
		<button  style="width: 50%"  onclick="bookRoomDiv()">Book Equipment</button>
				<button  style="width: 50%"  onclick="equipDiv()">New Equipment Entry</button>
	</div>
	</br></br>
<portlet:actionURL name="BookedEquipmentSubmit" var="BookedEquipmentSubmit">
<portlet:param name="mvcPath" value="/RoomAllocation.jsp" />
</portlet:actionURL>
<div id="bookRoomDiv" style="display: none;" class="answer_list">
<div class="container">
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
				<label for="equipmentName"><%=eq.getEquipment_name()%></br><font color="red">available:<%=eq.getEquip_quantity()-count%></font></label> <input type="text"
					class="form-control" id="equipmentName<%=eq.getEquipment_name()%>" placeholder="Number of <%=eq.getEquipment_name()%> Required"
					name="<portlet:namespace/><%=eq.getEquipment_name()%>">
			</div>
<%} }%>
			<div class="form-group">
				<label for="course_Id">Course Id:</label> <input type="text"
					class="form-control" id="course_Id" value="<%=courseId%>" name="<portlet:namespace/>course_Id" readonly="readonly">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
	</div>	

<portlet:actionURL name="EquipmentSubmit" var="EquipmentSubmit">
<portlet:param name="mvcPath" value="/RoomAllocation.jsp" />
</portlet:actionURL>
<div id="equipDiv" style="display: none;" class="answer_list">
	<div class="container">
		<form action="<%=EquipmentSubmit%>" method="Post">
		<input type="hidden" name="<portlet:namespace/>courseId" value="<%=courseId%>"/>
			<div class="form-group">
				<label for="EquipmentName">Equipment Name:</label> <input type="text"
					class="form-control" id="Equipment Name" placeholder="Equipment Name"
					name="<portlet:namespace/>equipment_name">
			</div>
			
			<div class="form-group">
				<label for="quantity">Quantity:</label> <input type="text"
					class="form-control" id="quantity" placeholder="Quantity"
					name="<portlet:namespace/>quantity">
			</div>
			
			<div class="form-group">
				<label for="equipDesc">Equipment Description:</label> <input type="text"
					class="form-control" id="equipDesc" placeholder="Equipment Description"
					name="<portlet:namespace/>equipDesc">
			</div>	
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</div>