package com.javaex;

public class PhoneUIMgr {
	public static PhoneUIMgr instance = new PhoneUIMgr();
	
	private PhoneUIMgr() {};
	
	// UI 구현
	// 시작 UI
	public static void phoneUIMgrStart() {
		System.out.println("****************************************");
		System.out.println("*          전화번호 관리 프로그램           *");
		System.out.println("****************************************");
	}
	
	// 반복 UI
	public static void phoneUIMgrMain() {
		System.out.println("1. 리스트 | 2. 등록 | 3.삭제 | 4.검색 | 5. 종료");
		System.out.println("------------------------------------------");
		System.out.print(">메뉴번호 : ");
	}
	
	// 종료
	public static void phoneUIMgrEnd() {
		System.out.println("****************************************");
		System.out.println("*                감사합니다               *");
		System.out.println("****************************************");
	}
}