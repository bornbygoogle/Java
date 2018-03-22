<%-- 
    Document   : resultat
    Created on : 4 mars 2018, 20:29:48
    Author     : faycal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultat</title>
    </head>
    <body>
        <jsp:useBean id="resultat" class="beans.resultatrequete" scope="request" />
        <form name="Result" action="Controleur" method="POST">
        
        <%            
            out.println("<table border=1 cellpadding=10>");
            while(resultat.getResult().next()) {
                out.println("<TR>");
                out.println("<TD> <input type=submit value="+resultat.getResult().getString(1)+" name=Operation /></TD>");
                out.println("<TD>"+resultat.getResult().getString(2)+"</TD>");
                out.println("<TD>"+resultat.getResult().getString(3)+"</TD>");
                out.println("<TD>"+resultat.getResult().getString(4)+"</TD>");
                out.println("<TD>"+resultat.getResult().getString(5)+"</TD>");
                out.println("</TR>");
            }
            out.println("</table>");
            
        %>
        </form>
    </body>
</html>
