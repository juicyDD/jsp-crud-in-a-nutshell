package Model.BO;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Bean.*;
import Model.DAO.*;

public class phongbanBO
{
	private phongbanDAO pbDAO = new phongbanDAO();
	//
	//
	public ArrayList<phongban> BOgetAllPB() throws ClassNotFoundException, SQLException
	{
		ArrayList<phongban> list = new ArrayList<phongban>();
		list = pbDAO.DAOgetAllPB();
		//System.out.println(list.size());
		return list;
	}
}