/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bap.persistance.dao;

import bap.domain.NavigationSection;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 *
 * @author tomaszbrymora
 */
public class NavigationElementsImpl extends HibernateDaoSupport implements NavigationElmentsDao {

	public List pageNavElements() {

		List contentPageNavElements =  this.getSession()
			.createCriteria(NavigationSection.class, "navigationSection").createAlias("contentPages", "cp")
			.setProjection(  Projections.projectionList()
			.add( Projections.property("navigationSection.id"), "id" )
			.add( Projections.property("cp.linkLabel"), "linkLabel" )
			.add( Projections.property("cp.linkHref"), "linkHref" )
			).setCacheable(true).list();

		return contentPageNavElements;

	}

	public List navigationElements() {
		List navSectionElements = this.getSession()
			.createCriteria(NavigationSection.class, "navigationSection")
			.setProjection( Projections.projectionList()
			.add( Projections.property("navigationSection.id"), "id" )
			.add(  Projections.property("navigationSection.label"), "label")
			.add( Projections.property("navigationSection.href"), "href" )
			).addOrder( Order.asc("navigationSection.id")  ).setCacheable(true).list();

		return navSectionElements;
	}

}
