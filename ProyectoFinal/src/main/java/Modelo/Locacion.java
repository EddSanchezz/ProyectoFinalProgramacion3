package Modelo;

import java.io.Serializable;

import Persistencia.Persistible;
import Persistencia.Repositorio;

public class Locacion implements Serializable, Persistible{
    private String nombre;
    private int capacidadDeAsientos;
    private String id;
    
    public Locacion() {};

    public Locacion(String nombre, int capacidadDeAsientos) {
        this.nombre = nombre;
        this.capacidadDeAsientos = capacidadDeAsientos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidadDeAsientos() {
        return capacidadDeAsientos;
    }

    public void setCapacidadDeAsientos(int capacidadDeAsientos) {
        this.capacidadDeAsientos = capacidadDeAsientos;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String getId()
    {
        return this.id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setId(String id)
    {
        this.id  = id;
    }
    
    public static Repositorio<Locacion> repositorio()
    {
        return new Repositorio<Locacion>("src\\main\\resources\\locaciones");
    }

}

