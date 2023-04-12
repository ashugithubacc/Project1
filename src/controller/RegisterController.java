package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.RegisterBo;
import com.dao.StuDao;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegisterController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    
		      response.setContentType("text/html");
		      PrintWriter pw=response.getWriter();
		      
		      String name = request.getParameter("name");
		      String pass = request.getParameter("pwd");
		
		     
		      RegisterBo rb=new RegisterBo(name,pass);
		      
		      int status=StuDao.registerData(rb);
		      
		      if(status>0) {
		    	  pw.print("Data inserted");
		    	  
		      }else {
		    	  pw.print("Not inserted");
		      }
		     
		      
		      
		
		
	}

}
