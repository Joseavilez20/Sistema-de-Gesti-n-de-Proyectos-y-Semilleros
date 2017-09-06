
<div id="id02" class="modal">
  
  <form class="modal-content animate"   method="post" action="ControlUsuario?action=insert">
    <div class="imgcontainer">
    <h1>Formulario de Registro</h1>
      <span onclick="document.getElementById('id02').style.display='none'" class="close" title="Close Modal">&times;</span>
      
    </div>

    <div class="container">
    
     <label for="fname"><b>Nombre</b></label>
    <input type="text" id="firstname" name="nombre" value="" placeholder="Digite su nombre.." >
     <span id="errornam"></span><br>

    <label for="lname"><b>Apellidos</b></label>
    <input type="text" id="lname" name="apellidos" placeholder="Digite sus apellidos.." >
    <span id="errorape"></span><br>
    
    <label for="id"><b>Numero de Identificacion</b></label>
    <input type="text" id="id" name="cedula" placeholder="Digite su numero de identificacion.."  autocomplete="on">
    
    <span id="panel" style="display:none;">Importante! llenar este dato correctamente</span>  

     <label for="usuario"><b>Usuario</b></label>
    <input type="text" id="usuario" name="username" value="" placeholder="Digite su usuario.." >
     <span id="errorus"></span><br>

    <label for="contraseña"><b>Contraseña</b></label>
    <input type="password" id="contraseña" name="password" placeholder="Digite la contraseña.." >
    <span id="errorpass"></span><br>
    
    <label for="correo"><b>Direcccion de correo</b></label>
    <input type="email" id="email" name="correo" placeholder="ejemplo jose@dominio.com" >
	
	
    <label for="tele"><b>telefono</b></label>
    <input type="tel" id="tel" name="telefono" placeholder="Digite su telefono.."  >
  
  <fieldset>
  <legend><b>Genero</b></legend>
    <input type="radio" name="genero" id="m" value="masculino" > Maculino<br>
    <input type="radio" name="genero" id="f" value="femenino"> Femenino<br>
    <input type="radio" name="genero" id="other" value="other"> Otro <br> 
  </fieldset>
	<span id="errorgen"></span>
    
    
  <label for="bday"><b>Fecha de Nacimiento</b></label>
  <input type="date" id="bday" name="fechaNacimiento"  >
  <span id="errorfnac"></span>
  
  <label for="ciudad"><b>Ciudad</b></label>
    <input type="text" id="ciudad" name="ciudad" value="" placeholder="Digite su usuario.." >
     <span id="errorciu"></span><br>

<label for="tusuario"><b>Tipo Usuario</b></label>
<select id="tusuario" name="rol">
  <option value="" id="seleccion">- Selecciona un rol-</option>
  <option value="Estudiante">Estudiante</option>
  <option value="Profesor">Profesorz</option>
 
</select><br>
<span id="errorrol"></span>

      <button type="submit">Registrarse</button>
      
    </div>

    <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="document.getElementById('id02').style.display='none'" class="cancelbtn">Cancel</button>
      <span class="psw">leer <a href="#">politicas</a></span>
    </div>
  </form>
</div>
<script>
// Get the modal
var modal2 = document.getElementById('id02');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal2) {
        modal2.style.display = "none";
    }
}
</script>
