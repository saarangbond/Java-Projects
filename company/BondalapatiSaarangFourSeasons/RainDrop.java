import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
 
public class RainDrop{
    
	private int x;
	private int y;
	private Color blue;
	private Random rand = new Random();
	
	public RainDrop(int x, int y){
		blue = new Color(0, 0, 200);
		this.x = x;
		this.y = y;
	}
	 
    public void drawMe(Graphics g, boolean spring){
		if(spring == true){
			g.setColor(blue);
			g.fillOval(x, y, 5, 10);
		}	
	}
	public void moveDown(){
		y+= rand.nextInt(3) + 1;
		
		if(y > rand.nextInt(150) + 650){
			y = - rand.nextInt(5) + 5;
		}
	}
     
}