/**
 *
 */

package com.ingenium.commons.util;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author JaimeRodrigo
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class BulkCsvFilesMerger {
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
    BulkCsvFilesMerger.merge(souceDirectory, destinationDirectory,
        destinationFileName, 0);
    
    // end-user-code
  }
  
  /** 
  * <!-- begin-UML-doc -->
  * <!-- end-UML-doc -->
  * @param souceDirectory
  * @param destinationDirectory
  * @param destinationFileName
  * @param linesToSkip
  * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
  */
  public static void merge(String souceDirectory, String destinationDirectory,
      String destinationFileName, int linesToSkip) {
    // begin-user-code
    String destination = new StringBuffer(destinationDirectory)
        .append(File.separator).append(destinationFileName).toString();
    File dir = new File(souceDirectory);
    File[] sources = dir.listFiles();
    if (sources == null) {
      return;
    }
    List<String[]> csvEntries = new ArrayList<>(100);
    FileInputStream is = null;
    InputStreamReader isr = null;
    CSVReader reader = null;
    BufferedReader buffReader = null;
    try {
      for (File source : sources) {
        is = new FileInputStream(source);
        isr = new InputStreamReader(is, "CP1250");
        buffReader = new BufferedReader(isr);
        reader = new CSVReader(buffReader, ';', '"', linesToSkip);
        List<String[]> readerEntries = reader.readAll();
        csvEntries.addAll(readerEntries);
      }
    } catch (FileNotFoundException e1) {
      e1.printStackTrace();
    } catch (UnsupportedEncodingException e1) {
      e1.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (buffReader != null) {
        try {
          buffReader.close();
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
      if (isr != null) {
        try {
          isr.close();
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
      if (is != null) {
        try {
          is.close();
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }
    
    if (destinationDirectory == null) {
      return;
    }
    if (destinationDirectory.equals("")) {
      return;
    }
    
    File destinationDirectoryAsFile = new File(destinationDirectory);
    try {
      FileUtils.deleteDirectory(destinationDirectoryAsFile);
    } catch (IOException e1) {
      // TODO log.finest
    }
    destinationDirectoryAsFile.mkdirs();
    File destinationFile = new File(destination);
    destinationFile.delete();
    CSVWriter writer = null;
    try {
      writer = new CSVWriter(new FileWriter(destinationFile), ';',
          CSVWriter.NO_QUOTE_CHARACTER);
      writer.writeAll(csvEntries);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (writer != null) {
        try {
          writer.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      
    }
    // end-user-code
  }
}