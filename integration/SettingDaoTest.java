package bap.test.integration;

import bap.persistance.dao.SettingDao;
import bap.settings.Setting;
import bap.settings.SettingsGroup;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//import bap.domain.Link;

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
public class SettingDaoTest extends AbstractJUnit4SpringContextTests {

    public SettingDaoTest(){}

    SettingDao settingDao;

    private Setting setting1;
    private Setting setting2;
    private SettingsGroup settingsGroup;

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

            .configuration(Setting.class)
            .addClass( SettingsGroup.class);

        SessionFactory sessionFactory = c.buildSessionFactory();

        settingDao = new SettingDao();
        settingDao.setSessionFactory( sessionFactory );
        //settingDao.getSessionFactory().getCurrentSession().getTransaction().begin();

        settingsGroup = new SettingsGroup();


        setting1 = new Setting();

        setting1.setLabel("setting 1 name in setup");
        setting1.setCode("setting_group_1_code_in_setup");

        settingsGroup = new SettingsGroup();
        settingsGroup.setName( "setting group 2 name in setup");
        settingsGroup.setCode( "setting_group_2_code_in_setup" );

         setting2 = new Setting();
        setting2.setLabel("setting 3 name in setup");
        setting2.setCode("setting_group_3_code_in_setup");

    }
    @After
    public void tearDown(){

    }

    @Test
    @Rollback(true)
    public void testSave() throws Exception {
        //SettingsGroup sg = new SettingsGroup();
        settingsGroup.setCode("testCode");
        settingsGroup.setName("Test Name");
        settingsGroup.setId(22222);

        setting1.setSettingsGroup( settingsGroup );


        //settingDao.getSessionFactory().getCurrentSession().getTransaction().begin();
        settingDao.save(setting1);
        System.out.println( "setting 1 id: " + setting1.getId() );
        //settingDao.getSessionFactory().getCurrentSession().getTransaction().rollback();

    }

    @Test
    @Rollback(true)
    public void testGet() throws Exception {
        settingsGroup.setCode("testCode");
        settingsGroup.setName("Test Name");
        settingsGroup.setId(222);

        setting1.setSettingsGroup( settingsGroup );
        setting1.setLabel("label set in tetGet() ");
        settingDao.save(setting1);

        System.out.println("id of setting 1: " + setting1.getId() );
    }

    @Test
    @Rollback(true)
    public void testList() throws Exception {
        settingsGroup.setCode("testCode4");
        settingsGroup.setName("Test Name 4");
        settingsGroup.setId(222);

        setting1.setSettingsGroup( settingsGroup );
        setting1.setLabel("label in testList() ");
        settingDao.save(setting1);
        List <Setting> sl = settingDao.list();
        System.out.println("settings list size: " + sl.size() );
    }

    @Test
    @Rollback(true)
    public void testUpdate() throws Exception{
        //Setting sg = settingDao.get(1);
        //sg.setLabel("Updated Name of Setting Group");
        //settingDao.update(sg);


        //settingsGroupDao.getSessionFactory().getCurrentSession().flush();
        //List <Setting> sl = settingDao.list();

       // Hibernate.initialize( settingDao.list() );

        //System.out.println( "UPDATED Settings Group Name: " + sg.getLabel() );
    }

    @Test
    public void testDelete() throws Exception{

       System.out.println( "seeting 1 id in delete: " + setting1.getId() );

       List<Setting> ls = settingDao.list();
       int ls1 = ls.size();
       int id = ls.get(0).getId();
       System.out.println( "id in delete: " + id );
       System.out.println( "Size after delete: " + ls1 );
//
//        settingDao.delete( 2 );
//
//
//        int ls2 = settingDao.list().size();
//
//        System.out.println( "Size after delete: " + ls2 );

    }
}
