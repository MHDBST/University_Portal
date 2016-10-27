package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Model;

/**
 * Servlet implementation class myservlet
 */
@WebServlet("/myservlet")
public class myservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getOutputStream().write("Hello from servlet\n".getBytes());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getOutputStream().write("Hello from servlet Post\n".getBytes());
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		System.out.print("select");
		ResultSet rs = Model.select("users","pass = '"+pass+"' and userName='"+user+"'");
		try {
			if(rs != null)
			{
				System.out.println("Welcome");
				rs.getString("user");
			}
			else {
				System.out.println("Not Found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if("bahar".equals(request.getParameter("user"))){
			if("123456".equals(request.getParameter("pass"))){
				response.sendRedirect("teacher.jsp");
				return;
			}
		}
		
		response.sendRedirect("login.jsp");
	}

}
