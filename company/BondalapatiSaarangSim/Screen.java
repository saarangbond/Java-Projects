import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;
 
public class Screen extends JPanel {
 
	private double angle;
	private double angle2;
	private Color innerSun;
	private Color outerSun;
	private Color daySky;
	private Color nightSky;
	private Color star;
	private Color outerMoon;
	private Color innerMoon;
	private Color green;
	private int s1;
	private int s2;
	private int s3;
	private int s4;
	private int sunX;
	private int sunY;
	private int moonX;
	private int moonY;
	private Random rand;
	private Houses h1;
	private Buildings b1;
 
    public Screen(){
        //sets up the instance variables        
		angle = 0;
		angle2 = 0;
		rand = new Random();
		innerSun = new Color(242, 206, 24);
        outerSun = new Color(255, 213, 0);
		innerMoon = new Color(130, 141, 165);
		outerMoon = new Color(130, 141, 158);
		daySky = new Color(66, 135, 245);
        nightSky = new Color(20, 25, 130);
		green = new Color(30, 163, 23);
		star = new Color(239, 240, 225);
		h1 = new Houses(3, 5, 10, 260);
		b1 = new Buildings(1, 4, 10, 400);
		s1 = 50;
		s2 = 50;
		s3 = 50;
		s4 = 50;
    }
 
    public Dimension getPreferredSize() {
        //Sets the size of the panel
        return new Dimension(800,600);
    }
     
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
		
		//background
		if(angle < Math.PI){
            g.setColor(daySky);
            g.fillRect(0, 0, 800, 800);

        }else if(angle >= Math.PI){
            g.setColor(nightSky);
            g.fillRect(0, 0, 800, 800);

            //stars
            g.setColor(star);
            int starX = 50;
            while(starX < 800){
                g.fillOval(starX, rand.nextInt(174) + 25, 2, 2);
                starX += 50;
            }
			
			double xDouble2 = 425 * Math.cos(angle2);
			double yDouble2 = 180 * Math.sin(angle2);
			moonX = 300 + (int)xDouble2;
			moonY = 200 - (int)yDouble2;
        }
		
		g.setColor(green);
		g.fillRect(0, 250, 800, 350);
		
		h1.drawMe(g);
		b1.drawMe(g);
		
		
		//sun
		double xDouble = 425 * Math.cos(angle);
        double yDouble = 180 * Math.sin(angle);
        sunX = 300 + (int)xDouble;
        sunY = 200 - (int)yDouble;
		/*
		
		*/
		
		if(angle < Math.PI){
            g.setColor(outerSun);
            g.fillOval(sunX, sunY, s1 + 10, s2 + 10);
            g.setColor(innerSun);
            g.fillOval(sunX + 5, sunY + 5, s1, s2);
        }else if(angle >= Math.PI){
			
			g.setColor(outerMoon);
            g.fillOval(moonX, moonY, s1 + 10, s2 + 10);
            g.setColor(innerMoon);
            g.fillOval(moonX + 5, moonY + 5, s1, s2);
			
		}
     
    } 
	public void animate(){
        while(true){
            try{
                Thread.sleep(50);
            } catch (InterruptedException ex){
                Thread.currentThread().interrupt();
            }

            //sun and moon animation
        if(angle < 2*Math.PI){
			angle += 0.01;
		}else if(angle >= 2*Math.PI){
			angle += 0.2;
		}
		if(angle >= Math.PI && angle2 < Math.PI){
			angle2 += 0.01;
		}
            repaint();
        }
    }
 
}