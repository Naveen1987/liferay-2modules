package com.daffo.form_di_segnalazione.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Administrator
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Naveen Apps-UnitaOperative",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.add-process-action-success-action=false",
		"javax.portlet.display-name=Form_di_segnalazione Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class Form_di_segnalazionePortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
				super.doView(renderRequest, renderResponse);
	}
	@ProcessAction(name="formSubmit")
	 public void formSubmit(ActionRequest actionRequest, ActionResponse actionResponse)
	   throws IOException, PortletException {
		/*System.out.println("I got It");
	    System.out.println("I am "+ParamUtil.getString(actionRequest, "DATA_2"));
        System.out.println("I am "+ParamUtil.getString(actionRequest, "SESSO_3"));
        System.out.println("I am "+ParamUtil.getString(actionRequest, "DATA_4"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "ORIGINE_5"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "DESCRIZIONE_6"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "INDICARE_7_1"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "INDICARE_7_2"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "INDICARE_7_3"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "INDICARE_7_4"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "INDICARE_7_5"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "INDICARE_7_6"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "INDICARE_7_7"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "GRAVITA_8_1"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "GRAVITA_8_2"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "GRAVITA_8_3"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "GRAVITA_8_4"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "GRAVITA_8_5"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "GRAVITA_8_6"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "GRAVITA_8_7"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "EVENTUALI_9"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "ESITO_10"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "ESITO_10_1"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "ESITO_10_2"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "ESITO_10_3"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "ESITO_10_4"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "ESITO_10_5"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "ESITO_10_6"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "ESITO_10_7"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "ESITO_10_8"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "ESITO_10_9"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "ESITO_10_10"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "AZIONI_11"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_12_a"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_12_a_13"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_12_a_14"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_12_a_15"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_12_a_16_1"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_12_a_16_2"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_12_a_17"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_12_a_18"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_12_a_19"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_12_a_20"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_12_b"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_12_b_13"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_12_b_14"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_12_b_15"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_12_b_16_1"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_12_b_16_2"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_12_b_17"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_12_b_18"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_12_b_19"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_12_b_20"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_12_c"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_12_c_13"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_12_c_14"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_12_c_15"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_12_c_16_1"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_12_c_16_2"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_12_c_17"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_12_c_18"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_12_c_19"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_12_c_20"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "INDICAZIONI_21_a"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "INDICAZIONI_21_b"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "INDICAZIONI_21_c"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_22_a"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_22_a_23"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_22_a_24"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_22_a_25"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_22_a_26_1"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_22_a_26_2"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_22_a_27"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_22_a_28"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_22_a_29"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_22_a_30"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_22_b"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_22_b_23"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_22_b_24"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_22_b_25"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_22_b_26_1"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_22_b_26_2"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_22_b_27"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_22_b_28"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_22_b_29"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "FARMACO_22_b_30"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "INDICAZIONI_31_a"));
System.out.println("I am "+ParamUtil.getString(actionRequest, "INDICAZIONI_31_b"));
		*/
}
}