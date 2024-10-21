<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Train Ticket Booking</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-image: url('Train.jpg');
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            background-attachment: fixed;
            height: 100vh;
        }

        .booking-box {
            margin-top: 50px;
            padding: 30px;
            background-color: rgba(255, 255, 255, 0.9); /* Transparent background */
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }

        .form-title {
            margin-bottom: 30px;
            font-weight: 600;
        }

        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100%;
        }
    </style>
</head>
<body>
   <%
        String id = request.getParameter("id");
        String fname= request.getParameter("fname");
        String lname= request.getParameter("lname");
        String sstation= request.getParameter("sstation");
        String estation= request.getParameter("estation");
        String date= request.getParameter("date");
        String time= request.getParameter("time");
        String seats= request.getParameter("seats");
%>

<div class="container">
    <div class="col-md-6">
        <div class="booking-box">
            <h2 class="text-center form-title">Ticket Booking</h2>

            <!-- Form Section -->
            <form action="UpdateServlet" method="POST">
            <!-- Id -->
            <div class="form-group">
                    <label for="firstName">ID:</label>
                    <input type="text" class="form-control" id="id" name="id" value="<%=id%>" placeholder="Enter your first name" readonly>
                </div>
                <!-- First Name -->
                <div class="form-group">
                    <label for="firstName">First Name</label>
                    <input type="text" class="form-control" id="firstName" name="fname" value="<%=fname%>" placeholder="Enter your first name" required>
                </div>

                <!-- Last Name -->
                <div class="form-group">
                    <label for="lastName">Last Name</label>
                    <input type="text" class="form-control" id="lastName" name="lname" value="<%=lname%>" placeholder="Enter your last name" required>
                </div>

                <!-- Select Start and End Station in Same Row -->
                <div class="form-row">
                    
                    <!-- Start Station -->
                    <div class="form-group col-md-6">
                        <label for="startStation">Start Station</label>
                        <select class="form-control" id="startStation" name="sstation" value="<%=sstation%>" required>
                            <option value="">-- Select Start Station --</option>
                            <option value="colombo">Colombo Fort</option>
                            <option value="kandy">Kandy</option>
                            <option value="galle">Galle</option>
                            <option value="jaffna">Jaffna</option>
                            <option value="anuradhapura">Anuradhapura</option>
                            <option value="badulla">Badulla</option>
                            <option value="matara">Matara</option>
                        </select>
                    </div>

                    <!-- End Station -->
                    <div class="form-group col-md-6">
                        <label for="endStation">End Station</label>
                        <select class="form-control" id="endStation" name="estation" value="<%=estation%>" required>
                            <option value="">-- Select End Station --</option>
                            <option value="colombo">Colombo Fort</option>
                            <option value="kandy">Kandy</option>
                            <option value="galle">Galle</option>
                            <option value="jaffna">Jaffna</option>
                            <option value="anuradhapura">Anuradhapura</option>
                            <option value="badulla">Badulla</option>
                            <option value="matara">Matara</option>
                        </select>
                    </div>
                </div>


                <!-- Select Date -->
                <div class="form-group">
                    <label for="travelDate">Travel Date</label>
                    <input type="date" class="form-control" id="travelDate" name="date" value="<%=date%>" required>
                </div>

                <!-- Select Time -->
                <div class="form-group">
                    <label for="travelTime">Travel Time</label>
                    <input type="time" class="form-control" id="travelTime" name="time" value="<%=time%>" required>
                </div>

                <!-- Number of Seats -->
                <div class="form-group">
                    <label for="seats">Number of Seats (Max 5)</label>
                    <input type="number" class="form-control" id="seats" name="seats" min="1" max="5" value="<%=seats%>" placeholder="Enter number of seats" required>
                </div>

                <!-- Submit Button -->
                <button type="submit" class="btn btn-primary btn-block">Submit</button>
            </form>
        </div>
    </div>
</div>

<!-- Bootstrap JS CDN -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>