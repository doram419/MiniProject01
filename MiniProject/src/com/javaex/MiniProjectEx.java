package com.javaex;

import java.util.Scanner;

public class MiniProjectEx {
	public static void main(String[] args) {
		PhoneNumberMgr pMgr = new PhoneNumberMgr();
		//PhoneUIMgr pUiMgr = new PhoneUIMgr();
		KeyboardMgr kMgr = new KeyboardMgr();
		
		Scanner numberInput = new Scanner(System.in);
		Scanner textInput = new Scanner(System.in);
		boolean isContinue = true;
		
		// 프로그램 시작
		// 파일 불러오기
		
		PhoneUIMgr.getInstance().phoneUIMgrStart();

		while (isContinue) {
			int number = 0;
			PhoneUIMgr.getInstance().phoneUIMgrMain();
			kMgr.numberInput(number);
			
			System.out.println();
			
			switch (number) {
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
					name = textInput.nextLine();
					System.out.print("> 휴대폰 : ");
					phoneNumber = textInput.nextLine();
					System.out.print("> 회사전화 : ");
					companyNumber = textInput.nextLine();
					
					pMgr.addList(name, phoneNumber, companyNumber);
				}
				case 3 ->{
					// 삭제
					System.out.println("<3. 삭제>");
					System.out.print("> 번호 : ");
					number = numberInput.nextInt();
					pMgr.remove(number);
				}
				case 4 ->{
					// 검색
					String search = null;
					System.out.println("<4. 검색>");
					System.out.print(">이름 :");
					search = textInput.nextLine();
					pMgr.search(search);
				}
				case 5 ->{
					// 종료
					PhoneUIMgr.getInstance().phoneUIMgrEnd();
					isContinue = false;
				}
			
				default ->{
					System.out.println("[ 다시 입력해주세요 ]");
				}
			}
			System.out.println();
		}
		
		// 파일 저장하기
		pMgr.requestSaveList();
		// 프로그램 종료
		numberInput.close();
		textInput.close();
	}
}
