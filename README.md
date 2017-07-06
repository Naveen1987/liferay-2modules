-wiki_node_table
NodeID
NodeName
NodeDescription
NodeCreationDate
NodeCreator
NodeModificationDate
-wiki_page_table
PageID
PageName
PageDescription
PageRating
PageVersion
NodeID
Page_Creation_Date
Page_creator
-wiki_pagedata_table
Page_ModID
PageData
PageEdit_User
Page_editDate
Page_Version
PageID
-wiki_comment_table
comment_ID
Comment_data
Comment_User
Comment_Date
PageID




<%-- <%

DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(suiluppo_course.class);
List<suiluppo_course> suil=suiluppo_courseLocalServiceUtil.dynamicQuery(userQuery);
for(suiluppo_course su:suil)
{
	System.out.println(su);
}
%> --%>
<%-- <%@include file="/listCourse.jsp" %>
 --%>
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

public boolean checkAlreadBooked(long cid,long rid){
//Error Full	
		//DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(suiluppo_room_allocation.class);
//Error free
		DynamicQuery userQuery = suiluppo_room_allocationLocalServiceUtil.dynamicQuery();
		userQuery.add(RestrictionsFactoryUtil.eq("room_allocat_status", "Booked"));
		userQuery.add(RestrictionsFactoryUtil.eq("roomID", rid));
		userQuery.add(RestrictionsFactoryUtil.eq("course_id", cid));
		List<suiluppo_room_allocation> sur= suiluppo_room_allocationLocalServiceUtil.dynamicQuery(userQuery);
		if(sur.size()>0){
			return true;
		}
		return false;
	}
	
	
	
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/init.jsp" %>
<script src="<%=request.getContextPath() %>/jsfiles/jquery-confirm.min.js"></script>
<link href="<%=request.getContextPath() %>/jsfiles/jquery-confirm.min.css" rel="stylesheet">

<button class="example2 btn btn-primary">example confirm</button>
<script type="text/javascript">
/* Simple example */
/* $('.example2').on('click', function () {
                    $.confirm({
                                	    title: 'Confirm!',
                                	    content: 'Do you want to do this?',
                                	    buttons: {
                                	        yes: function () {
                                	            $.alert('Confirmed!');
                                	        },
                                	        no: function () {
                                	            $.alert('Canceled!');
                                	        }
                                	    }
                   });
                                	        
 }); */
 /* Now Play with button css */
/*  Jconfirm comes bundled with btn-blue btn-green btn-red btn-orange btn-purple btn-default btn-dark
Other bootstrap options are btn-primary btn-inverse btn-warning btn-info btn-danger btn-success. 
to change the text of yes into yes If
yes: {
	text:'Yes If'
    btnClass: 'btn-green',
    action: function(){
    $.alert('Confirm!');
    }
}
 //this option will show show the close icon on confirmation dialog 
 closeIcon: true,
 //this will replace that icon with glyphicon (not rquired)
 closeIconClass:'glyphicon glyphicon-remove-circle',
*/
  $('.example2').on('click', function () {
                    $.confirm({
                    					icon: 'glyphicon glyphicon-question-sign',
                    					title: 'Confirm!',
                       					content: 'Do you want to do this?',
                                	    boxWidth: '500px',
                                	    closeIcon: true,
                                	    closeIconClass:'glyphicon glyphicon-remove-circle',
                                	    useBootstrap: false,
                                	    type: 'orange',
                                	    draggable: true,
                                	    buttons: {
                                	        yes: {
                                	            btnClass: 'btn-green',
                                	            action: function(){
                                	            //start	
                                	            $.alert('Confirm!');
                                	            //end
                                	            }
                                	        },
                                	        no: {
                                	            btnClass: 'btn-red',
                                	            action: function(){
                                	           //start
                                	            $.alert('Cancel!');
                                	           //end
                                	            }
                                	        }
                                	    }
                   });
                                	        
 });
</script>