package main;

import productos.Productos;
import crud.CRUDProductos;
import util.BufferedZ;

public class Main {
    public static void main(String[] args) {
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
                    System.out.println("||--Añadir Productos");
                    Productos cp = new Productos();
                    cp.setNameP(teclado.read("","Ingrese el nombre del producto"));
                    cp.setFechaV(teclado.read("","Ingrese la fecha de vencimiento | yyyy-MM-dd"));
                    cp.setCategoria(teclado.read("","Ingrese la categoría del producto"));
                    cp.setMarca(teclado.read("","Ingrese la marca del producto"));
                    cp.setPrecio(teclado.read(0.0,"Ingrese el precio"));
                    cp.setStock(teclado.read(0,"Ingrese el stock actual"));
                    crud.crear(cp);
                    break;
                case 2:
                    System.out.println("||>--Listar Productos");
                    crud.listarP();
                    break;
                case 3:
                    System.out.println("||>--Actualizar Productos");
                    Productos ap = new Productos();
                    ap.setId(teclado.read(0,"Ingrese la ID a actualizar"));
                    ap.setNameP(teclado.read("","Ingrese el nuevo nombre del producto"));
                    ap.setFechaV(teclado.read("","Ingrese la nueva fecha de vencimiento"));
                    ap.setCategoria(teclado.read("","Ingrese la nueva categoría del producto"));
                    ap.setMarca(teclado.read("","Ingrese la nueva marca del producto"));
                    ap.setPrecio(teclado.read(0.0,"Ingrese el nuevo precio"));
                    ap.setStock(teclado.read(0,"Ingrese el stock actual"));
                    crud.actualizar(ap);
                    break;
                case 4:
                    System.out.println("||>--Borrar Productos");
                    crud.borrarP(teclado.read(0,"Ingrese la ID a eliminar"));
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
