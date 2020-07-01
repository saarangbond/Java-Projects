import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
 
public class Snow{
    
	private int x;
	private int y;
	private Color snow;
	private Random rand = new Random();
	
	public Snow(int x, int y){
		snow = new Color(223, 224, 224);
		this.x = x;
		this.y = y;
	}
	 
    public void drawMe(Graphics g, boolean winter){
		if(winter == true){
			g.setColor(snow);
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