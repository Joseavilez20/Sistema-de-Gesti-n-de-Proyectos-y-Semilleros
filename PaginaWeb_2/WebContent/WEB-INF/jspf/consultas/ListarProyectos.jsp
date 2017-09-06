<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Proyectos</title>
</head>
<body>
<div align="center">
 
    <table border=1 class="tabla1">
        <thead>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Fecha Inicio</th>
                <th>Descripcion</th>
                
                
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${proyectos}" var="p">
                <tr>
                    <td><c:out value="${p.id}" /></td>
                    <td><c:out value="${p.nombre}" /></td>
                    <td><c:out value="${p.fechaInicio}" /></td>
                   <td><c:out value="${p.descripcion}" /></td>
                  
                   
                    <td><a class="act" href="ControlProyecto?action=editar&id=<c:out value="${p.id}"/>">Actualizar</a></td>
                    <td><a class="act" href="ControlProyecto?action=borrar&id=<c:out value="${p.id}"/>" onclick="return confirm('Está seguro de elimimar el registro?')">Eliminar</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a class="agregar" href="ControlProyecto?action=insert">Agregar proyecto</a></p>
    </div>
</body>
</html>