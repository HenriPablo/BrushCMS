/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bap.admin.controllers.propertyeditors;

import bap.domain.NavigationSection;
import bap.persistance.dao.NavigationSectionDao;

import java.beans.PropertyEditorSupport;

/**
 *
 * @author tomaszbrymora
 */
public class NavigationSectionEditor extends PropertyEditorSupport {

	private NavigationSectionDao navigationSectionDao;

	public NavigationSectionEditor( NavigationSectionDao navigationSectionDao ){
		this.navigationSectionDao = navigationSectionDao;
	}

	@Override
	public void setAsText( String text ) {
		int id = Integer.parseInt(text);
		NavigationSection navigationSection = (NavigationSection) navigationSectionDao.get(id);
		setValue(navigationSection);
	}


}
