<%--
  Created by IntelliJ IDEA.
  User: 32098
  Date: 2020/6/7
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>House Insert</title>
</head>
<body>

<form method="post">
    <table>
        <tr>
            <td>Title: </td>
            <td>
                <label>
                    <input type="text" name="title"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Area: </td>
            <td>
                <label>
                    <input type="text" name="area"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Price: </td>
            <td>
                <label>
                    <input type="text" name="price"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Info: </td>
            <td>
                <label>
                    <input type="text" name="info"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Type: </td>
            <td>
                <label>
                    <select name="type">
                        <c:forEach items="${requestScope.hts}" var="ht">
                            <option value="${ht.typeId}">${ht.typeName}</option>
                        </c:forEach>
                    </select>
                </label>
            </td>
        </tr>
    </table>
    <button class="button" formaction="AddHouse" formmethod="post">Submit</button>
</form>

</body>
</html>
