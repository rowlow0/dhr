package dao;

import java.sql.*;
import java.util.*;

import dto.Dto;
import dto.MDto;

public class Dao {

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private int result;
	
	public Connection getConnect(){
		try{Class.forName("oracle.jdbc.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","system1","1234");
		}catch(ClassNotFoundException e) {e.printStackTrace();}catch(SQLException e) {e.printStackTrace();}return con;
	}
	
	public void close(Connection con,PreparedStatement pstmt,ResultSet rs) {
		if(con!=null) {
			try{con.close();}catch(SQLException e) {e.printStackTrace();}
		}
		if(pstmt!=null) {
			try{pstmt.close();}catch(SQLException e) {e.printStackTrace();}
		}
		if(rs!=null) {
			try{rs.close();}catch(SQLException e) {e.printStackTrace();}
		}
	}
	
	public int autoGeNumber() {
		StringBuffer query=new StringBuffer();
		query.append("select max(custno) from member_tbl_02");
		try {con=getConnect();
			pstmt=con.prepareStatement(query.toString());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				result=rs.getInt(1)+1;
				if(result==0) {result=1;}
			}
		}catch(SQLException e) {e.printStackTrace();}finally {close(con,pstmt,rs);}
		return result;}
	
	public void insert(int custno,String custname,String phone,String address,String joindate,String grade,String city) {
		StringBuffer query=new StringBuffer();
		query.append("insert into member_tbl_02 values(?,?,?,?,?,?,?)");
		try {con=getConnect();
		pstmt=con.prepareStatement(query.toString());
		pstmt.setInt(1, custno);
		pstmt.setString(2,custname);
		pstmt.setString(3,phone);
		pstmt.setString(4,address);
		pstmt.setString(5,joindate);
		pstmt.setString(6,grade);
		pstmt.setString(7,city);
		result=pstmt.executeUpdate();
	}catch(SQLException e) {e.printStackTrace();}finally {close(con,pstmt,rs);}
}
	
	public List<Dto> select() {
		List<Dto> list=new ArrayList<Dto>();
		StringBuffer query=new StringBuffer();
		query.append("select *from member_tbl_02");
		try {con=getConnect();
		pstmt=con.prepareStatement(query.toString());
		rs=pstmt.executeQuery();
		while(rs.next()) {
			Dto dto=new Dto();
			dto.setCustno(rs.getInt(1));
			dto.setCustname(rs.getString(2));
			dto.setPhone(rs.getString(3));
			dto.setAddress(rs.getString(4));
			dto.setJoindate(rs.getString(5));
			dto.setGrade(rs.getString(6));
			dto.setCity(rs.getString(7));
			list.add(dto);
		}
	}catch(SQLException e) {e.printStackTrace();}finally {close(con,pstmt,rs);}
		return list;
	}
	
	public int update(int custno,String custname,String phone,String address,String joindate,String grade,String city) {
		StringBuffer query=new StringBuffer();
		query.append("update member_tbl_02 set custname=?,phone=?,address=?,joindate=?,grade=?,city=? where custno=?");
		try {con=getConnect();
		pstmt=con.prepareStatement(query.toString());;
		pstmt.setString(1,custname);
		pstmt.setString(2,phone);
		pstmt.setString(3,address);
		pstmt.setString(4,joindate);
		pstmt.setString(5,grade);
		pstmt.setString(6,city);
		pstmt.setInt(7,custno);
		result=pstmt.executeUpdate();
	}catch(SQLException e) {e.printStackTrace();}finally {close(con,pstmt,rs);}return result;
}
	
	public List<MDto> selectMoney() {
		List<MDto> list=new ArrayList<MDto>();
		StringBuffer query=new StringBuffer();
		query.append("select mo.custno,me.custname,me.grade,sum(price) from member_tbl_02 me,money_tbl_02 mo where me.custno=mo.custno group by mo.custno,me.custname,me.grade order by sum(price) desc");
		try {con=getConnect();
		pstmt=con.prepareStatement(query.toString());
		rs=pstmt.executeQuery();
		while(rs.next()) {
			MDto mDto=new MDto();
			mDto.setCustno(rs.getInt(1));
			mDto.setCustname(rs.getString(2));
			mDto.setGrade(rs.getString(3));
			mDto.setPrice(rs.getInt(4));
			list.add(mDto);
		}
	}catch(SQLException e) {e.printStackTrace();}finally {close(con,pstmt,rs);}
		return list;
		
	}
}
