/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author metzu
 */
public class Evento {
    private boolean disponible;
    private String nombre;
    private LocalDate fecha;
    private String lugar;
    private ArrayList<String> artistas;
    private Double precioBoletaBronce;
    private Double precioBoletaPlata;
    private Double precioBoletaOro;
    private int cantAsientos;
    private int cantAsientosBronce;
    private int cantAsientosPlata;
    private int cantAsientosOro;


    public Evento(boolean disponible, String nombre, LocalDate fecha, String lugar, ArrayList<String> artistas,
            Double precioBoletaBronce, Double precioBoletaPlata, Double precioBoletaOro, int cantAsientos) {
        this.disponible = disponible;
        this.nombre = nombre;
        this.fecha = fecha;
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



    public int getCantAsientosBronce() {
        return cantAsientosBronce;
    }
    public void setCantAsientosBronce(int cantAsientosBronce) {
        this.cantAsientosBronce = cantAsientosBronce;
    }
    public int getCantAsientosPlata() {
        return cantAsientosPlata;
    }
    public void setCantAsientosPlata(int cantAsientosPlata) {
        this.cantAsientosPlata = cantAsientosPlata;
    }
    public int getCantAsientosOro() {
        return cantAsientosOro;
    }
    public void setCantAsientosOro(int cantAsientosOro) {
        this.cantAsientosOro = cantAsientosOro;
    }
    public boolean isDisponible() {
        return disponible;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public String getLugar() {
        return lugar;
    }
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    public ArrayList<String> getArtistas() {
        return artistas;
    }
    public void setArtistas(ArrayList<String> artistas) {
        this.artistas = artistas;
    }
    public Double getPrecioBoletaBronce() {
        return precioBoletaBronce;
    }
    public void setPrecioBoletaBronce(Double precioBoletaBronce) {
        this.precioBoletaBronce = precioBoletaBronce;
    }
    public Double getPrecioBoletaPlata() {
        return precioBoletaPlata;
    }
    public void setPrecioBoletaPlata(Double precioBoletaPlata) {
        this.precioBoletaPlata = precioBoletaPlata;
    }
    public Double getPrecioBoletaOro() {
        return precioBoletaOro;
    }
    public void setPrecioBoletaOro(Double precioBoletaOro) {
        this.precioBoletaOro = precioBoletaOro;
    }
    public int getCantAsientos() {
        return cantAsientos;
    }
    public void setCantAsientos(int cantAsientos) {
        this.cantAsientos = cantAsientos;
    }
    
    

    
    

}
