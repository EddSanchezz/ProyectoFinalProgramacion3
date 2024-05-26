package Utilidades;

import java.io.IOException;
import java.util.ArrayList;
import Excepciones.EventoRegistradoException;
import Excepciones.UsuarioRegistradoException;
import Modelo.Evento;
import Modelo.Locacion;
import Modelo.Usuario;
import Persistencia.Repositorio;

public class FuncionesEvento {
    
    /**
     * previene la instanciacion
     */
    private FuncionesEvento() {}

    /**
     * metodo encargado de registrar un evento
     * @param evento
     * @throws EventoRegistradoException
     * @throws IOException
     */
    public static void registrarEvento(Evento evento) throws EventoRegistradoException, IOException
    {
        Repositorio<Evento> repo = Evento.repositorio();

        for (Evento u: repo.todos()) {
            if (u.getNombre().equals(evento.getNombre())) {
                throw new EventoRegistradoException("el evento ya existe.");
            }
        }

        evento.setId(null); // identificador en nulo para crear un nuevo recurso
        repo.escribir(evento); // crear el recurso
    }

    /**
     * este metodo se encarga de convertir todos los eventos en una lista de arreglos para trabajar
     * mas facilmente con los elementos
     * @param ruta
     * @return StringEventos
     * @throws IOException
     */
    public static ArrayList<Evento> CatalogoEventos() throws IOException{
        Repositorio<Evento> repo = Evento.repositorio();
        ArrayList<Evento> eventos = (ArrayList<Evento>) repo.todos();
        return eventos;
    }
    
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
    
    


}
