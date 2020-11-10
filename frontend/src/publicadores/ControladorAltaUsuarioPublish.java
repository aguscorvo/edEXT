/**
 * ControladorAltaUsuarioPublish.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorAltaUsuarioPublish extends java.rmi.Remote {
    public void ingresarDtUsuarioFrontEnd(publicadores.DtUsuario arg0) throws java.rmi.RemoteException, publicadores.UsuarioRepetidoExceptionNick, publicadores.UsuarioRepetidoExceptionMail;
    public void ingresarDtEstudianteFrontEnd(publicadores.DtEstudiante arg0) throws java.rmi.RemoteException, publicadores.UsuarioRepetidoExceptionNick, publicadores.UsuarioRepetidoExceptionMail;
    public void ingresarDtDocenteFrontEnd(publicadores.DtDocente arg0) throws java.rmi.RemoteException, publicadores.UsuarioRepetidoExceptionNick, publicadores.UsuarioRepetidoExceptionMail;
    public void cancelarAltaUsuario() throws java.rmi.RemoteException;
    public java.lang.String[] getInstitutos() throws java.rmi.RemoteException;
    public void ingresarDtUsuario(publicadores.DtUsuario arg0) throws java.rmi.RemoteException, publicadores.UsuarioRepetidoException;
    public void confirmarAltaUsuario() throws java.rmi.RemoteException, publicadores.NoExisteInstitutoException;
}
