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
import modelo.dao.UsuarioDAO;
import modelo.entidades.Proyecto;
import modelo.entidades.Semillero;
import modelo.entidades.Usuario;

import java.io.PrintWriter;

import java.util.List;

public class controladorSemillero extends HttpServlet {
 
    private static String INSERTAR_O_EDITAR = "../consultas/FormSemillero.jsp";
    private static String lista_Semilleros = "../consultas/ListarSemilleros.jsp";
    private static String detalles = "../consultas/detalles.jsp";
    private static String estadisticas = "../consultas/estadisticas.jsp";
    private SemilleroDAO daosem;
    private TieneDAO dt;
    private UsuarioDAO dao;

    public controladorSemillero() {
        super();
        daosem = new  SemilleroDAO();
        dt= new TieneDAO(); 
        dao = new UsuarioDAO();
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String forward="index.jsp";
    	response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        String segmento = "";
    	HttpSession session=request.getSession(false);
    	 String iduser= (String)request.getSession().getAttribute("idusuario");
    	
    	if( session.getAttribute("sessionAdmin")!=null ){  
    	
    		
        String action = request.getParameter("action");
        if (action == null) { 
        	segmento = estadisticas;
        	
            
            }
        
        else if (action.equalsIgnoreCase("borrar")){
            String id=(request.getParameter("id"));
            daosem.borrar(id);
            List<Semillero> datos = daosem.TodosSemilleros();
            request.getSession().setAttribute("semilleros", datos);
            segmento = lista_Semilleros;
            
               
        } else if (action.equalsIgnoreCase("edit")){
            
            String id = (request.getParameter("id"));
            
           Semillero s = daosem.UnSemillero(id);
         
           
           request.getSession().setAttribute("semillero", s);
            segmento = INSERTAR_O_EDITAR;
            System.out.println("editar semillero");
        } else if (action.equalsIgnoreCase("listar")){
            segmento = lista_Semilleros;
           
            List<Semillero> datos = daosem.TodosSemilleros();
            request.getSession().setAttribute("semilleros", datos);
            segmento = "../consultas/ListarSemilleros.jsp";
            
           
        } else if (action.equalsIgnoreCase("insert")){
            segmento= INSERTAR_O_EDITAR;
            System.out.println("insertar o editar");
        }else if (action.equalsIgnoreCase("estadisticas")){
            segmento= estadisticas;
            System.out.println("estadisticas");
        }
      
        request.getSession().setAttribute("segmento", segmento);

    	request.getRequestDispatcher("WEB-INF/jspf/administrador/principal.jsp").forward(request, response);
        
   }else if(session.getAttribute("sessionUsuario")!=null){
	   String action = request.getParameter("action");
       if (action == null) { 
       	segmento = estadisticas;
       	
           
           }
       else if (action.equalsIgnoreCase("listar")){
           segmento = lista_Semilleros;
          
           List<Semillero> datos = dt.misSemillero(iduser);
           request.getSession().setAttribute("semilleros", datos);
           segmento = "../consultas/ListarSemilleros.jsp";
           
          
       } else if (action.equalsIgnoreCase("ver")){
           segmento = lista_Semilleros;
          
           List<Semillero> datos = dt.misSemillero(iduser);
           request.getSession().setAttribute("semilleros", datos);
           segmento = "../consultas/ListarSemilleros.jsp";
           
          
       }
       
       else if (action.equalsIgnoreCase("borrar")){
           String id=(request.getParameter("id"));
           daosem.borrar(id);
           List<Semillero> datos = dt.misSemillero(iduser);
           request.getSession().setAttribute("semilleros", datos);
           segmento = lista_Semilleros;
           
              
       } else if (action.equalsIgnoreCase("edit")){
           
           String id = (request.getParameter("id"));
           
          Semillero s = daosem.UnSemillero(id);
        
          
          request.getSession().setAttribute("semillero", s);
           segmento = INSERTAR_O_EDITAR;
           
       } 
         else if (action.equalsIgnoreCase("insert")){
           segmento= INSERTAR_O_EDITAR;
           System.out.println("insertar o editar");
       }else if (action.equalsIgnoreCase("estadisticas")){
           segmento= estadisticas;
           System.out.println("estadisticas");
       }
     
       request.getSession().setAttribute("segmento", segmento);

       //request.getRequestDispatcher("WEB-INF/jspf/usuario/principal.jsp").forward(request, response);
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
						
						
					}else if (request.getParameter("descripcion") == null || request.getParameter("descripcion").equals("")){
						request.setAttribute("errMessage", "digite descripcion");
						
						
					}else if (request.getParameter("areaInvestigacion") == null || request.getParameter("areaInvestigacion").equals("")){
						request.setAttribute("errMessage", "digite area Investigacion");
						
						
					}else if (request.getParameter("id") == null || request.getParameter("id").equals(""))
					{
						System.out.print("rellene el id"); 
					}else{
						Semillero s = new Semillero();
	
						s.setNombre( request.getParameter("nombre"));
						s.setDescripcion(request.getParameter("descripcion"));
						s.setAreaInvestigacion(request.getParameter("areaInvestigacion"));
						
						s.setId(request.getParameter("id"));
						
						
						if (action.equals("update")) {
							
							daosem.actualizar(s);
							System.out.println("actualizar");
						}

						if (action.equals("insert")) {
							
							System.out.println("insertar-- ");
							if(daosem.UnSemillero(s.getId())!= null)
							{
								
								daosem.agregar(s);
								
								
							}
							else
								{
									System.out.println("cedula existe:"+s.getId());
								}
							
						} 

						if(session.getAttribute("sessionUsuario")!=null){
						
							forward="WEB-INF/jspf/usuario/principal.jsp";
							segmento = lista_Semilleros;
							 Usuario user = dao.getUserById(iduser);

							dt.agregar(user.getCedula(), s.getId(),null);
							 request.getSession().setAttribute("semilleros", dt.misSemillero(iduser));
					            
						}else if (session.getAttribute("sessionAdmin")!=null){
							segmento=lista_Semilleros;
							forward="WEB-INF/jspf/administrador/principal.jsp";
						      List<Semillero> datos = daosem.TodosSemilleros();
							request.getSession().setAttribute("semilleros", datos);
							
						}

		
					
			            
						request.getSession().setAttribute("segmento", segmento);
						request.getRequestDispatcher(forward).forward(request, response);
						
						
			            
						
				}

				
			
			
		}
      
        
    }
    }
}

