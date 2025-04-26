package Controlador;

import Vistas.VisualizarClientesView;
import Utilidades.Archivo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class VisualizarClientesController {
    private VisualizarClientesView vista;
    private Archivo archivo;

    public VisualizarClientesController(VisualizarClientesView vista) {
        this.vista = vista;
        this.archivo = new Archivo("cuentas.txt");

        configurarListeners();
    }

    private void configurarListeners() {
        vista.getCargarCuentasBtn().addActionListener(e -> cargarCuentas());
        vista.getLimpiarBtn().addActionListener(e -> limpiarVista());
    }

    private void cargarCuentas() {
        try {
            List<String> lineas = archivo.leerCuentas();
            DefaultTableModel model = vista.getTableModel();
            model.setRowCount(0); // Limpiar tabla

            if (lineas.isEmpty()) {
                vista.getCuentasArea().setText("No hay cuentas registradas.");
                return;
            }

            StringBuilder sb = new StringBuilder();
            for (String linea : lineas) {
                sb.append(linea).append("\n");

                // Parsear cada línea
                String tipoCuenta = "";
                String numeroCuenta = "";
                String titular = "";
                String saldo = "";

                try {
                    if (linea.contains("-")) {
                        String[] partes = linea.split("-", 2);
                        tipoCuenta = partes[0].trim();

                        String[] datos = partes[1].split(",");
                        for (String dato : datos) {
                            dato = dato.trim();
                            if (dato.startsWith("Nro:")) {
                                numeroCuenta = dato.substring(4).trim();
                            } else if (dato.startsWith("Titular:")) {
                                titular = dato.substring(8).trim();
                            } else if (dato.startsWith("Saldo:")) {
                                saldo = dato.substring(6).trim();
                            }
                        }
                    }

                    model.addRow(new Object[] {tipoCuenta, numeroCuenta, titular, saldo});
                } catch (Exception ex) {
                    System.out.println("Error parseando línea: " + linea);
                }
            }
            vista.getCuentasArea().setText(sb.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "Error al cargar cuentas: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarVista() {
        vista.getCuentasArea().setText("");
        vista.getTableModel().setRowCount(0); // Limpiar tabla también
    }
}
