<%-- 
    Document   : afficheliste
    Created on : Feb 4, 2018, 7:53:35 PM
    Author     : bornbygoogle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TD Menagerie</title>
    </head>
    <body>
        <h1>Liste des animaux dans la ménagerie</h1>
        <table>
            <tr>
                <td>Nom</td>
                <td>Type</td>
                <td>Cri</td>
            </tr>
            <c:forEach var="item" items="${tablesize}">        
            <tr>
                <td>${item.getNom()}</td>
                <td>${item.getClass().getName()}</td>
                <td>${item.sound()}</td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
