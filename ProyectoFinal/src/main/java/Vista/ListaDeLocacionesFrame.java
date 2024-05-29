package Vista;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Locacion;
import Utilidades.FuncionesEvento;

public class ListaDeLocacionesFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> comboBox;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ListaDeLocacionesFrame frame = new ListaDeLocacionesFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ListaDeLocacionesFrame() throws IOException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        ArrayList<Locacion> locaciones;
        locaciones = FuncionesEvento.catalogoLocaciones();
        comboBox = new JComboBox<>();
        for (Locacion u : locaciones) {
            comboBox.addItem(u.getNombre());
        }
        comboBox.setBounds(23, 30, 188, 22);
        contentPane.add(comboBox);

        JButton btnNewButton = new JButton("Ingresar a Locación");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String loc = (String) comboBox.getSelectedItem();
                if (loc!= null) {
                    new ListaDeEventosFrame(loc).setVisible(true);
                }
            }
        });
        btnNewButton.setBounds(318, 215, 106, 35);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Volver");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new UsuarioFrame().setVisible(true);
            }
        });
        btnNewButton_1.setBounds(10, 215, 106, 35);
        contentPane.add(btnNewButton_1);
    }
}