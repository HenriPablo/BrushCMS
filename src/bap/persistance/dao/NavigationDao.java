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
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import javax.naming.OperationNotSupportedException;
import java.util.List;

/**
 *
 * @author tomaszbrymora
 */
public class NavigationDao extends HibernateDaoSupport  {


	public void save(DomainObject obj) {
		this.getSession().saveOrUpdate(obj);
		this.getSession().flush();
	}

	public DomainObject get(int id) {
		return this.getHibernateTemplate().get(Navigation.class, id);
	}
	
	public DomainObject latest() {
		Query q = this.getHibernateTemplate().getSessionFactory().openSession().createQuery( "from Navigation where id = ( select max( id ) from Navigation )");
		return (Navigation) q.uniqueResult();
	}
	public List list() {
		return this.getHibernateTemplate().loadAll(Navigation.class );
	}

	/**
	 *
	 * @param id
	 * @return
	 * @throws OperationNotSupportedException
	 * 
	 */
	public DomainObject getLimited( int id ) throws OperationNotSupportedException{
		Criteria c = this.getHibernateTemplate().getSessionFactory().openSession().createCriteria(ContentPage.class).setProjection(Projections.property("label")).setProjection(Projections.property("ahref"));
		c.setMaxResults( 1 );
        return (DomainObject) c.list().get(1);
	}

	public void update(DomainObject obj) {
		throw new UnsupportedOperationException("Not supported :: Navigation ID elements are not modifiable.");
	}

	public void delete(int id) {
		Query query = this.getHibernateTemplate().getSessionFactory().openSession().createQuery("delete from Navigation where id = '" + id + "'" );
		query.executeUpdate();
	}

    public DomainObject getArticleLink(String section) {
        //To change body of implemented methods use File | Settings | File Templates.
        return null;
    }

}
