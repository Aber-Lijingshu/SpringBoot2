package com.demo.pojo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @ClassName: ApiResult 
 * @Description: api 统一返回参数
 * @author shuyu.wang
 * @date 2017年11月22日 下午10:07:31 
 * @version V1.0
 */
public class ApiResult {
	private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	/** Result status */
	private Integer code;
	/** Result message */
	private String message;
	/** Total item size */
	private Long total;
	/** Current page number */
	private Integer pageCurrent;
	/** Result data */
	private Object data;

	public ApiResult() {
		this(ResultCode.DEF_ERROR.getCode(), ResultMessage.DEF_ERROR.getMessage(), null, null);
	}

	public ApiResult(Integer code, String message, Object data, PageEntity pageEntity) {
		this.code = code;
		this.message = message;
		this.data = data;
		if (pageEntity != null) {
			this.pageCurrent = pageEntity.getCurrentPage();
			this.total = pageEntity.getTotalcount();
		}
	}

	public ApiResult(ResultCode code, String message, Object data, PageEntity pageEntity) {
		this(code.getCode(), message, data, pageEntity);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(ResultCode code) {
		this.code = code.getCode();
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(ResultMessage message) {
		this.message = message.getMessage();
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Integer getPageCurrent() {
		return pageCurrent;
	}

	public void setPageCurrent(Integer pageCurrent) {
		this.pageCurrent = pageCurrent;
	}

	public void setPageEntity(PageEntity pageEntity) {
		if (pageEntity != null) {
			this.pageCurrent = pageEntity.getCurrentPage();
			this.total = pageEntity.getTotalcount();
		}
	}

	public void setSuccess() {
		this.setCode(ResultCode.SUCCESS);
		this.setMessage(ResultMessage.DEF_SUCCESS.getMessage());
	}
	
	
	public String toJSON() {
		return GSON.toJson(this);
	}
}
