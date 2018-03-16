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
        
        <%
            
            out.println("<table border=1 cellpadding=10>");
          for(int a=0;a<1;a++){
                out.println("<TR>");
                for(int i=1;i<= resultat.getNbcol();i++){
                    out.println("<TD>"+resultat.getResultSetMetaData().getColumnName(i)+"</TD>");             
                }
                out.println("</TR>");
            }
            while(resultat.getResult().next()) {
            out.println("<TR>");
                for(int i=1;i<= resultat.getNbcol();i++)
                {
                    out.println("<TD>"+resultat.getResult().getString(i)+"</TD>");             
                }
                 /* out.println("<TD>"+resultat.getResult().getString(1)+"</TD>");
                  out.println("<TD>"+resultat.getResult().getString(2)+"</TD>");
                  out.println("<TD>"+resultat.getResult().getString(3)+"</TD>");
                  out.println("<TD>"+resultat.getResult().getString(4)+"</TD>");
                  out.println("<TD>"+resultat.getResult().getString(5)+"</TD>");*/
                out.println("</TR>");
            }
            out.println("</table>");
            
        %>
        
    </body>
</html>
