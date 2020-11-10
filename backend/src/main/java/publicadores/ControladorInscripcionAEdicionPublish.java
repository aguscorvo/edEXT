package publicadores;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatype.EstadoInscripcion;
import excepciones.NoExisteEdicionVigenteException;
import interfaces.Fabrica;
import interfaces.IControladorInscripcionAEdicion;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle= ParameterStyle.WRAPPED)
public class ControladorInscripcionAEdicionPublish {
	private Fabrica fabrica;
	private IControladorInscripcionAEdicion icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;
	private String edicion;
	private String nick;
	private Date fecha;

	public ControladorInscripcionAEdicionPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorInscripcionAEdicion();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorInscripcionAEdicion", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorInscripcionAEdicion");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	@WebMethod
	public String [] ingresarInstituto(String instituto) {
		return icon.ingresarInstituto(instituto);
	}
	
	@WebMethod
	public String[] getCategoriasGlobal() {
		return icon.getCategoriasGlobal();
	}
	
	@WebMethod
	public String[] getCursosPorCategoria(String categoria) {
		return icon.getCursosPorCategoria(categoria);
	}
	
	@WebMethod
	public String ingresarCurso(String curso) throws NoExisteEdicionVigenteException{
		return icon.ingresarCurso(curso);
	}
	
	@WebMethod
	public String obtenerDatosBasicosEd() {
		return icon.obtenerDatosBasicosEd();
	}
	
	@WebMethod
	public void ingresarEstudiante(String nick, Date fecha) {
		icon.ingresarEstudiante(nick, fecha);
	}
	
	@WebMethod
	public void confirmarInscripcionAEdicion() {
		icon.confirmarInscripcionAEdicion();
	}
	
	@WebMethod
	public void cancelarInscripcionAEdicion(){
		icon.cancelarInscripcionAEdicion();
	}
	
	@WebMethod
	public String[] getInstitutos() {
		return icon.getInstitutos();
	}
	
	@WebMethod
	public String[] getCursos(String instituto) {
		return icon.getCursos(instituto);
	}
	
	@WebMethod
	public String [] getEstudiantes(String edicion) {
		return icon.getEstudiantes(edicion);
	}
	
	@WebMethod
	public EstadoInscripcion chequearEstudianteEdicion() {
		return icon.chequearEstudianteEdicion();
	}
	
}
