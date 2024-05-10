package com.javaex.miniproject2;

import java.util.Iterator;
import java.util.LinkedList;

public class PeopleListMgr {
	private LinkedList<PeopleVo> originList;
	private LinkedList<PeopleVo> insertList;
	private LinkedList<PeopleVo> deleteList;
	private LinkedList<PeopleVo> changeList;
	private PeopleDAOMgr dao;
	
	public PeopleListMgr() {
		dao = new PeopleDAOMgr();
		requestLoadList();
	}
	
	/**
	 * DB에서 객체 가져오기
	 */
	private void requestLoadList()
	{
		originList = dao.loadDB();
		insertList = new LinkedList<PeopleVo>();
		deleteList = new LinkedList<PeopleVo>();
		changeList = originList;
	}
	
	/** 
	 * DB에 변경 내용 저장 요청
	 * 그런 뒤 변경 내용 초기화
	 */
	public void requestSaveList()
	{
		dao.saveDB(insertList, deleteList);
		requestLoadList();
	}
	
	/**
	 *  현재 List에 저장된 자료 확인
	 */
	public void printList() {
		Iterator<PeopleVo> iterator = changeList.iterator();
		int dataNum = 1;
		
		while (iterator.hasNext()) {
			PeopleVo people = iterator.next();
			System.out.println(dataNum + ". " + people);
			dataNum++;
		}
	}
	
	/** 
	 *  현재 List에 자료 추가
	 *  DB 저장은 프로그램 종료시에
	 * @param name : 사람의 이름
	 * @param phoneNumber : 전화번호 
	 * @param companyNumber : 회사 번호
	 */
	public void addList(String name, String phoneNumber, String companyNumber)
	{

		Integer lastId = dao.getLastId();
		lastId++;
		
		PeopleVo people = new PeopleVo((lastId.intValue()), name, phoneNumber, companyNumber);
		dao.setLastId(lastId);
		
		changeList.add(people);
		insertList.add(people);
		
		System.out.println("[ 입력 완료 ]");
	}
	
	/**
	 * 현재 List에 일치하는 자료 삭제
	 * DB 저장은 프로그램 종료시에 이뤄짐
	 * @param number : 삭제할 번호
	 * 		      -1 : 삭제하지 않고 메뉴로 돌아가기
	 */
	public void remove(int number)
	{
		number--;
		if(number == -2)
		{
			System.out.println("[ 메뉴로 돌아갑니다. ]");
			return;
		}
		
		try {
			deleteList.add(changeList.get(number));
			changeList.remove(number);
			System.out.println("[ 삭제되었습니다. ]");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("범주 안의 번호를 입력해주세요");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 검색
	public void search(String word)
	{
		Iterator<PeopleVo> iterator = changeList.iterator();
		int dataNum = 1;
		boolean isFoundAnything = false;
		
		while (iterator.hasNext()) {
			PeopleVo phoneNumber = iterator.next();

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
