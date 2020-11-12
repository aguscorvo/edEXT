/**
 * ControladorModificarDatosUsuarioPublishServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class ControladorModificarDatosUsuarioPublishServiceLocator extends org.apache.axis.client.Service implements publicadores.ControladorModificarDatosUsuarioPublishService {

    public ControladorModificarDatosUsuarioPublishServiceLocator() {
    }


    public ControladorModificarDatosUsuarioPublishServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ControladorModificarDatosUsuarioPublishServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ControladorModificarDatosUsuarioPublishPort
    private java.lang.String ControladorModificarDatosUsuarioPublishPort_address = "http://127.0.0.1:1942/controladorModificarDatosUsuario";

    public java.lang.String getControladorModificarDatosUsuarioPublishPortAddress() {
        return ControladorModificarDatosUsuarioPublishPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ControladorModificarDatosUsuarioPublishPortWSDDServiceName = "ControladorModificarDatosUsuarioPublishPort";

    public java.lang.String getControladorModificarDatosUsuarioPublishPortWSDDServiceName() {
        return ControladorModificarDatosUsuarioPublishPortWSDDServiceName;
    }

    public void setControladorModificarDatosUsuarioPublishPortWSDDServiceName(java.lang.String name) {
        ControladorModificarDatosUsuarioPublishPortWSDDServiceName = name;
    }

    public publicadores.ControladorModificarDatosUsuarioPublish getControladorModificarDatosUsuarioPublishPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ControladorModificarDatosUsuarioPublishPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getControladorModificarDatosUsuarioPublishPort(endpoint);
    }

    public publicadores.ControladorModificarDatosUsuarioPublish getControladorModificarDatosUsuarioPublishPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            publicadores.ControladorModificarDatosUsuarioPublishPortBindingStub _stub = new publicadores.ControladorModificarDatosUsuarioPublishPortBindingStub(portAddress, this);
            _stub.setPortName(getControladorModificarDatosUsuarioPublishPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setControladorModificarDatosUsuarioPublishPortEndpointAddress(java.lang.String address) {
        ControladorModificarDatosUsuarioPublishPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (publicadores.ControladorModificarDatosUsuarioPublish.class.isAssignableFrom(serviceEndpointInterface)) {
                publicadores.ControladorModificarDatosUsuarioPublishPortBindingStub _stub = new publicadores.ControladorModificarDatosUsuarioPublishPortBindingStub(new java.net.URL(ControladorModificarDatosUsuarioPublishPort_address), this);
                _stub.setPortName(getControladorModificarDatosUsuarioPublishPortWSDDServiceName());
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
        if ("ControladorModificarDatosUsuarioPublishPort".equals(inputPortName)) {
            return getControladorModificarDatosUsuarioPublishPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://publicadores/", "ControladorModificarDatosUsuarioPublishService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://publicadores/", "ControladorModificarDatosUsuarioPublishPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ControladorModificarDatosUsuarioPublishPort".equals(portName)) {
            setControladorModificarDatosUsuarioPublishPortEndpointAddress(address);
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
