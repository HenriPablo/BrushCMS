/*
 * TimeDate.java
 *
 * Created on February 28, 2007, 8:39 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package bap.domain;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author rohan
 */
public class TimeDate {
    
    /** Creates a new instance of TimeDate */
    public TimeDate () { }
    
    public final Date getDate ( ) {
	    return new Date ( System.currentTimeMillis () );
}
    
    
    public final String getTime (  ) {
    String d = new Date ( System.currentTimeMillis ()).toString ();
    String t = new Time ( System.currentTimeMillis () ).toString ();  
    return  d + " " + t;    

}
}
