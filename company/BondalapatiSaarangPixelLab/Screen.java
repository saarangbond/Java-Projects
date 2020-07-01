import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.*;

public class Screen extends JPanel implements MouseListener, MouseMotionListener, ActionListener{
	
	private Square[][] grid;
	private Square[][] colorGrid;
	private Color currentColor;
	private JButton clearButton;
	private JLabel colorLabel;
	private final int x = 50;
	private final int y = 50;
	private final int x2 = 550;
	private final int y2 = 410;
	private int red;
	private int green;
	private int blue;
	
	public Screen(){
		
		grid = new Square[20][20];
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				grid[i][j] = new Square();
			}
		}
		colorGrid = new Square[3][3];
		for(int i = 0; i < colorGrid.length; i++){
			for(int j = 0; j < colorGrid[i].length; j++){
				colorGrid[i][j] = new Square();
				colorGrid[i][j].setSize(50);
			}
		}
		colorGrid[0][0].setColor(Color.BLACK);
		colorGrid[0][1].setColor(Color.WHITE);
		colorGrid[0][2].setColor(Color.RED);
		colorGrid[1][0].setColor(Color.GREEN);
		colorGrid[1][1].setColor(Color.BLUE);
		colorGrid[1][2].setColor(Color.ORANGE);
		colorGrid[2][0].setColor(Color.PINK);
		colorGrid[2][1].setColor(Color.YELLOW);
		colorGrid[2][2].setColor(Color.CYAN);
		
		currentColor = Color.WHITE;
		
		setLayout(null);
		clearButton = new JButton("Clear");
		clearButton.setBounds(525, 250, 200, 100);
		add(clearButton);
		clearButton.addActionListener(this);
		
		colorLabel = new JLabel();
		colorLabel.setBounds(525, 100, 200, 100);
		add(colorLabel);
		colorLabel.setOpaque(true);
		
		addMouseListener(this);
		addMouseMotionListener(this);
		
	}
	
	
	public Dimension getPreferredSize(){
		return new Dimension(800,600);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		colorLabel.setBackground(currentColor);
		
		int x = this.x;
		int y = this.y;
		int size = grid[0][0].getSize();
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				grid[i][j].drawMe(g, x, y);
				x += size;
			}
			x = this.x;
			y += size;
		}
		
		int x2 = this.x2;
		int y2 = this.y2;
		int size2 = colorGrid[0][0].getSize();
		for(int i = 0; i < colorGrid.length; i++){
			for(int j = 0; j < colorGrid[i].length; j++){
				colorGrid[i][j].drawMe(g, x2, y2);
				x2 += size2;
			}
			x2 = this.x2;
			y2 += size2;
		}
		
		
		
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == clearButton){
			clearCanvas();
		}
		
		repaint();
	}
	
	public void clearCanvas(){
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				grid[i][j].setColor(Color.WHITE);
			}
		}
	}
	
	
	public void mousePressed(MouseEvent e){
		int row = 99;
		int col = 99;
		int x = e.getX();
		int y = e.getY();
		
		//col
		if(x > this.x && x < this.x + 20){
			col = 0;
		}else if(x > this.x + 20 && x < this.x + 40){
			col = 1;
		}else if(x > this.x + 40 && x < this.x + 60){
			col = 2;
		}else if(x > this.x + 60 && x < this.x + 80){
			col = 3;
		}else if(x > this.x + 80 && x < this.x + 100){
			col = 4;
		}else if(x > this.x + 100 && x < this.x + 120){
			col = 5;
		}else if(x > this.x + 120 && x < this.x + 140){
			col = 6;
		}else if(x > this.x + 140 && x < this.x + 160){
			col = 7;
		}else if(x > this.x + 160 && x < this.x + 180){
			col = 8;
		}else if(x > this.x + 180 && x < this.x + 200){
			col = 9;
		}else if(x > this.x + 200 && x < this.x + 220){
			col = 10;
		}else if(x > this.x + 220 && x < this.x + 240){
			col = 11;
		}else if(x > this.x + 240 && x < this.x + 260){
			col = 12;
		}else if(x > this.x + 260 && x < this.x + 280){
			col = 13;
		}else if(x > this.x + 280 && x < this.x + 300){
			col = 14;
		}else if(x > this.x + 300 && x < this.x + 320){
			col = 15;
		}else if(x > this.x + 320 && x < this.x + 340){
			col = 16;
		}else if(x > this.x + 340 && x < this.x + 360){
			col = 17;
		}else if(x > this.x + 360 && x < this.x + 380){
			col = 18;
		}else if(x > this.x + 380 && x < this.x + 400){
			col = 19;
		}
		
		//row
		if(y > this.y && y < this.y + 20){
			row = 0;
		}else if(y > this.y + 20 && y < this.y + 40){
			row = 1;
		}else if(y > this.y + 40 && y < this.y + 60){
			row = 2;
		}else if(y > this.y + 60 && y < this.y + 80){
			row = 3;
		}else if(y > this.y + 80 && y < this.y + 100){
			row = 4;
		}else if(y > this.y + 100 && y < this.y + 120){
			row = 5;
		}else if(y > this.y + 120 && y < this.y + 140){
			row = 6;
		}else if(y > this.y + 140 && y < this.y + 160){
			row = 7;
		}else if(y > this.y + 160 && y < this.y + 180){
			row = 8;
		}else if(y > this.y + 180 && y < this.y + 200){
			row = 9;
		}else if(y > this.y + 200 && y < this.y + 220){
			row = 10;
		}else if(y > this.y + 220 && y < this.y + 240){
			row = 11;
		}else if(y > this.y + 240 && y < this.y + 260){
			row = 12;
		}else if(y > this.y + 260 && y < this.y + 280){
			row = 13;
		}else if(y > this.y + 280 && y < this.y + 300){
			row = 14;
		}else if(y > this.y + 300 && y < this.y + 320){
			row = 15;
		}else if(y > this.y + 320 && y < this.y + 340){
			row = 16;
		}else if(y > this.y + 340 && y < this.y + 360){
			row = 17;
		}else if(y > this.y + 360 && y < this.y + 380){
			row = 18;
		}else if(y > this.y + 380 && y < this.y + 400){
			row = 19;
		}
		
		if(row >= 0 && row <= 19 && col >= 0 && col <= 19){
			grid[row][col].setColor(currentColor);
		}
		
		int row2 = 99;
		int col2 = 99;
		//color col
		if(x > this.x2 && x < this.x2 + 50){
			col2 = 0;
		}else if(x > this.x2 + 50 && x < this.x2 + 100){
			col2 = 1;
		}else if(x > this.x2 + 100 && x < this.x2 + 150){
			col2 = 2;
		}
		
		//color row
		if(y > this.y2 && y < this.y2 + 50){
			row2 = 0;
		}else if(y > this.y2 + 50 && y < this.y2 + 100){
			row2 = 1;
		}else if(y > this.y2 + 100 && y < this.y2 + 150){
			row2 = 2;
		}
		
		if(row2 >= 0 && row2 <= 2 && col2 >= 0 && col2 <= 2){
			currentColor = colorGrid[row2][col2].getColor();
		}
		
		repaint();
	}
	public void mouseDragged(MouseEvent e) {
		int row = 99;
		int col = 99;
		int x = e.getX();
		int y = e.getY();
		
		//col
		if(x > this.x && x < this.x + 20){
			col = 0;
		}else if(x > this.x + 20 && x < this.x + 40){
			col = 1;
		}else if(x > this.x + 40 && x < this.x + 60){
			col = 2;
		}else if(x > this.x + 60 && x < this.x + 80){
			col = 3;
		}else if(x > this.x + 80 && x < this.x + 100){
			col = 4;
		}else if(x > this.x + 100 && x < this.x + 120){
			col = 5;
		}else if(x > this.x + 120 && x < this.x + 140){
			col = 6;
		}else if(x > this.x + 140 && x < this.x + 160){
			col = 7;
		}else if(x > this.x + 160 && x < this.x + 180){
			col = 8;
		}else if(x > this.x + 180 && x < this.x + 200){
			col = 9;
		}else if(x > this.x + 200 && x < this.x + 220){
			col = 10;
		}else if(x > this.x + 220 && x < this.x + 240){
			col = 11;
		}else if(x > this.x + 240 && x < this.x + 260){
			col = 12;
		}else if(x > this.x + 260 && x < this.x + 280){
			col = 13;
		}else if(x > this.x + 280 && x < this.x + 300){
			col = 14;
		}else if(x > this.x + 300 && x < this.x + 320){
			col = 15;
		}else if(x > this.x + 320 && x < this.x + 340){
			col = 16;
		}else if(x > this.x + 340 && x < this.x + 360){
			col = 17;
		}else if(x > this.x + 360 && x < this.x + 380){
			col = 18;
		}else if(x > this.x + 380 && x < this.x + 400){
			col = 19;
		}
		
		//row
		if(y > this.y && y < this.y + 20){
			row = 0;
		}else if(y > this.y + 20 && y < this.y + 40){
			row = 1;
		}else if(y > this.y + 40 && y < this.y + 60){
			row = 2;
		}else if(y > this.y + 60 && y < this.y + 80){
			row = 3;
		}else if(y > this.y + 80 && y < this.y + 100){
			row = 4;
		}else if(y > this.y + 100 && y < this.y + 120){
			row = 5;
		}else if(y > this.y + 120 && y < this.y + 140){
			row = 6;
		}else if(y > this.y + 140 && y < this.y + 160){
			row = 7;
		}else if(y > this.y + 160 && y < this.y + 180){
			row = 8;
		}else if(y > this.y + 180 && y < this.y + 200){
			row = 9;
		}else if(y > this.y + 200 && y < this.y + 220){
			row = 10;
		}else if(y > this.y + 220 && y < this.y + 240){
			row = 11;
		}else if(y > this.y + 240 && y < this.y + 260){
			row = 12;
		}else if(y > this.y + 260 && y < this.y + 280){
			row = 13;
		}else if(y > this.y + 280 && y < this.y + 300){
			row = 14;
		}else if(y > this.y + 300 && y < this.y + 320){
			row = 15;
		}else if(y > this.y + 320 && y < this.y + 340){
			row = 16;
		}else if(y > this.y + 340 && y < this.y + 360){
			row = 17;
		}else if(y > this.y + 360 && y < this.y + 380){
			row = 18;
		}else if(y > this.y + 380 && y < this.y + 400){
			row = 19;
		}
		
		if(row >= 0 && row <= 19 && col >= 0 && col <= 19){
			grid[row][col].setColor(currentColor);
		}
		
		int row2 = 99;
		int col2 = 99;
		//color col
		if(x > this.x2 && x < this.x2 + 50){
			col2 = 0;
		}else if(x > this.x2 + 50 && x < this.x2 + 100){
			col2 = 1;
		}else if(x > this.x2 + 100 && x < this.x2 + 150){
			col2 = 2;
		}
		
		//color row
		if(y > this.y2 && y < this.y2 + 50){
			row2 = 0;
		}else if(y > this.y2 + 50 && y < this.y2 + 100){
			row2 = 1;
		}else if(y > this.y2 + 100 && y < this.y2 + 150){
			row2 = 2;
		}
		
		if(row2 >= 0 && row2 <= 2 && col2 >= 0 && col2 <= 2){
			currentColor = colorGrid[row2][col2].getColor();
		}
		
		repaint();
    }
	
	public void mouseMoved(MouseEvent e){}
	public void mouseReleased(MouseEvent e) {}
 
    public void mouseEntered(MouseEvent e) {}
 
    public void mouseExited(MouseEvent e) {}
 
    public void mouseClicked(MouseEvent e) {}
	
	
	
}
