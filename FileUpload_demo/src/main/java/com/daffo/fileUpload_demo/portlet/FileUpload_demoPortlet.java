package com.daffo.fileUpload_demo.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;


/**
 * @author Administrator
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Naveen Apps",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=FileUpload_demo Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class FileUpload_demoPortlet extends MVCPortlet {
	
	FileUpload_ServiceClass fus=new FileUpload_ServiceClass();
	public void uploadDocument(ActionRequest actionRequest,ActionResponse actionResponse) throws IOException,PortletException, PortalException, SystemException 
	{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		fus.createFolder(actionRequest, themeDisplay);
		fus.fileUpload(themeDisplay, actionRequest);
	}

	public void downloadFiles(ActionRequest actionRequest,ActionResponse actionResponse) throws IOException,PortletException, PortalException, SystemException 
	{
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		 Map<String,String> urlMap = fus.getAllFileLink(themeDisplay);
		  actionRequest.setAttribute("urlMap", urlMap);
		  actionResponse.setRenderParameter("jspPage","/download.jsp");
	}
	public void Particuler(ActionRequest actionRequest,ActionResponse actionResponse) throws IOException,PortletException, PortalException, SystemException 
	{
		 String filename=ParamUtil.getString(actionRequest, "uploadedFile");
		 System.out.println(filename+"-From");
		 ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		  Map<String,String> urlMap = fus.getFileLink(themeDisplay,filename);
		  actionRequest.setAttribute("urlOnly", urlMap);
		  actionResponse.setRenderParameter("jspPage","/Particuler.jsp");
	}
}