package Persistencia;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import Utilidades.Persistencia;

public class Repositorio<T extends Persistible>
{
    /**
     * ruta de los recursos
     */
    private String ruta;

    /**
     * crea una nueva instancia
     *
     * @param rutaRecursos directorio de los recursos
     */
    public Repositorio(String rutaRecursos)
    {
        if (rutaRecursos.endsWith("/")) {
            rutaRecursos = rutaRecursos.substring(0, -1);
        }

        new File(rutaRecursos).mkdirs();

        this.ruta = rutaRecursos;
    }

    /**
     * halla un recurso dado su identificador
     *
     * @param id identificador del recurso
     *
     * @return objeto del recurso
     *
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    public T hallar(String id) throws IOException
    {
        return (T) Persistencia.leerXml(ruta + "/" + id + ".xml");
    }

    /**
     * obtiene todos los recursos
     *
     * @return lista de objetos obtenidos de los recursos
     *
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    public List<T> todos() throws IOException {
        List<Object> objects = Persistencia.leerDirectorioXml(ruta);
        List<T> list = new ArrayList<>();
        for (Object object : objects) {
            list.add((T) object);
        }
        return list;
    }


    /**
     * crea o sobre escribe un recurso
     *
     * @param id identificador del recurso
     *
     * @param objeto objeto para el recurso
     *
     * @throws IOException
     */
    public void escribir(String id, T objeto) throws IOException
    {
        if (id == null) {
            objeto.setId(id = UUID.randomUUID().toString());
        }

        Persistencia.escribirXml(ruta + "/" + id + ".xml", objeto);
    }

    /**
     * crea o sobre escribe un recurso
     *
     * @param objeto objeto para el recurso
     *
     * @throws IOException
     */
    public void escribir(T objeto) throws IOException
    {
        this.escribir(objeto.getId(), objeto);
    }

    /**
     * elimina un recurso dado su identificador
     *
     * @param id identificador del recurso
     */
    public boolean eliminar(String id)
    {
        return new File(ruta + "/" + id + ".xml").delete();
    }
}