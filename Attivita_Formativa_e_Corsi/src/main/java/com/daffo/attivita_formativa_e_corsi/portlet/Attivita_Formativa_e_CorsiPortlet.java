package com.daffo.attivita_formativa_e_corsi.portlet;


import com.daffo.suilupposervice.model.suiluppo_application;
import com.daffo.suilupposervice.model.suiluppo_course;
import com.daffo.suilupposervice.service.suiluppo_applicationLocalServiceUtil;
import com.daffo.suilupposervice.service.suiluppo_courseLocalServiceUtil;
import com.daffo.suilupposervice.service.base.suiluppo_applicationLocalServiceBaseImpl;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
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

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;

import org.omg.CORBA.Request;
import org.osgi.service.component.annotations.Component;

/**
 * @author Administrator
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Naveen Apps-UnitaOperative",
		"javax.portlet.init-param.add-process-action-success-action=false",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Attivita_Formativa_e_Corsi",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class Attivita_Formativa_e_CorsiPortlet extends MVCPortlet {
	
	private final static Log log=LogFactoryUtil.getLog(Attivita_Formativa_e_CorsiPortlet.class);
	
	
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
				/*System.out.println("courseId-"+ParamUtil.getString(actionRequest, "courseId"));
				System.out.println("Applicant Name-"+ParamUtil.getString(actionRequest, "Applicant_Name"));
				System.out.println("Email-"+ParamUtil.getString(actionRequest, "email"));
				System.out.println("Phone-"+ParamUtil.getString(actionRequest, "phone"));*/
		suiluppo_application su=suiluppo_applicationLocalServiceUtil.createsuiluppo_application(CounterLocalServiceUtil.increment());
		su.setApplicat_name(ParamUtil.getString(actionRequest, "Applicant_Name"));
		su.setApplicat_phone(ParamUtil.getString(actionRequest, "phone"));
		su.setCourse_id(new Long(ParamUtil.getString(actionRequest, "courseId")).longValue());
		su.setApplicat_email(ParamUtil.getString(actionRequest, "email"));
		suiluppo_applicationLocalServiceUtil.addsuiluppo_application(su);
		log.info("New Applicant Added");
		SessionMessages.add(actionRequest, "successApply");
	}

}