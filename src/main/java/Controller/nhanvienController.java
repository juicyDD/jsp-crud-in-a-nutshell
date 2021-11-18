package Controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


import Model.BO.nhanvienBO;
import Model.Bean.nhanvien;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
@WebServlet("/")
public class nhanvienController extends HttpServlet {
	nhanvienBO nvBO = new nhanvienBO();
	public static boolean authorize=false;
	public static String username;
	private static final long serialVersionUID = 1L;
	public nhanvienController()
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
					case "/login":
						
						login(request,response);
						if (this.authorize==true) this.list(request, response);
						//else login(request,response);
						break;
					case "/insert":
						if (this.authorize==false) this.login(request, response);
						if (this.authorize==true) insert(request,response);
						break;
					case "/deletelist":
						if (this.authorize==false) this.login(request, response);
						if (this.authorize==true) deletelist(request,response);
						break;
					case "/delete":
						if (this.authorize==false) this.login(request, response);
						if (this.authorize==true) delete(request,response);
						break;
					case "/updatelist":
						if (this.authorize==false) this.login(request, response);
						if (this.authorize==true) updatelist(request,response);
						break;
						
					case "/update":
						if (this.authorize==false) this.login(request, response);
						if (this.authorize==true) update(request,response);
						break;
					case "/search":
						search(request,response);
						break;
					case "/list":
						list(request,response);
						break;
					case "/":
						list(request,response);
						break;
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			

	}
	//
	//--------#INSERT REGION----
	//--------#INSERT REGION----
	//--------#INSERT REGION----
	//
	
    private void insert(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
    	if(this.authorize==true) this.sessionInitialize(request, response);
        if (request.getMethod().toString().toLowerCase().equals("post"))
        {
        	nhanvien nv = new nhanvien();
            String name=request.getParameter("Hoten");
            String idpb=request.getParameter("IDPB");
            String diachi = request.getParameter("Diachi");
            try
            {
            	this.nvBO.BOinsertNV(name, diachi, idpb);
            }
            catch(Exception ex)
            {
            	//System.out.println("post ne");
            	ex.printStackTrace();
            }
            request.setAttribute("fromInsertFunc", "true");
//            RequestDispatcher dispatcher = request.getRequestDispatcher("listnv.jsp");
//            dispatcher.forward(request, response);
            this.list(request, response);
        }
        else
        {
        	//System.out.println(request.getMethod().toString().toLowerCase());
        	RequestDispatcher dispatcher = request.getRequestDispatcher("insertform.jsp");
            dispatcher.forward(request, response);
        }
        
    }

    //#LIST REGION
	
    private void list(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
    	if(this.authorize==true) this.sessionInitialize(request, response);
    	//
    	//
        ArrayList<nhanvien> listNV = new ArrayList<nhanvien>();
        if(request.getParameter("IDPB")==null||request.getAttribute("fromInsertFunc")!=null)
        	try
		        {
		        	listNV = this.nvBO.BOgetNV("");
		        }
		        catch (Exception ex)
		        {
		        	System.out.println("nvcontroller/list exceptions");
		        	ex.printStackTrace();
		        }
        else
        {
        	try
        	{
        		listNV = this.nvBO.BOgetNV(request.getParameter("IDPB").toString());
        		
        	}
        	catch(Exception ex)
        	{
	        	System.out.println("nvcontroller/list exceptions");
	        	ex.printStackTrace();
        	}
        }
        request.setAttribute("listNV", listNV);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("listnv.jsp");
        dispatcher.forward(request, response);
    }
    //#LOGIN REGION
	//
    //
    //
	  //#LOGIN REGION
	  //#LOGIN REGION
    private void sessionInitialize(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException, ServletException 
    {
		request.setAttribute("authorized", this.authorize);
		request.setAttribute("username", this.username);
    }
    private boolean login(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException 
    {
        
        if(request.getMethod().toString().toLowerCase().equals("get"))
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
            return false;
        }
        else if(request.getMethod().toString().toLowerCase().equals("post"))
        {
        	boolean authorized;
        	try
        	{
        		authorized = nvBO.BOcheckLogin(request.getParameter("username").toString(), request.getParameter("password").toString());
        		if (authorized == true)
        		{
        			request.setAttribute("authorized", authorized);
        			request.setAttribute("username", request.getParameter("username").toString());
        			
        			this.authorize=true;
        			this.username=request.getParameter("username").toString();
        			//this.list(request, response);
        			return true;
        			
        		}
        		else if (authorized ==false)
        		{
                    RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                    dispatcher.forward(request, response);
                    return false;
        		}
        			
        	}
        	catch(Exception nhiisnotanexception)
        	{
        		nhiisnotanexception.printStackTrace();
        	}
        	
        }
        return false;

    }
    
    
    //#UPDATE REGION
    //#UPDATE REGION
    //#UPDATE REGION
    //
    //----------------------------
    private void updatelist(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException, ServletException 
    {
    		if(this.authorize==true) this.sessionInitialize(request, response);
    		//
    		//
	        ArrayList<nhanvien> listNV = new ArrayList<nhanvien>();
	        try
	        {
	        	listNV = this.nvBO.BOgetNV("");
	        }
	        catch (Exception ex)
	        {
	        	System.out.println("Exception nek");
	        	ex.printStackTrace();
	        }
	        request.setAttribute("listNV", listNV);
	        
	        RequestDispatcher dispatcher = request.getRequestDispatcher("updatelist.jsp");
	        dispatcher.forward(request, response);
}
    //----
    //
    
    private void update(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException, ServletException 
    {
    	if(this.authorize==true) this.sessionInitialize(request, response);
    	//
    	//
    	
    	        if(request.getMethod().toString().toLowerCase().equals("get"))
    	        {
    	        	String id = request.getParameter("IDNV");
    	        	nhanvien nv = new nhanvien();
    	        	try
    	        	{
    	        		nv = nvBO.BOgetNVByID(id);
    	        		request.setAttribute("user", nv);
    	        	}
    	        	catch(Exception e)
    	        	{
    	        		e.printStackTrace();
    	        	}
    	            RequestDispatcher dispatcher = request.getRequestDispatcher("insertform.jsp");
    	            dispatcher.forward(request, response);
    	        }
    	        else if(request.getMethod().toString().toLowerCase().equals("post"))
    	        {
    	        	
    	        	String id = request.getParameter("IDNV");
    	            String name=request.getParameter("Hoten");
    	            //System.out.println(id+"  "+name);
    	            String idpb=request.getParameter("IDPB");
    	            String diachi = request.getParameter("Diachi");
    	            try
    	            {
    	            	nvBO.BOupdate(id, name, diachi, idpb);
    	            }
    	            catch(Exception nhi)
    	            {
    	            	nhi.printStackTrace();
    	            }
    	        	this.updatelist(request, response);
    	        }

    	    }
    //----------------------
    //
    //
    //---#DELETE CODE REGION
    //---#DELETE CODE REGION
    //---#DELETE CODE REGION
    private void delete(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException, ServletException 
    {
    	if(this.authorize==true) this.sessionInitialize(request, response);
    	//
    	//
    	//
    	if(request.getParameter("DeleteBtn")!=null)
    	{
    		String[] ids = request.getParameterValues("selected");
        	try
        	{
        		for(String id:ids)
        		{
        			nvBO.BOdelete(id);
        		}
        	}
        	catch(Exception ex)
        	{
        		ex.printStackTrace();
        	}
        	this.deletelist(request, response);
    	}
    	else if (request.getParameter("DeleteAllBtn")!=null) 
    	{
    		try
    		{
    			nvBO.BOdeleteAll();
    		}
    		catch (Exception ex) {}
    		this.deletelist(request, response);
    	}
    }
    private void deletelist(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException, ServletException 
    {
    	if(this.authorize==true) this.sessionInitialize(request, response);
    	//
    	//
    	//
    	
        ArrayList<nhanvien> listNV = new ArrayList<nhanvien>();
        try
        {
        	listNV = this.nvBO.BOgetNV("");
        }
        catch (Exception ex)
        {
        	System.out.println("Exception nek");
        	ex.printStackTrace();
        }
        request.setAttribute("listNV", listNV);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("deletelist.jsp");
        dispatcher.forward(request, response);
    }
    
    
    //#SEARCH REGION------------
    //#SEARCH REGION------------
    //#SEARCH REGION------------
    //#SEARCH REGION------------
    //#SEARCH REGION------------
    private void search(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException, ServletException 
    {
    	if(this.authorize==true) this.sessionInitialize(request, response);
    	//
    	//
    	//
    	if(request.getMethod().toString().toLowerCase().equals("get"))
    	{
            RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
            dispatcher.forward(request, response);
    	}
    	else if(request.getMethod().toString().toLowerCase().equals("post"))
    	{
    		String type = request.getParameter("item");
    		String searchvalue = request.getParameter("searchValue");
    		ArrayList<nhanvien> list = new ArrayList<nhanvien>();
    		
    		try
    		{
    			list =nvBO.BOsearch(type, searchvalue);
    		}
    		catch(Exception bono)
    		{
    			bono.printStackTrace();
    		}
    		//System.out.println(list.size());
    		
    		request.setAttribute("listNV", list);
    		request.setAttribute("criteria", type);
    		request.setAttribute("searchValue", searchvalue);
    		
            RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
            dispatcher.forward(request, response);
    		
    	}
    }
}
//

