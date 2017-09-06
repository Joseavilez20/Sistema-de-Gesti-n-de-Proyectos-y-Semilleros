package controladores;


import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import modelo.dao.ProyectoDAO;
import modelo.dao.SemilleroDAO;
import modelo.dao.TieneDAO;
import modelo.entidades.Proyecto;
import modelo.entidades.Semillero;

import java.io.PrintWriter;

import java.util.List;

public class ControladorTiene extends HttpServlet {
 

    private TieneDAO dt;
    private SemilleroDAO ds;
    private ProyectoDAO dp;

    public ControladorTiene() {
        super();
        dt = new TieneDAO();
        ds= new SemilleroDAO();
        dp = new ProyectoDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String forward="index.jsp";
    	response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        String segmento = "";
        String iduser= (String)request.getSession().getAttribute("idusuario");
        
        
    	HttpSession session=request.getSession(false);
    	
    	if(session.getAttribute("sessionUsuario")!=null ){  
    	
    		
        String action = request.getParameter("action");
        
        
        
        
       
    
   
	   }else{System.out.println("no hay usuario logeado");
   out.print("Aún no ha Inicie session ");  
   request.getRequestDispatcher(forward).include(request, response);  
       
     }
    	
       
    	
    }

    /*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String segmento="../consultas/ListarProyectos.jsp";
		if (action != null) {
			
				if (action.equals("insert")|| action.equals("update")) {
				
					
					if (request.getParameter("nombre") == null || request.getParameter("nombre").equals("")) {
						request.setAttribute("errMessage", "digite nombre");
						
						
					}else if  (request.getParameter("fechaInicio") == null || request.getParameter("fechaInicio").equals("")){
						request.setAttribute("errMessage", "digite fecha");
					
					}else if (request.getParameter("descripcion") == null || request.getParameter("descripcion").equals("")){
						request.setAttribute("errMessage", "digite descripcion");
						
						
					}else if (request.getParameter("id") == null || request.getParameter("id").equals(""))
					{
						System.out.print("rellene el id"); 
					}else{
						Proyecto p = new Proyecto();
	
						p.setNombre( request.getParameter("nombre"));
					
						p.setFechaInicio(request.getParameter("fechaInicio"));
						p.setDescripcion(request.getParameter("descripcion"));
						
						p.setId(request.getParameter("id"));
						
						
						if (action.equals("update")) {
							
							daopro.updateUser(p);
							System.out.println("actualizar");
						}

						if (action.equals("insert")) {
							
							System.out.println("insertar-- ");
							if(daopro.UnProyecto(p.getId())!= null)
							{
								
								daopro.addUser(p);
								
							}
							else
								{
									System.out.println("cedula existe:"+p.getId());
								}
							
						} 
								
						
						request.getSession().setAttribute("segmento", segmento);
			            
						response.sendRedirect("PerfilUsuario");

				}

				
			
			
		}
      
        
    }
    }*/
}

