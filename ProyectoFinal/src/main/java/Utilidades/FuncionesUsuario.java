package Utilidades;

import java.io.IOException;

import Excepciones.UsuarioRegistradoException;
import Modelo.Usuario;
import Persistencia.Repositorio;

public final class FuncionesUsuario
{
    /**
     * previene la instanciacion
     */
    private FuncionesUsuario() {}

    /**
     * registra un nuevo usuario
     * 
     * @param usuario usuario a registrar
     *  
     * @throws UsuarioRegistradoException cuando el correo ya ha sido tomado
     * @throws IOException error en el manejo de ficheros
     */
    public static void registrar(Usuario usuario) throws UsuarioRegistradoException, IOException
    {
        Repositorio<Usuario> repo = Usuario.repositorio();

        for (Usuario u: repo.todos()) {
            if (u.getCorreo().equals(usuario.getCorreo())) {
                throw new UsuarioRegistradoException("el correo ya ha sido tomado.");
            }
        }

        usuario.setId(null); // identificador en nulo para crear un nuevo recurso
        repo.escribir(usuario); // crear el recurso
    }
}