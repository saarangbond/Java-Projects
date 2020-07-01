import java.awt.Color;
import java.awt.Graphics;

public class Projectile{
	private int x;
	private int y;
	
	private int width;
	private int height;
	
	private Color proj;
	private boolean visible;

	
	public Projectile(int x, int y){
		
		this.x = x;
		this.y = y;
		
		this.width = 10;
		this.height = 10;
		
		this.proj = new Color(58, 192, 222);
		this.visible = false;

	}
	

	public void drawMe(Graphics g){
		
		if( visible ){
			g.setColor(proj);
			g.fillOval(x,y,width,height);
		}
		
	}
	
	public void shoot(){
		if(!visible){
			visible = true;
		}
	}
	
	public void moveUp(Enemy[] enemies){
		
		if( visible ){
			y-=4;
		
			boolean above = true;
			for(int i = 0; i < enemies.length; i++){
				if(y > enemies[i].getY()){
					above = false;
				}
			}
			if(above){
				visible = false;
			}
		}
	}
	
	public void setPosition(int x, int y){
		this.x = x + 20;
		this.y = y - 40;
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
				e.playBoomSound();
				e.setVisibleFalse();
				this.visible = false;
				setPosition(0, 0);
				Screen.increaseScore();
			}
		}
	}
	
	public void checkCollision(Boss b){
		if(b.getVisible()){
			int pX = this.x;
			int pY = this.y;
			int pWidth = this.width;
			int pHeight = this.height;
			int tX = b.getX();
			int tY = b.getY();
			int tWidth = b.getWidth();
			int tHeight = b.getHeight();
			
			if(pX+pWidth >= tX && pX <= tX + tWidth && pY+pHeight >= tY && pY <= tY + tHeight ){
				b.decreaseHealth();
				b.playBoomSound();
				this.visible = false;
			}
		}
	}
	
}