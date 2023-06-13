package org.example.gui;

import org.example.objetos.ListaDoble;
import org.example.objetos.Venta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class MenuFrame extends JFrame {
    private JLabel nombreLabel;
    private JTextArea ventasTextArea;

    private JButton verInfoButton;
    private JButton ventaButton;
    private JTextField ventaNueva;
    private String nombreAgregar, total;
    private int totalNum;
    public MenuFrame(String nombre) {
        super("Menu Frame");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setLayout(new BorderLayout());

        nombreLabel = new JLabel("Persona: " + nombre);
        nombreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nombreLabel.setVerticalAlignment(SwingConstants.CENTER);
        nombreLabel.setFont(nombreLabel.getFont().deriveFont(24.0f));
        add(nombreLabel, BorderLayout.NORTH);

        ventaNueva = new JTextField("Agregar Venta");
        ventaNueva.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                ventaNueva.setText("");
            }
        });

        ventasTextArea = new JTextArea(); // Agregado
        add(new JScrollPane(ventasTextArea), BorderLayout.CENTER); // Agregado

        verInfoButton = new JButton("Ver Info");
        ventaButton = new JButton("Venta");


        JPanel buttonPanel = new JPanel(new FlowLayout());

        buttonPanel.add(verInfoButton);
        buttonPanel.add(ventaButton);
        buttonPanel.add(ventaNueva);
        add(buttonPanel, BorderLayout.SOUTH);

        ventaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventaButtonActionPerformed(e);
            }
        });
    }

    public JButton getVerInfoButton() {
        return verInfoButton;
    }

    public JButton getVentaButton() {
        return ventaButton;
    }

    public JTextArea getVentasTextArea() {
        return ventasTextArea;
    }
    public void mostrarVentas(ListaDoble<Venta> ventas, JTextArea textArea) {
        textArea.setText("");
        for (Venta venta : ventas) {
            String infoVenta = "Nombre: " + venta.getNombre() + ", Cantidad: " + venta.getCantidad() + ", Fecha: " + venta.getFecha();
            textArea.append("\n" + infoVenta);
            totalNum = totalNum + venta.getCantidad();
            nombreAgregar = venta.getNombre();
        }
        textArea.setEditable(false);
    }
    private void ventaButtonActionPerformed(ActionEvent e) {
        int ventaOk = Integer.parseInt(ventaNueva.getText());
        String ventaString = ventaNueva.getText();
        if(ventaString.equalsIgnoreCase("0000")){
            mostrarTotal();
        }else{
            ventaNueva.setText("");
            agregarVentas(ventaOk);
        }
    }

    public void agregarVentas(int ventaOk){
        ventasTextArea.append("\n" + "Nombre: " + nombreAgregar + ", Cantidad: " + ventaOk + ", Fecha: " + "12.06.2023");
        totalNum = totalNum + ventaOk;
    }
    public void mostrarTotal(){
        ventasTextArea.append("\n" + "\n" + "TOTAL VENTAS: "+ (totalNum) + "\n" + "TOTAL EFECTIVO: " + ((totalNum)*15) + "Bs");
    }
}