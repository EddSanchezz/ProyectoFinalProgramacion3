package Utilidades;

import java.io.IOException;

import Modelo.Administrador;
import Modelo.Usuario;
import Persistencia.Repositorio;

public class FuncionesAdmin {
	
	/**
     * metodo dedicado a verificar si el administrador esta en la base de datos
     * @param correo
     * @param clave
     * @return
     */
	public static void registrarArdmin(Administrador admin) {
        Repositorio<Administrador> repo = Administrador.repositorio();
        
		admin.setId(null);
        try {
			repo.escribir(admin);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
     * metodo dedicado a verificar si el usuario esta en la base de datos
     * @param correo
     * @param clave
     * @return
     */
    public static boolean verificarAdmin(String correo, String clave) {
    	boolean acceso = false;
    	Repositorio<Administrador> repo = Administrador.repositorio();

        try {
			for (Administrador u: repo.todos()) {
			    if (u.getCorreo().equals(correo) && u.getClave().equals(clave)) {
			        acceso = true;
			    }
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        return acceso;
    }

}
