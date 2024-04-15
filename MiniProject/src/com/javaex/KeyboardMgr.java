package com.javaex;

import java.util.Scanner;

public class KeyboardMgr {
	private Scanner numberScanner;
	private Scanner textScanner;
	private Integer tempInt;
	private String tempStr;
	
	public KeyboardMgr() {
		numberScanner = new Scanner(System.in);
		textScanner = new Scanner(System.in);
	}
	
	public boolean textInput(String returnStr)
	{
		tempStr = null;
		
		try {
			tempStr = textScanner.nextLine();
			returnStr = tempStr;
			
		} catch (Exception e) {
			System.out.println("문자만 입력해주세요");
			return false;
		}
		
		return true;
	}
	
	public boolean numberInput(Integer returnInt)
	{
		tempInt = -1;
		
		try {
			tempInt = numberScanner.nextInt();
			returnInt = tempInt;
		} catch (Exception e) {
			System.out.println("숫자만 입력해주세요");
			
			return false;
		}
		
		return true;
	}
	
	/* 
	 * 종료 전 호출 필요
	 * */
	public void end()
	{
		numberScanner.close();
		textScanner.close();
	}
}
