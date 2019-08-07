import java.awt.Color;
import java.awt.Graphics;

public class Dinosaur extends DinoGameObject {
	Dinosaur(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed=10;
	}

void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(0, 350, 1000, 350);
		g.fillRect(X, Y, width, height);
	}
}
