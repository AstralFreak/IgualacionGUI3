package mx.unam.psicologia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
     * Elementos panelReady
     */
    private JPanel panelReady;

    private JLabel labelReady;
    /**
     * Elementos panelPregunta1
     */
    private JPanel panelPregunta1;
    private JLabel labelP1R42;
    private JLabel labelP1R32;
    /**
     * Elementos panelPregunta2
     */
    private JPanel panelPregunta2;
    private JLabel labelP2R32;
    private JLabel labelP2R22;
    /**
     * Elementos panelPregunta3
     */
    private JPanel panelPregunta3;
    private JLabel labelP3R1000;
    private JLabel labelP3R0001;
    /**
     * Elementos panelWait
     */
    private JPanel panelWait;
    private JButton buttonMostrarReporte;
    private JPanel panelReporte;
    private JPanel panelResultadosCuantitativos;
    private JButton button1;
    private JLabel labelReporteParticipante;
    private JLabel labelReporteNumeroCaso;
    private JLabel labelReporteNumeroEnsayo;
    private JLabel labelReporteFecha;
    private JLabel labelReporteAplicador;
    private JLabel labelReporteRespuesta1;
    private JLabel labelReporteRespuesta2;
    private JLabel labelReporteRespuesta3;
    private JLabel labelReporteCalificacion1;
    private JLabel labelReporteCalificacion2;
    private JLabel labelReporteCalificacion3;
    private JLabel labelReporteTimer1;
    private JLabel labelReporteTimer2;
    private JLabel LabelReporteTimer3;

    /**
     *
     * Variables Publicas
     */

    String numeroCaso;
    String numeroEnsayo;
    String apellidos;
    String nombres;
    String aplicador;
    int r1;
    int r2;
    int r3;
    int verdad1;
    int verdad2;
    int verdad3;

    /**
     * Obtener la resolucion del dispositivo
     */
    static GraphicsDevice device = GraphicsEnvironment
            .getLocalGraphicsEnvironment().getScreenDevices()[0];

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
        buttonContinuarAEnsayo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelConfirmacion.setVisible(false);
                device.setFullScreenWindow(null);
                panelReady.setVisible(true);

                /**
                 * Get Date
                 */

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                LocalDate localDate = LocalDate.now();

                /**
                 * Set Final cualitative values in report labels
                 */

                labelReporteParticipante.setText(apellidos + " " + nombres);
                labelReporteNumeroCaso.setText(numeroCaso);
                labelReporteNumeroEnsayo.setText(numeroEnsayo);
                labelReporteAplicador.setText(aplicador);
                labelReporteFecha.setText(String.valueOf(localDate));

            }
        });

        /**
         * Acciones panelReady
         */

        labelReady.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelReady.setVisible(false);
                panelPregunta1.setVisible(true);
                super.mouseClicked(e);
            }
        });

        /**
         * Acciones panelPregunta1
         */
        labelP1R42.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                r1 = 42;
                verdad1 = 1;
                labelReporteRespuesta1.setText(String.valueOf(r1));
                labelReporteCalificacion1.setText("Correcta");
                panelPregunta1.setVisible(false);
                panelPregunta2.setVisible(true);
                super.mousePressed(e);
            }
        });
        labelP1R32.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                r1 = 32;
                verdad1 = 0;
                labelReporteRespuesta1.setText(String.valueOf(r1));
                labelReporteCalificacion1.setText("Incorrecta");
                panelPregunta1.setVisible(false);
                panelPregunta2.setVisible(true);
                super.mousePressed(e);
            }
        });

        /**
         * Acciones panelPregunta2
         */
        labelP2R32.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                r2 = 32;
                verdad2 = 1;
                labelReporteRespuesta2.setText(String.valueOf(r2));
                labelReporteCalificacion2.setText("Correcta");
                panelPregunta2.setVisible(false);
                panelPregunta3.setVisible(true);
                super.mousePressed(e);
            }
        });
        labelP2R22.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                r2 = 22;
                verdad2 = 0;
                labelReporteRespuesta2.setText(String.valueOf(r2));
                labelReporteCalificacion2.setText("Incorrecta");
                panelPregunta2.setVisible(false);
                panelPregunta3.setVisible(true);
                super.mousePressed(e);
            }
        });

        /**
         * Acciones panelPregunta3
         */

        labelP3R1000.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                r3 = 1000;
                verdad3 = 1;
                labelReporteRespuesta3.setText(String.valueOf(r3));
                labelReporteCalificacion3.setText("Correcta");
                panelPregunta3.setVisible(false);
                panelWait.setVisible(true);
                super.mousePressed(e);
            }
        });
        labelP3R0001.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                r3 = 0001;
                verdad3 = 0;
                labelReporteRespuesta3.setText(String.valueOf(r3));
                labelReporteCalificacion3.setText("Incorrecta");
                panelPregunta3.setVisible(false);
                panelWait.setVisible(true);
                super.mousePressed(e);
            }
        });
        /**
         * Acciones PanelWait
         */
        buttonMostrarReporte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelWait.setVisible(false);
                panelReporte.setVisible(true);
            }
        });

        /**
         * Acciones panelReporte
         */
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
