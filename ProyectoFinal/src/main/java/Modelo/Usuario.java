package Modelo;

import java.io.Serializable;

import Persistencia.Persistible;
import Persistencia.Repositorio;

@SuppressWarnings("serial")
public class Usuario implements Serializable, Persistible
{
    /**
     * nombre completo
     */
    private String nombre;

    /**
     * direccion de correo electronico
     */
    private String correo;

    /**
     * clave de accesso
     */
    private String clave;

    /**
     * identificador del recurso asociado
     */
    private String id;

    /**
     * constructor vacio para serializacion
     */
    public Usuario() {}

    /**
     * contruye una nueva instancia
     * 
     * @param nombre nombre(s) y apellido(s)
     * @param correo correo electronico
     * @param clave clave de acceso
     */
    public Usuario(String nombre, String correo, String clave)
    {
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
    }

    /**
     * obtiene el nombre completo
     * 
     * @return nombre(s) y apellido(s)
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * establece el nombre completo
     * 
     * @param nombre nombre(s) y apellido(s)
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    /**
     * obtiene la direccion de correo electronico
     * 
     * @return correo electronico
     */
    public String getCorreo()
    {
        return correo;
    }

    /**
     * establece la direccion de correo electronico
     * 
     * @param correo correo electronico
     */
    public void setCorreo(String correo)
    {
        this.correo = correo;
    }

    /**
     * obtiene la clave de accesso
     * 
     * @return clave de acceso
     */
    public String getClave()
    {
        return clave;
    }

    /**
     * establece la clave de accesso
     * 
     * @param clave nueva clave de acesso
     */
    public void setClave(String clave)
    {
        this.clave = clave;
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

    /**
     * obtiene el repositorio para los recursos de usuario
     * 
     * @return repositorio de usuario
     */
    public static Repositorio<Usuario> repositorio()
    {
        return new Repositorio<Usuario>("src\\main\\resources\\usuarios");
    }
}