package com.demo.exception;

import com.demo.pojo.ResultCode;
import com.demo.pojo.ResultMessage;

/**
 * @ClassName: ExceptionResult 
 * @Description: 异常统一返回处理
 * @author shuyu.wang
 * @date 2017年11月23日 上午9:56:49 
 * @version V1.0
 */
public class ExceptionResult extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** Result status */
	private Integer code;
	/** Result message */
	private String message;
	public ExceptionResult() {
		this(ResultCode.SERVER_ERROR.getCode(), ResultMessage.SERVER_ERRPR.getMessage());
	}
	public ExceptionResult(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
