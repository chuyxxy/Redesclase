function popup(){
	alert(Math.random())
}

function Cuenta()
{
 var i =0;
 var text="";
	while (i < 10) {
  text += "The number is " + i+"<br>";
  i++;

}
return text;
}

function Juego(){  //ya sirve
	var i=0;
	var texts=0;
	var respuesta="";
	var piedra="piedra";
	var papel="papel";
	var tijera="tijera";
	i=Math.floor(Math.random() * 4)+1;

	texts+=i;
	return texts;
	/*if (texts=1) 
	{
		respuesta =piedra;
	}

	else (texts=2) {
		respuesta = papel;
	}

	if (texts=3) {
	respuesta = tijera;
	}
		
	
	//return respuesta;*/

}