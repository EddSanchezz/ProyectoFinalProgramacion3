package Controlador;

import java.io.IOException;
import Vista.LoginFrame;

/**
 *
 * @author Esteban S.
 */
public class Application {
    
    public static void main(String[] args) throws IOException {

        //ejecuta el servidor
        String host = "localhost";
        int port = 12345; // Puerto en el que el servidor escucha
        try {
            Cliente cliente = new Cliente(host, port);
            cliente.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //ejecuta la ventana de login
        new LoginFrame();
        
        
    }
    
}
