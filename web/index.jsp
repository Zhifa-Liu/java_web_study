<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Welcome Page</title>
    <style>
      body{
        text-align: center;
      }
      div{
        background-color: antiquewhite;
      }
      a{
        text-decoration: none;
      }
    </style>
  </head>
  <body>
    <div>
      <p>Welcome to XXX System!</p>
      <a href="${pageContext.request.contextPath}/signIn.jsp">Click to SignIn</a>
      <a href="${pageContext.request.contextPath}/signUp.jsp">Click to SignUp</a>
    </div>
  </body>
</html>