/**
 *
 */

package com.ingenium.commons.util;

/** 
 * <!-- begin-UML-doc -->
 * Esta&nbsp;interfaz&nbsp;define&nbsp;los&nbsp;métodos&nbsp;de&nbsp;las&nbsp;clases&nbsp;que&nbsp;extraen&nbsp;información&nbsp;desde<br>una&nbsp;fuente.<br><br>@author&nbsp;JaimeRodrigo
 * <!-- end-UML-doc -->
 * @author JaimeRodrigo
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface Downloader {
  
  /** 
  * <!-- begin-UML-doc -->
  * <p>Sets the location of the destination file.</p>
  * <!-- end-UML-doc -->
  * @param destination <p>the new location of the destination file</p>
  * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
  */
  public void setDestination(String destination);
  
  /** 
  * <!-- begin-UML-doc -->
  * <p>Sets the location of the source file.</p>
  * <!-- end-UML-doc -->
  * @param source <p>the new location of the source file</p>
  * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
  */
  public void setSource(String source);
  
  /** 
  * <!-- begin-UML-doc -->
  * <p>Performs the extraction.</p>
  * <!-- end-UML-doc -->
  * @throws DownloadException
  * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
  */
  public void download() throws DownloadException;
  
  /** 
  * <!-- begin-UML-doc -->
  * <p>Gets the location of the destination file.</p>
  * <!-- end-UML-doc -->
  * @return <p>the location of the destination file.</p>
  * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
  */
  public String getDestination();
  
  /** 
  * <!-- begin-UML-doc -->
  * <p>Gets the location of the source file.</p>
  * <!-- end-UML-doc -->
  * @return <p>the location of the source file</p>
  * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
  */
  public String getSource();
  
}
