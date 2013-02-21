/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bap.persistance.dao;

import bap.domain.ContentPage;
import bap.domain.DomainObject;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author tomek
 */
@Transactional
public class ContentPageDao extends HibernateDaoSupport implements Dao {


    @Transactional
	public void save(DomainObject obj) {
			 this.getSession().saveOrUpdate(  obj) ;
			 this.getSession().flush();
	}


	@Transactional
	public void update( DomainObject contentPage ) {
		 this.getSession().update(contentPage); 
	}


	@Transactional
	public List list() {
		return this.getHibernateTemplate() . loadAll(ContentPage.class);
	}


	@Transactional
	public ContentPage get(int id) {
		return  (ContentPage) this.getSession().get(ContentPage.class, id)  ;
	}


	@Transactional
	public void delete( int id ){
		Query query = this.getSession().createQuery("delete from ContentPage where id = '" + id + "'" );
		query.executeUpdate();
	}

    public DomainObject getArticleLink(String section) {

        Query q = this.getSession().createQuery( "from ContentPage where linkHref = '"  + section + "'" );
        return (ContentPage) q.uniqueResult();
    }

	public DomainObject latest() {
        Query q =  this.getSession().createQuery( "select cp   from ContentPage cp left join cp.tags as t where t.description ='article'  order by cp.modified desc");
        q.setMaxResults(1);
        return (ContentPage) q.uniqueResult();
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

        Query q = this.getSession().createQuery( "select cp from ContentPage cp left join cp.tags as t where t.description = " + tagValue + " order by cp.modified desc");
        q.setMaxResults( quntity );
        return  q.list();

    }




}
