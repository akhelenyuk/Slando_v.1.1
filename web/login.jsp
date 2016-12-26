<%--
  Created by IntelliJ IDEA.
  User: Oleksandr
  Date: 25.12.2016
  Time: 0:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Login page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="styles/RegistrationForm.css">

</head>
<body>

<c:set var="RegistrationStatusMessage" value="RegistrationStatusMessage"/>
<c:set var="error" value="error"/>

<div class="container">
    <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
            <div class="panel panel-default text-center">
                <div class="panel-heading">
                    <h3 class="panel-title ">
                            Вход в систему
                    </h3>
                </div>
                <div class="panel-body ">
                    <form role="form" action="login" method="post">
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="text" name="login" id="login" class="form-control input-sm" placeholder="Логин">
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="password" name="password" id="password" class="form-control input-sm" placeholder="Пароль">
                                </div>
                            </div>
                        </div>

                        <input type="submit" value="Войти" class="btn btn-info btn-block">
                        <a href="registration.jsp"><b>Зарегистрироваться</b></a>
                        <c:if test="${sessionScope[RegistrationStatusMessage] != null}">
                            <div class="alert alert-success">
                                <c:out value="${sessionScope[RegistrationStatusMessage]}"/>
                            </div>
                        </c:if>
                        <c:if test="${sessionScope[error] != null}">
                            <div class="alert alert alert-danger">
                                <c:out value="${sessionScope[error]}"/>
                            </div>
                        </c:if>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
