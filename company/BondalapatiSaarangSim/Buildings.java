import java.awt.Graphics;
import java.awt.Color;
 
public class Buildings{
     
    private Color dayWindows;
	private Color nightWindows;
	private Color colorBuilding;
	private Color colorDoor;
     
    private int rows;
    private int cols;
    private int x;
    private int y;  
     
    public Buildings(int rows, int cols, int x, int y){
        dayWindows = new Color(118, 184, 207);
		nightWindows = new Color(180, 191, 61);
		colorBuilding = new Color(96, 105, 120);
		colorDoor = new Color(87, 78, 72);
         
        this.rows = rows;
        this.cols = cols;
        this.x = x;
        this.y = y;
    }
     
    public void drawMe(Graphics g){
		
        int tempX = x;
        int tempY = y;
        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
				g.setColor(colorBuilding);
				g.fillRect(tempX, tempY, 90, 175);
				g.setColor(dayWindows);
				int windowY = tempY + 20;
				for(int i = 0; i < 4; i++){
					g.fillRect(tempX + 15, windowY, 25, 20);
					g.fillRect(tempX + 50, windowY, 25, 20);
					windowY += 30;
				}
				g.setColor(colorDoor);
				g.fillRoundRect(tempX + 35, tempY + 140, 20, 25, 5, 5);
				Color colorYellow = new Color(214, 201, 19);
				g.setColor(colorYellow);
				g.fillOval(tempX + 50, tempY + 150, 3, 3);
				tempX  = tempX  + 100;
				tempY = y;
			}
			
			tempY = tempY+200; //go down a row
			tempX = x;
			
        }
         
    }
 
     
}