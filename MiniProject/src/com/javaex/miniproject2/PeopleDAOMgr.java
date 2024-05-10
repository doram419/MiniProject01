package com.javaex.miniproject2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;

public class PeopleDAOMgr implements PeopleDAO {
	private Connection cn;
	private PreparedStatement pstmt;
	private Integer lastId;

	public PeopleDAOMgr() {
		super();
		cn = null;
		pstmt = null;
		loadLastId();
	}

	@Override
	public Connection getConnect() throws SQLException {
		Connection cn = null;
		
		try {
			Class.forName(PeopleConfig.driver);
			cn = DriverManager.getConnection(PeopleConfig.connectUrl,
					PeopleConfig.connectId, PeopleConfig.connectPs);
			System.out.println("연결 성공");
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 불러오기 실패");
			e.printStackTrace();
		}
		
		return cn;
	}

	@Override
	public LinkedList<PeopleVo> loadDB() {
		LinkedList<PeopleVo> peopleList = new LinkedList<PeopleVo>();
		String sql = "SELECT * FROM people\r\n";
		ResultSet rs = null;
		
		try {
			if(cn == null)
				cn = getConnect();
			
			pstmt = cn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				Integer id = rs.getInt("people_id");
				String name = rs.getString("people_name");
				String phoneNumber = rs.getString("phone_number");
				String companyNumber = rs.getString("local_number");
				
				PeopleVo vo = new PeopleVo(id, name, phoneNumber, companyNumber);
				peopleList.add(vo);
			}
		} catch (SQLException e) {
			System.err.println("SQL 오류!");
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return peopleList;
	}

	public void loadLastId() {
		String sql = "SELECT MAX(people_id) last_id FROM people";
		ResultSet rs = null;
		
		try {
			if(cn == null)
				cn = getConnect();
			
			pstmt = cn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				lastId = rs.getInt("last_id");

		} catch (SQLException e) {
			System.err.println("SQL 오류!");
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void setLastId(Integer lastId)
	{
		this.lastId = lastId;
	}
	
	public Integer getLastId() {
		return lastId;
	}

	/**
	 * 프로그램 종료시 호출
	 * 최종 수정을 DB에 적용
	 */
	public void saveDB(LinkedList<PeopleVo> insertList, LinkedList<PeopleVo> deleteList) {
		Iterator<PeopleVo> insertIter = insertList.iterator();
		
		while(insertIter.hasNext())
		{
			insert(insertIter.next());
		}
		
		Iterator<PeopleVo> deleteIter = deleteList.iterator();
		
		while(deleteIter.hasNext())
		{
			delete(deleteIter.next());
		}
		
	}

	/**
	 * DB에 새 객체 삽입
	 */
	@Override
	public boolean insert(PeopleVo vo) {
		String sql = "INSERT INTO people(people_id, people_name, phone_number, local_number)\r\n"
				+ "VALUES( ?, ?, ?, ? )";
		int count = 0;
		
		try {
			if(cn == null)
				cn = getConnect();
			
			pstmt = cn.prepareStatement(sql);
			
			Integer id = vo.getId();
			String name = vo.getName();
			String phoneNumber = vo.getPhoneNumber();
			String CompanyNumber = vo.getCompanyNumber();
			
			pstmt.setInt(1, id.intValue());
			pstmt.setString(2, name);
			pstmt.setString(3, phoneNumber);
			pstmt.setString(4, CompanyNumber);
			
			pstmt.execute();
			
			count++;
		} catch (SQLException e) {
			System.err.println("PeopleDAOMgr::insert() SQL 오류!");
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return count == 1 ? true : false;
	}
	
	/**
	 * DB에 새 객체 삽입
	 */
	@Override
	public void delete(PeopleVo vo) {
		String sql = "DELETE FROM people WHERE people_id = ?";
		
		try {
			if(cn == null)
				cn = getConnect();
			
			pstmt = cn.prepareStatement(sql);	
			
			pstmt.setInt(1, vo.getId());
			
			pstmt.execute();

		} catch (SQLException e) {
			System.err.println("SQL 오류!");
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * 현 프로그램 구조상 사용할 수 없지만 연습을 위해
	 * DB에서 직접 검색해오는 기능 search 구현
	 */
	@Override
	public LinkedList<PeopleVo> search(String searchWord) {
		LinkedList<PeopleVo> peopleList = new LinkedList<PeopleVo>();
		ResultSet rs = null;
		
		String sql = "SELECT * FROM people WHERE people_name Like ? OR "
				+ "people_name Like ? \r\n";
		
		try {
			if(cn == null)
				cn = getConnect();
			
			pstmt = cn.prepareStatement(sql);
			pstmt.setString(1, '%' + searchWord + '%');
			pstmt.setString(2,searchWord);
			rs = pstmt.executeQuery();
				
			while(rs.next())
			{
				Integer id = rs.getInt("people_id");
				String name = rs.getString("people_name");
				String phoneNumber = rs.getString("phone_number");
				String companyNumber = rs.getString("local_number");
				
				PeopleVo vo = new PeopleVo(id, name, phoneNumber, companyNumber);
				
				peopleList.add(vo);
			}
		} catch (SQLException e) {
			System.err.println("SQL 오류!");
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return peopleList;
	}
}
