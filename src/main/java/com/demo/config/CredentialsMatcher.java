package com.demo.config;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * @ClassName: CredentialsMatcher 
 * @Description: 自定义密码比较器
 * @author shuyu.wang
 * @date 2017年11月24日 下午5:15:39 
 * @version V1.0
 */
public class CredentialsMatcher extends SimpleCredentialsMatcher{
	
	 @Override
	    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
	        UsernamePasswordToken utoken=(UsernamePasswordToken) token;
	        //获得用户输入的密码:(可以采用加盐(salt)的方式去检验)
	        String inPassword = new String(utoken.getPassword());
	        //获得数据库中的密码
	        String dbPassword=(String) info.getCredentials();
	        //进行密码的比对
	        return this.equals(inPassword, dbPassword);
	    }

}
