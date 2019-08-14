import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Dinosaur extends DinoGameObject {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	Dinosaur(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed=10;
		if (needImage) {
		    loadImage ("Dinosaur.png");
		}
	}

void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(0, 350, 1000, 350);
		g.fillRect(X, Y, width, height);
		if (gotImage) {
			g.drawImage(image, X, Y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(X, Y, width, height);
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
