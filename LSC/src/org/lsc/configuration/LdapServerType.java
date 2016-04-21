//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.6 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2014.05.15 à 05:01:12 PM CEST 
//


package org.lsc.configuration;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour ldapServerType.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="ldapServerType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OpenLDAP"/>
 *     &lt;enumeration value="ApacheDS"/>
 *     &lt;enumeration value="OpenDS"/>
 *     &lt;enumeration value="OpenDJ"/>
 *     &lt;enumeration value="OracleDS"/>
 *     &lt;enumeration value="SunDS"/>
 *     &lt;enumeration value="NetscapeDS"/>
 *     &lt;enumeration value="ActiveDirectory"/>
 *     &lt;enumeration value="NovellEDirectory"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ldapServerType")
@XmlEnum
public enum LdapServerType {

    @XmlEnumValue("OpenLDAP")
    OPEN_LDAP("OpenLDAP"),
    @XmlEnumValue("ApacheDS")
    APACHE_DS("ApacheDS"),
    @XmlEnumValue("OpenDS")
    OPEN_DS("OpenDS"),
    @XmlEnumValue("OpenDJ")
    OPEN_DJ("OpenDJ"),
    @XmlEnumValue("OracleDS")
    ORACLE_DS("OracleDS"),
    @XmlEnumValue("SunDS")
    SUN_DS("SunDS"),
    @XmlEnumValue("NetscapeDS")
    NETSCAPE_DS("NetscapeDS"),
    @XmlEnumValue("ActiveDirectory")
    ACTIVE_DIRECTORY("ActiveDirectory"),
    @XmlEnumValue("NovellEDirectory")
    NOVELL_E_DIRECTORY("NovellEDirectory");
    private final String value;

    LdapServerType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LdapServerType fromValue(String v) {
        for (LdapServerType c: LdapServerType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
