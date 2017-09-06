package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.entidades.Proyecto;
import modelo.entidades.Semillero;
import conexion.Conexion;

public class SemilleroDAO {

    private Connection connection;

    public SemilleroDAO() {
        connection = Conexion.getConnection();
    }

    public void agregar(Semillero s) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into semillero(id,nombre,descripcion,areaInvestigacion) values (?, ?, ?, ? )");
            // Parameters start with 1
            preparedStatement.setString(1, s.getId());
            preparedStatement.setString(2,s.getNombre());
            preparedStatement.setString(3, s.getDescripcion());
            preparedStatement.setString(4, s.getAreaInvestigacion());
            
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void borrar(String id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from semillero where id=?");
            // Parameters start with 1
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizar(Semillero s) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update semillero set  nombre=?, descripcion=? , areaInvestigacion=?" +
                            "where id=?");
            // Parameters start with 1
           
            preparedStatement.setString(1,s.getNombre());
            preparedStatement.setString(2, s.getDescripcion());
            preparedStatement.setString(3, s.getAreaInvestigacion());
            preparedStatement.setString(4, s.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Semillero> TodosSemilleros() {
        List<Semillero> sem= new ArrayList<Semillero>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from semillero");
            while (rs.next()) {
                Semillero s = new Semillero();
                s.setId(rs.getString("id"));
                s.setNombre(rs.getString("nombre"));
                
                s.setDescripcion(rs.getString("descripcion"));
                s.setAreaInvestigacion(rs.getString("areaInvestigacion"));
                
               
                
               sem.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sem;
    }

    public Semillero UnSemillero(String id) {
    	 Semillero s = new Semillero();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from semillero where id=?");
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	s.setId(rs.getString("id"));
                 s.setNombre(rs.getString("nombre"));
                 s.setDescripcion(rs.getString("descripcion"));
                 s.setAreaInvestigacion(rs.getString("areaInvestigacion"));
                 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return s;
    }
}