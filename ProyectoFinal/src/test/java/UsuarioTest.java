import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import Autenticacion.Autenticador;
import Autenticacion.Credenciales;
import Excepciones.UsuarioRegistradoException;
import Modelo.Usuario;
import Utilidades.FuncionesUsuario;

public class UsuarioTest
{
    @Test
    public void crearUsuario()
    {
        Usuario usuario = new Usuario("Juan Caballa", "test@example.com", "123");

        assertEquals("test@example.com", usuario.getCorreo());
        assertEquals("Juan Caballa", usuario.getNombre());
        assertEquals("123", usuario.getClave());
    }

    @Test
    public void regisrar()
    {
        Usuario u = new Usuario("Juan Caballa", "test@example.com", "123");

        assertDoesNotThrow(() -> FuncionesUsuario.registrar(u));

        Usuario u2 = new Usuario("Pedro Motocross", "test@example.com", "98");

        assertThrows(
            UsuarioRegistradoException.class,
            () -> FuncionesUsuario.registrar(u2)
        );
    }

    @Test
    public void autenticar() throws IOException
    {
        Usuario u = new Usuario("Juan Caballa", "testauth@example.com", "123");

        try {
            FuncionesUsuario.registrar(u);
            Autenticador.intentar(new Credenciales("test@example.com", "contraseña"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertTrue(Autenticador.usuario() == null);
        Autenticador.intentar(new Credenciales("test@example.com", "123"));
        assertEquals(u.getId(), Autenticador.usuario().getId());
    }
}