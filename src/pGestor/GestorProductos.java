package pGestor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class GestorProductos {
    private ArrayList<Producto> a = new ArrayList<>();

    public void Mostrar() {
        if (a.isEmpty()) System.out.println("vacio");
        else System.out.println(a);
    }

    public boolean Agregar(Producto p) {
        if (p == null) throw new IllegalArgumentException("nulo");
        if (a.contains(p)) return false;
        else return a.add(p);
    }

    public boolean Agregar(Producto p, int pos) {
        if (p == null) throw new IllegalArgumentException("nulo");
        try {
            if (a.contains(p)) return false;
            else {
                a.add(pos, p);
                return true;
            }

        } catch (IndexOutOfBoundsException ex) {
            return a.add(p);

        }
    }
    public void aplicarIVA(){
        for(Producto x: a){
            x.aplicarIVA();
        }
    }
    public void AumentarPrecio(String seccion){
        Iterator<Producto> it=a.iterator();
        while(it.hasNext()){
            Producto p=it.next();
            if(p.seccion.equalsIgnoreCase(seccion)){
                p.precio*=1.10;
            }
        }

    }
    public Producto maxProducto(){
        try {
            Producto max = a.get(0);
            for(int i=1;i<a.size();i++){
                if(a.get(i).precio>max.precio){
                    max=a.get(i);
                }
            }
            return max;



        } catch(IndexOutOfBoundsException ex){
            return null;
        }
    }
    public void Sustituir(ArrayList<Producto>v){
        if(v==null) throw new IllegalArgumentException("nulo");
        for(Producto x: a){
            try{
                a.set(a.indexOf(x),x);


            }catch(IndexOutOfBoundsException ex){
                System.out.println(" codigo no encontrado: "+ x);
            }

        }

    }
    public int nProductos(){
        return a.size();
    }
    public void ordenar(boolean creciente){
        if(creciente){
            Collections.sort(a);

        }else{
            Collections.sort(a,Collections.reverseOrder());

        }
    }
}
