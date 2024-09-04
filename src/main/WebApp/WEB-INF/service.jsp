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
<link href="https://fonts.googleapis.com/css2?family=Josefin+Sans&family=Poppins:ital,wght@0,100;0,200;0,300;1,100;1,200&family=Roboto:wght@300;400;500&display=swap"
 rel="stylesheet">
 <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
 <style type="text/css"><%@ include file="service.css" %></style>
 <style type="text/css"><%@ include file="toast.css" %></style>
</head>
<body>
  
  <!-- progress -->
  <div class="progress">
   <div class="step active after">
    <p>1</p>
   </div>
   <div class="step after">
    <p>2</p>
   </div>
   <div class="step">
    <p>3</p>
   </div>
  </div>
  
  <!-- form -->
  <form action="service" method="post" enctype="multipart/form-data">
   <div class="input-group">
     <label for="region">Région</label>
     <input type="text" id="region" name="region" required="required">
   </div>
   <div class="input-group">
     <label for="local">Localisation</label>
     <input type="text" id="local" name="local" required="required">
   </div>
   <div class="input-group">
     <label for="prix">Prix</label>
     <input type="text" id="prix" name="prix" required="required">
   </div>
   <div class="input-group">
     <label for="cat">Categorie</label>
     <input type="text" id="cat" name="cat" placeholder="maison, appartement, hotel" required="required">
   </div>
   <div class="input-group file">
     <label for="image">
     <span class="material-icons">upload_file</span>
     Une image principale
   </label>
   <input type="file" name="image" id="image" accept="image/*" required="required" class="image"><br>
   </div>
   <div class=" ">
    <input type="submit" value="next" name="btn" class="btn width-50 ml-auto">
   </div>
   <c:if test="${not empty message}">
     <div class="input-group">
     <label for="cat"><c:out value="${message}"></c:out></label>
     </div>
   </c:if>
  </form>
  <div id="toast">
      
  </div>
</body>
<script>
  function toast({
	    title = '',
	    message = '',
	    type = 'info',
	    duration = 1000
	}) {
	    const main = document.getElementById('toast');
	    if (main) {
	        const toast = document.createElement('div');
	        const icons = {
	        	error: '<i class="fa-solid fa-circle-exclamation"></i>',
	            success: '<i class="fa-solid fa-circle-check"></i>',
	            info: '<i class="fa-solid fa-circle-info"></i>',
	            warning: '<i class="fa-solid fa-circle-exclamation"></i>'
	        };
	        const icon = icons[type];
	        const delay = (duration / 1000).toFixed(2);
			console.log(icon);
			toast.classList.add('toast', 'toast--' + type);
			toast.style.animation = 'fadeOn 0.8s ease ,fadeOut ' + delay + 's linear forwards';
	        toast.innerHTML = '<div class="toast__icon">' +
	        icon +
	        '</div>' +
	        '<div class="toast__body">' +
	        '<h3 class="toast__title">' + title + '</h3>' +
	        '<p class="toast__msg">' + message + '</p>' +
	        '</div>' +
	        '<div class="toast__close">' +
	        '<i class="fa fa-times"></i>' +
	        '</div>';

	        main.appendChild(toast);

	        const autoRemoveId = setTimeout(function () {
	            main.removeChild(toast)
	        }, duration + 1000);

	        toast.onclick = function (e) {
	            console.log(e.target.closest('toast__close'));
	            main.removeChild(toast);
	            clearTimeout(autoRemoveId);
	        }
	    }
	}

	function ShowSuccessToast() {
	    toast({
	        title: 'Succès',
	        message: 'Elève est inscrit avec succès',
	        type: 'success',
	        duration: 2500
	    });
	}

	function ShowErrorToast(message) {
	    toast({
	        title: 'Erreur',
	        message: message,
	        type: 'error',
	        duration: 5000
	    });
	}

	var successMessage = "<%= request.getAttribute("successMessage") %>";
	var errorMessage = "<%= request.getAttribute("errorMessage") %>";
	if (successMessage != null && successMessage != " ") {
		if(successMessage === "success"){
			ShowSuccessToast();
		    console.log(successMessage);
		}else if(successMessage === "error"){
			ShowErrorToast(errorMessage);
		    console.log(successMessage);
		}
	    
	}

  </script>
</html>