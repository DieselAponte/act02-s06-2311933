package Vistas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RegistrarCuentaView extends JPanel {
    private JComboBox<String> tipoCuentaCombo;
    private JTextField numeroCuentaField;
    private JTextField titularField;
    private JTextField emailField;
    private JTextField montoField;
    private JTextField plazoField;
    private JTextField tasaField;
    private JTextField menorField;
    private JTextField tutorField;
    private JButton agregarTitularBtn;
    private JList<String> titularesList;
    private DefaultListModel<String> titularesModel;
    private JButton crearCuentaBtn;
    private JTextArea resultadoArea;

    public RegistrarCuentaView() {
        setLayout(new BorderLayout());

        // Panel de entrada de datos
        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 5, 5));

        tipoCuentaCombo = new JComboBox<>(new String[]{"Sueldo", "Digital", "Mancomunada", "Plazo Fijo", "Menores"});
        tipoCuentaCombo.addActionListener(e -> actualizarCampos());

        inputPanel.add(new JLabel("Tipo de Cuenta:"));
        inputPanel.add(tipoCuentaCombo);

        numeroCuentaField = new JTextField();
        inputPanel.add(new JLabel("Número de Cuenta:"));
        inputPanel.add(numeroCuentaField);

        titularField = new JTextField();
        inputPanel.add(new JLabel("Titular:"));
        inputPanel.add(titularField);

        emailField = new JTextField();
        inputPanel.add(new JLabel("Email (Digital):"));
        inputPanel.add(emailField);

        montoField = new JTextField();
        inputPanel.add(new JLabel("Monto (Plazo Fijo):"));
        inputPanel.add(montoField);

        plazoField = new JTextField();
        inputPanel.add(new JLabel("Plazo días (Plazo Fijo):"));
        inputPanel.add(plazoField);

        tasaField = new JTextField();
        inputPanel.add(new JLabel("Tasa interés (Plazo Fijo):"));
        inputPanel.add(tasaField);

        menorField = new JTextField();
        inputPanel.add(new JLabel("Menor (Cuenta Menores):"));
        inputPanel.add(menorField);

        tutorField = new JTextField();
        inputPanel.add(new JLabel("Tutor (Cuenta Menores):"));
        inputPanel.add(tutorField);

        // Panel para cuentas mancomunadas
        JPanel mancomunadaPanel = new JPanel(new BorderLayout());
        titularesModel = new DefaultListModel<>();
        titularesList = new JList<>(titularesModel);

        agregarTitularBtn = new JButton("Agregar Titular");
        agregarTitularBtn.addActionListener(e -> {
            if (!titularField.getText().isEmpty()) {
                titularesModel.addElement(titularField.getText());
                titularField.setText("");
            }
        });

        mancomunadaPanel.add(new JLabel("Titulares Mancomunados:"), BorderLayout.NORTH);
        mancomunadaPanel.add(new JScrollPane(titularesList), BorderLayout.CENTER);
        mancomunadaPanel.add(agregarTitularBtn, BorderLayout.SOUTH);

        // Panel principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(mancomunadaPanel, BorderLayout.CENTER);

        // Botón de crear cuenta
        crearCuentaBtn = new JButton("Crear Cuenta");

        // Área de resultados
        resultadoArea = new JTextArea(5, 20);
        resultadoArea.setEditable(false);

        // Organización final
        add(mainPanel, BorderLayout.NORTH);
        add(crearCuentaBtn, BorderLayout.CENTER);
        add(new JScrollPane(resultadoArea), BorderLayout.SOUTH);

        // Inicializar campos según el tipo de cuenta seleccionado
        actualizarCampos();
    }

    private void actualizarCampos() {
        String tipo = (String) tipoCuentaCombo.getSelectedItem();

        titularField.setEnabled(!tipo.equals("Mancomunada"));
        emailField.setEnabled(tipo.equals("Digital"));
        montoField.setEnabled(tipo.equals("Plazo Fijo"));
        plazoField.setEnabled(tipo.equals("Plazo Fijo"));
        tasaField.setEnabled(tipo.equals("Plazo Fijo"));
        menorField.setEnabled(tipo.equals("Menores"));
        tutorField.setEnabled(tipo.equals("Menores"));
        agregarTitularBtn.setEnabled(tipo.equals("Mancomunada"));
        titularesList.setEnabled(tipo.equals("Mancomunada"));
    }

    // Getters para los componentes
    public JComboBox<String> getTipoCuentaCombo() { return tipoCuentaCombo; }
    public JTextField getNumeroCuentaField() { return numeroCuentaField; }
    public JTextField getTitularField() { return titularField; }
    public JTextField getEmailField() { return emailField; }
    public JTextField getMontoField() { return montoField; }
    public JTextField getPlazoField() { return plazoField; }
    public JTextField getTasaField() { return tasaField; }
    public JTextField getMenorField() { return menorField; }
    public JTextField getTutorField() { return tutorField; }
    public JButton getAgregarTitularBtn() { return agregarTitularBtn; }
    public DefaultListModel<String> getTitularesModel() { return titularesModel; }
    public JButton getCrearCuentaBtn() { return crearCuentaBtn; }
    public JTextArea getResultadoArea() { return resultadoArea; }
}
