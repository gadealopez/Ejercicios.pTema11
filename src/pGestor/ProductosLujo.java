package pGestor;

public class ProductosLujo extends Producto {
    public ProductosLujo(int codigo, String nombre, String seccion, double precio, int stock, boolean conIVA) {
        super(codigo, nombre, seccion, precio, stock, conIVA);
    }

    public void aplicarIVA() {
        if (!conIVA) {
            precio *= 1.21;
            conIVA = true;
        }
    }
    public ProductosLujo(int codigo,String nombre,double precio,String seccion){
        super(codigo,nombre,precio,seccion);
    }
    public ProductosLujo(int codigo){
        super(codigo);
    }
}