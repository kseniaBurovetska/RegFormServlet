<web-app xmlns="http://java.sun.com/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
         version="3.0">

  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>


  <html>
  <head>
    <title>All</title>


    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css"/>

  </head>
  <body>

  <nav class="navbar navbar-expand-lg sticky-top navbar-default">
    <a class="navbar-brand my-2">Registration Form</a>

    <div class="collapse navbar-collapse ml-4">
      <ul class="navbar-nav">

        <li class="nav-item active">
          <a class="nav-link" href="${pageContext.request.contextPath}/app/login">Home</a>
        </li>

      </ul>
    </div>
  </nav>


  <br><br>

  <div class="container-fluid">

    <h2>All Users</h2>

    <table class="table my-3">

      <thead>
      <tr>
        <th scope="col">FirstName</th>
        <th scope="col">LastName</th>
        <th scope="col">Login</th>
        <th scope="col">Email</th>
      </tr>
      </thead>

      <tbody>

      <c:forEach var="user" items="${users}">
        <tr>
          <td>${user.value.firstName}</td>
          <td>${user.value.lastName}</td>
          <td>${user.value.login}</td>
          <td>${user.value.email}</td>
        </tr>
      </c:forEach>

      </tbody>
    </table>
  </div>
  </body>
  </html>
</web-app>
