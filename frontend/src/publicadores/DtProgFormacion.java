/**
 * DtProgFormacion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class DtProgFormacion  extends publicadores.DtProgFormacionMin  implements java.io.Serializable {
    private java.util.Date fechaAlta;

    private java.util.Date fechaF;

    private java.util.Date fechaI;

    public DtProgFormacion() {
    }

    public DtProgFormacion(
           java.lang.String nombre,
           java.lang.String desc,
           java.util.Date fechaAlta,
           java.util.Date fechaF,
           java.util.Date fechaI) {
        super(
            nombre,
            desc);
        this.fechaAlta = fechaAlta;
        this.fechaF = fechaF;
        this.fechaI = fechaI;
    }


    /**
     * Gets the fechaAlta value for this DtProgFormacion.
     * 
     * @return fechaAlta
     */
    public java.util.Date getFechaAlta() {
        return fechaAlta;
    }


    /**
     * Sets the fechaAlta value for this DtProgFormacion.
     * 
     * @param fechaAlta
     */
    public void setFechaAlta(java.util.Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }


    /**
     * Gets the fechaF value for this DtProgFormacion.
     * 
     * @return fechaF
     */
    public java.util.Date getFechaF() {
        return fechaF;
    }


    /**
     * Sets the fechaF value for this DtProgFormacion.
     * 
     * @param fechaF
     */
    public void setFechaF(java.util.Date fechaF) {
        this.fechaF = fechaF;
    }


    /**
     * Gets the fechaI value for this DtProgFormacion.
     * 
     * @return fechaI
     */
    public java.util.Date getFechaI() {
        return fechaI;
    }


    /**
     * Sets the fechaI value for this DtProgFormacion.
     * 
     * @param fechaI
     */
    public void setFechaI(java.util.Date fechaI) {
        this.fechaI = fechaI;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DtProgFormacion)) return false;
        DtProgFormacion other = (DtProgFormacion) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.fechaAlta==null && other.getFechaAlta()==null) || 
             (this.fechaAlta!=null &&
              this.fechaAlta.equals(other.getFechaAlta()))) &&
            ((this.fechaF==null && other.getFechaF()==null) || 
             (this.fechaF!=null &&
              this.fechaF.equals(other.getFechaF()))) &&
            ((this.fechaI==null && other.getFechaI()==null) || 
             (this.fechaI!=null &&
              this.fechaI.equals(other.getFechaI())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getFechaAlta() != null) {
            _hashCode += getFechaAlta().hashCode();
        }
        if (getFechaF() != null) {
            _hashCode += getFechaF().hashCode();
        }
        if (getFechaI() != null) {
            _hashCode += getFechaI().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DtProgFormacion.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "dtProgFormacion"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaAlta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaAlta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaF");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaF"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaI");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
