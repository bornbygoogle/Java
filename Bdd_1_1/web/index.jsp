<%-- 
    Document   : index
    Created on : 15 mars 2018, 22:38:26
    Author     : faycal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
    </head>
    <body>
        <%-- jsp servant de point d'entrée à l'application et redirigeant directement vers le servlet controleur--%>
        <% response.sendRedirect("Controleur");%>
    </body>
</html>
