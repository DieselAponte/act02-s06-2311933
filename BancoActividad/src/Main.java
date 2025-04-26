import Controlador.HomeController;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Configurar el Look and Feel del sistema
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Error al configurar el Look and Feel: " + e.getMessage());
        }

        // Ejecutar la aplicación en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            // Crear e iniciar el controlador principal
            HomeController homeController = new HomeController();

            // Opcional: Configuración adicional de la ventana principal
            homeController.getVista().setTitle("Sistema Bancario - Home");
            homeController.getVista().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            homeController.getVista().setLocationRelativeTo(null); // Centrar en pantalla
        });
    }

    }
