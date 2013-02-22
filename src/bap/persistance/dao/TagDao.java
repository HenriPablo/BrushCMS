/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bap.persistance.dao;

import bap.domain.DomainObject;
import bap.domain.Tag;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author tomaszbrymora
 */

@Transactional(propagation = Propagation.REQUIRED)
public class TagDao {

    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory; }
    public SessionFactory getSessionFactory() { return sessionFactory; }



    public  Tag get(int id) {
        return (Tag) getSessionFactory().getCurrentSession().get( Tag.class, id );// this.getSession().get( Setting.class, id );
	}

    //@Transactional
    @Transactional(readOnly=true, propagation=Propagation.REQUIRES_NEW)
	public List list(){
        Session s = sessionFactory.getCurrentSession();
        //getSessionFactory().getCurrentSession().getTransaction().begin();
        List<Tag> ls = s.createQuery( "from Tag " ).list();
        s.flush();
        //getSessionFactory().getCurrentSession().flush();
        //getSessionFactory().getCurrentSession().getTransaction().commit();
        return ls;
	}


	public void save( DomainObject obj ){
        getSessionFactory().getCurrentSession().getTransaction().begin();
        getSessionFactory().getCurrentSession().saveOrUpdate( obj );
        getSessionFactory().getCurrentSession().flush();
        getSessionFactory().getCurrentSession().getTransaction().commit();
	}


	public void update(DomainObject obj) {
        getSessionFactory().getCurrentSession().getTransaction().begin();
        getSessionFactory().getCurrentSession().merge( obj );
        getSessionFactory().getCurrentSession().flush();
        getSessionFactory().getCurrentSession().getTransaction().commit();
	}


	public void delete(int id) {
        getSessionFactory().getCurrentSession().getTransaction().begin();
        getSessionFactory().getCurrentSession().createQuery("delete from Tag where id = '" + id + "'" ).executeUpdate();
        getSessionFactory().getCurrentSession().getTransaction().commit();
	}

    public DomainObject getArticleLink(String section) {
        //To change body of implemented methods use File | Settings | File Templates.
        return null;
    }

	public DomainObject latest() {
		Query q =  getSessionFactory().openSession().createQuery("from Tag where id = ( select max( id ) from Tag)");
		return (Tag) q.uniqueResult();
	}


}//TagDao
