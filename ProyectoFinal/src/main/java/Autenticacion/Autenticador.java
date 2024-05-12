package Autenticacion;

import java.io.IOException;

import Modelo.Usuario;

public final class Autenticador
{
    /**
     * identificador del usuario autenticado
     */
    private static String usuarioId;

    /**
     * contructor vacio
     */
    public Autenticador() {}

    /**
     * intenta autenticar un usuario usando credenciales
     * 
     * @param credenciales credenciales de usuario
     * 
     * @throws IOException
     */
    public static void intentar(Credenciales credenciales) throws IOException
    {
        Usuario usuario = credenciales.hallar();

        if (usuario != null) Autenticador.usuarioId = usuario.getId();
    }

    /**
     * olvida al usuario actual autenticado
     */
    public static void olvidarUsuario()
    {
        Autenticador.usuarioId = null;
    }

    /**
     * comprueba si un usuario se encuentra autenticado
     * 
     * @return un usuario esta autenticado
     */
    public static boolean estaAutenticado()
    {
        return Autenticador.usuarioId != null;
    }

    /**
     * obtiene un objeto del usuario autenticado
     * 
     * @return usuario identificado o null
     */
    public static Usuario usuario() throws IOException
    {
        if (Autenticador.usuarioId == null) return null;

        return Usuario.repositorio().hallar(usuarioId);
    }
}