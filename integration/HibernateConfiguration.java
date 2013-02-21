/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bap.test.integration;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

/**
 *
 * @author tomaszbrymora
 */
public class HibernateConfiguration {

	private HibernateConfiguration(){}


	public Configuration configuration( Class clazz) {

	Configuration c = new Configuration();
		c.setProperty(Environment.DRIVER, "org.postgresql.Driver");
		c.setProperty(Environment.URL, "jdbc:postgresql://localhost/brush_and_pixel");
		c.setProperty(Environment.USER, "postgres");
		c.setProperty(Environment.PASS, "solaris");
		c.setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
		c.setProperty(Environment.AUTOCOMMIT, "true"); //"true");
        c.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        c.addClass( clazz );

		return c;
	}

	public static HibernateConfiguration getHibernateConfiguration(){
		return new HibernateConfiguration();
	}

}
