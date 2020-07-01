import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Screen extends JPanel implements KeyListener, ActionListener{

	private Projectile p1;
	private Ship s1;
	private Boss b1;
	private Enemy[] enemies;
	private Random rand;
	private static int score;
	private int level;
	private int lives;
	private Color background0;
	private Color background1;
	private Color background2;
	private Color background3;
	private Color background4;
	private Color black;
	private JButton restartButton;
	private JButton startButton;
	private boolean started;
	
	public Screen(){
		setLayout(null);
		
		score = 0;
		level = 0;
		lives = 3;
		started = false;
		background0 = new Color(232, 28, 28);
		background1 = new Color(250, 247, 50);
		background2 = new Color(227, 140, 18);
		background3 = new Color(227, 32, 18);
		black = new Color(0, 0, 0);
		rand = new Random();
		s1 = new Ship(475, 700);
		p1 = new Projectile(50, 300);
		enemies = new Enemy[5];
		int enemyX = 50;
		for(int i = 0; i < enemies.length; i++){
			enemies[i] = new Enemy(enemyX, 75);
			enemyX += 100;
		}
		
		restartButton = new JButton("Restart");
		restartButton.setBounds(450, 475, 100, 50);
		add(restartButton);
		restartButton.addActionListener(this);
		restartButton.setVisible(false);
		
		startButton = new JButton("Start");
		startButton.setBounds(450, 400, 100, 50);
		add(startButton);
		startButton.addActionListener(this);
		startButton.setVisible(true);
		
		setFocusable(true);
		addKeyListener(this);
	}

	public Dimension getPreferredSize() {
		//Sets the size of the panel
        	return new Dimension(1000,800);
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
	
		
		if(level == 0){
			paintStart(g);
		}else if(level == 1){
			paintLevel1(g);
		}else if(level == 2){
			paintLevel2(g);
		}else if(level == 3){
			paintLevel3(g);
		}else if(level == 4){
			paintEnd(g);
		}
		g.setColor(black);
		g.drawString("Lives: " + lives, 900, 15);
		g.drawString("Score: " + score, 900, 50);
		g.drawString("Level: " + level, 900, 85);
	
		//Draw ship
		s1.drawMe(g);
		
		//Draw Projectile
		p1.drawMe(g);
		
		if(started){
			if(level == 1 || level == 2){
				for(int i = 0; i < enemies.length; i++){
					enemies[i].drawMe(g);
				}
			}else if(level == 3){
				b1.drawMe(g);
			}
			for(int i = 0; i < enemies.length; i++){
				p1.checkCollision(enemies[i]);
			}
			for(int i = 0; i < enemies.length; i++){
				s1.checkCollision(enemies[i]);
				if(s1.getCollision() == true){
					restartLevel();
				}
			}
			checkEnemyBottom();
		}
		
		

	} 
	
	public void paintStart(Graphics g){
		g.setColor(background0);
		g.fillRect(0, 0, 1000, 800);
	}
	public void paintLevel1(Graphics g){
		g.setColor(background1);
		g.fillRect(0, 0, 1000, 800);
	}
	
	public void paintLevel2(Graphics g){
		g.setColor(background2);
		g.fillRect(0, 0, 1000, 800);
	}
	public void paintLevel3(Graphics g){
		g.setColor(background3);
		g.fillRect(0, 0, 1000, 800);
	}
	public void paintEnd(Graphics g){
		g.setColor(black);
		g.fillRect(0, 0, 1000, 800);
	}

	public void animate(){
		
		while(true){
			//wait for .01 second
			try {
			    Thread.sleep(10);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			
			
			if(level == 0){
				startButton.setVisible(true);
			}else{
				startButton.setVisible(false);
			}
			
			if(level == 4){
				restartButton.setVisible(true);
			}else{
				restartButton.setVisible(false);
			}
			
			if(level == 1 || level == 2){
				p1.moveUp(enemies);
			}else if(level == 3){
				b1.move();
			}
			
			if(score == 5){
				level++;
				score = 0;
				for(int i = 0; i < enemies.length; i++){
					enemies[i].reset();
					if(level != 0 && level != 4)
						enemies[i].setVisibleTrue();
					else
						enemies[i].setVisibleFalse();
				}
			}
			if(level >= 1 && level <= 3){
				for(int i = 0; i < enemies.length; i++){
					enemies[i].move(level);
				}
			}
			
			//repaint the graphics drawn
			repaint();
			
		}

	}
	
	public void checkEnemyBottom(){
		if(level == 1 || level == 2 || level == 3){
			for(Enemy each : enemies){
				if(each.getY() > 770){
					lives--;
					if(lives <= 0){
						level = 4;
						each.reset();
						s1.setNotVisible();
					}
				}else{
					s1.setVisible();
			};
				}
		}
	}
	
	
	public void keyPressed(KeyEvent e){
		//System.out.println( e.getKeyCode() ); //use to detect what key is pressed
		
		if( e.getKeyCode() == 32 ){
			//set visible of the projectile to true
			p1.setPosition( s1.getX() , s1.getY() );
			p1.shoot();
			playShootSound();
			
		} else if(  e.getKeyCode() == 37 || e.getKeyCode() == 65){
			//call the method for the ship to move left
			s1.moveLeft();
			//p1.setPosition( s1.getX() , s1.getY() );
			
		} else if( e.getKeyCode() == 39  || e.getKeyCode() == 68){
			//call the method for the ship to move  right
			s1.moveRight();
			//p1.setPosition( s1.getX() , s1.getY() );
		}else if(e.getKeyCode() == 80){
			level++;
			if(level > 4){
				level = 0;
			}
		}else if(e.getKeyCode() == 82){
			restart();
		}
		
	}
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}
	
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == restartButton){
			restart();
		}else if(e.getSource() == startButton){
			started = true;
			level = 1;
		}
	}
	
	public boolean checkDead(){
		boolean allDead = true;
		for(int i = 0; i < enemies.length; i++){
			if(enemies[i].getVisible() == true){
				allDead = false;
			}
		}
		if(allDead = true){
			return true;
		}else{
			return false;
		}
	}
	
	public void restart(){
		level = 0;
		lives = 3;
		for(int i = 0; i < enemies.length; i++){
			enemies[i].reset();
		}
	}
	public void restartLevel(){
		for(int i = 0; i < enemies.length; i++){
			enemies[i].reset();
		}
	}
	
	public static void increaseScore(){
		score++;
	}
	
	public void playShootSound() {
 
        try {
            URL url = this.getClass().getClassLoader().getResource("shootsound.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }
}
