package Recargas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Proveedor extends JFrame {

    public JPanel panelProveedor;
    public JLabel titulo, estatus, compañia, numero, monto, finish;
    public JTextField cajaTextoCompañia, cajaTexto2Numero, cajaTexto2Monto;
    public JButton boton;

    // Obtener datos
    Recargas recargas = new Recargas();

    public Proveedor() {
        this.setSize(400, 400);
        this.setTitle("Recargas telefonicas");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        agregarPanel();
        etiquetas();
        colocarCajasTexto();
        colocarBoton();
    }

    private void agregarPanel() {
        panelProveedor = new JPanel();
        panelProveedor.setLayout(null);
        this.add(panelProveedor);
    }

    private void etiquetas() {
        titulo = new JLabel();
        titulo.setText("Proveedor");
        titulo.setFont(new Font("Bookman Old Style", 3, 40));
        titulo.setForeground(Color.BLUE);
        titulo.setBounds(90, 0, 350, 100);
        panelProveedor.add(titulo);

        estatus = new JLabel();
        estatus.setText("GENERANDO RECARGA...");
        estatus.setFont(new Font("Bookman Old Style", 1, 20));
        estatus.setForeground(Color.BLACK);
        estatus.setBounds(60, 70, 300, 50);
        panelProveedor.add(estatus);

        compañia = new JLabel();
        compañia.setText("Compañia telefonica:");
        compañia.setFont(new Font("arial", 1, 13));
        compañia.setForeground(Color.BLACK);
        compañia.setBounds(30, 115, 140, 50);
        panelProveedor.add(compañia);

        numero = new JLabel();
        numero.setText("Número Telefonico:");
        numero.setFont(new Font("arial", 1, 13));
        numero.setForeground(Color.BLACK);
        numero.setBounds(30, 145, 140, 50);
        panelProveedor.add(numero);

        monto = new JLabel();
        monto.setText("Monto:");
        monto.setFont(new Font("arial", 1, 13));
        monto.setForeground(Color.BLACK);
        monto.setBounds(30, 175, 140, 50);
        panelProveedor.add(monto);

        finish = new JLabel();
        finish.setText("RECARGA EXITOSA");
        finish.setFont(new Font("Bookman Old Style", 1, 20));
        finish.setForeground(Color.BLACK);
        finish.setBounds(90, 220, 250, 50);
        panelProveedor.add(finish);
    }

    private void colocarCajasTexto() {
        cajaTextoCompañia = new JTextField();
        cajaTextoCompañia.setBounds(190, 130, 140, 20);
        cajaTextoCompañia.setText(Recargas.getCompañia);
        cajaTextoCompañia.setEditable(false);
        cajaTextoCompañia.setBackground(Color.WHITE);
        cajaTextoCompañia.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        panelProveedor.add(cajaTextoCompañia);

        cajaTexto2Numero = new JTextField();
        cajaTexto2Numero.setBounds(190, 160, 140, 20);
        cajaTexto2Numero.setText(recargas.getNumero);
        cajaTexto2Numero.setEditable(false);
        cajaTexto2Numero.setBackground(Color.WHITE);
        cajaTexto2Numero.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        panelProveedor.add(cajaTexto2Numero);

        cajaTexto2Monto = new JTextField();
        cajaTexto2Monto.setBounds(190, 190, 140, 20);
        cajaTexto2Monto.setText(recargas.getMonto);
        cajaTexto2Monto.setEditable(false);
        cajaTexto2Monto.setBackground(Color.WHITE);
        cajaTexto2Monto.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        panelProveedor.add(cajaTexto2Monto);
    }
    
    private void generarTicket() {
        Ticket ticket = new Ticket();
        ticket.setVisible(true);
        dispose();
    }

    private void colocarBoton() {
        boton = new JButton("Generar Ticket");
        boton.setBounds(120, 280, 150, 50);
        panelProveedor.add(boton);
        
        ActionListener evento = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarTicket();
            }
        };
        boton.addActionListener(evento);
        
    }

}