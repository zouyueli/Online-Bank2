package com.cx.bank.actionform;

/**
 * 用于实时显示数据库里的余额
 * @author zouyueli
 * @version OnlineBank
 */
public class MoneyBean {
	
	private double money;
	
	private static MoneyBean instance = new MoneyBean();
	private MoneyBean(){}
	public static MoneyBean getInstance(){
		return instance;
	}
	
	public double getMoney(){
		return this.money;
	}
	
	public void setMoney(double money){
		this.money = money;
	}
}
