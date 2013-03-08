package bap.controllers;

import bap.admin.controllers.utilities.ViewBuilder;
import bap.settings.SettingsGroup;
import org.springframework.beans.factory.annotation.Autowired;
import bap.persistance.dao.SettingGroupDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 * User: tomekpilot
 * Date: 2/17/13
 * Time: 7:34 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class SettingsGroupController {

    @Autowired
    private SettingGroupDao settingsGroupDao;
    @Autowired
    private SettingsGroup settingsGroup;


	/*----------------------------------------------------------------------
		NEW
	 ---------------------------------------------------------------------*/
    @RequestMapping("/admin/settings_group/new.html")
    public final ModelAndView newSettingsGroup(){
        ModelAndView mov = new ModelAndView();

        ViewBuilder vb = new ViewBuilder.Builder()
                .modelPart("settingsGroup", settingsGroup )
                .modelPart("childrenList", settingsGroupDao.list() )
                .section("settings_group")
                .page("index")
                .element("form")
                .action("/admin/settings_group/save/0.html")
                .build();
        mov.addAllObjects(vb.getViewParts()).setViewName( vb.getLayout());

        return mov;
    }


	/*----------------------------------------------------------------------
		 READ
	 ---------------------------------------------------------------------*/

	/* READ - SHOW by ID */

    /* READ - LIST ALL */
    @RequestMapping("/admin/settings_group/read/list.html")
    public final ModelAndView listContentPages( ModelMap model ) {
        ModelAndView mov = new ModelAndView();
        ViewBuilder vb = new ViewBuilder.Builder()
                .modelPart("settingsGroupList", settingsGroupDao.list())
                .section("settings_group")
                .page("index")
                .element("list")
                .build();
        mov.addAllObjects(vb.getViewParts()).setViewName(vb.getLayout());
        return mov;
    }


    /*----------------------------------------------------------------------
         EDIT
     ---------------------------------------------------------------------*/
    @RequestMapping("/admin/settings_group/edit/{id}.html")
    public final ModelAndView editContentPage( ModelMap model, @PathVariable int id ){
        ModelAndView mov = new ModelAndView();

        ViewBuilder vb = new ViewBuilder.Builder()
                .modelPart("settingsGroup", settingsGroupDao.get(id))
                .modelPart("childrenList", settingsGroupDao.list())
                .section("settings_group")
                .page("index")
                .element("form")
                .action("/admin/settings_group/save/" + id + ".html")
                .build();
        mov.addAllObjects(vb.getViewParts()).setViewName(vb.getLayout());

        return mov;
    }


    /*----------------------------------------------------------------------
         SAVE - ( create - update )
     ---------------------------------------------------------------------*/
    @RequestMapping("/admin/settings_group/save/{id}.html")
    public final String saveContentPage(
            @PathVariable int id,
            @ModelAttribute("settingsGroup") SettingsGroup settingsGroup
    ){

        if( id == 0){
            settingsGroupDao.save( settingsGroup  );
        } else {
            settingsGroupDao.update( settingsGroup );

        }
        return "redirect:/admin/settings_group/edit/" + settingsGroup.getId() + ".html";
    }

    /*----------------------------------------------------------------------
         DELETE
     ---------------------------------------------------------------------*/
    @RequestMapping("/admin/settings_group/delete/{id}.html")
    public final String deleteSettingsGroup( @PathVariable int id ){
        SettingsGroup s = settingsGroupDao.get( id );
        settingsGroupDao.delete( s );
        return "redirect:/admin/settings_group/read/list.html";
    }

}
