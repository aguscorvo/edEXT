package publicadores;

public class ControladorInscripcionAProgramaPublishProxy implements publicadores.ControladorInscripcionAProgramaPublish {
  private String _endpoint = null;
  private publicadores.ControladorInscripcionAProgramaPublish controladorInscripcionAProgramaPublish = null;
  
  public ControladorInscripcionAProgramaPublishProxy() {
    _initControladorInscripcionAProgramaPublishProxy();
  }
  
  public ControladorInscripcionAProgramaPublishProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorInscripcionAProgramaPublishProxy();
  }
  
  private void _initControladorInscripcionAProgramaPublishProxy() {
    try {
      controladorInscripcionAProgramaPublish = (new publicadores.ControladorInscripcionAProgramaPublishServiceLocator()).getControladorInscripcionAProgramaPublishPort();
      if (controladorInscripcionAProgramaPublish != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorInscripcionAProgramaPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorInscripcionAProgramaPublish)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorInscripcionAProgramaPublish != null)
      ((javax.xml.rpc.Stub)controladorInscripcionAProgramaPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorInscripcionAProgramaPublish getControladorInscripcionAProgramaPublish() {
    if (controladorInscripcionAProgramaPublish == null)
      _initControladorInscripcionAProgramaPublishProxy();
    return controladorInscripcionAProgramaPublish;
  }
  
  public boolean confirmarInscripcion(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (controladorInscripcionAProgramaPublish == null)
      _initControladorInscripcionAProgramaPublishProxy();
    return controladorInscripcionAProgramaPublish.confirmarInscripcion(arg0, arg1);
  }
  
  public java.lang.String[] getProgramas() throws java.rmi.RemoteException{
    if (controladorInscripcionAProgramaPublish == null)
      _initControladorInscripcionAProgramaPublishProxy();
    return controladorInscripcionAProgramaPublish.getProgramas();
  }
  
  
}