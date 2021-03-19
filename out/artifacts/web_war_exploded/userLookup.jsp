<%--
  Created by IntelliJ IDEA.
  User: 32098
  Date: 2020/6/2
  Time: 0:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userLookup</title>
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
            <td>UserName: </td>
            <td>
                <label>
                    <input type="text" name="username" value="${requestScope.user.username}" readonly="readonly"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Tel: </td>
            <td>
                <label>
                    <input type="text" name="tel" value="${requestScope.user.tel}" readonly="readonly"/>
                </label>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
