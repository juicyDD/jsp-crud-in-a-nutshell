package Model.BO;
import java.sql.SQLException;
import java.util.*;
import Model.Bean.nhanvien;

import Model.DAO.nhanvienDAO;
public class nhanvienBO {
	nhanvienDAO nvDAO = new nhanvienDAO();
	public ArrayList<nhanvien> BOgetNV(String pb) throws ClassNotFoundException, SQLException
	{
		ArrayList<nhanvien> list = new ArrayList<nhanvien>();
		list = nvDAO.DAOGetNV(pb);
		//System.out.println(list.size());
		return list;
	}
	public void BOinsertNV(String ten, String diachi, String IDPB) throws ClassNotFoundException, SQLException
	{
		nhanvien nv = new nhanvien();
		nv.setHoten(ten);
		nv.setIDPB(IDPB);
		nv.setDiachi(diachi);
		nvDAO.DAOInsertNV(nv);
		return;
	}
	public boolean BOcheckLogin(String username, String password) throws ClassNotFoundException, SQLException
	{
		return nvDAO.DAOcheckLogin(username, password);
	}
	public nhanvien BOgetNVByID(String id) throws ClassNotFoundException, SQLException
	{
		return nvDAO.DAOgetNVByID(id);
	}
	public void BOupdate(String id, String hoten, String diachi, String idpb) throws ClassNotFoundException, SQLException
	{
		nvDAO.DAOupdate(id, hoten, diachi, idpb);
		return;
	}
	public void BOdelete(String id) throws ClassNotFoundException, SQLException
	{
		nvDAO.DAODeleteNV(id);
		return;
	}
	public void BOdeleteAll() throws ClassNotFoundException, SQLException
	{
		nvDAO.DAODeleteAll();
		return;
	}
	public ArrayList<nhanvien> BOsearch(String type, String searchValue) throws ClassNotFoundException, SQLException
	{
		ArrayList<nhanvien> list = new ArrayList<nhanvien>();
		list = nvDAO.DAOsearch(type, searchValue);
		//System.out.println(list.size());
		return list;
	}
	
}
