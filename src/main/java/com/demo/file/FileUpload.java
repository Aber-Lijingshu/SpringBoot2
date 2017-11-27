package com.demo.file;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.demo.utils.FileUtil;

@Controller
public class FileUpload {
	/**
	 * 文件上传具体实现方法;
	 * 
	 * @param file
	 * @return
	 */
	@RequestMapping("/upload")
	@ResponseBody
	public String handleFileUpload(@RequestParam("file") MultipartFile file,HttpServletRequest request) {
		if (!file.isEmpty()) {
			try {
				if (file.getSize() == 0) {
//					return renderOther(403, null, "图片不能为空");
				}
				long maxSize = 100000000;
				long fileSize = file.getSize();
				String fileName = file.getOriginalFilename();
				String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
				if (fileSize > maxSize) {
					// 100M
//					return renderOther(403, null, "上传文件尺寸过大！");
				}
				/*
				 * 这段代码执行完毕之后，图片上传到了工程的跟路径； 大家自己扩散下思维，如果我们想把图片上传到 d:/files大家是否能实现呢？ 等等;
				 * 这里只是简单一个例子,请自行参考，融入到实际中可能需要大家自己做一些思考，比如： 1、文件路径； 2、文件名； 3、文件格式; 4、文件大小的限制;
				 */
				BufferedOutputStream out = new BufferedOutputStream(
						new FileOutputStream(new File(file.getOriginalFilename())));
				out.write(file.getBytes());
				out.flush();
				out.close();
				
				
				
				// 此时图片可以上传了。
				String key = null;
				// 原图上传
				// InputStream reader = file.getInputStream();
				// key = getLocalKey(request,path,file, fileExt);
				key = getLocalFileKey(request,  file, fileExt);
				if (key != null) {
//					return renderOther(200, key, "上传成功！");
				} else {
					// pic为空
//					return renderOther(403, key, "上传失败，请重试！");
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return "上传失败," + e.getMessage();
			} catch (IOException e) {
				e.printStackTrace();
				return "上传失败," + e.getMessage();
			}
			return "上传成功";
		} else {
			return "上传失败，因为文件是空的.";
		}
	}

	/**
	 * 多文件具体上传时间，主要是使用了MultipartHttpServletRequest和MultipartFile
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/batch/upload", method = RequestMethod.POST)
	public @ResponseBody String handleFileUpload(HttpServletRequest request) {
		List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
		MultipartFile file = null;
		BufferedOutputStream stream = null;
		for (int i = 0; i < files.size(); ++i) {
			file = files.get(i);
			if (!file.isEmpty()) {
				try {
					byte[] bytes = file.getBytes();
					stream = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
					stream.write(bytes);
					stream.close();
				} catch (Exception e) {
					stream = null;
					return "You failed to upload " + i + " =>" + e.getMessage();
				}
			} else {
				return "You failed to upload " + i + " becausethe file was empty.";
			}
		}
		return "upload successful";
	}
	
	
	/** 
	* @Title: getLocalFileKey 
	* @Description:获取文件存储路径
	* @param request
	* @param file
	* @param suffix
	* @return String 
	* @throws 
	*/
	private String getLocalFileKey(HttpServletRequest request, MultipartFile file, String suffix) {
		// 上传文件路径，返回的文件url
		String url = null;
		// flag为是否存本地，true存本地，false存阿里云（接通后只存阿里云）
		boolean flag = true;
		if (flag) {// 保存本地
			// 存本地
			String savePath = request.getSession().getServletContext().getRealPath("/");
			String path2 = request.getContextPath();
			System.out.println("savePath"+savePath.substring(0,savePath.length()-1));
			System.out.println("path2"+path2.substring(1, path2.length()));
		        String tomcatWebApps =savePath.substring(0,savePath.length()-1).replace(path2.substring(1, path2.length()), "");
		        System.out.println("tomcatWebApps"+tomcatWebApps);
			
				savePath = tomcatWebApps + "fileupload"+ File.separator + "default";
			
			FileUtil.directoryIsExist(savePath);
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			// 文件名加后缀
			String fileName = file.getOriginalFilename();
			// 文件名
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
			String newFileName = fileName + "_" + df.format(new Date()) + "_" + new Random().nextInt(1000)+ "." + suffix;
			try {
				File uploadedFile = new File(savePath, newFileName);
				
					url = "default" +File.separator + newFileName;
				
				System.out.println("返回的url:" + url);
				file.transferTo(uploadedFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {// 上传到阿里云服务器上
			// 原图上传
//			InputStream reader = file.getInputStream();
//			String fileName = file.getOriginalFilename();
//			String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
//			String key = getKey(reader, fileExt);
		}
		return url;
	}

}
