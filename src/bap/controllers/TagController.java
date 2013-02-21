/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bap.controllers;

import bap.admin.controllers.utilities.ViewComposit;
import bap.domain.DomainObject;
import bap.domain.Tag;
import bap.persistance.dao.Dao;
import bap.persistance.dao.TagDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**  @author tomek */
@Controller
public class TagController {

	private static DomainObject tag;
	private static TagDao tagDao;
	private ViewComposit tagFormView;
	private ViewComposit tagListView;
	
	@Autowired
	public TagController( DomainObject tag, TagDao tagDao, ViewComposit tagFormView, ViewComposit tagListView ){
		this.tag = tag;
		this.tagDao = tagDao;
		this.tagFormView = tagFormView;
		this.tagListView = tagListView;
	}


	/*----------------------------------------------------------------------
		NEW
	 ---------------------------------------------------------------------*/
	@RequestMapping("/admin/tag/new.html")
	public final ModelAndView newTag( ModelMap model ) throws IOException {
		ModelAndView mov = new ModelAndView();
		mov.setViewName( tagFormView.getAdminViewBase().getLayout() );
		mov.addAllObjects(tagFormView.getViewProperties(tagFormView, "/admin/tag/save/0.html") );
		mov.addObject( tagFormView.getSection(), tag );
		return mov;
	} // create Tag

	/*----------------------------------------------------------------------
	 	SAVE - ( create - update )
	 ---------------------------------------------------------------------*/
	@RequestMapping("/admin/tag/save/{tagId}.html")
	public final ModelAndView saveTag( @PathVariable int tagId, @ModelAttribute( "tag" ) Tag tag, ModelMap model) throws IOException{
		ModelAndView mov = new ModelAndView();

		if( tagId == 0){
			tagDao.save(tag);
		}else {
			tagDao.update( tag );
		}
		mov.setViewName( tagFormView.getAdminViewBase().getLayout() );
		mov.addAllObjects(tagFormView.getViewProperties(tagFormView, "/admin/tag/save/"+ tag.getId() + ".html"));
		return mov;
	}// save

	/*----------------------------------------------------------------------
		 EDIT
	 ---------------------------------------------------------------------*/
	@RequestMapping("/admin/tag/edit/{tagId}.html")
	public final ModelAndView editTag(@PathVariable int tagId, ModelMap model ) throws IOException{

		ModelAndView mov = new ModelAndView();
		model.addAttribute("tag", tagDao.get(tagId));
		mov.setViewName( tagFormView.getAdminViewBase().getLayout() );
		mov.addAllObjects( tagFormView.getViewProperties( tagFormView, "/admin/tag/save/" + tagId + ".html") );
		return mov;
	}

	/*----------------------------------------------------------------------
		 READ
	 ---------------------------------------------------------------------*/

	/* READ - SHOW by ID */
	@RequestMapping("/admin/tag/read/{tagId}.html")
	public final ModelAndView readTag( @PathVariable int tagId, ModelMap model ) throws IOException{
		ModelAndView mov = new ModelAndView();
		mov.setViewName( tagListView.getAdminViewBase().getLayout() );
		mov.addAllObjects(tagListView.getViewProperties(tagListView, null));
		model.addAttribute("tag", getTagDao().get(tagId) );
		return mov;
	} // readArticle

	/* READ - LIST ALL */
	@RequestMapping("/admin/tag/read/list.html")
	public final ModelAndView listTags( ModelMap model ){
		ModelAndView mov = new ModelAndView();
		mov.addObject("tags", tagDao.list() );
		mov.setViewName(tagListView.getAdminViewBase().getLayout() );
		mov.addAllObjects( tagListView.getViewProperties(tagListView, null ));
		return mov;
	}


	/*----------------------------------------------------------------------
		 DELETE
	 ---------------------------------------------------------------------*/
	@RequestMapping("/admin/tag/delete/{tagId}.html")
	public final ModelAndView deleteTag( @PathVariable int tagId, ModelMap model ){
		ModelAndView mov = new ModelAndView();
		mov.setViewName( tagListView.getAdminViewBase().getLayout() );
		mov.addAllObjects( tagListView.getViewProperties(tagListView, null ));
		tagDao.delete(tagId);
		mov.addObject("tags", tagDao.list());
		return mov;
	} /* DELETE */


	/**
	 * Get the value of tagDao
	 *
	 * @return the value of tagDao
	 */
	public static TagDao getTagDao() {
		return tagDao;
	}

	/**
	 * Set the value of tagDao
	 *
	 * @param tagDao new value of tagDao
	 */
	public static void setTagDao(TagDao tagDao) {
		TagController.tagDao = tagDao;
	}



}
