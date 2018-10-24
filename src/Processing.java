import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;


public class Processing {
	private BufferedImage BuffImage, temp;
	private String imageFormat ;
	
	public Processing( BufferedImage buff, String imageFormat ) throws IOException
	{
		BuffImage = buff;
		this.imageFormat = imageFormat;
		this.temp = BuffImage;
		ArrayList<Cor> points = new ArrayList<Cor>();
		
		points = getBW();
		
		System.out.println("Points: "+points.size());
		System.out.println("Total pixels: "+ ( BuffImage.getHeight() * BuffImage.getWidth() ) );
		
		for( Cor val : points ){
			System.out.println( val.getX()+" "+val.getY() );
		}
		
		
		
		writeImage();
	}
	
	
	/*
	 * Get coordinate of points 
	 */
	private ArrayList< Cor > getBW()
	{
		ArrayList<Cor> ret = new ArrayList();
		
		double tot = 0.00;
		for(int i=0;i<BuffImage.getWidth();i++){
			for(int j=0;j<BuffImage.getHeight();j++){
				int val = BuffImage.getRGB(i, j);
				tot += 0.00 + val;
			}
		}
		
		double avarage = tot / ( 1.00 * BuffImage.getHeight() * BuffImage.getWidth() );
		
		int cnt = 0;
		for(int i=0;i<BuffImage.getWidth();i++){
			for(int j=0;j<BuffImage.getHeight();j++){
				
				double  val = 1.00 * BuffImage.getRGB(i, j);
				if( val <= avarage ) cnt++;
				
			}
		}
		
		int cnt2 = BuffImage.getHeight() * BuffImage.getWidth();
		cnt2-= cnt;
		
		int red = new Color(255,0,0).getRGB();
		int green = new Color(0,128,0).getRGB();
		
		for(int i=0;i<BuffImage.getWidth();i++){
			for(int j=0;j<BuffImage.getHeight();j++){
				
				double val = 1.00 * BuffImage.getRGB(i, j);
				if( cnt < cnt2 ){
					if( val <= avarage ){
						ret.add( new Cor( i,j ) );
						temp.setRGB(i, j, red);
					}
					else temp.setRGB(i, j, green);
				}
				else{
					if( val > avarage ){
						ret.add( new Cor(i,j) );
						temp.setRGB(i, j, red);
					}
					else temp.setRGB(i, j, green);
				}
				
			}
		}
		
		return ret;
	}
	
	public void writeImage() throws IOException
	{
		//String formetName = temp.get
		//temp = BuffImage;
		ImageIO.write(temp, imageFormat, new File("images/out2.jpg"));
	}
	
	
	
}
