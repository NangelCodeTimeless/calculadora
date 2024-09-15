package Calculadora.gui;

import Calculadora.controlador.ControladorCalculadora;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class GuiBoton extends JButton {
    public GuiBoton(String text, ControladorCalculadora obj) {
        setActionCommand(text);
        setText(text);
        addActionListener(obj);
        setFont(new Font("Arial", Font.BOLD, 16));
        setBackground(new Color(210, 180, 222));
        setFocusPainted(false);
        setBorderPainted(false);

        if(text.equalsIgnoreCase("")){
            setActionCommand("B");
            ClassLoader load = Thread.currentThread().getContextClassLoader();
            setIcon(new ImageIcon(Objects.requireNonNull(load.getResource("delete.png"))));
            setBorderPainted(false);
            setFocusPainted(false);
        }
    }
}
