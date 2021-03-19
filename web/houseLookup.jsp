<%--
  Created by IntelliJ IDEA.
  User: 32098
  Date: 2020/6/7
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>House Lookup</title>
</head>
<body>

<form method="post">
    <table>
        <tr>
            <td>ID:</td>
            <td>
                <label>
                    <input type="text" name="houseId" value="${requestScope.house.houseId}" readonly="readonly"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Title: </td>
            <td>
                <label>
                    <input type="text" name="title" value="${requestScope.house.title}" readonly="readonly"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Area: </td>
            <td>
                <label>
                    <input type="text" name="area" value="${requestScope.house.area}" readonly="readonly"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Price: </td>
            <td>
                <label>
                    <input type="text" name="price" value="${requestScope.house.price}" readonly="readonly"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Info: </td>
            <td>
                <label>
                    <input type="text" name="info" value="${requestScope.house.info}" readonly="readonly"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Type: </td>
            <td>
                <label>
                    <c:forEach items="${requestScope.hts}" var="ht">
                        <c:if test="${requestScope.house.typeId==ht.typeId}">
                            <input type="text" name="type" value="${ht.typeName}" readonly="readonly"/>
                        </c:if>
                    </c:forEach>
                </label>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
