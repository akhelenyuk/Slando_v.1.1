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
        <table class="table-bordered">
            <tbody>
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
            <%
                try{
                    AdsToDb adsToDb = new AdsToDb();
                    ResultSet resultSet = adsToDb.selectAll();
                    if(resultSet.next()){
            %>
                <tr class="table-row-cell row border">
                    <c:out value="Hello! JSTL is cool"/>

                    <%
                        for (int i = 1; i < resultSet.getMetaData().getColumnCount(); i++) {
                    %>
                        <td><%= resultSet.getString(i) %></td>
                    <%
                        }
                    %>
                   <%--<td class="col-md-4"><%= resultSet.getString(1) %></td>--%>
                   <%--<td class="col-md-4"><%= resultSet.getString(2) %></td>--%>
                   <%--<td class="col-md-4"><%= resultSet.getString(3) %></td>--%>
                </tr>
                <%     while (resultSet.next()) {
                %>
                <tr class="table-row-cell row border">
                    <%
                        for (int i = 1; i < resultSet.getMetaData().getColumnCount(); i++) {
                    %>
                    <td><%= resultSet.getString(i) %></td>
                    <%
                        }
                    %>
                </tr>
                <% }
                %>
            </tbody>
        </table>
        <%  }
        else {
        %>
        <P> Sorry, the query returned no rows! </P>
        <%
                }
            } catch(SQLException e){
                System.out.println("try error");
                e.printStackTrace();
            }

        %>

    </div>
</div>


</body>
</html>



<%--ResultSetMetaData resultSetMetaData = adsToDb.selectAll();--%>
<%--if(resultSetMetaData!=null){--%>
<%--for(int i = 1; i<resultSetMetaData.getColumnCount(); i++)--%>
<%--{%>--%>
<%--<p><%=resultSetMetaData.getColumnName(i)%></p>--%>
<%--&lt;%&ndash;%>
    <%--}--%>
<%--%>--%>
<%--}--%>
<%--else System.out.println("nothing");%>--%>