
document.addEventListener("DOMContentLoaded", function() {
    var header = document.querySelector('.head');

    window.addEventListener("scroll", function() {
        if (window.scrollY > 440) { // Vous pouvez ajuster la valeur selon votre besoin
            header.classList.add('active') // Couleur du header au scroll
			
            //header.style.color = "#333"; // Couleur du texte au scroll
        } else {
            header.classList.remove('active') // Couleur du header par défaut
           // header.style.color = "#fff"; // Couleur du texte par défaut
        }
    });
});
