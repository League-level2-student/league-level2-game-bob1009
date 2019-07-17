import javax.swing.JFrame;

public class DinoRunner {
	JFrame gameframe=new JFrame();
	public static final int WIDTH;
	public static final int HEIGHT;
public static void main(String[] args) {
	DinoRunner dn=new DinoRunner();
	DinoRunner.setup();
}
DinoRunner(JFrame frame){
	setup();
}
void setup() {
	WIDTH=800;
	HEIGHT=500;
	gameframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
