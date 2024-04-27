/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author metzu
 */
public class Administrador extends Usuario{
    
    private String codigoAdmin;

    public Administrador(String nombre, String correo, String clave, String codigo) {
        super(nombre, correo, clave);
        this.codigoAdmin = codigo;
    }

    public String getCodigo() {
        return codigoAdmin;
    }

    public void setCodigo(String codigo) {
        this.codigoAdmin = codigo;
    }

    
}
