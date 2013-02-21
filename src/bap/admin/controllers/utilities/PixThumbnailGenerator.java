package bap.admin.controllers.utilities;

import bap.logging.LoggerBean;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: tomaszbrymora
 * Date: Apr 13, 2009
 * Time: 9:00:12 AM
 * To change this template use File | Settings | File Templates.
 *
 * We create a thumbnail image for administrative purposes only,  when a pix gets uploaded
 *
 * based on: http://javaxden.blogspot.com/2007/08/creatin-thumbnail.html,
 * MODIFIED by tb on 4.13.09 to work in web context as a stand alone service class
 * mod based on service class used in my LogBook program, crating slideshows
 *
 */
public class PixThumbnailGenerator {

	/**
	 * 
	 * @param pathToPix
	 * @param pathToThumb
	 * @param thmPx
	 * @param orientation
	 */
    private static final int INT_QUALITY = 100;
    private static final float FLOAT_QUALTIY = 100.0f ;

    public void generateThumbnail(String pathToPix, String pathToThumb, int thmPx, String orientation) {

		java.awt.Image pix = null;

		File t = new File(pathToPix);
		try {
			pix = ImageIO.read(t);
		} catch (Exception e) {
            LoggerBean.getLoggerBean().getLogger().debug( "something went worong trying to read the original image" );
        }

		float thumbHeight = 0;
		float thumbWidth = 0;


		float imageWidth = pix.getWidth(null);
		float imageHeight = pix.getHeight(null);


		/* by default calculate thumbs to be of the same WIDTH */
		if (orientation.equalsIgnoreCase("wide")) {
			thumbWidth = thmPx;
			thumbHeight = thmPx * (imageHeight / imageWidth);
		} else {
			thumbWidth = thmPx / (imageHeight / imageWidth);
			thumbHeight = thmPx;
		}

		BufferedImage thumbImage = new BufferedImage((int) thumbWidth, (int) thumbHeight, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2D = thumbImage.createGraphics();
		graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


		graphics2D.drawImage(pix, 0, 0, (int) thumbWidth, (int) thumbHeight, null);

		try {

			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(pathToThumb));
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(thumbImage);

			param.setQuality((float) INT_QUALITY / FLOAT_QUALTIY, false);
			encoder.setJPEGEncodeParam(param);
			encoder.encode(thumbImage);
			out.close();


		} catch (FileNotFoundException e) {
            LoggerBean.getLoggerBean().getLogger().debug( "file not found" );
            LoggerBean.getLoggerBean().getLogger().debug( e.getCause()  );

            //To change body of catch statement use File | Settings | File Templates.
            LoggerBean.getLoggerBean().getLogger().debug( e.getMessage() );


		} catch (IOException e) {
            LoggerBean.getLoggerBean().getLogger().debug( "IOExeption" );
            LoggerBean.getLoggerBean().getLogger().debug( e.getCause() );

            //To change body of catch statement use File | Settings | File Templates.
            LoggerBean.getLoggerBean().getLogger().debug( e.getMessage() );
		}

        LoggerBean.getLoggerBean().getLogger().info( "\nGenerating thumb for : \n" + pathToPix + "\nThumb name: " );

	}// generateThumbnail


	/**
	 *
	 * @param r
	 * @param subDir
	 * @return
	 */
	public final String pathToArtUploadDir( HttpServletRequest r, String subDir , String fn ){

		File pathToPix = new File( r.getSession().getServletContext().getRealPath("/art/upload") );

		if( subDir != null ){
			pathToPix = new File( pathToPix.getPath(),subDir );
		}

		if( fn != null ) {
			pathToPix = new File( pathToPix.getPath(), fn );
		}

		return pathToPix.toString();
	} // pathToArtUploadDir

}
