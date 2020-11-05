/**
 * ControladorAltaCursoPublishServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class ControladorAltaCursoPublishServiceLocator extends org.apache.axis.client.Service implements publicadores.ControladorAltaCursoPublishService {

    public ControladorAltaCursoPublishServiceLocator() {
    }


    public ControladorAltaCursoPublishServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ControladorAltaCursoPublishServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ControladorAltaCursoPublishPort
    private java.lang.String ControladorAltaCursoPublishPort_address = "http://127.0.0.1:1942/controladorAltaCurso";

    public java.lang.String getControladorAltaCursoPublishPortAddress() {
        return ControladorAltaCursoPublishPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ControladorAltaCursoPublishPortWSDDServiceName = "ControladorAltaCursoPublishPort";

    public java.lang.String getControladorAltaCursoPublishPortWSDDServiceName() {
        return ControladorAltaCursoPublishPortWSDDServiceName;
    }

    public void setControladorAltaCursoPublishPortWSDDServiceName(java.lang.String name) {
        ControladorAltaCursoPublishPortWSDDServiceName = name;
    }

    public publicadores.ControladorAltaCursoPublish getControladorAltaCursoPublishPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ControladorAltaCursoPublishPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getControladorAltaCursoPublishPort(endpoint);
    }

    public publicadores.ControladorAltaCursoPublish getControladorAltaCursoPublishPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            publicadores.ControladorAltaCursoPublishPortBindingStub _stub = new publicadores.ControladorAltaCursoPublishPortBindingStub(portAddress, this);
            _stub.setPortName(getControladorAltaCursoPublishPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setControladorAltaCursoPublishPortEndpointAddress(java.lang.String address) {
        ControladorAltaCursoPublishPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (publicadores.ControladorAltaCursoPublish.class.isAssignableFrom(serviceEndpointInterface)) {
                publicadores.ControladorAltaCursoPublishPortBindingStub _stub = new publicadores.ControladorAltaCursoPublishPortBindingStub(new java.net.URL(ControladorAltaCursoPublishPort_address), this);
                _stub.setPortName(getControladorAltaCursoPublishPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ControladorAltaCursoPublishPort".equals(inputPortName)) {
            return getControladorAltaCursoPublishPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://publicadores/", "ControladorAltaCursoPublishService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://publicadores/", "ControladorAltaCursoPublishPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ControladorAltaCursoPublishPort".equals(portName)) {
            setControladorAltaCursoPublishPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
