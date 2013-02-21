/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bap.test.integration;


import bap.domain.Tag;
import bap.domain.Comment;
import bap.domain.ContentPage;
import bap.domain.NavigationSection;
import bap.domain.DomainObject;
//import bap.domain.Link;
import bap.domain.Navigation;
import java.util.List;

import bap.persistance.dao.NavigationDao;
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
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.*;

/**
 *
 * @author tomaszbrymora
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:bap/resources/applicationContext.xml"})
@TransactionConfiguration( transactionManager="transactionManager", defaultRollback=true )
@Transactional
public class NavigationDaoTest extends AbstractJUnit4SpringContextTests {

    public NavigationDaoTest() {
    }

NavigationDao instance;


	@BeforeClass
	public static void setUpClass() throws Exception { }

	@Before
	public void setUp() throws Exception {
		Configuration c = HibernateConfiguration.getHibernateConfiguration()
			.configuration( Navigation.class )
			.addClass(NavigationSection.class)
			.addClass(ContentPage.class)
			.addClass(Comment.class)
			.addClass(Tag.class);// configuration();
		SessionFactory sessionFactory = c.buildSessionFactory();
		instance = new NavigationDao();
		instance.setSessionFactory(sessionFactory);
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}


	/**
	 * Test of get method, of class NavigationDao.
	 */
//	@Test
//	public void testGet() {
//		System.out.println("get");
//		int id = 0;
//		NavigationDao settingsGroupDao = new NavigationDao();
//		Object expResult = null;
//		Object result = settingsGroupDao.get(id);
//		assertEquals(expResult, result);
//		fail("The test case is a prototype.");
//	}

	/**
	 * Test of list method, of class NavigationDao.
	 */
//	@Test
//	public void testList() {
//		System.out.println("list");
//		NavigationDao settingsGroupDao = new NavigationDao();
//		List expResult = null;
//		List result = settingsGroupDao.list();
//		assertEquals(expResult, result);
//		fail("The test case is a prototype.");
//	}

	/**
	 * Test of save method, of class NavigationDao.
	 */
	@Test
	public void testSave() {
//		System.out.println("\nsave\n");
//
		Navigation obj = new Navigation();
		NavigationSection ns = new NavigationSection();
//		ns.setId(9);
//		ns.setHref("lkj");
//		ns.setLabel("adfadf");
//		Set nsn = new HashSet();
//		nsn.add(ns);
//		obj.setNavigationSections(nsn);
//
//		int expResult = 0;
//		int result = settingsGroupDao.save(obj);
//		int latestId = 0;
//
//		System.out.println("\nSaved Navigation ID:" + result + "\n");
//		assertTrue(expResult < result);
//		//fail("not equal");
//
//		System.out.println("\nget\n");
//		obj = (Navigation) settingsGroupDao.get(result);
//		System.out.println("\tget id: " + obj.getId() + "\n");
//
//		System.out.println("\nlatest\n");
//		obj = (Navigation) settingsGroupDao.latest();
//		latestId = obj.getId();
//		System.out.println("\tlatest id: " + latestId + "\n");
//
//		System.out.println("\nlist\n");
		List<Navigation> navs = instance.list();



		for( Navigation n : navs){
			System.out.println("\n\tNavigation id : " + n.getId() + "\n");
				for( NavigationSection ns2 :   n.getNavigationSections()  ){

					System.out.println("\n\t\tNav Section Id 	: " + ns2.getId() );
					System.out.println("\n\t\tNav Section Label 	: " + ns2.getLabel() );// getLabel() );
					System.out.println("\n\t\tNav Section Href 	: " + ns2.getHref() );

						for( ContentPage  cp : ns2.getContentPages() ){
							System.out.println("\n\t\t\tContent Page Title : " + cp.getTitle() );
								for( Comment com : cp.getComments() ){
									System.out.println("\n\t\t\tComment Author  : " + com.getCommenter() );
								}
								for(  Tag t : cp.getTags() ){
									System.out.println("\n\t\t\t\tTag Description : " + t.getDescription() );
								}
						}

				}
		}

//		System.out.println("\ndelete\n");
//		settingsGroupDao.delete(latestId);
	}

	/**
	 * Test of update method, of class NavigationDao.
	 */
	@Test(expected=UnsupportedOperationException.class)
	public void testUpdate() {
		System.out.println("update");
		DomainObject obj = null;
		NavigationDao instance = new NavigationDao();
		instance.update(obj);
		fail("The test case is a nutcase.");
	}

	/**
	 * Test of delete method, of class NavigationDao.
	 */
//	@Test
//	public void testDelete() {
//		System.out.println("delete");
//		int id = 0;
//		NavigationDao settingsGroupDao = new NavigationDao();
//		settingsGroupDao.delete(id);
//		fail("The test case is a prototype.");
//	}

}