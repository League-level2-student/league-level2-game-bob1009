import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanels extends JPanel implements ActionListener, KeyListener {
	final int menu = 0;
	final int game = 1;
	final int end = 2;
	Font titlefont;
	int currentState = menu;
	Timer framerate;
	Dinosaur dino = new Dinosaur(200, 295, 50, 50);
	objectManager oj = new objectManager(dino);

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == menu) {
			drawMenuState(g);
		} else if (currentState == game) {
			drawGameState(g);
		} else if (currentState == end) {
			drawEndState(g);
		}
	}

	void updateMenuState() {

	}

	void updateGameState() {
		oj.update();
		
		if (dino.isActive == false) {
			currentState++;
			
		}
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, DinoRunner.WIDTH, DinoRunner.HEIGHT);
		g.setFont(titlefont);
		g.setColor(Color.RED);
		g.drawString("Dinosaur Game", 40, 50);
		g.setFont(titlefont);
		g.setColor(Color.RED);
		g.drawString("press enter to start", 50, 150);
		g.drawString("Press space for directions", 50, 200);

	}

	void drawGameState(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, DinoRunner.WIDTH, DinoRunner.HEIGHT);
		oj.draw(g);
		g.drawString("score:" + oj.score, 900, 20);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, DinoRunner.WIDTH, DinoRunner.HEIGHT);
		g.setFont(titlefont);
		g.setColor(Color.YELLOW);
		g.drawString("YOU DIED", 40, 50);
		g.drawString("Score:" + oj.score, 100, 100);
	}

	GamePanels() {
		titlefont = new Font("Arial", Font.PLAIN, 50);
		framerate = new Timer(1000 / 60, this);
		framerate.start();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (currentState == menu) {
			updateMenuState();
		} else if (currentState == game) {
			updateGameState();
		} else if (currentState == end) {
			updateEndState();
		}
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == menu) {
				currentState = game;
				oj.reset();
			} else  if(currentState!=game){

				currentState++;
				if(currentState>end) {
					currentState=menu;
				}
			}
		}
		else if (currentState == menu && e.getKeyCode() == KeyEvent.VK_SPACE) {
			JOptionPane.showMessageDialog(null,
					"This is an infinite game, press space to jump, if you hit a cactus, you lose.");
		}
		else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			dino.jump();
			dino.pressed = true;
			if(dino.Y<349&&e.getKeyCode()==KeyEvent.VK_SPACE) {
				dino.jump();
			}
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			dino.pressed = false;
		}
	}
}
