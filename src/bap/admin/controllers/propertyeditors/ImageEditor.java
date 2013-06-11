/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bap.admin.controllers.propertyeditors;

import bap.domain.Image;
import bap.persistance.dao.Dao;
import bap.persistance.dao.ImageDao;

import java.beans.PropertyEditorSupport;

/**
 *
 * @author tomek
 */
public class ImageEditor extends PropertyEditorSupport {

	private ImageDao imageDao;

	public ImageEditor ( ImageDao imageDao ){
		this.imageDao = (ImageDao) imageDao;
	}

	@Override
	public void setAsText( String text ) {
		int id  = Integer.parseInt(text);
		Image i = (Image) imageDao.get(id);
        System.out.println( "\n\n IMAGE  NAME IN EDITOR:  "  + i.getSrc() + "\n\n");
		setValue(i);
	}

}
