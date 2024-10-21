<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Add Bootstrap CSS -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
  <div class="container mt-4">
    <h2>Details Table</h2>

    <!-- Search input -->
    <input type="text" id="searchInput" class="form-control mb-3" placeholder="Search...">

    <!-- Table -->
    <table class="table table-bordered table-striped">
      <thead class="thead-dark">
        <tr>
          <th>ID</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Start Station</th>
          <th>End Station</th>
          <th>Date</th>
          <th>Time</th>
          <th>No Of Seats</th>
          <th>Action</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="ticket" items="${allTickets}">
          <tr>
            <td>${ticket.id}</td>
            <td>${ticket.fname}</td>
            <td>${ticket.lname}</td>
            <td>${ticket.sstation}</td>
            <td>${ticket.estation}</td>
            <td>${ticket.date}</td>
            <td>${ticket.time}</td>
            <td>${ticket.seats}</td>
            <td>
              <a href="update.jsp?id=${ticket.id}&fname=${ticket.fname}&lname=${ticket.lname}&sstation=${ticket.sstation}&estation=${ticket.sstation}&date=${ticket.date}&time=${ticket.time}&seats=${ticket.seats}" class="btn btn-primary btn-sm mb-1">
                Update
              </a>
              <form action="DeleteServlet" method="post" class="d-inline">
                <input type="hidden" name="id" value="${ticket.id}" />
                <button type="submit" class="btn btn-danger btn-sm">Delete</button>
              </form>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>

  <script>
    function filterTable() {
      var input, filter, table, tr, td, i, txtValue;
      input = document.getElementById("searchInput");
      filter = input.value.toUpperCase();
      table = document.querySelector("table");
      tr = table.getElementsByTagName("tr");

      for (i = 1; i < tr.length; i++) { // Start from 1 to skip table header
        tr[i].style.display = "none"; // Hide all rows initially
        td = tr[i].getElementsByTagName("td");
        for (var j = 0; j < td.length; j++) {
          if (td[j]) {
            txtValue = td[j].textContent || td[j].innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
              tr[i].style.display = ""; // Show the row if the search term matches
              break; // Exit the loop if a match is found
            }
          }
        }
      }
    }

    document.getElementById("searchInput").addEventListener("input", filterTable);
  </script>

  <!-- Add Bootstrap JS and dependencies -->
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>