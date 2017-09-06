package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import modelo.dao.LoginDao;
import modelo.dao.UsuarioDAO;
import modelo.entidades.LoginBean;
import modelo.entidades.Usuario;

import java.io.PrintWriter;
import java.util.List;
 
public class LoginServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
private UsuarioDAO dao;
public LoginServlet() {
	dao = new UsuarioDAO();
}

protected void doGet(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {
	 response.setContentType("text/html");  
     PrintWriter out=response.getWriter();  
	HttpSession session=request.getSession(false);
	
	 
    if(session.getAttribute("sessionUsuario")!=null){  
     
      
    	response.sendRedirect("PerfilUsuario"); 
    }  
    else{  
    	out.print("inicie session por favor!!"); 
        request.getRequestDispatcher("index.jsp").include(request, response);  
    } 
}
 
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 String segmento = "";
	
	 
String userName = request.getParameter("uname");
String password = request.getParameter("psw");
 
LoginBean loginBean = new LoginBean();
 
loginBean.setUserName(userName);
loginBean.setPassword(password);
 
LoginDao loginDao = new LoginDao();
 
try
{
String userValidate = loginDao.authenticateUser(loginBean);
 
if(userValidate.equals("Admin_Rol"))
{

 
HttpSession session = request.getSession(); //Creating a session
session.setAttribute("sessionAdmin", userName); //setting session attribute

segmento ="../consultas/estadisticas2.jsp";
request.getSession().setAttribute("segmento", segmento);

//request.getRequestDispatcher("WEB-INF/jspf/administrador/principal.jsp").forward(request, response);
response.sendRedirect("PerfilUsuario");
}
else if(userValidate.equals("usuario_Rol") )
{
	//segmento=	"perfil.jsp";
HttpSession session = request.getSession();
session.setMaxInactiveInterval(10*60);
session.setAttribute("sessionUsuario", userName);
//request.getSession().setAttribute("segmento",segmento);
Usuario user = dao.getUserById(loginDao.getId());


request.getSession().setAttribute("usuario", user);




request.getSession().setAttribute("idusuario", loginDao.getId());

 
//request.getRequestDispatcher("PerfilUsuario").forward(request, response);

response.sendRedirect("PerfilUsuario");
}
else
{
System.out.println(" Error - "+userValidate);
request.setAttribute("errMessage", userValidate);



request.getRequestDispatcher("index.jsp").forward(request, response);
}
}
catch (IOException e1)
{
e1.printStackTrace();
}
catch (Exception e2)
{
e2.printStackTrace();
}
}
}