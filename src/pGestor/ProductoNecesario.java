package pGestor;

public class ProductoNecesario extends Producto{
    public ProductoNecesario(int codigo, String nombre, String seccion, double precio, int stock, boolean conIVA) {
        super(codigo, nombre, seccion, precio, stock, conIVA);
    }

    public void aplicarIVA(){
        if(!conIVA){
            precio*=1.04;
            conIVA=true;
        }
    }
    public ProductoNecesario(int codigo,String nombre,double precio,String seccion){
        super(codigo,nombre,precio,seccion);
    }
    public ProductoNecesario(int codigo){
        super(codigo);
    }
}
