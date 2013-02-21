/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bap.test.integration;


import bap.domain.Comment;
import bap.domain.ContentPage;
import bap.domain.NavigationSection;
//import bap.domain.Link;
import bap.domain.Navigation;
import bap.domain.Tag;
import java.util.HashSet;
import java.util.Set;

import bap.persistance.dao.CommentDao;
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
public class CommentDaoTest extends AbstractJUnit4SpringContextTests {

    public CommentDaoTest() {
    }

CommentDao commentDao;


	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Configuration c = HibernateConfiguration.getHibernateConfiguration().configuration(
                 Comment.class )
			.addClass(ContentPage.class)
			.addClass(Tag.class)
			.addClass(NavigationSection.class)
			.addClass(Navigation.class);// configuration();
		
		SessionFactory sessionFactory = c.buildSessionFactory();
		commentDao = new CommentDao();
		commentDao.setSessionFactory(sessionFactory);
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
		System.out.println("\nsave\n");
		
		ContentPage contentPage = this.contentPageDomainObjectHelper()  ;//new ContentPage();
		Comment comment = new Comment();

		comment.setBody("some comment bdy");
		comment.setCommenter("Bob anonymous");
		comment.setContentPage(contentPage);
		comment.setEmail("some@email.com");
		comment.setWebsite("www.bobssite.com");

		//Set nsn = new HashSet();
		//nsn.add(comment);

		//contentPage.setNavigationSections(nsn);

		int expResult = 0;
		int result = commentDao.save(comment);
		int latestId = 0;

		System.out.println("\nSaved Comment ID:" + result + "\n");
		assertTrue(expResult < result);
		//fail("not equal");

//		System.out.println("\nget\n");
//		contentPage = (Navigation) settingsGroupDao.get(result);
//		System.out.println("\tget id: " + contentPage.getId() + "\n");
//
//		System.out.println("\nlatest\n");
//		contentPage = (Navigation) settingsGroupDao.latest();
//		latestId = contentPage.getId();
//		System.out.println("\tlatest id: " + latestId + "\n");
//
//		System.out.println("\nlist\n");
//		List<Navigation> navs = settingsGroupDao.list();
//		for( Navigation n : navs){
//			System.out.println("\n\t" + n.getId() + "\n");
//		}
//
//		System.out.println("\ndelete\n");
//		settingsGroupDao.delete(latestId);
	}

	/**
	 * Test of update method, of class NavigationDao.
	 */
//	@Test(expected=UnsupportedOperationException.class)
//	public void testUpdate() {
//		System.out.println("update");
//		DomainObject obj = null;
//		NavigationDao settingsGroupDao = new NavigationDao();
//		settingsGroupDao.update(obj);
//		fail("The test case is a nutcase.");
//	}

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

	private ContentPage contentPageDomainObjectHelper(){

		NavigationSection ns =  new NavigationSection();

		/**
			MAKE SURE: nav set id has to exist in the db for the test to work
		 *   		WHEN integration persis to db
		 */
		ns.setId(20);
		ns.setHref("temp_href");
		ns.setLabel("ns label");

		Set nss = new HashSet();
		nss.add(ns);

		Navigation n = new Navigation();
		n.setId(11);
		n.setNavigationSections(nss);

		/**
		 * with TAGS
		 */
		Tag t = new Tag();
		t.setId(23);
		t.setDescription("tet tag description");

		Set tagSet = new HashSet();
		tagSet.add(t);


		ContentPage cp = new ContentPage();
		
		cp.setId(32);

		cp.setMetaDescription("some description");
		cp.setMetaKeywords("some keywordss");
		cp.setNavigationSection(ns);
		cp.setTitle("some title");
		cp.setSubTitle("nice subtitle");
		cp.setContent("content body");
		cp.setAllowComments(true);
		cp.setLinkHref("some_link_href");
		cp.setLinkLabel("link label");
		cp.setCompletion(true);

		//cp.setTags(tagSet);

		//cp.setContentPageDisplayOrder(0);


		return cp;
	}
}