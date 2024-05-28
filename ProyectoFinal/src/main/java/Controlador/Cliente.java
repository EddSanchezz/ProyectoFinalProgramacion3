package Controlador;

import java.io.*;
import java.net.*;

public class Cliente {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private BufferedReader stdIn;

    public Cliente(String host, int port) throws IOException {
        socket = new Socket(host, port);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        stdIn = new BufferedReader(new InputStreamReader(System.in));
    }

    public void start() {
        System.out.println("Conectado al servidor.");
        String userInput;
        try {
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println("Respuesta del servidor: " + in.readLine());
                if ("bye".equalsIgnoreCase(userInput)) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                in.close();
                out.close();
                stdIn.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}

