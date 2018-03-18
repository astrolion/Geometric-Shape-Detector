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

		//String imageName = sc.nextLine();
		// System.out.println(imageName);

		File fi = new File("images/image1.jpg");

		byte[] fileContent;

		try {
			fileContent = Files.readAllBytes(fi.toPath());

			InputStream in = new ByteArrayInputStream(fileContent);
			BufferedImage bi = ImageIO.read(in);
			BufferedImage temp = bi;
			
			Processing obj = new Processing(temp);
			
			

		} catch (IOException e) {
			System.out.println("Error Mesage : " + e.getMessage());
			e.printStackTrace();
		}

	}

}
