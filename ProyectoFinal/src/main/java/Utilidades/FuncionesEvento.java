package Utilidades;

import java.io.IOException;
import java.util.ArrayList;
import Excepciones.EventoRegistradoException;
import Modelo.Evento;
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
    public static ArrayList<ArrayList<String>> CatalogoEventos() throws IOException{
        Repositorio<Evento> repo = Evento.repositorio();
        ArrayList<ArrayList<String>> StringEventos = new ArrayList<>();
        ArrayList<String> StringEvento = new ArrayList<>();
        ArrayList<Evento> eventos = (ArrayList<Evento>) repo.todos();

        for(Evento evento : eventos){
            StringEvento.add("nombre del evento: " + evento.getNombre());
            StringEvento.add("lugar del evento: " + evento.getLugar());

            //debido a que es una lista de artistas, se debe leer cada posicion
            String artistas = " ";
            for(String artista: evento.getArtistas()){
                artistas += artista;
                if(artista != evento.getArtistas().get(evento.getArtistas().size()-1)){
                    artistas += ", ";
                }
            }
            StringEvento.add("artistas: " + artistas);

            StringEvento.add("fecha del evento:" + evento.getFecha());
            StringEvento.add("cantidad de asientos: " + Integer.toString(evento.getCantAsientos()));
            StringEvento.add("cantidad de asientos bronce: " + Integer.toString(evento.getCantAsientosBronce()));
            StringEvento.add("cantidad de asientos plata: " + Integer.toString(evento.getCantAsientosPlata()));
            StringEvento.add("cantidad de asientos oro: " + Integer.toString(evento.getCantAsientosOro()));
            StringEvento.add("evento disponible: " + Boolean.toString(evento.isDisponible()));
            StringEventos.add(StringEvento);
        }


        return StringEventos;
    }



}
