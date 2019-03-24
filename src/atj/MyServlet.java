package atj;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet(description = "Servlet konwertera IS", urlPatterns= {"/MyServlet"})
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private double tem;
	private String action;
	private String result;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		tem = Double.parseDouble(request.getParameter("tem"));// zadanie paramentry tem zamienionego na double
		action = request.getParameter("action"); // zadanie parameru action 
		Convert();
		request.setAttribute("result",result);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Konwerter.jsp"); 
		requestDispatcher.forward(request, response);
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void Convert() {
	if (action.equals("celsius")) { double temp = (1.8*tem)+32; result = temp + "F";}
	else if(action.equals("farenheit")) {double temp = ((tem-32)*5)/9; result = temp + "C";}
	}
	
}
