package com.cx.bank.manager;

import java.util.List;

import com.cx.bank.actionform.UserForm;
import com.cx.bank.resultbean.Detail;
import com.cx.bank.resultbean.Users;
/**
 * 业务层接口：声明业务操作
 * @author zouyueli
 * @version Bank3.0
 */
public interface Manager{

  /**
   * 用户注册操作
   */
  public void register(UserForm userForm);
  
  /**
   * 用户登录操作
   */
  public Users login(UserForm userForm);
  
  /**
   * 获取余额
   * 
   */
  public double inquiry(int id);
  
  /**
   * 存款
   */
  public void deposit(UserForm userForm,Users user);
  
  /**
   * 取款
   */
  public void withdrawal(UserForm userForm,Users user);
  
  /**
   * 转账
   */
  public void transfer(UserForm userForm,Users user);
  
  /**
   * 查询交易明细
   */
  public List<Detail> showTransDetail(int id);

  public List<Users> getAllUserFreezeInfo();
  
  public void modifyIsFreeze(Users user);

}
