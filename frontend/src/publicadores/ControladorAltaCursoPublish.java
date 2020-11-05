/**
 * ControladorAltaCursoPublish.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorAltaCursoPublish extends java.rmi.Remote {
    public java.lang.String[] getCursos() throws java.rmi.RemoteException;
    public java.lang.String[] getCategorias() throws java.rmi.RemoteException;
    public void ingresarCurso(java.lang.String arg0, publicadores.DtCurso arg1) throws java.rmi.RemoteException, publicadores.NoExisteInstitutoException, publicadores.NoExisteCursoException, publicadores.CursoRepetidoException;
    public void confirmarAltaCurso() throws java.rmi.RemoteException;
    public void cancelarAltaCurso() throws java.rmi.RemoteException;
    public java.lang.String[] getInstitutos() throws java.rmi.RemoteException;
}
