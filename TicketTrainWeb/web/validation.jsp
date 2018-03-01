<%-- 
    Document   : validation
    Created on : 1 mars 2018, 18:31:30
    Author     : p0607615
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tickets trains</title>
    </head>
    <body>
        <h1>Validation de l'inscription</h1>
        <div>Numero : <%=request.getAttribute("Num")%></div>
        <div>Nom : <%=request.getAttribute("Nom")%></div>
        <div>Prenom : <%=request.getAttribute("Prenom")%></div>
        <div>Type : <%=request.getAttribute("Type")%></div>
        <div>A payer : <%=request.getAttribute("Prix")%></div>
    </body>
</html>
