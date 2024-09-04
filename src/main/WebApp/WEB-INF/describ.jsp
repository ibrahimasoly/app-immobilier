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
<link href="https://fonts.googleapis.com/css2?family=Josefin+Sans&family=Poppins:ital,wght@0,100;0,200;0,300;1,100;1,200&family=Roboto:wght@300;400;500&display=swap"
 rel="stylesheet">
 <style type="text/css">
  <%@ include file="describ.css" %>
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
   <div class="step active">
    <p>3</p>
   </div>
  </div>
  
  <!-- form -->
  <form action="describ" method="post">
   <div class="input-group">
     <input type="text" id="surface" name="surface" placeholder="Surface">
   </div>
   <div class="input-group">
     <input type="text" id="chambre" name="chambre" placeholder="Nombre de chambre">
   </div>
   <div class="input-group">
     <input type="text" id="salon" name="salon" placeholder="Nombre de salon">
   </div>
   <div class="input-group">
     <input type="text" id="douche" name="douche" placeholder="Nombre de douche">
   </div>
   <div class="input-group">
     <input type="text" id="cuisine" name="cuisine" placeholder="Nombre de cuisine">
   </div>
   <div class="input-group">
     <input type="text" id="etage" name="etage" placeholder="Nombre d'étage">
   </div>
   <div class="input-group">
     <textarea rows="5" cols="10" name="describ" placeholder="Description"></textarea>
   </div>
   <div class="btn-cont">
    <input type="submit" value="Terminer" name="btn" class="btn width-50 ml-auto">
   </div>
  </form>
</body>
</html>