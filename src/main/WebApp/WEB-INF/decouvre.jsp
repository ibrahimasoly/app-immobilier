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
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Josefin+Sans&family=Poppins:ital,wght@0,100;0,200;0,300;1,100;1,200&family=Roboto:wght@300;400;500&display=swap" rel="stylesheet">
 <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<style type="text/css">
 <%@ include file="decouvre.css" %>
</style>
</head>
<body>
     <%@ include file="menu.jsp" %>
     
     <div class="conteneur">
     <div class="share">
     <h3><span class="material-icons">place</span> Situé à <c:out value="${service.region}"></c:out>, quartier <c:out value="${service.localisation}"></c:out></h3>
     <h4><span class="material-icons">share</span> Partagez</h4>
     <h4><span class="material-icons">favorite_border</span> Aimez</h4>
     </div>
     
      <div class="slideshow-container">
        <div class="mySlides fade">
            <img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(service.image)}" alt="Image 1">
        </div>
        <c:forEach var="image" items="${images}" varStatus="status">
         <div class="mySlides fade">
            <img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(image.img)}" alt="image">
        </div>
        </c:forEach>

        <button class="prev" onclick="plusSlides(-1)">&#10094;</button>
        <button class="next" onclick="plusSlides(1)">&#10095;</button>
        
        <div style="text-align:center">
        	<span class="dot" onclick="currentSlide(1)"></span>
        	<c:forEach var="image" items="${images}" varStatus="status">        
        	  <span class="dot" onclick="currentSlide(${status.count+1})"></span>
        	</c:forEach>
    <!-- Ajoutez plus de spans pour chaque image -->
        </div>
    </div>
    <div class="contain">
    
     <div class="titles">
      <div class="title active" data-anim="1">Les détails</div>
      <div class="title" data-anim="2">La carte</div>
    </div>
    
    <div class="box">
    <div class="box-child activeContenu price" data-anim="1">
    
    <div class="describ">
     <div class="detaille">
      <h2>Prix :  <c:out value="${service.prix}"></c:out> CFA</h2>
      <span>${describ.describ}</span>
     </div>
     <div class="compte">
       <div class="profil">
        <div class="img"><span class="material-icons">account_circle</span></i></div>
        <div class="name">
         <h5>Agence</h5>
         <h6>Sanogo Mohamed</h6>
        </div>
        <div class="other">
        <span class="material-icons">chevron_right</span>
        </div>
       </div>
       <div class="contact">
        <span class="material-icons">phone</span>
        <span class="material-icons">mail</span>
        <span class="material-icons">insert_comment</span>
       </div>
     </div>
    </div>
    
     <div class="items">
       <div class="item"><h2><c:out value="${service.categorie}"></c:out></h2></div>
       <div class="item"><h5><span class="material-icons">terrain</span>Surface</h5><span class="val"><c:out value="${describ.surface}"></c:out></span></div>
       <div class="item"><h5><span class="material-icons">king_bed</span>Chambre</h5><span class="val"><c:out value="${describ.chambre}"></c:out></span></div>
       <div class="item"><h5><span class="material-icons">meeting_room</span>Salon</h5><span class="val"><c:out value="${describ.salon}"></c:out></span></div>
       <div class="item"><h5><span class="material-icons">bathroom</span>Salle de bain</h5><span class="val"><c:out value="${describ.douche}"></c:out></span></div>
       <div class="item"><h5><span class="material-icons">room_service</span>Cuisine</h5><span class="val"><c:out value="${describ.cuisine}"></c:out></span></div>
       <div class="item"><h5><i class="fa-solid fa-bars-staggered"></i>Etage</h5><span class="val"><c:out value="${describ.etage}"></c:out></span></div>
     </div>
     
    </div>
    <div class="box-child" data-anim="2">Google maps</div> 
    </div>
    
    </div>
    
     </div>
    <script type="text/javascript">
   <%@ include file="decouvre.js" %>
  </script>
  <script type="text/javascript">
   <%@ include file="tableLayout.js" %>
  </script>
</body>
</html>