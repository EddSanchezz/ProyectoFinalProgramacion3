package Utilidades;

import java.io.File;

public class FuncionesBoleta {

    /**
     * Metodo para crear el directorio con el nombre del evento
     * @param nombreDirectorio
     */
    public static void crearDirectorio(String nombreDirectorio) {
        String rutaPadre = "src/main/resources/boletas";
        File directorioPadre = new File(rutaPadre);

        // Verificar si el directorio padre existe
        if (directorioPadre.exists()) {
            // Crear la ruta completa para el nuevo directorio dentro del directorio padre
            String rutaNuevoDirectorio = rutaPadre + File.separator + nombreDirectorio;
            File nuevoDirectorio = new File(rutaNuevoDirectorio);

            // Verificar si el directorio ya existe
            if (!nuevoDirectorio.exists()) {
                // Intentar crear el directorio
                boolean creado = nuevoDirectorio.mkdirs();
                if (creado) {
                    System.out.println("Directorio creado correctamente en: " + rutaNuevoDirectorio);
                } else {
                    System.out.println("Error al crear el directorio en: " + rutaNuevoDirectorio);
                }
            } else {
                System.out.println("El directorio '" + nombreDirectorio + "' ya existe en: " + rutaPadre);
            }
        } else {
            System.out.println("El directorio padre no existe en la ruta especificada: " + rutaPadre);
        }
    }
}
