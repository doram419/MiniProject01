package com.javaex;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class MiniProjectEx {
	private static String rootPath = System.getProperty("user.dir") + "\\DB\\"; 
	private static String dst = rootPath + "PhoneDB.txt";
	
	public static void main(String[] args) {
		LinkedList<PhoneNumber> list = new LinkedList<PhoneNumber>();
		Scanner scanner = new Scanner(System.in);
		int userInput = 0;
		
		// 프로그램 시작
		// 파일 불러오기
		loadMgr(list);
		
		phoneUIMgrStart();

		while (userInput != 5) {
			phoneUIMgrMain();
			userInput = scanner.nextInt();
			System.out.println();
			
			switch (userInput) {
				case 1 ->{
					// 리스트
					System.out.println("<1. 리스트>");
					printList(list);
				}
				case 2 ->{
					// 등록	
					System.out.println("<2. 등록>");
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
					phoneUIMgrEnd();
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
	
	// 파일 불러오기
	private static void loadMgr(LinkedList<PhoneNumber> list) {
		File file = new File(dst);
				
		try (
			Scanner scanner = new Scanner(file);
				) {
			while((scanner.hasNext()))
			{
				String str = scanner.next();
				String[] splits = str.split(",");
				
				try {
					PhoneNumber phoneNumber = new PhoneNumber(splits[0], splits[1], splits[2]);
					list.add(phoneNumber);
				} catch (Exception e) {
					e.printStackTrace();
				}	
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 현재 List에 저장된 자료 확인
	private static void printList(LinkedList<PhoneNumber> list) {
		Iterator<PhoneNumber> iterator = list.iterator();
		int dataNum = 1;
		
		while (iterator.hasNext()) {
			PhoneNumber phoneNumber = iterator.next();
			System.out.println(dataNum + ". " + phoneNumber);
			dataNum++;
		}
	}
	
	// UI 구현
	// 시작 UI
	private static void phoneUIMgrStart() {
		System.out.println("****************************************");
		System.out.println("*          전화번호 관리 프로그램           *");
		System.out.println("****************************************");
	}
	
	// 반복 UI
	private static void phoneUIMgrMain() {
		System.out.println("1. 리스트 | 2. 등록 | 3.삭제 | 4.검색 | 5. 종료");
		System.out.println("------------------------------------------");
		System.out.print(">메뉴번호 : ");
	}
	
	// 종료
	private static void phoneUIMgrEnd() {
		System.out.println("****************************************");
		System.out.println("*                감사합니다               *");
		System.out.println("****************************************");

	}
}
