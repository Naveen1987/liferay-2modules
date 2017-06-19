<%@ include file="/init.jsp" %>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@ include file="init.jsp"%>
<portlet:actionURL var="sendMailMessageActionURL" windowState="<%=LiferayWindowState.NORMAL.toString()%>">
<portlet:param name="<%=ActionRequest.ACTION_NAME%>" value="sendMailMessage"/>
<portlet:param name="name" value="meera prince"/>
</portlet:actionURL>
<h1>Mail Sender</h1>
<fieldset>
    <legend>Mail Form</legend>

<liferay-ui:success key="mail-send-success" message="Mail has been send successfully." />

<aui:form action="<%=sendMailMessageActionURL%>" method="post" name="mailSenderForm">
			<aui:input 	label="From Mail Address" name="senderEmailAddess" id="senderEmailAddess" type="text" style="width:600px;height:20px;"/>	
			<aui:input 	label="To Mail Address" name="receiverEmailAddess" id="receiverEmailAddess" type="text" style="width:600px;height:20px;"/>
			<aui:input 	label="Mail Subject" name="mailSubject" id="mailSubject" type="text" style="width:600px;height:20px;"/>
			<liferay-ui:input-editor >
			</liferay-ui:input-editor>
			<aui:button type="submit" value="Send Mail" name="submit"></aui:button>
</aui:form>
</fieldset>

