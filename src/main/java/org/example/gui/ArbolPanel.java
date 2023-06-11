package org.example.gui;

import org.example.objetos.Arbol;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ArbolPanel extends JPanel implements MouseListener {
    private Arbol<String> modelo;
    private DibujoArbol dibujo;

    public ArbolPanel(Arbol<String> modelo) {
        this.modelo = modelo;
        this.dibujo = new DibujoArbol(modelo);

        // Registra el ArbolPanel como receptor de eventos de clic
        this.addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        dibujo.dibujar(g);
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600,500);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int xClic = e.getX();
        int yClic = e.getY();

        String nombreNodo = dibujo.obtenerNodoClic(xClic, yClic);
        if (nombreNodo != null) {
            MenuFrame menuFrame = new MenuFrame(nombreNodo);

            menuFrame.getVerSalirButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Acción cuando se presiona el botón "Ver Salir"
                    System.out.println("Ver Salir");
                }
            });

            menuFrame.getVerInfoButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Acción cuando se presiona el botón "Ver Info"
                    System.out.println("Ver Info");
                }
            });

            menuFrame.getVentaButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Acción cuando se presiona el botón "Venta"
                    System.out.println("Venta");
                }
            });

            menuFrame.setVisible(true);
        }
    }


    // Implementa los demás métodos de MouseListener, aunque no los utilicemos
    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
