/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bap.controllers;

import bap.admin.controllers.utilities.PixThumbnailGenerator;
import bap.admin.controllers.utilities.ViewBuilder;
import bap.domain.DomainObject;
import bap.domain.Image;
import bap.persistance.dao.AlbumDao;
import bap.persistance.dao.Dao;
import bap.persistance.dao.ImageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tomaszbrymora
 */
@Controller
public class ImageController {
	private DomainObject image;
	private ImageDao imageDao;
	private AlbumDao albumDao;
	private PixThumbnailGenerator pixThumbnailGenerator;

    private static final String REDIRECT_ADMIN_IMAGE_READ_LIST = "redirect:/admin/image/read/list.html";
    private static final String ADMIN_IMAGE_CROP = "/admin/image/crop.html";
    private static final String ART_UPLOAD = "/art/upload/";
    private static final String IMAGE = "image";
    private static final String INDEX = "index";


    private static final int DEFAULT_WIDTH_AND_HEIGHT = 100;


    @Autowired
	public ImageController( Image image, ImageDao imageDao, AlbumDao albumDao, PixThumbnailGenerator pixThumbnailGenerator ){
		this.image = image;
		this.imageDao = imageDao;
		this.albumDao = albumDao;
		this.pixThumbnailGenerator = pixThumbnailGenerator;
	}

	/*----------------------------------------------------------------------
		UPLOAD
	 ---------------------------------------------------------------------*/
	@RequestMapping("/admin/image/upload.html")
	public final ModelAndView uploadImage( ModelMap model ){

		ModelAndView mov = new ModelAndView();
		ViewBuilder vb = new ViewBuilder.Builder()
			.modelPart(IMAGE, image )
			.modelPart("albumy", albumDao.list() )
			.section(IMAGE)
			.page(INDEX)
			.element("form_upload")
			.action("/admin/image/save.html")
			.build();

		mov.addAllObjects(vb.getViewParts()).setViewName(vb.getLayout());
		return mov;
	}

	/*----------------------------------------------------------------------
		SAVE UPLOADED
	 ---------------------------------------------------------------------*/
	@RequestMapping("/admin/image/save.html")
	public final ModelAndView saveImage(  HttpServletRequest request, @ModelAttribute(IMAGE) Image image, @RequestParam( value="pix", required=true) MultipartFile pix ){

		try {
			File f = new File(request.getSession().getServletContext().getRealPath(ART_UPLOAD), pix.getOriginalFilename());
			pix.transferTo(f);
		} catch (IOException ioex) {
			Logger.getLogger(ImageController.class.getName()).log(Level.SEVERE, null, ioex);
		} finally {
			try {
				BufferedImage bi = ImageIO.read(new File(request.getSession().getServletContext().getRealPath(ART_UPLOAD + pix.getOriginalFilename())));
				image.setWidth(bi.getWidth());
				image.setHeight(bi.getHeight());
				image.setSrc(pix.getOriginalFilename());
				imageDao.save(image);
				bi.flush();
				bi = null;
			} catch (IOException ex) {
				Logger.getLogger(ImageController.class.getName()).log(Level.SEVERE, null, ex);
			}
		}// finally
		pixThumbnailGenerator.generateThumbnail(
			request.getSession().getServletContext().getRealPath(ART_UPLOAD + pix.getOriginalFilename()),
			request.getSession().getServletContext().getRealPath("/art/upload/thm/" + pix.getOriginalFilename()),
                DEFAULT_WIDTH_AND_HEIGHT,
			"wide" );

		ViewBuilder vb = new ViewBuilder.Builder()
			.modelPart(IMAGE, image)

             /* includes overrides of default form css for other crop details */
			.modelPart("css", "/js/Jcrop/css/jquery.Jcrop.css")
			.modelPart("js_lib", "/js/Jcrop/js/jquery.Jcrop.min.js")
			.section(IMAGE)
			.page(INDEX)
			.element("crop")
			.action(ADMIN_IMAGE_CROP)
			.build();
		ModelAndView mov = new ModelAndView();
		mov.addAllObjects(vb.getViewParts()).setViewName(vb.getLayout());
		return mov;
	}

