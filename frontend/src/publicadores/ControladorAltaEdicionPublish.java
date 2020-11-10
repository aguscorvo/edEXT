/**
 * ControladorAltaEdicionPublish.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorAltaEdicionPublish extends java.rmi.Remote {
    public java.lang.String[] ingresarInstituto(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.NoExisteInstitutoException;
    public java.lang.String[] getCursos(publicadores.Instituto arg0) throws java.rmi.RemoteException;
    public java.lang.String[] getInstitutos() throws java.rmi.RemoteException;
    public java.lang.String[] getDocentes() throws java.rmi.RemoteException;
    public void seleccionarCurso(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.NoExisteCursoException;
    public void ingresarDtEdicion(publicadores.DtEdicionExp arg0) throws java.rmi.RemoteException, publicadores.EdicionRepetidaException;
    public void confirmarAltaEdicion() throws java.rmi.RemoteException;
    public void cancelarAltaEdicion() throws java.rmi.RemoteException;
    public boolean existeInstituto(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.Instituto getInstituto(java.lang.String arg0) throws java.rmi.RemoteException;
}
