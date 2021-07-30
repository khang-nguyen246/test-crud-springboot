package com.test.dto;

public class LoginInfoDto {
	private short id ;
	private String fullName;
	public LoginInfoDto( short id , String fullname) { 
		this.id  = id;
		this.fullName = fullname;
		
	}
	public short getId() { 
		return id; 
		
	}
	public String getFullname() { 
		return fullName;
	}
}
