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
		LinkedList<String> list = new LinkedList<String>();
		Scanner scanner = new Scanner(System.in);
		int userInput = 0;
		
		// 프로그램 시작
		// 파일 불러오기
		loadMgr(list);
		
		phoneMgrUIStart();

		while (userInput != 5) {
			phoneMgrUI();
			userInput = scanner.nextInt();
			
			switch (userInput) {
				case 1 ->{
					// 리스트
				}
				case 2 ->{
					// 등록	
				}
				case 3 ->{
					// 삭제
				}
				case 4 ->{
					// 검색
				}
				case 5 ->{
					// 종료
				}
			
				default ->{
					System.out.println("[ 다시 입력해주세요 ]");
					System.out.println();
				}
			}
		}
		
		// 파일 저장하기
		// 프로그램 종료
		scanner.close();
	}
	
	// 파일 불러오기
	private static void loadMgr(LinkedList<String> list) {
		File file = new File(dst);
				
		try (
			Scanner scanner = new Scanner(file);
				) {
			while((scanner.hasNext()))
			{
				list.add(scanner.next());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 현재 List에 저장된 자료 확인
	private static void printList(LinkedList<String> list) {
		Iterator<String> iterator = list.iterator();
		
		while (iterator.hasNext()) {
			String printElement = iterator.next();
			System.out.println(printElement);
		}
	}
	
	// UI 구현
	// 시작 UI
	private static void phoneMgrUIStart() {
		System.out.println("****************************************");
		System.out.println("*          전화번호 관리 프로그램           *");
		System.out.println("****************************************");
	}
	
	// 반복 UI
	private static void phoneMgrUI() {
		System.out.println("1. 리스트 | 2. 등록 | 3.삭제 | 4.검색 | 5. 종료");
		System.out.println("------------------------------------------");
		System.out.print(">메뉴번호 : ");
	}
}
