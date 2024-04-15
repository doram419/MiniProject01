package com.javaex;

import java.util.Scanner;

public class MiniProjectEx {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int userInput = 0;
		
		// 프로그램 시작
		// 파일 불러오기
		
		PhoneUIMgr.getInstance().phoneUIMgrStart();

		while (userInput != 5) {
			PhoneUIMgr.getInstance().phoneUIMgrMain();
			userInput = scanner.nextInt();
			System.out.println();
			
			switch (userInput) {
				case 1 ->{
					// 리스트
					System.out.println("<1. 리스트>");
					PhoneNumberMgr.getInstance().printList();
				}
				case 2 ->{
					// 등록	
					System.out.println("<2. 등록>");
					
					// 분리필요
					String name = null;
					String phoneNumber = null;
					String companyNumber = null;
					System.out.print(">이름 : ");
					name = scanner.nextLine();
					System.out.print(">휴대폰 : ");
					phoneNumber = scanner.nextLine();
					System.out.print(">회사전화 : ");
					companyNumber = scanner.nextLine();
				}
				case 3 ->{
					// 삭제
					System.out.println("<3. 삭제>");
				}
				case 4 ->{
					// 검색
					System.out.println("<4. 검색>");
				}
				case 5 ->{
					// 종료
					PhoneUIMgr.getInstance().phoneUIMgrEnd();
				}
			
				default ->{
					System.out.println("[ 다시 입력해주세요 ]");
				}
			}
			System.out.println();
		}
		
		// 파일 저장하기
		// 프로그램 종료
		scanner.close();
	}
	


}
