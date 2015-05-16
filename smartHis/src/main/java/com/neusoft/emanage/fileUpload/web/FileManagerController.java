package com.neusoft.emanage.fileUpload.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import com.neusoft.emanage.fileUpload.service.IFileUploadManagerService;
import com.neusoft.sframe.util.FileManagerUtil;
import com.neusoft.sframe.util.SysUtil;
import com.google.gson.JsonObject;

@Controller
@RequestMapping(value = "/fileManager")
public class FileManagerController {
	private static Logger log = LoggerFactory.getLogger(FileManagerController.class);
	
	@Autowired
	IFileUploadManagerService fileUploadManagerService;
	
	@RequestMapping(value = "fileUpload")
	@ResponseBody
	public String fileUpload(HttpServletRequest request, @RequestParam("imgFile") MultipartFile imgFile){
		//获取工程下的upload目录，用来保存文件
		String uploadDir = request.getRealPath("/resources/upload/");  
//		String filepathName = FileManagerUtil.autoSaveFileToDir(imgFile, uploadDir);  可以直接掉用此方法保存文件，返回文件全路径
        File dirPath = new File(uploadDir);  
        //判断目录是否存在，不存在则创建目录
        if (!dirPath.exists()) {  
            dirPath.mkdirs();  
        }
        String _suffix = FileManagerUtil.getFileSuffix(imgFile);//截取文件后缀
        //-----end---
        String suffix = FileManagerUtil.getFileDotSuffix(imgFile);//.+后缀
        //文件名以年月日yyyyMMdd+时间戳命名
        String newFileName = FileManagerUtil.getTimeStamp()+suffix;
        String result=null;
        JsonObject json =new JsonObject();
        try {
        	//将文件保存到数据库
        	Map<String, Object> param = new HashMap<String, Object>();
//        	param.put("file", imgFile.getBytes());
        	param.put("oldFileName", imgFile.getOriginalFilename());//源文件名
        	param.put("currentfilepathName", uploadDir + "\\" + newFileName);//修改后当前的文件名称
        	param.put("createTime", new Date());//当前时间
        	Map<String, Object> resultMap = fileUploadManagerService.insertFile(param,imgFile,uploadDir + "\\" + newFileName);
        	json.addProperty("success", "true");
        	json.addProperty("filePathName", (String) resultMap.get("filePathName"));
//        	json.addProperty("oldFileName", URLEncoder.encode(imgFile.getOriginalFilename()).replaceAll("\\+", "%20"));
        	json.addProperty("oldFileName", imgFile.getOriginalFilename());
        	json.addProperty("id", String.valueOf(resultMap.get("id")));
        	
		} catch (IllegalStateException e) {
			e.printStackTrace();
			json.addProperty("success", "false");
		}
        return json.toString();
	}
	@RequestMapping(value = "fileDownload")
	@ResponseBody
	public void fileDownload(Integer id, HttpServletResponse response,HttpServletRequest request){
		Map<String, Object> resultMap = fileUploadManagerService.fileDownload(id);   
		String pathName = (String) resultMap.get("currentfilepathName"); 
		File data = new File(pathName);
		String fileName = (String) resultMap.get("oldFileName");   
		try {
//			fileName = SysUtil.ajaxFileTextEncoding(fileName, request);
			fileName = URLEncoder.encode(fileName, "UTF-8");
			response.reset();   
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");   
			response.addHeader("Content-Length", "" + data.length());   
			response.setContentType("application/octet-stream;charset=UTF-8");   
			OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());   
			InputStream inputStream = new FileInputStream(data);
			byte[] buffer = new byte[1024];
			int i = -1;
			while ((i = inputStream.read(buffer)) != -1) {
			    outputStream.write(buffer, 0, i);
			}
			
			outputStream.flush();   
			outputStream.close(); 
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	}
	@RequestMapping(value = "fileDownloadFormBlob")
	@ResponseBody
	public void fileDownloadFormBlob(Integer id, HttpServletResponse response,HttpServletRequest request){
		Map<String, Object> resultMap = fileUploadManagerService.fileDownload(id);   
		byte[] data = (byte[]) resultMap.get("file");   
		String fileName = (String) resultMap.get("oldFileName");   
		try {
			fileName = SysUtil.ajaxFileTextEncoding(fileName, request);
			response.reset();   
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");   
			response.addHeader("Content-Length", "" + data.length);   
			response.setContentType("application/octet-stream;charset=UTF-8");   
			OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());   
			outputStream.write(data);   
			outputStream.flush();   
			outputStream.close(); 
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	}
	@RequestMapping(value = "fileDelete")
	@ResponseBody
	public String fileDelete(Integer id){
		boolean b = fileUploadManagerService.fileDelete(id);  
		return String.valueOf(b);
	}
	@RequestMapping(value = "fileQueryByIds")
	@ResponseBody
	public List<Map<String, Object>> fileQueryByIds(String ids){
		List<Integer> paramsids = new ArrayList<Integer>();
		if(ids==null){
			return new ArrayList<Map<String,Object>>();
		}else{
			String[] idsArray = ids.split(",");
			for (int i = 0; i < idsArray.length; i++) {
				if(idsArray[i]!=null&&!"".equals(idsArray[i])){
					Integer id = Integer.valueOf(idsArray[i]);
					paramsids.add(id);
				}
			}
		}
		return fileUploadManagerService.fileQueryByIds(paramsids);  
//		return String.valueOf(b);
	}
	
}