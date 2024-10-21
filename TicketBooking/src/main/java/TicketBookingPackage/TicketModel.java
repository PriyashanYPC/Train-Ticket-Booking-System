package TicketBookingPackage;

public class TicketModel {
    private int id;
    private String fname;
    private String lname;
    private String sstation;
    private String estation;
    private String date;
    private String time;
    private String seats;
    
	public TicketModel(int id, String fname, String lname, String sstation, String estation, String date, String time,
			String seats) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.sstation = sstation;
		this.estation = estation;
		this.date = date;
		this.time = time;
		this.seats = seats;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getSstation() {
		return sstation;
	}

	public void setSstation(String sstation) {
		this.sstation = sstation;
	}

	public String getEstation() {
		return estation;
	}

	public void setEstation(String estation) {
		this.estation = estation;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSeats() {
		return seats;
	}

	public void setSeats(String seats) {
		this.seats = seats;
	}
}
