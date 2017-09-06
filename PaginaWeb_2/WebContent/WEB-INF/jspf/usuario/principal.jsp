<%@page contentType="text/html" pageEncoding="UTF-8"%>


<% if(session.getAttribute("sessionUsuario")!=null)
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