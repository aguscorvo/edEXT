package publicadores;

public class ControladorListarResultadosInscripcionesPublishProxy implements publicadores.ControladorListarResultadosInscripcionesPublish {
  private String _endpoint = null;
  private publicadores.ControladorListarResultadosInscripcionesPublish controladorListarResultadosInscripcionesPublish = null;
  
  public ControladorListarResultadosInscripcionesPublishProxy() {
    _initControladorListarResultadosInscripcionesPublishProxy();
  }
  
  public ControladorListarResultadosInscripcionesPublishProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorListarResultadosInscripcionesPublishProxy();
  }
  
  private void _initControladorListarResultadosInscripcionesPublishProxy() {
    try {
      controladorListarResultadosInscripcionesPublish = (new publicadores.ControladorListarResultadosInscripcionesPublishServiceLocator()).getControladorListarResultadosInscripcionesPublishPort();
      if (controladorListarResultadosInscripcionesPublish != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorListarResultadosInscripcionesPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorListarResultadosInscripcionesPublish)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorListarResultadosInscripcionesPublish != null)
      ((javax.xml.rpc.Stub)controladorListarResultadosInscripcionesPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorListarResultadosInscripcionesPublish getControladorListarResultadosInscripcionesPublish() {
    if (controladorListarResultadosInscripcionesPublish == null)
      _initControladorListarResultadosInscripcionesPublishProxy();
    return controladorListarResultadosInscripcionesPublish;
  }
  
  public java.lang.String inscripcionesPendientes(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorListarResultadosInscripcionesPublish == null)
      _initControladorListarResultadosInscripcionesPublishProxy();
    return controladorListarResultadosInscripcionesPublish.inscripcionesPendientes(arg0);
  }
  
  public java.lang.String inscripcionesRechazadas(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorListarResultadosInscripcionesPublish == null)
      _initControladorListarResultadosInscripcionesPublishProxy();
    return controladorListarResultadosInscripcionesPublish.inscripcionesRechazadas(arg0);
  }
  
  public java.lang.String inscripcionesAceptadas(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorListarResultadosInscripcionesPublish == null)
      _initControladorListarResultadosInscripcionesPublishProxy();
    return controladorListarResultadosInscripcionesPublish.inscripcionesAceptadas(arg0);
  }
  
  
}