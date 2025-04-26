package Controlador;

import Vistas.HomeView;
import Vistas.RegistrarCuentaView;
import Vistas.VisualizarClientesView;

public class HomeController {
    private HomeView vista;
    private RegistrarCuentaController crearCuentaController;
    private VisualizarClientesController visualizarCuentasController;

    public HomeController() {
        vista = new HomeView();
        crearCuentaController = new RegistrarCuentaController(vista.getCrearCuentaVista());
        visualizarCuentasController = new VisualizarClientesController(vista.getVisualizarCuentasVista());

        vista.setVisible(true);
    }

    public HomeView getVista() {
        return vista;
    }
}
