package com.javaex.miniproject2;

public class PeopleVo {
	private Integer id;
	private String name;
	private String phoneNumber;
	private String companyNumber;
	
	public PeopleVo(Integer id, String name, String phoneNumber, String companyNumber) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.companyNumber = companyNumber;
	}
	
	public String getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getCompanyNumber() {
		return companyNumber;
	}

	@Override
	public String toString() {
		return name + "\t " + phoneNumber + "\t " + companyNumber;
	}
}
