/**
 * ControladorSeleccionarEstudiantesPublish.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorSeleccionarEstudiantesPublish extends java.rmi.Remote {
    public java.lang.String obtenerDatosBasicosEd() throws java.rmi.RemoteException;
    public boolean esDocenteEdicion(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public publicadores.EstadoInscripcion[] getEstadosSegunEstudiantes(java.lang.String[] arg0) throws java.rmi.RemoteException;
    public void confirmarSeleccionarEstudiantes(java.lang.String[] arg0, publicadores.EstadoInscripcion arg1, java.lang.String arg2) throws java.rmi.RemoteException;
    public java.lang.String ingresarCurso(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, publicadores.NoEsProfesorDeEdicionVigenteException, publicadores.NoExisteEdicionVigenteException;
    public java.lang.String[] ingresarInstituto(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] getEstudiantes() throws java.rmi.RemoteException;
    public java.lang.String[] getInstitutos() throws java.rmi.RemoteException;
}
