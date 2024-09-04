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
 <%@ include file="user.css" %>
</style>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
 <%@ include file="menu.jsp" %>
 <div class="conteneur">
   <h2>Bonjour <c:out value="${nom}"></c:out>, bienvenue sur votre espace</h2>
 </div>
 <main>
    <div class="items">
     <c:if test="${not empty services}">
      <c:forEach var="service" items="${services}" varStatus="stat">
       <div class="item">
        <div class="img">
         <img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(service.image)}" alt="image">
         <div class="option">
          <button><span class="material-icons">visibility</span></button> 
          <button><span class="material-icons">edit</span></button>
          <button onclick="deleteItem(${service.id})"><span class="material-icons">clear</span></button>
         </div>
        </div>
        <div class="describ">
         <h4><c:out value="${service.region}"></c:out></h4>
         <span><c:out value="${service.localisation}"></c:out></span>
         <span><c:out value="${service.categorie}"></c:out></span>
         <h4><c:out value="${service.prix}"></c:out> cfa</h4>
        </div>
       </div>
      </c:forEach>
     </c:if>
    </div>
  </main>
  <script type="text/javascript">
    <%@ include file="user.js" %>
   </script>
</body>
</html>