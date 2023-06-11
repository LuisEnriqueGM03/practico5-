package org.example.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends JFrame {
    private JLabel nombreLabel;
    private JButton verSalirButton;
    private JButton verInfoButton;
    private JButton ventaButton;

    public MenuFrame(String nombre) {
        super("Menu Frame");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setLayout(new BorderLayout());

        nombreLabel = new JLabel("Persona: " + nombre);
        nombreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nombreLabel.setVerticalAlignment(SwingConstants.CENTER);
        nombreLabel.setFont(nombreLabel.getFont().deriveFont(24.0f));
        add(nombreLabel, BorderLayout.CENTER);

        verSalirButton = new JButton("Ver Salir");
        verInfoButton = new JButton("Ver Info");
        ventaButton = new JButton("Venta");

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(verSalirButton);
        buttonPanel.add(verInfoButton);
        buttonPanel.add(ventaButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public JButton getVerSalirButton() {
        return verSalirButton;
    }

    public JButton getVerInfoButton() {
        return verInfoButton;
    }

    public JButton getVentaButton() {
        return ventaButton;
    }
}
