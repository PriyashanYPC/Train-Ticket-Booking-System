package TicketBookingPackage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String fname= request.getParameter("fname");
	    String lname= request.getParameter("lname");
	    String sstation= request.getParameter("sstation");
	    String estation= request.getParameter("estation");
	    String date= request.getParameter("date");
	    String time= request.getParameter("time");
	    String seats= request.getParameter("seats");
	    
	    boolean isTrue;
	    
	    isTrue = TicketController.insertdata(fname,lname,sstation,estation,date,time,seats);
	    
	    if(isTrue == true) {
	    	String alertMessage ="Data Insert Successful";
	    	response.getWriter().println("<script> alert('"+alertMessage+"'); window.location.href='GetAllServlet'</script>");
	    }
	    else {
	    	RequestDispatcher dis2 = request.getRequestDispatcher("wrong.jsp");
	    	dis2.forward(request,response);
	    }
	}

}
