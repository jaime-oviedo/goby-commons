/**
 *
 */

package com.ingenium.commons.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/** 
 * <!-- begin-UML-doc -->
 * Esta&nbsp;clase&nbsp;permite&nbsp;la&nbsp;descarga&nbsp;de&nbsp;un&nbsp;archivo&nbsp;desde&nbsp;un&nbsp;sitio&nbsp;Web.<br><br>@author&nbsp;JaimeRodrigo
 * <!-- end-UML-doc -->
 * @author JaimeRodrigo
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SimpleFileDownloader {
  
  /** 
  * <!-- begin-UML-doc -->
  * <!-- end-UML-doc -->
  * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
  */
  private static final int BUFFER_SIZE = 4096;
  
  /** 
  * <!-- begin-UML-doc -->
  * Crea&nbsp;una&nbsp;nueva&nbsp;instancia&nbsp;de&nbsp;la&nbsp;clase&nbsp;SimpleFileDownloader.
  * <!-- end-UML-doc -->
  * Crea una nueva instancia de la clase SimpleFileDownloader.
  * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
  */
  public SimpleFileDownloader() {
    // begin-user-code
    super();
    // end-user-code
  }
  
  /*
   * (non-Javadoc)
   * @see com.ingenium.commons.util.Downloader#download(java.lang.String,
   * java.lang.String)
   */
  /** 
  * <!-- begin-UML-doc -->
  * <!-- end-UML-doc -->
  * @param source
  * @param destination
  * @throws IOException
  * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
  */
  public void download(String source, String destination) throws IOException {
    // begin-user-code
    final URL url = new URL(source);
    final URLConnection urlConnection = url.openConnection();
    HttpURLConnection httpConn = null;
    if (urlConnection instanceof HttpURLConnection) {
      httpConn = (HttpURLConnection) urlConnection;
    } else {
      return;
    }
    final int responseCode = httpConn.getResponseCode();
    
    // always check HTTP response code first
    if (responseCode == HttpURLConnection.HTTP_OK) {
      String fileName = "";
      final String disposition = httpConn.getHeaderField("Content-Disposition");
      final String contentType = httpConn.getContentType();
      final int contentLength = httpConn.getContentLength();
      
      if (disposition != null) {
        // extracts file name from header field
        final int index = disposition.indexOf("filename=");
        if (index > 0) {
          fileName = disposition.substring(index + 10,
              disposition.length() - 1);
        }
      } else {
        // extracts file name from URL
        fileName = source.substring(source.lastIndexOf("/") + 1,
            source.length());
      }
      System.out.println("Content-Type = " + contentType);
      System.out.println("Content-Disposition = " + disposition);
      System.out.println("Content-Length = " + contentLength);
      System.out.println("fileName = " + fileName);
      // opens input stream from the HTTP connection
      final InputStream inputStream = httpConn.getInputStream();
      final String saveFilePath = destination + File.separator + fileName;
      // opens an output stream to save into file
      final FileOutputStream outputStream = new FileOutputStream(saveFilePath);
      int bytesRead = -1;
      final byte[] buffer = new byte[SimpleFileDownloader.BUFFER_SIZE];
      while ((bytesRead = inputStream.read(buffer)) != -1) {
        outputStream.write(buffer, 0, bytesRead);
      }
      outputStream.close();
      inputStream.close();
      System.out.println("File downloaded");
    } else {
      System.out.println(
          "No file to download. Server replied HTTP code: " + responseCode);
    }
    httpConn.disconnect();
    // BufferedReader inputStream = null;
    // PrintWriter outputStream = null;
    // final URL url = new URL(source);
    // final Charset inputCharset = Charset.forName("ISO-8859-1");
    //
    // try {
    // inputStream = new BufferedReader(
    // new InputStreamReader(url.openStream(), inputCharset));
    // outputStream = new PrintWriter(
    // new BufferedWriter(new FileWriter(destination)));
    // String l;
    //
    // while ((l = inputStream.readLine()) != null) {
    // outputStream.write(l);
    // }
    // } finally {
    // if (inputStream != null) {
    // inputStream.close();
    // }
    // if (outputStream != null) {
    // outputStream.close();
    // }
    // }
    // end-user-code
  }
  
}
