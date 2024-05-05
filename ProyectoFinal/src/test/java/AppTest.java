/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 import Modelo.Boleta;
import Modelo.Evento;
 import Modelo.Usuario;
 import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;
 import javax.swing.JOptionPane;

import Enum.tipoBoleta;
/**
 *
 * @author metzu
 */
public class AppTest {
    

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) {
        Usuario usuario = new Usuario("marco", "polo@email.com", "123patata");
        ArrayList<String> artistas = new ArrayList<>();
        HashMap asientos = new HashMap(); 
        Boleta boleta1 = new Boleta(tipoBoleta.BRONCE, true);
        Boleta boleta2 = new Boleta(tipoBoleta.PLATA, true);
        Boleta boleta3 = new Boleta(tipoBoleta.ORO, true);
        asientos.put(1, boleta1);
        asientos.put(2, boleta2);
        asientos.put(3, boleta3);

        Evento evento = new Evento(true, "fuksNews", LocalDate.now(), "Armenia", artistas, 10.0, 20.0, 50.0, 300, asientos);
        JOptionPane.showMessageDialog(null, "Bienvenido " + usuario.getNombre());
        JOptionPane.showMessageDialog(null, "el precio de la boleta Oro es de " + evento.getPrecioBoletaOro() + " Dolares", "evento", -1);
        Boleta prueba = evento.getBoleta(1);
        JOptionPane.showMessageDialog(null, "su boleta es de : " + prueba.getCategoria(), null, 0);
        
    }
}
