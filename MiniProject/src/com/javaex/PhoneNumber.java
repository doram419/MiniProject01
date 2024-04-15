package com.javaex;

public class PhoneNumber {
	private String name;
	private String phoneNumber;
	private String companyNumber;
	
	public PhoneNumber(String name, String phoneNumber, String companyNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.companyNumber = companyNumber;
	}

	@Override
	public String toString() {
		return name + "\t" + phoneNumber + "\t" + companyNumber;
		
	}
}
