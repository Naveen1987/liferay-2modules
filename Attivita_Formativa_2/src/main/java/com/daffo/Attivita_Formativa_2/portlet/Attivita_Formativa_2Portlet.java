package com.daffo.Attivita_Formativa_2.portlet;


import com.daffo.Attivita_Formativa_2.portlet.FileUpload_ServiceClass;
import com.daffo.suilupposervice.model.suiluppo_application;
import com.daffo.suilupposervice.model.suiluppo_course;
import com.daffo.suilupposervice.model.suiluppo_room_allocation;
import com.daffo.suilupposervice.service.suiluppo_applicationLocalServiceUtil;
import com.daffo.suilupposervice.service.suiluppo_courseLocalServiceUtil;
import com.daffo.suilupposervice.service.suiluppo_room_allocationLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Administrator
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Naveen Apps-UnitaOperative",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Attivita_Formativa_2 Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class Attivita_Formativa_2Portlet extends MVCPortlet {

	private final static Log log=LogFactoryUtil.getLog(Attivita_Formativa_2Portlet.class);
	
	
	private FileUpload_ServiceClass fus=new FileUpload_ServiceClass();
	@ProcessAction(name="formSubmit")
	 public void formSubmit(ActionRequest actionRequest, ActionResponse actionResponse)
	   throws IOException, PortletException, PortalException {
		
		/*System.out.println("Docente-"+ParamUtil.getString(actionRequest, "Docente"));
		System.out.println("Evento_Progetto-"+ParamUtil.getString(actionRequest, "Evento_Progetto"));
		System.out.println("Titolo-"+ParamUtil.getString(actionRequest, "Titolo"));
		System.out.println("Descrizione-"+ParamUtil.getString(actionRequest, "Descrizione"));
		System.out.println("Figure_Professionali_Coinvolte-"+ParamUtil.getString(actionRequest, "Figure_Professionali_Coinvolte"));
		System.out.println("Nr_Edizione-"+ParamUtil.getString(actionRequest, "Nr_Edizione"));
		System.out.println("Sede-"+ParamUtil.getString(actionRequest, "Sede"));
		System.out.println("Abstract-"+ParamUtil.getString(actionRequest, "Abstract"));
		System.out.println("Data_Inizio-date-"+ParamUtil.getString(actionRequest, "Data_Inizio-date"));
		System.out.println("Data_Inizio-time-"+ParamUtil.getString(actionRequest, "Data_Inizio-time"));
		System.out.println("Data_Fine-date"+ParamUtil.getString(actionRequest, "Data_Fine-date"));
		System.out.println("getString-"+ParamUtil.getString(actionRequest, "Data_Fine-time"));
		System.out.println("Tot_Ore-"+ParamUtil.getString(actionRequest, "Tot_Ore"));
		System.out.println("Scadenza_Iscrizioni-date-"+ParamUtil.getString(actionRequest, "Scadenza_Iscrizioni-date"));
		System.out.println("Scadenza_Iscrizioni-time-"+ParamUtil.getString(actionRequest, "Scadenza_Iscrizioni-time"));
		System.out.println("Ammessi_al_corso-"+ParamUtil.getString(actionRequest, "Ammessi_al_corso"));
		System.out.println("Visibile-"+ParamUtil.getString(actionRequest, "Visibile_data"));
		System.out.println("Bloccato-"+ParamUtil.getString(actionRequest, "Bloccato_data"));*/
		//System.out.println("Dispensa_corso-"+ParamUtil.getString(actionRequest, "Dispensa_corso"));*/
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		fus.createFolder(actionRequest, themeDisplay);
		
//		 There are three parameter
//		 1. themeDisplay
//		 2. actionRequest
//		 3. Name of type=file control name

		String fileName=fus.fileUpload(themeDisplay, actionRequest,"Dispensa_corso");
		if(!fileName.isEmpty())
		{
			if(fileName.equalsIgnoreCase("blank")){
			log.error("File Name is Blank{"+fileName+"}");
				return;
			}else if(fileName.equalsIgnoreCase("No Extension")){
			log.error("File format is Missing..{"+fileName+"}");
				return;
			}
			log.info("Created File {"+fileName+"}");
			String downLink=fus.getFileLink(themeDisplay, fileName).get( fileName);
			log.info("Download Link {"+downLink+"}");	
			log.info("Now table is Updating.....");
			suiluppo_course cs=suiluppo_courseLocalServiceUtil.createsuiluppo_course(CounterLocalServiceUtil.increment());
			System.out.println(cs.getCourse_id());
			cs.setDocente(ParamUtil.getString(actionRequest, "Docente"));
			cs.setEvento_Progetto(ParamUtil.getString(actionRequest, "Evento_Progetto"));
			cs.setTitolo(ParamUtil.getString(actionRequest, "Titolo"));
			cs.setDescrizione(ParamUtil.getString(actionRequest, "Descrizione"));
			cs.setFigure_Professionali_Coinvolte(ParamUtil.getString(actionRequest, "Figure_Professionali_Coinvolte"));
			cs.setNr_Edizione(ParamUtil.getString(actionRequest, "Nr_Edizione"));
			cs.setSede(ParamUtil.getString(actionRequest, "Sede"));
			cs.setAbstract(ParamUtil.getString(actionRequest, "Abstract"));
			cs.setData_Inizio(ParamUtil.getString(actionRequest, "Data_Inizio-date")+" "+ParamUtil.getString(actionRequest, "Data_Inizio-time"));
			cs.setData_Fine(ParamUtil.getString(actionRequest, "Data_Fine-date")+" "+ParamUtil.getString(actionRequest, "Data_Fine-time"));
			cs.setTot_Ore(ParamUtil.getString(actionRequest, "Tot_Ore"));
			cs.setScadenza_Iscrizioni(ParamUtil.getString(actionRequest, "Scadenza_Iscrizioni-date")+" "+ParamUtil.getString(actionRequest, "Scadenza_Iscrizioni-time"));
			cs.setAmmessi_al_corso(new Long(ParamUtil.getString(actionRequest, "Ammessi_al_corso")).longValue());
			cs.setBloccato(ParamUtil.getString(actionRequest, "Bloccato_data"));
			cs.setVisibile(ParamUtil.getString(actionRequest, "Visibile_data"));
			cs.setDispensa_corso(downLink);
			suiluppo_courseLocalServiceUtil.addsuiluppo_course(cs);
			SessionMessages.add(actionRequest, "success");
			log.info("Now table is Updated.....");
		}
		else{
			log.error("File Is Exists");
		}
		
	}
	@ProcessAction(name="updateSubmit")
	 public void updateSubmit(ActionRequest actionRequest, ActionResponse actionResponse)
	   throws IOException, PortletException, PortalException {
		log.info("Record Updating ............");
		suiluppo_course cs=suiluppo_courseLocalServiceUtil.getsuiluppo_course(new Long(ParamUtil.getString(actionRequest, "courseId")).longValue());
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		String file_Name=uploadPortletRequest.getFileName("Dispensa_corso");
		System.out.println("File Name:"+file_Name);
		if(!file_Name.equalsIgnoreCase("")){
			log.info("FIle is Updating");
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			fus.createFolder(actionRequest, themeDisplay);
			/*
			 There are three parameter
			 1. themeDisplay
			 2. actionRequest
			 3. Name of type=file control name
			 */
			String fileName=fus.fileUpload(themeDisplay, actionRequest,"Dispensa_corso");
			if(!fileName.isEmpty())
			{
				if(fileName.equalsIgnoreCase("blank")){
				log.error("File Name is Blank{"+fileName+"}");
					return;
				}else if(fileName.equalsIgnoreCase("No Extension")){
				log.error("File format is Missing..{"+fileName+"}");
					return;
				}
				log.info("Created File {"+fileName+"}");
				String downLink=fus.getFileLink(themeDisplay, fileName).get( fileName);
				log.info("Download Link {"+downLink+"}");	
				cs.setDispensa_corso(downLink);
				log.info("Now table is Updating.....");
			}
			else{
				log.error("File Is Exists");
			}
		}
		else{
			log.info("There is no file");
			log.info("Now table is Updating.....");
		}
		
			cs.setDocente(ParamUtil.getString(actionRequest, "Docente"));
			cs.setEvento_Progetto(ParamUtil.getString(actionRequest, "Evento_Progetto"));
			cs.setTitolo(ParamUtil.getString(actionRequest, "Titolo"));
			cs.setDescrizione(ParamUtil.getString(actionRequest, "Descrizione"));
			cs.setFigure_Professionali_Coinvolte(ParamUtil.getString(actionRequest, "Figure_Professionali_Coinvolte"));
			cs.setNr_Edizione(ParamUtil.getString(actionRequest, "Nr_Edizione"));
			cs.setSede(ParamUtil.getString(actionRequest, "Sede"));
			cs.setAbstract(ParamUtil.getString(actionRequest, "Abstract"));
			cs.setData_Inizio(ParamUtil.getString(actionRequest, "Data_Inizio-date")+" "+ParamUtil.getString(actionRequest, "Data_Inizio-time"));
			cs.setData_Fine(ParamUtil.getString(actionRequest, "Data_Fine-date")+" "+ParamUtil.getString(actionRequest, "Data_Fine-time"));
			//cs.setTot_Ore(ParamUtil.getString(actionRequest, "Tot_Ore-date")+" "+ParamUtil.getString(actionRequest, "Tot_Ore-time"));
			cs.setTot_Ore(ParamUtil.getString(actionRequest, "Tot_Ore"));
			cs.setScadenza_Iscrizioni(ParamUtil.getString(actionRequest, "Scadenza_Iscrizioni-date")+" "+ParamUtil.getString(actionRequest, "Scadenza_Iscrizioni-time"));
			cs.setAmmessi_al_corso(new Long(ParamUtil.getString(actionRequest, "Ammessi_al_corso")).longValue());
			cs.setBloccato(ParamUtil.getString(actionRequest, "Bloccato_data"));
			cs.setVisibile(ParamUtil.getString(actionRequest, "Visibile_data"));
			suiluppo_courseLocalServiceUtil.updatesuiluppo_course(cs);
			log.info("Now table is Updated");
		
		actionRequest.setAttribute("courseId",ParamUtil.getString(actionRequest, "courseId"));
		SessionMessages.add(actionRequest, "success");
	}
	
	
	@ProcessAction(name="addApplicant")
	 public void addApplicant(ActionRequest actionRequest, ActionResponse actionResponse)
	   throws IOException, PortletException, PortalException {
		log.info("New Applicant Adding ............");
		suiluppo_application su=suiluppo_applicationLocalServiceUtil.createsuiluppo_application(CounterLocalServiceUtil.increment());
		su.setApplicat_name(ParamUtil.getString(actionRequest, "Applicant_Name"));
		su.setApplicat_phone(ParamUtil.getString(actionRequest, "phone"));
		su.setCourse_id(new Long(ParamUtil.getString(actionRequest, "courseId")).longValue());
		su.setApplicat_email(ParamUtil.getString(actionRequest, "email"));
		suiluppo_applicationLocalServiceUtil.addsuiluppo_application(su);
		log.info("New Applicant Added");
		SessionMessages.add(actionRequest, "successApply");
	}
	@ProcessAction(name="addConfirmApplicant")
	 public void addConfirmApplicant(ActionRequest actionRequest, ActionResponse actionResponse)
	   throws IOException, PortletException, PortalException {
		log.info("Applicant Confirimg ............");
		System.out.println("ApplicantId-"+ParamUtil.getString(actionRequest, "appId"));
		log.info("Applicant Confirimed");
		
	}
	
	
	private CourseStatusChk ch=new CourseStatusChk();
	@Override
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse)throws  IOException, PortletException {
		//Updating table
		update_room_allocationTable();
		//Update Table
	String resID=resourceRequest.getResourceID();
	System.out.println(resID);
	switch(resID){
	case "checkCourseRoomBookInfo":
		log.info("Room Confirimg ............");
		String id=resourceRequest.getParameter("courseId");
		JSONObject obj=JSONFactoryUtil.createJSONObject();
		if(ch.checkAlreadCourseBooked(new Long(id).longValue())){
			obj.put("flag","ar");
			resourceResponse.getWriter().println(obj.toJSONString());
			
		} else
			try {
				if(ch.checkValid(new Long(id).longValue())){
					obj.put("flag","cv");
					resourceResponse.getWriter().println(obj.toJSONString());
				}
			} catch (NumberFormatException | PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		log.info("Room Confirimed");
		break;
	case "updateRoomBookInfo":
		log.info("Room Confirimg ............");
		try {
			if(ch.checkValid(new Long(ParamUtil.getString(resourceRequest, "courseId")).longValue())){
				resourceResponse.getWriter().print(JSONFactoryUtil.createJSONObject().put("flag", "nv").toJSONString());
				log.info("Course Is Not valid");
				return;
			}
		} catch (NumberFormatException | PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(ch.checkAlreadBooked(new Long(ParamUtil.getString(resourceRequest, "courseId")).longValue(), new Long(ParamUtil.getString(resourceRequest, "roomID")).longValue()))
		{
			resourceResponse.getWriter().print(JSONFactoryUtil.createJSONObject().put("flag", "src").toJSONString());
			log.info("Room Already Booked On same Course");
			return;
		}
		if(ch.checkAlreadBooked(new Long(ParamUtil.getString(resourceRequest, "roomID")).longValue())){
			resourceResponse.getWriter().print(JSONFactoryUtil.createJSONObject().put("flag", "oc").toJSONString());
			log.info("Room Already Booked On Other Course");
			return;
		}
		if(ch.checkAlreadCourseBooked(new Long(ParamUtil.getString(resourceRequest, "courseId")).longValue())){
			resourceResponse.getWriter().print(JSONFactoryUtil.createJSONObject().put("flag", "orc").toJSONString());
			log.info("Room Already Booked for this Course");
			return;
		}
		suiluppo_room_allocation su=suiluppo_room_allocationLocalServiceUtil.createsuiluppo_room_allocation(CounterLocalServiceUtil.increment());
		su.setRoom_allocat_status("Booked");
		su.setCourse_id(new Long(ParamUtil.getString(resourceRequest, "courseId")).longValue());
		su.setRoomID(new Long(ParamUtil.getString(resourceRequest, "roomID")).longValue());
		suiluppo_room_allocationLocalServiceUtil.updatesuiluppo_room_allocation(su);
		resourceResponse.getWriter().print(JSONFactoryUtil.createJSONObject().put("flag", "suc").toJSONString());
		log.info("Room Confirimed");
	break;
		
	}
	
	}
	public void update_room_allocationTable(){
		//Updating the course_allocation Table
		DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(suiluppo_room_allocation.class);
		userQuery.add(RestrictionsFactoryUtil.eq("room_allocat_status", "Booked"));
		List<suiluppo_room_allocation> sur=suiluppo_room_allocationLocalServiceUtil.dynamicQuery(userQuery);
		if(sur.size()>0){
			for(suiluppo_room_allocation st:sur){
			log.info(st);
			//check valid course
			try {
				if(ch.checkValid(st.getCourse_id())){
					log.info("Finding Blank Rooms......");
					if(ch.UpdateRoomAllocation(st.getRoom_allocat_id())){
						log.info("Room Updated");
					}
					
				}else{
					log.warn("room will remain booked");
				}
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		else{
			log.info("No Room Booked");
		}
		
		//Updating Course Allocation Table
	}
}