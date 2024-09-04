<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" 
integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" 
crossorigin="anonymous" referrerpolicy="no-referrer" />

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Josefin+Sans&family=Poppins:ital,wght@0,100;0,200;0,300;1,100;1,200&family=Roboto:wght@300;400;500&display=swap"
 rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style type="text/css">
 <%@ include file="admin.css" %>
</style>
</head>
<body>
  <header>
   <h3>Dashboard</h3>
  </header>
  <section class="side">
   <div class="top">
    <h2>Administrateur</h2>
   </div>
   <div class="nav-links">
   <li><i class="fa-solid fa-table-columns"></i><a class="nav-link" href="#">Dashboard</a></li>
   <li><i class="fa-solid fa-house"></i><a class="nav-link" href="#">Maison</a></li>
   <li><i class="fa-solid fa-building"></i><a class="nav-link" href="#">Appartement</a></li>
   <li><i class="fa-solid fa-hotel"></i><a class="nav-link" href="#">Hotel</a></li>
   </div>
   <div class="bottom">
    <li><a class="nav-link" href="/Projet/Acceuil">Retourne à la maison</a></li>
   </div>
  </section>
  <main>
   <div class="item d">
   <p class="nbr a1"><a href="#">5,000 </a></p>
   <p class="name"><a href="#">nombre total d'appartement</a></p>
   </div>
   <div class="item d">
   <p class="nbr a2"><a href="#">2,000 </a></p>
   <p class="name"><a href="#">nombre total de maison</a></p>
   </div>
   <div class="item d">
   <p class="nbr a3"><a href="#">1,000 </a></p>
   <p class="name"><a href="#">nombre total d'hotel</a></p>
   </div>
   <div class="item table">
   
    <table id="table">
      <thead>
        <tr>
        <th>Identifiant</th>
        <th>Nom</th>
        <th>Prénom</th>
        <th>Tel</th>
        <th>Email</th>
        <th>Mot de passe</th>
        </tr>
      </thead>
      <tbody>
       <c:forEach items="${users}" var="user">
        <tr>
         <td><c:out value="${user.id}"/></td>
         <td><c:out value="${user.name}"/></td>
         <td><c:out value="${user.lastname}"/></td>
         <td><c:out value="${user.tel}"/></td>
         <td><c:out value="${user.email}"/></td>
         <td><c:out value="${user.pass}"/></td>
        </tr>
       </c:forEach>
      </tbody>
    </table>
   
   </div>
   <div class="item form">
   <form action="admin" method="post">
   <label for="id">Identifiant</label><br>
  <input type="text" id="idi" required="required" name="id"><br>
  <label for="name">Nom</label><br>
  <input type="text" id="name" required="required" name="name"><br>
  <label for="lastname">Prénom</label><br>
  <input type="text" id="lastname" required="required" name="lastname"><br>
  <label for="tel">Tel</label><br>
  <input type="text" id="tel" required="required" name="tel"><br>
  <label for="mail">Email</label><br>
  <input type="email" id="mail" required="required" name="mail"><br>
  <label for="pass">Mot de passe</label><br>
  <input type="password" id="pass" required="required" name="pass"><br>
   <div class="btn_radio">
    <div class="radio">
    <div>
    <input type="radio" id="insere" name="radio" required="required" value="save">
     <label for="insere">Save</label>
    </div>
    <div>
    <input type="radio" id="modifier" name="radio" required="required" value="update">
     <label for="modifier">Update</label>
    </div>
    <div>
     <input type="radio" id="sup" name="radio" required="required" value="delete">
     <label for="sup">Delete</label>
    </div>
    <div>
     <input type="radio" id="voir" name="radio" required="required" value="more">
     <label for="sup">More</label>
    </div>
    </div>
    <div class=".btn">
      <input type="submit" value="Confirmer">
    </div>
   </div>
 </form>
   </div>
  </main>
  <script type="text/javascript">
    <%@ include file="admin_javascript.js" %>
   </script>
</body>
</html>