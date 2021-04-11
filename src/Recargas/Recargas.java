package Recargas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Recargas extends JFrame implements ActionListener {

    public JPanel panel;
    public JLabel titulo, compañias, numero, monto, autor;
    public JRadioButton radio1, radio2, radio3, radio4;
    public ButtonGroup grupo;
    public JTextField cajaTextoNumero, cajaTextoMonto;
    public JButton proveedor, cancelar;
    public static String getCompañia;
    public static String getNumero;
    public static String getMonto;
    boolean cajasLlenas = false;

    public Recargas() {
        this.setSize(400, 440);
        this.setTitle("Recargas telefonicas");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false); // no permite que se le cambie el tamaño
        iniciarComponentes();
    }

    public Recargas(String getCompañia) {
        this.getCompañia = getCompañia;
    }

    private void iniciarComponentes() {
        iniciarPanel();
        etiquetas();
        colocarRadioBotones();
        colocarCajasTexto();
        colocarBotones();
    }

    private void iniciarPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
    }

    private void etiquetas() {
        titulo = new JLabel();
        titulo.setText("Tiempo Aire");
        titulo.setFont(new Font("Bookman Old Style", 3, 40));
        titulo.setForeground(Color.BLUE);
        titulo.setBounds(70, 0, 350, 100);
        panel.add(titulo);

        compañias = new JLabel();
        compañias.setText("Compañias");
        compañias.setFont(new Font("Bookman Old Style", 1, 18));
        compañias.setForeground(Color.BLACK);
        compañias.setBounds(40, 70, 100, 50);
        panel.add(compañias);

        numero = new JLabel();
        numero.setText("Número Telefonico:");
        numero.setFont(new Font("arial", 1, 12));
        numero.setForeground(Color.BLACK);
        numero.setBounds(30, 240, 130, 50);
        panel.add(numero);

        monto = new JLabel();
        monto.setText("Monto:");
        monto.setFont(new Font("arial", 1, 12));
        monto.setForeground(Color.BLACK);
        monto.setBounds(30, 270, 130, 50);
        panel.add(monto);
        
        autor = new JLabel();
        autor.setText("@author: Adrián");
        autor.setFont(new Font("arial", 3, 12));
        autor.setForeground(Color.BLACK);
        autor.setBounds(150, 370, 100, 30);
        panel.add(autor);
        
    }

    private void colocarRadioBotones() {
        radio1 = new JRadioButton("Telcel");
        radio1.setFont(new Font("arial", 1, 12));
        radio1.setBounds(55, 110, 100, 40);
        panel.add(radio1);

        radio2 = new JRadioButton("Movistar");
        radio2.setFont(new Font("arial", 1, 12));
        radio2.setBounds(55, 140, 100, 40);
        panel.add(radio2);

        radio3 = new JRadioButton("AT&T");
        radio3.setFont(new Font("arial", 1, 12));
        radio3.setBounds(55, 170, 100, 40);
        panel.add(radio3);

        radio4 = new JRadioButton("Unefon");
        radio4.setFont(new Font("arial", 1, 12));
        radio4.setBounds(55, 200, 100, 40);
        panel.add(radio4);

        grupo = new ButtonGroup();
        grupo.add(radio1);
        grupo.add(radio2);
        grupo.add(radio3);
        grupo.add(radio4);
    }

    private void colocarCajasTexto() {
        cajaTextoNumero = new JTextField();
        cajaTextoNumero.setBounds(150, 255, 180, 20);
        panel.add(cajaTextoNumero);

        cajaTextoMonto = new JTextField();
        cajaTextoMonto.setBounds(150, 285, 80, 20);
        panel.add(cajaTextoMonto);
    }

    private void colocarBotones() {
        proveedor = new JButton("Enviar a Proveedor");
        proveedor.setBounds(40, 330, 160, 30);
        proveedor.addActionListener((ActionListener) this);
        panel.add(proveedor);

        cancelar = new JButton("Cancelar");
        cancelar.setBounds(230, 330, 110, 30);
        cancelar.addActionListener((ActionListener) this);
        panel.add(cancelar);
    }

    private void iniciarProveedor() {
        Proveedor enviar = new Proveedor();
        enviar.setVisible(true);
        dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == proveedor) {
            validarElementos();
            if (getCompañia != null && cajasLlenas == true) {
                iniciarProveedor();
            } else {
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
            }

        } else if (e.getSource() == cancelar) {
            dispose();
        }
    }

    private void valideRadios() {
        if (radio1.isSelected()) {
            getCompañia = "Telcel";

        } else if (radio2.isSelected()) {
            getCompañia = "Movistar";

        } else if (radio3.isSelected()) {
            getCompañia = "AT&T";

        } else if (radio4.isSelected()) {
            getCompañia = "Unefon";

        }
    }

    private void valideCajasTexto() {
        if (!cajaTextoNumero.getText().isEmpty() && !(cajaTextoMonto.getText().isEmpty())) {
            getNumero = cajaTextoNumero.getText();
            getMonto = cajaTextoMonto.getText();
            cajasLlenas = true;
        }
    }

    private void validarElementos() {
        valideRadios();
        valideCajasTexto();
    }

    public static void main(String[] args) {
        Recargas ventana = new Recargas();
        ventana.setVisible(true);

    }
}
