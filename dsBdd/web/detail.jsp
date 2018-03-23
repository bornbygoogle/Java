<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail</title>
    </head>
    <body>
        <jsp:useBean id="resultat" class="beans.resultatrequete" scope="request" />
         <%--déplacement dans le resultset au prochain enregistrement valide, erreur sinon--%>
        <%resultat.getResult().next();%>
        <form name="inscription" action="Controleur" method="POST">
            <p>
                <label for="numero">Numero</label>
                <input type="text" name="numero" value="<%=resultat.getResult().getString("CUSTOMER_ID")%>" size="30" id="numero" />
            </p>
            <p>
                <label for="nom">Nom</label>
                <input type="text" name="nom" value="<%=resultat.getResult().getString("NAME")%>" size="30" id="nom" />
            </p>
            <p>
            <label for="adresse">Adresse</label>
            <input type="text" name="adresse" value="<%=resultat.getResult().getString("ADDRESSLINE1")%>" size="30" id="adresse" />
            </p>
            <p>
            <label for="telephone">Téléphone</label>
            <input type="text" name="telephone" value="<%=resultat.getResult().getString("PHONE")%>" size="30" id="tel" />
            </p>
            <p>
            <label for="email">E-mail</label>
            <input type="text" name="email" value="<%=resultat.getResult().getString("EMAIL")%>" size="30" id="email"/>
            </p>
            <input type="submit" value="Modifier" name="Operation" />
            <input type="submit" value="Supprimer" name="Operation" />
        </form>
    </body>
</html>
