<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="modelo.entidades.Usuario"%>
     <% 
    response.setHeader("Cache-Control","no-store,must-revalidate"); 
    response.setHeader("Pragma","no-cache"); 
    response.setDateHeader ("Expires", -1); 
    new java.util.Date();
    if(session.getAttribute("sessionAdmin")!=null)
    {
    %>
     <%String segmento = (String)request.getSession().getAttribute("segmento");
     
   %>



<jsp:include page="header.jspf" />

<jsp:include page="contenido.jspf" />

<jsp:include page="<%=segmento%>"  />
<jsp:include page="footer.jspf" /> 

 


<%}
else
response.sendRedirect("index.jsp");%>