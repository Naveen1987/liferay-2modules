package com.daffo.Attivita_Formativa_4.portlet;

import java.time.LocalDateTime;
import java.util.Calendar;
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


public class CourseStatusChk {

	public boolean checkValid(long courseId) throws PortalException{
	suiluppo_course sc=suiluppo_courseLocalServiceUtil.getsuiluppo_course(courseId);
	String cDate="";
	if(sc.getBloccato().equalsIgnoreCase("false")&&sc.getVisibile().equalsIgnoreCase("true")){
		StringTokenizer st=new StringTokenizer(sc.getData_Fine(), "/ :");
		while(st.hasMoreElements()){
			cDate+=st.nextElement();
		}
		Calendar c=new GregorianCalendar();
		String newDate="";
		if(c.get(Calendar.DATE)<10){
			newDate+="0"+c.get(Calendar.DATE);
		}
		else{
			newDate+=""+c.get(Calendar.DATE);
		}
		if((c.get(Calendar.MONTH)+1)<10)
		{
			newDate+="0"+(c.get(Calendar.MONTH)+1);
		}
		else{
			newDate+=""+(c.get(Calendar.MONTH)+1);
		}
		newDate+=c.get(Calendar.YEAR)+"";
		int hour=c.get(Calendar.HOUR_OF_DAY);
		int minute=c.get(Calendar.MINUTE);
		if(hour<10){
			newDate+="0"+hour;
		}else{
			newDate+=""+hour;
		}
		if(minute<10){
			newDate+="0"+minute;
		}else{
			newDate+=""+minute;
		}
		System.out.println(cDate);
		System.out.println(newDate);
		if(new Long(cDate).longValue()>new Long(newDate).longValue()){
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
	
		DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(suiluppo_room_allocation.class);
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
		
		DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(suiluppo_room_allocation.class);
		userQuery.add(RestrictionsFactoryUtil.eq("room_allocat_status", "Booked"));
		userQuery.add(RestrictionsFactoryUtil.eq("roomID",rid));
		List<suiluppo_room_allocation> sur= suiluppo_room_allocationLocalServiceUtil.dynamicQuery(userQuery);
		if(sur.size()>0){
			return true;
		}
		return false;
	}
public boolean checkAlreadCourseBooked(long cid){
		
		DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(suiluppo_room_allocation.class);
		userQuery.add(RestrictionsFactoryUtil.eq("room_allocat_status", "Booked"));
		userQuery.add(RestrictionsFactoryUtil.eq("course_id", cid));
		List<suiluppo_room_allocation> sur= suiluppo_room_allocationLocalServiceUtil.dynamicQuery(userQuery);
		if(sur.size()>0){
			return true;
		
		}
		return false;
	}
		
}
