/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bap.persistance.dao;

import bap.domain.DomainObject;
import bap.domain.NavigationSection;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author tomaszbrymora
 */
@Transactional(propagation = Propagation.REQUIRED)
public class NavigationSectionDao  {

    @Resource
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
    public SessionFactory getSessionFactory() {return sessionFactory;}


    public void save(DomainObject obj) {
        Session s = getSessionFactory().getCurrentSession();
        s.getTransaction().begin();
        
		s.saveOrUpdate(obj);
		s.flush();
	}


	public DomainObject get(int id) {
        DomainObject d;
        Session s = getSessionFactory().getCurrentSession();
       // s.getTransaction().begin();
		d =  (DomainObject) s.get(NavigationSection.class, id);
        s.flush();
        //s.getTransaction();
        return d;
	}


	public DomainObject latest() {
		throw new UnsupportedOperationException("Not supported yet.");
	}


	public List list() {
        List l;
        Session s = getSessionFactory().getCurrentSession();
        //s.getTransaction().begin();

		l = s.createQuery("from NavigationSection" ).list();
        s.flush();
        //s.getTransaction();

        return l;

	}


	public void update(DomainObject obj) {
        Session s = getSessionFactory().getCurrentSession();
        s.getTransaction().begin();
		s.merge(obj);
		s.flush();
        s.getTransaction().commit();
	}


	public void delete(int id) 	{
        Session s = getSessionFactory().getCurrentSession();
        s.getTransaction().begin();
		Query query = s.createQuery("delete from NavigationSection where id = '" + id + "'" );
		query.executeUpdate();
        s.flush();
        s.getTransaction().commit();
	}

    public DomainObject getArticleLink(String section) {
        //To change body of implemented methods use File | Settings | File Templates.
        return null;
    }


}
