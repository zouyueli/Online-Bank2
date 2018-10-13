package com.cx.bank.util;

public class MyException extends RuntimeException{

	public MyException(){
		super();
	}
	
	public MyException(String message){
		super(message);
	}
}
