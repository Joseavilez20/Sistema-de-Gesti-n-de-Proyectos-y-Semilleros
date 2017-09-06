<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Show All Users</title>
</head>
<body>
<div align="center">
 
    <table border=1 class="tabla1">
        <thead>
            <tr>
                <th>Cedula</th>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>Usuario</th>
                <th>contraseña</th>
                <th>Correo</th>
                <th>Telefono</th>
                <th>Genero</th>
                <th>Fecha Nacimiento</th>
                <th>Ciudad</th>
                <th>Rol</th>
                
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${users}" var="usuario">
                <tr>
                    <td><c:out value="${usuario.cedula}" /></td>
                    <td><c:out value="${usuario.nombre}" /></td>
                    <td><c:out value="${usuario.apellidos}" /></td>
                   <td><c:out value="${usuario.userName}" /></td>
                    <td><c:out value="${usuario.password}" /></td>
                    <td><c:out value="${usuario.correo}" /></td>
                    <td><c:out value="${usuario.telefono}" /></td>
                    <td><c:out value="${usuario.genero}" /></td>
                    <td><c:out value="${usuario.fechaNacimiento}" /></td>
                    <td><c:out value="${usuario.ciudad}" /></td>
                     <td><c:out value="${usuario.rol}" /></td>
                   
                    <td><a  class="act" href="ControlUsuario?action=edit&cedula=<c:out value="${usuario.cedula}"/>">Update</a></td>
                    <td><a class="act" href="ControlUsuario?action=delete&cedula=<c:out value="${usuario.cedula}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a class="agregar" href="ControlUsuario?action=insert">Agregar Usuario</a></p>
    </div>
 
</body>
</html>