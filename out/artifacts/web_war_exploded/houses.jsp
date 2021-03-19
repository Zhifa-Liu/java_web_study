<%--
  Created by IntelliJ IDEA.
  User: 32098
  Date: 2020/6/7
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Houses</title>
    <style>
        a{
            text-decoration: none;
        }

        ul.pagination {
            display: inline-block;
            padding: 0;
            margin: 0;
        }

        ul.pagination li {display: inline;}

        ul.pagination li a {
            color: black;
            float: left;
            padding: 8px 16px;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color .3s;

        }
    </style>
</head>

<body>
<div>
    <table id="users">
        <tr>
            <th>Order</th>
            <th>Title</th>
            <th>Area</th>
            <th>Price</th>
            <th>Info</th>
            <th>Type</th>
            <th>Handle</th>
        </tr>

        <c:forEach items="${requestScope.houses}" var="h" varStatus="hs">
            <tr>
                <td>${hs.index+1}</td>
                <td>${h.title}</td>
                <td>${h.area}</td>
                <td>${h.price}</td>
                <td style="width: 240px">${h.info}</td>
                <td>
                    <c:forEach items="${requestScope.hts}" var="ht">
                        <c:if test="${h.typeId==ht.typeId}">
                            ${ht.typeName}
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <a href="LookupHouse?houseId=${h.houseId}">查看</a>
                    <a href="PreUpdateHouse?houseId=${h.houseId}">修改</a>
                    <a href="DeleteHouse?houseId=${h.houseId}">删除</a>
                    <a href="PreAddHouse">添加</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <ul class="pagination">
        <a href="HousesPage?page=<c:if test="${requestScope.curPage!=1}">${requestScope.curPage-1}</c:if><c:if test="${requestScope.curPage==1}">1</c:if>">&#60;</a>
        <%
            for (int i=1; i<=(int)request.getAttribute("totalPage"); i++) {
        %>
                <a href="HousesPage?page=<%=i%>"><%=i%></a>
        <%
            }
        %>
        <a href="HousesPage?page=<c:if test="${requestScope.curPage!=requestScope.totalPage}">${requestScope.curPage+1}</c:if><c:if test="${requestScope.curPage==requestScope.totalPage}">${requestScope.curPage}</c:if>">&gt;</a>
    </ul>
</div>

</body>
</html>
