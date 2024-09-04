<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" 
integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" 
crossorigin="anonymous" referrerpolicy="no-referrer" />

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Josefin+Sans&family=Poppins:ital,wght@0,100;0,200;0,300;1,100;1,200&family=Roboto:wght@300;400;500&display=swap"
 rel="stylesheet">

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style type="text/css">
 <%@ include file="style.css" %>
</style>
 </head>
 <body>
  <header class="head">
   <div class="logo">
     my-Logement
   </div>
    <div class="search-bar">
      <a href="/Projet/Acceuil">Home</a>
      <a href="#">Propriétés</a>
      <a href="#">Agences</a>
      <a href="#">Maisons</a>
      <a href="#">Appartement</a>
     </div>
   <nav class="nav-link">
        <li> <a class="signup" href="/Projet/Signup">Mon compte</a></li>
        <li> <a class="dpa" href="/Projet/service">Publier</a></li>
   </nav>
   <div class="btn-hamb">
      <button class="hamb">
      <span class="line l1"></span>
      <span class="line l2"></span>
      <span class="line l3"></span>
   </button>
   </div>
  </header>
   <script type="text/javascript">
    <%@ include file="menu.js" %>
   </script>
  </body>
  </html>