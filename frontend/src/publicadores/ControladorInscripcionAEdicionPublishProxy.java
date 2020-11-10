package publicadores;

public class ControladorInscripcionAEdicionPublishProxy implements publicadores.ControladorInscripcionAEdicionPublish {
  private String _endpoint = null;
  private publicadores.ControladorInscripcionAEdicionPublish controladorInscripcionAEdicionPublish = null;
  
  public ControladorInscripcionAEdicionPublishProxy() {
    _initControladorInscripcionAEdicionPublishProxy();
  }
  
  public ControladorInscripcionAEdicionPublishProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorInscripcionAEdicionPublishProxy();
  }
  
  private void _initControladorInscripcionAEdicionPublishProxy() {
    try {
      controladorInscripcionAEdicionPublish = (new publicadores.ControladorInscripcionAEdicionPublishServiceLocator()).getControladorInscripcionAEdicionPublishPort();
      if (controladorInscripcionAEdicionPublish != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorInscripcionAEdicionPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorInscripcionAEdicionPublish)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorInscripcionAEdicionPublish != null)
      ((javax.xml.rpc.Stub)controladorInscripcionAEdicionPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorInscripcionAEdicionPublish getControladorInscripcionAEdicionPublish() {
    if (controladorInscripcionAEdicionPublish == null)
      _initControladorInscripcionAEdicionPublishProxy();
    return controladorInscripcionAEdicionPublish;
  }
  
  public java.lang.String obtenerDatosBasicosEd() throws java.rmi.RemoteException{
    if (controladorInscripcionAEdicionPublish == null)
      _initControladorInscripcionAEdicionPublishProxy();
    return controladorInscripcionAEdicionPublish.obtenerDatosBasicosEd();
  }
  
  public java.lang.String[] getCategoriasGlobal() throws java.rmi.RemoteException{
    if (controladorInscripcionAEdicionPublish == null)
      _initControladorInscripcionAEdicionPublishProxy();
    return controladorInscripcionAEdicionPublish.getCategoriasGlobal();
  }
  
  public java.lang.String[] getCursosPorCategoria(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorInscripcionAEdicionPublish == null)
      _initControladorInscripcionAEdicionPublishProxy();
    return controladorInscripcionAEdicionPublish.getCursosPorCategoria(arg0);
  }
  
  public publicadores.EstadoInscripcion chequearEstudianteEdicion() throws java.rmi.RemoteException{
    if (controladorInscripcionAEdicionPublish == null)
      _initControladorInscripcionAEdicionPublishProxy();
    return controladorInscripcionAEdicionPublish.chequearEstudianteEdicion();
  }
  
  public java.lang.String[] ingresarInstituto(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorInscripcionAEdicionPublish == null)
      _initControladorInscripcionAEdicionPublishProxy();
    return controladorInscripcionAEdicionPublish.ingresarInstituto(arg0);
  }
  
  public java.lang.String[] getInstitutos() throws java.rmi.RemoteException{
    if (controladorInscripcionAEdicionPublish == null)
      _initControladorInscripcionAEdicionPublishProxy();
    return controladorInscripcionAEdicionPublish.getInstitutos();
  }
  
  public void cancelarInscripcionAEdicion() throws java.rmi.RemoteException{
    if (controladorInscripcionAEdicionPublish == null)
      _initControladorInscripcionAEdicionPublishProxy();
    controladorInscripcionAEdicionPublish.cancelarInscripcionAEdicion();
  }
  
  public void ingresarEstudiante(java.lang.String arg0, java.util.Date arg1) throws java.rmi.RemoteException{
    if (controladorInscripcionAEdicionPublish == null)
      _initControladorInscripcionAEdicionPublishProxy();
    controladorInscripcionAEdicionPublish.ingresarEstudiante(arg0, arg1);
  }
  
  public void confirmarInscripcionAEdicion() throws java.rmi.RemoteException{
    if (controladorInscripcionAEdicionPublish == null)
      _initControladorInscripcionAEdicionPublishProxy();
    controladorInscripcionAEdicionPublish.confirmarInscripcionAEdicion();
  }
  
  public java.lang.String[] getEstudiantes(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorInscripcionAEdicionPublish == null)
      _initControladorInscripcionAEdicionPublishProxy();
    return controladorInscripcionAEdicionPublish.getEstudiantes(arg0);
  }
  
  public java.lang.String[] getCursos(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorInscripcionAEdicionPublish == null)
      _initControladorInscripcionAEdicionPublishProxy();
    return controladorInscripcionAEdicionPublish.getCursos(arg0);
  }
  
  public java.lang.String ingresarCurso(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.NoExisteEdicionVigenteException{
    if (controladorInscripcionAEdicionPublish == null)
      _initControladorInscripcionAEdicionPublishProxy();
    return controladorInscripcionAEdicionPublish.ingresarCurso(arg0);
  }
  
  
}