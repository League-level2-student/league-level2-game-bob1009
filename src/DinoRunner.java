import java.awt.Component;
import java.awt.Frame;

import javax.swing.JFrame;
import java.awt.Panel;
import javax.swing.JPanel;
public class DinoRunner {
	GamePanels gpanel=new GamePanels();
	JFrame gameframe=new JFrame();
	public static final int WIDTH=1000;
	public static final int HEIGHT=500;
public static void main(String[] args) {
	DinoRunner rn =new DinoRunner();
}
DinoRunner(){
	setup();
}
void setup() {
	gameframe.add(gpanel);
	gameframe.setVisible(true);
	gameframe.setSize(WIDTH,HEIGHT);
	gameframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	gameframe.addKeyListener(gpanel);
}
}
