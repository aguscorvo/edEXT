/**
 * ProgFormacion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class ProgFormacion  implements java.io.Serializable {
    private java.lang.String descPF;

    private java.util.Calendar fechaAlta;

    private java.util.Calendar fechaF;

    private java.util.Calendar fechaI;

    private publicadores.InscripcionPF[] inscripcionesPF;

    private java.lang.String nombre;

    public ProgFormacion() {
    }

    public ProgFormacion(
           java.lang.String descPF,
           java.util.Calendar fechaAlta,
           java.util.Calendar fechaF,
           java.util.Calendar fechaI,
           publicadores.InscripcionPF[] inscripcionesPF,
           java.lang.String nombre) {
           this.descPF = descPF;
           this.fechaAlta = fechaAlta;
           this.fechaF = fechaF;
           this.fechaI = fechaI;
           this.inscripcionesPF = inscripcionesPF;
           this.nombre = nombre;
    }


    /**
     * Gets the descPF value for this ProgFormacion.
     * 
     * @return descPF
     */
    public java.lang.String getDescPF() {
        return descPF;
    }


    /**
     * Sets the descPF value for this ProgFormacion.
     * 
     * @param descPF
     */
    public void setDescPF(java.lang.String descPF) {
        this.descPF = descPF;
    }


    /**
     * Gets the fechaAlta value for this ProgFormacion.
     * 
     * @return fechaAlta
     */
    public java.util.Calendar getFechaAlta() {
        return fechaAlta;
    }


    /**
     * Sets the fechaAlta value for this ProgFormacion.
     * 
     * @param fechaAlta
     */
    public void setFechaAlta(java.util.Calendar fechaAlta) {
        this.fechaAlta = fechaAlta;
    }


    /**
     * Gets the fechaF value for this ProgFormacion.
     * 
     * @return fechaF
     */
    public java.util.Calendar getFechaF() {
        return fechaF;
    }


    /**
     * Sets the fechaF value for this ProgFormacion.
     * 
     * @param fechaF
     */
    public void setFechaF(java.util.Calendar fechaF) {
        this.fechaF = fechaF;
    }


    /**
     * Gets the fechaI value for this ProgFormacion.
     * 
     * @return fechaI
     */
    public java.util.Calendar getFechaI() {
        return fechaI;
    }


    /**
     * Sets the fechaI value for this ProgFormacion.
     * 
     * @param fechaI
     */
    public void setFechaI(java.util.Calendar fechaI) {
        this.fechaI = fechaI;
    }


    /**
     * Gets the inscripcionesPF value for this ProgFormacion.
     * 
     * @return inscripcionesPF
     */
    public publicadores.InscripcionPF[] getInscripcionesPF() {
        return inscripcionesPF;
    }


    /**
     * Sets the inscripcionesPF value for this ProgFormacion.
     * 
     * @param inscripcionesPF
     */
    public void setInscripcionesPF(publicadores.InscripcionPF[] inscripcionesPF) {
        this.inscripcionesPF = inscripcionesPF;
    }

    public publicadores.InscripcionPF getInscripcionesPF(int i) {
        return this.inscripcionesPF[i];
    }

    public void setInscripcionesPF(int i, publicadores.InscripcionPF _value) {
        this.inscripcionesPF[i] = _value;
    }


    /**
     * Gets the nombre value for this ProgFormacion.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this ProgFormacion.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProgFormacion)) return false;
        ProgFormacion other = (ProgFormacion) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.descPF==null && other.getDescPF()==null) || 
             (this.descPF!=null &&
              this.descPF.equals(other.getDescPF()))) &&
            ((this.fechaAlta==null && other.getFechaAlta()==null) || 
             (this.fechaAlta!=null &&
              this.fechaAlta.equals(other.getFechaAlta()))) &&
            ((this.fechaF==null && other.getFechaF()==null) || 
             (this.fechaF!=null &&
              this.fechaF.equals(other.getFechaF()))) &&
            ((this.fechaI==null && other.getFechaI()==null) || 
             (this.fechaI!=null &&
              this.fechaI.equals(other.getFechaI()))) &&
            ((this.inscripcionesPF==null && other.getInscripcionesPF()==null) || 
             (this.inscripcionesPF!=null &&
              java.util.Arrays.equals(this.inscripcionesPF, other.getInscripcionesPF()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre())));
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
        if (getDescPF() != null) {
            _hashCode += getDescPF().hashCode();
        }
        if (getFechaAlta() != null) {
            _hashCode += getFechaAlta().hashCode();
        }
        if (getFechaF() != null) {
            _hashCode += getFechaF().hashCode();
        }
        if (getFechaI() != null) {
            _hashCode += getFechaI().hashCode();
        }
        if (getInscripcionesPF() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getInscripcionesPF());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getInscripcionesPF(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ProgFormacion.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "progFormacion"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descPF");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descPF"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inscripcionesPF");
        elemField.setXmlName(new javax.xml.namespace.QName("", "inscripcionesPF"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "inscripcionPF"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
