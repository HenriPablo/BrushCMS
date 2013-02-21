/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bap.test.integration;

import bap.domain.Comment;
import java.util.Set;

import bap.persistance.dao.ContentPageDao;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.ContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import bap.domain.NavigationSection;
import org.hibernate.cfg.Configuration;
import bap.domain.Navigation;
import bap.domain.ContentPage;
//import bap.domain.Link;
import bap.domain.Tag;
import java.sql.SQLException;
import java.util.HashSet;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tomaszbrymora
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:bap/resources/applicationContext.xml"})
public class ContentPageDaoTest extends AbstractJUnit4SpringContextTests {

    public ContentPageDaoTest() { }
    ContentPageDao instance;

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

    @Before
    public void setUp() {
	    Configuration c  = HibernateConfiguration.getHibernateConfiguration()
		    .configuration( ContentPage.class)
		    .addClass(NavigationSection.class)
		    .addClass(Navigation.class)
		    .addClass(Tag.class)
		    .addClass(Comment.class);

	    SessionFactory sessionFactory = c.buildSessionFactory();
	    instance = new ContentPageDao();
	    instance.setSessionFactory(sessionFactory);
    }

	/**
	 * Test of saveContentPage method, of class ContentPageDao.
	 */
	@Test
	public void testSaveContentPage() throws SQLException {
		System.out.println("\nsaveContentPage\n");

		int expResult = 0;
		int result = 0;
		instance.save(contentPageDomainObjectHelper());
		System.out.println("\nSaved Content Page ID:" + result + "\n");
		assertTrue(expResult < result);
	}

	/**
	 * Test of update method, of class ContentPageDao.
	 */
	@Test
	public void testGetLatestAndUpdate() {
		System.out.println("\nget latest update\n");

		ContentPage cpLatest = (ContentPage) instance.latest();
		int i = cpLatest.getId() -1;

		System.out.println("\nget latest update - interpolated id: " +  i + "\n");

		ContentPage cp = instance.get( i );
		cp.setTitle("updated title");
		cp.setContentPageDisplayOrder(3);
		instance.update( cp );
		instance.delete( cp.getId() -2 );
		instance.delete( 32 );
	}

	/**
	 * Test of list method, of class ContentPageDao.
	 */
//	@Test
//	public void testList() {
//		System.out.println("\nlist\n");
//		List expResult = null;
//		List result = settingsGroupDao.list();
//	}





	private NavigationSection navigationSectionDomainObjectHelper(){
		return new NavigationSection();
	}



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

		cp.setTags(tagSet);

		//cp.setContentPageDisplayOrder(0);


		return cp;
	}

}