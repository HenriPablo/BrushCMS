/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bap.controllers;

import bap.admin.controllers.utilities.ViewBuilder;
import bap.domain.Comment;
import bap.domain.DomainObject;
import bap.persistance.dao.CommentDao;
import bap.persistance.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author tomaszbrymora
 */
@Controller
public class CommentController {
	private DomainObject comment;
	private CommentDao commentDao;



    private static final String COMMENT = "comment";
    private static final String INDEX = "index";

	@Autowired
	public CommentController(
			DomainObject comment,
			CommentDao commentDao
			){
		this.comment = comment;
		this.commentDao = commentDao;
	}

	/*----------------------------------------------------------------------
		NEW
	 ---------------------------------------------------------------------*/
	@RequestMapping("/comment/article/{id}/new.html")
	public final ModelAndView newComment( ModelMap model, @PathVariable int id){
		ModelAndView mov = new ModelAndView();
		ViewBuilder vb = new ViewBuilder.Builder("public/layout")
			.modelPart(COMMENT, comment )
			.section(COMMENT)
			.page(INDEX)
			.element("form_comment")
			.action("/comment/article/" + id + "/save/0.html")
			.build();
		mov.setViewName(vb.getLayout());
		mov.addAllObjects(vb.getViewParts() );
		return mov;
	}

	/*----------------------------------------------------------------------
	 	SAVE - ( create - update )
	 ---------------------------------------------------------------------*/
	@RequestMapping("/comment/{section}/{pageId}/save/{id}.html")
	public final ModelAndView saveComment( ModelMap model, @PathVariable String section, @PathVariable int pageId, @PathVariable int id, @ModelAttribute(COMMENT) Comment comment ){
		ModelAndView mov = new ModelAndView();

		comment.setEnteredOn( new java.sql.Date( System.currentTimeMillis()) );
	
		if( id == 0 ){
			commentDao.save( comment );
		} else {
			commentDao.update( comment );
		}
		ViewBuilder vb = new ViewBuilder.Builder( "public/layout" ).modelPart( COMMENT, comment ).section(COMMENT).page(INDEX).element("form_comment").action("/comment/article/" + pageId + "/save/" + comment.getId() + ".html").build();
		mov.setViewName(vb.getLayout());
		mov.addAllObjects(vb.getViewParts());
		return mov;
	}


	/*----------------------------------------------------------------------
		 EDIT
	 ---------------------------------------------------------------------*/
	@RequestMapping("/admin/comment/edit/{commentId}.html")
	public final ModelAndView editComment(ModelMap model, @PathVariable int commentId ){
		ModelAndView mov = new ModelAndView();
		Comment c = (Comment) commentDao.get(commentId);
		ViewBuilder vb = new ViewBuilder.Builder("admin/layout").modelPart(COMMENT, c ).section(COMMENT).page(INDEX).element("form_comment").action("/comment/article/" + c.getContentPage().getId() + "/save/" + commentId + ".html").build();
		mov.addAllObjects(vb.getViewParts()).setViewName(vb.getLayout());
		return mov;
	}

	/*----------------------------------------------------------------------
		 READ
	 ---------------------------------------------------------------------*/
	/* READ - SHOW by ID */

	/* READ - LIST ALL */
	@RequestMapping("/admin/comment/read/list.html")
	public final ModelAndView listComments( ModelMap model ){
		ModelAndView mov = new ModelAndView();

		ViewBuilder vb = new ViewBuilder.Builder("admin/layout").modelPart("comments", commentDao.list() ).section(COMMENT).page(INDEX).element("list").build();

		mov.addAllObjects(vb.getViewParts()).setViewName(vb.getLayout());
		return mov;
	}
	/*----------------------------------------------------------------------
		 DELETE
	 ---------------------------------------------------------------------*/
}
