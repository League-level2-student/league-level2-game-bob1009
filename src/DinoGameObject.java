import java.awt.Rectangle;

public class DinoGameObject {
	int X;
	  int Y;
	 int width;
	 int height;
	 int speed=0;
	 Rectangle collisionbox;
	 boolean isActive=true;
 DinoGameObject(int x, int y, int height, int width){
	this.X=x;
	this.Y=y;
	this.width=width;
	this.height=height;
	 collisionbox = new Rectangle(x,y,width,height);
	 }
	void  update(){
		 collisionbox.setBounds(X, Y, width, height);
	 }
}
