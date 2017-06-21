<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/init.jsp" %>
<%--<%=request.getParameter("courseId") %> --%>
<script src="<%= request.getContextPath()%>/css/bootstrap-spinner.js"></script>
<liferay-ui:success key="success" message="New Applicant Inserted successfully!"/>
<portlet:actionURL name="addApplicant" var="addApplicant">
<portlet:param name="mvcPath" value="/newApplicant.jsp"/> 
</portlet:actionURL>
<aui:form action="${addApplicant}"  method="post" id="<portlet:namespace/>fm" name="fm">
<input type="hidden" name="<portlet:namespace/>courseId" class="form-control" value="<%=request.getParameter("courseId") %>"/>
<div class="container-fluid-1280">
<div class="row">
<div class="col-md-12 text-center">
<h1>New Applicant</h1>
<hr/>
</div>
</div>
<div class="row">
<div class="col-md-12">
<center>
<table width="70%">
<tbody>
<tr>
<td>Applicant Name<span style="font-size:20px;color:red"><b>*</b></span></td><td><input type="text" id="Applicant_Name" name="<portlet:namespace/>Applicant_Name" placeholder="Enter Name" value="<%=user.getFullName()%>" class="form-control"  readonly="readonly" style="color:black"/>
<span id="_Applicant_Name" style="color:red; display:none">Please Enter Name</span>
</td>
</tr>
<tr>
<td><br/></td>
</tr>
<tr>
<td>Email<span style="font-size:20px;color:red"><b>*</b></span></td><td><input  type="email" name="<portlet:namespace/>email" class="form-control" placeholder="Enter Email"  id="email"/>
<span id="_email" style="color:red; display:none">Please Enter Email</span>
</td>
</tr>
<tr>
<td><br/></td>
</tr>
<tr>
<td>Phone<span style="font-size:20px;color:red"><b>*</b></span></td><td><input  type="number" name="<portlet:namespace/>phone"  class="form-control input-number" placeholder="Enter Phone" value="" id="phone">
<span id="_phone" style="color:red; display:none">Please Enter Phone</span>
</td>
</tr>
<tr>
<td><br/></td>
</tr>
<tr>
<td></td><td style="text-align:right"><span id="submit" class="btn btn-success" onClick="showAddNoteDialog()" style="width:100px">   Submit   </span>     
</td>
</tr>
</tbody>
</table>
 
</center>
</div>
</div>
</div>

</aui:form>

<script type="text/javascript">
//Now Validation
</script>

<div class="yui3-skin-sam">
  <div id="modal"></div>
</div> 

<script type="text/javascript">
 <%--  $("#reset").click(function(){
	 
		 $("#_Applicant_Name").hide();
		 $("#_email").hide();
		 $("#_phone").hide();
		 $("#<portlet:namespace/>fm").closest('form').find("input[type=text] ").val("");
		 $("#<portlet:namespace/>fm").closest('form').find("input[type=email]").val("");
		 $("#Applicant_Name").val("<%=user.getFullName()%>");
		
});   --%>

