<%--
  Created by IntelliJ IDEA.
  User: 32098
  Date: 2020/5/24
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign In</title>
    <link rel="stylesheet" type="text/css" href="sign.css"/>
</head>
<body>

<%
    String tips = (String) request.getAttribute("tips");
    if(tips==null){
        tips = "";
    }
%>

<div>
    <form method="post">
        <table>
            <tr>
                <td>UserID: </td>
                <td><label><input type="text" name="userid"/></label></td>
            </tr>
            <tr>
                <td>Password: </td>
                <td><label><input type="password" name="password"/></label></td>
            </tr>
        </table>
        <br>
        <button class="button" formaction="SignInServlet" formmethod="post">SignIn</button>
        <button class="button" formaction="SignInServlet" formmethod="get">SignUp</button>
    </form>
    <br/>
    <label style="color: red"><%= tips %></label>
</div>

</body>
</html>
