package com.javaex.miniproject2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

public interface PeopleDAO {	
	public Connection getConnect() throws SQLException;
	public LinkedList<PeopleVo> loadDB();
	public void saveDB(LinkedList<PeopleVo> insertList, LinkedList<PeopleVo> deleteList);
	public boolean insert(PeopleVo vo);
	public void delete(PeopleVo vo);
	public LinkedList<PeopleVo> search(String searchWord);
}
