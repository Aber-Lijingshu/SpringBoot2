package com.demo.utils;

import java.io.File;
import java.io.IOException;

public class FileUtil {
	/**
	 * 判断文件是否存在，不存在创建文件
	 * @param path    C:\\Users\\QPING\\Desktop\\JavaScript\\2.htm
	 */
	public static void fileIsExist(String path){
		File file=new File(path);    
		if(!file.exists()){    
		    try {    
		        file.createNewFile();    
		    } catch (IOException e) {    
		        e.printStackTrace();    
		    }    
		}else{
			//删除文件
			file.delete();
		}    
	}
	/**
	 * 判断文件夹是否存在，不存在创建文件夹
	 * @param path   C:\\Users\\QPING\\Desktop\\JavaScript 
	 */
	public static void directoryIsExist(String path){
		File file =new File(path);    
		//如果文件夹不存在则创建    
		if  (!file .exists()  && !file .isDirectory()){       
		    System.out.println("//目录不存在");  
		    file .mkdirs();    
		} else {  
		    System.out.println("//目录存在");  
		}  
	}
}
