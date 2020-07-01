import java.awt.Graphics;
import java.awt.Color;

public class Tree{
	private int x;
	private int y;
	private Color brown;
	private Color fallLeaves;
	private Color otherLeaves;
	
	public Tree(int x, int y){
		this.x = x;
		this.y = y;
		brown = new Color(64, 44, 11);
		fallLeaves = new Color(255, 102, 0);
		otherLeaves = new Color(44, 115, 23);
	}
	
	public void drawMe(Graphics g, boolean summer, boolean spring, boolean fall, boolean winter){
		g.setColor(brown);
		g.fillRect(x, y, 30, 50);
		
		if(winter){
			int x2 = x-10; 
			int y2 = y - 5;
			for(int i = x; i < x + 30; i++){
				g.drawLine(i, y, x2, y2);
				x2 += 2;
				if(i < x + 10)
					y2 -= 3;
				else if(i > x + 20)
					y2 += 3;
				else
					y2++;
			}
		}else{
			if(spring || summer){
				g.setColor(otherLeaves);
			}else if(fall){
				g.setColor(fallLeaves);
			}
			g.fillOval(x - 10, y - 20, 50, 40);
		}
	}
}