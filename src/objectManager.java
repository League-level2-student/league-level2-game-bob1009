import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class objectManager {
Dinosaur dino;
boolean isactive=false;
Random ran=new Random();
GamePanels panel=new GamePanels();
ArrayList<spikes> pointy = new ArrayList<spikes>();
objectManager(Dinosaur saur){
	this.dino=saur;
	Random ran = new Random();
	addCactus();
	addCactus();
}
void addCactus() {
	pointy.add(new spikes(DinoRunner.WIDTH,0,50,50));
	
}
void update() {
	dino.update();
	for (int i = 0; i < pointy.size(); i++) {
		spikes j = pointy.get(i);
		j.update();
		if (j.Y > DinoRunner.WIDTH) {
			j.isActive = false;
}
}
	
}

	 void checkCollision() {
			for (int i = 0; i < pointy.size(); i++) {
				spikes c = pointy.get(i);
				if (dino.collisionbox.intersects(c.collisionbox)) {
					dino.isactive = false;
					panel.currentState++;
				}
			}
	}
 


void draw(Graphics g) {
	dino.draw(g);
	for (int i = 0; i < pointy.size(); i++) {
		spikes j = pointy.get(i);
		j.draw(g);
		
	}
}
void purgeObjects() {
	for (int i = 0; i < pointy.size(); i++) {
	spikes singleAlien = pointy.get(i);
		if (singleAlien.isActive == false) {
			pointy.remove(singleAlien);
		}
}
	
}

	
}

