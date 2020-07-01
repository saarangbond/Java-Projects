import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import java.net.URL;

public class Screen extends JPanel implements ActionListener, MouseListener{
	
	private Game game;
	private BufferedImage background;
	private JButton newGameButton;
	private JButton newCompGameButton;
	private boolean gameOn;
	private boolean pvp;
	private boolean playerTurn;
	private int winner;
	private int p1Score;
	private int p2Score;
	private boolean tie;
	
	public Screen(){
		setLayout(null);
		game = new Game();
		reset();
		gameOn = false;
		p1Score = 0;
		p2Score = 0;
		
		Font font1 = new Font("Arial", Font.BOLD, 20);
		
		newGameButton = new JButton("New PvP Game");
		newGameButton.setBounds(770, 350, 190, 150);
		add(newGameButton);
		newGameButton.addActionListener(this);
		newGameButton.setFont(font1);
		
		newCompGameButton = new JButton("New PvC Game");
		newCompGameButton.setBounds(770, 150, 190, 150);
		add(newCompGameButton);
		newCompGameButton.addActionListener(this);
		newCompGameButton.setFont(font1);
		
		try{
			background = ImageIO.read(new File("background.png"));
		}catch(IOException e){
			System.out.println(e);
		}
		
		
		
		addMouseListener(this);
	}
	
	public Dimension getPreferredSize() {
		//Sets the size of the panel
		return new Dimension(1000, 800);
	}

	public void paintComponent(Graphics g){	
		super.paintComponent(g);
		
		g.drawImage(background, 0, 0, 1000, 800, null);
		g.setColor(Color.BLACK);
		Font fontScores = new Font("Arial", Font.BOLD, 25);
		g.setFont(fontScores);
		g.drawString("Player 1 Score: " + p1Score, 50, 50);
		g.drawString("Player 2 Score: " + p2Score, 50, 100);
		Font font1 = new Font("Arial", Font.BOLD, 100);
		g.setFont(font1);
		game.drawMe(g);
		
		if(winner == 1){
			Font font2 = new Font("Arial", Font.BOLD, 50);
			g.setFont(font2);
			g.drawString("Player 1 Wins!", 650, 775);
		}else if(winner == 2){
			Font font2 = new Font("Arial", Font.BOLD, 50);
			g.setFont(font2);
			g.drawString("Player 2 Wins!", 650, 775);
		}else if(tie){
			g.drawString("Tie!", 700, 750);
		}
		
		if(gameOn){
			newGameButton.setVisible(false);
			newCompGameButton.setVisible(false);
		}else{
			newGameButton.setVisible(true);
			newCompGameButton.setVisible(true);
			return;
		}
		
	}
	
	private boolean checkDone(){
		boolean result = false;
		
		winner = game.checkTicTacToe();
		if(winner == 1){
			p1Score++;
			gameOn = false;
			playWinSound(1);
			result = true;
		}else if(winner == 2){
			p2Score++;
			gameOn = false;
			playWinSound(2);
			result = true;
		}else if(game.checkFull() == true){
			gameOn = false;
			playTieSound();
			tie = true;
			result = true;
		}
		return result;
	}
	
	private void reset(){
		game.reset();
		playerTurn = true;
		gameOn = true;
		winner = 0;
		tie = false;
		pvp = false;
	}
	
	public void actionPerformed(ActionEvent e){
		reset();
		if(e.getSource() == newGameButton){
			pvp = true;
		}else if(e.getSource() == newCompGameButton){
			pvp = false;
		}
		
		repaint();
	}
	public void mousePressed(MouseEvent e) {
		
		if(!gameOn){
			return;
		}
		
		int x = e.getX();
		int y = e.getY();
		
        //System.out.println("X: " + x + ", Y: " + x);
		
		if((!pvp && playerTurn) || pvp){
			boolean placed = false;
			if((x > 100 && x < 300) && (y > 100 && y < 300)){
				placed = game.insertXO(0, 0);
			}else if((x > 300 && x < 500) && (y > 100 && y < 300)){
				placed = game.insertXO(0, 1);
			}else if((x > 500 && x < 700) && (y > 100 && y < 300)){
				placed = game.insertXO(0, 2);
			}else if((x > 100 && x < 300) && (y > 300 && y < 500)){
				placed = game.insertXO(1, 0);
			}else if((x > 300 && x < 500) && (y > 300 && y < 500)){
				placed = game.insertXO(1, 1);
			}else if((x > 500 && x < 700) && (y > 300 && y < 500)){
				placed = game.insertXO(1, 2);
			}else if((x > 100 && x < 300) && (y > 500 && y < 700)){
				placed = game.insertXO(2, 0);
			}else if((x > 300 && x < 500) && (y > 500 && y < 700)){
				placed = game.insertXO(2, 1);
			}else if((x > 500 && x < 700) && (y > 500 && y < 700)){
				placed = game.insertXO(2, 2);
			}
			if(!placed){
				return;
			}
			
			if(x > 100 && x < 700 && y > 100 && y < 700){
				playPlaceSound();
				playerTurn = false;
			}
		}
		
		if(checkDone()){
			repaint();
			return;
		}
		if(!pvp && !playerTurn && gameOn){
			game.playCompMove();
			playPlaceSound();
			playerTurn = true;
		}
		checkDone();
        repaint();
    }
 
    public void mouseReleased(MouseEvent e) {}
 
    public void mouseEntered(MouseEvent e) {}
 
    public void mouseExited(MouseEvent e) {}
 
    public void mouseClicked(MouseEvent e) {}
	
	
	private void playWinSound(int player){
		try{
			URL url = this.getClass().getClassLoader().getResource("sounds/player1Win.wav");
			if(player == 2){
				url = this.getClass().getClassLoader().getResource("sounds/player2Win.wav");
			}
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        }catch(Exception exc){
            exc.printStackTrace(System.out);
        }
	}
	
	private void playPlaceSound(){
		try{
            URL url = this.getClass().getClassLoader().getResource("sounds/place.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        }catch(Exception exc){
            exc.printStackTrace(System.out);
        }
	}
	
	private void playTieSound(){
		try{
            URL url = this.getClass().getClassLoader().getResource("sounds/tie.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        }catch(Exception exc){
            exc.printStackTrace(System.out);
        }
	}
}