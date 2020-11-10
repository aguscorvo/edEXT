/**
 * InscripcionEd.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class InscripcionEd  implements java.io.Serializable {
    private publicadores.Edicion edicion;

    private publicadores.EstadoInscripcion estado;

    private publicadores.Estudiante estudiante;

    private java.util.Calendar fecha;

    private int IPR;

    public InscripcionEd() {
    }

    public InscripcionEd(
           publicadores.Edicion edicion,
           publicadores.EstadoInscripcion estado,
           publicadores.Estudiante estudiante,
           java.util.Calendar fecha,
           int IPR) {
           this.edicion = edicion;
           this.estado = estado;
           this.estudiante = estudiante;
           this.fecha = fecha;
           this.IPR = IPR;
    }


    /**
     * Gets the edicion value for this InscripcionEd.
     * 
     * @return edicion
     */
    public publicadores.Edicion getEdicion() {
        return edicion;
    }


    /**
     * Sets the edicion value for this InscripcionEd.
     * 
     * @param edicion
     */
    public void setEdicion(publicadores.Edicion edicion) {
        this.edicion = edicion;
    }


    /**
     * Gets the estado value for this InscripcionEd.
     * 
     * @return estado
     */
    public publicadores.EstadoInscripcion getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this InscripcionEd.
     * 
     * @param estado
     */
    public void setEstado(publicadores.EstadoInscripcion estado) {
        this.estado = estado;
    }


    /**
     * Gets the estudiante value for this InscripcionEd.
     * 
     * @return estudiante
     */
    public publicadores.Estudiante getEstudiante() {
        return estudiante;
    }


    /**
     * Sets the estudiante value for this InscripcionEd.
     * 
     * @param estudiante
     */
    public void setEstudiante(publicadores.Estudiante estudiante) {
        this.estudiante = estudiante;
    }


    /**
     * Gets the fecha value for this InscripcionEd.
     * 
     * @return fecha
     */
    public java.util.Calendar getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this InscripcionEd.
     * 
     * @param fecha
     */
    public void setFecha(java.util.Calendar fecha) {
        this.fecha = fecha;
    }


    /**
     * Gets the IPR value for this InscripcionEd.
     * 
     * @return IPR
     */
    public int getIPR() {
        return IPR;
    }


    /**
     * Sets the IPR value for this InscripcionEd.
     * 
     * @param IPR
     */
    public void setIPR(int IPR) {
        this.IPR = IPR;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InscripcionEd)) return false;
        InscripcionEd other = (InscripcionEd) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.edicion==null && other.getEdicion()==null) || 
             (this.edicion!=null &&
              this.edicion.equals(other.getEdicion()))) &&
            ((this.estado==null && other.getEstado()==null) || 
             (this.estado!=null &&
              this.estado.equals(other.getEstado()))) &&
            ((this.estudiante==null && other.getEstudiante()==null) || 
             (this.estudiante!=null &&
              this.estudiante.equals(other.getEstudiante()))) &&
            ((this.fecha==null && other.getFecha()==null) || 
             (this.fecha!=null &&
              this.fecha.equals(other.getFecha()))) &&
            this.IPR == other.getIPR();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getEdicion() != null) {
            _hashCode += getEdicion().hashCode();
        }
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        if (getEstudiante() != null) {
            _hashCode += getEstudiante().hashCode();
        }
        if (getFecha() != null) {
            _hashCode += getFecha().hashCode();
        }
        _hashCode += getIPR();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InscripcionEd.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "inscripcionEd"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("edicion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "edicion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "edicion"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "estadoInscripcion"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estudiante");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estudiante"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "estudiante"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fecha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IPR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IPR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
