package ru.specialist;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServerTimeServlet
 */
@WebServlet("/ServerTime")
public class ServerTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServerTimeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		PrintWriter out =response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<body>");
		out.println("<h1>");
		
		Date now = new Date();
		out.println(now.toLocaleString());
		
		out.println("</h1>");
		out.println("</body>");
		out.println("</head>");
		out.println("</html>");
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
