package Utilidades;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase que contiene funciones utilitarias relacionadas con la gestión de la hora de apertura.
 */
public class FuncionesApertura {

    private static final String RUTA_HORA_APERTURA = "src\\main\\resources\\horaDeApertura.txt";

    /**
     * Lee la hora de apertura desde un archivo de texto.
     *
     * @return La hora de apertura en formato HH:mm, o null si no se pudo leer.
     */
    public static String leerHora() {
        String hora = null;
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_HORA_APERTURA))) {
            String linea = br.readLine();
            if (linea != null) {
                hora = linea.trim(); // Eliminar espacios en blanco alrededor de la hora
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hora;
    }

    /**
     * Configura la hora de apertura escribiendo la hora en un archivo de texto.
     *
     * @param hora La hora de apertura en formato HH:mm.
     */
    public static void configurarHora(String hora) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_HORA_APERTURA))) {
            bw.write(hora);
            JOptionPane.showMessageDialog(null, "Hora de apertura configurada a las " + hora, "Configuración exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar la hora de apertura.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Verifica si la hora actual es igual o posterior a la hora de apertura.
     *
     * @param hora La hora de apertura en formato HH:mm.
     * @return true si la hora actual es igual o posterior a la hora de apertura, false en caso contrario.
     */
    public static boolean verificarApertura(String hora) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime horaApertura = LocalTime.parse(hora, formatter);

            LocalTime ahora = LocalTime.now();

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

    /**
     * Verifica si la hora actual está dentro de un intervalo de tiempo especificado.
     *
     * @param horaInicio La hora de inicio del intervalo en formato HH:mm.
     * @param horaFin    La hora de fin del intervalo en formato HH:mm.
     * @return true si la hora actual está dentro del intervalo, false en caso contrario.
     */
    public static boolean verificarIntervalo(String horaInicio, String horaFin) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime inicio = LocalTime.parse(horaInicio, formatter);
            LocalTime fin = LocalTime.parse(horaFin, formatter);
            LocalTime ahora = LocalTime.now();

            if (ahora.isAfter(inicio) && ahora.isBefore(fin)) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "La hora actual no está dentro del intervalo permitido (" + horaInicio + " - " + horaFin + ").", "Hora no permitida", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato de hora inválido. Use HH:mm.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
