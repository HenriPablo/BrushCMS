/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bap.admin.controllers.bindinginitializers;

import bap.admin.controllers.propertyeditors.*;
import bap.domain.*;
import bap.persistance.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author tomaszbrymora
 */
public class DataBindingInitializer implements WebBindingInitializer{

	private NavigationSectionDao navigationSectionDao;
	private TagDao tagDao;
	private NavigationDao navigationDao;
	private AlbumDao albumDao;
	private ImageDao imageDao;

	@Autowired
	public DataBindingInitializer(
            NavigationSectionDao navigationSectionDao,
            TagDao tagDao,
            NavigationDao navigationDao,
            AlbumDao albumDao,
            ImageDao imageDao
    ){
		this.navigationSectionDao = navigationSectionDao;
		this.tagDao = tagDao;
		this.navigationDao = navigationDao;
		this.albumDao = albumDao;
		this.imageDao = imageDao;
	}

    public DataBindingInitializer(ImageDao imageDao, AlbumDao albumDao, TagDao tagDao) {
    }

    //	@Override
	public void initBinder(WebDataBinder binder, WebRequest request) {
		binder.registerCustomEditor( NavigationSection.class, new NavigationSectionEditor( (NavigationSectionDao) navigationSectionDao));
		binder.registerCustomEditor( Tag.class, new TagEditor( tagDao));
		binder.registerCustomEditor( Navigation.class, new NavigationEditor( navigationDao ));
		binder.registerCustomEditor( Album.class,  new AlbumEditor(albumDao));
		binder.registerCustomEditor( Image.class, new ImageEditor(imageDao));
	}

}
