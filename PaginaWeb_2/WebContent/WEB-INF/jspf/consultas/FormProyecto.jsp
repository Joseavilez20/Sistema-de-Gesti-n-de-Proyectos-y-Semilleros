<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

   
    <div >
    <c:if test="${proyecto != null}">
            <form action="ControlProyecto?action=update" method="post">
            
        </c:if>
        <c:if test="${proyecto == null}">
            <form action="ControlProyecto?action=insert" method="post">
             
        </c:if>
        <div align="center">
 
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${proyecto != null}">
                        Editar Proyecto
                    </c:if>
                    <c:if test="${proyecto == null}">
                        Agregar Proyecto
                    </c:if>
                </h2>
            </caption>
                 <tr>
                 <th>Id: </th>
                 <td>
                 <c:if test="${proyecto != null}">
                    <input type="text" name="id"  value="<c:out value='${proyecto.id}' />" />
                    
                     </c:if> 
                     <c:if test="${proyecto == null}">
                    <input type="text" name="id"  value="<c:out value='${proyecto.id}' />" />
                     </c:if>   
                 </td>
                 </tr>          
            <tr>
                <th>Nombre: </th>
                <td>
                    <input type="text" name="nombre" 
                            value="<c:out value='${proyecto.nombre}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Fecha Inicio: </th>
                <td>
                    <input type="date" name="fechaInicio" 
                            value="<c:out value='${proyecto.fechaInicio}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Descripcion: </th>
                <td>
                    <input type="text" name="descripcion" 
                            value="<c:out value='${proyecto.descripcion}' />"
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
         </div>
        </form>
    </div>   
