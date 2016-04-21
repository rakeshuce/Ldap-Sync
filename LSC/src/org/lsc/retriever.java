/**
 * retrievebyguid.java
 * 5 July 2001
 * Sample JNDI application to retrieve an Active Directory 
 * object using the string form of its objectGUID
 */
 package org.lsc;
import java.util.Hashtable;
import javax.naming.ldap.*;
import javax.naming.directory.*;
import javax.naming.*;
 
// java.exe retriever ldap://localhost:389/ cn=lsc-exec,ou=clients,dc=lsc-project,dc=org 1qaz!QAZ  "OU=US Scottsdale,DC=lsc-project,DC=org" 
 
 
public class retriever	{
	public static void main (String[] args)	{
	
		Hashtable env = new Hashtable();
		String ldapURL = args[0];
		String adminName = args[1];
		String adminPassword = args[2];
		String ldapPath = args[3];
		
		env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
 
		//set security credentials, note using simple cleartext authentication
		env.put(Context.SECURITY_AUTHENTICATION,"simple");
		env.put(Context.SECURITY_PRINCIPAL,adminName);
		env.put(Context.SECURITY_CREDENTIALS,adminPassword);
		env.put("java.naming.ldap.attributes.binary","objectGUID");
		
		//connect to my domain controller
		env.put(Context.PROVIDER_URL,ldapURL);
		try {
 
			//Create the initial directory context
			LdapContext ctx = new InitialLdapContext(env,null);
		
			//Bind directly using the string form of the GUID
			String strGUID = "<GUID=7c448a67-923b-48ee-b21a-3451f2f758ca>";
 
			//Specify the attributes to return
			String returnedAtts[]={"ou","objectGUID"};
 
			Attributes attr = ctx.getAttributes(ldapPath,returnedAtts);
 
			//print out the retrieved attributes
			System.out.println("ou: " + attr.get("ou").get());
			System.out.println("guid: " + attr.get("objectGUID").get());
			System.out.println("guid: " + printGUID((byte[]) attr.get("objectGUID").get()));
			
			ctx.close();
 
		}
		catch (NamingException e) {
			System.err.println("Problem searching directory: " + e);
		}
	}
	
	private static String printGUID(byte[] GUID)
	{
		// byte[] GUID = (byte[]) objectGUID;
		String strGUID = "";
		String byteGUID = "";
		
		//Convert the GUID into string using the byte format
		for (int c=0;c<GUID.length;c++) {
			byteGUID = byteGUID + "\\" + AddLeadingZero((int)GUID[c] & 0xFF);
		}
		//convert the GUID into string format
//		strGUID = "{";
		strGUID = strGUID + AddLeadingZero((int)GUID[3] & 0xFF);
		strGUID = strGUID + AddLeadingZero((int)GUID[2] & 0xFF);
		strGUID = strGUID + AddLeadingZero((int)GUID[1] & 0xFF); 
		strGUID = strGUID + AddLeadingZero((int)GUID[0] & 0xFF);
		strGUID = strGUID + "-";
		strGUID = strGUID + AddLeadingZero((int)GUID[5] & 0xFF);
		strGUID = strGUID + AddLeadingZero((int)GUID[4] & 0xFF);
		strGUID = strGUID + "-";
		strGUID = strGUID + AddLeadingZero((int)GUID[7] & 0xFF);
		strGUID = strGUID + AddLeadingZero((int)GUID[6] & 0xFF);
		strGUID = strGUID + "-";
		strGUID = strGUID + AddLeadingZero((int)GUID[8] & 0xFF);
		strGUID = strGUID + AddLeadingZero((int)GUID[9] & 0xFF);
		strGUID = strGUID + "-";
		strGUID = strGUID + AddLeadingZero((int)GUID[10] & 0xFF);
		strGUID = strGUID + AddLeadingZero((int)GUID[11] & 0xFF);
		strGUID = strGUID + AddLeadingZero((int)GUID[12] & 0xFF);
		strGUID = strGUID + AddLeadingZero((int)GUID[13] & 0xFF);
		strGUID = strGUID + AddLeadingZero((int)GUID[14] & 0xFF);
		strGUID = strGUID + AddLeadingZero((int)GUID[15] & 0xFF);
//		strGUID = strGUID + "}";
		System.out.println("LDAP://<GUID=" + strGUID + ">");
		System.out.println("(objectGUID=" + byteGUID + ")");
 
		return strGUID;
	}
	
	static String AddLeadingZero(int k) {
		return (k <= 0xF)?"0" + Integer.toHexString(k):Integer.toHexString(k);
	}
}
