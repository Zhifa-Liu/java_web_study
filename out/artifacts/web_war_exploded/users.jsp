<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="bean.User" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: 32098
  Date: 2020/5/24
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
    <style>
        #users{
            width:50%;
            border-collapse:collapse;
        }
        #users th{
            text-align: left;
            background-color: #3b3d3b;
            color: white;
        }
        #users tr.odd{
            background-color: white;
        }
        #users tr.even{
            background-color: #c7c5c5;
        }
        a{
            text-decoration: none;
        }
    </style>
</head>

<body>
<div>
    <table id="users">
        <tr>
            <th>Order</th>
            <th>User ID</th>
            <th>User Name</th>
            <th>User Tel</th>
            <th>Handle</th>
        </tr>

        <c:forEach items="${requestScope.users}" var="u" varStatus="us">
            <c:if test="${(us.index+1)%2!=0}">
                <tr class="odd">
                    <td>${us.index+1}</td>
                    <td>${u.userid}</td>
                    <td>${u.username}</td>
                    <td>${u.tel}</td>
                    <td>
                        <a href="LookupUser?userid=${u.userid}">查看</a>
                        <a href="PreUpdateUser?userid=${u.userid}">修改</a>
                        <a href="DeleteUser?userid=${u.userid}">删除</a>
                        <a href="signUp.jsp">添加</a>
                    </td>
                </tr>
            </c:if>
            <c:if test="${(us.index+1)%2==0}">
                <tr class="even">
                    <td>${us.index+1}</td>
                    <td>${u.userid}</td>
                    <td>${u.username}</td>
                    <td>${u.tel}</td>
                    <td>
                        <a href="LookupUser?userid=${u.userid}">查看</a>
                        <a href="PreUpdateUser?userid=${u.userid}">修改</a>
                        <a href="DeleteUser?userid=${u.userid}">删除</a>
                        <a href="signUp.jsp">添加</a>
                    </td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
    <a href="UsersPage?page=1">首页</a>
    <a href="UsersPage?page=<c:if test="${requestScope.curPage!=1}">${requestScope.curPage-1}</c:if><c:if test="${requestScope.curPage==1}">1</c:if>">上一页</a>
    <a href="UsersPage?page=<c:if test="${requestScope.curPage!=requestScope.totalPage}">${requestScope.curPage+1}</c:if><c:if test="${requestScope.curPage==requestScope.totalPage}">${requestScope.curPage}</c:if>">下一页</a>
    <a href="UsersPage?page=${requestScope.totalPage}">末页</a>
</div>

</body>
</html>
