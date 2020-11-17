package logica;


import java.util.ArrayList;
import java.util.List;

import datatype.DtDocente;
import datatype.DtEstudiante;
import datatype.DtUsuario;
import excepciones.NoExisteInstitutoException;
import excepciones.UsuarioRepetidoException;
import excepciones.UsuarioRepetidoExceptionMail;
import excepciones.UsuarioRepetidoExceptionNick;
import interfaces.IControladorAltaUsuario;


public class ControladorAltaUsuario implements IControladorAltaUsuario {
	
	private DtUsuario usuario;
	
	public void ingresarDtUsuario(DtUsuario usuario) throws UsuarioRepetidoException{
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		if(mu.existeUsuarioCorreo(usuario.getCorreo())) {
			throw new UsuarioRepetidoException ("Ya existe un usuario con correo '" + usuario.getCorreo() + "' registrado en el sistema.");			
		}
		if(mu.existeUsuarioNick(usuario.getNick())) {
			throw new UsuarioRepetidoException ("Ya existe un usuario con nick '" + usuario.getNick() + "' registrado en el sistema.");
		}
		this.usuario= usuario;		
	}
		
	public void ingresarDtUsuarioFrontEnd(DtUsuario usuario) throws UsuarioRepetidoExceptionNick, UsuarioRepetidoExceptionMail{
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		if(mu.existeUsuarioCorreo(usuario.getCorreo())) {
			throw new UsuarioRepetidoExceptionMail ("Ya existe un usuario con correo '" + usuario.getCorreo() + "' registrado en el sistema.");			
		}
		if(mu.existeUsuarioNick(usuario.getNick())) {
			throw new UsuarioRepetidoExceptionNick ("Ya existe un usuario con nick '" + usuario.getNick() + "' registrado en el sistema.");
		}
		this.usuario= usuario;			
	}
	
	public void ingresarDtEstudianteFrontEnd(DtEstudiante estudiante) throws UsuarioRepetidoExceptionNick, UsuarioRepetidoExceptionMail{
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		if(mu.existeUsuarioCorreo(estudiante.getCorreo())) {
			throw new UsuarioRepetidoExceptionMail ("Ya existe un usuario con correo '" + estudiante.getCorreo() + "' registrado en el sistema.");			
		}
		if(mu.existeUsuarioNick(estudiante.getNick())) {
			throw new UsuarioRepetidoExceptionNick ("Ya existe un usuario con nick '" + estudiante.getNick() + "' registrado en el sistema.");
		}
		this.usuario= estudiante;			
	}

	public void ingresarDtDocenteFrontEnd(DtDocente usuario) throws UsuarioRepetidoExceptionNick, UsuarioRepetidoExceptionMail{
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		if(mu.existeUsuarioCorreo(usuario.getCorreo())) {
			throw new UsuarioRepetidoExceptionMail ("Ya existe un usuario con correo '" + usuario.getCorreo() + "' registrado en el sistema.");			
		}
		if(mu.existeUsuarioNick(usuario.getNick())) {
			throw new UsuarioRepetidoExceptionNick ("Ya existe un usuario con nick '" + usuario.getNick() + "' registrado en el sistema.");
		}
		this.usuario= usuario;			
	}

	public void confirmarAltaUsuario() throws NoExisteInstitutoException{
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		if (usuario instanceof DtDocente) {
			ManejadorInstituto mi = ManejadorInstituto.getInstancia();
			if(!mi.existeInstituto(((DtDocente)usuario).getInstituto())){
				throw new NoExisteInstitutoException("El instituto '" + ((DtDocente)usuario).getInstituto() + "'no se encuentra registrado en el sistema."); 
			}
			Instituto inst = mi.getInstituto(((DtDocente) usuario).getInstituto());
			List<Edicion> aux = new ArrayList<Edicion>(); 
			Docente d= new Docente(usuario.getNick(), usuario.getNombre(), usuario.getApellido(), usuario.getCorreo(), usuario.getFechaNac(), usuario.getPassword(), inst, aux);
			mu.agregarUsuario(d);

		}
		if (usuario instanceof DtEstudiante) {
			List<InscripcionEd> ie = new ArrayList<InscripcionEd>();
			List<InscripcionPF> ip = new ArrayList<InscripcionPF>();
			Estudiante e= new Estudiante(usuario.getNick(), usuario.getNombre(), usuario.getApellido(), usuario.getCorreo(), usuario.getFechaNac(), usuario.getPassword(), ie, ip);
			mu.agregarUsuario(e);
		}		
		
	};
	
	public void cancelarAltaUsuario(){};
	
	public String[] getInstitutos(){
		
		ManejadorInstituto mi = ManejadorInstituto.getInstancia();		
		
		List<Instituto> institutos = mi.getInstitutos();
		
		String [] arrInstitutos = new String [institutos.size()];
		
		int i=0;		
		for(Instituto ins: institutos) {
			arrInstitutos[i] = ins.getNombre();
			i++;
		}
		return arrInstitutos;		
		
	}
	
	public boolean existeUsuarioNick(String nick) {
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		if (mu.existeUsuarioNick(nick))
			return true;
		else return false;
	}
	
	public boolean existeUsuarioCorreo(String correo) {
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		if (mu.existeUsuarioCorreo(correo))
			return true;
		else return false;
	}
	
}
