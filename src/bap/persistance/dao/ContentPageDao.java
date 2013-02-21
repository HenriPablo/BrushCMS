/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bap.persistance.dao;

import bap.domain.ContentPage;
import bap.domain.DomainObject;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author tomek
 */
@Transactional
public class ContentPageDao  {

    private SessionFactory sessionFactory;



    @Transactional
	public void save(DomainObject obj) {
        Session s = sessionFactory.getCurrentSession();
        s.getTransaction().begin();

			 s.saveOrUpdate(  obj) ;
			s.flush();
        s.getTransaction().commit();
	}


	@Transactional
	public void update( DomainObject contentPage ) {
        Session s = sessionFactory.getCurrentSession();
        s.getTransaction().begin();
		 s.update(contentPage);
        s.flush();
        s.getTransaction().commit();
	}


	@Transactional
	public List list() {
        List l;
        Session s = sessionFactory.getCurrentSession();
        s.getTransaction().begin();

		l = s.createQuery( "from ContentPage " ).list();
        s.flush();
        s.getTransaction().commit();
        return  l;
	}


	@Transactional
	public ContentPage get(int id) {
        ContentPage cp;
        Session s = sessionFactory.getCurrentSession();
        s.getTransaction().begin();
		cp =  (ContentPage) s.get(ContentPage.class, id) ;
        s.flush();
        s.getTransaction().commit();
        return cp;
	}


	@Transactional
	public void delete( int id ){
        Session s = sessionFactory.getCurrentSession();
        s.getTransaction().begin();

		Query query = s.createQuery("delete from ContentPage where id = '" + id + "'" );
		query.executeUpdate();
        s.flush();
        s.getTransaction().commit();
	}

    public DomainObject getArticleLink(String section) {
        DomainObject dm;
        Session s = sessionFactory.getCurrentSession();
        s.getTransaction().begin();

        Query q = s.createQuery( "from ContentPage where linkHref = '"  + section + "'" );
        dm = (ContentPage) q.uniqueResult();
        s.flush();
        s.getTransaction().commit();
        return dm;
    }

	public DomainObject latest() {
        DomainObject dm;
        Session s = sessionFactory.getCurrentSession();
        s.getTransaction().begin();

        Query q =  s.createQuery( "select cp   from ContentPage cp left join cp.tags as t where t.description ='article'  order by cp.modified desc");
        q.setMaxResults(1);

        dm = (ContentPage) q.uniqueResult();
        s.flush();
        s.getTransaction().commit();
        return  dm;
	}

	public DomainObject getLatestArticle(){
		return null;
	}

    /**
     *
     * @param tagValue
     * @param quntity
     * @return List of content pages associated with a certain Tag description value,
     * for instance N number of content pages tagged 'article'
     */

    public List getLatestByTagAndQty(String tagValue, int quntity ){
        List l;
        Session s = sessionFactory.getCurrentSession();
        s.getTransaction().begin();

        Query q = s.createQuery( "select cp from ContentPage cp left join cp.tags as t where t.description = " + tagValue + " order by cp.modified desc");
        q.setMaxResults( quntity );
        l =  q.list();
        s.flush();
        s.getTransaction().commit();
        return l;

    }


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
