package com.a20da10.controller;

import com.a20da10.activemq.StatefulMessageListener;
import com.a20da10.service.ejb.AccountServiceLocal;
import com.a20da10.service.ejb.InstructorSelfServiceRemote;
import com.a20da10.service.spring.LoginOutAndRegisterService;
import com.a20da10.service.spring.StudentSelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/welcome")
public class HomePageController<LoginOutAndRegisterSer> {

    @Autowired
    private StudentSelfService studentSelfService;

    @Autowired
    private LoginOutAndRegisterService logService;

    @Autowired
    private StatefulMessageListener statefulMessageListener;

    @Autowired
    private AccountServiceLocal accountServiceLocal;

    @Autowired
    private InstructorSelfServiceRemote instructorSelfServiceRemote;

    @RequestMapping("/loginStudent")
    public String Login(HttpServletRequest request,HttpSession session){
        //0.Fetching parameters
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        //1.Verification
        if (logService.StudentAuthentication(email, password)) {
            //2.Add studentId into service
            Integer id = logService.getStudentIdByEmail(email);
            System.out.println(email + password);
            //3.create stateful bean for later access
            studentSelfService.setStudentId(id);
            System.out.println("studentSelfService id is" + id);
            statefulMessageListener.setStudentId(id);
            //4.Set session attribute for interceptor checking later
            session.setAttribute("LOGIN_TYPE", "student");
            session.setAttribute("USER_SESSION",studentSelfService);
            //5.redirect to home page
            System.out.println(studentSelfService);
            System.out.println("login success");
            return "success";
        }
        return "loginFail";
    }

    @RequestMapping("/loginInstructor")
    public String LoginIns(HttpServletRequest request, HttpSession session){
        //0.Fetching parameters
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        //1.Verification
        if (accountServiceLocal.InstructorAuthentication(email, password)) {
            //2.Add studentId into service
            Integer id = accountServiceLocal.getInstructorIdByEmail(email);
            System.out.println(email + password);
            //3.create stateful bean for later access
            instructorSelfServiceRemote.setInsId(id);
            System.out.println("InstructorSelfService id is" + id);
            //4.Set session attribute for interceptor checking later
            session.setAttribute("LOGIN_TYPE", "instructor");
            session.setAttribute("USER_SESSION", instructorSelfServiceRemote);
            //5.redirect to home page
            System.out.println(instructorSelfServiceRemote);
            System.out.println("login success");
            return "InstructorMainPage";
        }
        return "loginFail";
    }

    @RequestMapping("/logout")
    public String Logout(HttpSession session, SessionStatus sessionStatus) {
//        springIOC.getAutowireCapableBeanFactory().destroyBean(studentSelfService);
        session.invalidate();
        sessionStatus.setComplete();
        System.out.println(this.getClass().getClassLoader().getResource("main.css").getPath());
        return "home";
    }

    @RequestMapping("/")
    public String welcome(){
        return "login";
    }

    @RequestMapping("/hash")
    public void hashCodePass(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("zhenjie"));
    }
}
