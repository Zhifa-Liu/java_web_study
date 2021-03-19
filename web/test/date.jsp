<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 32098
  Date: 2020/5/24
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Date</title>
</head>
<body>

<%!
    public String showDate(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy 年 MM 月 dd 日");
        return sdf.format(date);
    }
%>

<%= showDate()%><br/>
<%= showDate()%>

</body>
</html>
