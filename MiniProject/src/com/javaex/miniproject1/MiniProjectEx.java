package com.javaex.miniproject1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MiniProjectEx {
	public static void main(String[] args) {
		Scanner numberInput = new Scanner(System.in);
		Scanner textInput = new Scanner(System.in);
		boolean isContinue = true;
		
		// 프로그램 시작
		// 파일 불러오기
		
		PhoneUIMgr.getInstance().phoneUIMgrStart();

		while (isContinue) {
			int number = 0;
			PhoneUIMgr.getInstance().phoneUIMgrMain();
			
			try {
				number = numberInput.nextInt();
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
			}
			
			System.out.println();
			
			switch (number) {
				case 1 ->{
					// 리스트
					System.out.println("<1. 리스트>");
					PhoneNumberMgr.getInstance().printList();
				}
				case 2 ->{
					// 등록	
					System.out.println("<2. 등록>");
					
					String name = null;
					String phoneNumber = null;
					String companyNumber = null;
					
					System.out.print("> 이름 : ");
					name = textInput.nextLine();
					System.out.print("> 휴대폰 : ");
					phoneNumber = textInput.nextLine();
					System.out.print("> 회사전화 : ");
					companyNumber = textInput.nextLine();
					
					if(phoneRegex(phoneNumber, companyNumber))
						PhoneNumberMgr.getInstance().addList(name, phoneNumber, companyNumber);
					else
						System.out.println("형식이 올바르지 않습니다");
				}
				case 3 ->{
					// 삭제
					System.out.println("<3. 삭제 (-1 돌아가기)>");
					System.out.print("> 삭제할 번호 : ");
					number = numberInput.nextInt();
					PhoneNumberMgr.getInstance().remove(number);
				}
				case 4 ->{
					// 검색
					String search = null;
					System.out.println("<4. 검색>");
					System.out.print(">이름 :");
					search = textInput.nextLine();
					PhoneNumberMgr.getInstance().search(search);
				}
				case 5 ->{
					// 종료
					PhoneUIMgr.getInstance().phoneUIMgrEnd();
					isContinue = false;
				}
				case 6 ->{
					// 리셋
					PhoneNumberMgr.getInstance().requestResetList();
					System.out.println("[ 리셋 완료! ]");
				}
			
				default ->{
					System.out.println("[ 다시 입력해주세요 ]");
				}
			}
			System.out.println();
		}
		
		// 파일 저장하기
		PhoneNumberMgr.getInstance().requestSaveList();
		
		// 프로그램 종료
		numberInput.close();
		textInput.close();
	}
	
	private static boolean phoneRegex(String hp, String tel) {
		// 전화번호 패턴 : [공백][3자리 숫자-3~4자리 숫자-4자리 숫자][공백]
		String hpPattern = "(\\d{3}\\-\\d{3,4}\\-\\d{4})\\s*";
		Pattern hpRegex = Pattern.compile(hpPattern);
		Matcher hpMatcher = hpRegex.matcher(hp);
		
		// 회사 패턴 : [공백][2~4자리 숫자-3~4자리 숫자-4자리 숫자][공백]
		String telPattern = "(\\d{2,4}\\-\\d{3,4}\\-\\d{4})\\s*";
		Pattern telRegex = Pattern.compile(telPattern);
		Matcher telMatcher = telRegex.matcher(tel);
		
		if (hpMatcher.matches() && telMatcher.matches())
		{
			return true;
		}
		
		return false;
	}
}
