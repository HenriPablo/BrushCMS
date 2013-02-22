/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bap.persistance.dao;

import bap.domain.Album;
import bap.domain.DomainObject;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author tomek
 */

@Transactional(propagation = Propagation.REQUIRED)
public class AlbumDao  {

    @Resource
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory; }
    public SessionFactory getSessionFactory() { return sessionFactory; }


    //	@Override
	public void save(DomainObject obj) {
        getSessionFactory().getCurrentSession().getTransaction().begin();
        getSessionFactory().getCurrentSession().saveOrUpdate( obj );
        getSessionFactory().getCurrentSession().flush();
        getSessionFactory().getCurrentSession().getTransaction().commit();
	}

//	@Override
	public DomainObject get(int id) {
		return (DomainObject) getSessionFactory().getCurrentSession().get(Album.class, id);
	}

//	@Override
	public DomainObject latest() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

//	@Override
//	@Transactional
	public List list() {
        //getSessionFactory().getCurrentSession().getTransaction().begin();
        List<Album> ls = getSessionFactory().getCurrentSession().createQuery( "from Album " ).list();// .load( Setting.class);// this.getHibernateTemplate().loadAll( Setting.class );
        //getSessionFactory().getCurrentSession().flush();
        //getSessionFactory().getCurrentSession().getTransaction().commit();
        return ls;
	}

//	@Override
	public void update(DomainObject obj) {
        getSessionFactory().getCurrentSession().getTransaction().begin();
        getSessionFactory().getCurrentSession().merge( obj );
        getSessionFactory().getCurrentSession().flush();
        getSessionFactory().getCurrentSession().getTransaction().commit();
	}

//	@Override
	public void delete(int id) {
        getSessionFactory().getCurrentSession().getTransaction().begin();
        getSessionFactory().getCurrentSession().createQuery("delete from Album where id = '" + id + "'" ).executeUpdate();
        getSessionFactory().getCurrentSession().getTransaction().commit();
	}

    public DomainObject getArticleLink(String section) {
        //To change body of implemented methods use File | Settings | File Templates.
        return null;
    }

}
