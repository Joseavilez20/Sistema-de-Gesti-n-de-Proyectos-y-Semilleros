package controladores;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.dao.ProyectoDAO;
import modelo.dao.UsuarioDAO;
import modelo.entidades.Usuario;

import java.io.PrintWriter;



public class PerfilUsuario extends HttpServlet {
    //private static final long serialVersionUID = 1L;
    ProyectoDAO daopro;
   

    public PerfilUsuario() {
        super();
        
     
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String forward="index.jsp";
    	String segmento="",idusuario="";
    	response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
    	HttpSession session=request.getSession(false);
    	segmento=	"perfil.jsp";
         

    	if(session.getAttribute("sessionUsuario")!=null){
    		
    		
	       
	        Usuario usuario = (Usuario)request.getSession().getAttribute("usuario"); 
	        request.getSession().setAttribute("usuario", usuario);
	        
	        idusuario = (String)request.getSession().getAttribute("idusuario");
	        request.getSession().setAttribute("idusuario", idusuario);
	        
	        
    		request.getSession().setAttribute("segmento", segmento);
    		
           
    		request.getRequestDispatcher("WEB-INF/jspf/usuario/principal.jsp").forward(request, response);
 
      
    	}else if(session.getAttribute("sessionAdmin")!=null){
    		
    		segmento = (String)request.getSession().getAttribute("segmento");
    	
    		
    		request.getSession().setAttribute("segmento", segmento);
    		
           
    		request.getRequestDispatcher("WEB-INF/jspf/administrador/principal.jsp").forward(request, response);
 
      
    	} else{
    		
			out.print("Aún no ha Iniciado session ");  
			request.getRequestDispatcher(forward).include(request, response);  
       
     }
    }

    
}

