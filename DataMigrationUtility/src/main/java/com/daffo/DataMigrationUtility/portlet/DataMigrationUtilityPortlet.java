package com.daffo.DataMigrationUtility.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

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
		"com.liferay.portlet.display-category=Naveen Apps",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DataMigrationUtility Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DataMigrationUtilityPortlet extends MVCPortlet {
	private Log logger=LogFactoryUtil.getLog("DataMigrationUtility");
	
	@ProcessAction(name="fileUploadAction")
	public void fileUploadAction(ActionRequest actionRequest,ActionResponse actionResponse)throws IOException, PortletException, PortalException{
	
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse)throws  IOException, PortletException {
	String resourceId=resourceRequest.getResourceID();
	switch (resourceId) {
	case "fetchDocumentType":
		System.out.print("Ressource");
		break;

	default:
		break;
	}
	}
	
}