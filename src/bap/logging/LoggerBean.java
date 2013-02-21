/*
 * LoggerBean.java
 *
 * Created on October 18, 2007, 2:16 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package bap.logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author tomaszbrymora
 */
public final class LoggerBean {
    
    /** prevent creation of a new instance of LoggerBean */
    private LoggerBean () {}
    /** instance of LoggerBean accessible only through getter method */
    private static LoggerBean loggerBean = null;
    
    /** Logger itself for this class and subclasses */
    private final Log  logger = LogFactory.getLog(getClass());    
    
    public static  LoggerBean getLoggerBean ( ) {
        if ( loggerBean == null ) {
            loggerBean = new LoggerBean ( );
        }
        return loggerBean;
    }// getLoggerBean
    public Log getLogger ( ) {
        return logger;
    }
    
}
