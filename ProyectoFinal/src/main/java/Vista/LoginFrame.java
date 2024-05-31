package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//VENTANA PARA ELEGIR SI INICIAR SESION O REGISTRARSE
@SuppressWarnings("serial")
public class LoginFrame extends JFrame {
    public LoginFrame() {
        setTitle("Bienvenido");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label1 = new JLabel("Bienvenido");
        label1.setBounds(243, 36, 109, 34);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(label1);

        JLabel label2 = new JLabel("Iniciar sesion como:");
        label2.setBounds(243, 124, 124, 20);
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        JButton userButton = new JButton("Usuario");
        userButton.setBounds(195, 155, 80, 25);
        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UsuarioFrame();  // Abre el JFrame UsuarioFrame
                setVisible(false);   // Oculta el LoginFrame
            }
        });
        panel.add(userButton);

        JButton adminButton = new JButton("Admin");
        adminButton.setBounds(315, 155, 80, 25);
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminFrame();  // Abre el JFrame AdminFrame
                setVisible(false); // Oculta el LoginFrame
            }
        });
        panel.add(adminButton);

        JButton registerButton = new JButton("Registrarse como usuario");
        registerButton.setBounds(195, 325, 200, 25);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistroFrame();  // Abre el JFrame RegistroFrame
                setVisible(false);    // Oculta el LoginFrame
            }
        });
        panel.add(registerButton);

        getContentPane().add(panel);
        
        JLabel lblFondo = new JLabel("New label");
        lblFondo.setIcon(new ImageIcon("src\\main\\java\\Recursos\\Wallpaper.jpg"));
        lblFondo.setBounds(0, 0, 584, 361);
        panel.add(lblFondo);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}
