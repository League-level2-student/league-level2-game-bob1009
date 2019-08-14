import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class spikes extends DinoGameObject{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	int speed =1;
	
	spikes(int x, int y, int height, int width) {
		super(x, y, height, width);
		if (needImage) {
		    loadImage ("cactus.png");
		}
	}
	void draw(Graphics g) {
		 g.setColor(Color.YELLOW);
	        g.fillRect(X, Y, width, height);
	        if (gotImage) {
	        	g.drawImage(image, X, Y, width, height, null);
	        } else {
	        	g.setColor(Color.YELLOW);
	        	g.fillRect(X, Y, width, height);
	        }
	}
	void update() {
		X-= speed;
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
