/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bap.test.integration;


//import bap.domain.Link;
import bap.domain.Navigation;
import bap.domain.NavigationSection;
import bap.persistance.dao.NavigationSectionDao;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

/**
 *
 * @author tomaszbrymora
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:bap/resources/applicationContext.xml"})
public class NavigationSectionDaoTest extends AbstractJUnit4SpringContextTests  {

    public NavigationSectionDaoTest() {
    }
NavigationSectionDao instance;
	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

    @Before
    public void setUp() {
		Configuration c = HibernateConfiguration.getHibernateConfiguration().configuration( NavigationSection.class )
			.addClass(Navigation.class);// configuration();
		SessionFactory sessionFactory = c.buildSessionFactory();
		instance = new NavigationSectionDao();
		instance.setSessionFactory(sessionFactory);
    }

	/**
	 * Test of save method, of class NavigationSectionDao.
	 */
	@Test
	public void testSave() {
		System.out.println("\nsave\n");
		NavigationSection obj =  new NavigationSection();
		Navigation n = new Navigation();
		n.setId(11);
		obj.setHref("temp href");
		obj.setLabel("temp label");
		obj.setNavigation( n );

		int expResult = 0;
		 instance.save(obj);

		System.out.println("\nSaved Navigation Section ID:" + obj.getId() + "\n");
		assertTrue(expResult < obj.getId() );
	}

//	/**
//	 * Test of get method, of class NavigationSectionDao.
//	 */
//	@Test
//	public void testGet() {
//		System.out.println("get");
//		int id = 0;
//		NavigationSectionDao settingsGroupDao = new NavigationSectionDao();
//		DomainObject expResult = null;
//		DomainObject result = settingsGroupDao.get(id);
//		assertEquals(expResult, result);
//		fail("The test case is a prototype.");
//	}
//
//	/**
//	 * Test of latest method, of class NavigationSectionDao.
//	 */
//	@Test
//	public void testLatest() {
//		System.out.println("latest");
//		NavigationSectionDao settingsGroupDao = new NavigationSectionDao();
//		DomainObject expResult = null;
//		DomainObject result = settingsGroupDao.latest();
//		assertEquals(expResult, result);
//		fail("The test case is a prototype.");
//	}
//
//	/**
//	 * Test of list method, of class NavigationSectionDao.
//	 */
//	@Test
//	public void testList() {
//		System.out.println("list");
//		NavigationSectionDao settingsGroupDao = new NavigationSectionDao();
//		List expResult = null;
//		List result = settingsGroupDao.list();
//		assertEquals(expResult, result);
//		fail("The test case is a prototype.");
//	}
//
//	/**
//	 * Test of update method, of class NavigationSectionDao.
//	 */
//	@Test
//	public void testUpdate() {
//		System.out.println("update");
//		DomainObject obj = null;
//		NavigationSectionDao settingsGroupDao = new NavigationSectionDao();
//		settingsGroupDao.update(obj);
//		fail("The test case is a prototype.");
//	}
//
//	/**
//	 * Test of delete method, of class NavigationSectionDao.
//	 */
//	@Test
//	public void testDelete() {
//		System.out.println("delete");
//		int id = 0;
//		NavigationSectionDao settingsGroupDao = new NavigationSectionDao();
//		settingsGroupDao.delete(id);
//		fail("The test case is a prototype.");
//	}

}