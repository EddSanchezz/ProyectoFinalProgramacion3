package Vista;

import javax.swing.*;

import Utilidades.FuncionesApertura;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class ConfigAperturaFrame extends JFrame {
    private JTextField horaTextField;
    private JButton configurarButton;
    private JButton volverButton;

    public ConfigAperturaFrame() {
        setTitle("Configurar Hora de Apertura");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel horaLabel = new JLabel("Hora de Apertura (HH:mm):");
        horaLabel.setBounds(10, 20, 200, 25);
        add(horaLabel);

        horaTextField = new JTextField();
        horaTextField.setBounds(180, 20, 100, 25);
        add(horaTextField);

        configurarButton = new JButton("Configurar");
        configurarButton.setBounds(80, 60, 140, 25);
        configurarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FuncionesApertura.configurarHora(horaTextField.getText());
            }
        });
        add(configurarButton);

        volverButton = new JButton("Volver");
        volverButton.setBounds(80, 100, 140, 25);
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(volverButton);

        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        ConfigAperturaFrame frame = new ConfigAperturaFrame();
        frame.setVisible(true);
    }
}
