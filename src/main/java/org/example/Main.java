package org.example;

import org.example.gui.ArbolFrame;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File archivo = new File("C:\\Users\\Luis Gil\\Documents\\practico\\arbol.txt");
        ArbolFrame frame = new ArbolFrame();
        frame.cargarArbolDesdeArchivo(archivo);
    }
}