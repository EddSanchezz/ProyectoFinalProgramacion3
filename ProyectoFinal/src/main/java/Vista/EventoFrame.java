package Vista;

import javax.swing.*;
import java.awt.*;
import Modelo.Evento;

@SuppressWarnings("serial")
public class EventoFrame extends JFrame {
    @SuppressWarnings("unused")
	private Evento evento;

    public EventoFrame(Evento evento) {
        this.evento = evento;

        setTitle("Detalles del Evento");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 2));

        panel.add(new JLabel("Disponible:"));
        panel.add(new JLabel(String.valueOf(evento.isDisponible())));

        panel.add(new JLabel("Nombre:"));
        panel.add(new JLabel(evento.getNombre()));

        panel.add(new JLabel("Fecha:"));
        panel.add(new JLabel(evento.getFecha()));

        panel.add(new JLabel("Lugar:"));
        panel.add(new JLabel(evento.getLugar()));

        panel.add(new JLabel("Artistas:"));
        panel.add(new JLabel(evento.getArtistas().toString()));

        panel.add(new JLabel("Precio Boleta Bronce:"));
        panel.add(new JLabel(String.valueOf(evento.getPrecioBoletaBronce())));

        panel.add(new JLabel("Precio Boleta Plata:"));
        panel.add(new JLabel(String.valueOf(evento.getPrecioBoletaPlata())));

        panel.add(new JLabel("Precio Boleta Oro:"));
        panel.add(new JLabel(String.valueOf(evento.getPrecioBoletaOro())));

        panel.add(new JLabel("Cantidad de Asientos:"));
        panel.add(new JLabel(String.valueOf(evento.getCantAsientos())));

        getContentPane().add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Para probar la ventana, puedes crear un evento de prueba y pasarlo al constructor
        // new EventoFrame(eventoDePrueba);
    }
}