//Now Validation
function showAddNoteDialog(){
   YUI().use('aui-modal', function(Y) {
       var modal = new Y.Modal(
         {
           bodyContent:  '<label for="feedback/suggestions" ><liferay-ui:message key="Are you want to submit form"/></label>',
           centered: true,
           headerContent: '<h3><label for="formsofinteraction"><liferay-ui:message key="Confirmation Box"/></label></h3>',
           modal: true,
           resizable:false,
           render: '#modal',
           zIndex: 1100,
           width: 500,
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
                      var inputs = document.getElementsByTagName('input');
                      var flag=true;
                      for(var i = 0; i < inputs.length; i++) {    
                    	 
                    	  if(inputs[i].type.toLowerCase() == 'text') {
                        	  if(inputs[i].value){
                        		  
                        		  if(inputs[i].name=="<portlet:namespace/>Applicant_Name")
                            	  {
                        			 
                                	  $("#_Applicant_Name").hide();
                                	 
                                  }
                        	  }
                    	  }
                    	  if(inputs[i].type.toLowerCase() == 'text') {
                        	  if(inputs[i].value==''){
                              if(inputs[i].name=="<portlet:namespace/>Applicant_Name")
                        	  {
                            	  $("#_Applicant_Name").show();
                            	  flag=false;
                            	  //alert(inputs[i].name);
                              }                                                     
                           	}
                          }

                    	  
                    	  if(inputs[i].type.toLowerCase() == 'email'){
                    		  if(inputs[i].value==''){
                    		  if(inputs[i].name=="<portlet:namespace/>email")
                        	  {
                            	  $("#_email").show();
                            	  flag=false;
                            	//alert(inputs[i].name);
                              }
                    		}
                    	  }
                    	  
                    	  if(inputs[i].type.toLowerCase() == 'email'){
                    		  if(inputs[i].value){
                    		  if(inputs[i].name=="<portlet:namespace/>email")
                        	  {
                    			  if( !isValidEmailAddress(inputs[i].value ) ){
                    				  //$("#_email").replaceWith("Please Enter Valid Email Address");
                    				 $("#_email").text("Please Enter Valid Email Address");
                    				  $("#_email").show();
                                	  flag=false;
                    			  }
                    			  else{
                    				  $("#_email").hide();
                    			  }
                            	 
                              }
                    		}
                    	  }
                    	  
                    	  if(inputs[i].type.toLowerCase() == 'number'){
                    		  if(inputs[i].value==''){
                    			  if(inputs[i].name=="<portlet:namespace/>phone")
                            	  {
                                	  $("#_phone").show();
                                	  flag=false;
                                	//alert(inputs[i].name);
                                  }
                    		}
                    	  }
                    	  if(inputs[i].type.toLowerCase() == 'number'){
                    		  if(inputs[i].value){
                    			  if(inputs[i].name=="<portlet:namespace/>phone")
                            	  {
                    				  if( !isValidPhone(inputs[i].value ) ){
                        				  //$("#_email").replaceWith("Please Enter Valid Email Address");
                        				 $("#_phone").text("Please Enter Valid Phone Number");
                        				 $("#_phone").show();
                                    	  flag=false;
                        			  }
                        			  else{
                        				  $("#_phone").hide();
                        			  }
                                	 
                                	
                                  }
                    			  
                    		}
                    	  }
                    	  
                         
                          //outer IF
                      }
						
                     if(flag==true){
                    	     $("#_Applicant_Name").hide();
                    		 $("#_email").hide();
                    		 $("#_phone").hide();
                    	//document.getElementById("<portlet:namespace/>fm").submit();
                    	//Ajax Request
						formSubmiting();
			          	//Ajax Request
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

function isValidEmailAddress(emailAddress) {
   // var pattern = /^([a-z\d!#$%&'*+\-\/=?^_`{|}~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]+(\.[a-z\d!#$%&'*+\-\/=?^_`{|}~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]+)*|"((([ \t]*\r\n)?[ \t]+)?([\x01-\x08\x0b\x0c\x0e-\x1f\x7f\x21\x23-\x5b\x5d-\x7e\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|\\[\x01-\x09\x0b\x0c\x0d-\x7f\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))*(([ \t]*\r\n)?[ \t]+)?")@(([a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|[a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF][a-z\d\-._~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]*[a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])\.)+([a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|[a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF][a-z\d\-._~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]*[a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])\.?$/i;
    var pattern=/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return pattern.test(emailAddress);
};
function isValidPhone(phone) {
    var pattern =  /^\d{10}$/;
    return pattern.test(phone);
};
function formSubmiting(){
	AUI().use('aui-base','aui-io-request', function(A){
		//aui ajax call to get updated content
		A.io.request('<%=addApplicant%>',{
  		dataType: 'json',
  		method: 'POST',
  		form: {id: '<portlet:namespace/>fm'},
  		on: {
   			 success: function() {
   			  Liferay.Util.getOpener().closePopup('<portlet:namespace/>New_Applicant');
    		}
  		}
		});
		});
}

</script>
<%--
In java Script phone validation
var pattern = /^\+?([0-9]{2})\)?[-. ]?([0-9]{4})[-. ]?([0-9]{4})$/;
+XX-XXXX-XXXX +XX.XXXX.XXXX +XX XXXX XXXX
var pattern = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
XXX-XXX-XXXX XXX.XXX.XXXX XXX XXX XXXX
--%>

    