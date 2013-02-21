/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bap.controllers;

import bap.admin.controllers.utilities.ViewBuilder;
import bap.domain.Album;
import bap.domain.DomainObject;
import bap.persistance.dao.AlbumDao;
import bap.persistance.dao.Dao;
import bap.persistance.dao.ImageDao;
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
public class AlbumController {

    private static final String ALBUM = "album";
    private AlbumDao albumDao;
	private DomainObject album;
	private ImageDao imageDao;

	@Autowired
	public AlbumController( AlbumDao albumDao, DomainObject album, ImageDao imageDao ){
		this.albumDao = albumDao;
		this.album = album;
		this.imageDao = imageDao;
	}

	/*----------------------------------------------------------------------
		NEW
	 ---------------------------------------------------------------------*/
	@RequestMapping( "/admin/album/new.html")
	public final ModelAndView newAlbum(){
		ModelAndView mov = new ModelAndView();

		ViewBuilder vb = new ViewBuilder.Builder()
			.modelPart(ALBUM, album )
			.modelPart("images", imageDao.list() )
			.section(ALBUM)
			.page("index")
			.element("form")
			.action("/admin/album/save/0.html")
			.build();
		mov.addAllObjects(vb.getViewParts()).setViewName(vb.getLayout());
		return mov;
	} // newAlbum

	/*----------------------------------------------------------------------
	 	SAVE - ( create - update )
	 ---------------------------------------------------------------------*/
	@RequestMapping("/admin/album/save/{id}.html")
	public final String saveAlbum(
		@PathVariable int id,
		@ModelAttribute(ALBUM) Album album ){
			if( id == 0 ){
				albumDao.save( album );
			} else {
				albumDao.update(album);
			}
		return "redirect:/admin/album/edit/" + album.getId() + ".html";
	} // saveAlbum

	/*----------------------------------------------------------------------
		 EDIT
	 ---------------------------------------------------------------------*/
	@RequestMapping( "/admin/album/edit/{id}.html")
	public final ModelAndView editAlbum( @PathVariable int id ) {
		ModelAndView mov = new ModelAndView();
			ViewBuilder vb = new ViewBuilder.Builder()
				.modelPart(ALBUM, albumDao.get(id))
				.modelPart("images", imageDao.list() )
				.section(ALBUM)
				.page("index")
				.element("form")
				.action("/admin/album/save/" + id + ".html").build();
			mov.addAllObjects(vb.getViewParts()).setViewName(vb.getLayout());
		return mov;
	}// editAlbum


	/*----------------------------------------------------------------------
		 READ
	 ---------------------------------------------------------------------*/
	@RequestMapping("/admin/album/read/list.html")
	public final ModelAndView listAlbums( ){
		ModelAndView mov = new ModelAndView();
			ViewBuilder vb = new  ViewBuilder.Builder()
				.modelPart("albums", albumDao.list() )
				.section(ALBUM)
				.page("index")
				.element("list")
				.build();
			mov.addAllObjects(vb.getViewParts()).setViewName(vb.getLayout());
		return mov;
	} // listAlbums

	/*----------------------------------------------------------------------
		 DELETE
	 ---------------------------------------------------------------------*/
	@RequestMapping("/admin/album/delete/{id}.html")
	public final String deleteAlbum( @PathVariable int id ){
		albumDao.delete(id);
		return "redirect:/admin/album/read/list.html";
	} // deleteAlbum
}
