/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bap.admin.controllers.utilities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * materials found at: http://java-servlet-jsp-web.blogspot.com/search/label/Java%20programs
 *
 *
 * Perfect image resizer which will give good quality
 * @author SANTHOSH REDDY MANDADI
 * @version 1.0
 * @since 16th June 2009
 */
public final class ImageResizer {

    private static final int INT_DIVISOR_100 = 100;
    private static final int INT_NEW_WIDTH = 200;

    private static final ImageResizer INSTANCE = new ImageResizer();
    private ImageResizer(){}

    public static ImageResizer getInstance(){
        return INSTANCE;
    }

    /**
	 * A static method to create the thumbnail of the mentioned sizes
	 * @author SANTHOSH REDDY MANDADI
	 * @param sourceFile represents the original file from where the thumbanil to be created
	 * @param destFile represents the output file path to store the thumbnail
	 * @param newWidth represents the width
	 * @param newHeight represents the height
	 * @since 16th June 2009
	 */
	public static void createThumbnail(String sourceFile, String destFile, int newWidth, int newHeight) throws IOException {
		BufferedImage image = ImageIO.read(new File(sourceFile));
		int width = image.getWidth();
		int height = image.getHeight();

		boolean isTranslucent = image.getType() != Transparency.OPAQUE;

        checkWidthAndHeight(newWidth, width, newHeight, height);


		BufferedImage thumb = image;
		BufferedImage temp = null;
		Graphics2D g2 = null;
		Map map = new HashMap();
		map.put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		map.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		map.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		try {
			int previousWidth = width;
			int previousHeight = height;
			do {
                width = checkWidth(width, newWidth);

				if (height > newHeight) {
					height /= 2;
					if (height < newHeight) {
						height = newHeight;
					}
				} // if
				if (temp == null || isTranslucent) {
					if (g2 != null) {
						//do not need to wrap with finally
						//outer finally block will ensure
						//that resources are properly reclaimed
						g2.dispose();
					}
					temp = createCompatibleImage(image, width, height);
					g2 = temp.createGraphics();
					g2.setRenderingHints(map);
				}
				g2.drawImage(thumb, 0, 0, width, height, 0, 0, previousWidth, previousHeight, null);
				previousWidth = width;
				previousHeight = height;
				thumb = temp;
			} while (width != newWidth || height != newHeight);
		} finally {
			g2.dispose();
		}
		if (width != thumb.getWidth() || height != thumb.getHeight()) {
			temp = createCompatibleImage(image, width, height);
			g2 = temp.createGraphics();
			try {
				g2.setRenderingHints(map);
				g2.drawImage(thumb, 0, 0, width, height, 0, 0, width, height, null);
			} finally {
				g2.dispose();
			}
			thumb = temp;
		}
		ImageIO.write(thumb, destFile.substring(destFile.lastIndexOf('.') + 1), new FileOutputStream(destFile));
	}

    private static int checkWidth(int width, int newWidth) {
        int w = 0;
        if (width > newWidth) {
        w /= 2;
        if (width < newWidth) {
            w = newWidth;
        }

        } // if
        return w;
    }

    private static void checkWidthAndHeight(int newWidth, int width, int newHeight, int height) {

        if (newWidth >= width || newHeight >= height) {
            throw new IllegalArgumentException("newWidth and newHeight cannot be greater than the image dimensions");
        } else if (newWidth <= 0 || newHeight <= 0) {
            throw new IllegalArgumentException("newWidth and newHeight must be greater than 0");
        }

    }

    public static BufferedImage createCompatibleImage(BufferedImage image, int width, int height) {
		return isHeadless() ? new BufferedImage(width, height, image.getType()) : getGraphicsConfiguration().createCompatibleImage(width, height);
	}
	// Returns the graphics configuration for the primary screen

	private static GraphicsConfiguration getGraphicsConfiguration() {
		return GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
	}

	private static boolean isHeadless() {
		return GraphicsEnvironment.isHeadless();
	}

	public static void main(String[] args) throws IOException {
		//Fetch the image height and width (I'm hardcoding them here, if you don't know how to get look at creatThumbnail method)
		BufferedImage image = ImageIO.read(new File("Water.jpg"));
		int imgWidth = image.getWidth();
		int imgHeight = image.getHeight();
		//Original size of the image is
		int newWidth = INT_NEW_WIDTH;
		//Calculating the percentage of image width going to be reduced
		double imgHeightPercentage = (newWidth / (double) imgWidth) * INT_DIVISOR_100;
		//Calculating the height based on the above percentage
		double imgTotalHeight = imgHeight * (imgHeightPercentage / INT_DIVISOR_100);
		int newHeight = (int) Math.round(imgTotalHeight);
		ImageResizer.createThumbnail("Water.jpg", "aWater.jpg", newWidth, newHeight);
	}
} // ImageResizer

