<%--
  Created by IntelliJ IDEA.
  User: 32098
  Date: 2020/6/7
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Add</title>
</head>
<body>

<form method="post">
    <table>
        <tr>
            <td>UserID: </td>
            <td>
                <label>
                    <input type="text" name="userid"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Password: </td>
            <td><label><input type="password" name="password"/></label></td>
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
    <button class="button" formaction="AddUser" formmethod="post">Submit</button>
</form>

</body>
</html>
