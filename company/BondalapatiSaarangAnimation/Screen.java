import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.Random;

import java.awt.event.*;
import java.awt.*;

public class Screen extends JPanel implements MouseListener{
	
	private Color sky;
	private Color green;
	private Color asphalt;
	private Color black;
	private Color yellow;
	private Color red;
	private Color blue;
	private Color barnWhite;
	private Color barnRed;
	private Color innerSun;
	private Color outerSun;
	private Color car1;
	private Color car2;
	private Color car3;
	private Random rand;
	
	private int mouseX;
	private int mouseY;
	
	private int num1;
	private int num2;
	private int num3;
	
	private boolean death;
	
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int x3;
	private int y3;
	private int s1;
	private int s2;
	
	public Screen(){
		
		sky = new Color(66, 135, 245);
		green = new Color(69, 209, 44);
		red = new Color(255, 0, 0);
		blue = new Color(0, 0, 255);
		asphalt = new Color(25, 23,33);
		black = new Color(0, 0, 0);
		yellow = new Color(229, 245, 7);
		barnWhite = new Color(224, 222, 222);
		barnRed = new Color(189, 51, 42);
		innerSun = new Color(242, 206, 24);
		outerSun = new Color(255, 213, 0);
		car1 = green;
		car2 = blue;
		car3 = red;
		death = false;
		rand = new Random();
		
		x1 = 100;
		y1 = 650;
		x2 = 700;
		y2 = 575;
		x3 = 500;
		y3 = 660;
		s1 = 100;
		s2 = 100;
		
	}
	
    public Dimension getPreferredSize(){
        return new Dimension(800,800);
    }
     
    public void paintComponent(Graphics g){
        super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		//sky
		g.setColor(sky);
		g.fillRect(0, 0, 800, 800);
		
		//green background grass
		g.setColor(green);
		g.fillRect(0, 300, 800, 500);
		
		//road
		g.setColor(asphalt);
		g.fillRect(0, 550, 800, 200);
		//middle bois of the road
		g.setColor(yellow);
		int i = 25;
		while(i< 800){
			g.fillRect(i, 630, 25, 10);
			i += 50;
		}
		
		//sun
		g.setColor(outerSun);
		g.fillOval(600, 50, s1 + 10, s2 + 10);
		g.setColor(innerSun);
		g.fillOval(605, 55, s1, s2);
		
		//farmhouse
		g.setColor(barnRed);
		g.fillRect(100, 225, 275, 200);
		g.fillRect(375, 260, 175, 165);
		
		g2.setColor(barnWhite);
		g2.setStroke(new BasicStroke(10));
		g2.drawLine(110, 235, 365, 415);
		g2.drawLine(365, 235, 110, 415);
		g2.drawLine(105, 230, 370, 230);
		g2.drawLine(105, 230, 105, 420);
		g2.drawLine(105, 420, 370, 420);
		g2.drawLine(370, 230, 370, 420);
		
		g2.drawLine(380, 255, 545, 255);
		g2.drawLine(545, 255, 545, 420);
		g2.drawLine(380, 420, 545, 420);
		
		
		//cars
		drawCarRight(car1, x1, y1, g);
		drawCarLeft(car2, x2, y2, g);
		drawCarRight(car3, x3, y3, g);
		
		if(death == true){
			g.setColor(black);
			Font font = new Font("Arial", Font.BOLD, 30);
			g.setFont(font);
			g.drawString("I AM YOUR LORD", 650, 150);
			while(true){
				try{
					Thread.sleep(5);
				} catch (InterruptedException ex){
					Thread.currentThread().interrupt();
				}
				s1++;
				s2++;
				
				repaint();
			}
		}
		
    }
	
	public static void drawCarRight(Color color, int x, int y, Graphics g){
		
		Color windows = new Color(160, 181, 222);
		Color grey = new Color(88, 95, 107);
		g.setColor(grey);
		g.fillOval(x+5, y+20, 25, 25);
		g.fillOval(x+70, y+20, 25, 25);
		
		g.setColor(color);
		g.fillRoundRect(x, y, 100, 35, 5, 5);
		g.fillRoundRect(x+20, y-18, 60, 20, 5, 5);
		
		g.setColor(windows);
		g.fillRoundRect(x + 55, y-16, 25, 18, 5, 5);
		
	}
	public static void drawCarLeft(Color color, int x, int y, Graphics g){
		
		Color windows = new Color(160, 181, 222);
		Color grey = new Color(88, 95, 107);
		g.setColor(grey);
		g.fillOval(x+5, y+20, 25, 25);
		g.fillOval(x+70, y+20, 25, 25);
		
		g.setColor(color);
		g.fillRoundRect(x, y, 100, 35, 5, 5);
		g.fillRoundRect(x+20, y-18, 60, 20, 5, 5);
		
		g.setColor(windows);
		g.fillRoundRect(x + 20, y-16, 25, 18, 5, 5);
		
	}
	
	
	public void animate(){
		while(true){
			try{
				Thread.sleep(50);
			} catch (InterruptedException ex){
				Thread.currentThread().interrupt();
			}
			
			//car animations
			num1 = rand.nextInt(4) + 1;
			num2 = rand.nextInt(4) + 1;
			num3 = rand.nextInt(4) + 1;
			
			
			//green car
			x1+=4;
			if(x1 > 900){
				x1 = -100;
				switch (num1){
					case 1 :
						car1 = green;
						break;
					case 2 :
						car1 = blue;
						break;
					case 3 :
						car1 = red;
						break;
					case 4 :
						car1 = yellow;
						break;
					case 5 :
						car1 = black;
						break;
				}
			}
			//blue car
			x2-=5;
			if(x2 < -100){
				x2 = 900;
				switch (num2){
					case 1 :
						car2 = blue;
						break;
					case 2 :
						car2 = green;
						break;
					case 3 :
						car2 = red;
						break;
					case 4 :
						car2 = yellow;
						break;
					case 5 :
						car2 = black;
						break;
				}
			}
			//red car
			x3+=3;
			if(x3 > 900){
				x3 = -100;
				switch (num3){
					case 1 :
						car3 = red;
						break;
					case 2 :
						car3 = blue;
						break;
					case 3 :
						car3 = green;
						break;
					case 4 :
						car3 = yellow;
						break;
					case 5 :
						car3 = black;
						break;
				}
			}
			
			
			//repaint
			repaint();
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e){
		mouseX = MouseInfo.getPointerInfo().getLocation().x;
		mouseY = MouseInfo.getPointerInfo().getLocation().y;
		double horizontalDist = Math.abs(mouseX - 650);
		double verticalDist = Math.abs(mouseY - 150);
		double distance = Math.sqrt(Math.pow(horizontalDist, 2) + Math.pow(verticalDist, 2));
		if(distance <= 55){
			death = true;
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent e){
		
	}
	
	@Override
	public void mouseExited(MouseEvent e){
		
	}
	
	@Override
	public void mousePressed(MouseEvent e){
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e){
		
	}
}