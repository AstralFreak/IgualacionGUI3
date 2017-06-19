package mx.unam.psicologia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by pablo on 18/06/17.
 */
public class MainWindow {
    private JPanel applicationWindow;
    /**
     * Elementos panelBienvenida
     */
    private JPanel panelBienvenida;
    private JTextPane JTexpaneInstrucciones;
    private JButton buttonComenzar;
    private JPanel panelDatos;
    /**
     * Elementos panelDatos
     */
    private JButton buttonCancelar;
    private JButton buttonAceptar;
    private JTextField textFieldNumeroCaso;
    private JTextField textFieldNumeroEnsayo;
    private JTextField textFieldApellidos;
    private JTextField textFieldNombres;
    private JTextField textFieldAplicador;
    private JLabel labelAplicador;
    private JLabel labelNumeroCaso;
    private JLabel labelNumeroEnsayo;
    private JLabel labelApellidos;
    private JLabel labelNombres;
    private JLabel labelIntroduceDatos;
    /**
     * Elementos panelConfirmarDatos
     */
    private JPanel panelConfirmacion;
    private JButton buttonCorregir;
    private JButton buttonContinuarAEnsayo;
    private JLabel labelConfirmaNumeroCaso;
    private JLabel labelConfirmaNumeroEnsayo;
    private JLabel labelConfirmaApellidos;
    private JLabel labelConfirmaNombres;
    private JLabel labelConfirmaAplicador;
    private JLabel labelConfirmaDatos;

    /**
     *
     * Variables Publicas
     */

    String numeroCaso;
    String numeroEnsayo;
    String apellidos;
    String nombres;
    String aplicador;

    /**
     *
     * Main Method
     */

    public static void main(String[] args) {
        JFrame frame = new JFrame("Igualación a la Muestra");
        frame.setContentPane(new MainWindow().applicationWindow);
        frame.setDefaultCloseOperation(3);
        frame.pack();
        frame.setVisible(true);

    }

    public MainWindow() {

        /**
         * Acciones de panelBienvenida
         */
        buttonComenzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBienvenida.setVisible(false);
                panelDatos.setVisible(true);
            }
        });

        /**
         * Acciones de panelDatos
         */
        buttonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        buttonAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * Registrar los valores de los Campos de texto en su respectiva variable
                 */
                numeroCaso = textFieldNumeroCaso.getText();
                numeroEnsayo = textFieldNumeroEnsayo.getText();
                apellidos = textFieldApellidos.getText();
                nombres = textFieldNombres.getText();
                aplicador = textFieldAplicador.getText();
                /**
                 * Asignar los valores almacenados en las variables a las etiquetas correspondientes en panelConfirmacion
                 */
                labelConfirmaNumeroCaso.setText("Número de Caso: "+ numeroCaso);
                labelConfirmaNumeroEnsayo.setText("Número de Ensayo: "+ numeroEnsayo);
                labelConfirmaApellidos.setText("Apellidos del Participante: " + apellidos);
                labelConfirmaNombres.setText("Nombres del Participante: "+ nombres);
                labelConfirmaAplicador.setText("Aplicador: "+ aplicador);

                /**
                 * Cerrar este pannel y mostrar el de confirmacion
                 */
                panelDatos.setVisible(false);
                panelConfirmacion.setVisible(true);
            }
        });

        /**
         * Acciones panelConfirmacion
         */
        buttonCorregir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelConfirmacion.setVisible(false);
                panelDatos.setVisible(true);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
