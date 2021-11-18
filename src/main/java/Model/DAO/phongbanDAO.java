package Model.DAO;

import java.sql.*;
import java.util.*;
import Model.Bean.*;
public class phongbanDAO {

	public ArrayList<phongban> DAOgetAllPB() throws ClassNotFoundException, SQLException
	{
		ArrayList<phongban> list = new ArrayList<phongban>();
		Class.forName("com.mysql.jdbc.Driver");
		String url ="jdbc:mysql://localhost:3306/dulieu";
		String user ="root";
		String p = "";
        Connection con = (Connection) DriverManager.getConnection(url, user, p);
		Statement st = con.createStatement();
		String sql = "select * from phongban";
		ResultSet rs = st.executeQuery(sql);
		while (rs.next())
		{
			phongban pban = new phongban();
			pban.setIDPB(rs.getString("IDPB"));
			pban.setMota(rs.getString("MoTa"));
			pban.setTenpb(rs.getString("TenPB"));
			list.add(pban);
		}
		con.close();
		return list;
		
		
		
	}
}
