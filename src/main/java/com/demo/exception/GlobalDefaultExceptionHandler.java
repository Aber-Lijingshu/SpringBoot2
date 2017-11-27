package com.demo.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.demo.pojo.ResultCode;
import com.demo.pojo.ResultMessage;

/**
 * @ClassName: GlobalDefaultExceptionHandler
 * @Description: 异常集中处理，更好的使业务逻辑与异常处理剥离开
 * @author shuyu.wang
 * @date 2017年11月23日 上午9:45:16
 * @version V1.0
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	/**
	 * @Title: defaultErrorHandler @Description: 统一处理某一类异常，从而能够减少代码重复率和复杂度 @param
	 * req @param e @return ApiResult @throws
	 */
	@ExceptionHandler(value = ExceptionResult.class)
	@ResponseBody
	public ExceptionResult defaultErrorHandler(HttpServletRequest req, Exception e) {
		// 打印异常信息：
		e.printStackTrace();
		return new ExceptionResult(ResultCode.SERVER_ERROR.getCode(), ResultMessage.SERVER_ERRPR.getMessage());

	}

	/**
	 * 捕获类内所有的异常
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler
	public ModelAndView exceptionHandelByThymeleaf(Exception ex, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error");
		mav.addObject("exception", ex);
		mav.addObject("url", req.getRequestURL());
		return mav;
	}

}
