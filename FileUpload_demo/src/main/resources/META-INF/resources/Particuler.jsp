<%@page import="java.util.Map"%>
<%@ include file="/init.jsp" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <b>Click link to download files</b> 
 <br><br> 
 <portlet:actionURL var="downloadURL" name="Particuler">
</portlet:actionURL> 
 <form action="<%=downloadURL%>" method="post"> 
<input type="text" name="<portlet:namespace/>uploadedFile"> 
<input type="Submit" name="Submit"> 
</form> 
<%=request.getAttribute("urlOnly")%>