import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Processing {
	private BufferedImage BuffImage, temp;
	
	public Processing( BufferedImage buff )
	{
		BuffImage = buff;
	}
	
	
	public void writeImage() throws IOException
	{
		ImageIO.write(temp, "jpg", new File("images/out2.jpg"));
	}
	
	
	
}
