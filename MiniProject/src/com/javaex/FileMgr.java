package com.javaex;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class FileMgr {
	private static String rootPath = System.getProperty("user.dir") + "\\DB\\"; 
	private static String dst = rootPath + "PhoneDB.txt";
	
	// 파일 불러오기
	public LinkedList<People> load() {
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
	
	// 파일 저장하기 
	public void save(LinkedList<People> list)
	{
		File file = new File(dst);
		
		try (
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				) {
			String result = null;
			Iterator<People> iterator = list.iterator();
			
			while (iterator.hasNext()) {
				People next = iterator.next();
				
				result = next.getName() + "," + 
						next.getPhoneNumber() + "," +
						next.getCompanyNumber() + "\n";
				bufferedWriter.write(result);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
