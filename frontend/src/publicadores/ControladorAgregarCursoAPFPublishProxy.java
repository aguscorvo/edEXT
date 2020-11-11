package publicadores;

public class ControladorAgregarCursoAPFPublishProxy implements publicadores.ControladorAgregarCursoAPFPublish {
  private String _endpoint = null;
  private publicadores.ControladorAgregarCursoAPFPublish controladorAgregarCursoAPFPublish = null;
  
  public ControladorAgregarCursoAPFPublishProxy() {
    _initControladorAgregarCursoAPFPublishProxy();
  }
  
  public ControladorAgregarCursoAPFPublishProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorAgregarCursoAPFPublishProxy();
  }
  
  private void _initControladorAgregarCursoAPFPublishProxy() {
    try {
      controladorAgregarCursoAPFPublish = (new publicadores.ControladorAgregarCursoAPFPublishServiceLocator()).getControladorAgregarCursoAPFPublishPort();
      if (controladorAgregarCursoAPFPublish != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorAgregarCursoAPFPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorAgregarCursoAPFPublish)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorAgregarCursoAPFPublish != null)
      ((javax.xml.rpc.Stub)controladorAgregarCursoAPFPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorAgregarCursoAPFPublish getControladorAgregarCursoAPFPublish() {
    if (controladorAgregarCursoAPFPublish == null)
      _initControladorAgregarCursoAPFPublishProxy();
    return controladorAgregarCursoAPFPublish;
  }
  
  public java.lang.String[] getCursos() throws java.rmi.RemoteException{
    if (controladorAgregarCursoAPFPublish == null)
      _initControladorAgregarCursoAPFPublishProxy();
    return controladorAgregarCursoAPFPublish.getCursos();
  }
  
  public java.lang.String[] getProgramas() throws java.rmi.RemoteException{
    if (controladorAgregarCursoAPFPublish == null)
      _initControladorAgregarCursoAPFPublishProxy();
    return controladorAgregarCursoAPFPublish.getProgramas();
  }
  
  public void seleccionarPrograma(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorAgregarCursoAPFPublish == null)
      _initControladorAgregarCursoAPFPublishProxy();
    controladorAgregarCursoAPFPublish.seleccionarPrograma(arg0);
  }
  
  public void seleccionarCurso(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.CursoEnPFRepetidoException{
    if (controladorAgregarCursoAPFPublish == null)
      _initControladorAgregarCursoAPFPublishProxy();
    controladorAgregarCursoAPFPublish.seleccionarCurso(arg0);
  }
  
  
}