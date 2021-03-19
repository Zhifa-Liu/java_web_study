<%@ page import="bean.User" %><%--
  Created by IntelliJ IDEA.
  User: 32098
  Date: 2020/5/24
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyIndex</title>
    <style>
        p.out{
            position: absolute;
            top: 5px;
            right: 120px;
        }
        p.out a{
            text-decoration: none;
        }
        ul{
            list-style-type: none;
        }
        ul li{
            float: top;
        }
        ul li a{
            display: block;
            padding: 8px;
            text-decoration: none;
            background-color: #eee;
            color: #666;
        }
        ul li a:hover{
            background-color: #555;
            color: white;
        }
    </style>
</head>
<body>

<%
    User u = (User) session.getAttribute("user");
%>

<p>
    <%=
        "Welcome, "+u.getUsername()+". Your information is: </br>"+
                "ID: "+u.getUserid()+"</br>Name: "+u.getUsername()+"</br>Tel: "+u.getTel()
    %>
</p>
<p class="out">
    <a href="SignOutServlet">安全退出</a>
</p>


<div>
    <ul>
        <li class="active">
            <a href="ListUsers">用户管理</a>
        </li>
        <li class="active">
            <a href="ListHouses">房子管理</a>
        </li>
        <li>
            <a href="#">其它信息管理</a>
        </li>
    </ul>
</div>

</body>
</html>
