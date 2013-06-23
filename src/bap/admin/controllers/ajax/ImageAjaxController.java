package bap.admin.controllers.ajax;

import bap.domain.ContentPage;
import bap.domain.Image;
import bap.persistance.dao.ContentPageDao;
import bap.persistance.dao.ImageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller()
public class ImageAjaxController {

    @Autowired
    private ImageDao pixDao;
    //@Autowired
   // private Image pix;

    @Autowired
    private ContentPageDao contentPageDao;
    //@Autowired
    //ContentPage contentPage;

    @RequestMapping(
            value = {"/image/mainPix/save.html" },
            method = RequestMethod.POST,
            produces = "application/json"
            )

    public @ResponseBody String saveMainPix(
            @RequestParam final String pixId,
            @RequestParam final String pageId
    ){
        if( pixId.equalsIgnoreCase("x") ){
            ContentPage cp = contentPageDao.get( Integer.parseInt( pageId ));
            cp.setMainPix( null );
            contentPageDao.update( cp );
            return "pix removed: PAGE ID: " + pageId ;

        }
        else {
            Image pix = pixDao.get( Integer.parseInt( pixId ));
            ContentPage cp = contentPageDao.get( Integer.parseInt( pageId ));
            cp.setMainPix( pix );
            contentPageDao.update( cp );
            return "main pix set on content page, method PIX ID: " +  pixId + "    PAGE ID: " + pageId ;
        }

    }


}
