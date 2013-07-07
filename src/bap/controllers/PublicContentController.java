/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bap.controllers;

import bap.domain.ContentPage;
import bap.persistance.dao.ContentPageDao;
import bap.persistance.dao.Dao;
import bap.persistance.dao.NavigationElmentsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.net.URLDecoder;

/**
 *
 * @author tomekpilot
 */
@Controller
public class PublicContentController {

	private ContentPageDao contentPageDao;
	private NavigationElmentsDao navigationElementsDaoImpl;


	@Autowired
	public PublicContentController( ContentPageDao contentPageDao, NavigationElmentsDao navigationElementsDaoImpl ) {
		this.contentPageDao = contentPageDao;
		this.navigationElementsDaoImpl = navigationElementsDaoImpl;
	}

	@RequestMapping("/index.html")
	public final ModelAndView index( ) throws IOException{

		ModelAndView mov = new ModelAndView();

        ContentPage cp = (ContentPage) this.contentPageDao.latest();
        cp.setContent( URLDecoder.decode( cp.getContent(), "UTF-8") );

        //URLDecoder.decode( x.getContent(),  "UTF-8" )


        mov.addObject("layout", "generic");
		mov.addObject("page", "home");

		mov.addObject("nav_elements", navigationElementsDaoImpl.navigationElements());
		mov.addObject("page_nav_elements", navigationElementsDaoImpl.pageNavElements());

//        mov.addObject("latest_article", cp);// this.contentPageDao.latest());
        mov.addObject("latest_article", this.contentPageDao.latest());

        mov.setViewName("public/layouts/generic/layout");
		return mov;
	}//index

    @RequestMapping("/{section}.html")
    public final ModelAndView sectionHome( @PathVariable String section ){
        ModelAndView mov = new ModelAndView();
        mov.addObject("page", section);
        mov.addObject("page_contents", contentPageDao.getArticleLink( section ));
        mov.addObject("nav_elements", navigationElementsDaoImpl.navigationElements() );
        mov.addObject("page_nav_elements", navigationElementsDaoImpl.pageNavElements() );
        mov.setViewName("public/layouts/generic/layout");
        return mov;

    }

	@RequestMapping( "/{section}/{page}.html" )
	public final ModelAndView page( @PathVariable String section, @PathVariable String page ){
		ModelAndView mov = new ModelAndView();
		mov.addObject("page", "index");
        mov.addObject("layout", "generic");

        mov.addObject("page_contents", contentPageDao.getArticleLink( page ));
		mov.addObject("nav_elements", navigationElementsDaoImpl.navigationElements());
		mov.addObject("page_nav_elements", navigationElementsDaoImpl.pageNavElements());

		mov.setViewName("public/layouts/generic/layout");
		return mov;
	}

	/** * @return the contentPageDao */
	public final ContentPageDao getContentPageDao() { return contentPageDao; }

	/** * @param contentPageDao the contentPageDao to set */
	public final void setContentPageDao( ContentPageDao contentPageDao) { this.contentPageDao = contentPageDao; }

}
