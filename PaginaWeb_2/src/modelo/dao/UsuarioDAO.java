package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.entidades.Usuario;
import conexion.Conexion;

public class UsuarioDAO {

    private Connection connection;

    public UsuarioDAO() {
        connection = Conexion.getConnection();
    }

    public void addUser(Usuario user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into usuario(cedula,nombre,apellidos,username,password,correo,telefono,genero,fechaNacimiento,ciudad,rol) values (?, ?, ?, ?,?, ?, ?, ?,?, ?, ? )");
            // Parameters start with 1
            preparedStatement.setString(1, user.getCedula());
            preparedStatement.setString(2, user.getNombre());
            preparedStatement.setString(3, user.getApellidos());
            preparedStatement.setString(4, user.getUserName());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setString(6, user.getCorreo());
            preparedStatement.setString(7, user.getTelefono());
            preparedStatement.setString(8, user.getGenero());
            preparedStatement.setString(9, user.getFechaNacimiento());
            preparedStatement.setString(10, user.getCiudad());
            preparedStatement.setString(11, user.getRol());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(String cedula) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from usuario where cedula=?");
            // Parameters start with 1
            preparedStatement.setString(1, cedula);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(Usuario user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update usuario set  nombre=?, apellidos=?, username=?, password=?, correo=?, telefono=?, genero=?, fechaNacimiento=?, ciudad=?, rol=?" +
                            "where cedula=?");
            // Parameters start with 1
           
            preparedStatement.setString(1, user.getNombre());
            preparedStatement.setString(2, user.getApellidos());
            preparedStatement.setString(3, user.getUserName());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getCorreo());
            preparedStatement.setString(6, user.getTelefono());
            preparedStatement.setString(7, user.getGenero());
            preparedStatement.setString(8, user.getFechaNacimiento());
            preparedStatement.setString(9, user.getCiudad());
            preparedStatement.setString(10, user.getRol());
            preparedStatement.setString(11, user.getCedula());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> getAllUsers() {
        List<Usuario> users = new ArrayList<Usuario>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from usuario");
            while (rs.next()) {
                Usuario user = new Usuario();
                user.setCedula(rs.getString("cedula"));
                user.setNombre(rs.getString("nombre"));
                user.setApellidos(rs.getString("apellidos"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setCorreo(rs.getString("correo"));
                user.setTelefono(rs.getString("telefono"));
                user.setGenero(rs.getString("genero"));
                user.setFechaNacimiento(rs.getString("fechaNacimiento"));
                user.setCiudad(rs.getString("ciudad"));
                user.setRol(rs.getString("rol"));
                
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public Usuario getUserById(String cedula) {
        Usuario user = new Usuario();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from usuario where cedula=?");
            preparedStatement.setString(1, cedula);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	 user.setCedula(rs.getString("cedula"));
                 user.setNombre(rs.getString("nombre"));
                 user.setApellidos(rs.getString("apellidos"));
                 user.setUserName(rs.getString("username"));
                 user.setPassword(rs.getString("password"));
                 user.setCorreo(rs.getString("correo"));
                 user.setTelefono(rs.getString("telefono"));
                 user.setGenero(rs.getString("genero"));
                 user.setFechaNacimiento(rs.getString("fechaNacimiento"));
                 user.setCiudad(rs.getString("ciudad"));
                 user.setRol(rs.getString("rol"));
                 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}