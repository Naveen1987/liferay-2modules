package com.daffo.DataMigrationUtility.portlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.dynamic.data.mapping.kernel.DDMForm;
import com.liferay.dynamic.data.mapping.kernel.DDMFormField;
import com.liferay.dynamic.data.mapping.kernel.DDMFormValues;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.FileItem;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.dynamic.data.mapping.storage.Field;
import com.liferay.dynamic.data.mapping.storage.Fields;
import com.liferay.dynamic.data.mapping.util.DDMFormFactory;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;

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
					else if(sname.equalsIgnoreCase("Unità Organizzativa")){}
					else if(sname.equalsIgnoreCase("Dipartimento")){}
					else if(sname.equalsIgnoreCase("Numero")){}
					else if(sname.equalsIgnoreCase("Modulo")){}
					
					
				}
				logger.info("{ File Name-"+fileItem.getFileName()+" }");
				for(Field f:fields){
					logger.info("Value Mapped {"+f.getName()+"="+f.getValue()+"}");
				}
				

				ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
				DLFolder dlFolder = DLFolderLocalServiceUtil.getFolder(new Long(folderId).longValue());
		        long fileEntryTypeId = dlFolder.getDefaultFileEntryTypeId();
		        long userId = themeDisplay.getUserId();
				long groupId = themeDisplay.getScopeGroupId();
				long repositoryId = themeDisplay.getScopeGroupId();				
				String title = fileItem.getFileName();
				String description = title +" is added via programatically";
				String mimeType = fileItem.getContentType();	
				File file = fileItem.getStoreLocation();
				String changeLog = "This is By Prgram";
				Map<String, Fields> fieldsMap = new HashMap<String, Fields>();
				fieldsMap.put(ddm.getStructureKey(), fields); 
				InputStream is =fileItem.getInputStream();
//				try {
//			    	
//			    	DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), title, mimeType, 
//								title, description, "", is, file.getTotalSpace(), serviceContext);	
//					logger.info("{ "+title+" } -Done"); 
//			    	} catch (SystemException e) {
//			    		logger.error(e);
//						is.close();
//					 }
//			    	finally {
//			    		is.close();
//					}
				DLFileEntry dlFileEntry=null;
				
				dlFileEntry = DLFileEntryLocalServiceUtil.addFileEntry(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
						themeDisplay.getScopeGroupId(), folder.getFolderId(),title, mimeType, title, StringPool.BLANK, StringPool.BLANK, 
						dlFolder.getDefaultFileEntryTypeId(),fieldsMap, file, null, file.length(), serviceContext);
					
				
				DLFileEntryLocalServiceUtil.updateFileEntry(folder.getUserId(), dlFileEntry.getFileEntryId(), file.getName(), mimeType,
				  title, description, "Draft to save",true, dlFileEntry.getFileEntryTypeId(), fieldsMap, file, is, 
				  file.getTotalSpace(), serviceContext);
			
			
				
			}
		
				/*Hello Adding*/
			
				

	}

	return true;
}
}
