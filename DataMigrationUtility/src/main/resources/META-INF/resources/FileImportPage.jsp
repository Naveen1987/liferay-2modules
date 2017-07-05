<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.repository.model.Folder"%>
<%@page import="com.daffo.DataMigrationUtility.portlet.FolderAndDocType_Service"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/init.jsp" %>
<portlet:actionURL name="fileUploadAction" var="formSubmit">
<portlet:param name="mvcPath" value="/view.jsp"/> 
</portlet:actionURL>
<%FolderAndDocType_Service fdt=new FolderAndDocType_Service(); %>
<div class="container-fluid-1280">
<div class="row">
<div class="col-xs-12">
<aui:form action="${formSubmit}" enctype="multipart/form-data" method="post" id="fm" name="fm">
<table class="table">
<tbody>
<tr>
<td>Select Folder</td>
<td>
<%
List<Folder> folders=fdt.getAllFolder(themeDisplay);
%>
<select id="sel-folder" class="form-control">
<option value="-1">- Select Folder-</option>
<%
for(Folder folder:folders){
%>
<option value="<%=folder.getFolderId()+"|"+folder.getName()%>"><%=folder.getName()%></option>	
<%
}
%>
</select>
</td>
</tr>
<tr>
<td>Document Type</td>
<td>
<input id="txt-doc" value="" readonly="readonly" class="form-control"/>
</td>
</tr>
<tr>
<td>Select File</td>
<td><input type="file" name="" id="txt-file" class="form-control"/></td>
</tr>
<tr>
<td colspan="2"><span class="btn btn-warning pull-right">Upload</span></td>
</tr>
</tbody>
</table>
</aui:form>
</div>
</div>
</div>
<portlet:resourceURL var="fetchDocumentType" id="fetchDocumentType">
</portlet:resourceURL>

<script>
$("#sel-folder").change(function(){
	var item=$(this).val();
	if(item==-1){
		alert('Please Select valid value');
		return;
	}
	alert(item);
	AUI().use('aui-base','aui-io-request', function(A){
		//aui ajax call to get updated content
		A.io.request('<%=fetchDocumentType%>',{
  		dataType: 'json',
  		method: 'POST',
  		data:{'<portlet:namespace/>FolderName':item},
  		on: {
   			 success: function() {
   			var data=this.get('responseData');
   			
   			location.reload();
    		}
  		}
		});
		});
});
</script>
