package com.cx.bank.resultbean;

/**
 * 
 * 与表Users对应的结果bean
 * @author zouyueli
 * @version Bank-ssm
 */
public class Users {
	
	private int id;
    private String username;  //用户名
    private String password;  //密码
    private double money;  //余额
    private int isFreeze;
    
	public int getIsFreeze() {
		return isFreeze;
	}
	public void setIsFreeze(int isFreeze) {
		this.isFreeze = isFreeze;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
}
