package Utilidades;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

import Excepciones.EventoRegistradoException;
import Modelo.Evento;
import Modelo.Locacion;
import Persistencia.Repositorio;
import javax.swing.JOptionPane;

public class FuncionesEvento {

<<<<<<< HEAD
    /**
     * metodo encargado de registrar un evento
     */
    public static boolean registrarEvento(boolean disponible, String nombre, LocalDate fecha, String lugar, ArrayList<String> artistas,
            int precioBoletaBronce, int precioBoletaPlata, int precioBoletaOro, int cantAsientos, Locacion locacion) throws IOException {
=======
    // Constructor privado para prevenir la instanciación
    private FuncionesEvento() {}

    // Método encargado de registrar un evento
    public static void registrarEvento(boolean disponible, String nombre, LocalDate fecha, String lugar, ArrayList<String> artistas,
                                       int precioBoletaBronce, int precioBoletaPlata, int precioBoletaOro, int cantAsientos, Locacion locacion) throws IOException {
>>>>>>> 6f314437fa87f4c86bb8d71090fda19edfd1608e
        Evento evento = new Evento(disponible, nombre, fecha, lugar, artistas, precioBoletaBronce, precioBoletaPlata, precioBoletaOro, cantAsientos, locacion);
        Repositorio<Evento> repo = Evento.repositorio();

        boolean eventoExistente = repo.todos().stream()
                .anyMatch(u -> u.getNombre().equals(evento.getNombre()));

        FuncionesBoleta.crearDirectorio(nombre);

        if (eventoExistente) {
            JOptionPane.showMessageDialog(null, "El evento ya existe");
            return;
        }

        evento.setId(null); // Identificador en nulo para crear un nuevo recurso
        repo.escribir(evento); // Crear el recurso
        JOptionPane.showMessageDialog(null, "El evento fue creado exitosamente");
    }

    // Este método se encarga de devolver una lista de los eventos guardados
    public static ArrayList<Evento> catalogoEventos() throws IOException {
        Repositorio<Evento> repo = Evento.repositorio();
        return new ArrayList<>(repo.todos());
    }

    // Método para registrar una locación
    public static boolean registrarLocacion(String nombre, int capacidadDeAsientos) throws IOException {
        Locacion locacion = new Locacion(nombre, capacidadDeAsientos);
        Repositorio<Locacion> repo = Locacion.repositorio();

        boolean locacionExistente = repo.todos().stream()
                .anyMatch(u -> u.getNombre().equals(locacion.getNombre()));

        if (locacionExistente) {
            return false;
        }

        locacion.setId(null);
        repo.escribir(locacion);
        return true;
    }

    // Busca todas las locaciones
    public static ArrayList<Locacion> catalogoLocaciones() throws IOException {
        Repositorio<Locacion> repo = Locacion.repositorio();
<<<<<<< HEAD
        ArrayList<Locacion> locaciones = (ArrayList<Locacion>) repo.todos();
        return locaciones;
    }
    
    public static Locacion buscarLocacionPorNombre(String nombre)throws IOException {
        for (Locacion locacion : CatalogoLocaciones()) {
            if (locacion.getNombre().equals(nombre)) {
                return locacion;
            }
        }
        return null;
    }

	public static ArrayList<Evento> getEventosPorLocacion(Locacion locacionSeleccionada) throws IOException {
		Repositorio<Evento> repo = Evento.repositorio();
        ArrayList<Evento> eventos = (ArrayList<Evento>) repo.todos();
        ArrayList<Evento> eventosLocacion = new ArrayList<>();
        
        for(Evento u: eventos) {
        	if(u.getLocacion().equals(locacionSeleccionada.getNombre())) {
        		eventosLocacion.add(u);
        	}
=======
        return new ArrayList<>(repo.todos());
    }

    // Busca una locación por nombre
    public static Locacion buscarLocacionPorNombre(String nombre) throws IOException {
        return catalogoLocaciones().stream()
                .filter(locacion -> locacion.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);
    }

    // Obtiene una lista de eventos según la locación que se ingrese
    public static ArrayList<Evento> getEventosPorLocacion(Locacion locacionSeleccionada) throws IOException {
        Repositorio<Evento> repo = Evento.repositorio();
        return repo.todos().stream()
                .filter(evento -> evento.getLocacion().equals(locacionSeleccionada.getNombre()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    // Busca una lista de eventos según el nombre de la locación que se ingrese
    public static ArrayList<Evento> getEventosPorLocacion(String nombreLocacion) throws IOException {
        Repositorio<Evento> repo = Evento.repositorio();
        return repo.todos().stream()
                .filter(evento -> evento.getLocacion().equals(nombreLocacion))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    // Método para eliminar un evento por su nombre
    public static boolean eliminarEventoPorNombre(String nombreEvento) throws IOException {
        Repositorio<Evento> repo = Evento.repositorio();
        Optional<Evento> eventoAEliminar = repo.todos().stream()
                .filter(evento -> evento.getNombre().equals(nombreEvento))
                .findFirst();

        if (eventoAEliminar.isPresent()) {
            repo.eliminar(eventoAEliminar.get().getId());
            JOptionPane.showMessageDialog(null, "El evento fue eliminado exitosamente");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "El evento no se encontró");
            return false;
>>>>>>> 6f314437fa87f4c86bb8d71090fda19edfd1608e
        }
    }

    // Método para eliminar una locación por su nombre
    public static boolean eliminarLocacionPorNombre(String nombreLocacion) throws IOException {
        Repositorio<Locacion> repo = Locacion.repositorio();
        Optional<Locacion> locacionAEliminar = repo.todos().stream()
                .filter(locacion -> locacion.getNombre().equals(nombreLocacion))
                .findFirst();

        if (locacionAEliminar.isPresent()) {
            repo.eliminar(locacionAEliminar.get().getId());
            JOptionPane.showMessageDialog(null, "La locación fue eliminada exitosamente");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "La locación no se encontró");
            return false;
        }
    }
}
