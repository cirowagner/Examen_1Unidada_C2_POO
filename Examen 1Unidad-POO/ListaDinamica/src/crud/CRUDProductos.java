package crud;

import productos.Productos;
import java.util.*;

public class CRUDProductos {
    public List<Productos> listP = new ArrayList<>();

    int id = 0;
    public void crear(Productos pdt){
        try{
            id++;
            pdt.setId(id);
            listP.add(pdt);
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void listarP (){
        System.out.println("ID \t NombreProducto \t FechaVencimiento \t Categoría \t Marca " +
                "\t Precio \t Stock");
        for (Productos pl : listP) {
            System.out.println(pl.getId()+"\t"+pl.getNameP()+"\t"+pl.getFechaV()+"\t"+pl.getCategoria()+
                    "\t"+pl.getMarca()+"\t"+pl.getPrecio()+"\t"+pl.getStock());
        }
    }

    public void actualizar (Productos a) {
        for (Productos ac : listP) {
            if (ac.getId() == a.getId()) {
                ac.setId(a.getId());
                ac.setNameP(a.getNameP());
                ac.setFechaV(a.getFechaV());
                ac.setCategoria(a.getCategoria());
                ac.setMarca(a.getMarca());
                ac.setPrecio(a.getPrecio());
                ac.setStock(a.getStock());
                System.out.println("|> El registro de actualizo correctamente...100%");
            } else {
                System.out.println("¡Error al actualizar registro!");
            }

        }
    }

    public void borrarP(int id){
        try{
            for(Productos p : listP){
                if(id == p.getId()){
                    listP.remove(p);
                    this.id--;
                    System.out.println("Se elimino correctamente el registro número: "+p.getId());
                }else{
                    System.out.println("¡Error al eliminar el registro!");
                }
            }
        }catch (Exception e){
        }
    }
}
