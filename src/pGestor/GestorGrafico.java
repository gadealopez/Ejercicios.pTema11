package pGestor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GestorGrafico extends JFrame {
    public static void main(String[] args) {
        new GestorGrafico();
    }
    //ATRIBUTOS
    private JLabel eC,eN,eP,eT,eS;
    private JTextField tC,tN,tP;
    private JButton bA,bE,bI;

    //RADIO
    private JRadioButton rR,rN,rL;
    private ButtonGroup grupo;

    //NUEVOS
    private JTextArea area;
    private JComboBox cmb;

    //OTROS
    ArrayList<Producto>al;
    private boolean orden;
    Listener listener;












    //INICIALIZACIÓN Y CONFIGURACIÓN
    public GestorGrafico(){

            // VENTANA
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(200, 200, 1100, 340);
            setTitle("Gestor Productos");
            setLayout(null);

            // RESTO DE COMPONENTES
            eC = new JLabel("Codigo: ");
            eN = new JLabel("Nombre: ");
            eP = new JLabel("Precio: ");
            tC = new JTextField();
            tN = new JTextField();
            tP = new JTextField();
            bA = new JButton("Añadir");
            bE = new JButton("Eliminar");
            bI = new JButton("Inventario");

            // Ubicacion
            eC.setBounds(20, 20, 100, 30);
            eN.setBounds(20, 50, 100, 30);
            eP.setBounds(20, 80, 100, 30);

            tC.setBounds(120, 20, 100, 30);
            tN.setBounds(120, 50, 100, 30);
            tP.setBounds(120, 80, 100, 30);

            bA.setBounds(20, 260, 100, 30);
            bE.setBounds(120, 260, 100, 30);

            bI.setBounds(250, 260, 100, 30);

            // add
            add(eC);
            add(eN);
            add(eP);
            add(tC);
            add(tN);
            add(tP);
            add(bA);
            add(bE);
            add(bI);

            // RADIO BUTTONS
            eT = new JLabel("Tipo: ");
            rR = new JRadioButton("Reducido");
            rN = new JRadioButton("Normal");
            rL = new JRadioButton("Lujo");

            eT.setBounds(20, 110, 100, 30);
            rR.setBounds(120, 110, 100, 30);
            rN.setBounds(120, 140, 100, 30);
            rL.setBounds(120, 170, 100, 30);

            add(eT);
            add(rR);
            add(rN);
            add(rL);

            grupo = new ButtonGroup();
            grupo.add(rR);
            grupo.add(rN);
            grupo.add(rL);
            rN.setSelected(true);

            area = new JTextArea();
            area.setBounds(660, 20, 400, 210);
            add(area);

            // COMBO BOX
            eS = new JLabel("Seccion: ");
            cmb = new JComboBox();

            eS.setBounds(20, 200, 100, 30);
            cmb.setBounds(120, 200, 100, 30);

            add(eS);
            add(cmb);

            cmb.addItem("Oficina");
            cmb.addItem("Limpieza");
            cmb.addItem("Almacen");
            cmb.setBackground(Color.yellow);

            // OTROS
            listener = new Listener();
            al = new ArrayList<>();

            bA.addActionListener(listener);
            bE.addActionListener(listener);
            bI.addActionListener(listener);

            setVisible(true);

    }

    private class Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()== bA){
                try{
                int codigo=Integer.parseInt(tC.getText());
                String nombre=tN.getText();
                double precio=Double.parseDouble(tP.getText());
                String seccion=cmb.getSelectedItem().toString();
                if(nombre.isEmpty()){
                    throw new IllegalArgumentException();
                }
                    Producto p;
                    if(rR.isSelected()){
                        p=new ProductoNecesario(codigo,nombre,precio,seccion);

                    }else if(rN.isSelected()){
                        p=new ProductosNormales(codigo,nombre,precio,seccion);

                    }else{
                        p=new ProductosLujo(codigo,nombre,precio,seccion);

                    }if(al.contains(p))JOptionPane.showMessageDialog(null,"codigo repe");
                    else{
                        al.add(p);
                        mostrarDatos();

                    }


            }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null," error: "+ ex.getMessage());
                }catch (IllegalArgumentException ex){
                    JOptionPane.showMessageDialog(null,"error: nombre vacio");

                }

                if(e.getSource()==bE){
                    try{
                        int codigo=Integer.parseInt(tC.getText());
                        Producto p=new ProductosNormales(codigo);
                        if(al.remove(p)){
                            mostrarDatos();

                        }else{
                            JOptionPane.showMessageDialog(null,"codigo not found");
                        }

                    }catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(null,"codigo not well");
                    }
                }




                }

        }
    }
    private void mostrarDatos(){
        area.setText("");
        StringBuilder s=new StringBuilder();
        for(Producto x: al){
            s.append(x.toString()+"\n");
        }
        area.setText(s.toString());
    }





} //FIN DE LA CLASE
