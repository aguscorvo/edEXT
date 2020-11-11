package publicadores;

public class ControladorListarAceptadosPublishProxy implements publicadores.ControladorListarAceptadosPublish {
  private String _endpoint = null;
  private publicadores.ControladorListarAceptadosPublish controladorListarAceptadosPublish = null;
  
  public ControladorListarAceptadosPublishProxy() {
    _initControladorListarAceptadosPublishProxy();
  }
  
  public ControladorListarAceptadosPublishProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorListarAceptadosPublishProxy();
  }
  
  private void _initControladorListarAceptadosPublishProxy() {
    try {
      controladorListarAceptadosPublish = (new publicadores.ControladorListarAceptadosPublishServiceLocator()).getControladorListarAceptadosPublishPort();
      if (controladorListarAceptadosPublish != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorListarAceptadosPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorListarAceptadosPublish)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorListarAceptadosPublish != null)
      ((javax.xml.rpc.Stub)controladorListarAceptadosPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorListarAceptadosPublish getControladorListarAceptadosPublish() {
    if (controladorListarAceptadosPublish == null)
      _initControladorListarAceptadosPublishProxy();
    return controladorListarAceptadosPublish;
  }
  
  public java.lang.String obtenerDatosBasicosEd() throws java.rmi.RemoteException{
    if (controladorListarAceptadosPublish == null)
      _initControladorListarAceptadosPublishProxy();
    return controladorListarAceptadosPublish.obtenerDatosBasicosEd();
  }
  
  public java.lang.String getEstudiantesAceptados() throws java.rmi.RemoteException{
    if (controladorListarAceptadosPublish == null)
      _initControladorListarAceptadosPublishProxy();
    return controladorListarAceptadosPublish.getEstudiantesAceptados();
  }
  
  public java.lang.String ingresarCurso(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, publicadores.NoEsProfesorDeEdicionVigenteException, publicadores.NoExisteEdicionVigenteException{
    if (controladorListarAceptadosPublish == null)
      _initControladorListarAceptadosPublishProxy();
    return controladorListarAceptadosPublish.ingresarCurso(arg0, arg1);
  }
  
  public java.lang.String[] ingresarInstituto(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorListarAceptadosPublish == null)
      _initControladorListarAceptadosPublishProxy();
    return controladorListarAceptadosPublish.ingresarInstituto(arg0);
  }
  
  public java.lang.String[] getInstitutos() throws java.rmi.RemoteException{
    if (controladorListarAceptadosPublish == null)
      _initControladorListarAceptadosPublishProxy();
    return controladorListarAceptadosPublish.getInstitutos();
  }
  
  
}