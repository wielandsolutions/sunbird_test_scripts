package org.sunbird.generic;

import org.sunbird.startup.IAutoConst;

public class AllUploadingPaths implements IAutoConst
{ 
	 public static String h5pPath = System.getProperty("user.dir")+"\\uploadingDocuments\\upload Document Contents\\"+UPLOAD_H5P;
	 public static String pdfPath = System.getProperty("user.dir")+"\\uploadingDocuments\\upload Document Contents\\"+UPLOAD_PDF;
	 public static String mp4Path = System.getProperty("user.dir")+"\\uploadingDocuments\\uploading videos\\"+UPLOAD_MP4;
	 public static String webmPath = System.getProperty("user.dir")+"\\uploadingDocuments\\uploading videos\\"+UPLOAD_WEBM;
	 public static String htmlPath = System.getProperty("user.dir")+"\\uploadingDocuments\\upload Document Contents\\"+UPLOAD_HTML;
	 public static String epubPath = System.getProperty("user.dir")+"\\uploadingDocuments\\upload Document Contents\\"+UPLOAD_EPUB;
	 public static String rootOrgPath = System.getProperty("user.dir")+"\\uploadingDocuments\\"+UPLOAD_ROOT_ORG;
	 public static String subOrgPath = System.getProperty("user.dir")+"\\uploadingDocuments\\"+UPLOAD_SUB_ORG;
	 public static String rootOrgUserPath = System.getProperty("user.dir")+"\\uploadingDocuments\\"+UPLOAD_USERS_ROOT_ORG;
	 public static String subOrgUserPath = System.getProperty("user.dir")+"\\uploadingDocuments\\"+UPLOAD_USERS_SUB_ORG;
	 public static String profilePicturePath = System.getProperty("user.dir")+"\\uploadingDocuments\\upload Document Contents\\"+UPLOAD_PROFILE_PIC;
	 public static String audioPath = System.getProperty("user.dir")+"\\uploadingDocuments\\uploading audios\\"+AUDIO_UPLOAD;
		
}
