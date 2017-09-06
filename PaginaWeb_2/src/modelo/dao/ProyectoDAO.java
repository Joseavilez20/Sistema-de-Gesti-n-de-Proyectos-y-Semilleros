package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.entidades.Proyecto;

import conexion.Conexion;

public class ProyectoDAO {

    private Connection connection;

    public ProyectoDAO() {
        connection = Conexion.getConnection();
    }

    public void agregar(Proyecto p) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into proyecto(id,nombre,fechaInicio,descripcion) values (?, ?, ?, ? )");
            // Parameters start with 1
            preparedStatement.setString(1, p.getId());
            preparedStatement.setString(2,p.getNombre());
            preparedStatement.setString(3, p.getFechaInicio());
            preparedStatement.setString(4, p.getDescripcion());
            
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void borrar(String id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from proyecto where id=?");
            // Parameters start with 1
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizar(Proyecto p) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update proyecto set  nombre=?, fechaInicio=?, descripcion=?" +
                            "where id=?");
            // Parameters start with 1
           
            preparedStatement.setString(1, p.getNombre());
            preparedStatement.setString(2, p.getFechaInicio());
            preparedStatement.setString(3, p.getDescripcion());
            preparedStatement.setString(4, p.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Proyecto> TodoProyectos() {
        List<Proyecto> pro= new ArrayList<Proyecto>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from proyecto");
            while (rs.next()) {
                Proyecto p = new Proyecto();
                p.setId(rs.getString("id"));
                p.setNombre(rs.getString("nombre"));
                p.setFechaInicio(rs.getString("fechaInicio"));
                p.setDescripcion(rs.getString("descripcion"));
               
                
               pro.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pro;
    }

    public Proyecto UnProyecto(String id) {
        Proyecto p = new Proyecto();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from proyecto where id=?");
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	 p.setId(rs.getString("id"));
                 p.setNombre(rs.getString("nombre"));
                 p.setFechaInicio(rs.getString("fechaInicio"));
                 p.setDescripcion(rs.getString("descripcion"));
                 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return p;
    }
}