package logica;


import java.util.ArrayList;
import java.util.List;

import datatype.DtDocente;
import datatype.DtEstudiante;
import datatype.DtUsuario;
import excepciones.CorreoRepetidoException;
import excepciones.UsuarioRepetidoException;
import interfaces.IControladorAltaUsuario;


public class ControladorAltaUsuario implements IControladorAltaUsuario {
	
	private DtUsuario usuario;
	
	public void ingresarDtUsuario(DtUsuario usuario) throws UsuarioRepetidoException, CorreoRepetidoException{
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		if(mu.existeUsuarioCorreo(usuario.getCorreo())) {
			throw new CorreoRepetidoException ("El usuario con correo '" + usuario.getCorreo() + "' ya se encuentra registrado en el sistema.");			
		}
		if(mu.existeUsuarioNick(usuario.getNick())) {
			throw new UsuarioRepetidoException ("El usuario con nick '" + usuario.getNick() + "' ya se encuentra registrado en el sistema.");
		}
		this.usuario= usuario;			
	}
		
	public void confirmarAltaUsuario(){
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		if (usuario instanceof DtDocente) {
			ManejadorInstituto mi = ManejadorInstituto.getInstancia();
			Instituto inst = mi.getInstituto(((DtDocente) usuario).getInstituto());
			List<Edicion> aux = new ArrayList<Edicion>(); 
			Docente d= new Docente(usuario.getNick(), usuario.getNombre(), usuario.getApellido(), usuario.getCorreo(), usuario.getFechaNac(), inst, aux);
			mu.agregarUsuario(d);

		}
		if (usuario instanceof DtEstudiante) {
			List<InscripcionEd> ie = new ArrayList<InscripcionEd>();
			List<InscripcionPF> ip = new ArrayList<InscripcionPF>();
			Estudiante e= new Estudiante(usuario.getNick(), usuario.getNombre(), usuario.getApellido(), usuario.getCorreo(), usuario.getFechaNac(), ie, ip);
			mu.agregarUsuario(e);
		}		
		
	};
	
	public void cancelarAltaUsuario(){};
	
}
