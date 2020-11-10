package publicadores;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatype.DtCursoExp;
import datatype.DtProgFormacionExp;
import interfaces.Fabrica;
import interfaces.IControladorConsultaProgFormacion;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle= ParameterStyle.WRAPPED)
public class ControladorConsultaProgFormacionPublish {
	
	private Fabrica fabrica;
	private IControladorConsultaProgFormacion icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorConsultaProgFormacionPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorConsultaProgFormacion();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorConsultaProgFormacion", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorConsultaProgFormacion");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	@WebMethod
	public String[] getProgramasDeFormacion() {
		return icon.getProgramasDeFormacion();
	}
	
	@WebMethod
	public String[] getCategoriasPrograma (String programa) {
		return icon.getCategoriasPrograma(programa);
	}
	
	@WebMethod
	public DtProgFormacionExp seleccionarPrograma(String programa) {
		return icon.seleccionarPrograma(programa);
	}
	
	@WebMethod
	public DtCursoExp seleccionarCurso(String curso) {
		return icon.seleccionarCurso(curso);
	}
	
	@WebMethod
	public String [] getCursos(DtProgFormacionExp dtProg) {
		return icon.getCursos(dtProg);
	}

	@WebMethod
	public String obtenerDatosPrograma(DtProgFormacionExp programa) {
		return icon.obtenerDatosPrograma(programa);
	}
	
	@WebMethod
	public String obtenerDatosCurso(DtCursoExp curso) {
		return icon.obtenerDatosCurso(curso);
	}

}
