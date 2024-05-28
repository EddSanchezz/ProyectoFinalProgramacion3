package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import Modelo.Locacion;
import Utilidades.FuncionesEvento;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.KeyAdapter;

@SuppressWarnings("serial")
public class SetEventoFrame extends JFrame {
    private JTextField nombreField;
    private JTextField fechaField;
    private JTextField lugarField;
    private JTextField artistasField;
    private JTextField precioBoletaBronceField;
    private JTextField precioBoletaPlataField;
    private JTextField precioBoletaOroField;
    private JTextField cantAsientosField;
    private JComboBox<String> locacionComboBox;
    private JCheckBox disponibleCheckBox;

    public SetEventoFrame()throws IOException {
        setTitle("Crear Evento");
        setSize(535, 384);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("Disponible:");
        label.setForeground(new Color(255, 255, 255));
        label.setBounds(88, 2, 171, 31);
        panel.add(label);
        disponibleCheckBox = new JCheckBox();
        disponibleCheckBox.setForeground(new Color(0, 0, 255));
        disponibleCheckBox.setBounds(265, 7, 21, 20);
        panel.add(disponibleCheckBox);

        JLabel label_1 = new JLabel("Nombre:");
        label_1.setForeground(new Color(255, 255, 255));
        label_1.setBounds(88, 33, 171, 31);
        panel.add(label_1);
        nombreField = new JTextField();
        nombreField.setBounds(259, 38, 224, 20);
        panel.add(nombreField);

        JLabel label_2 = new JLabel("Fecha (yyyy-mm-dd):");
        label_2.setForeground(new Color(255, 255, 255));
        label_2.setBounds(88, 64, 171, 31);
        panel.add(label_2);
        fechaField = new JTextField();
        fechaField.setBounds(259, 69, 224, 20);
        panel.add(fechaField);

        JLabel label_3 = new JLabel("Lugar:");
        label_3.setForeground(new Color(255, 255, 255));
        label_3.setBounds(88, 95, 171, 31);
        panel.add(label_3);
        lugarField = new JTextField();
        lugarField.setBounds(259, 100, 224, 20);
        panel.add(lugarField);

        JLabel label_4 = new JLabel("Artistas (separados por comas):");
        label_4.setForeground(new Color(255, 255, 255));
        label_4.setBounds(88, 126, 171, 31);
        panel.add(label_4);
        artistasField = new JTextField();
        artistasField.setBounds(259, 131, 224, 20);
        panel.add(artistasField);

        JLabel label_5 = new JLabel("Precio Boleta Bronce:");
        label_5.setForeground(new Color(255, 255, 255));
        label_5.setBounds(88, 157, 171, 31);
        panel.add(label_5);
        precioBoletaBronceField = new JTextField();
        precioBoletaBronceField.setBounds(259, 162, 224, 20);
        panel.add(precioBoletaBronceField);

        JLabel label_6 = new JLabel("Precio Boleta Plata:");
        label_6.setForeground(new Color(255, 255, 255));
        label_6.setBounds(88, 188, 171, 31);
        panel.add(label_6);
        precioBoletaPlataField = new JTextField();
        precioBoletaPlataField.setBounds(259, 193, 224, 20);
        panel.add(precioBoletaPlataField);

        JLabel label_7 = new JLabel("Precio Boleta Oro:");
        label_7.setForeground(new Color(255, 255, 255));
        label_7.setBounds(88, 219, 171, 31);
        panel.add(label_7);
        precioBoletaOroField = new JTextField();
        precioBoletaOroField.setBounds(259, 224, 224, 20);
        panel.add(precioBoletaOroField);

        JLabel label_8 = new JLabel("Cantidad de Asientos:");
        label_8.setForeground(new Color(255, 255, 255));
        label_8.setBounds(88, 281, 171, 31);
        panel.add(label_8);
        cantAsientosField = new JTextField();
        cantAsientosField.addKeyListener(new KeyAdapter() {
        });
        cantAsientosField.setBounds(259, 286, 224, 20);
        panel.add(cantAsientosField);

        JLabel label_9 = new JLabel("Locación:");
        label_9.setForeground(new Color(255, 255, 255));
        label_9.setBounds(88, 250, 171, 31);
        panel.add(label_9);
     // Crea un array con los nombres de las locaciones
        ArrayList<Locacion> locaciones = FuncionesEvento.catalogoLocaciones();
        String[] nombresLocaciones = new String[locaciones.size()];
        for (int i = 0; i < locaciones.size(); i++) {
            nombresLocaciones[i] = locaciones.get(i).getNombre();
        }

        // Usa el array de nombres para el JComboBox
        locacionComboBox = new JComboBox<>(nombresLocaciones);
        locacionComboBox.setBounds(259, 255, 224, 20);
        panel.add(locacionComboBox);

        JButton crearEventoButton = new JButton("Crear Evento");
        crearEventoButton.setBounds(377, 312, 132, 31);
        crearEventoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean disponible = disponibleCheckBox.isSelected();
                String nombre = nombreField.getText();
                LocalDate fecha = LocalDate.parse(fechaField.getText());
                String lugar = lugarField.getText();
                ArrayList<String> artistas = new ArrayList<>(Arrays.asList(artistasField.getText().split(",")));
                int precioBoletaBronce = Integer.parseInt(precioBoletaBronceField.getText());
                int precioBoletaPlata = Integer.parseInt(precioBoletaPlataField.getText());
                int precioBoletaOro = Integer.parseInt(precioBoletaOroField.getText());
                int cantAsientos = Integer.parseInt(cantAsientosField.getText());
			try {
                            Locacion locacion = FuncionesEvento.buscarLocacionPorNombre((String) locacionComboBox.getSelectedItem());
                            FuncionesEvento.registrarEvento(disponible, nombre, fecha, lugar, artistas, precioBoletaBronce, precioBoletaPlata, precioBoletaOro, cantAsientos, locacion);
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (IllegalArgumentException ef) {
				ef.printStackTrace();
			}

            }
        });
        panel.add(crearEventoButton);

        JButton volverButton = new JButton("Volver");
        volverButton.setBounds(10, 312, 132, 31);
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
        lblNewLabel.setBounds(0, 0, 518, 343);
        panel.add(lblNewLabel);
        setVisible(true);
    }

    public static void main(String[] args)throws IOException {
        new SetEventoFrame();
    }
}

