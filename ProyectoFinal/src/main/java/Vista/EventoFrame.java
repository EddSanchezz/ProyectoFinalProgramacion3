package Vista;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import Modelo.Evento;

@SuppressWarnings("serial")
public class EventoFrame extends JFrame {
    private final Evento evento;

    public EventoFrame(Evento evento) {
        this.evento = evento;

        setTitle(evento.getNombre());
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));

        panel.add(new JLabel("Nombre:"));
        panel.add(new JLabel(evento.getNombre()));

        panel.add(new JLabel("Fecha:"));
        panel.add(new JLabel(evento.getFecha().toString())); // Convertir LocalDate a String

        panel.add(new JLabel("Lugar:"));
        panel.add(new JLabel(evento.getLugar()));

        panel.add(new JLabel("Artistas:"));
        String artistas = String.join(", ", evento.getArtistas()); // Unir artistas con coma y espacio
        panel.add(new JLabel(artistas));

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


}
