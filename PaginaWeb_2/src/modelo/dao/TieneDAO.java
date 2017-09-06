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
import modelo.entidades.Usuario;
import conexion.Conexion;

public class TieneDAO {

    private Connection connection;

    public TieneDAO() {
        connection = Conexion.getConnection();
    }
   
    public void agregar(String idusuario,String idsemillero, String idproyecto ) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into tiene(idusuario,idsemillero,idproyecto) values (?, ?, ?)");
            // Parameters start with 1
            preparedStatement.setString(1, idusuario);
            preparedStatement.setString(2,idsemillero);
            preparedStatement.setString(3, idproyecto);
          
            
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void agregarProyectoASemillero(String idusuario,String idsemillero, String idproyecto ) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update tiene set idproyecto=? where ( tiene.idsemillero=? and tiene.idusuario=?)");
            // Parameters start with 1
            preparedStatement.setString(1, idproyecto);
            preparedStatement.setString(2,idsemillero);
            preparedStatement.setString(3, idusuario);
           
          
            
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Proyecto> ProyectosDeSemillero() {
        List<Proyecto> pro= new ArrayList<Proyecto>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(" select proyecto.* from tiene,proyecto where ((tiene.idusuario =? and tiene.idsemillero=? )and tiene.idproyecto=proyecto.id)");

            while (rs.next()) {
                Proyecto s = new Proyecto();
                s.setId(rs.getString("id"));
                s.setNombre(rs.getString("nombre"));
                s.setFechaInicio(rs.getString("fechaInicio"));
                s.setDescripcion(rs.getString("descripcion"));
              
                
               
                
               pro.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pro;
    }

    
    public void borrarProyecto(String idproyecto , String idusuario) {
        try {
        	 System.out.println("idproyecto"+idproyecto+"  idusuario:"+  idusuario);
            PreparedStatement preparedStatement = connection.prepareStatement("update tiene set  idproyecto=null where (idproyecto=? and idusuario=?)");
            // Parameters start with 1
           
            preparedStatement.setString(1, idproyecto);
            preparedStatement.setString(2,  idusuario);
 
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public void borrarSemillero(String idsemillero , String idusuario) {
        try {
        	 
            PreparedStatement preparedStatement = connection.prepareStatement("update tiene set  idsemillero=null where (idsemillero=? and idusuario=?)");
            // Parameters start with 1
           
            preparedStatement.setString(1, idsemillero);
            preparedStatement.setString(2,  idusuario);
 
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   

   

  /*  public List<Proyecto> misProyectos() {
        List<Proyecto> pro= new ArrayList<Proyecto>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select proyecto.* from proyecto,tiene where (proyecto.id=tiene.idproyecto and tiene.idusuario=?) ");
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
*/
    public List<Proyecto> misProyectos(String id) {
    	List<Proyecto> pro= new ArrayList<Proyecto>();
       
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select proyecto.* from proyecto,tiene where (proyecto.id=tiene.idproyecto and tiene.idusuario=?)");
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();

           while(rs.next()) {
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
    
    public List<Semillero> misSemillero(String id) {
    	List<Semillero> sem= new ArrayList<Semillero>();
       
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select semillero.* from semillero,tiene where (semillero.id=tiene.idsemillero and tiene.idusuario=?)");
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();

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
}