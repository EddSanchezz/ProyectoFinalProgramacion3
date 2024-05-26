package Modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import Persistencia.Persistible;
import Persistencia.Repositorio;


public class Evento implements Persistible, Serializable{
    private boolean disponible;
    private String nombre;
    private String fecha;
    private String lugar;
    private ArrayList<String> artistas;
    private Double precioBoletaBronce;
    private Double precioBoletaPlata;
    private Double precioBoletaOro;
    private int cantAsientos;
    private int cantAsientosBronce;
    private int cantAsientosPlata;
    private int cantAsientosOro;
    private String id;
    private Locacion locacion;

    /**
     * constructor vacio para serializacion
     */
    public Evento(){}

    /**
     * constructor con los siguuientes parametros:
     * @param disponible
     * @param nombre
     * @param fecha
     * @param lugar
     * @param artistas
     * @param precioBoletaBronce
     * @param precioBoletaPlata
     * @param precioBoletaOro
     * @param cantAsientos
     */
    public Evento(boolean disponible, String nombre, LocalDate fecha, String lugar, ArrayList<String> artistas,
            Double precioBoletaBronce, Double precioBoletaPlata, Double precioBoletaOro, int cantAsientos, Locacion locacion) {  // Agrega el parámetro locacion
        this.disponible = disponible;
        this.nombre = nombre;
        this.fecha = fecha.toString();
        this.lugar = lugar;
        this.artistas = artistas;
        this.precioBoletaBronce = precioBoletaBronce;
        this.precioBoletaPlata = precioBoletaPlata;
        this.precioBoletaOro = precioBoletaOro;
        this.locacion = locacion;
        setCantAsientos(cantAsientos);  // Usa el método setCantAsientos para establecer la cantidad de asientos
    }

    /**
     * obtiene la cantidad de asientos
     * @return cantAsientosBronce
     */
    public int getCantAsientosBronce() {
        return cantAsientosBronce;
    }

    /**
     * establece la cantidad de asientos de bronce
     * @param cantAsientosBronce
     */
    public void setCantAsientosBronce(int cantAsientosBronce) {
        this.cantAsientosBronce = cantAsientosBronce;
    }

    /**
     * obtiene la cantidad de asientos de plata
     * @return cantAsientosPlata
     */
    public int getCantAsientosPlata() {
        return cantAsientosPlata;
    }

    /**
     * establece la cantidad de asientos de plata
     * @param cantAsientosPlata
     */
    public void setCantAsientosPlata(int cantAsientosPlata) {
        this.cantAsientosPlata = cantAsientosPlata;
    }

    /*
     *  obtiene la cantidad de asientos de oro
     *  @return cantAsientosOro
     */
    public int getCantAsientosOro() {
        return cantAsientosOro;
    }

    /**
     * establece la cantidad de asientos de oro
     * @param cantAsientosOro
     */
    public void setCantAsientosOro(int cantAsientosOro) {
        this.cantAsientosOro = cantAsientosOro;
    }

    /**
     * indica si el evento esta disponible o no
     * @return disponible
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * establece si el evento esta disponible o no
     * @param disponible
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * obtiene el nombre del evento
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * establece el nombre del evento
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * obtiene la fecha del evento
     * @return fecha
     */
    public String getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha.toString();
    }

    /**
     * obtiene el lugar del evento
     * @return lugar
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * establece el lugar del evento
     * @param lugar
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    /**
     * obtiene la lista de artistas del evento
     * @return artistas
     */
    public ArrayList<String> getArtistas() {
        return artistas;
    }

    /**
     * establece la lista de artistas del evento
     * @param artistas
     */
    public void setArtistas(ArrayList<String> artistas) {
        this.artistas = artistas;
    }

    /**
     * obtiene el precio de la boleta de bronce
     * @return precioBoletaBronce
     */
    public Double getPrecioBoletaBronce() {
        return precioBoletaBronce;
    }

    /*
     * establece el precio de la boleta de bronce
     * @param precioBoletaBronce
     */
    public void setPrecioBoletaBronce(Double precioBoletaBronce) {
        this.precioBoletaBronce = precioBoletaBronce;
    }

    /**
     * obtiene el precio de la boleta de plata
     * @return precioBoletaPlata
     */
    public Double getPrecioBoletaPlata() {
        return precioBoletaPlata;
    }

    /**
     * estabelce el precio de la boleta de plata
     * @param precioBoletaPlata
     */
    public void setPrecioBoletaPlata(Double precioBoletaPlata) {
        this.precioBoletaPlata = precioBoletaPlata;
    }

    /**
     * devuelve el precio de la boleta de oro
     * @return precioBoletaOro
     */
    public Double getPrecioBoletaOro() {
        return precioBoletaOro;
    }

    /**
     * establece el precio de la boleta de oro
     * @param precioBoletaOro
     */
    public void setPrecioBoletaOro(Double precioBoletaOro) {
        this.precioBoletaOro = precioBoletaOro;
    }

    /**
     * devuelve la cantidad de asientos
     * @return cantAsientos
     */
    public int getCantAsientos() {
        return cantAsientos;
    }

    /**
     * establece la cantidad de asientos
     * @param cantAsientos
     */
    public void setCantAsientos(int cantAsientos) {
        if (cantAsientos > locacion.getCapacidadDeAsientos()) {
            throw new IllegalArgumentException("La cantidad de asientos no puede ser mayor a la capacidad de la locación");
        }
        this.cantAsientos = cantAsientos;
    }

    
    /**
     * {@inheritDoc}
     * @return id
     */
    @Override
    public String getId() {
        return this.id;
    }

    /**
     * {@inheritDoc}
     * @param id
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * obtiene el repositorio para los recursos de evento
     * 
     * @return repositorio de evento
     */
    public static Repositorio<Evento> repositorio()
    {
        return new Repositorio<Evento>("src/main/resources/eventos");
    }
}
