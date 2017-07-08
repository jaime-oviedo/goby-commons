/**
 *
 */

package com.ingenium.commons.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author joviedo
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class BulkFileMerger {
  /** 
  * <!-- begin-UML-doc -->
  * <!-- end-UML-doc -->
  * @param souceDirectory
  * @param destinationDirectory
  * @param destinationFileName
  * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
  */
  public static void merge(String souceDirectory, String destinationDirectory,
      String destinationFileName) {
    // begin-user-code
    OutputStream output = null;
    final String destination = new StringBuffer(destinationDirectory)
        .append(File.separator).append(destinationFileName).toString();
    final File dir = new File(souceDirectory);
    final File[] sources = dir.listFiles();
    if (sources == null) {
      return;
    }
    InputStream input = null;
    try {
      output = new BufferedOutputStream(
          new FileOutputStream(destination, true));

      for (final File source : sources) {
        input = new BufferedInputStream(new FileInputStream(source));
        IOUtils.copy(input, output);
      }
    } catch (final FileNotFoundException e) {
      e.printStackTrace();
    } catch (final IOException e) {
      e.printStackTrace();
    }

    finally {
      if (output != null) {
        try {
          output.close();
        } catch (final IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        if (input != null) {
          try {
            input.close();
          } catch (final IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
      }

      IOUtils.closeQuietly(output);
    }
    // end-user-code
  }

}