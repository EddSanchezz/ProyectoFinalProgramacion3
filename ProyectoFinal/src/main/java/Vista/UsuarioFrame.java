package Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Utilidades.FuncionesUsuario;
import java.awt.Color;

//VENTANA PARA INICIAR SESION COMO USUARIO
@SuppressWarnings("serial")
public class UsuarioFrame extends JFrame {
    private JTextField correoField;
    private JPasswordField contrasenaField;

    public UsuarioFrame() {
        setTitle("Iniciar sesión");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        JButton btnRegresar = new JButton("Volver");
        btnRegresar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		new LoginFrame();
        	}
        });
        btnRegresar.setBounds(10, 222, 117, 28);
        panel.add(btnRegresar);

        JLabel label = new JLabel("Correo:");
        label.setForeground(new Color(255, 255, 255));
        label.setBounds(64, 54, 86, 33);
        panel.add(label);
        correoField = new JTextField();
        correoField.setBounds(160, 54, 141, 33);
        panel.add(correoField);

        JLabel label_1 = new JLabel("Contraseña:");
        label_1.setForeground(new Color(255, 255, 255));
        label_1.setBounds(64, 120, 86, 33);
        panel.add(label_1);
        contrasenaField = new JPasswordField();
        contrasenaField.setBounds(160, 120, 141, 33);
        panel.add(contrasenaField);

        JButton iniciarSesionButton = new JButton("Iniciar sesión");
        iniciarSesionButton.setBounds(257, 217, 117, 33);
        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean accesoPermitido = FuncionesUsuario.verificarUsuario(correoField.getText(), new String(contrasenaField.getPassword()));
                if (accesoPermitido) {
                    new ListaDeEventosFrame().setVisible(true);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Las credenciales que intenta ingresar son incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(iniciarSesionButton);

        getContentPane().add(panel);
        
        JLabel lblIngresaPorfis = new JLabel("Por favor, ingresa tus datos");
        lblIngresaPorfis.setBounds(126, 11, 162, 14);
        panel.add(lblIngresaPorfis);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("src\\\\main\\\\java\\\\Recursos\\\\Wallpaper.jpg"));
        lblNewLabel.setBounds(0, 0, 384, 261);
        panel.add(lblNewLabel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new UsuarioFrame();
    }
}

