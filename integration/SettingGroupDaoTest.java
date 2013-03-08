package bap.test.integration;

import bap.persistance.dao.SettingGroupDao;
import bap.settings.Setting;
import bap.settings.SettingsGroup;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.ContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.hibernate.cfg.Configuration;
//import bap.domain.Link;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: tomekpilot
 * Date: 1/23/13
 * Time: 9:45 PM
 * To change this template use File | Settings | File Templates.
 */



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = {"classpath:bap/resources/applicationContext.xml"})
@Transactional
@TransactionConfiguration( defaultRollback = true )
public class SettingGroupDaoTest extends AbstractJUnit4SpringContextTests {

    public SettingGroupDaoTest(){}

    //@Autowired
    SettingGroupDao settingsGroupDao;


    private SettingsGroup sg1;
     SettingsGroup sg2;
    private SettingsGroup sg3;


    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }


    @Before
    public void setUp()   {
        /**/
        Configuration c  = HibernateConfiguration.getHibernateConfiguration()

                .configuration(SettingsGroup.class).addClass( Setting.class);

        SessionFactory sessionFactory =  c. buildSessionFactory();

        settingsGroupDao = new SettingGroupDao();
        settingsGroupDao.setSessionFactory(sessionFactory);

         sg1 = new SettingsGroup();

        sg1.setName( "setting group 1 name in setup");
        sg1.setCode( "setting_group_1_code_in_setup" );

         sg2 = new SettingsGroup();
        sg2.setName( "setting group 2 name in setup");
        sg2.setCode( "setting_group_2_code_in_setup" );

         sg3= new SettingsGroup();
        sg3.setName( "setting group 3 name in setup");
        sg3.setCode( "setting_group_3_code_in_setup" );

    }



    @Test
    public void testSave() throws Exception {



        settingsGroupDao.save(sg2);
        System.out.println( "sg2 id: " + sg2.getId() );

    }

    @Test
    public void testGet() throws Exception {
        List <SettingsGroup> l = settingsGroupDao.list( );
        System.out.println("size of SettingsGroup list: " + l.size() );
    }

    @Test
    public void testList() throws Exception {
        List<SettingsGroup> sqList =  settingsGroupDao.list();
        Hibernate.initialize( sqList );
        SettingsGroup s1 = sqList.get(1).getChildren().get(0);
        System.out.println( "children index 2 name: " + s1.getName() );
        System.out.println( "2nd element of children: " + s1.getName() );
    }

    @Test
    public void testUpdate() throws Exception{
        SettingsGroup sg = settingsGroupDao.get(1);
        sg.setName("Updated Name of Setting Group");
        settingsGroupDao.update(sg);


        //settingsGroupDao.getSessionFactory().getCurrentSession().flush();
        List <SettingsGroup> sl = settingsGroupDao.list();

//        Hibernate.initialize( settingsGroupDao.list() );

        System.out.println( "UPDATED Settings Group Name: " + sg.getName() );
    }

    @Test
    public void testDelete() throws Exception{





        //int ls1 = settingsGroupDao.list().size();
        //System.out.println("Size after insert: " + ls1);

       // settingsGroupDao.delete(156);


        int ls2 = settingsGroupDao.list().size();

        System.out.println( "Size after delete: " + ls2 );

    }
}
