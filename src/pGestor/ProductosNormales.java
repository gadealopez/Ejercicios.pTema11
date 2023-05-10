package pGestor;

public class ProductosNormales extends Producto{
    public ProductosNormales(int codigo, String nombre, String seccion, double precio, int stock, boolean conIVA) {
        super(codigo, nombre, seccion, precio, stock, conIVA);
    }

    public void aplicarIVA(){
        if(!conIVA){
            precio*=1.1;
            conIVA=true;
        }
    }
    public ProductosNormales(int codigo,String nombre,double precio,String seccion){
        super(codigo,nombre,precio,seccion);
    }
    public ProductosNormales(int codigo){
        super(codigo);
    }
}
