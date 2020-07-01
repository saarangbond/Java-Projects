import java.awt.Color;
import java.awt.Graphics;

public class Ship{
	private int x;
	private int y;
	
	private int width;
	private int height;
	
	private boolean visible;
	private boolean collision;
	
	private Color blue;
	
	public Ship(int x, int y){
		
		this.x = x;
		this.y = y;
		
		this.width = 50;
		this.height = 50;
		
		this.visible = true;
		this.collision = false;
		
		this.blue = new Color(0,0,255);
		
	}
	

	public void drawMe(Graphics g){
		if(visible){
			g.setColor(blue);
			g.fillRect(x,y,width,height);
			g.fillRect(x + 10, y - 20, 30, 20);
			g.fillRect(x + 20, y - 40, 10, 20);
		}
	}
	
	public void moveLeft(){
		if(x > 0)
			x -= 7;
	}
	
	public void moveRight(){
		if(x < 950)
			x += 7;
	}
	
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void checkCollision(Enemy e){
		if(e.getVisible()){
			int sX = this.x;
			int sY = this.y;
			int sWidth = this.width;
			int sHeight = this.height;
			int tX = e.getX();
			int tY = e.getY();
			int tWidth = e.getWidth();
			int tHeight = e.getHeight();
			
			if(sX+sWidth >= sX && sX <= tX + tWidth && sY+sHeight >= tY && sY <= tY + tHeight ){
				//System.out.println("Collision");
				e.setVisibleFalse();
				this.visible = false;
				collision = true;
			}
		}
	}
	
	public boolean getCollision(){
		return collision;
	}
	public void setVisible(){
		this.visible = true;
	}
	public void setNotVisible(){
		this.visible = false;
	}
	
	
	
}