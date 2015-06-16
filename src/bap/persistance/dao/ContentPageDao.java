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
import org.hibernate.Transaction;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.util.List;

/**
 *
 * @author tomek
 */
@Transactional(propagation = Propagation.REQUIRED)
public class ContentPageDao  {

    @Autowired
    private SessionFactory sessionFactory;

//    public SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public  List searchContent( String term ) throws InterruptedException {

        Session s = sessionFactory.getCurrentSession();

        FullTextSession fullTextSession = Search.getFullTextSession( s );

        fullTextSession.createIndexer().startAndWait();

        QueryBuilder qb = fullTextSession.getSearchFactory()
                .buildQueryBuilder().forEntity( ContentPage.class ).get();

        org.apache.lucene.search.Query query = qb
                .keyword()
                .onFields("title", "content")
                .matching( term ).createQuery();


        //org.hibernate.Query
        org.hibernate.search.FullTextQuery hibQuery = fullTextSession.createFullTextQuery(query, ContentPage.class);
        hibQuery.setProjection(
                FullTextQuery.SCORE,
                FullTextQuery.THIS,
                "content"
        );
        //hibQuery.setResultTransformer(
        //       new AliasToBeanResultTransformer( ContentPage.class )
        //);

        List result = hibQuery.list();
        return  result;
    }


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
        //s.getTransaction().begin();
		 s.update(contentPage);
        s.flush();
        //s.getTransaction().commit();
	}


	@Transactional
	public List list() {
        List l;
        Session s = sessionFactory.getCurrentSession();

		l = s.createQuery( "from ContentPage " ).list();
        s.flush();
        return  l;
	}


	public ContentPage get(int id) {
        ContentPage cp;
		cp =  (ContentPage) sessionFactory.getCurrentSession().get(ContentPage.class, id) ;
        return cp;
	}


	@Transactional
	public void delete( int id ){
        Session s = sessionFactory.getCurrentSession();

		Query query = s.createQuery("delete from ContentPage where id = '" + id + "'" );
		query.executeUpdate();
        s.flush();
	}

    public DomainObject getArticleLink(String section) {
        DomainObject dm;
        Session s = sessionFactory.getCurrentSession();

        Query q = s.createQuery( "from ContentPage where linkHref = '"  + section + "'" );
        dm = (ContentPage) q.uniqueResult();
        s.flush();
        return dm;
    }

	public DomainObject latest() {
        DomainObject dm;
        Session s = sessionFactory.getCurrentSession();

        Query q =  s.createQuery( "select cp   from ContentPage cp left join cp.tags as t where t.description ='article'  order by cp.modified desc");
        q.setMaxResults(1);

        dm = (ContentPage) q.uniqueResult();
        s.flush();
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

        Query q = s.createQuery( "select cp from ContentPage cp left join cp.tags as t where t.description = " + tagValue + " order by cp.modified desc");
        q.setMaxResults( quntity );
        l =  q.list();
        s.flush();
        return l;

    }



}
