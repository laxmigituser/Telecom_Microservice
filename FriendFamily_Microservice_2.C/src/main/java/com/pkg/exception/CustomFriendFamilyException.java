package com.pkg.exception;

public class CustomFriendFamilyException extends Exception{


	private static final long serialVersionUID = 1L;
	
	public CustomFriendFamilyException() {
		super("CUSTOM FRIENDFAMILY EXCEPTION!!!");
	}
	public CustomFriendFamilyException(String str) {
		super(str);
	}

}
