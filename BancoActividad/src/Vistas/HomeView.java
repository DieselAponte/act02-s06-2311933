package Vistas;

import javax.swing.*;

public class HomeView extends JFrame {
    private JTabbedPane tabbedPane;
    private RegistrarCuentaView crearCuentaVista;
    private VisualizarClientesView visualizarCuentasVista;

    public HomeView() {
        setTitle("Sistema Bancario");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabbedPane = new JTabbedPane();

        crearCuentaVista = new RegistrarCuentaView();
        visualizarCuentasVista = new VisualizarClientesView();

        tabbedPane.addTab("Crear Cuenta", crearCuentaVista);
        tabbedPane.addTab("Visualizar Cuentas", visualizarCuentasVista);

        add(tabbedPane);
    }

    public RegistrarCuentaView getCrearCuentaVista() { return crearCuentaVista; }
    public VisualizarClientesView getVisualizarCuentasVista() { return visualizarCuentasVista; }
    public JTabbedPane getTabbedPane() { return tabbedPane; }
}
