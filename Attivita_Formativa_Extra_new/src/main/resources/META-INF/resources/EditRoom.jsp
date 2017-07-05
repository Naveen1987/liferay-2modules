<%@page import="com.daffo.suilupposervice.model.suiluppo_room"%>
<%@page import="com.daffo.suilupposervice.service.suiluppo_roomLocalServiceUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/init.jsp" %>
<%
suiluppo_room sr=suiluppo_roomLocalServiceUtil.getsuiluppo_room(new Long(request.getParameter("roomId")).longValue());

%>
<liferay-ui:success key="success" message="Room Updated successfully!"/>
<portlet:actionURL name="editRoom" var="formSubmit">
<portlet:param name="mvcPath" value="/EditRoom.jsp"/> 
</portlet:actionURL>
<aui:form action="${formSubmit}" method="post" id="fm" name="fm">
<div class="container-fluid-1280">
<div class="row" style="margin-left:15px">
<div class="col-md-12">
<input type="hidden" name="<portlet:namespace/>roomId" value="<%=request.getParameter("roomId") %>"/>
<table class="table table-hover table-bordered results" style="width:100%">
<tbody>
<tr>
<td><b>Room Name<span style="color:red">*</span></b></td><td>
<input name="<portlet:namespace/>txt-room" id="txt-room" value="<%=sr.getRoom_name() %>" class="form-control"/>
<span id="_txt-room" style="color:red; display:none">Please Enter Room Name</span>
</td>
</tr>
<tr>
<td><b>Description<!-- <span style="color:red">*</span> --></b></td><td>
<textarea name="<portlet:namespace/>txt-des" id="txt-des"  class="form-control">
<%=sr.getRoom_description() %>
</textarea>
<span id="_txt-des"  style="color:red; display:none">Please Enter Room Description</span>
</td>
</tr>
<tr>
<td colspan="2" style="text-align:right"><span id="submit" class="btn btn-success" onClick="showAddNoteDialog()" style="width:100px">   Update   </span>     
  
</td>
</tr>
</tbody>
</table>
</div>
</div>
</div>
</aui:form>

<script type="text/javascript">
$("#reset").click(function(){
	$("#_txt-room").hide();
	$("#_txt-des").hide();
	$("#txt-room").val('');
	$("#txt-des").val('');
});  

//Now Validation
function showAddNoteDialog(){
   YUI().use('aui-modal', function(Y) {
       var modal = new Y.Modal(
         {
           bodyContent: '<label for="feedback/suggestions" ><liferay-ui:message key="Are you want to submit form"/></label>',
           centered: true,
           headerContent: '<h3><label for="formsofinteraction"><liferay-ui:message key="Confirmation Box"/></label></h3>',
           modal: true,
           resizable:false,
           render: '#modal',
           zIndex: 1100,
           width: 500
         }
       ).render();
        modal.addToolbar(
              [
                {
                  label: '<liferay-ui:message key="Cancel"/>',
                  on: {
                    click: function() {
                     modal.hide();
                    }
                  }
                },
                {
                   label: '<liferay-ui:message key="Submit"/>',
                   on: {
                     click: function() {
                    	 //Start Of On Method
                      modal.hide();
                      var flag=true;
                      var inputs = document.getElementsByTagName('input');
                      for(var i = 0; i < inputs.length; i++) {
                    	  if(inputs[i].type.toLowerCase() == 'text') {
                    		  if(inputs[i].value==''){
                    			  if(inputs[i].name=="<portlet:namespace/>txt-room")
                            	  {
                    				  flag=false;
                    				  $("#_txt-room").show();
                    				
                            	  }
                   
                    		  }
                    		  if(inputs[i].value){
                    			  if(inputs[i].name=="<portlet:namespace/>txt-room")
                            	  {
                    				  $("#_txt-room").hide();
                    				 
                            	  }
                   
                    		  }
                    	  }

						} 
                      if(flag==true){
                		  document.getElementById("<portlet:namespace/>fm").submit();
                	  }
                	
                      //End OF On method
                     }
                   }
                 },
                ]
       );
     }
   );
    }

</script>