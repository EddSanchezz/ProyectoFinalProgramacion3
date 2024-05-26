package Vista;

import javax.swing.*;

import Excepciones.UsuarioRegistradoException;
import Utilidades.FuncionesUsuario;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RegistroFrame extends JFrame {
    private JTextField nombreField;
    private JTextField correoField;
    private JPasswordField contrasenaField;

    public RegistroFrame() {
        setTitle("Registro");
        setSize(461, 340);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("Nombre de usuario:");
        label.setForeground(new Color(255, 255, 255));
        label.setBounds(39, 47, 149, 28);
        panel.add(label);
        nombreField = new JTextField();
        nombreField.setBounds(198, 47, 166, 28);
        panel.add(nombreField);

        JLabel label_1 = new JLabel("Correo:");
        label_1.setForeground(new Color(255, 255, 255));
        label_1.setBounds(39, 98, 103, 28);
        panel.add(label_1);
        correoField = new JTextField();
        correoField.setBounds(198, 98, 166, 28);
        panel.add(correoField);

        JLabel label_2 = new JLabel("Contraseña:");
        label_2.setForeground(new Color(255, 255, 255));
        label_2.setBounds(39, 153, 103, 28);
        panel.add(label_2);
        contrasenaField = new JPasswordField();
        contrasenaField.setBounds(198, 153, 166, 28);
        panel.add(contrasenaField);

        JButton registrarButton = new JButton("Registrar");
        registrarButton.setBounds(318, 250, 103, 28);
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean registroExitoso;
				try {
					registroExitoso = FuncionesUsuario.registrarUsuario(nombreField.getText(), correoField.getText(), new String(contrasenaField.getPassword()));
					if (registroExitoso) {
	                    JOptionPane.showMessageDialog(null, "El usuario ha sido creado exitosamente", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
	                } else {
	                    JOptionPane.showMessageDialog(null, "No se pudo crear el usuario", "Error", JOptionPane.ERROR_MESSAGE);
	                }
				} catch (UsuarioRegistradoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
            }
        });
        panel.add(registrarButton);

        JButton cancelarButton = new JButton("Cancelar");
        cancelarButton.setBounds(28, 250, 103, 28);
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cierra la ventana actual
                dispose();
                // Muestra la ventana LoginFrame
                new LoginFrame().setVisible(true);
            }
        });
        panel.add(cancelarButton);

        getContentPane().add(panel);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("src\\\\main\\\\java\\\\Recursos\\\\Wallpaper.jpg"));
        lblNewLabel.setBounds(0, 0, 445, 301);
        panel.add(lblNewLabel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new RegistroFrame();
    }
}

