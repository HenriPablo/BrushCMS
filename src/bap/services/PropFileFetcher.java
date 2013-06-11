package bap.services;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: tomekpilot
 * Date: 6/9/13
 * Time: 11:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class PropFileFetcher {

    public void myProps(){
        Resource resource = new ClassPathResource("/resources/properties/Pix.properties");
        try {
            Properties props = PropertiesLoaderUtils.loadProperties(resource);
            System.out.println( props.getProperty("pix.width"));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
