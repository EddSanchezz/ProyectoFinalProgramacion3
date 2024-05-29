package Vista;

import javax.swing.*;

import Modelo.Evento;
import Utilidades.FuncionesEvento;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class ListaDeEventosFrame extends JFrame {
    private JComboBox<String> comboBox;

    public ListaDeEventosFrame(String loc) {
        comboBox = new JComboBox<String>();

    	ArrayList<Evento> eventos;
		try {
            System.out.println(FuncionesEvento.getEventosPorLocacion(FuncionesEvento.buscarLocacionPorNombre(loc)));

			eventos = FuncionesEvento.getEventosPorLocacion(FuncionesEvento.buscarLocacionPorNombre(loc));
			// Añadir las ubicaciones de los eventos al JComboBox
	        for (Evento evento : eventos) {
	            comboBox.addItem(evento.getNombre());
	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // Crear el JComboBox
        // comboBox = new JComboBox<>();

        

        // Configurar el JComboBox
        comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        comboBox.setPreferredSize(new Dimension(200, 30));

        // Crear un panel para añadir un borde alrededor del JComboBox
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.add(comboBox);

        // Añadir el panel al JFrame
        this.add(panel);

        // Configurar el JFrame
        this.setTitle("Lista de Eventos");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.pack();
        this.setVisible(true);
    }
}
