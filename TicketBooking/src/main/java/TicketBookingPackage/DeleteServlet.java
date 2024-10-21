package TicketBookingPackage;

import java.io.IOException;
import java.util.List;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
        boolean isTrue;
        isTrue = TicketController.deletedata(id);
        if(isTrue == true) {
        	String alterMessage = "Data delete Successful";
        	response.getWriter().println("<script>alert('"+alterMessage+"');"+"window.location.href='GetAllServlet';</script>");
        }
        else {
        	List<TicketModel> ticketDetails = TicketController.getById(id);
        	request.setAttribute("ticketDetails", ticketDetails);
        	
        	RequestDispatcher dispatcher = request.getRequestDispatcher("wrong.jsp");
        	dispatcher.forward(request,response);
	}

	}
}
