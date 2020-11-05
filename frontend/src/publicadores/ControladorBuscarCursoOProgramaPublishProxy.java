package publicadores;

public class ControladorBuscarCursoOProgramaPublishProxy implements publicadores.ControladorBuscarCursoOProgramaPublish {
  private String _endpoint = null;
  private publicadores.ControladorBuscarCursoOProgramaPublish controladorBuscarCursoOProgramaPublish = null;
  
  public ControladorBuscarCursoOProgramaPublishProxy() {
    _initControladorBuscarCursoOProgramaPublishProxy();
  }
  
  public ControladorBuscarCursoOProgramaPublishProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorBuscarCursoOProgramaPublishProxy();
  }
  
  private void _initControladorBuscarCursoOProgramaPublishProxy() {
    try {
      controladorBuscarCursoOProgramaPublish = (new publicadores.ControladorBuscarCursoOProgramaPublishServiceLocator()).getControladorBuscarCursoOProgramaPublishPort();
      if (controladorBuscarCursoOProgramaPublish != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorBuscarCursoOProgramaPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorBuscarCursoOProgramaPublish)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorBuscarCursoOProgramaPublish != null)
      ((javax.xml.rpc.Stub)controladorBuscarCursoOProgramaPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorBuscarCursoOProgramaPublish getControladorBuscarCursoOProgramaPublish() {
    if (controladorBuscarCursoOProgramaPublish == null)
      _initControladorBuscarCursoOProgramaPublishProxy();
    return controladorBuscarCursoOProgramaPublish;
  }
  
  public publicadores.DtCurso[] buscarCursos(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorBuscarCursoOProgramaPublish == null)
      _initControladorBuscarCursoOProgramaPublishProxy();
    return controladorBuscarCursoOProgramaPublish.buscarCursos(arg0);
  }
  
  public publicadores.DtProgFormacion[] buscarProgramas(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorBuscarCursoOProgramaPublish == null)
      _initControladorBuscarCursoOProgramaPublishProxy();
    return controladorBuscarCursoOProgramaPublish.buscarProgramas(arg0);
  }
  
  public publicadores.DtCurso[] ordenarCursosAlfabeticamente(publicadores.ArrayList arg0) throws java.rmi.RemoteException{
    if (controladorBuscarCursoOProgramaPublish == null)
      _initControladorBuscarCursoOProgramaPublishProxy();
    return controladorBuscarCursoOProgramaPublish.ordenarCursosAlfabeticamente(arg0);
  }
  
  public publicadores.DtCurso[] ordenarCursosPorFecha(publicadores.ArrayList arg0) throws java.rmi.RemoteException{
    if (controladorBuscarCursoOProgramaPublish == null)
      _initControladorBuscarCursoOProgramaPublishProxy();
    return controladorBuscarCursoOProgramaPublish.ordenarCursosPorFecha(arg0);
  }
  
  public publicadores.DtProgFormacion[] ordenarProgramasAlfabeticamente(publicadores.ArrayList arg0) throws java.rmi.RemoteException{
    if (controladorBuscarCursoOProgramaPublish == null)
      _initControladorBuscarCursoOProgramaPublishProxy();
    return controladorBuscarCursoOProgramaPublish.ordenarProgramasAlfabeticamente(arg0);
  }
  
  public publicadores.DtProgFormacion[] ordenarProgramasPorFecha(publicadores.ArrayList arg0) throws java.rmi.RemoteException{
    if (controladorBuscarCursoOProgramaPublish == null)
      _initControladorBuscarCursoOProgramaPublishProxy();
    return controladorBuscarCursoOProgramaPublish.ordenarProgramasPorFecha(arg0);
  }
  
  
}