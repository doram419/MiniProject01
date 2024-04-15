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
	
	public String KeyInput(String input)
	{
		
		return null;
	}
	
	public Integer KeyInput(Integer input)
	{
		
		return null;
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
