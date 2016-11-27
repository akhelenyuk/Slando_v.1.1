<%--
  Created by IntelliJ IDEA.
  User: okhelenyuk
  Date: 24.11.2016
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SlandoRent</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>

<div>
    <div align="center">

        <input type="search" placeholder="найти...">
        <input type="submit" value="Найти">
    </div>
    <div align="center">
        <table>
            <tbody>
                <tr class="table-row-cell">
                   <td>
                       <table class="table-bordered">
                           <tbody>
                                <tr class="row border">
                                    <td class="col-md-4">
                                        <a href="ссылка на обьявление">
                                            <img src="images//img1.jpg" class="img-rounded" alt="image1" width="170" height="130">
                                        </a>
                                    </td>
                                    <td class="col-md-4">
                                        <div>
                                            <h3>
                                                <a href="ссылка на обьявление">
                                                    Header
                                                </a>

                                            </h3>
                                            <p>
                                                Category
                                            </p>
                                        </div>
                                    </td>
                                    <td class="col-md-4">
                                        <p>Price</p>

                                    </td>
                                </tr>
                           </tbody>
                       </table>
                   </td>
                   <td>222</td>
                    <c:out value="Hello! JSTL is cool"/>
                   <td>333</td>
                </tr>

            </tbody>
        </table>
    </div>
</div>


</body>
</html>
