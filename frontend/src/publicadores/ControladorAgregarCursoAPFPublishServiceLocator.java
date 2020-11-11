/**
 * ControladorAgregarCursoAPFPublishServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class ControladorAgregarCursoAPFPublishServiceLocator extends org.apache.axis.client.Service implements publicadores.ControladorAgregarCursoAPFPublishService {

    public ControladorAgregarCursoAPFPublishServiceLocator() {
    }


    public ControladorAgregarCursoAPFPublishServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ControladorAgregarCursoAPFPublishServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ControladorAgregarCursoAPFPublishPort
    private java.lang.String ControladorAgregarCursoAPFPublishPort_address = "http://127.0.0.1:1942/controladorAgregarCursoAPF";

    public java.lang.String getControladorAgregarCursoAPFPublishPortAddress() {
        return ControladorAgregarCursoAPFPublishPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ControladorAgregarCursoAPFPublishPortWSDDServiceName = "ControladorAgregarCursoAPFPublishPort";

    public java.lang.String getControladorAgregarCursoAPFPublishPortWSDDServiceName() {
        return ControladorAgregarCursoAPFPublishPortWSDDServiceName;
    }

    public void setControladorAgregarCursoAPFPublishPortWSDDServiceName(java.lang.String name) {
        ControladorAgregarCursoAPFPublishPortWSDDServiceName = name;
    }

    public publicadores.ControladorAgregarCursoAPFPublish getControladorAgregarCursoAPFPublishPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ControladorAgregarCursoAPFPublishPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getControladorAgregarCursoAPFPublishPort(endpoint);
    }

    public publicadores.ControladorAgregarCursoAPFPublish getControladorAgregarCursoAPFPublishPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            publicadores.ControladorAgregarCursoAPFPublishPortBindingStub _stub = new publicadores.ControladorAgregarCursoAPFPublishPortBindingStub(portAddress, this);
            _stub.setPortName(getControladorAgregarCursoAPFPublishPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setControladorAgregarCursoAPFPublishPortEndpointAddress(java.lang.String address) {
        ControladorAgregarCursoAPFPublishPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (publicadores.ControladorAgregarCursoAPFPublish.class.isAssignableFrom(serviceEndpointInterface)) {
                publicadores.ControladorAgregarCursoAPFPublishPortBindingStub _stub = new publicadores.ControladorAgregarCursoAPFPublishPortBindingStub(new java.net.URL(ControladorAgregarCursoAPFPublishPort_address), this);
                _stub.setPortName(getControladorAgregarCursoAPFPublishPortWSDDServiceName());
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
        if ("ControladorAgregarCursoAPFPublishPort".equals(inputPortName)) {
            return getControladorAgregarCursoAPFPublishPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://publicadores/", "ControladorAgregarCursoAPFPublishService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://publicadores/", "ControladorAgregarCursoAPFPublishPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ControladorAgregarCursoAPFPublishPort".equals(portName)) {
            setControladorAgregarCursoAPFPublishPortEndpointAddress(address);
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
