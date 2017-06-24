package mx.unam.psicologia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by pablo on 18/06/17.
 */
public class IgualacionGUI {
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
    private JButton buttonFinalizar;
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
    private JLabel labelReporteTimer3;

    /**
     *
     * Variables Publicas
     */

    String numeroCaso;
    String numeroEnsayo;
    String apellidos;
    String nombres;
    String aplicador;
    String r1;
    String r2;
    String r3;
    int verdad1;
    int verdad2;
    int verdad3;
    String fecha;

    //TIMERSFINALES
    double timer1, timer2, timer3;
    //START TIMES
    double startTime1, startTime2,startTime3;
    //END TIMES
    double endTime1, endTime2, endTime3;
    //TIMERS NANOSECONDS






    /**
     *
     * Main Method
     */

    public static void main(String[] args) {
        JFrame frame = new JFrame("Igualación a la Muestra");
        frame.setContentPane(new IgualacionGUI().applicationWindow);
        frame.setDefaultCloseOperation(3);
        /*frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.isUndecorated();*/
        frame.pack();
        frame.setVisible(true);

    }

    public IgualacionGUI() {

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
                labelConfirmaNumeroCaso.setText(numeroCaso);
                labelConfirmaNumeroEnsayo.setText(numeroEnsayo);
                labelConfirmaApellidos.setText(apellidos);
                labelConfirmaNombres.setText(nombres);
                labelConfirmaAplicador.setText(aplicador);

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
                panelReady.setVisible(true);



                /**
                 * Get Date
                 */

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                LocalDate localDate = LocalDate.now();
                fecha = String.valueOf(localDate);

                /**
                 * Set Final qualitative values in report labels
                 */

                labelReporteParticipante.setText(apellidos + ", " + nombres);
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
            public void mousePressed(MouseEvent e) {
                panelReady.setVisible(false);
                panelPregunta1.setVisible(true);


                startTime1 = System.nanoTime();
                super.mousePressed(e);
            }
        });

        /**
         * Acciones panelPregunta1
         */
        labelP1R42.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                endTime1 = System.nanoTime();
                timer1 = (endTime1 - startTime1) / 1000000000.0;
                labelReporteTimer1.setText(String.valueOf(timer1) + " Segundos");
                r1 = "42";
                verdad1 = 1;
                labelReporteRespuesta1.setText(String.valueOf(r1));
                labelReporteCalificacion1.setForeground(Color.green);
                labelReporteCalificacion1.setText("Correcta");
                panelPregunta1.setVisible(false);
                panelPregunta2.setVisible(true);
                startTime2 = System.nanoTime();
                super.mousePressed(e);
            }
        });
        labelP1R32.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                endTime1 = System.nanoTime();
                timer1 = (endTime1 - startTime1) / 1000000000.0;
                labelReporteTimer1.setText(String.valueOf(timer1) + " Segundos");
                r1 = "32";
                verdad1 = 0;
                labelReporteRespuesta1.setText(String.valueOf(r1));
                labelReporteCalificacion1.setForeground(Color.red);
                labelReporteCalificacion1.setText("Incorrecta");
                panelPregunta1.setVisible(false);
                panelPregunta2.setVisible(true);
                startTime2 = System.nanoTime();
                super.mousePressed(e);
            }
        });

        /**
         * Acciones panelPregunta2
         */
        labelP2R32.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                endTime2 = System.nanoTime();
                timer2 = (endTime2 - startTime2) / 1000000000.0;
                labelReporteTimer2.setText(String.valueOf(timer2) + " Segundos");
                r2 = "32";
                verdad2 = 1;
                labelReporteRespuesta2.setText(String.valueOf(r2));
                labelReporteCalificacion2.setForeground(Color.green);
                labelReporteCalificacion2.setText("Correcta");
                panelPregunta2.setVisible(false);
                panelPregunta3.setVisible(true);
                startTime3 = System.nanoTime();
                super.mousePressed(e);
            }
        });
        labelP2R22.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                endTime2 = System.nanoTime();
                timer2 = (endTime2 - startTime2) / 1000000000.0;
                labelReporteTimer2.setText(String.valueOf(timer2) + " Segundos");
                r2 = "22";
                verdad2 = 0;
                labelReporteRespuesta2.setText(String.valueOf(r2));
                labelReporteCalificacion2.setForeground(Color.red);
                labelReporteCalificacion2.setText("Incorrecta");
                panelPregunta2.setVisible(false);
                panelPregunta3.setVisible(true);
                startTime3 = System.nanoTime();
                super.mousePressed(e);
            }
        });

        /**
         * Acciones panelPregunta3
         */

        labelP3R1000.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                endTime3 = System.nanoTime();
                timer3 = (endTime3 - startTime3) / 1000000000.0;
                labelReporteTimer3.setText(String.valueOf(timer3) + " Segundos");
                r3 = "1000";
                verdad3 = 1;
                labelReporteRespuesta3.setText(String.valueOf(r3));
                labelReporteCalificacion3.setForeground(Color.green);
                labelReporteCalificacion3.setText("Correcta");
                panelPregunta3.setVisible(false);
                panelWait.setVisible(true);
                super.mousePressed(e);
            }
        });
        labelP3R0001.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                endTime3 = System.nanoTime();
                timer3 = (endTime3 - startTime3) / 1000000000.0;
                labelReporteTimer3.setText(String.valueOf(timer3) + " Segundos");
                r3 = "0001";
                verdad3 = 0;
                labelReporteRespuesta3.setText(String.valueOf(r3));
                labelReporteCalificacion3.setForeground(Color.red);
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

                /**
                 * Registro CSV
                 */


                String stringCaso  = numeroCaso;
                String stringEnsayo = numeroEnsayo;
                String fileName = stringCaso + "-" + stringEnsayo + ".csv";



                //Delimiter used in CSV file
                String COMMA_DELIMITER = ",";
                String NEW_LINE_SEPARATOR = "\n";

                //CSV file header
                String FILE_HEADER = "Fecha,Caso,NumeroEnsayo,ApellidosSujeto,NombresSujeto," +
                        "NumeroAplicador,Respuesta1,Calificación1,Tiempo1,Respuesta2,Calificación2,Tiempo2,Respuesta3,Calificación3," +
                        "Tiempo3";


                FileWriter fileWriter = null;

                try {
                    fileWriter = new FileWriter(fileName);



                    fileWriter = new FileWriter(fileName);

                    fileWriter.append(FILE_HEADER);
                    fileWriter.append(NEW_LINE_SEPARATOR);
                    fileWriter.append(String.valueOf(fecha));
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(String.valueOf(numeroCaso));
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(String.valueOf(numeroEnsayo));
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(String.valueOf(apellidos));
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(String.valueOf(nombres));
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(String.valueOf(aplicador));
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(String.valueOf(r1));
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(String.valueOf(verdad1));
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(String.valueOf(timer1));
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(String.valueOf(r2));
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(String.valueOf(verdad2));
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(String.valueOf(timer2));
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(String.valueOf(r3));
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(String.valueOf(verdad3));
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(String.valueOf(timer3));
                }

                catch (Exception er) {
                    er.printStackTrace();
                }finally {
                    try {
                        fileWriter.flush();
                        fileWriter.close();
                    }
                    catch (IOException er){
                        er.printStackTrace();
                    }

                }
            }
        });

        /**
         * Acciones panelReporte
         */
        buttonFinalizar.addActionListener(new ActionListener() {
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
