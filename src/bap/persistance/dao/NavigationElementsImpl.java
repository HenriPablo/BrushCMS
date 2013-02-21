/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bap.persistance.dao;

import bap.domain.NavigationSection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author tomaszbrymora
 */
public class NavigationElementsImpl  implements NavigationElmentsDao {


    @Resource
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory; }
    public SessionFactory getSessionFactory() { return sessionFactory; }


    public List pageNavElements() {
        List l;
        Session s = getSessionFactory().getCurrentSession();
        s.getTransaction().begin();

		 l =  s
			.createCriteria(NavigationSection.class, "navigationSection").createAlias("contentPages", "cp")
			.setProjection(  Projections.projectionList()
			.add( Projections.property("navigationSection.id"), "id" )
			.add( Projections.property("cp.linkLabel"), "linkLabel" )
			.add( Projections.property("cp.linkHref"), "linkHref" )
			).setCacheable(true).list();
        s.flush();
        s.getTransaction().commit();
		return l;

	}

	public List navigationElements() {
        List l;
        Session s = getSessionFactory().getCurrentSession();
        s.getTransaction().begin();

		 l = s
			.createCriteria(NavigationSection.class, "navigationSection")
			.setProjection( Projections.projectionList()
			.add( Projections.property("navigationSection.id"), "id" )
			.add(  Projections.property("navigationSection.label"), "label")
			.add( Projections.property("navigationSection.href"), "href" )
			).addOrder( Order.asc("navigationSection.id")  ).setCacheable(true).list();

        s.flush();
        s.getTransaction().commit();
		return l;
	}

}
