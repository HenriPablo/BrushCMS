package bap.controllers;


import bap.admin.controllers.utilities.ViewBuilder;
import bap.domain.DomainObject;
import bap.persistance.dao.NavigationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NavigationController {


    private static final String NAVIGATION = "navigation";
    private NavigationDao navigationDao;
    private DomainObject navigation;

    @Autowired
    public NavigationController(
            NavigationDao navigationDao,
            DomainObject navigation

    ){
        this.navigationDao = navigationDao;
        this.navigation = navigation;

    }


    /*----------------------------------------------------------------------
    NEW
 ---------------------------------------------------------------------*/
    @RequestMapping("/admin/navigation/new.html")
    public final ModelAndView  newNavigation(){

        ModelAndView mov = new ModelAndView();
        ViewBuilder vb = new ViewBuilder.Builder()
                .modelPart(NAVIGATION, navigation)
                .section(NAVIGATION)
                .page("index")
                .element("form")
                .action("/admin/navigation/save/0.html")
                .build();
        mov.addAllObjects(vb.getViewParts()).setViewName( vb.getLayout());

        return mov;

    }

    /*----------------------------------------------------------------------
        SAVE - ( create - update )
    ---------------------------------------------------------------------*/
    @RequestMapping("/admin/navigation/save/{id}.html")
    public final String saveNavigation(
            @PathVariable int id,
            @ModelAttribute("navigation") bap.domain.Navigation navigation
    ){

        if( id == 0 ){
            navigationDao.save(navigation);
        } else {
            navigationDao.update(navigation);
        }
        return "redirect:/admin/navigation/edit/" + navigation.getId()  + ".html";
    }




    /*----------------------------------------------------------------------
         EDIT
     ---------------------------------------------------------------------*/
    @RequestMapping("/admin/navigation/edit/{id}.html")
    public final ModelAndView editNavigation( @PathVariable int id ){

        ModelAndView mov = new ModelAndView();
        ViewBuilder vb = new ViewBuilder.Builder()
                .modelPart(NAVIGATION, navigationDao.get(id))
                .section(NAVIGATION)
                .page("index")
                .element("form")
                .action("/admin/navigation/save/" + id  +  ".html")
                .build();
        mov.addAllObjects(vb.getViewParts()).setViewName(vb.getLayout());
        return mov;
    }



	/*----------------------------------------------------------------------
		 READ
	 ---------------------------------------------------------------------*/

	/* READ - SHOW by ID */

    /* READ - LIST ALL */
    @RequestMapping("/admin/navigation/read/list.html")
    public final ModelAndView listNavigation(){
        ModelAndView mov = new ModelAndView();
        ViewBuilder vb = new ViewBuilder.Builder()
                .modelPart("navigation", navigationDao.list())
                .section(NAVIGATION)
                .page("index")
                .element("list")
                .build();
        mov.addAllObjects(vb.getViewParts()).setViewName(vb.getLayout());
        return mov;
    }

    /*----------------------------------------------------------------------
     DELETE
 ---------------------------------------------------------------------*/
    @RequestMapping("/admin/navigation/delete/{id}.html")
    public final String deleteNavigation( @PathVariable int id ){
        navigationDao.delete(id);
        return "redirect:/admin/navigation/read/list.html";
    }

}
