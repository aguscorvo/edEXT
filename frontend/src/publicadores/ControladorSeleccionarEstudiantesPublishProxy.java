package publicadores;

public class ControladorSeleccionarEstudiantesPublishProxy implements publicadores.ControladorSeleccionarEstudiantesPublish {
  private String _endpoint = null;
  private publicadores.ControladorSeleccionarEstudiantesPublish controladorSeleccionarEstudiantesPublish = null;
  
  public ControladorSeleccionarEstudiantesPublishProxy() {
    _initControladorSeleccionarEstudiantesPublishProxy();
  }
  
  public ControladorSeleccionarEstudiantesPublishProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorSeleccionarEstudiantesPublishProxy();
  }
  
  private void _initControladorSeleccionarEstudiantesPublishProxy() {
    try {
      controladorSeleccionarEstudiantesPublish = (new publicadores.ControladorSeleccionarEstudiantesPublishServiceLocator()).getControladorSeleccionarEstudiantesPublishPort();
      if (controladorSeleccionarEstudiantesPublish != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorSeleccionarEstudiantesPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorSeleccionarEstudiantesPublish)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorSeleccionarEstudiantesPublish != null)
      ((javax.xml.rpc.Stub)controladorSeleccionarEstudiantesPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorSeleccionarEstudiantesPublish getControladorSeleccionarEstudiantesPublish() {
    if (controladorSeleccionarEstudiantesPublish == null)
      _initControladorSeleccionarEstudiantesPublishProxy();
    return controladorSeleccionarEstudiantesPublish;
  }
  
  public java.lang.String obtenerDatosBasicosEd() throws java.rmi.RemoteException{
    if (controladorSeleccionarEstudiantesPublish == null)
      _initControladorSeleccionarEstudiantesPublishProxy();
    return controladorSeleccionarEstudiantesPublish.obtenerDatosBasicosEd();
  }
  
  public boolean esDocenteEdicion(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (controladorSeleccionarEstudiantesPublish == null)
      _initControladorSeleccionarEstudiantesPublishProxy();
    return controladorSeleccionarEstudiantesPublish.esDocenteEdicion(arg0, arg1);
  }
  
  public publicadores.EstadoInscripcion[] getEstadosSegunEstudiantes(java.lang.String[] arg0) throws java.rmi.RemoteException{
    if (controladorSeleccionarEstudiantesPublish == null)
      _initControladorSeleccionarEstudiantesPublishProxy();
    return controladorSeleccionarEstudiantesPublish.getEstadosSegunEstudiantes(arg0);
  }
  
  public void confirmarSeleccionarEstudiantes(java.lang.String[] arg0, publicadores.EstadoInscripcion arg1, java.lang.String arg2) throws java.rmi.RemoteException{
    if (controladorSeleccionarEstudiantesPublish == null)
      _initControladorSeleccionarEstudiantesPublishProxy();
    controladorSeleccionarEstudiantesPublish.confirmarSeleccionarEstudiantes(arg0, arg1, arg2);
  }
  
  public java.lang.String ingresarCurso(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, publicadores.NoEsProfesorDeEdicionVigenteException, publicadores.NoExisteEdicionVigenteException{
    if (controladorSeleccionarEstudiantesPublish == null)
      _initControladorSeleccionarEstudiantesPublishProxy();
    return controladorSeleccionarEstudiantesPublish.ingresarCurso(arg0, arg1);
  }
  
  public java.lang.String[] ingresarInstituto(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorSeleccionarEstudiantesPublish == null)
      _initControladorSeleccionarEstudiantesPublishProxy();
    return controladorSeleccionarEstudiantesPublish.ingresarInstituto(arg0);
  }
  
  public java.lang.String[] getEstudiantes() throws java.rmi.RemoteException{
    if (controladorSeleccionarEstudiantesPublish == null)
      _initControladorSeleccionarEstudiantesPublishProxy();
    return controladorSeleccionarEstudiantesPublish.getEstudiantes();
  }
  
  public java.lang.String[] getInstitutos() throws java.rmi.RemoteException{
    if (controladorSeleccionarEstudiantesPublish == null)
      _initControladorSeleccionarEstudiantesPublishProxy();
    return controladorSeleccionarEstudiantesPublish.getInstitutos();
  }
  
  
}