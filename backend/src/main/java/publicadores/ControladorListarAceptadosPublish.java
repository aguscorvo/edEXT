package publicadores;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import excepciones.NoEsProfesorDeEdicionVigenteException;
import excepciones.NoExisteEdicionVigenteException;
import interfaces.Fabrica;
import interfaces.IControladorListarAceptados;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle= ParameterStyle.WRAPPED)
public class ControladorListarAceptadosPublish{
	
	private Fabrica fabrica;
	private IControladorListarAceptados icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorListarAceptadosPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorListarAceptados();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorListarAceptados", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorListarAceptados");
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
	public String getEstudiantesAceptados() {
		return icon.getEstudiantesAceptados();
	}

}
