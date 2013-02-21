/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bap.test.integration;

import bap.domain.Tag;
import java.util.List;

import bap.persistance.dao.TagDao;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
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
 * @author tomaszbrymora
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:bap/resources/applicationContext.xml"})
public class TagDaoTest extends AbstractJUnit4SpringContextTests {

	// http://today.java.net/pub/a/today/2005/10/11/testing-hibernate-mapping.html
	// http://livingtao.blogspot.com/2007/08/unit-testing-with-junit-spring-and.html

	public TagDaoTest() { }
	
	TagDao instance;


	@BeforeClass
	public static void setUpClass() throws Exception {
		System.out.println("\ncalled setUpClass()\n");
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
		System.out.println("\ncalled tearDownClass()\n");
	}

	@Before
	public void setUp() {
		System.out.println("\ncalled seUp()\n");
		Configuration configuration = HibernateConfiguration.getHibernateConfiguration().configuration( Tag.class );// configuration();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		instance = new TagDao();
		instance.setSessionFactory(sessionFactory);
	}

	@After
	public void tearDown() {
		System.out.println("\ncalled tearDown()\n");
	}

	@Test
	public void testGet() {
		System.out.println("\n\tcalled testGet() :: testing :: get\n");
		int tagId = 2;
		Tag result = instance.get(tagId);
		assertNotNull("we have a tag!!!", result);
	}
	
	/** 
	 * Test of list method, of class TagDao.
	 */
	@Test
	public void testList() {
	System.out.println("\n\tcalled testList() :: testing :: list\n");
	List<Tag> result = instance.list();
	assertNotNull("we have a list of tags!", result);
	}


	/**
	 * Test of save method, of class TagDao.
	 */
	@Test
	public void testSaveUpdateLatestDelete() {
	System.out.println("\n\tcalled testSaveUpdateLatestDelete() :: testing :: save update latest delete\n");
	Tag tag = new Tag();
	tag.setDescription("JUnit Test Tag!!!!");
	int tempId;
		instance.save(tag);
	tempId = tag.getId();
	System.out.println("\n\tNew Tag Saved: " + tempId + "\n");

	tag  = instance.get(tempId );
	tag.setDescription("updated tag description!");
	instance.update(tag);
	System.out.println("\n\tTag Updated: " + instance.get(tempId).toString() );

	tag = (Tag) instance.latest();
	System.out.println("\n\tLatest Tag : " + tag.getId() + "\n");

	instance.delete(tag.getId());
	tag = (Tag) instance.latest();
	System.out.println("\n\tLatest Tag after DELETE : " + tag.getId() + "\n");

	}

}
