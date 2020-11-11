/**
 * ControladorBuscarCursoOProgramaPublish.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorBuscarCursoOProgramaPublish extends java.rmi.Remote {
    public publicadores.DtCurso[] buscarCursos(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.DtProgFormacion[] buscarProgramas(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.DtCurso[] ordenarCursosAlfabeticamente(publicadores.DtCurso[] arg0) throws java.rmi.RemoteException;
    public publicadores.DtCurso[] ordenarCursosPorFecha(publicadores.DtCurso[] arg0) throws java.rmi.RemoteException;
    public publicadores.DtProgFormacion[] ordenarProgramasAlfabeticamente(publicadores.DtProgFormacion[] arg0) throws java.rmi.RemoteException;
    public publicadores.DtProgFormacion[] ordenarProgramasPorFecha(publicadores.DtProgFormacion[] arg0) throws java.rmi.RemoteException;
}
