/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bap.controllers;

import bap.admin.controllers.utilities.ViewBuilder;
import bap.domain.DomainObject;
import bap.domain.NavigationSection;
import bap.persistance.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author tomek
 */
@Controller
public class NavigationSectionController {

    private static final String NAVIGATION_SECTION = "navigation_section";
	private Dao navigationDao;

	private DomainObject navigationSection;
	private Dao navigationSectionDao;


	@Autowired
	public NavigationSectionController(
		Dao navigationDao,
		DomainObject navigationSection,
		Dao navigationSectionDao
		){
		this.navigationDao = navigationDao;
		this.navigationSection = navigationSection;
		this.navigationSectionDao = navigationSectionDao;
	}

	/*----------------------------------------------------------------------
		NEW
	 ---------------------------------------------------------------------*/
	@RequestMapping("/admin/navigation_section/new.html")
	public final ModelAndView  newNavigationSection(){

		ModelAndView mov = new ModelAndView();
		 ViewBuilder vb = new ViewBuilder.Builder()
			 .modelPart("all_navigation", navigationDao.list() )
			.modelPart(NAVIGATION_SECTION,  navigationSection )
			.section(NAVIGATION_SECTION)
			.page("index")
			.element("form")
			.action("/admin/navigation_section/save/0.html")
			.build();
		 	mov.addAllObjects(vb.getViewParts()).setViewName( vb.getLayout());

		return mov;

	}

	/*----------------------------------------------------------------------
	 	SAVE - ( create - update )
	 ---------------------------------------------------------------------*/
	@RequestMapping("/admin/navigation_section/save/{id}.html")
	public final String saveNavigationSection(
		@PathVariable int id,
		@ModelAttribute("navigationSection") NavigationSection navigationSection
		){

		if( id == 0 ){
			navigationSectionDao.save(navigationSection);
		} else {
			navigationSectionDao.update(navigationSection);
		}
		return "redirect:/admin/navigation_section/edit/" + navigationSection.getId()  + ".html";
	}

	/*----------------------------------------------------------------------
		 EDIT
	 ---------------------------------------------------------------------*/
	@RequestMapping("/admin/navigation_section/edit/{id}.html")
	public final ModelAndView editNavigationSection( @PathVariable int id ){

		ModelAndView mov = new ModelAndView();
		ViewBuilder vb = new ViewBuilder.Builder()
			.modelPart("all_navigation", navigationDao.list())
			.modelPart(NAVIGATION_SECTION, navigationSectionDao.get(id))
			.section(NAVIGATION_SECTION)
			.page("index")
			.element("form")
			.action("/admin/navigation_section/save/" + id  +  ".html")
			.build();
		mov.addAllObjects(vb.getViewParts()).setViewName(vb.getLayout());
		return mov;
	}

	/*----------------------------------------------------------------------
		 READ
	 ---------------------------------------------------------------------*/

	/* READ - SHOW by ID */

	/* READ - LIST ALL */
	@RequestMapping("/admin/navigation_section/read/list.html")
	public final ModelAndView listNavigationSection(){
		ModelAndView mov = new ModelAndView();
		ViewBuilder vb = new ViewBuilder.Builder()
			.modelPart("navigation_sections", navigationSectionDao.list())
			.section(NAVIGATION_SECTION)
			.page("index")
			.element("list")
			.build();
		mov.addAllObjects(vb.getViewParts()).setViewName(vb.getLayout());
		return mov;
	}
	/*----------------------------------------------------------------------
		 DELETE
	 ---------------------------------------------------------------------*/
	@RequestMapping("/admin/navigation_section/delete/{id}.html")
	public final String deleteNavigationSection( @PathVariable int id ){
		navigationSectionDao.delete(id);
		return "redirect:/admin/navigation_section/read/list.html";
	}
}
