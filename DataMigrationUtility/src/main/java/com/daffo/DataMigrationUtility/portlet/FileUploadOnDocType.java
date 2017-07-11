package com.daffo.DataMigrationUtility.portlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;
import javax.portlet.ActionRequest;
import com.liferay.document.library.kernel.model.DLFileEntryType;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryTypeLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.FileItem;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.dynamic.data.mapping.storage.Field;
import com.liferay.dynamic.data.mapping.storage.Fields;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;

public class FileUploadOnDocType {
private final Log logger=LogFactoryUtil.getLog("FileUploadOnDocumentType");
public boolean uploadInfo(ThemeDisplay themeDisplay, String folderId,String folderName,	String docId,String docName,UploadPortletRequest uploadPortletRequest, ActionRequest actionRequest) throws NumberFormatException, PortalException, IOException{
	//System.out.println("Folder Info:-"+folderId+" "+folderName);
	//System.out.println("Documenet Type Info:-"+docId+" "+docName);
	logger.info("{ Folder Info:-"+folderId+" "+folderName+" }");
	logger.info("{ Documenet Type Info:-"+docId+" "+docName+" }");
	DDMStructure ddm=DDMStructureLocalServiceUtil.getDDMStructure(new Long(docId).longValue());
	Set<String> fieldsName=null;
	if(ddm.getNameCurrentValue().equalsIgnoreCase(docName)){
		logger.info("{ Documenet Type Confirmation - Ok } ");
		fieldsName=ddm.getFieldNames();
		logger.info("{ Documenet Type Fields-"+fieldsName+" } ");
	}
	Folder folder=DLAppServiceUtil.getFolder(new Long(folderId).longValue());
	if(folder.getName().equalsIgnoreCase(folderName)){
		logger.info("{ Folder Name Confirmation - Ok }");
	}
	
	Map<String, FileItem[]> files= uploadPortletRequest.getMultipartParameterMap();
	for (Entry<String, FileItem[]> file2 : files.entrySet()) {
		FileItem item[] =file2.getValue();
			for (FileItem fileItem : item) {
				Fields fields=new Fields();
				String fileNameW=fileItem.getFileName();
				if (fileNameW.indexOf(".") > 0){
					fileNameW = fileNameW.substring(0, fileNameW.lastIndexOf("."));
			     }
				String a[]=fileNameW.split(Pattern.quote("@"));
				for(String sname:fieldsName){
					if(sname.equalsIgnoreCase("COD")){
						Field f=new Field(ddm.getStructureId(), "COD", a[0]);
						fields.put(f);
						
					}
					else if(sname.equalsIgnoreCase("Titolo")){
						Field f=new Field(ddm.getStructureId(), "Titolo", a[1]);
						fields.put(f);
					}
					else if(sname.equalsIgnoreCase("REV")){
						Field f=new Field(ddm.getStructureId(), "REV", a[2]);
						fields.put(f);
						
					}
					else if(sname.equalsIgnoreCase("Lingua")){
						Field f=new Field(ddm.getStructureId(), "Lingua", "IT");
						fields.put(f);
					}
					else if(sname.equalsIgnoreCase("Dimensione")){}
					else if(sname.equalsIgnoreCase("Spec")){}
					else if(sname.equalsIgnoreCase("Applicativo")){}
					else if(sname.equalsIgnoreCase("Anno")){}
					else if(sname.equalsIgnoreCase("Sede")){}
					else if(sname.equalsIgnoreCase("Unit� Organizzativa")){}
					else if(sname.equalsIgnoreCase("Dipartimento")){}
					else if(sname.equalsIgnoreCase("Numero")){}
					else if(sname.equalsIgnoreCase("Modulo")){}
					
					
				}
				logger.info("{ File Name-"+fileItem.getFileName()+" }");
				for(Field f:fields){
					logger.info("Value Mapped {"+f.getName()+"="+f.getValue()+"}");
				}
				

				
				DLFolder dlFolder = DLFolderLocalServiceUtil.getFolder(new Long(folderId).longValue());
		        long fileEntryTypeId = dlFolder.getDefaultFileEntryTypeId();
		        System.out.println("fileEntryTypeId:-"+fileEntryTypeId);
//		        long userId = themeDisplay.getUserId();
//				long groupId = themeDisplay.getScopeGroupId();
				long repositoryId = themeDisplay.getScopeGroupId();				
				String title = fileItem.getFileName();
				String description = title +" is added via programatically";
				String mimeType = fileItem.getContentType();	
				File file = fileItem.getStoreLocation();
				System.out.println(file.getName());
				System.out.println(file.length());
				String changeLog = "This is By Prgram";
					DLFileEntryType sp=null;
					try{
					List<DLFileEntryType> dlFileEntryTypes =DLFileEntryTypeLocalServiceUtil.getFileEntryTypes(ddm.getStructureId());
					if(!dlFileEntryTypes.isEmpty()){
						sp=dlFileEntryTypes.get(0);
					}
					}catch(Exception ex){
						System.out.println("No structure Is here please Recreate your type if exists because It is not valid Document Type");
						return false;
					}
//					if(sp==null){
//						System.out.println("Not file Entry type Exits means not valid document type ");
//						Map<Locale, String> nameMap = new HashMap<>();
//						nameMap.put(LocaleUtil.getDefault(), "SITRA");
//						Map<Locale, String> descriptionMap = new HashMap<>();			
//						ServiceContext serviceContext = new ServiceContext();
//						serviceContext.setAddGuestPermissions(true);
//						serviceContext.setAddGroupPermissions(true);
//						serviceContext.setScopeGroupId(themeDisplay.getScopeGroupId());
//						serviceContext.setUserId(themeDisplay.getDefaultUserId());
//
//						sp= DLFileEntryTypeLocalServiceUtil.addFileEntryType(
//							themeDisplay.getDefaultUserId(), themeDisplay.getScopeGroupId(),
//							"SITRA", nameMap, descriptionMap,
//							new long[] {ddm.getStructureId()}, serviceContext);
//						System.out.println("Now created valid and -"+sp.getFileEntryTypeId());
//					}
					InputStream is =fileItem.getInputStream();
					System.out.println(is.available());
					ServiceContext serviceContext = new ServiceContext();
					serviceContext.setAddGuestPermissions(true);
					serviceContext.setAddGroupPermissions(true);
					serviceContext.setScopeGroupId(themeDisplay.getScopeGroupId());
					serviceContext.setUserId(themeDisplay.getDefaultUserId());
					serviceContext.setAttribute("fileEntryTypeId", sp.getFileEntryTypeId());
					serviceContext.setAttribute(ddm.getStructureId()+"COD", fields.get("COD").getValue(themeDisplay.getLocale()));
					serviceContext.setAttribute(ddm.getStructureId()+"Titolo", fields.get("Titolo").getValue(themeDisplay.getLocale()));
					serviceContext.setAttribute(ddm.getStructureId()+"REV", fields.get("REV").getValue(themeDisplay.getLocale()));
					serviceContext.setAttribute(ddm.getStructureId()+"Lingua", fields.get("Lingua").getValue(themeDisplay.getLocale()));
				    DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(),repositoryId, folder.getFolderId(), title, mimeType, 
							title, description, changeLog, is, file.getTotalSpace(), serviceContext);	    
			
			}	
				/*Hello Adding*/
			
	}	
	return true;
}

}