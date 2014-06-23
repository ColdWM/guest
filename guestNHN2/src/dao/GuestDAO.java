package dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import dto.Guest;
import exception.DuplicateException;

public class GuestDAO{
	private SqlMapClient sqlMapper;

	private static GuestDAO instance;
	
	//Singleton Pattern
	private GuestDAO(){
	//1.SqlMapClient Load
		sqlMapper=DAOParser.getParser();
	}
	public static GuestDAO getInstance(){
		if(instance == null)	instance = new GuestDAO();
		return instance;
	}
	
	private boolean isExist(String custId){
		boolean flag=false;
		String result=null;
		try {
			result = (String)sqlMapper.queryForObject("isExist", custId);
			if( result != null ) flag=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public void insert(Guest guest) {		
		try {
			sqlMapper.insert("insert", guest);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void update(Guest guest) {

		try {
			sqlMapper.update("update", guest);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public void delete(String custId) {
		try {
			sqlMapper.delete("delete", custId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Guest> getGuests() {
		
		ArrayList<Guest> resultList =null;
		try {
			resultList = (ArrayList<Guest>)sqlMapper.queryForList("getGuests");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
	}

	
	public Guest getGuest(String guestPA) {
		Guest guest=null;
		
		try {
			guest=(Guest)sqlMapper.queryForObject("getGuest", guestPA);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	    //if(guest == null ) throw new RecordNotFoundException(custId);
		
		return guest;
	}

}








