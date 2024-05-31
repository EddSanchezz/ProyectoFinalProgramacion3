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
    public static boolean registrarUsuario(String nombre, String correo, String clave) throws UsuarioRegistradoException, IOException
    {
    	Usuario usuario = new Usuario(nombre,correo,clave);
    	
        Repositorio<Usuario> repo = Usuario.repositorio();

        for (Usuario u: repo.todos()) {
            if (u.getCorreo().equals(usuario.getCorreo())) {
                return false;
            }
        }
        
        
        usuario.setId(null); // identificador en nulo para crear un nuevo recurso
        repo.escribir(usuario); // crear el recurso
        return true;
        
    }
    
    /**
     * metodo dedicado a verificar si el usuario esta en la base de datos
     * @param correo
     * @param clave
     * @return
     */
    public static boolean verificarUsuario(String correo, String clave) {
    	boolean acceso = false;
    	Repositorio<Usuario> repo = Usuario.repositorio();

        try {
			for (Usuario u: repo.todos()) {
			    if (u.getCorreo().equals(correo) && u.getClave().equals(clave)) {
			        acceso = true;
			    }
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        return acceso;
    }
}