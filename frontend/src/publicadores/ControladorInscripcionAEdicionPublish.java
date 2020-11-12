/**
 * ControladorInscripcionAEdicionPublish.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorInscripcionAEdicionPublish extends java.rmi.Remote {
    public java.lang.String obtenerDatosBasicosEd() throws java.rmi.RemoteException;
    public java.lang.String[] getCategoriasGlobal() throws java.rmi.RemoteException;
    public java.lang.String[] getCursosPorCategoria(java.lang.String arg0) throws java.rmi.RemoteException;
    public boolean tieneInscripcion() throws java.rmi.RemoteException;
    public publicadores.EstadoInscripcion chequearEstudianteEdicion() throws java.rmi.RemoteException;
    public java.lang.String[] getCursos(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String ingresarCurso(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.NoExisteEdicionVigenteException;
    public java.lang.String[] ingresarInstituto(java.lang.String arg0) throws java.rmi.RemoteException;
    public void cancelarInscripcionAEdicion() throws java.rmi.RemoteException;
    public void ingresarEstudiante(java.lang.String arg0, java.util.Date arg1) throws java.rmi.RemoteException;
    public void confirmarInscripcionAEdicion() throws java.rmi.RemoteException;
    public java.lang.String[] getEstudiantes(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] getInstitutos() throws java.rmi.RemoteException;
}
