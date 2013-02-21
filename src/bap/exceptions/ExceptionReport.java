/*
 * ExceptionReport.java
 *
 * Created on October 11, 2007, 11:09 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package bap.exceptions;

import javax.servlet.ServletException;
import java.io.PrintWriter;

/**
 * taken from:
 * http://blog.diefirma.de/2006-03-30/nice-error-pages/
 */
public class ExceptionReport {

   protected ExceptionReport() {
        // prevents calls from subclass
        throw new UnsupportedOperationException();
    }

    
    public static void print (PrintWriter writer, Throwable throwable) {
        Throwable rootCause = null;
        if (throwable instanceof ServletException) {
            rootCause = ((ServletException) throwable).getRootCause ();
	}
        
        throwable.printStackTrace (writer);
        
        while (rootCause != null) {
            writer.println ("Root cause:");
            rootCause.printStackTrace (writer);
            try {
                rootCause = (Throwable) rootCause.getClass ().getMethod ("getRootCause", new Class[] {}).invoke (rootCause, new Object[] {});
            } catch (Exception e) {
                rootCause = null;
            }
        }
    }
}