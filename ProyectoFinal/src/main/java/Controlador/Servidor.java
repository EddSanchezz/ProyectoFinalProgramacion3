package Controlador;

import java.io.*;
import java.net.*;

public class Servidor {

    private ServerSocket serverSocket;

    public Servidor(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() {
        System.out.println("Servidor iniciado. Esperando conexiones...");
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Cliente conectado: " + socket.getInetAddress().getHostAddress());
                new ClientHandler(socket).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //ejecuta el servidor
    public static void main(String[] args) {
        int port = 12345; // Puerto en el que el servidor escucha
        try {
            Servidor servidor = new Servidor(port);
            servidor.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

