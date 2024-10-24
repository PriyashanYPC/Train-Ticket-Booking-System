package TicketBookingPackage;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    String id = request.getParameter("id");
		    String fname= request.getParameter("fname");
		    String lname= request.getParameter("lname");
		    String sstation= request.getParameter("sstation");
		    String estation= request.getParameter("estation");
		    String date= request.getParameter("date");
		    String time= request.getParameter("time");
		    String seats= request.getParameter("seats");
		    
		    boolean isTrue;
		    isTrue = TicketController.updatedata(seats,fname, lname, sstation, estation, date, time, seats);
		    
		    if(isTrue == true) {
		    	List<TicketModel> ticketdetails = TicketController.getById(id);
		    	request.setAttribute("ticketdetails", ticketdetails);
		    	
		    	String alertMessage = "Data Update Successful";
		    	response.getWriter().println("<script> alert('"+alertMessage+"'); window.location.href='GetAllServlet'</script>");
		    	
		    }else {
		    	RequestDispatcher dis2 = request.getRequestDispatcher("wrong.jsp");
		    	dis2.forward(request,response);
		    }
     }
 }
