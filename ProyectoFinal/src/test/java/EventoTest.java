import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Excepciones.EventoRegistradoException;
import Modelo.Evento;
import Utilidades.FuncionesEvento;

public class EventoTest {

    @Test
    public void registrarEvento() throws EventoRegistradoException, IOException{
        ArrayList<String> artistas = new ArrayList<>();
        artistas.add("jorge seledon");
        artistas.add("michael jackson");
        Evento evento = new Evento(true, "NCS", LocalDate.of(2018,6,12), "New York", artistas, 10.0, 20.0, 80.0, 300);
        
        
        assertThrows(
            EventoRegistradoException.class,
            () -> FuncionesEvento.registrarEvento(evento)
        );
    }
    
    @Test
    public void ConvertirEventoToString() throws IOException, EventoRegistradoException{
        ArrayList<String> artistas = new ArrayList<>();
        artistas.add("jorge seledon");
        artistas.add("michael jackson");
        
        ArrayList<ArrayList<String>> eventos = FuncionesEvento.CatalogoEventos();

        assertEquals("nombre del evento: NCS", eventos.get(0).get(0));

    }
}
