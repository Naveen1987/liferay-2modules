<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.daffo.Attivita_Formativa_3.portlet.CourseStatusChk"%>
<%@page import="com.daffo.suilupposervice.model.suiluppo_room_allocation"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.daffo.suilupposervice.service.suiluppo_equipmentLocalServiceUtil"%>
<%@page import="com.daffo.suilupposervice.model.suiluppo_equipment"%>
<%@page import="com.daffo.suilupposervice.service.suiluppo_roomLocalServiceUtil"%>
<%@page import="com.daffo.suilupposervice.model.suiluppo_room"%>
<%@page import="com.daffo.suilupposervice.service.suiluppo_room_allocationLocalServiceUtil"%>
<%@ include file="/init.jsp" %>

    <style>
    .rowdiv {
        border: 1px solid;
        padding:1 1 1 1;
        border-radius: 10px;
      }
    .cliente {
    text-align:center;
 
    border: #cdcdcd medium solid;
    border-radius: 10px;
    -moz-border-radius: 10px;
    -webkit-border-radius: 10px;
    cursor:pointer;
}
    </style>
<%! private Log log=LogFactoryUtil.getLog("RoomAllocation"); %>
<%
CourseStatusChk  chk=new CourseStatusChk();
DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(suiluppo_room_allocation.class);
userQuery.add(RestrictionsFactoryUtil.eq("room_allocat_status", "Booked"));
List<suiluppo_room_allocation> sur=suiluppo_room_allocationLocalServiceUtil.dynamicQuery(userQuery);
if(sur.size()>0){
	for(suiluppo_room_allocation st:sur){
	log.info(st);
	//check valid course
	if(chk.checkValid(st.getCourse_id())){
		log.info("Finding Blank Rooms......");
		if(chk.UpdateRoomAllocation(st.getRoom_allocat_id())){
			log.info("Room Updated");
		}
		
	}else{
		log.warn("room will remain booked");
	}
	}
}
else{
	log.info("No Room Booked");
}
%>
<%
List<suiluppo_room> sr=suiluppo_roomLocalServiceUtil.getsuiluppo_rooms(0, suiluppo_roomLocalServiceUtil.getsuiluppo_roomsCount());
%>
<%-- <%=request.getParameter("courseId")%> --%>
<div class="container-fluid-1280">
<div class="row  rowdiv">
<div  class="row">
<div class="col-xs-12">
<h1 class="pull-left">Rooms Details</h1>
</div>
</div>
<br/>
<div class="row">
<%
int count=0;
for(suiluppo_room st:sr){
	if(count%12==0&&count!=0){
		%>
		</div>
		<br/>
		<div class="row">
		
		<%
	}
	if(chk.checkAlreadBooked(new Long(request.getParameter("courseId")).longValue(),st.getRoomID())){
		%>
		<div id='<%="div_"+st.getRoomID()%>' class="col-xs-1" style="background-color:white">
		<div class="cliente" onClick="getRoomBooked('<%=st.getRoomID()%>')"><%=st.getRoom_name()%></div>
		</div>
		<%
		}
	else if(chk.checkAlreadBooked(st.getRoomID())){
		%>
		<div id='<%="div_"+st.getRoomID()%>' class="col-xs-1" style="background-color:red">
		<div class="cliente" onClick="getRoomBooked('<%=st.getRoomID()%>')"><%=st.getRoom_name()%></div>
		</div>
		<%	
	} 
	else{
		%>
		<div id='<%="div_"+st.getRoomID()%>' class="col-xs-1" style="background-color:green">
		<div class="cliente" onClick="getRoomBookInfo('<%=st.getRoomID()%>')"><%=st.getRoom_name()%></div>
		</div>
		<%	
}
	count++;
}

%>
</div>
<br/>
</div>
<div  class="row">
<div class="col-xs-12">
<h1>Equipment Details</h1>
<div class="row">
<div class="col-xs-12">
<table  class="table table-hover table-bordered results">
<thead>
<tr  class="bg-primary">
<td><b>Name</b></td>
<td><b>Required</b></td>
</tr>
</thead>
<tbody>
<%
List<suiluppo_equipment> su=suiluppo_equipmentLocalServiceUtil.getsuiluppo_equipments(0, suiluppo_equipmentLocalServiceUtil.getsuiluppo_equipmentsCount());
int counte=0;
for(suiluppo_equipment sp:su){
	++counte;
%>
<tr>
	<td><%=sp.getEquip_name()%></td>
	<td><input type="hidden" id="<%="hid_"+(counte)%>" value="<%=sp.getEquip_id() %>"><input id="<%="txt_"+(counte)%>" type="number" value="0" class="form-control"/></td>
</tr>
<%
}
%>
</tbody>
</table>
</div>
</div>
<%--This is end --%>
</div>
</div>
</div>
<portlet:resourceURL var="updateRoomBookInfo" id="updateRoomBookInfo">
</portlet:resourceURL>
<script>
function getRoomBooked(roomId){
	alert('Sorry! This Room already Booked');
	var portletURL = Liferay.PortletURL.createRenderURL();
	 	portletURL.setWindowState('<%=LiferayWindowState.POP_UP.toString() %>');
	    portletURL.setParameter('roomId', roomId);    
	    portletURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
	    portletURL.setParameter('mvcPath', '/MessageBox.jsp');
	    YUI().ready(function(A) {
	        YUI().use('aui-base','liferay-util-window', function(A) {
	            Liferay.Util.Window.getWindow({
	                title :'Room Allocation',
	                uri: portletURL,
	                id:'<portlet:namespace/>RoomAllowcation',
	                dialog: {
	                	centered: true,
	                	constrain2view: true,
	                    destroyOnHide: true,
	                    resizable: false,
	                    cache: false,
	                    modal: true,
	                    width: 500
	                }
	            }).after('destroy', function(event) {
	            	//It will refresh
	            	location.reload();
	            });
	        });
	    });
	return;
}
function getRoomBookInfo(roomId){
	var div_id="#div_"+roomId;
	var count=<%=counte%>
	var dataTxt="";
	for(i=1;i<=count;i++){
		var hid="#hid_"+i;
		var txt="#txt_"+i;
		dataTxt+="["+$(hid).val()+"="+$(txt).val()+"]";
		//alert(dataTxt);
	} 
	if(dataTxt==""){
		alert('Please Fill equipments');
		return;
	}
	//alert(count);
	  var courseId='<%=request.getParameter("courseId")%>';
	AUI().use('aui-base','aui-io-request', function(A){
		//aui ajax call to get updated content
		A.io.request('<%=updateRoomBookInfo%>',{
  		dataType: 'json',
  		method: 'POST',
  		data:{'<portlet:namespace/>roomID':roomId,'<portlet:namespace/>courseId':courseId,'<portlet:namespace/>DataValue':dataTxt},
  		on: {
   			 success: function() {
   			var data=this.get('responseData');
   			if(data!=null){
   				if(data.flag=='nv'){
   					alert('Course Is not valid');
   				}else if(data.flag=='src'){
   					alert('Room booked on same course');
   				}else if(data.flag=='oc'){
   					alert('Room booked on Other course');
   				}else if(data.flag=='orc'){
   					alert('Some Other room book for this Course');
   				}else if(data.flag=='suc'){
   					alert('Successfully Booked');
   				   $(div_id).css("background", "red");
   				}
   			}
   			
    		}
  		}
		});
		});  
}

</script>