package Persistencia;

public interface Persistible
{
    /**
     * obtiene el identificador/nombre del recurso/archivo
     *
     * @return id of resoruce
     */
    public String getId();

    /**
     * establece el identificador del recurso
     *
     * @param id identificador
     */
    public void setId(String id);
}