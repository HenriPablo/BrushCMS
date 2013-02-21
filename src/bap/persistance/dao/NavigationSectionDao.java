/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bap.persistance.dao;

import bap.domain.DomainObject;
import bap.domain.NavigationSection;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 *
 * @author tomaszbrymora
 */

public class NavigationSectionDao extends HibernateDaoSupport  {



	public void save(DomainObject obj) {
		this.getSession().saveOrUpdate(obj);
		this.getSession().flush();
	}


	public DomainObject get(int id) {
		return  (DomainObject) this.getSession().get(NavigationSection.class, id);
	}


	public DomainObject latest() {
		throw new UnsupportedOperationException("Not supported yet.");
	}


	public List list() {
		return this.getHibernateTemplate().loadAll(NavigationSection.class);

	}


	public void update(DomainObject obj) {
		this.getSession().merge(obj);
		this.getSession().flush();
	}


	public void delete(int id) 	{	
		Query query = this.getSession().createQuery("delete from NavigationSection where id = '" + id + "'" );
		query.executeUpdate();
	}

    public DomainObject getArticleLink(String section) {
        //To change body of implemented methods use File | Settings | File Templates.
        return null;
    }


}
