package com.demo.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class PropertiesRead {
	
	
	private static String ip;
	private static Integer port;
	private static String password;
	private static Integer maxActive;
	private static Integer maxIdle;
	private static Long maxWait;
	private static Boolean testOnBorrow;
	private static Boolean testOnReturn;
	private static Integer expire;
	private static Integer maxTotal;
	static  {  
		Properties prop =  new  Properties();  
        String configFile = "config/redis.properties";  
        //以URL形式获取工程的资源文件 classpath 路径, 得到以file:/为开头的URL  
        //例如返回: file:/D:/workspace/myproject01/WEB-INF/classes/   
        URL classPath = Thread.currentThread().getContextClassLoader().getResource("");  
        String proFilePath = classPath.toString();  
          
        //移除开通的file:/六个字符  
        proFilePath = proFilePath.substring(6);   
          
        //如果为window系统下,则把路径中的路径分隔符替换为window系统的文件路径分隔符  
        proFilePath = proFilePath.replace("/", java.io.File.separator);  
          
        //兼容处理最后一个字符是否为 window系统的文件路径分隔符,同时建立 properties 文件路径  
        //例如返回: D:\workspace\myproject01\WEB-INF\classes\config.properties  
        if(!proFilePath.endsWith(java.io.File.separator)){  
            proFilePath = proFilePath + java.io.File.separator + configFile;  
        } else {  
            proFilePath = proFilePath + configFile;  
        }  
       
        //以文件流形式读取指定路径的配置文件 config.properties   
        FileInputStream ins=null;
		try {
			ins = new FileInputStream(proFilePath);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
         try  {  
            prop.load(ins);  
            ip = prop.getProperty( "redis.ip" ).trim();  
            port =Integer.valueOf(prop.getProperty( "redis.port" ).trim()) ;
//            password=prop.getProperty( "redis.password" ).trim(); 
            maxActive =Integer.valueOf(prop.getProperty( "redis.maxActive" ).trim()) ;
            maxTotal =Integer.valueOf(prop.getProperty( "redis.maxTotal" ).trim()) ;
            maxWait =Long.parseLong(prop.getProperty( "redis.maxWait" ).trim()) ;
            maxIdle =Integer.valueOf(prop.getProperty( "redis.maxIdle" ).trim()) ;
            expire =Integer.valueOf(prop.getProperty( "redis.expire" ).trim()) ;
            testOnBorrow =Boolean.getBoolean(prop.getProperty( "redis.testOnBorrow" ).trim()) ;
            testOnReturn =Boolean.getBoolean(prop.getProperty( "redis.testOnReturn" ).trim()) ;
        }  catch  (IOException e) {  
            e.printStackTrace();  
        }  
    }
	public String getIp() {
		return ip;
	}
	public Integer getPort() {
		return port;
	}
	public String getPassword() {
		return password;
	}
	public Integer getMaxActive() {
		return maxActive;
	}
	public Integer getMaxIdle() {
		return maxIdle;
	}
	public Long getMaxWait() {
		return maxWait;
	}
	public Boolean getTestOnBorrow() {
		return testOnBorrow;
	}
	public Boolean getTestOnReturn() {
		return testOnReturn;
	}
	public Integer getExpire() {
		return expire;
	}
	public Integer getMaxTotal() {
		return maxTotal;
	}
	
	
	

}
