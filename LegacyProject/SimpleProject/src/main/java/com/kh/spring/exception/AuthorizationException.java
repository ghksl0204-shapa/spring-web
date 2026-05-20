package com.kh.spring.exception;

public class AuthorizationException extends RuntimeException {

	public AuthorizationException(String msg) {
		super(msg);
	}
}
