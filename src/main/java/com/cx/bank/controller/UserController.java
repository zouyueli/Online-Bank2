package com.cx.bank.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.cx.bank.actionform.MoneyBean;
import com.cx.bank.actionform.UserForm;
import com.cx.bank.manager.Manager;
import com.cx.bank.resultbean.Detail;
import com.cx.bank.resultbean.Users;

@Controller
public class UserController {
	
	@Resource(name="manager")
	private Manager manager;
	
	@Resource(name="moneyBean")
	private MoneyBean moneyBean;
	
	/**
	 * 国际化模块
	 */
	@RequestMapping("/chinese.do")
	public ModelAndView chinese(HttpServletRequest request){
		return new ModelAndView("views/index");  // 采用重定向方式跳转页面
	}
	@RequestMapping("/english.do")
	public ModelAndView english(HttpServletRequest request){
		return new ModelAndView("views/index");  // 采用重定向方式跳转页面
	}
	
	/**
	 * 跳转页面
	 */
	@RequestMapping("/toLogin.do")
	public ModelAndView toLogin(HttpServletRequest request){
		return new ModelAndView("views/login");  // 采用重定向方式跳转页面
	}
	@RequestMapping("/toRegister.do")
	public ModelAndView register(HttpServletRequest request){
		return new ModelAndView("views/register");  // 采用重定向方式跳转页面
	}
	
    /**
     *登录注册模块
     */
	@RequestMapping("/register.do")
	public ModelAndView register(UserForm userForm){  //会自动创建UserForm对象，把表单里的参数封装到userForm里
		manager.register(userForm);
		return new ModelAndView("views/login");
	}
	@RequestMapping("/login.do")
	public String login(UserForm userForm,HttpServletRequest request){
		String name=userForm.getUsername();
    	String password=userForm.getPassword();
    	if("admin".equals(name) && "admin".equals(password)){
    		List<Users> alluser = manager.getAllUserFreezeInfo();
        	request.getSession().setAttribute("alluser",alluser);
        	return "adminPage";
    	}else{
    		Users user = manager.login(userForm);
    	    request.getSession().setAttribute("user", user);
    	    moneyBean.setMoney(user.getMoney());
    	    return "mainpage";
    	}
	}
	
	
	/**
	 * 业务操作模块
	 */
	@RequestMapping("/inquiry.do")
	public String inquiry(HttpServletRequest request){
		int id= ((Users)request.getSession().getAttribute("user")).getId();
		double money = manager.inquiry(id);
		request.setAttribute("money", money);
		return "balance";
	}
	
	@RequestMapping("/deposit.do")
	public String deposit(UserForm userForm, HttpServletRequest request){
		Users user = (Users)request.getSession().getAttribute("user");
		manager.deposit(userForm, user);
		return "success";
	}
	
	@RequestMapping("/withdrawal.do")
	public String withdrawal(UserForm userForm, HttpServletRequest request){
		Users user = (Users)request.getSession().getAttribute("user");
		manager.withdrawal(userForm, user);
		return "success";
	}
	
	@RequestMapping("/transfer.do")
	public String transfer(UserForm userForm, HttpServletRequest request){
		Users user = (Users)request.getSession().getAttribute("user");
		System.out.println(",,,"+userForm.getOtherUserName());
		manager.transfer(userForm, user);
		return "success";
	}
	
	@RequestMapping("/getAllDetails.do")
	public String getAllDetails(HttpServletRequest request){
		int id = ((Users)request.getSession().getAttribute("user")).getId();
		List<Detail> list = manager.showTransDetail(id);
		request.setAttribute("detaillist", list);
		return "transDetails";
	}
	
    @RequestMapping("/toTransferForm.do")
	public String toTransferForm(HttpServletRequest request){
		
		return "transferForm";
	}
    
   @RequestMapping("/getUserDetails.do")
   public String  getUserDetails(@RequestParam int id, HttpServletRequest request){
	   
	   List<Detail> list = manager.showTransDetail(id);
	   
	   request.setAttribute("detaillist", list);
	   return "transDetails";
	   
   }
   
   
   @RequestMapping("/modifyIsFreeze.do")
   public String  modifyIsFreeze(@RequestParam int id ,@RequestParam int  isFreeze, HttpServletRequest request){
	   
	   Users user = new Users();
	   user.setId(id);
	   user.setIsFreeze(isFreeze);
	   manager.modifyIsFreeze(user);
	   
	   return "ok";
    }
   
    @RequestMapping("/returnAdmin.do")
	public String returnAdmin(HttpServletRequest request){

		return "adminPage";
	}
   
    
    
}
