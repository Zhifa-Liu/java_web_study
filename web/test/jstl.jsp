<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 32098
  Date: 2020/6/7
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:url value="fmt.jsp" var="FormatURL" scope="request"/>
<a href="${FormatURL}">To FormatDate Test Page</a>
<br/>

<c:set var="str" value="Hello" scope="session"/>
<c:out value="${str}" default="NULL"/>
<br/>

<c:set var="score" value="96" scope="request"/>
<c:choose>
    <c:when test="${score>95}">
        优秀
    </c:when>
    <c:when test="${score>85}">
        良
    </c:when>
    <c:when test="${score>75}">
        良
    </c:when>
    <c:when test="${score>65}">
        及格
    </c:when>
    <c:otherwise>
        不及格
    </c:otherwise>
</c:choose>
<br/>

<%
    List<String> list = new ArrayList<>();
    list.add("A");
    list.add("B");
    list.add("C");
    request.setAttribute("list",list);
%>
<c:forEach items="${list}" var="str" varStatus="status">
    ${status.index+1}: ${str}
    <br/>
</c:forEach>

</body

</html>
