<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/init.jsp" %>
<liferay-ui:success key="success" message="New Equipment Inserted successfully!"/>

<portlet:actionURL name="EquipmentSubmit" var="EquipmentSubmit">
<portlet:param name="mvcPath" value="/NewEquip.jsp" />
</portlet:actionURL>

<aui:form action="${EquipmentSubmit}" id="fm" name="fm">
	<div class="container-fluid-1280">
	<div class="row">
	<div class="col-xs-12" style="margin-left:15px">
	<table class="table table-hover table-bordered results" style="width:100%">
<tbody>
<tr>
<td><b>Equipment Name<span style="color:red">*</span></b></td><td>
<input type="text" class="form-control" id="txt-equ" placeholder="Equipment Name"
					name="<portlet:namespace/>equipment_name">
<span id="_txt-equ" style="color:red; display:none">Please Enter Equipment Name</span>
</td>
</tr>
<tr>
<td><b>Quantity<span style="color:red">*</span></b></td><td>
<input type="number" value="0"
					class="form-control" min="0" id="txt-quan" placeholder="Quantity"
					name="<portlet:namespace/>quantity">
<span id="_txt-quan" style="color:red; display:none">Please Enter Equipment Quantity</span>
</td>
</tr>
<tr>
<td><b>Description<span style="color:red">*</span></b></td><td>
<textarea class="form-control" id="txt-des" placeholder="Equipment Description"
					name="<portlet:namespace/>equipDesc"></textarea>
<span id="_txt-des"  style="color:red; display:none">Please Enter Equipment Description</span>
</td>
</tr>
<tr>
<td colspan="2" style="text-align:right"><span id="submit" class="btn btn-success" onClick="showAddNoteDialog()" style="width:100px">   Submit   </span>     
    <span id="reset" class="btn btn-warning" style="width:100px">   Reset   </span>
</td>
</tr>
</tbody>
</table>
</div>
</div>
</aui:form>
	
	<script type="text/javascript">
$("#reset").click(function(){
	$("#_txt-equ").hide();
	$("#_txt-des").hide();
	$("#_txt-quan").hide();
	$("#txt-equ").val('');
	$("#txt-des").val('');
	$("#txt-quan").val('0');
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
           width: 300,
           height:200
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
                      var txtarea= document.getElementsByTagName('textarea');
                      for(var i = 0; i < txtarea.length; i++) {
                    	  if(txtarea[i].value==''){
                			  if(txtarea[i].name=="<portlet:namespace/>equipDesc")
                        	  {
                				  flag=false;
                				  $("#_txt-des").show();
                				
                        	  }
               
                		  }
                    	  if(txtarea[i].value){
                			  if(txtarea[i].name=="<portlet:namespace/>equipDesc")
                        	  {
                				  $("#_txt-des").hide();
                				 
                        	  }
               
                		  }
                      }
                      var inputs = document.getElementsByTagName('input');
                      for(var i = 0; i < inputs.length; i++) {
                    	  if(inputs[i].type.toLowerCase() == 'text') {
                    		  if(inputs[i].value==''){
                    			  if(inputs[i].name=="<portlet:namespace/>equipment_name")
                            	  {
                    				  flag=false;
                    				  $("#_txt-equ").show();
                    				
                            	  }
                   
                    		  }
                    		  if(inputs[i].value){
                    			  if(inputs[i].name=="<portlet:namespace/>equipment_name")
                            	  {
                    				  $("#_txt-equ").hide();
                    				 
                            	  }
                   
                    		  }
                    	  }        
                    	  if(inputs[i].type.toLowerCase() == 'number') {
                    		  if(inputs[i].value==''){
                    			  if(inputs[i].name=="<portlet:namespace/>quantity")
                            	  {
                    				  flag=false;
                    				  $("#_txt-quan").show();
                    				
                            	  }
                   
                    		  }
                    		  if(inputs[i].value){
                    			  if(inputs[i].name=="<portlet:namespace/>quantity")
                            	  {
                    				  $("#_txt-quan").hide();
                    				 
                            	  }
                   
                    		  }
                    	  }        
						} 
                      if($("#txt-quan").val()<1){
                    	  $("#_txt-quan").text("Quantity must grater then 0")
                    	  $("#_txt-quan").show();
                    	  flag=false;
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