	/*----------------------------------------------------------------------
		CROP - THUMBNAIL
	 ---------------------------------------------------------------------*/
	@RequestMapping(ADMIN_IMAGE_CROP)
	public final ModelAndView cropImage( 
		HttpServletRequest r,
		@ModelAttribute(IMAGE) Image image,
		@RequestParam( "x1") int x1,
		@RequestParam( "y1") int y1,
		@RequestParam( "x2") int x2,
		@RequestParam( "y2") int y2,
		@RequestParam( "w" ) int w,
		@RequestParam( "h" ) int h,
		@RequestParam( required = false, value = "cropOption" ) String cropOption,
		@RequestParam( required = false, value = "thmPx" ) int thmPx,
		@RequestParam( required = false, value = "orientation" ) String orientation
		) {



		/* CROP ONLY */

		if ( cropOption.equals("crop_only") ) {
			try {
				/* read in original -> trim to size :-) */
				BufferedImage cropped = ImageIO.read(new File( pixThumbnailGenerator.pathToArtUploadDir( r, null , image.getSrc() ))).getSubimage(x1, y1, w, h);

				/* write thumbnail */
				ImageIO.write(cropped, "jpg", new File( pixThumbnailGenerator.pathToArtUploadDir(r, null,  image.getSrc())));

			} catch (IOException ex) {
				Logger.getLogger(ImageController.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		/* THUMBNAIL ONLY */

		if( cropOption.equals("thumbnail_only")){

			try {
				/* read in original -> trim to size :-) */
				BufferedImage original = ImageIO.read(new File( pixThumbnailGenerator.pathToArtUploadDir(r, null,   image.getSrc() ) ) );
				BufferedImage cropped=  original.getSubimage(x1, y1, w, h);

				/* write thumbnail */
				ImageIO.write(cropped, "jpg", new File(( pixThumbnailGenerator.pathToArtUploadDir(r, "thm" , image.getSrc()) )));

				pixThumbnailGenerator.generateThumbnail( pixThumbnailGenerator.pathToArtUploadDir(r, "thm", image.getSrc()  ) , pixThumbnailGenerator.pathToArtUploadDir(r, "thm", image.getSrc()  ) , thmPx, orientation );

			} catch (IOException ex) {
				Logger.getLogger(ImageController.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		/*CROP & THUMBNAIL */
		if ( cropOption.equals("crop_and_thumbnail")){
			try {
				/* read in original */
				BufferedImage origianl = ImageIO.read(new File(r.getSession().getServletContext().getRealPath(ART_UPLOAD + image.getSrc())));

				/* trim to size :-) */
				BufferedImage cropped = origianl.getSubimage(x1, y1, w, h);

				/* write thumbnail */
				ImageIO.write(cropped, "jpg", new File(r.getSession().getServletContext().getRealPath(ART_UPLOAD + image.getSrc())));

			} catch (IOException ex) {
				Logger.getLogger(ImageController.class.getName()).log(Level.SEVERE, null, ex);
			}
			pixThumbnailGenerator.generateThumbnail(
				r.getSession().getServletContext().getRealPath(ART_UPLOAD + image.getSrc()),
				r.getSession().getServletContext().getRealPath("/art/upload/thm/" + image.getSrc()),
                    thmPx, orientation );
		}

		ViewBuilder vb = new ViewBuilder.Builder()
			.modelPart(IMAGE, image )

            /* includes overrides of default form css for other crop details */
			.modelPart("css", "/js/Jcrop/css/jquery.Jcrop.css")
			.modelPart("js_lib", "/js/Jcrop/js/jquery.Jcrop.min.js")
			.section(IMAGE)
			.page(INDEX)
			.element("crop")
			.action(ADMIN_IMAGE_CROP)
			.build();
		ModelAndView mov = new ModelAndView();
		mov.addAllObjects(vb.getViewParts()).setViewName(vb.getLayout());
		return mov;
	} // cropImage

	/*----------------------------------------------------------------------
		EDIT
	 ---------------------------------------------------------------------*/
	@RequestMapping( "/admin/image/edit/{id}.html" )
	public final ModelAndView editImage( HttpServletRequest request, @PathVariable("id") int id ){
		ViewBuilder vb = new ViewBuilder.Builder()
			.modelPart(IMAGE, imageDao.get(id))

            /* includes overrides of default form css for other crop details */
			.modelPart("css", "/js/Jcrop/css/jquery.Jcrop.css")
			.modelPart("js_lib", "/js/Jcrop/js/jquery.Jcrop.min.js")
			.section(IMAGE)
			.page(INDEX)
			.element("crop")
			.action(ADMIN_IMAGE_CROP)
			.build();
		ModelAndView mov = new ModelAndView();
		mov.addAllObjects(vb.getViewParts()).setViewName(vb.getLayout());
		return mov;
	}

	/*----------------------------------------------------------------------
		DELETE
	 ---------------------------------------------------------------------*/
	@RequestMapping("/admin/image/delete/{id}.html")
	public final String /*ModelAndView*/ deleteImage( HttpServletRequest request, @PathVariable("id") int id ) throws IOException{

		/** todo: START - implment transaction */

		bap.domain.Image img = (Image) imageDao.get(id);

		/* delete files: ORIGINAL , THUMBNAIL */
		File original = new File(  request.getSession( false ).getServletContext().getRealPath(ART_UPLOAD ), img.getSrc() );

		if( original.exists() ){
			original.delete();
		}

		File thumbnail = new File(  request.getSession( false ).getServletContext().getRealPath("/art/upload/thm/"),  img.getSrc() );

		if( thumbnail.exists() ){
			thumbnail.delete();
		}
		
		imageDao.delete(id);

		/** todo: END - transation  */
		
		return REDIRECT_ADMIN_IMAGE_READ_LIST;
	}

	/*----------------------------------------------------------------------
		LIST
	 ---------------------------------------------------------------------*/
	@RequestMapping("/admin/image/read/list.html")
	public ModelAndView listImages(  ){
		ModelAndView mov = new ModelAndView();
		ViewBuilder vb = new ViewBuilder.Builder()
			.modelPart("images", imageDao.list())
			.section(IMAGE)
			.page(INDEX)
			.element("list")
			.build();
		mov.addAllObjects(vb.getViewParts()).setViewName(vb.getLayout());
		return mov;
	}




}
