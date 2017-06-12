<%@ include file="/init.jsp" %>
<div class="container-fluid-1280">
<div class="row"  style="margin-left:5px;margin-right:5px;margin-top:5px;margin-bottom:5px">
<div class="col-md-12" id="dataShow">
<%-- <%=request.getParameter("data")%> --%>
</div>
</div>
</div>
<script>
var m=Liferay.Util.getOpener().<portlet:namespace />pageData.getHTML();
$("#dataShow")[0].innerHTML=m;
</script>