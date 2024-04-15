package com.javaex;

import java.util.Iterator;
import java.util.LinkedList;

public class PhoneNumberMgr {
	//private static PhoneNumberMgr instance = new PhoneNumberMgr();
	private LinkedList<People> phoneList;
	private FileMgr fMgr;
	
//	private PhoneNumberMgr() {
//		loadMgr();
//	}
	
//	public static PhoneNumberMgr getInstance()
//	{
//		return instance;
//	}
	
	public PhoneNumberMgr() {
		fMgr = new FileMgr();
		requestLoadList();
	}
	
	// 파일 불러오기 요청
	public void requestLoadList()
	{
		phoneList = fMgr.loadMgr();
	}
	
	// 현재 List에 저장된 자료 확인
	public void printList() {
		Iterator<People> iterator = phoneList.iterator();
		int dataNum = 1;
		
		while (iterator.hasNext()) {
			People phoneNumber = iterator.next();
			System.out.println(dataNum + ". " + phoneNumber);
			dataNum++;
		}
	}
	
	// 현재 List에 자료 추가
	public void addList(String name, String phoneNumber, String companyNumber)
	{
		People people = new People(name, phoneNumber, companyNumber);
		
		phoneList.add(people);
		System.out.println("[ 입력 완료 ]");
	}
	
	// 항목 삭제
	public void remove(int number)
	{
		number--;
		phoneList.remove(number);
		System.out.println("[ 삭제되었습니다. ]");
	}
}
