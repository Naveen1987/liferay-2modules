<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="java.util.List"%>
<%@page import="com.daffo.suilupposervice.model.suiluppo_course"%>
<%@page import="com.daffo.suilupposervice.service.suiluppo_courseLocalServiceUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/init.jsp" %>
<%--Message area --%>
<liferay-ui:success key="showall" message="This is list of all Employee!"/>

<style>
.results tr[visible='false'],
.no-result{
  display:none;
}

.results tr[visible='true']{
  display:table-row;
}

.counter{
  padding:8px; 
  color:#ccc;
}
</style>

<script>
$(document).ready(function() {
	  $(".search").keyup(function () {
	    var searchTerm = $(".search").val();
	    var listItem = $('.results tbody').children('tr');
	    var searchSplit = searchTerm.replace(/ /g, "'):containsi('")
	    
	  $.extend($.expr[':'], {'containsi': function(elem, i, match, array){
	        return (elem.textContent || elem.innerText || '').toLowerCase().indexOf((match[3] || "").toLowerCase()) >= 0;
	    }
	  });
	    
	  $(".results tbody tr").not(":containsi('" + searchSplit + "')").each(function(e){
	    $(this).attr('visible','false');
	  });

	  $(".results tbody tr:containsi('" + searchSplit + "')").each(function(e){
	    $(this).attr('visible','true');
	  });

	  var jobCount = $('.results tbody tr[visible="true"]').length;
	    $('.counter').text(jobCount + ' item');

	  if(jobCount == '0') {$('.no-result').show();}
	    else {$('.no-result').hide();}
			  });
	});
</script>

<div class="container-fluid-1280">
<div class="row">
<div class="col-md-12">
<div class="pull-right">
    <table>
    <tbody>
    <tr>
    <td style="padding: 10px;"><span id="btnOwn" class="btn btn-warning">Own Course</span></td>
    <td style="padding: 10px;"><span id="btnOther" class="btn btn-warning">Course for Apply</span></td>
    </tr>
    </tbody>
    </table>
</div>
</div>
</div>
<div id="listOwn" class="row">
<div class="col-md-12">
<div class="form-group pull-right">
    <input type="text" class="search form-control" placeholder="What you looking for?">
</div>
<span class="counter pull-right"></span>
<table class="table table-hover table-bordered results">
  <thead>
    <tr class="bg-primary">
     <%--<th><b>#</b></th> --%>
    <th><b>Evento Progetto</b></th>
    <th><b>Titolo</b></th>
    <th><b>Data Inizio</b></th>
    <th><b>Data Fine</b></th>
    <th><b>Tot Ore</b></th>
    <th><b>Visibile</b></th>
    <th><b>Bloccato</b></th>
     <th><b>Action</b></th>
    </tr>
    <tr class="warning no-result">
      <td colspan="10"><i class="fa fa-warning"></i> No result</td>
    </tr>
  </thead>
    <tbody>
   <%--  <%
    List<suiluppo_course> lsc=suiluppo_courseLocalServiceUtil.getsuiluppo_courses(0, suiluppo_courseLocalServiceUtil.getsuiluppo_coursesCount());			
    %> --%>
    
    <%
    
    DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(suiluppo_course.class);
    userQuery.add(RestrictionsFactoryUtil.eq("Docente", user.getFullName()));
    List<suiluppo_course> suil=suiluppo_courseLocalServiceUtil.dynamicQuery(userQuery);
    for(suiluppo_course su:suil)
    {%>
     <tr>
    <%-- <td><%=su.getCourse_id() %></td> --%>
    <td><%=su.getEvento_Progetto()%></td>
    <td><%=su.getTitolo()%></td>
    <td><%=su.getData_Inizio()%></td>
    <td><%=su.getData_Fine()%></td>
    <td><%=su.getTot_Ore()%></td>
    <td><%=su.getVisibile()%></td>
    <td><%=su.getBloccato()%></td>
    <td>
    <table>
    <tbody>
    <tr>
    <td style="padding: 5px;"><span onclick="getCourseViewId('<%=su.getCourse_id() +""%>')" class="btn btn-primary btnview">View</span></td>
    <td style="padding: 5px;"><span onclick="getCourseEditId('<%=su.getCourse_id() +""%>')" class="btn btn-warning btnedit">Edit</span></td>
     </tr>
    </tbody>
    </table>
    </td>
    </tr>
    <%}%>
   
    </tbody>
    </table>

