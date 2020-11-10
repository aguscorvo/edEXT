/**
 * Estudiante.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class Estudiante  extends publicadores.Usuario  implements java.io.Serializable {
    private publicadores.InscripcionEd[] inscripcionesEd;

    private publicadores.InscripcionPF[] inscripcionesPF;

    public Estudiante() {
    }

    public Estudiante(
           java.lang.String apellido,
           java.lang.String correo,
           java.util.Calendar fechaNac,
           java.lang.String nick,
           java.lang.String nombre,
           java.lang.String password,
           publicadores.Usuario[] usuariosSeguidos,
           publicadores.InscripcionEd[] inscripcionesEd,
           publicadores.InscripcionPF[] inscripcionesPF) {
        super(
            apellido,
            correo,
            fechaNac,
            nick,
            nombre,
            password,
            usuariosSeguidos);
        this.inscripcionesEd = inscripcionesEd;
        this.inscripcionesPF = inscripcionesPF;
    }


    /**
     * Gets the inscripcionesEd value for this Estudiante.
     * 
     * @return inscripcionesEd
     */
    public publicadores.InscripcionEd[] getInscripcionesEd() {
        return inscripcionesEd;
    }


    /**
     * Sets the inscripcionesEd value for this Estudiante.
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
     * Gets the inscripcionesPF value for this Estudiante.
     * 
     * @return inscripcionesPF
     */
    public publicadores.InscripcionPF[] getInscripcionesPF() {
        return inscripcionesPF;
    }


    /**
     * Sets the inscripcionesPF value for this Estudiante.
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

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Estudiante)) return false;
        Estudiante other = (Estudiante) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.inscripcionesEd==null && other.getInscripcionesEd()==null) || 
             (this.inscripcionesEd!=null &&
              java.util.Arrays.equals(this.inscripcionesEd, other.getInscripcionesEd()))) &&
            ((this.inscripcionesPF==null && other.getInscripcionesPF()==null) || 
             (this.inscripcionesPF!=null &&
              java.util.Arrays.equals(this.inscripcionesPF, other.getInscripcionesPF())));
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Estudiante.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "estudiante"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inscripcionesEd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "inscripcionesEd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "inscripcionEd"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inscripcionesPF");
        elemField.setXmlName(new javax.xml.namespace.QName("", "inscripcionesPF"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "inscripcionPF"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
