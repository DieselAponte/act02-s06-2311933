package Controlador;

import Utilidades.Archivo;
import Modelo.Producto.CuentaAhorro;
import Modelo.Factory.Registrador;
import Excepciones.CuentaException;
import Vistas.RegistrarCuentaView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class RegistrarCuentaController {
    private RegistrarCuentaView vista;
    private Archivo archivo;

    public RegistrarCuentaController(RegistrarCuentaView vista) {
        this.vista = vista;
        this.archivo = new Archivo("cuentas.txt");

        configurarListeners();
    }

    private void configurarListeners() {
        vista.getCrearCuentaBtn().addActionListener(e -> crearCuenta());
    }

    private void crearCuenta() {
        try {
            String tipo = (String) vista.getTipoCuentaCombo().getSelectedItem();
            String numeroCuenta = vista.getNumeroCuentaField().getText();

            if (numeroCuenta.isEmpty()) {
                throw new CuentaException("El número de cuenta es requerido");
            }

            CuentaAhorro cuenta = null;

            switch (tipo) {
                case "Sueldo":
                    cuenta = Registrador.crearCuenta(tipo, numeroCuenta,
                            vista.getTitularField().getText());
                    break;
                case "Digital":
                    cuenta = Registrador.crearCuenta(tipo, numeroCuenta,
                            vista.getTitularField().getText(),
                            vista.getEmailField().getText());
                    break;
                case "Mancomunada":
                    List<String> titulares = new ArrayList<>();
                    for (int i = 0; i < vista.getTitularesModel().size(); i++) {
                        titulares.add(vista.getTitularesModel().get(i));
                    }
                    if (titulares.isEmpty()) {
                        throw new CuentaException("Debe agregar al menos un titular");
                    }
                    cuenta = Registrador.crearCuenta(tipo, numeroCuenta, titulares);
                    break;
                case "Plazo Fijo":
                    double monto = Double.parseDouble(vista.getMontoField().getText());
                    int plazo = Integer.parseInt(vista.getPlazoField().getText());
                    double tasa = Double.parseDouble(vista.getTasaField().getText());
                    cuenta = Registrador.crearCuenta(tipo, numeroCuenta,
                            vista.getTitularField().getText(), monto, plazo, tasa);
                    break;
                case "Menores":
                    cuenta = Registrador.crearCuenta(tipo, numeroCuenta,
                            vista.getMenorField().getText(),
                            vista.getTutorField().getText());
                    break;
            }

            archivo.guardarCuenta(cuenta);
            vista.getResultadoArea().append("Cuenta creada exitosamente:\n" + cuenta.getDetalles() + "\n\n");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Error en formato numérico: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (CuentaException e) {
            JOptionPane.showMessageDialog(vista, e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "Error al crear la cuenta: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
