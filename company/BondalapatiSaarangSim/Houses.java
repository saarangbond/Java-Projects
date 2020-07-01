import java.awt.Graphics;
import java.awt.Color;
 
public class Houses {
     
    private Color brown;
	private Color lightBrown;
     
    private int rows;
    private int cols;
    private int x;
    private int y;  
     
    public Houses(int rows, int cols, int x, int y){
        brown = new Color(222,184,135);
		lightBrown = new Color(230, 178, 110);
         
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
				g.setColor(brown);
				g.fillRect(tempX ,tempY,30,20);
				int[] xCoords = {tempX - 5, tempX+15, tempX+35};
				int[] yCoords = {tempY, tempY - 10, tempY};
				g.setColor(lightBrown);
				g.fillPolygon(xCoords, yCoords, 3);
                tempX  = tempX  + 40;
				
            }
            tempY =tempY+30; //go down a row
            tempX = x;
             
        }
         
    }
 
     
}