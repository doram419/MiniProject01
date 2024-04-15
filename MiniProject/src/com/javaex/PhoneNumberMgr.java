package com.javaex;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class PhoneNumberMgr {
	private static PhoneNumberMgr instance = new PhoneNumberMgr();
	private static String rootPath = System.getProperty("user.dir") + "\\DB\\"; 
	private static String dst = rootPath + "PhoneDB.txt";
	private LinkedList<PhoneNumber> phoneList = new LinkedList<PhoneNumber>();
	
	private PhoneNumberMgr() {
		loadMgr();
	}
	
	public static PhoneNumberMgr getInstance()
	{
		return instance;
	}
	
	// 파일 불러오기
	private void loadMgr() {
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
					phoneList.add(phoneNumber);
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
	public void printList() {
		Iterator<PhoneNumber> iterator = phoneList.iterator();
		int dataNum = 1;
		
		while (iterator.hasNext()) {
			PhoneNumber phoneNumber = iterator.next();
			System.out.println(dataNum + ". " + phoneNumber);
			dataNum++;
		}
	}
}
