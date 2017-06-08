<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="istruzioni_per_la_compilazioneservice.model.istruzioni_per_la_compilazione"%>
<%@page import="istruzioni_per_la_compilazioneservice.model.istruzioni_per_la_compilazione_childModel"%>
<%@page import="istruzioni_per_la_compilazioneservice.model.istruzioni_per_la_compilazione_child"%>
<%@page import="java.util.List"%>
<%@page import="istruzioni_per_la_compilazioneservice.service.istruzioni_per_la_compilazione_childLocalServiceUtil"%>
<%@page import="istruzioni_per_la_compilazioneservice.service.istruzioni_per_la_compilazioneLocalServiceUtil"%>
<%@ include file="/init.jsp" %>


<liferay-ui:success key="success" message="Record Updated successfully!"/>

<portlet:actionURL var="addURL" name="NewInstruction">
<portlet:param name="mvcPath" value="/add_instruction.jsp" />
</portlet:actionURL>

<div class="container" style="margin-left:20px;margin-right:20px;">
<div class="row">
<br/>
<div class="col-md-12">
<aui:form action="${addURL}" method="post" name="name">
<aui:input name="NewInstruction"  label="Enter New Instruction" type="textarea" placeholder="Enter Instruction">
<aui:validator name="required" errorMessage="Please enter Instruction"></aui:validator>
</aui:input>
<aui:button name="name" type="submit" value="Add Instruction" />
</aui:form>
</div>
</div>
</div>
