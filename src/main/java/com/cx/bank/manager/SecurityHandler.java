package com.cx.bank.manager;

import java.util.Date;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.cx.bank.actionform.UserForm;
import com.cx.bank.mapper.UserMapper;
import com.cx.bank.resultbean.Detail;
import com.cx.bank.resultbean.Users;
import com.cx.bank.util.MyException;

/**
 * 利用spring的AOP的技术
 * @author zouyueli
 */

@Aspect
public class SecurityHandler{
	
	@Resource(name="mapper")
	private UserMapper mapper;
	
	
	@Pointcut("execution(* com.cx.bank.manager.ManagerImpl.login(..))")
	private void loginMethod(){};
	
	/**
	 *  权限验证
	 * @throws RuntimeException
	 */
	@Before("loginMethod()")
	public void checkSecurity(JoinPoint joinPoint) {
		
		Object[] o = joinPoint.getArgs();
		UserForm u = (UserForm)o[0];
		Users user = mapper.selectUserByUsername(u.getUsername());
		int flag = user.getIsFreeze();
	    if(flag==0){
	    	//通过连接点找到目标对象
	    	Manager manager = (Manager)joinPoint.getTarget();
	    	manager.login(u);
	    }else{
	    	throw new MyException("您的账号已被冻结");
	    }
	}
}