</div>
</div>

<div id="listApply" class="row">
<div class="col-md-12">
<div class="form-group pull-right">
    <input type="text" class="search form-control" placeholder="What you looking for?">
</div>
<span class="counter pull-right"></span>
<table class="table table-hover table-bordered results">
  <thead>
    <tr class="bg-primary">
    <th><b>Docente</b></th>
    <th><b>Evento Progetto</b></th>
    <th><b>Titolo</b></th>
    <th><b>Data Inizio</b></th>
    <th><b>Data Fine</b></th>
    <th><b>Tot Ore</b></th>
    <th><b>Visibile</b></th>
    <th><b>Bloccato</b></th>
    <th><b>Dispensa corso</b></th>
     <th><b>Action</b></th>
    </tr>
    <tr class="warning no-result">
      <td colspan="10"><i class="fa fa-warning"></i> No result</td>
    </tr>
  </thead>
    <tbody>
   <tr>
     <td>Docente</td>
    <td>Evento Progetto</td>
    <td>Titolo</td>
    <td>Data Inizio</td>
    <td>Data Fine</td>
    <td>Tot Ore</td>
    <td>Visibile</td>
    <td>Bloccato</td>
    <td>Dispensa corso</td>
    <td>
    <table>
    <tbody>
    <tr>
    <td style="padding: 10px;"><span id="btnApply"  class="btn btn-success">Apply</span></td>
    </tr>
    </tbody>
    </table>
    </td>
    </tr>
    </tbody>
    </table>

</div>
</div>
</div>

<script type="text/javascript">
$(document).ready(function () {
$("#listApply").hide();
});
$("#btnOwn").click(function(){
	$("#listApply").hide();
	$("#listOwn").show();
});
$("#btnOther").click(function(){
	$("#listApply").show();
	$("#listOwn").hide();
});
function getCourseViewId(courseId)
{
	    var portletURL = Liferay.PortletURL.createRenderURL();
	 	portletURL.setWindowState('<%=LiferayWindowState.POP_UP.toString() %>');
	    portletURL.setParameter('courseId', courseId);    
	    portletURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
	    portletURL.setParameter('mvcPath', '/ViewCourse.jsp');
	    // Now we can use the URL
	  // alert(portletURL.toString());
	   Liferay.Util.openWindow({
			dialog: {
			centered: true,
			cssClass: 'my-liferay-popup',
			constrain2view: true,
			modal: true,
			resize:false,
			width: 950,
			height:800

			},
			id: '<portlet:namespace/>Course_View',
			title: 'Course View' ,
			uri:  portletURL.toString()
			});
}
function getCourseEditId(courseId)
{
	    var portletURL = Liferay.PortletURL.createRenderURL();
	 	portletURL.setWindowState('<%=LiferayWindowState.POP_UP.toString() %>');
	    portletURL.setParameter('courseId', courseId);    
	    portletURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
	    portletURL.setParameter('mvcPath', '/editCourse.jsp');
	    // Now we can use the URL
	  // alert(portletURL.toString());
	   /* Liferay.Util.openWindow({
			dialog: {
			centered: true,
			cssClass: 'my-liferay-popup',
			constrain2view: true,
			modal: true,
			width: 950
			},
			id: '<portlet:namespace/>Course_Edit',
			title: 'Course Edit' ,
			uri:  portletURL.toString()		
			}); */
	    YUI().ready(function(A) {
	        YUI().use('aui-base','liferay-util-window', function(A) {
	            Liferay.Util.Window.getWindow({
	                title :'Course Edit',
	                uri: portletURL,
	                id:'<portlet:namespace/>Course_Edit',
	                dialog: {
	                	centered: true,
	                    destroyOnHide: true,
	                    cache: false,
	                    modal: true,
	                    width: 950
	                }
	            }).after('destroy', function(event) {
	            	//It will refresh
	            	location.reload();
	            });
	        });
	    });
}

</script>

