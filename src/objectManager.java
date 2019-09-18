import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class objectManager {
	Dinosaur dino;
	boolean isactive = false;
	Random ran = new Random();
	int score = 0;
	ArrayList<spikes> pointy = new ArrayList<spikes>();

	objectManager(Dinosaur saur) {
		this.dino = saur;
		Random ran = new Random();
		addCactus();
		addCactus();
	}

	void addCactus() {
		pointy.add(new spikes(DinoRunner.WIDTH, 0, 50, 50));

	}

	void update() {
		score++;
		dino.update();
		for (int i = 0; i < pointy.size(); i++) {
			spikes j = pointy.get(i);
			j.update();
			
		}
		checkCollision();
	}

	void checkCollision() {
		for (int i = 0; i < pointy.size(); i++) {
			spikes c = pointy.get(i);
			if (dino.collisionbox.intersects(c.collisionbox)) {
				dino.isActive = false;
				break;
				//System.out.println(";LKA");

			}
		}

	}

	int getscore() {
		return score;
	}

	void draw(Graphics g) {
		dino.draw(g);
		for (int i = 0; i < pointy.size(); i++) {
			spikes j = pointy.get(i);
			j.draw(g);

		}
	}

	
	void reset() {
		System.out.println("yeeeeet");
		for (int i = 0; i < pointy.size(); i++) {
			spikes t = pointy.get(i);
			t.X = DinoRunner.WIDTH;
		}
		dino.isActive=true;	
		score=0;
	}
}
