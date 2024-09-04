<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Base64" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link href="https://fonts.googleapis.com/css2?family=Josefin+Sans&family=Poppins:ital,wght@0,100;0,200;0,300;1,100;1,200&family=Roboto:wght@300;400;500&display=swap" rel="stylesheet">
 <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<style type="text/css">
 <%@ include file="acceuil.css" %>
</style>
</head>
<body>
  
  <%@ include file="menu.jsp" %>
    
  <div class="conteneur">
   <div class="cont1">
    <h1>Trouvez l'immobilier qui vous convient</h1>
    <span>my-Logement vous offre la possibilité de publier ou de rechercher un bien immobilier dans la commodité et dans la diligeance</span>
   </div>   
   <div class="search">
    <form action="Acceuil" method="Post">
     <div class="group">
      <input type="text" name="lieu" placeholder="Localisation">
      <span class="material-icons">place</span>
     </div>
     <div class="group">
      <input type="text" name="type" placeholder="Type">
      <span class="material-icons">home</span>
     </div>
     <div class="group">
      <input type="text" name="budget" placeholder="Budget">
      <span class="material-icons">attach_money</span>
     </div>
     <button>Rechercher</button>
    </form>
   </div>
   
  </div>
  <main>
    <div class="items">
     <c:if test="${not empty services}">
      <c:forEach var="service" items="${services}" varStatus="stat">
        <a href="/Projet/Decouvre?id=${service.id}">
       <div class="item">
        <div class="img">
         <img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(service.image)}" alt="image">
        </div>
        <div class="describ">
         <h4><c:out value="${service.region}"></c:out></h4>
         <span><c:out value="${service.localisation}"></c:out></span>
         <span><c:out value="${service.categorie}"></c:out></span>
         <h4><c:out value="${service.prix}"></c:out> cfa</h4>
        </div>
       </div>
     </a>
      </c:forEach>
     </c:if>
    </div>
  </main>
</body>
</html>