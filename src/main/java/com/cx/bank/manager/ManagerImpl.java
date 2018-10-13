package com.cx.bank.manager;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.cx.bank.actionform.MoneyBean;
import com.cx.bank.actionform.UserForm;
import com.cx.bank.mapper.UserMapper;
import com.cx.bank.resultbean.Detail;
import com.cx.bank.resultbean.Users;
import com.cx.bank.util.MD5;
import com.cx.bank.util.MyException;

public class ManagerImpl implements Manager{
	
    @Resource(name="mapper")
    private UserMapper mapper;
    
    @Resource(name="moneyBean")
    private MoneyBean moneyBean;
    /**
     * 用户注册
     */
	@Override
	public void register(UserForm userForm) {
	
		Users user = new Users();
		user.setUsername(userForm.getUsername());
		user.setPassword((new MD5()).encode(userForm.getPassword().getBytes()));
	
		try{
			mapper.insertUserByUsernameAndPassword(user);
		}catch(Exception e){
		    throw new MyException("注册失败");
		}
	}
    
	/**
	 * 用户登录
	 */
	@Override
	public Users login(UserForm userForm) {
		
		Users user = new Users();
		user.setUsername(userForm.getUsername());
		System.out.println(userForm.getUsername());
		user.setPassword((new MD5()).encode(userForm.getPassword().getBytes()));

		Users u = mapper.selectUserByUsernameAndPassword(user);
		if(u != null){
			return u;
		}else{
			throw new MyException("登录失败");
		}
	}
	
	/**
	 * 查询余额
	 */
	@Override
	public double inquiry(int id){
		return moneyBean.getMoney();
	}
	
	/**
	 * 存款
	 */
	@Override
	public void deposit(UserForm userForm,Users user) {
		
	    double money = userForm.getMoney();
	    if(money>100000){
	    	throw new MyException("输入金额过大");
	    }
	    user.setMoney(moneyBean.getMoney()+money);

	    mapper.updateMoney(user);	
	  
	    moneyBean.setMoney(moneyBean.getMoney()+money);
	    	
	    Detail detail = new Detail();
	    detail.setReason("deposit");
	    detail.setMoney(+money);
	    detail.setDate(new Date());
	    detail.setUser(user);
	    mapper.insertTransDetail(detail);
	}
	
	/**
	 * 取款
	 */
	@Override
	public void withdrawal(UserForm userForm, Users user) {
		double money = userForm.getMoney();
		if(money>100000){
		   throw new MyException("输入金额过大");
		}
	    user.setMoney(moneyBean.getMoney()-money);
	    	
	    if(money > moneyBean.getMoney()){
	    	throw new MyException("余额不足");  //余额不足
	    }else{
	    	mapper.updateMoney(user);
	    	
	    	//实时更新内存中的余额
	    	moneyBean.setMoney(moneyBean.getMoney()-money);
	    	
	    	//封装交易明细数据,更新数据库的detail表
	    	Detail detail = new Detail();
	    	detail.setReason("withdrawal");
	    	detail.setMoney(-money);
	    	detail.setDate(new Date());
	    	detail.setUser(user);
	 	    mapper.insertTransDetail(detail);
		} 
	}
	
	/**
	 * 转账 
	 */
	@Override
	public void transfer(UserForm userForm, Users user) {
        String otherUsername = userForm.getOtherUserName();
        double money = userForm.getMoney();
        if(money>100000){
	    	throw new MyException("输入金额过大");
	    }
        if(otherUsername.equals(user.getUsername())){
        	throw new MyException("不能给自己转账");
        }
        user.setMoney(moneyBean.getMoney()-money);
        System.out.println(otherUsername);
        
        Users otherUser = mapper.selectUserByUsername(otherUsername);
        System.out.println(otherUser);
                
        if(otherUser == null){
            throw new MyException("不存在该用户");  //不存在该用户
        }else if(money > moneyBean.getMoney()){
        	throw new MyException("余额不足");  //余额不足
        }else{
        	otherUser.setMoney(otherUser.getMoney()+money);
        	
        	mapper.updateMoney(otherUser);
        	mapper.updateMoney(user);
        	
    		moneyBean.setMoney(moneyBean.getMoney()-money);
        	
        	Detail detail = new Detail();
        	detail.setReason("transfer");
        	detail.setMoney(-money);
        	detail.setDate(new Date());
        	detail.setUser(user);
		    mapper.insertTransDetail(detail);
		    
		    //收钱人
		    Detail detail1 = new Detail();
        	detail1.setReason("income");
        	detail1.setMoney(money);
        	detail1.setDate(new Date());
        	detail1.setUser(otherUser);
		    mapper.insertTransDetail(detail1);
        }
	}
	
	/** 
	 * 查询交易明细
	 */
	@Override
	public List<Detail> showTransDetail(int id) {

		 List<Detail> list = mapper.selectDetailByUserId(id);
		 System.out.println(",,,,,"+list);
		 return list;
	}

	/**
	 *[管理员获得所有的冻结信息]
	 */
	public List<Users> getAllUserFreezeInfo() {
        List<Users> list = mapper.selectAllUserInfo();
		return list;
	}

	@Override
	public void modifyIsFreeze(Users user) {
		
		mapper.modifyIsFreeze(user);
	}
	
	
	
	
}
