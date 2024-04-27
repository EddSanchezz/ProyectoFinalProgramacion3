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



    public Boleta(tipoBoleta categoria, float precio) {
        this.categoria = categoria;
    }



    public tipoBoleta getCategoria() {
        return categoria;
    }
    public void setCategoria(tipoBoleta categoria) {
        this.categoria = categoria;
    }

    
}
