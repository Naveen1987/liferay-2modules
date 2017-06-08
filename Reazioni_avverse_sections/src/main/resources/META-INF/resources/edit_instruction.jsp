<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="istruzioni_per_la_compilazioneservice.model.istruzioni_per_la_compilazione"%>
<%@page import="istruzioni_per_la_compilazioneservice.model.istruzioni_per_la_compilazione_childModel"%>
<%@page import="istruzioni_per_la_compilazioneservice.model.istruzioni_per_la_compilazione_child"%>
<%@page import="java.util.List"%>
<%@page import="istruzioni_per_la_compilazioneservice.service.istruzioni_per_la_compilazione_childLocalServiceUtil"%>
<%@page import="istruzioni_per_la_compilazioneservice.service.istruzioni_per_la_compilazioneLocalServiceUtil"%>
<%@ include file="/init.jsp" %>

<style>
.table-remove {
  color: #700;
  cursor: pointer;
  
  &:hover {
    color: #f00;
  }
}
}
</style>

<liferay-ui:success key="success" message="Record Updated successfully!"/>
<div class="container" style="margin-left:20px;margin-right:20px;">
<div class="row">
<br/>
<div class="col-md-12">
<table width="100%">
<tr>
<td><input class="txt-maintitle form-control"  name="<portlet:namespace/>maintitle" value="<%=istruzioni_per_la_compilazioneLocalServiceUtil.getistruzioni_per_la_compilazione(1).getMainTitle()%>"></input></td>
<td width="45px">
<span class="table-maintitle btn btn-primary" style="color:white">Edit</span>
</tr>
</table> 
</div>
</div>

<div class="row">
<br/>
<div class="col-md-12">
<table width="100%">
<tr>
<td><input class="txt-title form-control" name="<portlet:namespace/>maintitle" value="<%=istruzioni_per_la_compilazioneLocalServiceUtil.getistruzioni_per_la_compilazione(1).getTilte()%>"></input></td>
<td width="45px">
<span class="table-title btn btn-primary" style="color:white">Edit</span>
</td>
</tr>
</table> 
</div>
</div>

<div class="row">
<br/>
<div class="col-md-12">
<table width="100%">
<tr>
<td><textarea  row="5"  class="txt-Purpose form-control" name="<portlet:namespace/>maintitle" ><%=istruzioni_per_la_compilazioneLocalServiceUtil.getistruzioni_per_la_compilazione(1).getPurpose()%></textarea></td>
<td width="45px">
<span class="table-Purpose btn btn-primary" style="color:white">Edit</span>
</td>
</tr>
</table> 
</div>
</div>

<div class="row">
<br/>
<div class="col-md-12">
<table width="100%">
<tr>
<td><input class="txt-SubTitle form-control" name="<portlet:namespace/>maintitle_4" value="<%=istruzioni_per_la_compilazioneLocalServiceUtil.getistruzioni_per_la_compilazione(1).getSubTitle()%>"></input></td>
<td width="45px">
<span class="table-SubTitle btn btn-primary" style="color:white">Edit</span>
</td>
</tr>
</table> 
<br/>
</div>
</div>

<%
int count=0;
List<istruzioni_per_la_compilazione_child> childs=istruzioni_per_la_compilazione_childLocalServiceUtil.getistruzioni_per_la_compilazione_childs(0, istruzioni_per_la_compilazione_childLocalServiceUtil.getistruzioni_per_la_compilazione_childsCount());
for(istruzioni_per_la_compilazione_child child:childs)
{
	if(child.getIstruzioni_per_id()==1){
	%>
	<div class="row"> 
	<br/>
	<div class="col-md-12">
	<div class="row">
	<div class="col-md-1"> 
	<center>
	<%=""+(++count) %>
	</center>
	</div>
	<div class="col-md-11"> 
	<table width="100%">
	<tr>
	<%-- <aui:form action="${edit_instruction}">
	<input type="hidden" name="<portlet:namespace/>instruct_id" value="<%=child.getIns_id()%>"/>
	<td><textarea row="5"  class="form-control" name='<portlet:namespace/>instruct_data'><%=child.getInstruction() %></textarea>
	 --%>
	<td>
	<textarea row="5"  class="child-textarea form-control" data-id="<%=child.getIns_id()%>"><%=child.getInstruction() %></textarea>
	</td>
	<td width="45px">
	<center>
	<span class="table-edit btn btn-primary" style="color:white" data-childid="<%=child.getIns_id()%>">Edit</span><br/>
	<!-- <span class="table-editable glyphicon glyphicon-edit"> </span>-->
	<span class="table-remove glyphicon glyphicon-remove" data-stateName="<%=child.getIns_id()%>"></span>
	</center>
    </td>
	<%-- </aui:form>  --%>
	</tr>
	</table> 
	</div>
	</div>
	</div>
	</div>
<%
	}
}
%>
</div>
<div class="row">
<br/>
<div class="col-md-12">
<table width="100%">
<tr>
<aui:form action="">
<td><aui:button type="submit" value="Add New"/> </td>
</aui:form> 
</tr>
</table> 
<br/>
</div>
</div>
<portlet:resourceURL var="updaContentURL">
</portlet:resourceURL>
<script>

