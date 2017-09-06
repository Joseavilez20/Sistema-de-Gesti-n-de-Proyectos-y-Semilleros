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
import modelo.dao.TieneDAO;
import modelo.dao.UsuarioDAO;
import modelo.entidades.Proyecto;
import modelo.entidades.Semillero;
import modelo.entidades.Usuario;

import java.io.PrintWriter;

import java.util.List;

public class controladorProyecto extends HttpServlet {
 
    private static String INSERTAR_O_EDITAR = "../consultas/FormProyecto.jsp";
    private static String lista_Proyecto = "../consultas/ListarProyectos.jsp";
    private static String estadisticas = "../consultas/estadisticas.jsp";
    private ProyectoDAO daopro;
    private TieneDAO dt;
    private UsuarioDAO dao;

    public controladorProyecto() {
        super();
        daopro = new ProyectoDAO();
        dt = new TieneDAO();
        dao = new UsuarioDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String forward="index.jsp";
    	response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        String segmento = "";
        String iduser= (String)request.getSession().getAttribute("idusuario");
    	HttpSession session=request.getSession(false);
    	
    	if( session.getAttribute("sessionAdmin")!=null ){  
    	
    		
        String action = request.getParameter("action");
        if (action == null) { 
        	segmento = estadisticas;
        	
            
            }
        
        else if (action.equalsIgnoreCase("borrar")){
            String id=(request.getParameter("id"));
            daopro.borrar(id);
            List<Proyecto> datos = daopro.TodoProyectos();
            request.getSession().setAttribute("proyectos", datos);
            segmento = lista_Proyecto;
            
               
        } else if (action.equalsIgnoreCase("editar")){
            
            String id = (request.getParameter("id"));
            
           Proyecto p = daopro.UnProyecto(id);
         
           
           request.getSession().setAttribute("proyecto", p);
            segmento = INSERTAR_O_EDITAR;
            
        } else if (action.equalsIgnoreCase("listarProyectos")){
            segmento = lista_Proyecto;
           
            
            request.getSession().setAttribute("proyectos", daopro.TodoProyectos());
            segmento = lista_Proyecto;
            
           
        } else if (action.equalsIgnoreCase("insert")){
            segmento= INSERTAR_O_EDITAR;
            System.out.println("insertar o editar");
        }else if (action.equalsIgnoreCase("estadisticas")){
            segmento= estadisticas;
            System.out.println("estadisticas");
        }
      
        request.getSession().setAttribute("segmento", segmento);

        //request.getRequestDispatcher("WEB-INF/jspf/usuario/principal.jsp").forward(request, response);
    	request.getRequestDispatcher("WEB-INF/jspf/administrador/principal.jsp").forward(request, response);
        
   }else if( session.getAttribute("sessionUsuario")!=null ){
	   String action = request.getParameter("action");
       if (action == null) { 
       	segmento = estadisticas;

           }
       else if (action.equalsIgnoreCase("listarProyectos")){
           segmento = lista_Proyecto;
          
           
           request.getSession().setAttribute("proyectos", dt.misProyectos(iduser));
           segmento = lista_Proyecto;
           
          
       } 
       
       else if (action.equalsIgnoreCase("borrar")){
           String id=(request.getParameter("id"));
           daopro.borrar(id);
           List<Proyecto> datos = dt.misProyectos(iduser);
           request.getSession().setAttribute("proyectos", datos);
           segmento = "../consultas/ListarProyectos.jsp";
           
              
       } else if (action.equalsIgnoreCase("editar")){
           
           String id = (request.getParameter("id"));
           
          Proyecto p = daopro.UnProyecto(id);
        
          
          request.getSession().setAttribute("proyecto", p);
           segmento = INSERTAR_O_EDITAR;
           System.out.print("editar");
       } 
         else if (action.equalsIgnoreCase("insert")){
           segmento= INSERTAR_O_EDITAR;
           System.out.println("insertar o editar");
       }else if (action.equalsIgnoreCase("estadisticas")){
           segmento= estadisticas;
           System.out.println("estadisticas");
       }
     
       request.getSession().setAttribute("segmento", segmento);

     
   	request.getRequestDispatcher("WEB-INF/jspf/usuario/principal.jsp").forward(request, response);
       
   }
   
   else{System.out.println("no hay usuario logeado");
   out.print("Aún no ha Inicie session ");  
   request.getRequestDispatcher(forward).include(request, response);  
       
     }
    	
       
    	
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session=request.getSession(false);
		String segmento="index.jsp";
		String forward="";
		 String iduser= (String)request.getSession().getAttribute("idusuario");
		if (action != null) {
			
				if (action.equals("insert")|| action.equals("update")) {
				
					
					if (request.getParameter("nombre") == null || request.getParameter("nombre").equals("")) {
						request.setAttribute("errMessage", "digite nombre");
						RequestDispatcher view = request.getRequestDispatcher("INSERT_OR_EDIT");
				        view.forward(request, response);
						
					}else if  (request.getParameter("fechaInicio") == null || request.getParameter("fechaInicio").equals("")){
						request.setAttribute("errMessage", "digite fecha");
						RequestDispatcher view = request.getRequestDispatcher("INSERT_OR_EDIT");
				        view.forward(request, response);
					
					}else if (request.getParameter("descripcion") == null || request.getParameter("descripcion").equals("")){
						request.setAttribute("errMessage", "digite descripcion");
						RequestDispatcher view = request.getRequestDispatcher("INSERT_OR_EDIT");
				        view.forward(request, response);
						
						
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
							
							daopro.actualizar(p);
							
						}
					
						if (action.equals("insert")) {
							
							
							if(daopro.UnProyecto(p.getId())!= null)
							{
								daopro.agregar(p);
								
								
								
							}
							else
								{
									System.out.println("cedula existe:"+p.getId());
								}
							
						} 
						
						if(session.getAttribute("sessionUsuario")!=null){
							segmento=lista_Proyecto;
							forward="WEB-INF/jspf/usuario/principal.jsp";
							Usuario user = dao.getUserById(iduser);
							
							
							dt.agregar(user.getCedula(), null, p.getId());
				            request.getSession().setAttribute("proyectos", dt.misProyectos(iduser));
						}else if (session.getAttribute("sessionAdmin")!=null){
							segmento=lista_Proyecto;
							forward="WEB-INF/jspf/administrador/principal.jsp";
							request.getSession().setAttribute("proyectos", daopro.TodoProyectos());
							
						}

		
						
						request.getSession().setAttribute("segmento", segmento);
						request.getRequestDispatcher(forward).forward(request, response);
						

				}

				
			
			
		}
      
        
    }
    }
}

