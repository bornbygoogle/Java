<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TD Menagerie</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    
        <H2>Cr&eacute;er une application web permettant de g&eacute;rer une m&eacute;nagerie.</H2>
        <p>L'application devra comporter un formulaire de saisie des diff&eacute;rents animaux ( au choix : chat, chien et oiseau ). <br> Une fois cr&eacute;&eacute;, l'animal devrait &ecirc;tre stock&eacute; dans un tableau et un message de confirmation de cr&eacute;tion devra &ecirc;tre affich&eacute;.</p>
        <p>Le formulaire int&eacute;grera un bouton permettent de r&eacute;capituler les animaux cr&eacute;&eacute;s sous forme de tableau.</p>
        <p>L'affichage d'un animal devra comporter son nom, son esp&egrave;ce et son cri.</p>
        <form name="MenageInput" method="POST" action="Menagerie">
            <input type="texte" name="animalname" label="animalname" value=""/>
            <select id="animaltype" name="animaltype">
                <option value="chien">Chien</option>
                <option value="chat">Chat</option>
                <option value="oiseau">Oiseau</option>
            </select>
            <input type="submit" name="Creer" label="Creer" value="Cr&eacute;er"/><br>
        </form>
        <p>
           <% if (request.getAttribute("saved")==null) out.println("");
              else out.println("Un "+request.getAttribute("animaltype")+" named "+request.getAttribute("animalname")+" est ajouté dans la liste !");
           %>
        </p>
        <form name="GetMenage" method="GET" action="Menagerie">
            <input type="submit" name="Afficher la liste" label="AfficherLaListe" value="Afficher La Liste"/>
        </form>
        <div></div>  
</html>
