<%@page import="com.daffo.suilupposervice.service.suiluppo_courseLocalServiceUtil"%>
<%@page import="com.daffo.suilupposervice.model.suiluppo_course"%>
<%@page import="com.daffo.suilupposervice.service.suiluppo_room_allocationLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.daffo.suilupposervice.model.suiluppo_room_allocation"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/init.jsp" %>
<%-- <%=request.getParameter("roomId") %>
<%=request.getParameter("courseId") %> --%>
<%
long roomId=new Long(request.getParameter("roomId")).longValue();
long courseId=new Long(request.getParameter("courseId")).longValue();
DynamicQuery dq=suiluppo_room_allocationLocalServiceUtil.dynamicQuery();
dq.add(RestrictionsFactoryUtil.eq("roomID", roomId));
dq.add(RestrictionsFactoryUtil.eq("course_id", courseId));
List<suiluppo_room_allocation>su=suiluppo_room_allocationLocalServiceUtil.dynamicQuery(dq);

%>
<div class="container-fluid-1280">
<div class="row" style="margin-left:15px">
<div class="col-md-12">
<table class="table table-hover table-bordered results" style="width:100%">
<thead>
<tr>
<td colspan="5">
<b><u>Room Detail</u></b>
</td>
</tr>
</thead>
<tbody>
<tr>
<td><b>Room Allocation Date</b></td><td>
<%=su.get(0).getRoom_allocat_date() %>
</td>
</tr>
<tr>
<td><b>Course Start Date</b></td><td>
<%=su.get(0).getRoom_allocat_start() %>
</td>
</tr>
<tr>
<td><b>Course End Date</b></td><td>
<%=su.get(0).getRoom_allocat_end() %>
</td>
</tr>
<tr>
<td><b>Room Status</b></td><td>
<%=su.get(0).getRoom_allocat_status() %>
</td>
</tr>

</tbody>
</table>
</div>
</div>
</div>
