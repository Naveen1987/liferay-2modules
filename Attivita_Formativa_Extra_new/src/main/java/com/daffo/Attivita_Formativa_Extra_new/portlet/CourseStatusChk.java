package com.daffo.Attivita_Formativa_Extra_new.portlet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.StringTokenizer;

import com.daffo.suilupposervice.model.suiluppo_course;
import com.daffo.suilupposervice.model.suiluppo_room_allocation;
import com.daffo.suilupposervice.service.suiluppo_courseLocalServiceUtil;
import com.daffo.suilupposervice.service.suiluppo_room_allocationLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


public class CourseStatusChk {

	private Log logger=LogFactoryUtil.getLog("Course Status Check");
	
	public boolean checkValid(long courseId) throws PortalException{
	suiluppo_course sc=suiluppo_courseLocalServiceUtil.getsuiluppo_course(courseId);
	String cDate="";
	String newDate="";
	if(sc.getBloccato().equalsIgnoreCase("false")&&sc.getVisibile().equalsIgnoreCase("true")){
		Date c_date=null;
		Date new_date=null;
		try{
		cDate=sc.getData_Fine();
		newDate=new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());
		c_date=new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(cDate);
		new_date=new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(newDate);
//		System.out.println(cDate);
//		System.out.println(newDate);
//		System.out.println(c_date);
//		System.out.println(new_date);
		}catch (Exception e) {
			logger.error(e.getMessage());
			return true;
		}
		if(c_date.after(new_date)){
			return false;
		}
		else{
			return true;
		}
	}
	else{
		return true;
	}
	
}
	public boolean UpdateRoomAllocation(long roomalloID) throws PortalException {
//		suiluppo_room_allocation su=suiluppo_room_allocationLocalServiceUtil.getsuiluppo_room_allocation(roomalloID);
//		su.setRoom_allocat_status("Not Booked");
//		suiluppo_room_allocationLocalServiceUtil.updatesuiluppo_room_allocation(su);
		suiluppo_room_allocationLocalServiceUtil.deletesuiluppo_room_allocation(roomalloID);
		return true;
	}
	
	public boolean checkAlreadBooked(long cid,long rid){	
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
	public boolean checkAlreadBooked(long rid){
		
		DynamicQuery userQuery = suiluppo_room_allocationLocalServiceUtil.dynamicQuery();
		userQuery.add(RestrictionsFactoryUtil.eq("room_allocat_status", "Booked"));
		userQuery.add(RestrictionsFactoryUtil.eq("roomID",rid));
		List<suiluppo_room_allocation> sur= suiluppo_room_allocationLocalServiceUtil.dynamicQuery(userQuery);
		if(sur.size()>0){
			return true;
		}
		return false;
	}
public boolean checkAlreadCourseBooked(long cid){
		
		DynamicQuery userQuery = suiluppo_room_allocationLocalServiceUtil.dynamicQuery();
		userQuery.add(RestrictionsFactoryUtil.eq("room_allocat_status", "Booked"));
		userQuery.add(RestrictionsFactoryUtil.eq("course_id", cid));
		List<suiluppo_room_allocation> sur= suiluppo_room_allocationLocalServiceUtil.dynamicQuery(userQuery);
		if(sur.size()>0){
			return true;
		
		}
		return false;
	}
		
}
