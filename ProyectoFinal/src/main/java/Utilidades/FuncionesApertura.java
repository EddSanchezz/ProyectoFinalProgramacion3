package Utilidades;

import javax.swing.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FuncionesApertura {
    
	public static String leerHora() {
	    String hora = null;
	    String ruta = "src\\\\main\\\\resources\\\\horaDeApertura.txt"; // Cambiado el formato de la ruta
	    try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
	        String linea = br.readLine();
	        if (linea != null) {
	            hora = linea.trim(); // Eliminar espacios en blanco alrededor de la hora
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return hora;
	}

    
    public static void configurarHora(String primeraLinea) {
    	String ruta = "src\\\\main\\\\resources\\\\horaDeApertura.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            bw.write(primeraLinea);
            JOptionPane.showMessageDialog(null, "Hora de apertura configurada a las " + primeraLinea, "Configuración exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Formato de hora inválido. Use HH:mm.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static boolean verificarApertura(String hora) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime horaApertura = LocalTime.parse(hora, formatter);
            System.out.println("Hora de apertura leída: " + horaApertura.toString()); // Mensaje de depuración

            LocalTime ahora = LocalTime.now();
            System.out.println("Hora actual: " + ahora.toString()); // Mensaje de depuración

            if (ahora.isBefore(horaApertura)) {
                JOptionPane.showMessageDialog(null, "Podrá entrar a la ventana a las " + horaApertura.toString(), "Hora no permitida", JOptionPane.INFORMATION_MESSAGE);
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato de hora inválido. Use HH:mm.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }



}
