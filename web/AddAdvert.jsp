<%--
  Created by IntelliJ IDEA.
  User: Oleksandr
  Date: 25.12.2016
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Add your advertisement</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="styles/RegistrationForm.css">

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


</head>
<body>

    <div class="container">
        <div class="row centered-form">
            <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Добавить объявление</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" enctype="multipart/form-data" action="/addadvert" method="POST">
                            <div class="row">
                                <div class="col-xs-3 col-sm-3 col-md-3">
                                    <div class="form-group">
                                        <label>Название:</label>
                                    </div>
                                </div>
                                <div class="col-xs-9 col-sm-9 col-md-9">
                                    <div class="form-group">
                                        <input type="text" name="name" class="form-control input-sm" placeholder="Название">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-3 col-sm-3 col-md-3">
                                    <div class="form-group">
                                        <label>Описание:</label>
                                    </div>
                                </div>
                                <div class="col-xs-9 col-sm-9 col-md-9">
                                    <div class="form-group">
                                        <textarea class="form-control input-sm" rows="5" style="max-width: 100%;" name="description"></textarea>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-3 col-sm-3 col-md-3">
                                    <div class="form-group">
                                        <label>Цена:</label>
                                    </div>
                                </div>
                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <div class="form-group">
                                        <input type="text" name="price" class="form-control input-sm">
                                    </div>
                                </div>
                                <div class="col-xs-5 col-sm-5 col-md-5" style="padding-left: 0px">
                                    <div class="form-group">
                                        <select name="currency" class="form-control input-sm">
                                            <option value="UAH" selected>гривна</option>
                                            <option value="USD">доллары США</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-3 col-sm-3 col-md-3">
                                    <div class="form-group">
                                        <label>Фотографии:</label>
                                        <small>Вы можете загрузить до 5 фотографий</small>
                                    </div>
                                </div>
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <input type="file" name="image"  accept="image/jpeg, image/pgn, image/gif">
                                        <input type="file" name="image" accept="image/jpeg, image/pgn, image/gif">
                                        <input type="file" name="image" accept="image/jpeg, image/pgn, image/gif">
                                        <input type="file" name="image" accept="image/jpeg, image/pgn, image/gif">
                                        <input type="file" name="image" accept="image/jpeg, image/pgn, image/gif">
                                    </div>
                                </div>

                            </div>

                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <input type="submit" name="button" value="Добавить" class="btn btn-success btn-block">

                                    </div>
                                </div>
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <input type="submit" name="button" value="Отменить" class="btn btn-default btn-block">
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
