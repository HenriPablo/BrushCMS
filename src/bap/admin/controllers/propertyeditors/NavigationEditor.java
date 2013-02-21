/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bap.admin.controllers.propertyeditors;

import bap.domain.DomainObject;
import bap.domain.Navigation;
import bap.persistance.dao.Dao;
import bap.persistance.dao.NavigationDao;

import java.beans.PropertyEditorSupport;

/**
 *
 * @author tomek
 */
public class NavigationEditor extends PropertyEditorSupport {

	private NavigationDao navigationDao;

	public NavigationEditor( NavigationDao navigationDao ){
		this.navigationDao = navigationDao;
	}

	@Override
	public void setAsText( String text ) {
		int id = Integer.parseInt( text );
		DomainObject navigation = (Navigation ) navigationDao.get(id);
		setValue( navigation );
	}

}
