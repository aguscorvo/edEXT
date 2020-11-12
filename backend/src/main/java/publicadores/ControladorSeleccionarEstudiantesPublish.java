package publicadores;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatype.EstadoInscripcion;
import excepciones.NoEsProfesorDeEdicionVigenteException;
import excepciones.NoExisteEdicionVigenteException;
import interfaces.Fabrica;
import interfaces.IControladorSeleccionarEstudiantes;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle= ParameterStyle.WRAPPED)
public class ControladorSeleccionarEstudiantesPublish {

	
	private Fabrica fabrica;
	private IControladorSeleccionarEstudiantes icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorSeleccionarEstudiantesPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorSeleccionarEstudiantes();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorSeleccionarEstudiantes", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorSeleccionarEstudiantes");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	
	@WebMethod
	public String[] getInstitutos() {
		return icon.getInstitutos();
	}
	
	@WebMethod
    public String[] ingresarInstituto(String instituto) {
		return icon.ingresarInstituto(instituto);
	}
	
	@WebMethod	
	public String ingresarCurso(String curso, String docente) throws NoExisteEdicionVigenteException, NoEsProfesorDeEdicionVigenteException{
		return icon.ingresarCurso(curso, docente);
	}
	
	@WebMethod
	public String obtenerDatosBasicosEd() {
		return icon.obtenerDatosBasicosEd();
	}
	
	@WebMethod
	public String [] getEstudiantes() {
		return icon.getEstudiantes();
	}
	
	@WebMethod
	public boolean esDocenteEdicion (String docente, String edicion) {
		return icon.esDocenteEdicion(docente, edicion);
	}
	
	@WebMethod
	public EstadoInscripcion [] getEstadosSegunEstudiantes (String [] estudiantes) {
		return icon.getEstadosSegunEstudiantes(estudiantes);
	}
	
	@WebMethod
	public void confirmarSeleccionarEstudiantes (String [] estudiantes, EstadoInscripcion ei, String edi) {
		icon.confirmarSeleccionarEstudiantes(estudiantes, ei, edi);
	}


	
}
