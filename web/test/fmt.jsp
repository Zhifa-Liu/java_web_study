<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 32098
  Date: 2020/6/7
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>FMT</title>
</head>
<body>

<fmt:formatDate value="<%=new Date()%>" pattern="yyyy-MM-dd HH:mm:ss" type="both" var="date_time" scope="request"/>
${date_time}

</body>
</html>
