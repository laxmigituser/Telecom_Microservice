package com.pkg.exception;

public class CustomPlanException extends Exception{


	private static final long serialVersionUID = 1L;
	
	public CustomPlanException() {
		super("CUSTOM PLAN EXCEPTION!!!");
	}
	public CustomPlanException(String str) {
		super(str);
	}

}
