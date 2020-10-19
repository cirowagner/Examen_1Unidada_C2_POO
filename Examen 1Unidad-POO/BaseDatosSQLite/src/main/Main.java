package main;

import productos.Productos;
import util.BufferedZ;
import crudSQLite.CRUDProductos;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args)throws SQLException{
        BufferedZ teclado = new BufferedZ();
        CRUDProductos crud = new CRUDProductos();

        int opt;
        do {
            System.out.println();
            opt = teclado.read(0,"|>------- CRUD PRODUCTOS ------<|\n"+
                    "1 > Crear Productos\n"+
                    "2 > Listar\n"+
                    "3 > Actualizar\n"+
                    "4 > Borrar\n"+
                    "0 >Salir\n");

            switch (opt) {
                case 1:
                    System.out.println("||--Crear Productos");
                    Productos cp = new Productos();
                    cp.setNameP(teclado.read("","Ingrese el nombre del producto"));
                    cp.setFechaV(teclado.read("","Ingrese la fecha de vencimiento | yyyy-MM-dd"));
                    cp.setCategoria(teclado.read("","Ingrese la categoría del producto"));
                    cp.setMarca(teclado.read("","Ingrese la marca del producto"));
                    cp.setPrecio(teclado.read(0.0,"Ingrese el precio"));
                    cp.setStock(teclado.read(0,"Ingrese del stock actual"));
                    crud.crearProd(cp);
                    break;
                case 2:
                    System.out.println("||>--Listar Productos");
                    for(Productos l : crud.ListarProd()){
                        System.out.println(l.getId()+"\t"+l.getNameP()+"\t"+l.getFechaV()+"\t"+l.getCategoria()+
                                "\t"+l.getMarca()+"\t"+l.getPrecio()+"\t"+l.getStock());
                    }
                    break;
                case 3:
                    System.out.println("||>--Actualizar Productos");
                    int id = teclado.read(0,"Ingrese la ID a actualizar");
                    crud.actualizarProd(id);
                    break;
                case 4:
                    System.out.println("||>--Borrar Productos");
                    int idB = teclado.read(0,"Ingrese la ID a actualizar");
                    crud.borrarProd(idB);
                    break;
                case 0:
                    System.out.println("|> Saliendo... ");
                    break;
                default:
                    System.out.println("¡Opción incorrecta¡");
                    break;
            }
        } while (opt != 0);
    }
}
