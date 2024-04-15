package com.javaex;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class FileMgr {
	private static String rootPath = System.getProperty("user.dir") + "\\DB\\"; 
	private static String dst = rootPath + "PhoneDB.txt";
	
	// 파일 불러오기
	public LinkedList<People> loadMgr() {
		File file = new File(dst);
		LinkedList<People> phoneList = new LinkedList<People>();

		try (Scanner scanner = new Scanner(file);) {
			while ((scanner.hasNext())) {
				String str = scanner.next();
				String[] splits = str.split(",");

				try {
					People phoneNumber = new People(splits[0], splits[1], splits[2]);
					phoneList.add(phoneNumber);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return phoneList;
	}
}
