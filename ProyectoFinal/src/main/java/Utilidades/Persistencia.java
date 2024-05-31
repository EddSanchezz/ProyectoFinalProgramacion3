package Utilidades;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final public class Persistencia
{
    /**
     * escribe un archivo xml con un objeto
     * 
     * @param ruta ruta del archivo xml (incluye nombre y extension)
     * @param obj objeto a persistir
     * 
     * @throws IOException
     */
    public static void escribirXml(String ruta, Object obj) throws IOException
    {
        XMLEncoder encoder = new XMLEncoder(new FileOutputStream(ruta));
        encoder.writeObject(obj);
        encoder.close();
    }

    /**
     * lee un objeto de un archivo xml
     * 
     * @param ruta ruta del archivo xml (incluye nombre y extension)
     * 
     * @throws IOException
     */
    public static Object leerXml(String ruta) throws IOException
    {
        XMLDecoder decoder = new XMLDecoder(new FileInputStream(ruta));
        Object object = decoder.readObject();
        decoder.close();

        return object;
    }

    /**
     * lee los archivos xml de un directorio
     * 
     * @param ruta directorio de los archivos
     * 
     * @return lista de objetos
     * 
     * @throws IOException
     */
    public static List<Object> leerDirectorioXml(String ruta) throws IOException
    {
        List<Object> objetos = new ArrayList<>();
        File directorio = new File(ruta);

        for (File f : directorio.listFiles()) {
            if (f.getName().endsWith(".xml")) {
                objetos.add(Persistencia.leerXml(f.getCanonicalPath()));
            }
        }

        return objetos;
    }

    /**
     * elimina un archivo/directorio 
     * 
     * @param ruta ruta del archivo (incluye nombre y extension)
     * 
     * @return logro de la accion
     * 
     * @throws IOException
     */
    public static boolean eliminar(String ruta)
    {
        return new File(ruta).delete();
    }
    
    /**
     * crea las carpetas de una ruta
     * 
     * @param ruta ruta deseada
     * 
     * @return logro de la accion
     * 
     * @throws IOException
     */
    public static boolean crearCarpetas(String ruta)
    {
        File direccion = new File(ruta);

        if (direccion.isDirectory()) {
            direccion = direccion.getParentFile();
        }

        return direccion.mkdirs();
    }
}
