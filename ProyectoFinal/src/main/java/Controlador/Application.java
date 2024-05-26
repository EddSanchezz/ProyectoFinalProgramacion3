/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.io.IOException;
import java.util.ArrayList;

import Utilidades.FuncionesEvento;
import Utilidades.Persistencia;

/**
 *
 * @author Esteban S.
 */
public class Application {
    
    public static void main(String[] args) throws IOException {
        ArrayList<ArrayList<String>>eventos = FuncionesEvento.CatalogoEventos();
        System.out.println(eventos.get(0).get(0));
    }
    
}
