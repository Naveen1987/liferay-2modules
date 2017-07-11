package com.daffo.DataMigrationUtility_New.portlet;

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
				String fileNameW=fileItem.getFileName();
				try{
					if (fileNameW.indexOf(".") > 0){
						fileNameW = fileNameW.substring(0, fileNameW.lastIndexOf("."));
				     }
					//Value Extration from file name
					String val[]=fileNameW.split(Pattern.quote("@"));
					//getting attribute of Document Type
					String typeName[]=new ListOfDocType().getDocType(folderName).split(Pattern.quote(","));
					//Val to type mapping
					Fields fields=new Fields();
					for(int i=0;i<val.length;i++){
						Field f=new Field(ddm.getStructureId(), typeName[i], val[i]);
						fields.put(f);	
					}
					if(typeName.length>val.length){
						int i=val.length;
						while(i<typeName.length){
							if(typeName[i].equalsIgnoreCase("Lingua"))
							{
								Field f=new Field(ddm.getStructureId(), typeName[i], "IT");
								fields.put(f);
							}
							else{
								Field f=new Field(ddm.getStructureId(), typeName[i], "-empty-");
								fields.put(f);
							}
							i++;
						}
					}
					logger.info("{ File Name-"+fileItem.getFileName()+" }");
//			        long userId = themeDisplay.getUserId();
//					long groupId = themeDisplay.getScopeGroupId();
					long repositoryId = themeDisplay.getScopeGroupId();				
					String title = fileItem.getFileName();
					String description = title +" is added via programatically";
					String mimeType = fileItem.getContentType();	
					File file = fileItem.getStoreLocation();
					System.out.println(file.getName());
					System.out.println(file.length());
					String changeLog = "This is By Program";
						DLFileEntryType sp=null;
						try{
						List<DLFileEntryType> dlFileEntryTypes =DLFileEntryTypeLocalServiceUtil.getFileEntryTypes(ddm.getStructureId());
						if(!dlFileEntryTypes.isEmpty()){
							sp=dlFileEntryTypes.get(0);
						}
						}catch(Exception ex){
							logger.error("No Document Type {"+ddm.getName()+"} validation failed. Please Recreate your Document type");
							return false;
						}

						InputStream is =fileItem.getInputStream();
						System.out.println(is.available());
						ServiceContext serviceContext = new ServiceContext();
						serviceContext.setAddGuestPermissions(true);
						serviceContext.setAddGroupPermissions(true);
						serviceContext.setScopeGroupId(themeDisplay.getScopeGroupId());
						serviceContext.setUserId(themeDisplay.getDefaultUserId());
						serviceContext.setAttribute("fileEntryTypeId", sp.getFileEntryTypeId());
						//Uploading metaData of File
						for(Field f:fields){
							String fieldName=""+ddm.getStructureId()+f.getName();
							serviceContext.setAttribute(fieldName, f.getValue(themeDisplay.getLocale()));
							logger.info("Value Mapped {"+f.getName()+"="+f.getValue(themeDisplay.getLocale())+"}");
						}
					    DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(),repositoryId, folder.getFolderId(), title, mimeType, 
								title, description, changeLog, is, file.getTotalSpace(), serviceContext);
					    logger.info("File is Successfully Uploaded-{"+title+"}");
					
				}catch (Exception e) {
					logger.error(fileNameW+" Not Uploaded and Error Description "+e.getMessage());
				}
			}		
			
	}	
	return true;
}

}