package Modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Persistencia.Persistible;
import Persistencia.Repositorio;
import javax.swing.JOptionPane;

/**
 * Clase que representa un evento, implementando la interfaz Persistible para
 * permitir su persistencia y Serializable para permitir su serialización.
 */
@SuppressWarnings("serial")
public class Evento implements Persistible, Serializable {
    private boolean disponible;
    private String nombre;
    private LocalDate fecha;
    private String lugar;
    private List<String> artistas;
    private int precioBoletaBronce;
    private int precioBoletaPlata;
    private int precioBoletaOro;
    private int cantAsientos;
    private int cantAsientosBronce;
    private int cantAsientosPlata;
    private int cantAsientosOro;
    private String id;
    private String locacion;
    private int limiteAsientos;

    /**
     * Constructor vacío necesario para la serialización.
     */
    public Evento() {}

    /**
     * Constructor con parámetros para inicializar un evento.
     *
     * @param disponible       Indica si el evento está disponible.
     * @param nombre           Nombre del evento.
     * @param fecha            Fecha del evento.
     * @param lugar            Lugar del evento.
     * @param artistas         Lista de artistas que se presentarán en el evento.
     * @param precioBoletaBronce Precio de la boleta de bronce.
     * @param precioBoletaPlata Precio de la boleta de plata.
     * @param precioBoletaOro   Precio de la boleta de oro.
     * @param cantAsientos      Cantidad total de asientos disponibles.
     * @param locacion          Locación donde se realizará el evento.
     */
    public Evento(boolean disponible, String nombre, LocalDate fecha, String lugar, List<String> artistas,
                  int precioBoletaBronce, int precioBoletaPlata, int precioBoletaOro, int cantAsientos, Locacion locacion) {
        this.disponible = disponible;
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.artistas = new ArrayList<>(artistas);
        this.precioBoletaBronce = precioBoletaBronce;
        this.precioBoletaPlata = precioBoletaPlata;
        this.precioBoletaOro = precioBoletaOro;
        this.locacion = locacion.getNombre();
        this.limiteAsientos = locacion.getCapacidadDeAsientos();
        setCantAsientos(cantAsientos);
    }

    /**
     * Indica si el evento está disponible.
     *
     * @return true si el evento está disponible, false en caso contrario.
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * Establece si el evento está disponible o no.
     *
     * @param disponible true para indicar que el evento está disponible, false en caso contrario.
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * Obtiene el nombre del evento.
     *
     * @return El nombre del evento.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del evento.
     *
     * @param nombre El nombre del evento.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la fecha del evento.
     *
     * @return La fecha del evento.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha del evento.
     *
     * @param fecha La fecha del evento.
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el lugar del evento.
     *
     * @return El lugar del evento.
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * Establece el lugar del evento.
     *
     * @param lugar El lugar del evento.
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    /**
     * Obtiene la lista de artistas que se presentarán en el evento.
     *
     * @return La lista de artistas.
     */
    public List<String> getArtistas() {
        return artistas;
    }

    /**
     * Establece la lista de artistas que se presentarán en el evento.
     *
     * @param artistas La lista de artistas.
     */
    public void setArtistas(List<String> artistas) {
        this.artistas = new ArrayList<>(artistas);
    }

    /**
     * Obtiene el precio de la boleta de bronce.
     *
     * @return El precio de la boleta de bronce.
     */
    public int getPrecioBoletaBronce() {
        return precioBoletaBronce;
    }

    /**
     * Establece el precio de la boleta de bronce.
     *
     * @param precioBoletaBronce El precio de la boleta de bronce.
     */
    public void setPrecioBoletaBronce(int precioBoletaBronce) {
        this.precioBoletaBronce = precioBoletaBronce;
    }

    /**
     * Obtiene el precio de la boleta de plata.
     *
     * @return El precio de la boleta de plata.
     */
    public int getPrecioBoletaPlata() {
        return precioBoletaPlata;
    }

