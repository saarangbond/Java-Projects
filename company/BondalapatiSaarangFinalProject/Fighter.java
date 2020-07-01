import java.awt.Color;
import java.awt.Graphics;

public class Fighter{
	private int x;
	private int y;
	private Color fighterColor;
	private boolean visible;
	
	public Fighter(){
		fighterColor = new Color(25, 114, 209);
		visible = true;
	}
	
	public void drawMe(Graphics g){
		if(visible){
			//draw fighter here
			g.setColor(fighterColor);
		}
	}
	
	public void die(){
		if(!visible)
			visible = false;
	}
}