$('.table-maintitle').click(function(){
	var data=$('.txt-maintitle').val();
	alert('Hello I am main mainTilte'+data);
	//Start of Ajax
	AUI().use('aui-base','aui-io-request', function(A){
		//main Ajax Request Body
		A.io.request('<%=updaContentURL%>',{
  		dataType: 'json',
  		method: 'POST',
  		data: { '<portlet:namespace />parentId': '1','<portlet:namespace />action-for':'mainTitle' ,'<portlet:namespace />data-value': data},
  		on: {
   			 success: function() {
   			//	alert('OK');
	     	//	location.reload();
    		}
  		}
		});
		//end of main Ajax Request Body
		});
		//End of Ajax
});

$('.table-title').click(function(){
	var data=$('.txt-title').val();
		alert('Hello I am main Tilte'+data);
		//Start of Ajax
		AUI().use('aui-base','aui-io-request', function(A){
			//main Ajax Request Body
			A.io.request('<%=updaContentURL%>',{
	  		dataType: 'json',
	  		method: 'POST',
	  		data: { '<portlet:namespace />parentId': '1','<portlet:namespace />action-for':'Title' ,'<portlet:namespace />data-value': data},
	  		on: {
	   			 success: function() {
	   			//	alert('OK');
		     	//	location.reload();
	    		}
	  		}
			});
			//end of main Ajax Request Body
			});
			//End of Ajax

});
	
$('.table-Purpose').click(function(){
	var data=$('.txt-Purpose').val(); 
	alert('Hello I am main puspose'+data);
	//Start of Ajax
	AUI().use('aui-base','aui-io-request', function(A){
		//main Ajax Request Body
		A.io.request('<%=updaContentURL%>',{
  		dataType: 'json',
  		method: 'POST',
  		data: { '<portlet:namespace />parentId': '1','<portlet:namespace />action-for':'purpose' ,'<portlet:namespace />data-value': data},
  		on: {
   			 success: function() {
   			//	alert('OK');
	     	//	location.reload();
    		}
  		}
		});
		//end of main Ajax Request Body
		});
		//End of Ajax

});
		
$('.table-SubTitle').click(function(){
	var data=$('.txt-SubTitle').val();	
	alert('Hello I am main subtitle'+data);
	//Start of Ajax
	AUI().use('aui-base','aui-io-request', function(A){
		//main Ajax Request Body
		A.io.request('<%=updaContentURL%>',{
  		dataType: 'json',
  		method: 'POST',
  		data: { '<portlet:namespace />parentId': '1','<portlet:namespace />action-for':'subTitle' ,'<portlet:namespace />data-value': data},
  		on: {
   			 success: function() {
   			//	alert('OK');
	     	//	location.reload();
    		}
  		}
		});
		//end of main Ajax Request Body
		});
		//End of Ajax
});

<!--I am calling on base of class name use(.) and -->
$('.table-remove').click(function(){
	alert('Hello I am remove'+$(this).attr("data-stateName"));
});

$('.table-edit').click(function(){
	var id=$(this).attr("data-childid") 
	 $(".child-textarea").each(function(){
		 if(id==$(this).attr("data-id"))
			 {
			//Ajax
			var data=	$(this).val();
			AUI().use('aui-base','aui-io-request', function(A){
				//aui ajax call to get updated content
				A.io.request('<%=updaContentURL%>',{
		  		dataType: 'json',
		  		method: 'GET',
		  		data: { '<portlet:namespace />parentId': '1','<portlet:namespace />childId':id ,'<portlet:namespace />data-value': data},
		  		on: {
		   			 success: function() {
		   			//	alert('OK');
			     	//	location.reload();
		    		}
		  		}
				});
				});
			
			
			//Ajax End
			 alert("text area value"+$(this).val()+" not "+$(this).attr("data-id")+" Ok "+id)		 
			
			 	 
			 }
		 });
	 // alert('Hello I am edit'+$(this).attr("data-childid"));
});
</script>
