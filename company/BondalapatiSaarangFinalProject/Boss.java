import java.awt.Color;
import java.awt.Graphics;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Boss{
	private int x;
	private int y;
	private int n;
	private int width;
	private int height;
	private int health;
	private boolean visible;
	private Color boss;
	
	public Boss(){
		n = 1;
		x = 450;
		y = 25;
		width = 200;
		height = 100;
		health = 10;
		visible = false;
		boss = new Color(133, 105, 176);
	}
	
	public void move(){
		if(visible){
			x += n;
			if(x == 900 || x == 0){
				n *= -1;
				y += 100;
			}
			
		}
	}
	
	public void drawMe(Graphics g){
		g.setColor(boss);
		g.fillRect(x, y, width, height);
	}
	
	public void resetPosition(){
		y = 25;
	}
	
	public void decreaseHealth(){
		health --;
	}
	
	public boolean getVisible(){
		return visible;
	}
	public void setVisible(boolean bool){
		this.visible = bool;
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