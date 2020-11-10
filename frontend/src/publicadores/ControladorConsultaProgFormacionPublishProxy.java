package publicadores;

public class ControladorConsultaProgFormacionPublishProxy implements publicadores.ControladorConsultaProgFormacionPublish {
  private String _endpoint = null;
  private publicadores.ControladorConsultaProgFormacionPublish controladorConsultaProgFormacionPublish = null;
  
  public ControladorConsultaProgFormacionPublishProxy() {
    _initControladorConsultaProgFormacionPublishProxy();
  }
  
  public ControladorConsultaProgFormacionPublishProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorConsultaProgFormacionPublishProxy();
  }
  
  private void _initControladorConsultaProgFormacionPublishProxy() {
    try {
      controladorConsultaProgFormacionPublish = (new publicadores.ControladorConsultaProgFormacionPublishServiceLocator()).getControladorConsultaProgFormacionPublishPort();
      if (controladorConsultaProgFormacionPublish != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorConsultaProgFormacionPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorConsultaProgFormacionPublish)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorConsultaProgFormacionPublish != null)
      ((javax.xml.rpc.Stub)controladorConsultaProgFormacionPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorConsultaProgFormacionPublish getControladorConsultaProgFormacionPublish() {
    if (controladorConsultaProgFormacionPublish == null)
      _initControladorConsultaProgFormacionPublishProxy();
    return controladorConsultaProgFormacionPublish;
  }
  
  public java.lang.String[] getCursos(publicadores.DtProgFormacionExp arg0) throws java.rmi.RemoteException{
    if (controladorConsultaProgFormacionPublish == null)
      _initControladorConsultaProgFormacionPublishProxy();
    return controladorConsultaProgFormacionPublish.getCursos(arg0);
  }
  
  public java.lang.String obtenerDatosCurso(publicadores.DtCursoExp arg0) throws java.rmi.RemoteException{
    if (controladorConsultaProgFormacionPublish == null)
      _initControladorConsultaProgFormacionPublishProxy();
    return controladorConsultaProgFormacionPublish.obtenerDatosCurso(arg0);
  }
  
  public java.lang.String obtenerDatosPrograma(publicadores.DtProgFormacionExp arg0) throws java.rmi.RemoteException{
    if (controladorConsultaProgFormacionPublish == null)
      _initControladorConsultaProgFormacionPublishProxy();
    return controladorConsultaProgFormacionPublish.obtenerDatosPrograma(arg0);
  }
  
  public publicadores.DtProgFormacionExp seleccionarPrograma(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorConsultaProgFormacionPublish == null)
      _initControladorConsultaProgFormacionPublishProxy();
    return controladorConsultaProgFormacionPublish.seleccionarPrograma(arg0);
  }
  
  public java.lang.String[] getProgramasDeFormacion() throws java.rmi.RemoteException{
    if (controladorConsultaProgFormacionPublish == null)
      _initControladorConsultaProgFormacionPublishProxy();
    return controladorConsultaProgFormacionPublish.getProgramasDeFormacion();
  }
  
  public java.lang.String[] getCategoriasPrograma(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorConsultaProgFormacionPublish == null)
      _initControladorConsultaProgFormacionPublishProxy();
    return controladorConsultaProgFormacionPublish.getCategoriasPrograma(arg0);
  }
  
  public publicadores.DtCursoExp seleccionarCurso(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorConsultaProgFormacionPublish == null)
      _initControladorConsultaProgFormacionPublishProxy();
    return controladorConsultaProgFormacionPublish.seleccionarCurso(arg0);
  }
  
  
}