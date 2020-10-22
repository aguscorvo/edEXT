package interfaces;
import logica.*;

public class Fabrica {
	private static Fabrica instancia = null;
	
	private Fabrica(){}
	
	public static Fabrica getInstancia() {
		if (instancia == null)
			instancia = new Fabrica();
		return instancia;
	}
	
	
	
	public IControladorAltaInstituto getIControladorAltaInstituto() {
		return new ControladorAltaInstituto();		
	}
	
	
	public IControladorAltaCategoria getIControladorAltaCategoria() {
		return new ControladorAltaCategoria();
	}
	
	
	public IControladorAltaUsuario getIControladorAltaUsuario() {
		return new ControladorAltaUsuario();		
	}
	
	
	public IControladorAltaCurso getIControladorAltaCurso() {
		return new ControladorAltaCurso();
	}
	
	
	public IControladorAltaEdicion getIControladorAltaEdicion() {
		return new ControladorAltaEdicion();
	}
	
	
	public IControladorConsultaEdicion getIControladorConsultaEdicion() {
		return new ControladorConsultaEdicion();
	}
	
	
	public IControladorInscripcionAEdicion getIControladorInscripcionAEdicion() {
		return new ControladorInscripcionAEdicion();
	}
	
	
	public IControladorConsultaCurso getIControladorConsultaCurso() {
		return new ControladorConsultaCurso();		
	}
	
	
	public IControladorAltaProgFormacion getIControladorAltaProgFormacion() {
		return new ControladorAltaProgFormacion();		
	}
	
	
	public IControladorAgregarCursoAPF getIControladorAgregarCursoAPF() {
		return new ControladorAgregarCursoAPF();
	}
	
	public IControladorConsultaProgFormacion getIControladorConsultaProgFormacion() {
		return new ControladorConsultaProgFormacion();
	}
	
	public IControladorModificarDatosUsuario getIControladorModificarDatosUsuario() {
		return new ControladorModificarDatosUsuario();
	}
	
	
	public IControladorConsultaUsuario getIControladorConsultaUsuario() {
		return new ControladorConsultaUsuario();
	}
	
	public IControladorSeleccionarEstudiantes getIControladorSeleccionarEstudiantes() {
		return new ControladorSeleccionarEstudiantes();
	}
	
	public IControladorListarAceptados getIControladorListarAceptados() {
		return new ControladorListarAceptados();
	}
	
	public IControladorIniciarSesion getIControladorIniciarSesion() {
		return new ControladorIniciarSesion();
	}
	
	public IControladorBuscarCursoOPrograma getIControladorBuscarCursoOPrograma() {
		return new ControladorBuscarCursoOPrograma();
	}
	
		
}