    /**
     * Establece el precio de la boleta de plata.
     *
     * @param precioBoletaPlata El precio de la boleta de plata.
     */
    public void setPrecioBoletaPlata(int precioBoletaPlata) {
        this.precioBoletaPlata = precioBoletaPlata;
    }

    /**
     * Obtiene el precio de la boleta de oro.
     *
     * @return El precio de la boleta de oro.
     */
    public int getPrecioBoletaOro() {
        return precioBoletaOro;
    }

    /**
     * Establece el precio de la boleta de oro.
     *
     * @param precioBoletaOro El precio de la boleta de oro.
     */
    public void setPrecioBoletaOro(int precioBoletaOro) {
        this.precioBoletaOro = precioBoletaOro;
    }

    /**
     * Obtiene la cantidad total de asientos disponibles.
     *
     * @return La cantidad total de asientos.
     */
    public int getCantAsientos() {
        return cantAsientos;
    }

    /**
     * Establece la cantidad total de asientos disponibles, limitando esta cantidad a la capacidad de la locación.
     *
     * @param cantAsientos La cantidad total de asientos.
     */
    public void setCantAsientos(int cantAsientos) {
        if (cantAsientos > limiteAsientos) {
            JOptionPane.showMessageDialog(null, "La cantidad de asientos es mayor a la capacidad de la locación, por lo que el número de asientos se limitará.");
            this.cantAsientos = limiteAsientos;
        } else {
            this.cantAsientos = cantAsientos;
        }
    }

    /**
     * Obtiene la cantidad de asientos de la categoría bronce.
     *
     * @return La cantidad de asientos de bronce.
     */
    public int getCantAsientosBronce() {
        return cantAsientosBronce;
    }

    /**
     * Establece la cantidad de asientos de la categoría bronce.
     *
     * @param cantAsientosBronce La cantidad de asientos de bronce.
     */
    public void setCantAsientosBronce(int cantAsientosBronce) {
        this.cantAsientosBronce = cantAsientosBronce;
    }

    /**
     * Obtiene la cantidad de asientos de la categoría plata.
     *
     * @return La cantidad de asientos de plata.
     */
    public int getCantAsientosPlata() {
        return cantAsientosPlata;
    }

    /**
     * Establece la cantidad de asientos de la categoría plata.
     *
     * @param cantAsientosPlata La cantidad de asientos de plata.
     */
    public void setCantAsientosPlata(int cantAsientosPlata) {
        this.cantAsientosPlata = cantAsientosPlata;
    }

    /**
     * Obtiene la cantidad de asientos de la categoría oro.
     *
     * @return La cantidad de asientos de oro.
     */
    public int getCantAsientosOro() {
        return cantAsientosOro;
    }

    /**
     * Establece la cantidad de asientos de la categoría oro.
     *
     * @param cantAsientosOro La cantidad de asientos de oro.
     */
    public void setCantAsientosOro(int cantAsientosOro) {
        this.cantAsientosOro = cantAsientosOro;
    }

    /**
     * Obtiene la locación del evento.
     *
     * @return La locación del evento.
     */
    public String getLocacion() {
        return locacion;
    }

    /**
     * Establece la locación del evento.
     *
     * @param locacion La locación del evento.
     */
    public void setLocacion(String locacion) {
        this.locacion = locacion;
    }

    /**
     * Obtiene el límite de asientos de la locación.
     *
     * @return El límite de asientos de la locación.
     */
    public int getLimiteAsientos() {
        return limiteAsientos;
    }

    /**
     * Establece el límite de asientos de la locación.
     *
     * @param limiteAsientos El límite de asientos de la locación.
     */
    public void setLimiteAsientos(int limiteAsientos) {
        this.limiteAsientos = limiteAsientos;
    }

    /**
     * {@inheritDoc}
     *
     * @return El ID del evento.
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     * {@inheritDoc}
     *
     * @param id El ID del evento.
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el repositorio para los recursos de evento.
     *
     * @return El repositorio de evento.
     */
    public static Repositorio<Evento> repositorio() {
        return new Repositorio<Evento>("src\\main\\resources\\eventos");
    }


}
