<%@page import="com.liferay.portal.kernel.portlet.PortletClassLoaderUtil"%>
<%@page import="com.liferay.portal.kernel.bean.PortletBeanLocatorUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.daffo.suilupposervice.service.suiluppo_equip_allocationLocalServiceUtil"%>
<%@page import="com.daffo.suilupposervice.service.suiluppo_room_allocationLocalServiceUtil"%>
<%@page import="com.daffo.suilupposervice.service.suiluppo_equipmentLocalServiceUtil"%>
<%@page import="com.daffo.suilupposervice.service.suiluppo_roomLocalServiceUtil"%>
<%@page import="com.daffo.suilupposervice.service.suiluppo_applicationLocalServiceUtil"%>
<%@page import="com.daffo.suilupposervice.model.suiluppo_application"%>
<%@page import="com.daffo.suilupposervice.service.suiluppo_courseLocalServiceUtil"%>
<%@ include file="/init.jsp" %>




<%-- <%@include file="/AddCourse.jsp" %> --%>
<%@include file="/listCourse.jsp" %>

<%--
<%=suiluppo_courseLocalServiceUtil.getsuiluppo_course(1)%>
<%=suiluppo_applicationLocalServiceUtil.getsuiluppo_application(1)%>
<%=suiluppo_roomLocalServiceUtil.getsuiluppo_room(1)%>
<%=suiluppo_equipmentLocalServiceUtil.getsuiluppo_equipment(1)%>
<%=suiluppo_room_allocationLocalServiceUtil.getsuiluppo_room_allocation(1)%>
<%=suiluppo_equip_allocationLocalServiceUtil.getsuiluppo_equip_allocation(1)%>
--%>
<%--Dynamic Query Task --%>
<%--
<%
DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(suiluppo_application.class, "user",
		PortalClassLoaderUtil.getClassLoader());
userQuery.add(RestrictionsFactoryUtil.eq("user.course_id", new Long(1)));
List<suiluppo_application> suil=suiluppo_applicationLocalServiceUtil.dynamicQuery(userQuery);
for(suiluppo_application su:suil)
{
	System.out.println(su.getApplicat_name());
}
%>
--%>
<%--
<%
List<suiluppo_application> suil=suiluppo_applicationLocalServiceUtil.findBycourse_id(new Long(1).longValue());
for(suiluppo_application su:suil)
{
	System.out.println(su.getApplicat_name());
}
%>
--%>

<%-- 
<%
DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(suiluppo_application.class, PortalClassLoaderUtil.getClassLoader());
userQuery.add(RestrictionsFactoryUtil.eq("course_id", new Long(1)));
List<suiluppo_application> suil=suiluppo_applicationLocalServiceUtil.dynamicQuery(userQuery);
for(suiluppo_application su:suil)
{
	System.out.println(su.getApplicat_name());
}
%>
 --%>
<%-- <%
DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(suiluppo_application.class);
userQuery.add(RestrictionsFactoryUtil.eq("course_id", new Long(1)));
List<suiluppo_application> suil=suiluppo_applicationLocalServiceUtil.dynamicQuery(userQuery);
for(suiluppo_application su:suil)
{
	System.out.println("Hello->"+su);
	
}
%>
  --%>