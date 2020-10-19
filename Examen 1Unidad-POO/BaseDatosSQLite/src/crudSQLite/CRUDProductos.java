package crudSQLite;

import java.sql.*;

import conexion.Conexion;
import productos.Productos;
import util.BufferedZ;

import java.util.*;

public class CRUDProductos extends Conexion {
    BufferedZ teclado = new BufferedZ();
    Productos p = new Productos();
    Statement stmt = null;
    ResultSet rs = null;
    Connection conn = null;

    public void crearProd(Productos pd){
        String consult = "INSERT INTO productos (NOMBREP, FECHAVENCI, CATEGORIA, MARCA, PRECIO, STOCK) VALUES " +
                "('"+pd.getNameP()+"','"+pd.getFechaV()+"','"+pd.getCategoria()+"','"+pd.getMarca()+"','"+pd.getPrecio()+"','"+pd.getStock()+"')";
        try{
            stmt = connect().createStatement();
            stmt.executeUpdate(consult);
            System.out.println("> Los productos se  crearon correctamente...100%");
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public List<Productos> ListarProd (){
        List<Productos> listP = new ArrayList<>();
        String consult = "SELECT p.*,strftime('%d/%m/%Y', date(p.FECHAVENCI)) as fecha FROM productos p"; //strftime('%d/%m/%Y', myDate)
        try{
            stmt = connect().createStatement();
            rs = stmt.executeQuery(consult);
            while (rs.next()) {
                p = new Productos();
                p.setId(rs.getInt(1));
                p.setNameP(rs.getString(2));
                p.setFechaV(rs.getString("fecha"));
                p.setCategoria(rs.getString(4));
                p.setMarca(rs.getString(5));
                p.setPrecio(rs.getDouble(6));
                p.setStock(rs.getInt(7));
                System.out.println("Elemento :"+p.getId());
                listP.add(p);
            }
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
        return listP;
    }

    public void actualizarProd(int id)throws SQLException{
        String consulta = "SELECT * FROM productos";
        stmt = connect().createStatement();
        char finish = ' ';
        do{
            rs = stmt.executeQuery(consulta);
            rs.next();
            String column = teclado.read("","Ingrese el nombre de la columna a modificar");
            String newValor = teclado.read("","Ingrese el nuevo dato");
            String up = "UPDATE productos SET "+column+" = '"+newValor+"' WHERE ID = '"+id+"'";
            try{
                stmt.executeUpdate(up);
                conn.commit();
            }catch (Exception e){
            }
            System.out.println("N: no  |  S: si");
            finish = teclado.read(' ',"¿Desea terminar el proceso?");
        }while (finish == 'N');
    }

    public void borrarProd (int id){
        String consulta = "DELETE FROM productos WHERE ID = "+id+"";
        try{
            stmt = connect().createStatement();
            stmt.executeUpdate(consulta);
            System.out.println("Se elimino correctamente la ID "+id);
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}