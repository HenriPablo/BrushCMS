package bap.test.integration;

import bap.services.PropDBFetcher;
import bap.services.PropFileFetcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = {"classpath:bap/resources/applicationContext.xml"})
public class PropFileFetcherTest extends AbstractJUnit4SpringContextTests {

    public PropFileFetcherTest(){}

    @Autowired
    PropFileFetcher propFileFetcher;

    @Autowired
    PropDBFetcher propDBFetcher;

    @Test
    public void readTest(){
          propFileFetcher.myProps();
    }

    @Test
    public void readDbTest(){
     System.out.println( propDBFetcher.getSetting("pix.width"));
    }

}
