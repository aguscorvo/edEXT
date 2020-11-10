/**
 * InscripcionPF.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class InscripcionPF  implements java.io.Serializable {
    private publicadores.Estudiante estudiante;

    private java.util.Calendar fechaPF;

    private publicadores.ProgFormacion progFormacion;

    public InscripcionPF() {
    }

    public InscripcionPF(
           publicadores.Estudiante estudiante,
           java.util.Calendar fechaPF,
           publicadores.ProgFormacion progFormacion) {
           this.estudiante = estudiante;
           this.fechaPF = fechaPF;
           this.progFormacion = progFormacion;
    }


    /**
     * Gets the estudiante value for this InscripcionPF.
     * 
     * @return estudiante
     */
    public publicadores.Estudiante getEstudiante() {
        return estudiante;
    }


    /**
     * Sets the estudiante value for this InscripcionPF.
     * 
     * @param estudiante
     */
    public void setEstudiante(publicadores.Estudiante estudiante) {
        this.estudiante = estudiante;
    }


    /**
     * Gets the fechaPF value for this InscripcionPF.
     * 
     * @return fechaPF
     */
    public java.util.Calendar getFechaPF() {
        return fechaPF;
    }


    /**
     * Sets the fechaPF value for this InscripcionPF.
     * 
     * @param fechaPF
     */
    public void setFechaPF(java.util.Calendar fechaPF) {
        this.fechaPF = fechaPF;
    }


    /**
     * Gets the progFormacion value for this InscripcionPF.
     * 
     * @return progFormacion
     */
    public publicadores.ProgFormacion getProgFormacion() {
        return progFormacion;
    }


    /**
     * Sets the progFormacion value for this InscripcionPF.
     * 
     * @param progFormacion
     */
    public void setProgFormacion(publicadores.ProgFormacion progFormacion) {
        this.progFormacion = progFormacion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InscripcionPF)) return false;
        InscripcionPF other = (InscripcionPF) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.estudiante==null && other.getEstudiante()==null) || 
             (this.estudiante!=null &&
              this.estudiante.equals(other.getEstudiante()))) &&
            ((this.fechaPF==null && other.getFechaPF()==null) || 
             (this.fechaPF!=null &&
              this.fechaPF.equals(other.getFechaPF()))) &&
            ((this.progFormacion==null && other.getProgFormacion()==null) || 
             (this.progFormacion!=null &&
              this.progFormacion.equals(other.getProgFormacion())));
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
        if (getEstudiante() != null) {
            _hashCode += getEstudiante().hashCode();
        }
        if (getFechaPF() != null) {
            _hashCode += getFechaPF().hashCode();
        }
        if (getProgFormacion() != null) {
            _hashCode += getProgFormacion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InscripcionPF.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "inscripcionPF"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estudiante");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estudiante"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "estudiante"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaPF");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaPF"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("progFormacion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "progFormacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "progFormacion"));
        elemField.setMinOccurs(0);
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
