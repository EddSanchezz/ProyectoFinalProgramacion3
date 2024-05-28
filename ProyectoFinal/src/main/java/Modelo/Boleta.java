package Modelo;

import Persistencia.Persistible;
import Persistencia.Repositorio;

public class Boleta implements Persistible {
    private String evento;
    private int numeroSilla;
    private int precioSilla;
    private String id;

    public Boleta(String evento, int numeroSilla, int precioSilla) {
        this.evento = evento;
        this.numeroSilla = numeroSilla;
        this.precioSilla = precioSilla;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public int getNumeroSilla() {
        return numeroSilla;
    }

    public void setNumeroSilla(int numeroSilla) {
        this.numeroSilla = numeroSilla;
    }

    public int getPrecioSilla() {
        return precioSilla;
    }

    public void setPrecioSilla(int precioSilla) {
        this.precioSilla = precioSilla;
    }

    @Override
    public String getId() {
        return "";
    }

    @Override
    public void setId(String id) {

    }


}

