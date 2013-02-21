/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bap.admin.controllers.propertyeditors;

import bap.domain.Album;
import bap.persistance.dao.AlbumDao;
import bap.persistance.dao.Dao;

import java.beans.PropertyEditorSupport;


/**
 *
 * @author tomek
 */
public class AlbumEditor  extends PropertyEditorSupport{
	private AlbumDao albumDao;
	public AlbumEditor( AlbumDao albumDao){
		this.albumDao = (AlbumDao) albumDao;
	}

	@Override
	public void setAsText(String text ) {
		int id = Integer.parseInt(text);
		Album album  = (Album) albumDao.get(id);
		setValue(album);
	}
}
