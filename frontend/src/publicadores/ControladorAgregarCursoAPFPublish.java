/**
 * ControladorAgregarCursoAPFPublish.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorAgregarCursoAPFPublish extends java.rmi.Remote {
    public java.lang.String[] getCursos() throws java.rmi.RemoteException;
    public java.lang.String[] getProgramas() throws java.rmi.RemoteException;
    public void seleccionarPrograma(java.lang.String arg0) throws java.rmi.RemoteException;
    public void seleccionarCurso(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.CursoEnPFRepetidoException;
}
