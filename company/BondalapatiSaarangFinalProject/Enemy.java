import java.awt.Color;
import java.awt.Graphics;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Enemy{
	private int x;
	private int y;
	
	private int n;
	private int m;
	
	private int width;
	private int height;
	
	private boolean visible;
	
	private Color green;
	private Color black;
	private Color white;

	
	public Enemy(int x, int y){
		
		this.visible = true;
		this.x = x;
		this.y = y;
		
		this.width = 50;
		this.height = 50;
		
		this.green = new Color(0,255,00);
		this.white = new Color(245, 240, 250);
		this.black = new Color(0, 0, 0);
		
		this.n = 1;
		this.m = 2;
	}
	

	public void drawMe(Graphics g){
		if(visible){
			g.setColor(green);
			g.fillRect(x,y,width,height);
			g.fillRect(x + 20, y - 30, 10, 30);
			g.fillRect(x + 5, y - 45, 40, 15);
			g.setColor(black);
			g.fillOval(x - 5, y - 45, 10, 10);
			g.fillOval(x + 40, y - 45, 10, 10);
			g.setColor(white);
			g.fillOval(x - 5, y - 44, 5, 5);
			g.fillOval(x + 40, y - 44, 5, 5);
		}
	}
	
	public void move(int level){
		if(visible){
			if(level == 1)
				x += n;
			else if(level == 2)
				x += m;
			if(x == 970 || x == 0){
				m *= -1;
				n *= -1;
				y += 55;
			}
			
		}
	}
	
	public void reset(){
		y = 75;
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
	public void setVisibleTrue(){
		this.visible = true;
	}
	public boolean getVisible(){
		return visible;
	}
	
	public void playBoomSound() {
 
        try {
            URL url = this.getClass().getClassLoader().getResource("shootsound.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }
}



