<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" 
integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" 
crossorigin="anonymous" referrerpolicy="no-referrer" />

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Josefin+Sans&family=Poppins:ital,wght@0,100;0,200;0,300;1,100;1,200&display=swap" 
 rel="stylesheet">
 <style type="text/css">
  <%@ include file="signup.css" %>
 </style>
</head>
<body>

 <div>
    <c:if test="${not empty reponse}">
    <p><c:out value="Message : ${reponse}"></c:out></p>
    </c:if>
    
    <h2>Connexion au compte</h2>
  <form action="#" method="post">
  
  <label for="nom">Nom d'utilisateur</label><br>
  <input type="text" id="nom" name="login" required="required">
  
  <label for="pass">Mot de passe</label><br>
  <input type="password" id="pass" name="pass" required="required">
  
  <button type="submit">Se connecter</button>
 </form>
 <p>Vous n'avez pas de compte my-Logement ? <a href="/Projet/signin">Créer un compte</a></p>
 </div>

</body>
</html>