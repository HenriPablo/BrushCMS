/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bap.persistance.dao;

import bap.domain.DomainObject;
import bap.domain.Image;
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
 * @author tomaszbrymora
 */

@Transactional(propagation = Propagation.REQUIRED)
public class ImageDao {

    @Resource
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory; }
    public SessionFactory getSessionFactory() { return sessionFactory; }



	public List list() {
        List<Image> ls = getSessionFactory().getCurrentSession().createQuery( "from Image " ).list();
        getSessionFactory().getCurrentSession().flush();
        return ls;
	}


	public void delete(int id) {
		Query query = getSessionFactory().openSession().createQuery("delete from Image where id = '" + id + "'" );
		query.executeUpdate();
	}

    public DomainObject getArticleLink(String section) {
        //To change body of implemented methods use File | Settings | File Templates.
        return null;

    }


	public Image get(int id) {
		return (Image) getSessionFactory().getCurrentSession().get(Image.class, id);
	}

	public void save(DomainObject obj) {
        getSessionFactory().getCurrentSession().saveOrUpdate( obj );
        getSessionFactory().getCurrentSession().flush();
	}

	public DomainObject latest() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public void update(DomainObject obj) {
        getSessionFactory().getCurrentSession().merge( obj );
        getSessionFactory().getCurrentSession().flush();
	}

}
