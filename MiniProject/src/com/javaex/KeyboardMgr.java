package com.javaex;

import java.util.Scanner;

public class KeyboardMgr {
	// 싱글턴
	private Scanner numberInput;
	private Scanner textInput;
	
	public KeyboardMgr() {
		numberInput = new Scanner(System.in);
		textInput = new Scanner(System.in);
	}
	
	public String textInput()
	{
		String str = null;
		
		try {
			str = textInput.nextLine();
		} catch (Exception e) {
			System.out.println("문자만 입력해주세요");
		}
		
		return str;
	}
	
	public Integer numberInput()
	{
		Integer integer = null;
		
		try {
			integer = textInput.nextInt();
		} catch (Exception e) {
			System.out.println("숫자만 입력해주세요");
		}
		
		return integer;
	}
	
	/* 
	 * 종료 전 호출 필요
	 * */
	public void end()
	{
		numberInput.close();
		textInput.close();
	}
}
