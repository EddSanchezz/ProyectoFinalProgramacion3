/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    private HashMap<Integer,Boleta> asientos;
    private String id;

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
            Double precioBoletaBronce, Double precioBoletaPlata, Double precioBoletaOro, int cantAsientos) {
        this.disponible = disponible;
        this.nombre = nombre;
        this.fecha = fecha.toString();
        this.lugar = lugar;
        this.artistas = artistas;
        this.precioBoletaBronce = precioBoletaBronce;
        this.precioBoletaPlata = precioBoletaPlata;
        this.precioBoletaOro = precioBoletaOro;
        this.cantAsientos = cantAsientos;
        this.cantAsientosBronce = (int) (cantAsientos* 0.6);
        this.cantAsientosPlata = (int) (cantAsientos* 0.3);
        this.cantAsientosOro = (int) (cantAsientos* 0.1);
    }

    /**
     * metodo dedicado a agregar los asientos faltantes debido a la división de asientos
     */
    public void agregarAsientoPerdido(){
        int sumaAsientos = cantAsientosBronce + cantAsientosPlata + cantAsientosOro;
        int diferencia = 0;
        if(cantAsientos != cantAsientosBronce+cantAsientosPlata+cantAsientosOro){
            diferencia = cantAsientos - sumaAsientos;
            cantAsientosBronce = cantAsientosBronce + diferencia;
        }

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

    /**
     * devuelve la fecha del evento como un String
     * @return
     
    public String getStringFecha() {
        // define el formato deseado
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // convierte el LocalDate a String usando el formato definido
        String fechaComoString = fecha.format(formato);

        return fechaComoString;
    }*/

    /**
     *  establece la fecha del evento
     * @param fecha
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
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
        this.cantAsientos = cantAsientos;
    }

    /**
     * obitene el numero de asiento de una boleta
     * @param numAsiento
     * @return
     */
    public Boleta getBoleta(int numAsiento) {
        return this.asientos.get(numAsiento);
    }

    /**
     * establece el numero de asiento de una boleta
     * @param numAsiento
     * @param boleta
     */
    public void setAsientos(int numAsiento, Boleta boleta) {
        this.asientos.put(numAsiento,boleta);
    }

    /**
     * obtiene la lista de asientos (codigo y boleta)
     * @return asientos
     */
    public HashMap<Integer, Boleta> getAsientos() {
        return asientos;
    }

    /**
     * establece una lista de asientos (codigo y boleta)
     * @param asientos
     */
    public void setAsientos(HashMap<Integer, Boleta> asientos) {
        this.asientos = asientos;
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
