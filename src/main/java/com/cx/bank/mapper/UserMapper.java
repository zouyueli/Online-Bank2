package com.cx.bank.mapper;

import java.util.List;

import com.cx.bank.resultbean.Detail;
import com.cx.bank.resultbean.Users;

public interface UserMapper {
	
	 /**
	  * 查询一条记录
	  * @return
	  */
	 public Users selectUserByUsernameAndPassword(Users user);
	 
	 
	 /**
	  * 向users表只插入一条记录
	  */
	 public void insertUserByUsernameAndPassword(Users user);
	 
	 
    /**
     * 更新money值
     */
    public void updateMoney(Users user);

    
    /**
     * 通过用户名找User
     * @param username
     * @return
     */
    public Users selectUserByUsername(String username);
    
    /**
     * 查询交易明细
     * @param id
     * @return
     */
    public List<Detail> selectDetailByUserId(int id);
    
    /**
     * 插入交易明细
     * @param detail
     * @return
     */
    public void insertTransDetail(Detail detail);
    
    public List<Users> selectAllUserInfo();
    
    public void modifyIsFreeze(Users user);

}
