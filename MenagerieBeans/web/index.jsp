<%-- 
    Document   : index
    Created on : Mar 2, 2018, 2:10:11 PM
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
        <form action="ControlServlet" method="POST">
            <label>Nom : </label><input type="text" name="Nom" value="" size="10" />
            <select name="type" size="1">
                <option value="Chien">Chien</option>
                <option value="Chat">Chat</option>
                <option value="Oiseau">Oiseau</option>
            </select>
            <div><input type="text" name="Resultat" label="A Payer" value="<%=request.getAttribute("Resultat")%>">
            <input type="submit" value="Afficher" name="action" />
            <input type="submit" value="Creer" name="action" />      
        </form>
    </body>
</html>
