package Model.DAO;


import java.util.*;
import java.sql.*;

import Model.Bean.nhanvien;

public class nhanvienDAO {

	public ArrayList<nhanvien>DAOGetNV(String pb) throws ClassNotFoundException, SQLException
	{
		
			ArrayList<nhanvien> list = new ArrayList<nhanvien>();
			Class.forName("com.mysql.jdbc.Driver");
			String url ="jdbc:mysql://localhost:3306/dulieu";
			String user ="root";
			String p = "";
	        Connection con = (Connection) DriverManager.getConnection(url, user, p);
			Statement st = con.createStatement();
			String sql = "";
			if(pb.toString().length()==0)
				sql = "select * from nhanvien";
			else if (pb.toString().length()>0)
				sql="select * from nhanvien where IDPB='"+pb+"'";
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next())
			{
				nhanvien nv = new nhanvien();
				nv.setIDNV(rs.getString("IDNV"));
				nv.setHoten(rs.getString("HoTen"));
				nv.setDiachi(rs.getString("DiaChi"));
				nv.setIDPB(rs.getString("IDPB"));
				list.add(nv);
			}
			
			con.close();
			return list;
			

	}
	//
	//
	//------------------------------------------
	public String generateID() throws ClassNotFoundException, SQLException
	{
		boolean check = true;
		int i=0;
		while(true)
		{
			i++;
			String temp = "NV" + i;
			if(this.searchID(temp)==false) return temp;
		}
		
	}
	//-----------#SEARCH REGION------------
	//
	//
	//-----------#SEARCH REGION------------
	//-----------#SEARCH REGION------------
	public boolean searchID(String id) throws ClassNotFoundException, SQLException
	{
		ArrayList<nhanvien> list = new ArrayList<nhanvien>();
		list = this.DAOGetNV("");
		for (nhanvien nv : list)
		{
			if (nv.getIDNV().equals(id)) return true;
		}
		return false;
	}
	public ArrayList<nhanvien> DAOsearch(String type, String searchValue) throws ClassNotFoundException, SQLException
	{
		ArrayList<nhanvien> list = new ArrayList<nhanvien>();
		Class.forName("com.mysql.jdbc.Driver");
		String url ="jdbc:mysql://localhost:3306/dulieu";
		String user ="root";
		String p = "";
        Connection con = (Connection) DriverManager.getConnection(url, user, p);
		Statement st = con.createStatement();
		String sql = "select * from nhanvien where "+type+"='"+searchValue+"'";
		ResultSet rs = st.executeQuery(sql);
		while (rs.next())
		{
			nhanvien nv = new nhanvien();
			nv.setIDNV(rs.getString("IDNV"));
			nv.setHoten(rs.getString("HoTen"));
			nv.setDiachi(rs.getString("DiaChi"));
			nv.setIDPB(rs.getString("IDPB"));
			list.add(nv);
		}
		
		con.close();
		return list;
		
	}
	//
	//------------#INSERT REGION-----------------------------
	//
	
	public boolean DAOInsertNV(nhanvien nv)  throws ClassNotFoundException, SQLException
	{
		ArrayList<nhanvien> list = new ArrayList<nhanvien>();
		Class.forName("com.mysql.jdbc.Driver");
		String url ="jdbc:mysql://localhost:3306/dulieu";
		String user ="root";
		String p = "";
        Connection con = (Connection) DriverManager.getConnection(url, user, p);
		Statement st = con.createStatement();
		String sql = "";
		nv.setIDNV(this.generateID());
		sql = "insert into nhanvien (IDNV,HoTen,IDPB,DiaChi) values ('"
				+nv.getIDNV()+"','"+nv.getHoten()+"','"+nv.getIDPB()+"','"
				+nv.getDiaChi()+"')";
		st.execute(sql);
		con.close();
		return true;
	}
	//------------------#DELETE REGION---------
	
	//------------------#DELETE REGION---------
	//
	//
	//------------------#DELETE REGION---------
	
	public boolean DAODeleteNV(String id) throws ClassNotFoundException, SQLException
	{
		ArrayList<nhanvien> list = new ArrayList<nhanvien>();
		Class.forName("com.mysql.jdbc.Driver");
		String url ="jdbc:mysql://localhost:3306/dulieu";
		String user ="root";
		String p = "";
        Connection con = (Connection) DriverManager.getConnection(url, user, p);
		Statement st = con.createStatement();
		
		String sql = "delete from nhanvien where IDNV='"+id+"'";
		st.execute(sql);
		con.close();
		return true;
	}
	public boolean DAODeleteAll() throws ClassNotFoundException, SQLException
	{
		ArrayList<nhanvien> list = new ArrayList<nhanvien>();
		Class.forName("com.mysql.jdbc.Driver");
		String url ="jdbc:mysql://localhost:3306/dulieu";
		String user ="root";
		String p = "";
        Connection con = (Connection) DriverManager.getConnection(url, user, p);
		Statement st = con.createStatement();
		
		String sql = "delete * from nhanvien";
		st.execute(sql);
		con.close();
		return true;
	}

	// --------------------CHECK LOGIN
	//
	//
	public boolean DAOcheckLogin(String username, String password) throws ClassNotFoundException, SQLException
	{
		ArrayList<nhanvien> list = new ArrayList<nhanvien>();
		Class.forName("com.mysql.jdbc.Driver");
		String url ="jdbc:mysql://localhost:3306/dulieu";
		String user ="root";
		String p = "";
        Connection con = (Connection) DriverManager.getConnection(url, user, p);
		Statement st = con.createStatement();
		
		String sql = "select * from admin where username='"+username+"' and password='"+password+"'";
		ResultSet rs = st.executeQuery(sql);
		while(rs.next())
		{
			return true;
		}
		return false;
		
	}
	//------get nhanvien by id
	public nhanvien DAOgetNVByID(String id)  throws ClassNotFoundException, SQLException
	{
		nhanvien nv = new nhanvien();
		Class.forName("com.mysql.jdbc.Driver");
		String url ="jdbc:mysql://localhost:3306/dulieu";
		String user ="root";
		String p = "";
        Connection con = (Connection) DriverManager.getConnection(url, user, p);
		Statement st = con.createStatement();
		
		String sql = "select * from nhanvien where IDNV='"+id+"' limit 1";
		ResultSet rs = st.executeQuery(sql);
		while(rs.next())
		{
			nv.setIDNV(rs.getString("IDNV"));
			nv.setHoten(rs.getString("HoTen"));
			nv.setDiachi(rs.getString("DiaChi"));
			nv.setIDPB(rs.getString("IDPB"));
		}
		return nv;
	}
	//--------#UPDATE CODE REGION
	//
	//
	public void DAOupdate(String id, String hoten, String diachi, String idpb)  throws ClassNotFoundException, SQLException
	{
		nhanvien nv = new nhanvien();
		Class.forName("com.mysql.jdbc.Driver");
		String url ="jdbc:mysql://localhost:3306/dulieu";
		String user ="root";
		String p = "";
        Connection con = (Connection) DriverManager.getConnection(url, user, p);
		Statement st = con.createStatement();
		
		String sql = "update nhanvien set HoTen='"+hoten+"', DiaChi='"+diachi+"',IDPB='"+idpb+"' where IDNV='"+id+"'";
		st.execute(sql);
		con.close();
		return;
		
	}
	

}
