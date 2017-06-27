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

<%
long roomId=new Long(request.getParameter("roomId")).longValue();
DynamicQuery dq=DynamicQueryFactoryUtil.forClass(suiluppo_room_allocation.class);
dq.add(RestrictionsFactoryUtil.eq("roomID", roomId));
List<suiluppo_room_allocation>su=suiluppo_room_allocationLocalServiceUtil.dynamicQuery(dq);
long courseId =su.get(0).getCourse_id();
suiluppo_course ls=suiluppo_courseLocalServiceUtil.getsuiluppo_course(courseId);
%>
<div class="container-fluid-1280">
<div class="row" style="margin-left:15px">
<div class="col-md-12">
<table class="table table-hover table-bordered results" style="width:100%">
<thead>
<tr>
<th colspan="2" class="bg-primary">
<b>Course View</b>
</th>
</tr>
</thead>
<tbody>
<tr>
<td><b>Docente</b></td><td><%=ls.getDocente() %></td>
</tr>
<tr>
<td><b>Evento Progetto</b></td><td><%=ls.getEvento_Progetto()%></td>
</tr>
<tr>
<td><b>Titolo</b></td><td><%=ls.getTitolo() %></td>
</tr>
<tr>
<td><b>Descrizione</b></td><td><%=ls.getDescrizione() %></td>
</tr>
<tr>
<td><b>Figure Professionali Coinvolte</b></td><td><%=ls.getFigure_Professionali_Coinvolte()%></td>
</tr>
<tr>
<td><b>Nr Edizione</b></td><td><%=ls.getNr_Edizione() %></td>
</tr>
<tr>
<td><b>Sede</b></td><td><%=ls.getSede() %></td>
</tr>
<tr>
<td><b>Abstract</b></td><td><%=ls.getAbstract() %></td>
</tr>
<tr>
<td><b>Data Inizio</b></td><td><%=ls.getData_Inizio()%></td>
</tr>
<tr>
<td><b>Data Fine</b></td><td><%=ls.getData_Fine() %></td>
</tr>
<tr>
<td><b>Tot Ore</b></td><td><%=ls.getTot_Ore()%></td>
</tr>
<tr>
<td><b>Scadenza Iscrizioni</b></td><td><%=ls.getScadenza_Iscrizioni() %></td>
</tr>
<tr>
<td><b>Ammessi al corso</b></td><td><%=ls.getAmmessi_al_corso() %></td>
</tr>
<tr>
<td><b>Visibile</b></td><td><%=(ls.getVisibile().equalsIgnoreCase("true"))?"SI":"NO" %></td>
</tr>
<tr>
<td><b>Bloccato</b></td><td><%=(ls.getBloccato().equalsIgnoreCase("true"))?"SI":"NO" %></td>
</tr>
<tr>
<td><b>Dispensa corso</b></td><td><a href="<%=ls.getDispensa_corso() %>">Download</a></td>
</tr>
</tbody>
</table>
</div>
</div>
</div>
