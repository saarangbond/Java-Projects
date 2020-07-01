import java.awt.Graphics;
import java.awt.Color;

public class Square{
	private int red;
	private int green;
	private int blue;
	private Color color;
	private int size;
	
	public Square(){
		size = 20;
		red = 255;
		green = 255;
		blue = 255;
		color = new Color(red, green, blue);
	}
			
	public void drawMe(Graphics g, int x, int y){
		g.setColor(color);
		g.fillRect(x, y, size, size);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, size, size);
	}
	
	public void setColor(int red, int green,  int blue){
		this.red = red;
		this.green = green;
		this.blue = blue;
		color = new Color(red, green, blue);
	}
	public void setColor(Color c){
		color = c;
	}
	
	public Color getColor(){
		return color;
	}
	
	public void setSize(int size){
		this.size = size;
	}
	public int getSize(){
		return size;
	}
}