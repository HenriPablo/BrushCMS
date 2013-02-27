/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bap.admin.controllers.bindinginitializers;

import bap.admin.controllers.propertyeditors.*;
import bap.domain.*;
import bap.persistance.dao.*;
import bap.settings.Setting;
import bap.settings.SettingsGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author tomaszbrymora
 */
public class DataBindingInitializer implements WebBindingInitializer{

    @Autowired
	private NavigationSectionDao navigationSectionDao;
    @Autowired
    private TagDao tagDao;
    @Autowired
    private NavigationDao navigationDao;
    @Autowired
    private AlbumDao albumDao;
    @Autowired
    private ImageDao imageDao;
    @Autowired
    private SettingDao settingDao;
    @Autowired
    private SettingGroupDao settingGroupDao;


    //	@Override
	public void initBinder(WebDataBinder binder, WebRequest request) {
		binder.registerCustomEditor( NavigationSection.class,   new NavigationSectionEditor( (NavigationSectionDao) navigationSectionDao));
		binder.registerCustomEditor( Tag.class,                 new TagEditor( tagDao));
		binder.registerCustomEditor( Navigation.class,          new NavigationEditor( navigationDao ));
		binder.registerCustomEditor( Album.class,               new AlbumEditor(albumDao));
		binder.registerCustomEditor( Image.class,               new ImageEditor(imageDao));
        binder.registerCustomEditor( Setting.class,             new SettingEditor( settingDao));
        binder.registerCustomEditor( SettingsGroup.class,       new SettingsGropuEditor( settingGroupDao));
	}

}
