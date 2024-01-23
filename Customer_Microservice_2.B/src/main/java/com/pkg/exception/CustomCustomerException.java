package com.pkg.exception;

public class CustomCustomerException extends Exception{


	private static final long serialVersionUID = 1L;
	
	public CustomCustomerException() {
		super("CUSTOM CUSTOMER EXCEPTION!!!");
	}
	public CustomCustomerException(String str) {
		super(str);
	}

}
