package app.gui;

import app.controlador.ControladorCalculadora;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class GuiCalculadora extends JFrame {
    private JTextField pantalla;
    ControladorCalculadora ctrlCalc;

    public GuiCalculadora() {
        ctrlCalc = new ControladorCalculadora(this);
    }

    public void showVentana() {
        setTitle("Calculadora v.1.0");
        setDefaultCloseOperation(GuiCalculadora.EXIT_ON_CLOSE);
        setSize(330, 400);
        JPanel container = new JPanel();
        container.setLayout(new GridBagLayout());
        container.setBackground(new Color(31, 20, 20));

        HashMap<String, JButton> listaObjetosButton = new HashMap<>();
        //FILA 1
        listaObjetosButton.put("10", new GuiBoton("AC", ctrlCalc)); // borra todo(memoria y la pantalla)
        listaObjetosButton.put("11", new GuiBoton("/", ctrlCalc));
        listaObjetosButton.put("12", new GuiBoton("", ctrlCalc));
        //FILA 2
        listaObjetosButton.put("20", new GuiBoton("7", ctrlCalc));
        listaObjetosButton.put("21", new GuiBoton("8", ctrlCalc));
        listaObjetosButton.put("22", new GuiBoton("9", ctrlCalc));
        listaObjetosButton.put("23", new GuiBoton("x", ctrlCalc));
        //FILA 3
        listaObjetosButton.put("30", new GuiBoton("4", ctrlCalc));
        listaObjetosButton.put("31", new GuiBoton("5", ctrlCalc));
        listaObjetosButton.put("32", new GuiBoton("6", ctrlCalc));
        listaObjetosButton.put("33", new GuiBoton("-", ctrlCalc));
        //FILA 4
        listaObjetosButton.put("40", new GuiBoton("1", ctrlCalc));
        listaObjetosButton.put("41", new GuiBoton("2", ctrlCalc));
        listaObjetosButton.put("42", new GuiBoton("3", ctrlCalc));
        listaObjetosButton.put("43", new GuiBoton("+", ctrlCalc));
        //FILA 5
        listaObjetosButton.put("50", new GuiBoton("0", ctrlCalc));
        listaObjetosButton.put("52", new GuiBoton(".", ctrlCalc));
        listaObjetosButton.put("53", new GuiBoton("=", ctrlCalc));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL; // Llenar horizontalmente
        constraints.insets = new Insets(4, 4, 4, 4);
        constraints.ipady = 16;
        constraints.ipadx = 16;

        //Creando la cuadricula de la calculadora.
        for (int fila = 0; fila < 6; fila++) {
            for (int columna = 0; columna < 4; columna++) {
                if (fila == 0) {
                    //Configuracion de la pantalla
                    pantalla = new JTextField();
                    pantalla.setEditable(false);
                    pantalla.setFont(new Font("Arial", -1, 18));
                    pantalla.setHorizontalAlignment(JTextField.RIGHT);
                    constraints.gridx = columna; // Columna
                    constraints.gridy = fila; // Fila
                    constraints.gridwidth = 4; // Ocupa 4 columnas
                    container.add(pantalla, constraints);
                    break;
                } else {
                    if (fila == 1 && columna == 2) {
                        constraints.gridx = columna;
                        constraints.gridy = fila;
                        constraints.gridwidth = 2;
                        container.add(listaObjetosButton.get("" + fila+ "" + columna), constraints);
                        columna = columna + 1;
                    } else {
                        if (fila == 5 && columna == 0) {
                            constraints.gridx = columna;
                            constraints.gridy = fila;
                            constraints.gridwidth = 2;
                            container.add(listaObjetosButton.get("" + fila + "" + columna), constraints);
                            columna = columna + 1;
                        } else {
                            constraints.gridx = columna;
                            constraints.gridy = fila;
                            constraints.gridwidth = 1;
                            container.add(listaObjetosButton.get("" + fila + "" + columna), constraints);
                        }
                    }
                }
            }
        }

        getContentPane().add(container);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void setTextScreen(String txt) {
        this.pantalla.setText(txt);
    }

    public int cleanScreen() {
        this.pantalla.setText(null);
        return 1;
    }
}
