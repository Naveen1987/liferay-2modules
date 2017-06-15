package com.daffo.attivita_formativa_e_corsi.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;

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
	@ProcessAction(name="formSubmit")
	 public void formSubmit(ActionRequest actionRequest, ActionResponse actionResponse)
	   throws IOException, PortletException, PortalException {
		System.out.println("Docente-"+ParamUtil.getString(actionRequest, "Docente"));
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
		System.out.println("Tot_Ore-date-"+ParamUtil.getString(actionRequest, "Tot_Ore-date"));
		System.out.println("Tot_Ore-time-"+ParamUtil.getString(actionRequest, "Tot_Ore-time"));
		System.out.println("Scadenza_Iscrizioni-date-"+ParamUtil.getString(actionRequest, "Scadenza_Iscrizioni-date"));
		System.out.println("Scadenza_Iscrizioni-time-"+ParamUtil.getString(actionRequest, "Scadenza_Iscrizioni-time"));
		System.out.println("Ammessi_al_corso-"+ParamUtil.getString(actionRequest, "Ammessi_al_corso"));
		System.out.println("Visibile-"+ParamUtil.getString(actionRequest, "Visibile_data"));
		System.out.println("Bloccato-"+ParamUtil.getString(actionRequest, "Bloccato_data"));
		System.out.println("Dispensa_corso-"+ParamUtil.getString(actionRequest, "Dispensa_corso"));
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		long sizeInBytes = uploadRequest.getSize("One");
		System.out.println(sizeInBytes);
		
	}

}