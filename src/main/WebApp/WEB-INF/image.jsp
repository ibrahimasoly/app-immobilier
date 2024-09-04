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
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
 <style type="text/css">
  <%@ include file="image.css" %>
 </style>
</head>
<body>
   <!-- progress -->
  <div class="progress">
   <div class="step active after">
    <p>1</p>
   </div>
   <div class="step active after">
    <p>2</p>
   </div>
   <div class="step">
    <p>3</p>
   </div>
  </div>
  
  <!-- form -->
  <form action="image" method="post" enctype="multipart/form-data">
   <label for="image">
   <span class="material-icons">upload_file</span>
   Autres une image
   </label>
   <input type="file" name="image" id="image" accept="image/*" required="required" class="image"><br>
   <input type="submit" value="Enregistrer" class="btn">
   </form>
   <div class="next-prev">
      <a href="/Projet/service" class="prev">Retour</a>
      <a href="/Projet/describ" class="next">Suivant</a>
   </div>
</body>
</html>