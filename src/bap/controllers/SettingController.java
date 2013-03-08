package bap.controllers;

import bap.admin.controllers.utilities.ViewBuilder;
import bap.persistance.dao.SettingDao;
import bap.persistance.dao.SettingGroupDao;
import bap.settings.Setting;
import bap.settings.SettingsGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class SettingController {

    @Autowired
    private Setting setting;

    @Autowired
    private SettingDao settingDao;

    @Autowired
    private SettingGroupDao settingsGroupDao;

    /*----------------------------------------------------------------------
        NEW
     ---------------------------------------------------------------------*/
    @RequestMapping("/admin/setting/new.html")
    public final ModelAndView newSetting(){
        ModelAndView mov = new ModelAndView();

        ViewBuilder vb = new ViewBuilder.Builder()
                .modelPart("setting", setting )
                .modelPart("settingsGroupList", settingsGroupDao.list() )
                .section("setting")
                .page("index")
                .element("form")
                .action("/admin/setting/save/0.html")
                .build();
        mov.addAllObjects(vb.getViewParts()).setViewName( vb.getLayout());

        return mov;
    }


    /*----------------------------------------------------------------------
         SAVE - ( create - update )
     ---------------------------------------------------------------------*/
    @RequestMapping("/admin/setting/save/{id}.html")
    public final String saveSetting(
            @PathVariable int id,
            @ModelAttribute("setting") Setting setting
    ){

        if( id == 0){
            settingsGroupDao.save( setting  );
        } else {
            settingsGroupDao.update( setting );

        }
        return "redirect:/admin/setting/edit/" + setting.getId() + ".html";
    }

    /*----------------------------------------------------------------------
         EDIT
     ---------------------------------------------------------------------*/
    @RequestMapping("/admin/setting/edit/{id}.html")
    public final ModelAndView editSetting( ModelMap model, @PathVariable int id ){
        ModelAndView mov = new ModelAndView();

        ViewBuilder vb = new ViewBuilder.Builder()
                .modelPart("setting", settingDao.get(id))
                .modelPart("settingsGroupList", settingsGroupDao.list())
                .section("setting")
                .page("index")
                .element("form")
                .action("/admin/setting/save/" + id + ".html")
                .build();
        mov.addAllObjects(vb.getViewParts()).setViewName(vb.getLayout());

        return mov;
    }

	/*----------------------------------------------------------------------
		 READ
	 ---------------------------------------------------------------------*/

	/* READ - SHOW by ID */

    /* READ - LIST ALL */
    @RequestMapping("/admin/setting/read/list.html")
    public final ModelAndView listSettings( ModelMap model ) {
        ModelAndView mov = new ModelAndView();
        ViewBuilder vb = new ViewBuilder.Builder()
                .modelPart("settingsList", settingDao.list())
                .section("setting")
                .page("index")
                .element("list")
                .build();
        mov.addAllObjects(vb.getViewParts()).setViewName(vb.getLayout());
        return mov;
    }


    /*----------------------------------------------------------------------
         DELETE
     ---------------------------------------------------------------------*/
    @RequestMapping("/admin/setting/delete/{id}.html")
    public final String deleteSetting( @PathVariable int id ){
        //Setting s = settingDao.get( id );
        settingDao.delete( id );
        return "redirect:/admin/setting/read/list.html";
    }

}
