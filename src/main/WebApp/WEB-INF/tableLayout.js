const onglets = document.querySelectorAll('.title');
const contenu = document.querySelectorAll('.box-child');

onglets.forEach(onglet =>{
	onglet.addEventListener('click', ()=>{
		if(onglet.classList.contains('active')){
			return;
		}else{
			onglet.classList.add('active');
		}
		
		index = onglet.getAttribute('data-anim');
		for(k=0; k<onglets.length; k++){
			if(onglets[k].getAttribute('data-anim') != index){
				onglets[k].classList.remove('active');
			}
		}
		
		for(j=0; j<contenu.length; j++){
			if(contenu[j].getAttribute('data-anim') == index){
				contenu[j].classList.add('activeContenu');
			}else{
				contenu[j].classList.remove('activeContenu');
			}
		}
	});
});