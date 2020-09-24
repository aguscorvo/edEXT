package logica;

import java.util.List;

import javax.persistence.EntityManager;

import datatype.DtUsuario;
import interfaces.IControladorModificarDatosUsuario;
import persistencia.Conexion;

public class ControladorModificarDatosUsuario implements IControladorModificarDatosUsuario{
	
	public String [] getUsuarios() {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		List <Usuario> usuarios = mU.getUsuarios();
		String [] arrVacio = {""};
		
		if (!usuarios.isEmpty()) {
			String [] arrUsuarios = new String [usuarios.size()];
			int i=0;
			for (Usuario u: usuarios) {
				arrUsuarios[i]=u.getNick();
				i++;
			}
			return arrUsuarios;
		}
		return arrVacio;
	}
	
	public DtUsuario seleccionarUsuario(String nick) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario auxUsuario = mU.getUsuario(nick);
		DtUsuario dt = new DtUsuario (auxUsuario.getNick(), auxUsuario.getNombre(), auxUsuario.getApellido(), auxUsuario.getCorreo(), 
		auxUsuario.getFechaNac(), auxUsuario.getPassword());
		return dt;
	}
	
	public void modificarDatosUsuario(DtUsuario datos) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario auxUsuario = mU.getUsuario(datos.getNick());
		auxUsuario.setNombre(datos.getNombre());
		auxUsuario.setApellido(datos.getApellido());
		auxUsuario.setFechaNac(datos.getFechaNac());
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.merge(auxUsuario);
		em.getTransaction().commit();		
	}

}
