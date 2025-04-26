package Vistas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VisualizarClientesView extends JPanel {
    private JTextArea cuentasArea;
    private JButton cargarCuentasBtn;
    private JButton limpiarBtn;
    private JTable cuentasTable;
    private DefaultTableModel tableModel;

    public VisualizarClientesView() {
        setLayout(new BorderLayout());

        cuentasArea = new JTextArea(5, 60); // Lo reduzco un poco
        cuentasArea.setEditable(false);

        // Configurar el JTable
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[] {"Tipo de Cuenta", "Número de Cuenta", "Titular(es)", "Saldo"});
        cuentasTable = new JTable(tableModel);
        cuentasTable.setEnabled(false); // Solo para visualizar

        JPanel buttonPanel = new JPanel();
        cargarCuentasBtn = new JButton("Cargar Cuentas");
        limpiarBtn = new JButton("Limpiar");

        buttonPanel.add(cargarCuentasBtn);
        buttonPanel.add(limpiarBtn);

        // Panel principal
        add(new JScrollPane(cuentasArea), BorderLayout.NORTH);
        add(new JScrollPane(cuentasTable), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public JTextArea getCuentasArea() { return cuentasArea; }
    public JButton getCargarCuentasBtn() { return cargarCuentasBtn; }
    public JButton getLimpiarBtn() { return limpiarBtn; }
    public JTable getCuentasTable() { return cuentasTable; }
    public DefaultTableModel getTableModel() { return tableModel; }
}
