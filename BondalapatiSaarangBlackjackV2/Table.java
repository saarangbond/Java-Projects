import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import java.io.FileWriter;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.util.ArrayList;

public class Table extends JPanel implements ActionListener{
	private ArrayList<Card> deck;
	private ArrayList<Card> playerDeck;
	private ArrayList<Card> dealerDeck;
	private JButton hitButton;
	private JButton standButton;
	private JButton newGameButton;
	private int dealerScore;
	private int playerScore;
	private int dealerWins;
	private int playerWins;
	private int state;
	private boolean playerWin;
	private boolean dealerWin;
	private boolean tie;
	private BufferedImage background;
	private BufferedImage backCard;
	private boolean playerGoing;
	private boolean dealerHasGone;
	
	public Table(){
		setLayout(null);
		
		deck = new ArrayList<Card>();
		playerDeck = new ArrayList<Card>();
		dealerDeck = new ArrayList<Card>();
		
		shuffle();
		
		playerWins = 0;
		dealerWins = 0;
		state = 1;
		playerGoing = true;
		dealerHasGone = false;
		
		dealerScore = 0;
		if(dealerHasGone){
			for(int i = 0; i < dealerDeck.size(); i++){
				dealerScore += dealerDeck.get(i).getValue();
			}
		}else{
			dealerScore = dealerDeck.get(0).getValue();
		}
		
		newGameButton = new JButton("New Game");
		newGameButton.setBounds(600, 50, 150, 50);
		add(newGameButton);
		newGameButton.addActionListener(this);
		
		hitButton = new JButton("Hit");
		hitButton.setBounds(525, 100, 150, 50);
		add(hitButton);
		hitButton.addActionListener(this);
				
		standButton = new JButton("Stand");
		standButton.setBounds(675, 100, 150, 50);
		add(standButton);
		standButton.addActionListener(this);
		
		try{
			background = ImageIO.read(new File("images/blackjack.png"));
		}catch(IOException e){
			System.out.println(e);
		}
		try{
			backCard = ImageIO.read(new File("images/backCard.png"));
		}catch(IOException e){
			System.out.println(e);
		}
	}
	
	public Dimension getPreferredSize() {
		//Sets the size of the panel
		return new Dimension(1000, 800);
	}

	public void paintComponent(Graphics g){	
		super.paintComponent(g);
		Font font1 = new Font("Arial", Font.PLAIN, 50);
		g.setFont(font1);
		
		g.drawImage(background, 0, 0, 1000, 800, null);
		
		if(state == 1){
			//start of game and during rounds
			newGameButton.setVisible(false);
			hitButton.setVisible(true);
			standButton.setVisible(true);
		}else if(state == 2){
			//round ends
			newGameButton.setVisible(true);
			hitButton.setVisible(false);
			standButton.setVisible(false);
		}
		
		Font font = new Font("Arial", Font.PLAIN, 20);
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString("Dealer", 25, 235);
		g.drawString("Player", 25, 435);
		
		int x = 20;
		int y = 250;
		if(dealerHasGone){
			for(int i = 0; i < dealerDeck.size(); i++){
				dealerDeck.get(i).drawMe(g, x, y);
				x += 80;
			}
		}else{
			dealerDeck.get(0).drawMe(g, x, y);
			g.drawImage(backCard, x+80, y, 120, 150, null);
		}
		int x2 = 20;
		int y2 = 450;
		for(int i = 0; i < playerDeck.size(); i++){
			playerDeck.get(i).drawMe(g, x2, y2);
			x2 += 80;
		}
		
		g.setColor(Color.WHITE);
		Font font2 = new Font("Arial", Font.PLAIN, 25);
		g.setFont(font2);
		g.drawString("Dealer Score: " + dealerScore, 50, 25);
		g.drawString("Player Score: " + playerScore, 50, 75);
		g.drawString("Dealer\'s Wins: " + dealerWins, 50, 125);
		g.drawString("Player\'s Wins: " + playerWins, 50, 175);
		
		if(playerWin){
			g.drawString("Player Wins!", 275, 100);
		}else if(dealerWin){
			g.drawString("Dealer Wins :|", 275, 100);
		}else if(tie){
			g.drawString("A Tie!", 275, 100);
		}
	}
	
