package Utilidades;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import Excepciones.EventoRegistradoException;
import Modelo.Evento;
import Modelo.Locacion;
import Persistencia.Repositorio;

public class FuncionesEvento {
    
    /**
     * previene la instanciacion
     */
    public FuncionesEvento() {}

    /**
     * metodo encargado de registrar un evento
     */
    public static boolean registrarEvento(boolean disponible, String nombre, LocalDate fecha, String lugar, ArrayList<String> artistas,
            int precioBoletaBronce, int precioBoletaPlata, int precioBoletaOro, int cantAsientos, Locacion locacion) throws IOException {
        Evento evento = new Evento(disponible, nombre, fecha, lugar, artistas, precioBoletaBronce, precioBoletaPlata, precioBoletaOro, cantAsientos, locacion);
        Repositorio<Evento> repo = Evento.repositorio();

        for (Evento u : repo.todos()) {
            if (u.getNombre().equals(evento.getNombre())) {
                return false;
            }
        }

        evento.setId(null); // identificador en nulo para crear un nuevo recurso
        repo.escribir(evento); // crear el recurso
        return true;
    }

    /**
     * este metodo se encarga de devolver una lista de los eventos guardados
     * @param ruta
     * @return StringEventos
     * @throws IOException
     */
    public static ArrayList<Evento> CatalogoEventos() throws IOException{
        Repositorio<Evento> repo = Evento.repositorio();
        ArrayList<Evento> eventos = (ArrayList<Evento>) repo.todos();
        return eventos;
    }
    
    /**
     * Metodo para registrar una locacion
     * @param nombre
     * @param capacidadDeAsientos
     * @return
     * @throws IOException
     */
    public static boolean registrarLocacion(String nombre, int capacidadDeAsientos) throws IOException {
    	Locacion locacion = new Locacion(nombre,capacidadDeAsientos);
    	
        Repositorio<Locacion> repo = Locacion.repositorio();

        for (Locacion u: repo.todos()) {
            if (u.getNombre().equals(locacion.getNombre())) {
                return false;
            }
        }
        locacion.setId(null);
        repo.escribir(locacion);
        return true;
    }
    
    public static ArrayList<Locacion> CatalogoLocaciones() throws IOException{
        Repositorio<Locacion> repo = Locacion.repositorio();
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
        }
		
		return eventosLocacion;
	}
	
	public static ArrayList<Evento> getEventosPorLocacion(String nombreLocacion) throws IOException {
	    Repositorio<Evento> repo = Evento.repositorio();
	    ArrayList<Evento> eventos = (ArrayList<Evento>) repo.todos();
	    ArrayList<Evento> eventosLocacion = new ArrayList<>();

	    for (Evento evento : eventos) {
	        if (evento.getLocacion() == nombreLocacion) {
	            eventosLocacion.add(evento);
	        }
	    }

	    return eventosLocacion;
	}



}
