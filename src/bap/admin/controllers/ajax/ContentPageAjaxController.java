package bap.admin.controllers.ajax;

import bap.domain.ContentPage;
import bap.persistance.dao.ContentPageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: tomekpilot
 * Date: 6/21/13
 * Time: 9:32 PM
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class ContentPageAjaxController {

    @Autowired
    private ContentPageDao contentPageDao;

    @RequestMapping(
            value = { "/contentPage/saveContent.html" },
            method = RequestMethod.POST,
//            consumes="application/json",
            produces = "application/json" /* ,
            headers = "Accept=application/json"*/
            )

    public @ResponseBody
    String saveContent(

        @RequestParam final String contentToSave,
        @RequestParam final String pageId
    ){
        int id = Integer.parseInt( pageId );
        ContentPage cp = contentPageDao.get( id );
        cp.setContent( contentToSave );
        contentPageDao.update( cp );

        return "Contents Updated";

    }
}
