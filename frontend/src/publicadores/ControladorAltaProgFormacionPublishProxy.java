package publicadores;

public class ControladorAltaProgFormacionPublishProxy implements publicadores.ControladorAltaProgFormacionPublish {
  private String _endpoint = null;
  private publicadores.ControladorAltaProgFormacionPublish controladorAltaProgFormacionPublish = null;
  
  public ControladorAltaProgFormacionPublishProxy() {
    _initControladorAltaProgFormacionPublishProxy();
  }
  
  public ControladorAltaProgFormacionPublishProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorAltaProgFormacionPublishProxy();
  }
  
  private void _initControladorAltaProgFormacionPublishProxy() {
    try {
      controladorAltaProgFormacionPublish = (new publicadores.ControladorAltaProgFormacionPublishServiceLocator()).getControladorAltaProgFormacionPublishPort();
      if (controladorAltaProgFormacionPublish != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorAltaProgFormacionPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorAltaProgFormacionPublish)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorAltaProgFormacionPublish != null)
      ((javax.xml.rpc.Stub)controladorAltaProgFormacionPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorAltaProgFormacionPublish getControladorAltaProgFormacionPublish() {
    if (controladorAltaProgFormacionPublish == null)
      _initControladorAltaProgFormacionPublishProxy();
    return controladorAltaProgFormacionPublish;
  }
  
  public void ingresarProgFormacion(publicadores.DtProgFormacion arg0) throws java.rmi.RemoteException, publicadores.ProgramaRepetidoException{
    if (controladorAltaProgFormacionPublish == null)
      _initControladorAltaProgFormacionPublishProxy();
    controladorAltaProgFormacionPublish.ingresarProgFormacion(arg0);
  }
  
  public void confirmarAltaPrograma() throws java.rmi.RemoteException{
    if (controladorAltaProgFormacionPublish == null)
      _initControladorAltaProgFormacionPublishProxy();
    controladorAltaProgFormacionPublish.confirmarAltaPrograma();
  }
  
  public void cancelarAltaPrograma() throws java.rmi.RemoteException{
    if (controladorAltaProgFormacionPublish == null)
      _initControladorAltaProgFormacionPublishProxy();
    controladorAltaProgFormacionPublish.cancelarAltaPrograma();
  }
  
  
}