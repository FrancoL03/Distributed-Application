package com.a20da10.controller;

import com.a20da10.service.ejb.InstructorSelfServiceRemote;
import com.a20da10.service.spring.StudentSelfService;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url =request.getRequestURI();
        //Only allow accessing to WelcomePageController
        if(url.contains("/welcome")){
            return true;
        }
        HttpSession session = request.getSession();
        if(session.getAttribute("LOGIN_TYPE") == "student") {
            StudentSelfService service = (StudentSelfService) session.getAttribute("USER_SESSION");
            if (service!=null){
                return true;
            }
        }
        else{
            InstructorSelfServiceRemote service = (InstructorSelfServiceRemote) session.getAttribute("USER_SESSION");
            if (service!=null){
                return true;
            }
        }
        //Here can set forward to login page jsp
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
