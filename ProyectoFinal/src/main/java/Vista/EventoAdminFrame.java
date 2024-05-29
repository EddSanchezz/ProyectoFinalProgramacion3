package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//VENTANA PARA ADMINISTRAR EVENTOS COMO ADMIN


@SuppressWarnings("serial")
public class EventoAdminFrame extends JFrame {
    public EventoAdminFrame() {
        setTitle("Administrar Evento");
        setSize(474, 343);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JButton configurarHoraButton = new JButton("Configurar Hora de Apertura");
        configurarHoraButton.setBounds(199, 261, 238, 32);
        configurarHoraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConfigAperturaFrame().setVisible(true);
            }
        });
        panel.add(configurarHoraButton);

        JButton volverButton = new JButton("Volver");
        volverButton.setBounds(10, 261, 97, 32);
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cierra la ventana actual
                dispose();
                // Muestra la ventana AdminFrame
                new AdminFrame().setVisible(true);
            }
        });
        panel.add(volverButton);

        getContentPane().add(panel);
        
                JButton agregarLocacionButton = new JButton("Agregar Locacion");
                agregarLocacionButton.setBounds(150, 168, 149, 32);
                panel.add(agregarLocacionButton);
                
                        JButton agregarEventoButton = new JButton("Agregar Evento");
                        agregarEventoButton.setBounds(150, 110, 149, 32);
                        panel.add(agregarEventoButton);
                        
                        JLabel lblNewLabel = new JLabel("");
                        lblNewLabel.setIcon(new ImageIcon("src\\main\\java\\Recursos\\Wallpaper.jpg"));
                        lblNewLabel.setBounds(0, 0, 458, 304);
                        panel.add(lblNewLabel);
                        agregarEventoButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try {
                                	dispose();
									new SetEventoFrame().setVisible(true);
								} catch (IOException e1) {
									e1.printStackTrace();
								}
                            }
                        });
                agregarLocacionButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	dispose();
                        new SetLocacionFrame().setVisible(true);
                    }
                });
        setVisible(true);
    }

    public static void main(String[] args) {
        new EventoAdminFrame();
    }
}

