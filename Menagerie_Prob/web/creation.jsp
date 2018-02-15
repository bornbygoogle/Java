<%-- 
    Document   : creation
    Created on : 30 janv. 2018, 15:48:51
    Author     : faycal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menagerie</title>
    </head>
    <body>
        <form name="Creation" action="Create" method="POST">
            <input type="text" name="Nom" value="" size="10" />
            <select name="type" size="1">
                <option>Chien</option>
                <option>Chat</option>
                <option>Oiseau</option>
            </select>
            <input type="submit" value="Créer" name="B_CREAT" />
            
        </form>
        <form name="Liste" action="Liste" method="POST">
            <input type="submit" value="Afficher la liste" name="Liste"  />
        </form>
    </body>
</html>
