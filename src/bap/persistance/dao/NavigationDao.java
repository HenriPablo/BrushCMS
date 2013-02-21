/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bap.persistance.dao;

import bap.domain.ContentPage;
import bap.domain.DomainObject;
import bap.domain.Navigation;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import javax.annotation.Resource;
import javax.naming.OperationNotSupportedException;
import java.util.List;

/**
 *
 * @author tomaszbrymora
 */
public class NavigationDao  {
    @Resource
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
    public SessionFactory getSessionFactory() {return sessionFactory;}


	public void save(DomainObject obj) {
        Session s = getSessionFactory().getCurrentSession();
        s.getTransaction().begin();

		s.saveOrUpdate(obj);
		s.flush();
        s.getTransaction().commit();
	}

	public DomainObject get(int id) {
        DomainObject d;
        Session s = getSessionFactory().getCurrentSession();
        s.getTransaction().begin();

		d = (DomainObject) s.get(Navigation.class, id);
        s.flush();
        s.getTransaction().commit();
        return  d;
	}
	
	public DomainObject latest() {
        DomainObject d;
        Session s = getSessionFactory().getCurrentSession();
        s.getTransaction().begin();

		Query q = s.createQuery("from Navigation where id = ( select max( id ) from Navigation )");
		d = (Navigation) q.uniqueResult();
        s.flush();
        s.getTransaction();
        return  d;
	}

	public List list() {
        List l;
        Session s = getSessionFactory().getCurrentSession();
        s.getTransaction().begin();

		l = s.createQuery("from Navigation" ).list();
        s.flush();
        s.getTransaction().commit();
        return l;
	}

	/**
	 *
	 * @param id
	 * @return
	 * @throws OperationNotSupportedException
	 * 
	 */
	public DomainObject getLimited( int id ) throws OperationNotSupportedException{
        DomainObject d;
        Session s = getSessionFactory().getCurrentSession();
        s.getTransaction().begin();

		Criteria c = s.createCriteria(ContentPage.class).setProjection(Projections.property("label")).setProjection(Projections.property("ahref"));
		c.setMaxResults( 1 );
        d = (DomainObject) c.list().get(1);
        return d;
	}

	public void update(DomainObject obj) {
		throw new UnsupportedOperationException("Not supported :: Navigation ID elements are not modifiable.");
	}

	public void delete(int id) {
        Session s = getSessionFactory().getCurrentSession();
        s.getTransaction().begin();

		Query query = s.createQuery("delete from Navigation where id = '" + id + "'");
		query.executeUpdate();
        s.flush();
        s.getTransaction().commit();
	}

    public DomainObject getArticleLink(String section) {
        //To change body of implemented methods use File | Settings | File Templates.
        return null;
    }

}
