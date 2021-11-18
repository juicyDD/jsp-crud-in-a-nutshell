package Controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import Controller.nhanvienController;

import Model.BO.*;
import Model.Bean.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
@WebServlet("/department/")
public class phongbanController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	phongbanBO pbBO = new phongbanBO();
	public static boolean authorize =nhanvienController.authorize;
	public static String username = nhanvienController.username;
	public phongbanController()
	{
		
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			String destination = null;
			
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			
			
			String action = request.getServletPath();
			
			try
			{
				
				switch(action)
				{
					
					default:
						list(request,response);
						break;
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			

	}
    //#SESSION INITIALIZE
	//
	//--------------
    private void sessionInitialize(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException, ServletException 
    {
		request.setAttribute("authorized", this.authorize);
		request.setAttribute("username", this.username);
    }
  //#LIST REGION
    //#LIST REGION
    //#LIST REGION
    //#LIST REGION
    //
    
    private void list(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
    	if(this.authorize==true) this.sessionInitialize(request, response);
        ArrayList<phongban> listPB = new ArrayList<phongban>();
        try
        {
        	listPB = this.pbBO.BOgetAllPB();
        }
        catch (Exception ex)
        {
        	System.out.println("Exception nek");
        	ex.printStackTrace();
        }
        request.setAttribute("listPB", listPB);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("//listpb.jsp");
        dispatcher.forward(request, response);
    }
}