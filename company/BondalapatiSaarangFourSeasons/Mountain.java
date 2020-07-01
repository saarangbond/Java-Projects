import java.awt.Graphics;
import java.awt.Color;

public class Mountain{
	private int x;
	private int y;
	private Color brown;
	private Color snow;
	
	public Mountain(int x, int y){
		this.x = x;
		this.y = y;
		brown = new Color(130, 113, 66);
		snow = new Color(219, 216, 206);
	}
	
	public void drawMe(Graphics g, boolean winter){
		int[] xCoords = {x - 40, x, x+ 40};
		int[] yCoords = {y, y - 60, y};
		g.setColor(brown);
		g.fillPolygon(xCoords, yCoords, 3);
		
		if(winter){
			int[] snowXCoords = {x-12, x, x+12};
			int[] snowYCoords = {y-40, y-60, y-40};
			g.setColor(snow);
			g.fillPolygon(snowXCoords, snowYCoords, 3);
		}
	}
}