import java.awt.Color;
import java.awt.Graphics;

public class Enemy{
	private int x;
	private int y;
	
	private int width;
	private int height;
	
	private boolean visible;
	
	private Color green;

	
	public Enemy(int x, int y){
		
		this.visible = true;
		this.x = x;
		this.y = y;
		
		this.width = 50;
		this.height = 50;
		
		this.green = new Color(0,255,00);
		
			
	}
	

	public void drawMe(Graphics g){
		if(visible){
			g.setColor(green);
			g.fillRect(x,y,width,height);
		}
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	
	public void setVisibleFalse(){
		this.visible = false;
	}
	public boolean getVisible(){
		return visible;
	}
}





