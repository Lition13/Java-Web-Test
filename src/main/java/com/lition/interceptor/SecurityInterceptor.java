package com.lition.interceptor;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.lition.po.TMenu;
import com.lition.po.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 页面安全拦截器
 * @author think
 *
 */

public class SecurityInterceptor implements Interceptor{

	@Override
	public void destroy() {
		
	}

	@Override
	public void init() {
		
	}

	/**
	 * 拦截除登录意外的所有的请求，
	 * 如果登录状态就放过，否则调回登录界面
	 */
	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		Object obj = session.get("LOGIN_USER");
		if(obj != null){
			// 表示已经登录，放过
			// 1.获取用户的提交地址
			String path = request.getServletPath();
			// 2.获取用户权限以内的所有地址
			TUser user = (TUser) obj;
			List<TMenu> menus = user.getMenusList();
			// 3.判断是否在权限以内
			boolean flag = false;
			
			for (TMenu m : menus) {
				if (m.getMenulink().equals(path) || (m.getMenulink()+".action").equals(path)) {
					//表示具有权限
					flag = true;
				}
			}
			if (flag) {
				ai.invoke();
			}else {
				//表示没有权限
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print("<script>");
				out.print("alert('权限不够，请联系管理员');");
				out.print("location.href='"+request.getContextPath()+"/error.jsp';");
				out.print("</script>");
				out.flush();
				out.close();
			}
		}else{
			// 没有登录，需要跳转回登录界面
			// 表示没有登录，需要跳转会登录界面
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('还没有登录，请先登录！！！');");
			out.print("location.href='"+request.getContextPath()+"/login.jsp';");
			out.print("</script>");
			out.flush();
			out.close();
		}
		return null;
	}

}
