package Recargas;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JFrame;

public class Imprimir extends JFrame implements Printable {

    public void jButton1ActionPerformed() {
        try {
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintable(this);
            job.printDialog();
            job.print();
            iniciarImpresion();
        } catch (PrinterException ex) {
        }
    }

    private void iniciarImpresion() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Ticket dialog = new Ticket();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX() + 100,
                pageFormat.getImageableY() + 50);
        g2d.scale(1, 1);
        
        Ticket.panel.printAll(graphics);
        return PAGE_EXISTS;
    }
}
