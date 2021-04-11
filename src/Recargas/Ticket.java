package Recargas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Ticket extends JFrame implements Printable{

    public static JPanel panel;
    public JTextPane encabezado;
    public JTextField compañia, monto, autorizacion, total, telefono;
    public JLabel etiqueta;
    public JButton imprimir;
    
    Recargas recargas = new Recargas();
    Imprimir impresion = new Imprimir();
    
    public Ticket() {
        this.setSize(450, 520);
        this.setTitle("Ticket");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        iniciarPanel();
        colocarTextoPane();
        colocarCajasTexto();
        agradecimiento();
        imprimir();
    }

    private void iniciarPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
    }

    private void colocarTextoPane() {
        encabezado = new JTextPane();
        encabezado.setBounds(30, 10, 370, 120);
        encabezado.setText("\nCadena comercial Oxxo, S.A. de C.V.\nCCO-860523-1N4\nEdison Nte. Numero 235 Colonia talleres\nMonterrey, Nuevo León C.P. 64480\nJARDINES PAZ");
        encabezado.setFont(new Font("Bookman Old Style", 0, 13));
        encabezado.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); //pintar bordes
        encabezado.setEditable(false);
        panel.add(encabezado, BorderLayout.CENTER);

        // Centrar texto
        StyledDocument doc = encabezado.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
    }
    
    public int getNumAutorizacion() {
        Random rn = new Random();
        int numero = rn.nextInt(999999) + 100000;
        return numero;        
    }
    
    private void colocarCajasTexto() {
        compañia = new JTextField();
        compañia.setBounds(140, 150, 150, 20);
        compañia.setText("COMPAÑIA: " + Recargas.getCompañia);
        compañia.setEditable(false);
        compañia.setFont(new Font("Bookman Old Style", 0, 13));
        compañia.setBackground(Color.WHITE);
        compañia.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panel.add(compañia); 
        
        monto = new JTextField();
        monto.setBounds(140, 180, 150, 20);
        monto.setText("MONTO: " + Recargas.getMonto);
        monto.setEditable(false);
        monto.setFont(new Font("Bookman Old Style", 0, 13));
        monto.setBackground(Color.WHITE);
        monto.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panel.add(monto);
        
        autorizacion = new JTextField();
        autorizacion.setBounds(125, 210, 180, 20);
        autorizacion.setText("AUTORIZACION: " + getNumAutorizacion());
        autorizacion.setEditable(false);
        autorizacion.setFont(new Font("Bookman Old Style", 0, 13));
        autorizacion.setBackground(Color.WHITE);
        autorizacion.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panel.add(autorizacion);
        
        total = new JTextField();
        total.setBounds(140, 240, 150, 20);
        total.setText("TOTAL: $" + Recargas.getMonto);
        total.setEditable(false);
        total.setFont(new Font("Bookman Old Style", 0, 13));
        total.setBackground(Color.WHITE);
        total.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panel.add(total);
        
        telefono = new JTextField();
        telefono.setBounds(100, 280, 240, 40);
        telefono.setText("TELEFONO ABONADO: " + Recargas.getNumero);
        telefono.setEditable(false);
        telefono.setFont(new Font("Bookman Old Style", 0, 13));
        telefono.setBackground(Color.WHITE);
        telefono.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panel.add(telefono);
    }
    
    private void agradecimiento() {
        etiqueta = new JLabel();
        etiqueta.setText("¡GRACIAS POR TU VISITA!");
        etiqueta.setFont(new Font("Bookman Old Style", 1, 15));
        etiqueta.setForeground(Color.BLACK);
        etiqueta.setBounds(115, 330, 230, 80);
        panel.add(etiqueta);
    }
    
    private void imprimir() {
        imprimir = new JButton("Imprimir");
        imprimir.setBounds(160, 400, 120, 40);
        panel.add(imprimir);
        
        ActionListener evento = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                impresion.jButton1ActionPerformed();
                dispose();
            }
        };
        imprimir.addActionListener(evento);
    }   

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        throw new UnsupportedOperationException();
    }
}
