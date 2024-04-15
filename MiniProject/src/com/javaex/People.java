package com.javaex;

public class People {
	private String name;
	private String phoneNumber;
	private String companyNumber;
	
	public People(String name, String phoneNumber, String companyNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.companyNumber = companyNumber;
	}
	
	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getCompanyNumber() {
		return companyNumber;
	}

	@Override
	public String toString() {
		return name + "\t" + phoneNumber + "\t" + companyNumber;
		
	}
}
