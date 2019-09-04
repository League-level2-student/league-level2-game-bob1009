import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public class spikes extends DinoGameObject{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	int speed =10;
	Random ram=new Random();
	
	spikes(int x, int y, int height, int width) {
		super(x, y, height, width);
		Y=300;
		if (needImage) {
		    loadImage ("cactus.png");
		}
	}
	void draw(Graphics g) {
		
	        if (gotImage) {;
	        	g.drawImage(image, X, Y, width, height, null);
	        } else {
	        	g.setColor(Color.YELLOW);
	        	g.fillRect(X, Y, width, height);
	        }
	        
	     
	}
	void update() {
		super.update();
		X-= speed;
		if(X<-width) {
			X=DinoRunner.WIDTH+ram.nextInt(1000);
			
		}
	}
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	
}
