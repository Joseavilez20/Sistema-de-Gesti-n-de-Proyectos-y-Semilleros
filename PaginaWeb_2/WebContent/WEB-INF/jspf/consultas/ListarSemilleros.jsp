<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Semilleros</title>
</head>
<body>
<div align="center">
 
    <table border=1 class="tabla1">
        <thead>
            <tr>
                <th>Id</th>
                <th>Nombre</th> 
                <th>Descripcion</th>
                <th>Area de Investigación</th>
                
                
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${semilleros}" var="s">
                <tr>
                    <td><c:out value="${s.id}" /></td>
                    <td><c:out value="${s.nombre}" /></td>
                    <td><c:out value="${s.descripcion}" /></td>
                    <td><c:out value="${s.areaInvestigacion}" /></td>
                   
                  
                   <td><a class="act" href="ControlProyecto?action=listarProyectos">ver </a></td>
                    <td><a class="act" href="ControlSemillero?action=edit&id=<c:out value="${s.id}"/>">Actualizar</a></td>
                    <td><a class="act" href="ControlSemillero?action=borrar&id=<c:out value="${s.id}"/>" onclick="return confirm('Está seguro de elimimar el registro?')">Eliminar</a></td>
                    
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a class="agregar" href="ControlSemillero?action=insert">Agregar Semillero</a></p>
    </div>
</body>
</html>