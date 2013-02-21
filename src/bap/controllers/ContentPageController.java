/*
 * ADMIN :
 *      CREATE READ UPDATE and DELETE content pages
 */

package bap.controllers;

import bap.admin.controllers.utilities.ViewBuilder;
import bap.domain.ContentPage;
import bap.domain.DomainObject;
import bap.persistance.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author tomek
 */
@Controller
public class ContentPageController {

    private static final String CONTENT_PAGE = "content_page";
    private DomainObject contentPage;
	private ContentPageDao contentPageDao;
	private NavigationSectionDao navigationSectionDao;
	private TagDao tagDao;
	private AlbumDao albumDao;


	@Autowired
	public ContentPageController(
			DomainObject contentPage,
			ContentPageDao contentPageDao,
			TagDao tagDao,
			NavigationSectionDao navigationSectionDao,
			AlbumDao albumDao
			){
		this.contentPage = contentPage;
		this.contentPageDao = contentPageDao;

		this.tagDao = tagDao;
		this.navigationSectionDao = navigationSectionDao;
		this.albumDao = albumDao;
	}
	/*----------------------------------------------------------------------
		NEW
	 ---------------------------------------------------------------------*/
	@RequestMapping("/admin/content_page/new.html")
	public final ModelAndView newContentPage( ){
		ModelAndView mov = new ModelAndView();

		ViewBuilder vb = new ViewBuilder.Builder()
			.modelPart(CONTENT_PAGE, contentPage )
			.modelPart("navigation_sections", navigationSectionDao.list() )
			.modelPart("available_tags", tagDao.list() )
			.modelPart("available_albums", albumDao.list() )
			.section(CONTENT_PAGE)
			.page("index")
			.element("form")
			.action("/admin/content_page/save/0.html")
			.build();
		mov.addAllObjects(vb.getViewParts()).setViewName(vb.getLayout());

		return mov;
	}


	/*----------------------------------------------------------------------
	 	SAVE - ( create - update )
	 ---------------------------------------------------------------------*/
	@RequestMapping("/admin/content_page/save/{id}.html")
	public final String saveContentPage(
			@PathVariable int id,
			@ModelAttribute("contentPage") ContentPage contentPage
			){

		if( id == 0){
			 contentPageDao.save( contentPage  );
		} else {
			contentPageDao.update( contentPage );
			
		}
	return "redirect:/admin/content_page/edit/" + contentPage.getId() + ".html";
	}//saveContentPage


	/*----------------------------------------------------------------------
		 EDIT
	 ---------------------------------------------------------------------*/
	@RequestMapping("/admin/content_page/edit/{id}.html")
	public final ModelAndView editContentPage( ModelMap model, @PathVariable int id ){
		ModelAndView mov = new ModelAndView();

		ViewBuilder vb = new ViewBuilder.Builder()
			.modelPart(CONTENT_PAGE, contentPageDao.get(id))
			.modelPart("navigation_sections", navigationSectionDao.list() )
			.modelPart("available_tags", tagDao.list() )
			.modelPart("available_albums", albumDao.list() )
			.section(CONTENT_PAGE)
			.page("index")
			.element("form")
			.action("/admin/content_page/save/" + id + ".html")
			.build();
		mov.addAllObjects(vb.getViewParts()).setViewName(vb.getLayout());

		return mov;
	}


	/*----------------------------------------------------------------------
		 READ
	 ---------------------------------------------------------------------*/

	/* READ - SHOW by ID */

	/* READ - LIST ALL */
	@RequestMapping("/admin/content_page/read/list.html")
	public final ModelAndView listContentPages( ModelMap model ) {
		ModelAndView mov = new ModelAndView();
		ViewBuilder vb = new ViewBuilder.Builder()
			.modelPart("content_pages", contentPageDao.list())
			.section(CONTENT_PAGE)
			.page("index")
			.element("list")
			.build();
		mov.addAllObjects(vb.getViewParts()).setViewName(vb.getLayout());
		return mov;
	}

	/*----------------------------------------------------------------------
		 DELETE
	 ---------------------------------------------------------------------*/
	@RequestMapping("/admin/content_page/delete/{id}.html")
	public final String deleteContentPage( @PathVariable int id ){
		contentPageDao.delete( id );
		return "redirect:/admin/content_page/read/list.html";
	}
}
