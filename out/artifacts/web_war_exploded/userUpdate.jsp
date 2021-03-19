<%--
  Created by IntelliJ IDEA.
  User: 32098
  Date: 2020/6/1
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userUpdate</title>
</head>
<body>

<form method="post">
    <table>
        <tr>
            <td>UserID: </td>
            <td>
                <label>
                    <input type="text" name="userid" value="${requestScope.user.userid}" readonly="readonly"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Password: </td>
            <td><label><input type="password" name="password" value="${requestScope.user.password}"/></label></td>
        </tr>
        <tr>
            <td>UserName: </td>
            <td><label><input type="text" name="username" value="${requestScope.user.username}"/></label></td>
        </tr>
        <tr>
            <td>Tel: </td>
            <td><label><input type="text" name="tel" value="${requestScope.user.tel}"/></label></td>
        </tr>
    </table>
    <br>
    <button class="button" formaction="UpdateUser" formmethod="post">Submit</button>
</form>

</body>
</html>

