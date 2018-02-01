<%-- 
    Document   : Calcul
    Created on : 18 janv. 2018, 17:32:49
    Author     : faycal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ma Calculatrice</title>
    </head>
    <body>
        
        <% if (request.getAttribute("Resultat")=="null" ) request.setAttribute("Resultat",""); %>
        
         <form name="Calcul" method="POST" action="CalculatriceWebServlet">
                <input type="text"  name="Op1" value="<% request.getAttribute("Op1"); %>" size="10" /> 
                <input type="text" name="Op2"  value="<% request.getAttribute("Op2"); %>" size="10" />
        <div>
            <input type="submit" value="+" name="type" />
            <input type="submit" value="-" name="type" />
            <input type="submit" value="*" name="type" />
            <input type="submit" value="/" name="type" />
        </div>
                        <input type="text" name="Resultat" label="Resulat" value="<% request.getAttribute("Resultat"); %>">
        </form>

    </body>
</html>
