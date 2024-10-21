package TicketBookingPackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TicketController {
	
	//connect DB
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	//insert data function
	public static boolean insertdata(String fname,String lname,String sstation,String estation,String date,String time,String seats){
		
		boolean isSuccess = false;
		try {
			//DB CONNECTION CALL
			con=DBConnection.getConnection();
			stmt=con.createStatement();
			
			//SQL QUERY
			String sql = "insert into ticket values(0,'"+fname+"','"+lname+"','"+sstation+"','"+estation+"','"+date+"','"+time+"','"+seats+"')";
			int rs = stmt.executeUpdate(sql);
			
			if(rs>0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	//GetById
	public static List<TicketModel> getById (String Id){
		
		int convertID = Integer.parseInt(Id);
		
		ArrayList <TicketModel> ticket = new ArrayList<>();
		
		try {
			//DB connection
			con=DBConnection.getConnection();
			stmt=con.createStatement();
			
			//Query
			String sql = "select * from ticket where id '"+convertID+"'";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String fname = rs.getString(2);
				String lname = rs.getString(3);
				String sstation = rs.getString(4);
				String estation = rs.getString(5);
				String date = rs.getString(6);
				String time = rs.getString(7);
				String seats = rs.getString(8);
				
				TicketModel tk = new TicketModel(id,fname,lname,sstation,estation,date,time,seats);
				ticket.add(tk);
			} 
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ticket;
	}
		//GetAll data
		public static List<TicketModel> getAllTicket(){
			
			ArrayList <TicketModel> tickets = new ArrayList<>();
			
			try {
				//DB connection
				con=DBConnection.getConnection();
				stmt=con.createStatement();
				
				//Query
				String sql = "select * from ticket";
				
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					int id = rs.getInt(1);
					String fname = rs.getString(2);
					String lname = rs.getString(3);
					String sstation = rs.getString(4);
					String estation = rs.getString(5);
					String date = rs.getString(6);
					String time = rs.getString(7);
					String seats = rs.getString(8);
					
					TicketModel tk = new TicketModel(id,fname,lname,sstation,estation,date,time,seats);
					tickets.add(tk);
				} 
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			return tickets;
		}
		//Update controller
		public static boolean updatedata(String id,String fname,String lname,String sstation,String estation,String date,String time,String seats) {
			try {
				//DB connection
				con=DBConnection.getConnection();
				stmt=con.createStatement();
				
				//SQl Query
				String sql ="update ticket set fname='"+fname+"',lname='"+lname+"',sstation='"+sstation+"',estation='"+estation+"',date='"+date+"',time='"+time+"',seats='"+seats+"'"
						+ "where id='"+id+"'";
				
				int rs = stmt.executeUpdate(sql);
				
				if(rs>0) {
					isSuccess = true;
				}
				else {
					isSuccess = false;
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			return isSuccess;
		}
		
		//Delete data
		public static boolean deletedata(String id) {
			int convID = Integer.parseInt(id);
			
			try {
				//DB Connection
				con=DBConnection.getConnection();
				stmt=con.createStatement();
				
				String sql = "delete from ticket where id='"+convID+"'";
				
                int rs = stmt.executeUpdate(sql);
				
				if(rs>0) {
					isSuccess = true;
				}
				else {
					isSuccess = false;
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			return isSuccess;
		}
}
