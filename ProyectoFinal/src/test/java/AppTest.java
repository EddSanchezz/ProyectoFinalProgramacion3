/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Modelo.Evento;
import Modelo.Usuario;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author metzu
 */
public class AppTest {
    

    public static void main(String[] args) {
        Usuario usuario = new Usuario("marco", "polo@email.com", "123patata");
        ArrayList<String> artistas = new ArrayList<>();
        Evento evento = new Evento(true, "fuksNews", LocalDate.now(), "Armenia", artistas, 10.0, 20.0, 50.0, 300);
    }
}
