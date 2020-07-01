import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.Random;


public class Screen extends JPanel implements KeyListener{

	private Projectile p1;
	private Ship s1;
	private Enemy[] enemies;
	private Random rand;
	
	public Screen(){
		
		rand = new Random();
		s1 = new Ship(50,300);
		p1 = new Projectile(50,300);
		enemies = new Enemy[10];
		for(int i = 0; i < enemies.length; i++){
			int enemyY = rand.nextInt(550) + 100;
			enemies[i] = new Enemy(700, enemyY);
		}

        setFocusable(true);
		addKeyListener(this);
	}

	public Dimension getPreferredSize() {
		//Sets the size of the panel
        	return new Dimension(800,600);
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
	
	

		g.setColor(Color.white);
		g.fillRect(0, 0, 800, 600);
		
	
		//Draw ship
		s1.drawMe(g);
		
		//Draw Projectile
		p1.drawMe(g);
		
		for(int i = 0; i < enemies.length; i++){
			enemies[i].drawMe(g);
		}
		
		for(int i = 0; i < enemies.length; i++){
			p1.checkCollision(enemies[i]);
		}

	} 


	public void animate(){
		
		while(true){
			//wait for .01 second
			try {
			    Thread.sleep(10);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			
			p1.moveRight();
			
			//repaint the graphics drawn
			repaint();
			
		}

	}
	
	
	public void keyPressed(KeyEvent e){
		//System.out.println( e.getKeyCode() ); //use to detect what key is pressed
		
		if( e.getKeyCode() == 32 ){
			//set visible of the projectile to true
			p1.setPosition( s1.getX() , s1.getY() );
			p1.shoot();
			
			
		} else if(  e.getKeyCode() == 38 || e.getKeyCode() == 87){
			//call the method for the ship to move up
			s1.moveUp();
			//p1.setPosition( s1.getX() , s1.getY() );
			
		} else if( e.getKeyCode() == 40  || e.getKeyCode() == 83){
			//call the method for the ship to move down
			s1.moveDown();
			//p1.setPosition( s1.getX() , s1.getY() );
		}
		
	}
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}
	

}


