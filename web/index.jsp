<%@ page import="pack.classes.AdsToDb" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.ResultSetMetaData" %><%--
  Created by IntelliJ IDEA.
  User: okhelenyuk
  Date: 24.11.2016
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SlandoRent</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>


<body BACKGROUND="<c:url value='/images/background4'/>">

<form action="index" method="get">

    <div class="pull-right">
        <c:set var="isLoggedIn" value="isLoggedIn"/>

        <c:if test="${sessionScope[isLoggedIn] != true}">
            <a href="index?btnIndex=Мой профиль" name="btnIndex">Мой профиль</a>
        </c:if>
        <c:if test="${sessionScope[isLoggedIn] == true}">
            <jsp:useBean id="currentUser" class="pack.classes.User" scope="session"></jsp:useBean>
            Hello,
            <jsp:getProperty name="currentUser" property="firstName"/>
            <input type="submit" name="btnIndex" class="btn btn-xs" value="Выйти">
        </c:if>
        <input type="submit" name="btnIndex" value="Подать объявление" class="btn btn-primary">
    </div>

    <div>
        <div align="center">
            <input type="search" placeholder="найти...">
            <input type="submit" name="btnIndex" value="Найти">
        </div>
        <div align="center">
            <table class="table-bordered">
                <tbody>


                <%
                    try {
                        AdsToDb adsToDb = new AdsToDb();
                        ResultSet resultSet = adsToDb.selectAll();
                        if (resultSet.next()) {
                %>
                <tr class="table-row-cell row border">

                    <%
                        for (int i = 1; i < resultSet.getMetaData().getColumnCount(); i++) {
                    %>
                    <td><%= resultSet.getString(i) %>
                    </td>
                    <%
                        }
                    %>
                    <%--<td class="col-md-4"><%= resultSet.getString(1) %></td>--%>
                    <%--<td class="col-md-4"><%= resultSet.getString(2) %></td>--%>
                    <%--<td class="col-md-4"><%= resultSet.getString(3) %></td>--%>
                </tr>
                <% while (resultSet.next()) {
                %>
                <tr class="table-row-cell row border">
                    <%
                        for (int i = 1; i < resultSet.getMetaData().getColumnCount(); i++) {
                    %>
                    <td><%= resultSet.getString(i) %>
                    </td>
                    <%
                        }
                    %>
                </tr>
                <% }
                %>
                </tbody>
            </table>
            <% } else {
            %>
            <P> Sorry, the query returned no rows! </P>
            <%
                    }
                } catch (SQLException e) {
                    System.out.println("try error");
                    e.printStackTrace();
                }

            %>

        </div>
    </div>

</form>
</body>
</html>


<%--<tr class="row border">--%>
<%--<td class="col-md-4">--%>
<%--<a href="ссылка на обьявление">--%>
<%--<img src="images//img1.jpg" class="img-rounded" alt="image1" width="170" height="130">--%>
<%--</a>--%>
<%--</td>--%>
<%--<td class="col-md-4">--%>
<%--<div>--%>
<%--<h3>--%>
<%--<a href="ссылка на обьявление">--%>
<%--Header--%>
<%--</a>--%>

<%--</h3>--%>
<%--<p>--%>
<%--Category--%>
<%--</p>--%>
<%--</div>--%>
<%--</td>--%>
<%--<td class="col-md-4">--%>
<%--<p>Price</p>--%>

<%--</td>--%>
<%--</tr>--%>