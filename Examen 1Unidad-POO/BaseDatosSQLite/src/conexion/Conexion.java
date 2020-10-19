package conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Conexion {
    public Connection connect(){
        Connection conn = null;
        try{
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:D:\\BaseDatosSQLite\\DateBases\\ProductosDB.db";
            if(conn == null){
                conn = DriverManager.getConnection(url);
                System.out.println("> La conexión se realizo correctamente...100%");
            }else{
                System.out.println("Err: Ya existe una conexión");
            }
        }catch (SQLException | ClassNotFoundException e){
            System.out.println("Error: "+e.getMessage());
        }
        return conn ;
    }
}
