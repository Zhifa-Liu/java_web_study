<%@ page import="bean.User" %><%--
  Created by IntelliJ IDEA.
  User: 32098
  Date: 2020/5/24
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page A</title>
</head>
<body>

<%@include file="head.jsp"%>

<%
    session.setAttribute("msg","Welcome");
    request.setAttribute("user",new User("101","123456","Tom","12378901231"));
    request.getRequestDispatcher("b.jsp").forward(request, response);
%>

<%@include file="footer.jsp"%>

</body>
</html>
