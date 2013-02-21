/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bap.admin.controllers.propertyeditors;

import bap.domain.Tag;
import bap.persistance.dao.Dao;
import bap.persistance.dao.TagDao;

import java.beans.PropertyEditorSupport;

/**
 *
 * @author tomek
 */
public class TagEditor extends PropertyEditorSupport {

	private TagDao tagDao;

	public TagEditor( TagDao tagDao ){
        this.tagDao = (TagDao) tagDao;
	}


    @Override
	public void setAsText( String text ) {
		int id = Integer.parseInt(text);
		Tag tag = (Tag) tagDao.get(id);
		setValue(tag);
	}

}
