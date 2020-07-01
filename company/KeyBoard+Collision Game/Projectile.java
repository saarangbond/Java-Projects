import java.awt.Color;
import java.awt.Graphics;

public class Projectile{
	private int x;
	private int y;
	
	private int width;
	private int height;
	
	private Color red;
	private boolean visible;

	
	public Projectile(int x, int y){
		
		this.x = x;
		this.y = y;
		
		this.width = 10;
		this.height = 10;
		
		this.red = new Color(255,0,0);
		this.visible = false;


	}
	

	public void drawMe(Graphics g){
		
		if( visible ){
			g.setColor(red);
			g.fillOval(x,y,width,height);
		}
		
	}
	
	public void shoot(){
		visible = true;
	}
	
	public void moveRight(){
		
		if( visible )
			x+=3;
		
		//make projectile false so that you can shoot again
		if( x > 800 ){
			visible = false;
		}
		
	}
	
	public void setPosition(int x, int y){
		
		if( visible == false ){
			this.x = x;
			this.y = y;
		}	
		
	}
	
	
	public void checkCollision(Enemy e){
		if(e.getVisible()){
			int pX = this.x;
			int pY = this.y;
			int pWidth = this.width;
			int pHeight = this.height;
			int tX = e.getX();
			int tY = e.getY();
			int tWidth = e.getWidth();
			int tHeight = e.getHeight();
			
			if(pX+pWidth >= tX && pX <= tX + tWidth && pY+pHeight >= tY && pY <= tY + tHeight ){
				//System.out.println("Collision");
				e.setVisibleFalse();
			}
		}
	}
	
}
