/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// comentario para que elimine el rollback.

package conversoreuros;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jesus
 */
public class ConversorEuros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame ventana = new JFrame();
        JPanel miPanel = new JPanel();
        final JLabel pesetas = new JLabel();
        //botones
        JLabel texto0 = new JLabel("Importe en euros");
        final JTextField textValor = new JTextField(10);
        
        JButton convertir = new JButton("Convertir");
        JLabel texto1 = new JLabel("Pulse para obtener importe en pesetas");
        texto1.setSize(new Dimension(50, 10)); 
       
        //codigo para actuar sobre el botón
        
        convertir.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                boolean ok = true;
                int longitud = textValor.getText().length();
                String valor =  textValor.getText();
                System.out.println(valor);
                for (int i=0;i<longitud;i++)
                    if (!Character.isDigit(valor.charAt(i))) {
                        System.out.println(valor.charAt(i));
                        ok = false;
                        break;
                    }
                if (ok) {
                    float cantidad = Float.parseFloat(valor);
                    float conv = (float) 166.386;
                    cantidad = cantidad * conv;
                    pesetas.setText(cantidad + " pesetas.");
                }
                else pesetas.setText("El campo de texto no es un número");
            }
        });
        ventana.setSize(300,200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        miPanel.add(texto0);
        miPanel.add(textValor);
        miPanel.add(convertir);
        miPanel.add(texto1);
        miPanel.add(pesetas);
        
        ventana.setLayout(new BoxLayout(ventana.getContentPane(),BoxLayout.Y_AXIS));
        ventana.setTitle("Conversor de euros a pesetas.");
        ventana.setContentPane(miPanel);
        
        ventana.setVisible(true);
    }
    
}
