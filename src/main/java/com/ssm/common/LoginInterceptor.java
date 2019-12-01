package com.ssm.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Controller
public class LoginInterceptor extends HandlerInterceptorAdapter{

	private static final Logger logger = org.apache.log4j.Logger
			.getLogger(LoginInterceptor.class);
//    @Resource
//    LoginService loginService;
	
	
	
	
    // 加载登录页面
    @RequestMapping("/login")
    @ResponseBody
    public String loadLogin(){
    	logger.info("========用户邓丽========");
        return "login";
    }




	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("==========用户进入后postHandle==============");
		super.postHandle(request, response, handler, modelAndView);
	}




	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		logger.info("==========用户进入前preHandle==============");
		return super.preHandle(request, response, handler);
	}

    
    
//    // 登录验证
//    @RequestMapping(value = "/login/students", method = RequestMethod.POST)
//    @ResponseBody
//    public Msg getLogin(Login login, HttpSession session){
//        // 登录检测，返回登录人员信息的实体类
//        Login reLogin = loginService.checkUser(login);
//        System.out.println(reLogin);
//        if(reLogin == null){
//            // 不存在，返回错误，并跳转注册页面
//            System.out.println("null");
//            return Msg.fail().add("end", "登录信息有误，请确认后在填写！");
//        }else{
//            // 如果存在则将实体类，保存在session中
//            session.setAttribute("userSession", reLogin);
//            System.out.println("OK");
//            // 返回成功信息
//            return Msg.success().add("end", "欢迎"+reLogin.getName()+"登录！");
//        }
//    }


//    @RequestMapping(value = "/logout")
//    @ResponseBody
//    public Msg logout(HttpSession session){
//        // 移除session
//        session.removeAttribute("userSession");
//        // @SessionAttributes需要清除时，使用SessionStatus.setComplete();来清除。注意，它只清除@SessionAttributes的session，不会清除HttpSession的数据
//        sessionStatus.setComplete();
//        return Msg.success().add("logout", "退出登录成功");
//    }
}