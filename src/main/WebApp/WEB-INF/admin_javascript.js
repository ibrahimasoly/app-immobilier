var table = document.getElementById("table"), rIndex;
for(var i=1; i< table.rows.length; i++){
	table.rows[i].onclick = function(){
		rIndex = this.rowIndex;
		console.log(rIndex);
		document.getElementById("idi").value = this.cells[0].innerHTML;
		document.getElementById("name").value = this.cells[1].innerHTML;
		document.getElementById("lastname").value = this.cells[2].innerHTML;
		document.getElementById("tel").value = this.cells[3].innerHTML;
		document.getElementById("mail").value = this.cells[4].innerHTML;
		document.getElementById("pass").value = this.cells[5].innerHTML;
	}
}