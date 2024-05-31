/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Enum.tipoBoleta;

/**
 *
 * @author metzu
 */
public class Boleta {
    private tipoBoleta categoria;
    private boolean disponible;
    private String nombre;
    private String id;

    public Boleta(){}

    public Boleta(tipoBoleta categoria, boolean disponible) {
        this.categoria = categoria;
        this.disponible = disponible;
    }

    public tipoBoleta getCategoria() {
        return categoria;
    }
    public void setCategoria(tipoBoleta categoria) {
        this.categoria = categoria;
    }
    public boolean isDisponible() {
        return disponible;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setNombreBoleta(String nombre){
        this.nombre = nombre;
    }

    public void setIdentificacion(String id){
        this.id = id;
    }
    
    public String getNombreBoleta(){
        return nombre;
    }

    public String getIdBoleta(){
        return id;
    }

    
}
