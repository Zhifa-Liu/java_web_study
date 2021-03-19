<jsp:useBean id="user" scope="request" type="bean.User"/>
<jsp:useBean id="msg" scope="session" type="java.lang.String"/>
<%--
  Created by IntelliJ IDEA.
  User: 32098
  Date: 2020/5/24
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page B</title>
</head>
<body>

<%@include file="head.jsp"%>

<%--<%--%>
<%--    session.setAttribute("number",120);--%>
<%--    request.getRequestDispatcher("c.jsp").forward(request, response);--%>
<%--%>--%>

Session Msg:${msg}
<br/>
User Info:<br/>
ID:${user.userid}
<br/>
Name:${user.username}
<br/>
Tel:${user.tel}
<br/>

<%@include file="footer.jsp"%>

<%  %>

</body>
</html>
