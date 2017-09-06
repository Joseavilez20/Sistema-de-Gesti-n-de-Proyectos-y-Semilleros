package modelo.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.Conexion;

import modelo.entidades.LoginBean;


public class LoginDao {
	
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
public String authenticateUser(LoginBean loginBean)
{
 
String userName = loginBean.getUserName();
String password = loginBean.getPassword();
String searchQuery ="select * from usuario where username='"+ userName+ "' AND password='"+ password+ "'";
 
Connection con = null;
Statement statement = null;
ResultSet resultSet = null;
 
String userNameDB = "";
String passwordDB = "";
String roleDB = "";

 
try
{
	con = Conexion.getConnection();
	statement = con.createStatement();
	resultSet = statement.executeQuery(searchQuery);
	if(resultSet.next()){
		setId(resultSet.getString("cedula"));
		userNameDB = resultSet.getString("username");
		passwordDB = resultSet.getString("password");
		roleDB = resultSet.getString("rol");
		
	}
	 

 
if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Admin")){
	
return "Admin_Rol";
}
else if((userName.equals(userNameDB) && password.equals(passwordDB) )&& (roleDB.equals("Profesor") || roleDB.equals("Estudiante")) )
{return "usuario_Rol";}
else{
	System.out.print("no es ningun tipo");
}


}
catch(SQLException e)
{
e.printStackTrace();
}
return "las credenciales de acceso son invalidas";
}
}