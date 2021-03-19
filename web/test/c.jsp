<%@ page import="bean.User" %><%--
  Created by IntelliJ IDEA.
  User: 32098
  Date: 2020/5/24
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page C</title>
</head>
<body>

<%
    User u = (User) request.getAttribute("user");
    Integer number = (Integer) session.getAttribute("number");
%>

<%=
"User Info:"+u.getUsername()+" "+u.getTel()+" "+u.getUserid()+"."
%>

<br/>

<%=
"Number: "+number+"."
%>

</body>
</html>
