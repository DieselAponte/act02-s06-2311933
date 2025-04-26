package Utilidades;

import Modelo.Producto.CuentaAhorro;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Archivo {
    private String nombreArchivo;

    public Archivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void guardarCuenta(CuentaAhorro cuenta) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo, true))) {
            writer.println(cuenta.getDetalles());
        }
    }

    public List<String> leerCuentas() throws IOException {
        List<String> lineas = new ArrayList<>();
        File file = new File(nombreArchivo);

        if (!file.exists()) {
            return lineas;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                lineas.add(linea);
            }
        }
        return lineas;
    }
}