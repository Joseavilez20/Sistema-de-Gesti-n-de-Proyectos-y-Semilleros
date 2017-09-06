function ValidateForm(){
var nom = document.forms["myForm"]["nombre"].value;
var ape= document.forms["myForm"]["apellidos"].value;
var dni = document.forms["myForm"]["cedula"].value;
var usu= document.forms["myForm"]["username"].value;
var pass = document.forms["myForm"]["password"].value;
var mail = document.forms["myForm"]["correo"].value;

var tel =document.forms["myForm"]["telefono"].value;
var gen = document.getElementsByName("genero");
var fnac = document.getElementsByName("fechaNacimiento");
var ciu = document.getElementsByName("ciudad");
var indicerol = document.getElementById("rol").selectedIndex;

document.getElementById("panel").style.display = "none";
document.getElementById("errornom").innerHTML = " " ;
document.getElementById("errorape").innerHTML = " " ;
 document.getElementById("errorgen").innerHTML = " ";
 document.getElementById("errorrol").innerHTML = " ";
 document.getElementById("errorusu").innerHTML = " ";
 document.getElementById("errorpass").innerHTML = " ";
  document.getElementById("tel").style.border='0px';
   document.getElementById("email").style.border='0px ';
   document.getElementById("seleccion").style.color = "black";


    
    if (nom == null || nom .length == 0  || !(/^[a-z]{10,30}$/i.test(nom )) || /^\s+$/.test(nom ) ) {
     
        document.getElementById("errornom").innerHTML = "* El campo no es valido" ;
        return false;
        
    }else if(ape == null || ape.length == 0 || /^\s+$/.test(ape) || !(/^[a-z]{15,40}$/i.test(ape)) ) {
     
        document.getElementById("errorape").innerHTML = "* El campo debe ser llenado" ;
        return false }

     else if( !(/^\d{10}$/.test(dni)) ) {

       document.getElementById("panel").style.display = "block";
     
    return false;
}
   else if (usu == null || usu .length == 0   ) {
        
        document.getElementById("errorusu").innerHTML = "* El campo no es valido" ;
        return false;
        
    } else if (pass == null || pass .length == 0   ) {
        
        document.getElementById("errorpass").innerHTML = "* El campo no es valido" ;
        return false;
        
    }
else if( !(/\w+([-+.']\w+)*@\w+([-.]\w+)/.test(mail)) ) {
  colorborde("email");
  return false;
}

else if( !(/^\d{10}$/.test(tel)) ) {
  colorborde("telefono");

  return false;
} else if(!(items(gen))) 
{
 document.getElementById("errorgen").innerHTML = "*seleccione un genero  ";
     return false;
} 
else if (fnac == null || fnac .length == 0  ) {
     
        document.getElementById("errorfnac").innerHTML = "* El campo no es valido" ;
        return false;
    }
    
else if (ciu == null || ciu .length == 0  ) {
     
        document.getElementById("errorciu").innerHTML = "* El campo no es valido" ;
        return false;}
    
	 else if( indicerol == null || indicerol == 0 ) {
	 document.getElementById("errorrol").innerHTML = "*seleccione un rol ";
	  return false;
} else{
	
	return true;
}



function colorborde(id)
{
  document.getElementById(id).style.border='1px solid red';
}


function items(opciones){ 
var seleccionado = false;
for(var i=0; i<opciones.length; i++) {    
  if(opciones[i].checked) {
    seleccionado = true;
    break;
  }
}
 return seleccionado;  

}



}