	public void actionPerformed(ActionEvent e){
		int button = 0;
		if(e.getSource() == hitButton){
			if(playerScore < 21){
				getCard(1);
			}
			button = 1;
		}else if(e.getSource() == standButton){
			
			button = 2;
			
		}else if(e.getSource() == newGameButton){
			restart();
		}
		
		playerScore = 0;
		for(int i = 0; i < playerDeck.size(); i++){
			playerScore += playerDeck.get(i).getValue();
		}
		
		
		if(button == 1){
			if(playerScore < 17){
				playHitSound();
			}else if(playerScore >= 17 && playerScore < 21){
				playStandSound();
			}
		}
		
		dealerScore = 0;
		if(dealerHasGone){
			for(int i = 0; i < dealerDeck.size(); i++){
				dealerScore += dealerDeck.get(i).getValue();
			}
		}else{
			dealerScore = dealerDeck.get(0).getValue();
		}
		
		if(playerScore == 21 || button == 2){
			getDealersCards();
		}
		
		checkScores();
		repaint();
	}
	
	private void restart(){
		state = 1;
		playerWin = false;
		dealerWin = false;
		tie = false;
		playerScore = 0;
		dealerScore = 0;
		dealerHasGone = false;
		shuffle();
	}
	
	private void getCard(int num){
		if(num == 1){
			playerDeck.add(deck.get(0));
			deck.remove(0);
		}else if(num == 2){
			dealerDeck.add(deck.get(0));
			deck.remove(0);
		}
		dealerScore = 0;
		for(int i = 0; i < dealerDeck.size(); i++){
			dealerScore += dealerDeck.get(i).getValue();
		}
	}
	private void getDealersCards(){
		while(dealerScore < 17 && dealerScore < 21){
			getCard(2);
		}
		dealerHasGone = true;
		state = 2;
	}
	
	private void initializeDeck(){
		deck.clear();
		String[] suits = new String[]{"hearts", "diamonds", "clubs", "spades"};
		int num, num2;
		
		for(int i = 0 ; i < 52; i++){
			num = i%13;
			num2 = num + 1;
			
			if(num == 0){
				deck.add(new Card(11, "A", suits[i/13]));
			}else if(num > 0 && num < 10){
				deck.add(new Card(num+1, num2 + "", suits[i/13]));
				
			}else if(num == 10){
				deck.add(new Card(10, "J", suits[i/13]));
				
			}else if(num == 11){
				deck.add(new Card(10, "Q", suits[i/13]));
	
			}else if(num == 12){
				deck.add(new Card(10, "K", suits[i/13]));
			}
		}
	}
	
	private void shuffle(){
		//write code to shuffle your deck
		initializeDeck();
		for(int i = 0; i < deck.size(); i++){
			int ind = (int)(Math.random() * deck.size());
			
			Card temp = deck.get(i);
			deck.set(i, deck.get(i));
			deck.set(ind, temp);
		}
		playerDeck.clear();
		dealerDeck.clear();
		
		playerDeck.add( deck.get(0) );
		playerDeck.add( deck.get(1) );
		deck.remove(0); 
		deck.remove(0);

		dealerDeck.add( deck.get(0) );
		dealerDeck.add( deck.get(1) );
		deck.remove(0); 
		deck.remove(0);
	}
	
	private void checkScores(){
		if(dealerScore > playerScore && dealerScore <= 21 && dealerScore >= 17){
			dealerWin = true;
			dealerWins++;
			state = 2;
			playLoseSound();
		}else if((playerScore > dealerScore && playerScore <= 21 && dealerScore >= 17) || (playerScore <= 21 && playerScore >= 17 && dealerScore > 21)){
			playerWin = true;
			playerWins++;
			state = 2;
			playWinSound();
		}else if(dealerScore == playerScore && playerScore <= 21 && dealerHasGone){
			tie = true;
			state = 2;
			playTieSound();
		}else if(playerScore > 21){
			dealerWin = true;
			dealerWins++;
			state = 2;
			playLoseSound();
		}
		
	}
	
	private void playStandSound(){
        try{
            URL url = this.getClass().getClassLoader().getResource("sounds/stand.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        }catch(Exception exc){
            exc.printStackTrace(System.out);
        }
    }
	
	private void playHitSound(){
        try{
            URL url = this.getClass().getClassLoader().getResource("sounds/hit.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        }catch(Exception exc){
            exc.printStackTrace(System.out);
        }
    }
	
	private void playWinSound(){
        try{
            URL url = this.getClass().getClassLoader().getResource("sounds/win.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        }catch(Exception exc){
            exc.printStackTrace(System.out);
        }
    }
	
	private void playLoseSound(){
        try{
            URL url = this.getClass().getClassLoader().getResource("sounds/lose.wav");
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