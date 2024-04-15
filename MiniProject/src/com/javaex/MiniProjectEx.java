package com.javaex;

import java.util.Scanner;

public class MiniProjectEx {
	public static void main(String[] args) {
		PhoneNumberMgr pMgr = new PhoneNumberMgr();
		PhoneUIMgr pUiMgr = new PhoneUIMgr();
		
		Scanner select = new Scanner(System.in);
		Scanner userInput = new Scanner(System.in);
		int numberInput = 0;
		
		// 프로그램 시작
		// 파일 불러오기
		
		pUiMgr.phoneUIMgrStart();

		while (numberInput != 5) {
			pUiMgr.phoneUIMgrMain();
			numberInput = select.nextInt();
			
			System.out.println();
			
			switch (numberInput) {
				case 1 ->{
					// 리스트
					System.out.println("<1. 리스트>");
					pMgr.printList();
				}
				case 2 ->{
					// 등록	
					System.out.println("<2. 등록>");
					
					// 분리필요
					String name = null;
					String phoneNumber = null;
					String companyNumber = null;
					
					System.out.print("> 이름 : ");
					name = userInput.nextLine();
					System.out.print("> 휴대폰 : ");
					phoneNumber = userInput.nextLine();
					System.out.print("> 회사전화 : ");
					companyNumber = userInput.nextLine();
					
					pMgr.addList(name, phoneNumber, companyNumber);
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
					pUiMgr.phoneUIMgrEnd();
				}
			
				default ->{
					System.out.println("[ 다시 입력해주세요 ]");
				}
			}
			System.out.println();
		}
		
		// 파일 저장하기
		// 프로그램 종료
		select.close();
		userInput.close();
	}
	


}
