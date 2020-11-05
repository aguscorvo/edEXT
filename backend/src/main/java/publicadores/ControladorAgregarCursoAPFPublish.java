package publicadores;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import excepciones.CursoEnPFRepetidoException;
import interfaces.Fabrica;
import interfaces.IControladorAgregarCursoAPF;
import interfaces.IControladorAltaUsuario;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle= ParameterStyle.WRAPPED)
public class ControladorAgregarCursoAPFPublish {

	
	private Fabrica fabrica;
	private IControladorAgregarCursoAPF icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorAgregarCursoAPFPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorAgregarCursoAPF();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorAgregarCursoAPF", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorAgregarCursoAPF");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	@WebMethod
	public String[] getProgramas() {
		return icon.getProgramas();
	}
	
	@WebMethod
	public void seleccionarPrograma(String nombrePF) {
		icon.seleccionarPrograma(nombrePF);
		
	}
	
	@WebMethod
	public String [] getCursos() {
		return icon.getCursos();
	}
	
	@WebMethod
	public void seleccionarCurso(String nombreC) throws CursoEnPFRepetidoException{
		icon.seleccionarCurso(nombreC);
	}

	
}
