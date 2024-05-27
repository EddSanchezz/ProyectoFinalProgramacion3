package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Utilidades.FuncionesEvento;

@SuppressWarnings("serial")
public class SetLocacionFrame extends JFrame {
    private JTextField nombreField;
    private JTextField capacidadField;

    public SetLocacionFrame() {
        setTitle("Crear Locación");
        setSize(461, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("Nombre de la locación:");
        label.setForeground(new Color(255, 255, 255));
        label.setBounds(47, 70, 154, 26);
        panel.add(label);
        nombreField = new JTextField();
        nombreField.setBounds(211, 70, 178, 26);
        panel.add(nombreField);

        JLabel label_1 = new JLabel("Capacidad de asientos:");
        label_1.setForeground(new Color(255, 255, 255));
        label_1.setBounds(47, 103, 154, 26);
        panel.add(label_1);
        capacidadField = new JTextField();
        capacidadField.setBounds(211, 103, 178, 26);
        panel.add(capacidadField);

        JButton crearLocacionButton = new JButton("Crear Locación");
        crearLocacionButton.setBounds(281, 236, 154, 34);
        crearLocacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean locacionCreada;
				try {
					locacionCreada = FuncionesEvento.registrarLocacion(nombreField.getText(), Integer.parseInt(capacidadField.getText()));
					if (locacionCreada) {
	                    JOptionPane.showMessageDialog(null, "La locación se guardó correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	                } else {
	                    JOptionPane.showMessageDialog(null, "La locación ya existe", "Error", JOptionPane.ERROR_MESSAGE);
	                }
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
            }
        });
        panel.add(crearLocacionButton);

        JButton volverButton = new JButton("Volver");
        volverButton.setBounds(10, 236, 110, 34);
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cierra la ventana actual
                dispose();
                // Muestra la ventana EventoAdminFrame
                new EventoAdminFrame().setVisible(true);
            }
        });
        panel.add(volverButton);

        getContentPane().add(panel);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("src\\main\\java\\Recursos\\Wallpaper.jpg"));
        lblNewLabel.setBounds(0, 0, 445, 281);
        panel.add(lblNewLabel);
        setVisible(true);
    }

    public static void main(String[] args)throws IOException {
        new SetEventoFrame();
    }
}

