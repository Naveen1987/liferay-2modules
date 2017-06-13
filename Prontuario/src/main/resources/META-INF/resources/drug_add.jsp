<%@page import="com.daffo.prontuario_drugservice.service.prontuario_drugLocalServiceUtil"%>
<%@ include file="/init.jsp" %>
<%--Message area --%>
<liferay-ui:success key="success" message="Successfully Submitted"/>

<portlet:actionURL name="formSubmit_drug" var="formSubmit">
<portlet:param name="mvcPath" value="/drug_add.jsp"/> 
</portlet:actionURL>
<aui:form name="fm" id="fm" action="${formSubmit}">  
<div class="container-fluid-1280">
<!-- First Row --> 
<div class="row">
<div class="col-md-12 ">
<br/>
<center>
<table width="50%" cellpadding="5">
<thead><tr><td colspan="2" style="Background-color:#2C95DD;font-size:20px; color:white">
<center>
<b>Drug</b>
</center>
</td></tr></thead>
<tbody>
<tr>
<td>Gruppo</td><td><select class="form-control" required="required" name="<portlet:namespace/>Gruppo">
<option value="-1">-Select Item-</option>
<option value="ONE">ONE</option>
<option value="TWO">TWO</option>
<option value="THREE">THREE</option>
<option value="FOUR">FOUR</option>
</select></td>
</tr>
<tr>
<td>SottoGruppo</td><td><select class="form-control" required="required"  name="<portlet:namespace/>SottoGruppo">
<option value="-1">-Select Item-</option>
<option value="ONE">ONE</option>
<option value="TWO">TWO</option>
<option value="THREE">THREE</option>
<option value="FOUR">FOUR</option>
</select></td>
</tr>
<tr>
<td>Codice </td><td><input class="form-control required" style="background-color: #eee" required="required" name="<portlet:namespace/>Codice" ></td>
</tr>
<tr>
<td>Principio Attivo </td><td><input class="form-control" style="background-color: #eee" required="required" name="<portlet:namespace/>Principio_Attivo" ></td>
</tr>
<tr>
<td>Nome Commerciale </td><td><input class="form-control" style="background-color: #eee" required="required" name="<portlet:namespace/>Nome_Commerciale" ></td>
</tr>
<tr>
<td>
<br/>
 <aui:button  style="width:200px;background-color:#e60000;color:white; height:40px" value="Reset" onclick="this.form.reset()" />
 </td>
 <td>
 <br/>
 <aui:button value="Save" key="save"  style="width:200px;background-color:#006622;color:white; height:40px" onClick="javascript:showAddNoteDialog();"/>
</td>
</tr>
</tbody>
</table>
</center>
</div> 
</div>
</div>
</aui:form>
<div class="yui3-skin-sam">
  <div id="modal"></div>
</div> 
<script>

function showAddNoteDialog(){

  
   YUI().use('aui-modal', function(Y) {
       var modal = new Y.Modal(
         {
           bodyContent: '<label for="feedback/suggestions" ><liferay-ui:message key="Are you want to submit form"/></label>',
           centered: true,
           headerContent: '<h3><label for="formsofinteraction"><liferay-ui:message key="Confirmation Box"/></label></h3>',
           modal: true,
           render: '#modal',
           width:300,
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
                      modal.hide();
                      var flag=true;
                      var all_select = document.getElementsByTagName("select");
                      for (i = 0; i < all_select.length; i++) {
                    	  if(all_select[i].value=='-1')
                    		  {
                    		  all_select[i].style.backgroundColor = "yellow";
                    		  flag=false;
                    		  }
                      }
                      var inputs = document.getElementsByTagName('input');
                      for(var i = 0; i < inputs.length; i++) {
                          if(inputs[i].type.toLowerCase() == 'text') {
                        	  if(inputs[i].value==''){
                        		  inputs[i].style.backgroundColor = "yellow";
                            	  inputs[i].placeholder="Input me";
                            	  inputs[i].focus();
                            	  flag=false;
                              /*
                              if(inputs[i].name=="<portlet:namespace/>Codice")
                        	  {
                            	  inputs[i].style.backgroundColor = "red";
                            	  inputs[i].placeholder="Input me";
                            	  inputs[i].focus();
                            	  flag=false;
                            	//  alert(inputs[i].value);
                              }
                              if(inputs[i].name=="<portlet:namespace/>Principio_Attivo")
                        	  {
                            	  inputs[i].style.backgroundColor = "red";
                            	  inputs[i].focus();
                            	  inputs[i].placeholder="Input me";
                            	  flag=false;
                            	//  alert(inputs[i].value);
                              }
                              if(inputs[i].name=="<portlet:namespace/>Nome_Commerciale")
                        	  {
                            	  inputs[i].style.backgroundColor = "red";
                            	  inputs[i].focus();
                            	  inputs[i].placeholder="Input me";
                            	  flag=false;
                            	//  alert(inputs[i].value);
                              }
                              
                              */
                        	}
                          }
                          
                      }
						
                      if(flag==true){
                    	document.getElementById("<portlet:namespace/>fm").submit();
                    	//Liferay.Util.getOpener().<portlet:namespace/>windowRefresh();
						}
                     }
                   }
                 },
                ]
       );
     }
   );
 }
</script>
