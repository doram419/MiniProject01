package com.javaex;

import java.util.Iterator;
import java.util.LinkedList;

public class PhoneNumberMgr {
	private static PhoneNumberMgr instance = new PhoneNumberMgr();
	private LinkedList<People> phoneList;
	private FileMgr fMgr;
	
	private PhoneNumberMgr() {
		fMgr = new FileMgr();
		requestLoadList();
	}
	
	public static PhoneNumberMgr getInstance()
	{
		return instance;
	}
	
//	public PhoneNumberMgr() {
//		fMgr = new FileMgr();
//		requestLoadList();
//	}
	
	// 파일 불러오기 요청
	private void requestLoadList()
	{
		phoneList = fMgr.load();
	}
	
	public void requestSaveList()
	{
		fMgr.save(phoneList);
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
		try {
			phoneList.remove(number);
			System.out.println("[ 삭제되었습니다. ]");
		}catch (IndexOutOfBoundsException e) {
			System.out.println("범주 안의 번호를 입력해주세요");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 검색
	public void search(String word)
	{
		Iterator<People> iterator = phoneList.iterator();
		int dataNum = 1;
		boolean isFoundAnything = false;
		
		while (iterator.hasNext()) {
			People phoneNumber = iterator.next();

			if(phoneNumber.getName().contains(word))
			{
				System.out.println(dataNum + ". " + phoneNumber);
				isFoundAnything = true;
			}
			dataNum++;
		}
		
		if(!isFoundAnything) {
			System.out.println("일치하는 이름이 없습니다");
		}
	}
}
