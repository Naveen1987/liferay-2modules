<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="istruzioni_per_la_compilazioneservice.model.istruzioni_per_la_compilazione"%>
<%@page import="istruzioni_per_la_compilazioneservice.model.istruzioni_per_la_compilazione_childModel"%>
<%@page import="istruzioni_per_la_compilazioneservice.model.istruzioni_per_la_compilazione_child"%>
<%@page import="java.util.List"%>
<%@page import="istruzioni_per_la_compilazioneservice.service.istruzioni_per_la_compilazione_childLocalServiceUtil"%>
<%@page import="istruzioni_per_la_compilazioneservice.service.istruzioni_per_la_compilazioneLocalServiceUtil"%>
<%@ include file="/init.jsp" %>

<style>
h2Class{
font-family: Arial, Helvetica, Sans-serif;
    font-weight: normal;
    line-height: normal;
}
</style>
<%--
<%=istruzioni_per_la_compilazioneLocalServiceUtil.getistruzioni_per_la_compilazionesCount()%>
<%=istruzioni_per_la_compilazioneLocalServiceUtil.getistruzioni_per_la_compilazione(1) %>
<%=istruzioni_per_la_compilazione_childLocalServiceUtil.getistruzioni_per_la_compilazione_childsCount()%>
--%>
<div class="container"> 
<!-- Heading -->
<div class="row">
<div class="col-md-12">
<h1 class="h2Class">
<%=istruzioni_per_la_compilazioneLocalServiceUtil.getistruzioni_per_la_compilazione(1).getMainTitle()%>
</h1>
</div>
</div>
<!-- First Row --> 
<div class="row"> 
<div class="col-md-12"> 
<h2 class="h2Class">
<%=istruzioni_per_la_compilazioneLocalServiceUtil.getistruzioni_per_la_compilazione(1).getTilte()%>
</h2>
<div class="row"> 
<div class="col-md-12" style="margin-left: 33px;"> 
<%=istruzioni_per_la_compilazioneLocalServiceUtil.getistruzioni_per_la_compilazione(1).getPurpose()%>
</div>
</div>
</div>
</div>
<!-- Second Row --> 
<div class="row"> 
<div class="col-md-12">
<h2 class="h2Class">
<%=istruzioni_per_la_compilazioneLocalServiceUtil.getistruzioni_per_la_compilazione(1).getSubTitle()%>
</h2>
<%
int count=0;
List<istruzioni_per_la_compilazione_child> childs=istruzioni_per_la_compilazione_childLocalServiceUtil.getistruzioni_per_la_compilazione_childs(0, istruzioni_per_la_compilazione_childLocalServiceUtil.getistruzioni_per_la_compilazione_childsCount());
for(istruzioni_per_la_compilazione_child child:childs)
{
	if(child.getIstruzioni_per_id()==1){
	%>
	<div class="row"> 
	<div class="col-md-1"> 
	<center>
	<%=""+(++count) %>
	</center>
	</div>
	<div class="col-md-11"> 
	<%=child.getInstruction() %>
	</div>
	</div>
<%
	}
}
%>
</div>
</div>
</div>
