package pGestor;

import java.util.Objects;

public abstract class Producto implements Comparable<Producto> {
     protected int codigo;
    protected String nombre;
    protected String seccion;
   protected double precio;
    protected int stock;
   protected  boolean conIVA;

   public Producto(int codigo,String nombre,double precio,String seccion){
       this.codigo=codigo;
       this.nombre=nombre;
       this.precio=precio;
       this.seccion=seccion;
   }
   public Producto(int codigo){
       this.codigo=codigo;
   }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", seccion='" + seccion + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", conIVA=" + conIVA +
                '}';
    }
    public Producto(int codigo,String nombre,String seccion,double precio,int stock,boolean conIVA){
        this.codigo=codigo;
        this.nombre=nombre;
        this.seccion=seccion;
        this.precio=precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return codigo == producto.codigo && Double.compare(producto.precio, precio) == 0 && stock == producto.stock && conIVA == producto.conIVA && Objects.equals(nombre, producto.nombre) && Objects.equals(seccion, producto.seccion);
    }

   public abstract void aplicarIVA();
    public int compareTo(Producto p){
        if(p==null)return 0;
        if(this.precio<p.precio)return -1;
        else if(this.precio>p.precio)return 1;
        else return this.nombre.compareTo(p.nombre);

    }

}
