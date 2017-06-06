<%@page import="com.liferay.portal.kernel.model.Group"%>
<%@page import="com.liferay.portal.kernel.service.UserServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp" %>
<%User me=user; %>
<%
System.out.println(me.getFullName());
for(Role r:me.getRoles()){
	System.out.println(r.getName());
}
%>