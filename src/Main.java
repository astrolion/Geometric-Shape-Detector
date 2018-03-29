import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter image directory: ");

		String imageName = sc.nextLine();
		// System.out.println(imageName);

		File fi = new File(imageName);
		
		String imageFormat = formetName(imageName);
		System.out.println("Image Format: "+imageFormat);
		
		byte[] fileContent;

		try {
			fileContent = Files.readAllBytes(fi.toPath());

			InputStream in = new ByteArrayInputStream(fileContent);
			BufferedImage bi = ImageIO.read(in);
			BufferedImage temp = bi;
			
			Processing obj = new Processing(temp,imageFormat);

		} catch (IOException e) {
			System.out.println("Error Mesage : " + e.getMessage());
			//e.printStackTrace();
		}

	}

	/*
	 * Extracting image format from image
	 */
	
	public static String formetName(String s) {
		String ret = "";
		int len = s.length();
		for (int i = len - 1; i >= 0; i--) {
			if (s.charAt(i) == '.')
				break;
			else
				ret += s.charAt(i);
		}
		String ans = "";
		for (int i = ret.length() - 1; i >= 0; i--)
			ans += ret.charAt(i);
		return ans;
	}

}
