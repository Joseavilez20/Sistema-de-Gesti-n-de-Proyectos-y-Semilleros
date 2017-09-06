package controladores;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import modelo.dao.UsuarioDAO;
import modelo.entidades.Usuario;
import java.io.PrintWriter;

public class controladorUsuario extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERTAR_O_EDITAR = "../consultas/FormUsuario.jsp";
    private static String LIST_USER = "../consultas/ListaUsuarios.jsp";
   
    private static String estadisticas = "../consultas/estadisticas2.jsp";
    private UsuarioDAO dao;

    public controladorUsuario() {
        super();
        dao = new UsuarioDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String forward="index.jsp";
        String segmento = "";
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        HttpSession session=request.getSession(false);
        if(session.getAttribute("sessionAdmin")!=null){  
        String action = request.getParameter("action");
        
        
        if (action == null) { 
        	segmento = estadisticas;
        	
            
            }
        else if (action.equalsIgnoreCase("delete")){
            String cedula =(request.getParameter("cedula"));
            dao.deleteUser(cedula);
            segmento = LIST_USER;
            request.setAttribute("users", dao.getAllUsers()); 
            
        } else if (action.equalsIgnoreCase("edit")){
            
            String cedula = (request.getParameter("cedula"));
            
            Usuario user = dao.getUserById(cedula);
           
           
            request.setAttribute("usuario", user);
            segmento = INSERTAR_O_EDITAR;
            
        } else if (action.equalsIgnoreCase("estadisticas")){
            
           
            segmento = estadisticas;
        }else if (action.equalsIgnoreCase("insert")){
            segmento= INSERTAR_O_EDITAR;
            
        } else if (action.equalsIgnoreCase("listUser")){
            segmento= LIST_USER;
        	
            request.setAttribute("users", dao.getAllUsers());
        }
        request.getSession().setAttribute("segmento", segmento);
        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jspf/administrador/principal.jsp");
        view.forward(request, response);
      }else if(session.getAttribute("sessionUsuario")!=null){
    	  String action = request.getParameter("action");
          
    	  if (action.equalsIgnoreCase("edit")){
              
              String cedula = (request.getParameter("cedula"));
              
              Usuario user = dao.getUserById(cedula);
             
             
              request.setAttribute("usuario", user);
              segmento = INSERTAR_O_EDITAR; 
              }
    	  request.getSession().setAttribute("segmento", segmento);
          RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jspf/usuario/principal.jsp");
          view.forward(request, response);
      }
      else{
    	  System.out.println("no hay usuario logeado");
    	   out.print("Aún no ha Inicie session ");  
    	   request.getRequestDispatcher(forward).include(request, response);  
      }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session=request.getSession(false);
		String segmento="index.jsp";
		String forward="";
		
		if (action != null) {
			
				if (action.equals("insert")|| action.equals("update")) {
				
					
					if (request.getParameter("nombre") == null || request.getParameter("nombre").equals("")) {
						request.setAttribute("errMessage", "digite nombre");
						RequestDispatcher view = request.getRequestDispatcher("INSERT_OR_EDIT");
				        view.forward(request, response);
						
					}else if  (request.getParameter("apellidos") == null || request.getParameter("apellidos").equals("")){
						request.setAttribute("errMessage", "digite apellido");
						RequestDispatcher view = request.getRequestDispatcher("INSERT_OR_EDIT");
				        view.forward(request, response);
				        
					}else if (request.getParameter("username") == null || request.getParameter("username").equals("")){
						request.setAttribute("errMessage", "digite usuario");
						 RequestDispatcher view = request.getRequestDispatcher("INSERT_OR_EDIT");
					        view.forward(request, response);
						
					}else if (request.getParameter("password") == null || request.getParameter("password").equals(""))
					{
						System.out.print("rellene contraseña"); 
					}else if (request.getParameter("correo") == null || request.getParameter("correo").equals(""))
					{
						System.out.print("rellene correo"); 
					}else if (request.getParameter("telefono")  == null || request.getParameter("telefono").equals(""))
					{
						System.out.print("rellene telefono"); 
					}else if (request.getParameter("genero") == null || request.getParameter("genero").equals(""))
					{
						System.out.print("rellene genero"); 
					}else if (request.getParameter("fechaNacimiento") == null || request.getParameter("fechaNacimiento").equals(""))
					{
						System.out.print("rellene fecha nacimiento"); 
					}else if (request.getParameter("ciudad") == null || request.getParameter("ciudad").equals(""))
					{
						System.out.print("rellene  ciudad"); 
					}else if (request.getParameter("rol") == null || request.getParameter("rol").equals(""))
					{
						System.out.print("rellene rol"); 
					}else if (request.getParameter("cedula") == null || request.getParameter("cedula").equals(""))
					{
						System.out.print("rellene cedula"); 
					}else{
						Usuario user = new Usuario();
	
						user.setNombre( request.getParameter("nombre"));
					
						user.setApellidos(request.getParameter("apellidos"));
						user.setUserName(request.getParameter("username"));
						user.setPassword(request.getParameter("password"));
						user.setCorreo(request.getParameter("correo"));
						user.setTelefono(request.getParameter("telefono"));
						user.setGenero(request.getParameter("genero"));
						user.setFechaNacimiento(request.getParameter("fechaNacimiento"));
						user.setCiudad(request.getParameter("ciudad"));
						user.setRol(request.getParameter("rol"));
						user.setCedula(request.getParameter("cedula"));
						
						
						if (action.equals("update")) {
							
							dao.updateUser(user);
			
						}

						if (action.equals("insert")) {
							
							
							if(dao.getUserById(user.getCedula())!= null)
							{
								dao.addUser(user);
								
							}
							else
								{
									System.out.println("cedula existe:"+user.getCedula());
								}
							
						} 
								
						
						/*RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
				        request.setAttribute("users", dao.getAllUsers());
				        view.forward(request, response);	*/
						
						if(session.getAttribute("sessionUsuario")!=null){
							segmento=	"perfil.jsp";
							forward="WEB-INF/jspf/usuario/principal.jsp";
							System.out.print("segmento perfil");
							request.getSession().setAttribute("usuario", dao.getUserById((user.getCedula())));
						}else if (session.getAttribute("sessionAdmin")!=null){
							segmento=LIST_USER;
							forward="WEB-INF/jspf/administrador/principal.jsp";
							request.getSession().setAttribute("users", dao.getAllUsers());
						}


						
						request.getSession().setAttribute("segmento", segmento);
			            
						 RequestDispatcher view = request.getRequestDispatcher(forward);
				          view.forward(request, response);


				}

				
			
			
		}
      
        
    }
    }
}

