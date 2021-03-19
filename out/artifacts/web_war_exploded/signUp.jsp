<%--
  Created by IntelliJ IDEA.
  User: 32098
  Date: 2020/5/24
  Time: 18:07
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
    <form>
        <table>
            <tr>
                <td>UserID: </td>
                <td><label><input type="text" name="userid"/></label></td>
            </tr>
            <tr>
                <td>Password: </td>
                <td><label><input type="password" name="password"/></label></td>
            </tr>
            <tr>
                <td>Repeat Password: </td>
                <td><label><input type="password" name="repeatPsw"/></label></td>
            </tr>
            <tr>
                <td>UserName: </td>
                <td><label><input type="text" name="username"/></label></td>
            </tr>
            <tr>
                <td>Tel: </td>
                <td><label><input type="text" name="tel"/></label></td>
            </tr>
        </table>
        <br>
        <button class="button" formaction="SignUpServlet" formmethod="post">Submit</button>
    </form>
    <label style="color: red"><%= tips %></label>
</div>

</body>
</html>
