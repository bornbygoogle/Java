<%-- 
    Document   : affiche
    Created on : Mar 2, 2018, 2:48:47 PM
    Author     : bornbygoogle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menagerie en Beans</title>
    </head>
    <body>
        <h1>Affiche</h1>
        <jsp:useBean id="monbean" class="Menagerie.AnimalBean" scope="request" />
        <jsp:getProperty name="monbean" property="name" />
        <jsp:getProperty name="monbean" property="type" />
        <jsp:getProperty name="monbean" property="cri" />
    </body>
</html>
