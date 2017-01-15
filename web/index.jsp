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
    <link rel="stylesheet" type="text/css" href="styles/index.css">
</head>


<body BACKGROUND="<c:url value='/images/background6.jpg'/>">

<form action="index" method="get">
    <div class="container">
        <%--заголовок: пользователь и кнопка "Добавить объявление"--%>
        <div class="row">
            <%--информация о пользователе--%>
            <div class="pull-right text-primary">
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
            </div>

            <%--кнопка "Добавить объявление"--%>
            <div>
                <input type="submit" name="btnIndex" value="Подать объявление" class="btn btn-primary">
            </div>
        </div>

        <%--Поиск--%>
        <div class="row">
            <div align="center">
                <input type="search" placeholder="найти...">
                <input type="submit" name="btnIndex" value="Найти">
            </div>
        </div>

        <%--Список объявлений--%>
        <div class="row">
            <div class="panel panel-default">
                <%--заголовок--%>
                <div class="panel-heading">
                    <h2 class="panel-title">Текущие объявления</h2>
                </div>

                <%--тело--%>
                <div class="panel-body">
                    <table class="table-bordered">
                        <tbody>
                            <c:forEach items="${adsList}" var="item">
                                <tr>
                                    <td>${item.getName()}</td>
                                    <td>${item.getDescription()}</td>
                                    <td>${item.getPrice()}</td>
                                    <td>${item.getCurrency()}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>



