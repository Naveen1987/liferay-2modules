<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="/init.jsp" %>
    <link href="<%=request.getContextPath() %>/newcss/css/responsive-calendar.css" rel="stylesheet">
  <div class="container">
      <!-- Responsive calendar - START -->
    	<div class="responsive-calendar">
       <!--  <div class="controls">
            <a class="pull-left" data-go="prev"><div class="btn btn-primary">Prev</div></a>
            <h4><span data-head-year></span> <span data-head-month></span></h4>
            <a class="pull-right" data-go="next"><div class="btn btn-primary">Next</div></a>
        </div><hr/> -->
         <div class="controls">
      <a class="pull-left" data-go="prev"><div class="btn"><i class="icon-chevron-left"></i></div></a>
      <h4><span data-head-year></span> <span data-head-month></span></h4>
      <a class="pull-right" data-go="next"><div class="btn"><i class="icon-chevron-right"></i></div></a>
  	  </div><hr/>
        <div class="day-headers">
          <div class="day header">Mon</div>
          <div class="day header">Tue</div>
          <div class="day header">Wed</div>
          <div class="day header">Thu</div>
          <div class="day header">Fri</div>
          <div class="day header">Sat</div>
          <div class="day header">Sun</div>
        </div>
        <div class="days" data-group="days">
          
        </div>
      </div>
      <!-- Responsive calendar - END -->
    </div>
    
    
<%--We are talking about model for duration choose --%>    
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="<%=request.getContextPath() %>/newcss/modals/w3.css">
<link href="<%= request.getContextPath()%>/css/clockpicker.css" rel="stylesheet">
<script src="<%= request.getContextPath()%>/css/clockpicker.js"></script>

<div class="w3-container">
   <div id="id01" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px">

      <div class="w3-center"><br>
        <span onclick="document.getElementById('id01').style.display='none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
        <img src="<%=request.getContextPath() %>/newcss/modals/clock.png" alt="Avatar" style="width:30%" class="w3-circle w3-margin-top">
      </div>   
      <br/>  
        <div class="w3-center">
       <center>
        <table><tr>
        <td>
         <label><b>Start Date</b></label>
          <div class="input-group clockpicker">
 	      <input type="text"  name="<portlet:namespace/>start-time" id="start-time" class="form-control" placeholder="Click for Clock" readonly="readonly">
 	      <span id="_start-time" style="color:red; display:none">Please Enter start-time</span>
	      </div>
          <label><b>End Date</b></label>
          <div class="input-group clockpicker">
 	      <input type="text"  name="<portlet:namespace/>start-end" id="start-end" class="form-control" placeholder="Click for Clock" readonly="readonly">
 	      <span id="_start-end" style="color:red; display:none">Please Enter start-time</span>
	      </div>
          <button class="w3-button w3-block w3-green w3-section w3-padding" onclick="document.getElementById('id01').style.display='none'">Submit</button>
                 
        </td>
        </tr></table>
       </center>
        </div>
     

     

    </div>
  </div>
</div>
 <%--We are talking about model for duration choose --%>    
    <%--$('.responsive-calendar').responsiveCalendar({ }); this will use only one time --%>
    <script src="<%=request.getContextPath() %>/newcss/js/responsive-calendar.js"></script>
    <script type="text/javascript">
    function addLeadingZero(num) {
	    if (num < 10) {
	      return "0" + num;
	    } else {
	      return "" + num;
	    }
	  }
    $(document).ready(function () {  
    		  $('.clockpicker').clockpicker({donetext: 'Done'});
    		  $('.responsive-calendar').responsiveCalendar({ 
    		  	  onDayClick: function(events) {
    		  		getDate(this);
    		    }   
    		  });
      });
    </script>
    
   <script type="text/javascript">
function getDate(obj){
	  var courseId='<%=request.getParameter("courseId")%>';
	  var  key;
      key = $(obj).data('year')+'-'+addLeadingZero( $(obj).data('month') )+'-'+addLeadingZero( $(obj).data('day') ); 		    
      $("#id01").css("display", "block");
      alert(courseId+" | "+key);
}
</script>

<%--
    <script type="text/javascript">
      $(document).ready(function () {
      
      /* var today = new Date();
    	    	var dd = today.getDate();
    	    	var mm = today.getMonth()+1; //January is 0!
    	    	var yyyy = today.getFullYear();
    	    	var date=yyyy+"-"+mm;
    	    	$(".responsive-calendar").responsiveCalendar({
    	          time: date,
    	          events: {}
    	        }); */
    	        //or
       // $(".responsive-calendar").responsiveCalendar('curr')
      
        $(".responsive-calendar").responsiveCalendar({
          time: '2013-05',
          events: {
            "2013-04-30": {"number": 5, "url": "http://w3widgets.com/responsive-slider"},
            "2013-04-26": {"number": 1, "url": "http://w3widgets.com"}, 
            "2013-05-03": {"number": 1}, 
            "2013-06-12": {}}
        });
      });
    </script>
    --%>