package publicadores;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatype.DtCursoExp;
import datatype.DtEdicion;
import datatype.DtProgFormacionExp;
import interfaces.Fabrica;
import interfaces.IControladorConsultaCurso;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle= ParameterStyle.WRAPPED)
public class ControladorConsultaCursoPublish {

	private Fabrica fabrica;
	private IControladorConsultaCurso icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorConsultaCursoPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorConsultaCurso();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorConsultaCurso", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorConsultaCurso");
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
	public String[] getCursosPorCategoria(String categoria) {
		return icon.getCursosPorCategoria(categoria);
	}
	public String[] getCategoriasGlobal() {
		return icon.getCategoriasGlobal();
	}
	public String [] ingresarInstituto(String instituto) {
		return icon.ingresarInstituto(instituto);
	}
	public DtCursoExp seleccionarCurso(String curso) {
		return icon.seleccionarCurso(curso);
	}
	public DtEdicion seleccionarEdicion(String edicion) {
		return icon.seleccionarEdicion(edicion);
	}
	public DtProgFormacionExp seleccionarProgFormacion(String progFormacion) {
		return icon.seleccionarProgFormacion(progFormacion);
	}
	public String [] getPrevias (String curso) {
		return icon.getPrevias(curso);
	}
	public String [] getCategorias (String curso) {
		return icon.getCategorias(curso);
	}
	public String[] getEdiciones (String curso) {
		return icon.getEdiciones(curso);
	}
	public String[] getPFs (String curso) {
		return icon.getPFs(curso);
	}
	public String obtenerDatosCurso(DtCursoExp curso) {
		return icon.obtenerDatosCurso(curso);
	}
	public String obtenerDatosEdicion(DtEdicion edicion) {
		return icon.obtenerDatosEdicion(edicion);
	}
	public String obtenerDatosPrograma(DtProgFormacionExp programa) {
		return icon.obtenerDatosPrograma(programa);
	}

	
	
	
}
