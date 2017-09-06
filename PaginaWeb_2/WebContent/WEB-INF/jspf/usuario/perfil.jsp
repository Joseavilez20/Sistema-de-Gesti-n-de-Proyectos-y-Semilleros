
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="modelo.entidades.Usuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%String usuario= (String)request.getSession().getAttribute("sessionUsuario");%>

<% 
   Usuario  persona
        = (Usuario)request.getSession()
          .getAttribute("usuario");


%>



<!-- Page Container -->
<div class="w3-content w3-margin-top" style="max-width:1400px;">

  <!-- The Grid -->
  <div class="w3-row-padding">
  
    <!-- Left Column -->
    <div class="w3-third">
    
      <div class="w3-white w3-text-grey w3-card-4">
        <div class="w3-display-container">
          <img src="images/profile.jpg" style="width:100%" alt="Avatar">
          <div class="w3-display-bottomleft w3-container w3-text-black">
            <h2><%= usuario %></h2>
          </div>
        </div>
        <div class="w3-container">
          <p><i class="fa fa-briefcase fa-fw w3-margin-right w3-large w3-text-teal"></i><%= persona.getNombre() %></p>
          <p><i class="fa fa-home fa-fw w3-margin-right w3-large w3-text-teal"></i><%= persona.getCiudad() %></p>
          <p><i class="fa fa-envelope fa-fw w3-margin-right w3-large w3-text-teal"></i><%= persona.getCorreo() %></p>
          <p><i class="fa fa-phone fa-fw w3-margin-right w3-large w3-text-teal"></i><%= persona.getTelefono() %></p>
          <hr>

          <p class="w3-large"><b><i class="fa fa-asterisk fa-fw w3-margin-right w3-text-teal"></i>Avance de Actividades</b></p>
          <p>Proyecto1</p>
          <div class="w3-light-grey w3-round-xlarge w3-small">
            <div class="w3-container w3-center w3-round-xlarge w3-teal" style="width:90%">90%</div>
          </div>
          <p>Proyecto2</p>
          <div class="w3-light-grey w3-round-xlarge w3-small">
            <div class="w3-container w3-center w3-round-xlarge w3-teal" style="width:80%">
              <div class="w3-center w3-text-white">80%</div>
            </div>
          </div>
          <p>proyecto3</p>
          <div class="w3-light-grey w3-round-xlarge w3-small">
            <div class="w3-container w3-center w3-round-xlarge w3-teal" style="width:75%">75%</div>
          </div>
          <p>Proyecto4</p>
          <div class="w3-light-grey w3-round-xlarge w3-small">
            <div class="w3-container w3-center w3-round-xlarge w3-teal" style="width:50%">50%</div>
          </div>
          <br>

          <p class="w3-large w3-text-theme"><b><i class="fa fa-globe fa-fw w3-margin-right w3-text-teal"></i>Aportes a semilleros</b></p>
          <p>semillero 1</p>
          <div class="w3-light-grey w3-round-xlarge">
            <div class="w3-round-xlarge w3-teal" style="height:24px;width:100%"></div>
          </div>
          <p>semillero 2</p>
          <div class="w3-light-grey w3-round-xlarge">
            <div class="w3-round-xlarge w3-teal" style="height:24px;width:55%"></div>
          </div>
          <p>semillero 3</p>
          <div class="w3-light-grey w3-round-xlarge">
            <div class="w3-round-xlarge w3-teal" style="height:24px;width:25%"></div>
          </div>
          <br>
        </div>
      </div><br>

    <!-- End Left Column -->
    </div>

    <!-- Right Column -->
    <div class="w3-twothird">
    
      <div class="w3-container w3-card-2 w3-white w3-margin-bottom">
        <h2 class="w3-text-grey w3-padding-16"><i class="fa fa-address-book fa-fw w3-margin-right w3-xxlarge w3-text-teal"></i>Informacion Personal</h2>
        <div class="w3-container">
         
          <h5 class="w3-text-teal"> <span class="w3-tag w3-teal w3-round">Cedula</span>---------------------><%= persona.getCedula() %></h5>
          
          <hr>
        </div>
        <div class="w3-container">
         
          <h5 class="w3-text-teal"> <span class="w3-tag w3-teal w3-round">Nombre</span>---------------------><%= persona.getNombre() %></h5>
          
          <hr>
        </div>
        <div class="w3-container">
         
          <h5 class="w3-text-teal"> <span class="w3-tag w3-teal w3-round">Apellidos</span>-----------------><%= persona.getApellidos() %></h5>
          
          <hr>
        </div>
        <div class="w3-container">
         
          <h5 class="w3-text-teal"> <span class="w3-tag w3-teal w3-round">Genero</span>---------------------><%= persona.getGenero() %></h5>
          
          <hr>
        </div>
        <div class="w3-container">
         
          <h5 class="w3-text-teal"> <span class="w3-tag w3-teal w3-round">Fecha Nacimiento</span>--><%= persona.getFechaNacimiento() %></h5>
          
          <hr>
        </div>
        <div class="w3-container">
         
          <h5 class="w3-text-teal"> <span class="w3-tag w3-teal w3-round">Rol</span>-------------------------><%= persona.getRol() %></h5>
          
          
        </div>
      </div>
 
      <div class="w3-container w3-card-2 w3-white">
        <h2 class="w3-text-grey w3-padding-16"><i class="fa fa-certificate fa-fw w3-margin-right w3-xxlarge w3-text-teal"></i>Datos de Acceso</h2>
        <div class="w3-container">
         
          <h5 class="w3-text-teal"> <span class="w3-tag w3-teal w3-round">Usuario</span>-----------------------><%= persona.getUserName() %></h5>
          
          
        </div>
        <div class="w3-container">
         
          <h5 class="w3-text-teal"> <span class="w3-tag w3-teal w3-round">Contraseña</span>------------------><%= "*****" %></h5>
          
          
        </div>
        <div class="w3-container">
         
        <a  href="ControlUsuario?action=edit&cedula=<c:out value="${usuario.cedula}"/>">Actualizar informacion</a>
          
          
        </div>
        
        
      </div>

    <!-- End Right Column -->
    </div>
    
  <!-- End Grid -->
  </div>
  
  <!-- End Page Container -->
</div>

