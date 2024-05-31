package Autenticacion;

import java.io.IOException;

import Modelo.Usuario;

public class Credenciales
{
    /**
     * correo electronico
     */
    private String correo;

    /**
     * contraseña
     */
    private String clave;

    /**
     * crea una instancia
     * 
     * @param correo direccion de correo electronico
     * @param clave contraseña
     */
    public Credenciales(String correo, String clave)
    {
        this.correo = correo;
        this.clave = clave;
    }

    /**
     * obtiene la direccion de correo electronico
     * 
     * @return correo electronico
     */
    public String getCorreo()
    {
        return this.correo;
    }

    /**
     * valida las credenciales con los recursos
     * 
     * @return representacion de la validacion
     */
    public boolean validar() throws IOException
    {
        for (Usuario u: Usuario.repositorio().todos()) {
            if (
                u.getCorreo().equalsIgnoreCase(correo)
                && u.getClave().equals(clave)
            ) {
                return true; // si cumple las condiciones
            }
        }

        return false; // no comple las credenciales
    }

    /**
     * halla un usuario
     * 
     * @return instancia del usuario o null
     * 
     * @throws IOException
     */
    public Usuario hallar() throws IOException
    {
        for (Usuario u: Usuario.repositorio().todos()) {
            if (! u.getCorreo().equalsIgnoreCase(correo)) {
                continue;
            }

            if (u.getClave().equals(clave)) return u;
        }

        return null;
    }
}