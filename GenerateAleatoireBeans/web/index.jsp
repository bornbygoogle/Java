<%-- 
    Document   : index
    Created on : Mar 2, 2018, 1:00:47 PM
    Author     : bornbygoogle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bonjour !!</h1>
        <jsp:useBean id="monbean" class="generateAleatoire.generateAleatoireBean" scope="request" />
        <jsp:getProperty name="monbean" property="alea" />
    </body>
</html>
