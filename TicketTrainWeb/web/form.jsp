<%-- 
    Document   : form
    Created on : 1 mars 2018, 18:21:11
    Author     : p0607615
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tickets de train de tourisme</title>
    </head>
    <body>
        <% if (request.getAttribute("Resultat")==null)request.setAttribute("Resultat","");  %>   
        <form action="Controller" method="POST">
            <label>Nom : </label><input type="text" name="Nom" value="" size="10" />
            <label>Prenom : </label><input type="text" name="Prenom" value="" size="10" />
            <select name="type" size="1">
                <option value="Adulte">Adulte</option>
                <option value="Enfant">Enfant</option>
                <option value="Etudiant">Etudiant</option>
            </select>
            <div><input type="text" name="Resultat" label="A Payer" value="<%=request.getAttribute("Resultat")%>">
            <input type="submit" value="Recapituler" name="action" />
            <input type="submit" value="Calculer" name="action" />      
        </form> 
    </body>
</html>
