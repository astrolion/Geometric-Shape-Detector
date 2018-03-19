import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Processing {
	private BufferedImage BuffImage, temp;
	private String imageFormat ;
	
	public Processing( BufferedImage buff, String imageFormat )
	{
		BuffImage = buff;
		this.imageFormat = imageFormat;
	}
	
	
	
	public void writeImage() throws IOException
	{
		//String formetName = temp.get
		ImageIO.write(temp, imageFormat, new File("images/out2.jpg"));
	}
	
	
	
}
