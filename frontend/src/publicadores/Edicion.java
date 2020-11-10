/**
 * Edicion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class Edicion  implements java.io.Serializable {
    private int cupo;

    private java.util.Date fechaF;

    private java.util.Date fechaI;

    private java.util.Date fechaPub;

    private publicadores.InscripcionEd[] inscripcionesEd;

    private java.lang.String nombreEd;

    public Edicion() {
    }

    public Edicion(
           int cupo,
           java.util.Date fechaF,
           java.util.Date fechaI,
           java.util.Date fechaPub,
           publicadores.InscripcionEd[] inscripcionesEd,
           java.lang.String nombreEd) {
           this.cupo = cupo;
           this.fechaF = fechaF;
           this.fechaI = fechaI;
           this.fechaPub = fechaPub;
           this.inscripcionesEd = inscripcionesEd;
           this.nombreEd = nombreEd;
    }


    /**
     * Gets the cupo value for this Edicion.
     * 
     * @return cupo
     */
    public int getCupo() {
        return cupo;
    }


    /**
     * Sets the cupo value for this Edicion.
     * 
     * @param cupo
     */
    public void setCupo(int cupo) {
        this.cupo = cupo;
    }


    /**
     * Gets the fechaF value for this Edicion.
     * 
     * @return fechaF
     */
    public java.util.Date getFechaF() {
        return fechaF;
    }


    /**
     * Sets the fechaF value for this Edicion.
     * 
     * @param fechaF
     */
    public void setFechaF(java.util.Date fechaF) {
        this.fechaF = fechaF;
    }


    /**
     * Gets the fechaI value for this Edicion.
     * 
     * @return fechaI
     */
    public java.util.Date getFechaI() {
        return fechaI;
    }


    /**
     * Sets the fechaI value for this Edicion.
     * 
     * @param fechaI
     */
    public void setFechaI(java.util.Date fechaI) {
        this.fechaI = fechaI;
    }


    /**
     * Gets the fechaPub value for this Edicion.
     * 
     * @return fechaPub
     */
    public java.util.Date getFechaPub() {
        return fechaPub;
    }


    /**
     * Sets the fechaPub value for this Edicion.
     * 
     * @param fechaPub
     */
    public void setFechaPub(java.util.Date fechaPub) {
        this.fechaPub = fechaPub;
    }


    /**
     * Gets the inscripcionesEd value for this Edicion.
     * 
     * @return inscripcionesEd
     */
    public publicadores.InscripcionEd[] getInscripcionesEd() {
        return inscripcionesEd;
    }


    /**
     * Sets the inscripcionesEd value for this Edicion.
     * 
     * @param inscripcionesEd
     */
    public void setInscripcionesEd(publicadores.InscripcionEd[] inscripcionesEd) {
        this.inscripcionesEd = inscripcionesEd;
    }

    public publicadores.InscripcionEd getInscripcionesEd(int i) {
        return this.inscripcionesEd[i];
    }

    public void setInscripcionesEd(int i, publicadores.InscripcionEd _value) {
        this.inscripcionesEd[i] = _value;
    }


    /**
     * Gets the nombreEd value for this Edicion.
     * 
     * @return nombreEd
     */
    public java.lang.String getNombreEd() {
        return nombreEd;
    }


    /**
     * Sets the nombreEd value for this Edicion.
     * 
     * @param nombreEd
     */
    public void setNombreEd(java.lang.String nombreEd) {
        this.nombreEd = nombreEd;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Edicion)) return false;
        Edicion other = (Edicion) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.cupo == other.getCupo() &&
            ((this.fechaF==null && other.getFechaF()==null) || 
             (this.fechaF!=null &&
              this.fechaF.equals(other.getFechaF()))) &&
            ((this.fechaI==null && other.getFechaI()==null) || 
             (this.fechaI!=null &&
              this.fechaI.equals(other.getFechaI()))) &&
            ((this.fechaPub==null && other.getFechaPub()==null) || 
             (this.fechaPub!=null &&
              this.fechaPub.equals(other.getFechaPub()))) &&
            ((this.inscripcionesEd==null && other.getInscripcionesEd()==null) || 
             (this.inscripcionesEd!=null &&
              java.util.Arrays.equals(this.inscripcionesEd, other.getInscripcionesEd()))) &&
            ((this.nombreEd==null && other.getNombreEd()==null) || 
             (this.nombreEd!=null &&
              this.nombreEd.equals(other.getNombreEd())));
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
        _hashCode += getCupo();
        if (getFechaF() != null) {
            _hashCode += getFechaF().hashCode();
        }
        if (getFechaI() != null) {
            _hashCode += getFechaI().hashCode();
        }
        if (getFechaPub() != null) {
            _hashCode += getFechaPub().hashCode();
        }
        if (getInscripcionesEd() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getInscripcionesEd());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getInscripcionesEd(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNombreEd() != null) {
            _hashCode += getNombreEd().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Edicion.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "edicion"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cupo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cupo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("fechaPub");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaPub"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inscripcionesEd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "inscripcionesEd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "inscripcionEd"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombreEd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombreEd"));
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
