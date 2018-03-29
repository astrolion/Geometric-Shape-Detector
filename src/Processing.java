import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Processing {
	private BufferedImage BuffImage, temp;
	private String imageFormat;
	private int height, width;

	public Processing(BufferedImage buff, String imageFormat)
			throws IOException {
		BuffImage = buff;
		temp = buff;
		this.imageFormat = imageFormat;
		this.height = buff.getHeight();
		this.width = buff.getWidth();
		ConvertBWImage();
		writeImage();
	}

	/*
	 * Converting image to B/W image
	 */
	private void ConvertBWImage() {
		System.out.println("Converting to B/W Image . . . ");
		
		Raster raster = BuffImage.getRaster();
		double sum = 0.0;

		/*
		 * Calculating average pixel value
		 */

		for (int y = 0; y < height; ++y) {
			for (int x = 0; x < width; ++x) {
				sum += raster.getSample(x, y, 0);
			}
		}

		sum = sum / (height * width); // average of of the all pixels
		
		/*
		 * building B/W image
		 */
		for (int y = 0; y < height; ++y) {
			for (int x = 0; x < width; ++x) {
				if (raster.getSample(x, y, 0) <= sum) {
					temp.setRGB( x, y, Color.BLACK.getRGB() );
				} else {
					temp.setRGB( x, y, Color.WHITE.getRGB() );
				}
			}
		}
		
		
		

	}

	/*
	 * Writing B/W Image
	 */
	public void writeImage() throws IOException {
		// String formetName = temp.get

		ImageIO.write(temp, imageFormat, new File("out/output." + imageFormat));
		System.out
				.println("GrayScale image saved : /out/output." + imageFormat);
		System.out.println("Image : " + height + "*" + width);

	}

}
