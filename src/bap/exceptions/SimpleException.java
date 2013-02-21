/*
 * SimpleException.java
 *
 * Created on October 9, 2007, 12:34 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package bap.exceptions;

/**
 *
 * @author tomaszbrymora
 */
public class SimpleException extends Exception  {
    
    /** Creates a new instance of SimpleException */
    public SimpleException () { }
    
    public SimpleException( String msg ) {
        super( msg );
    } //SimpleException 
    
} // SimpleException
