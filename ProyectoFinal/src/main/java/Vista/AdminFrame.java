package Vista;


import javax.swing.*;

import Utilidades.FuncionesAdmin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//VENTANA PARA INICIAR SESION COMO ADMIN
public class AdminFrame extends JFrame {
    private JTextField correoField;
    private JPasswordField contrasenaField;

    public AdminFrame() {
        setTitle("Iniciar sesión como Admin");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("Correo:");
        label.setBounds(10, 18, 142, 25);
        panel.add(label);
        correoField = new JTextField();
        correoField.setBounds(162, 18, 100, 25);
        panel.add(correoField);

        JLabel label_1 = new JLabel("Contraseña:");
        label_1.setBounds(10, 54, 142, 25);
        panel.add(label_1);
        contrasenaField = new JPasswordField();
        contrasenaField.setBounds(162, 54, 100, 25);
        panel.add(contrasenaField);

        JButton iniciarSesionButton = new JButton("Iniciar sesión");
        iniciarSesionButton.setBounds(174, 118, 100, 32);
        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean accesoPermitido = FuncionesAdmin.verificarAdmin(correoField.getText(), new String(contrasenaField.getPassword()));
                if (accesoPermitido) {
                    new EventoAdminFrame().setVisible(true);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Las credenciales que intenta ingresar son incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(iniciarSesionButton);

        getContentPane().add(panel);
        
        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		new LoginFrame();
        	}
        });
        btnVolver.setBounds(10, 118, 100, 32);
        panel.add(btnVolver);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("src\\\\main\\\\java\\\\Recursos\\\\Wallpaper.jpg"));
        lblNewLabel.setBounds(0, 0, 284, 161);
        panel.add(lblNewLabel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AdminFrame();
    }
}
