<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>title</title>
</head>
<body>
   
    <div align="center">
    <c:if test="${usuario != null}">
            <form action="ControlUsuario?action=update" method="post">
         
        </c:if>
        <c:if test="${usuario == null}">
            <form action="ControlUsuario?action=insert" method="post">
             
        </c:if>
        
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${usuario != null}">
                        Editar Usuario
                    </c:if>
                    <c:if test="${usuario == null}">
                        Agregar usuario
                    </c:if>
                </h2>
            </caption>
                 <tr>
                 <th>Cedula: </th>
                 <td>
                 <c:if test="${usuario != null}">
                    <input type="text" name="cedula"  value="<c:out value='${usuario.cedula}' />" />
                    
                     </c:if> 
                     <c:if test="${usuario == null}">
                    <input type="text" name="cedula"  value="<c:out value='${usuario.cedula}' />" />
                     </c:if>   
                 </td>
                 </tr>          
            <tr>
                <th>Nombre: </th>
                <td>
                    <input type="text" name="nombre" 
                            value="<c:out value='${usuario.nombre}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Apellidos: </th>
                <td>
                    <input type="text" name="apellidos" 
                            value="<c:out value='${usuario.apellidos}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Usuario: </th>
                <td>
                    <input type="text" name="username" 
                            value="<c:out value='${usuario.userName}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Contraseña: </th>
                <td>
                    <input type="text" name="password" 
                            value="<c:out value='${usuario.password}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>correo: </th>
                <td>
                    <input type="text" name="correo" 
                            value="<c:out value='${usuario.correo}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>telefono: </th>
                <td>
                    <input type="text" name="telefono" 
                            value="<c:out value='${usuario.telefono}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>genero: </th>
                <td>
                    <input type="text" name="genero"
                            value="<c:out value='${usuario.genero}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Fecha Nacimiento: </th>
                <td>
                    <input type="text" name="fechaNacimiento" 
                            value="<c:out value='${usuario.fechaNacimiento}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>ciudad: </th>
                <td>
                    <input type="text" name="ciudad"
                            value="<c:out value='${usuario.ciudad}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Rol: </th>
                <td>
                    <input type="text" name="rol" 
                            value="<c:out value='${usuario.rol}' />"
                    />
                </td>
            </tr>
            <span style="color:red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Guardar" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>