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