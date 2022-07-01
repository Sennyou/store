package com.liu.store.interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Signature;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Statement;

//定义一个拦截器
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 检测session对象中是否有uid数据,如果有放行,如果没有重定向到登录页面
     * @param request   请求对象
     * @param response  响应对象
     * @param handler   处理器(将url和Controller进行映射的对象)
     * @return  如果返回值为true,表示放行,false表示进行拦截当前请求
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getRequestURL());
        // 可以通过HttpServletRequest对象来获取session对象
        Object object = request.getSession().getAttribute("uid");
        if(object == null){
            //重定向到登录页面
            response.sendRedirect("/web/login.html");
            //结束后续调用
            return false;

        }
        return true;
    }
}
