<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  <%@ include file="signin.css" %>
 </style>
</head>
<body>
   <div>
    <h2>Créer un compte</h2>
  <form action="#" method="post">
  <label for="name">Nom</label><br>
  <input type="text" id="name" name="name" required="required">
  <label for="lastname">Prénom</label><br>
  <input type="text" id="lastname" name="lastname" required="required">
  <label for="tel">Tel</label><br>
  <input type="tel" id="tel" name="tel" required="required">
  <label for="mail">Email</label><br>
  <input type="email" id="mail" name="mail" required="required">
  <label for="pass">Mot de passe</label><br>
  <input type="password" id="pass" name="pass" required="required"><br><br>
  <button type="submit">Créer un compte</button>
 </form>
 <p>Vous avez dejà un compte my-Logement ? <a href="/Projet/signup">Se connecter</a></p>
 </div>
</body>
</html>