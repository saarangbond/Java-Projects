import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Card {
	private int value;
	private String name;
	private String suit;
	private BufferedImage suitImg;
	
	public Card(int value, String name, String suit){
		this.value = value;
		this.name = name;
		this.suit = suit;
		if(suit.equals("hearts")){
			try{
				suitImg = ImageIO.read(new File("images/hearts.png"));
			}catch(IOException e){
				System.out.println(e);
			}
		}else if(suit.equals("diamonds")){
			try{
				suitImg = ImageIO.read(new File("images/diamonds.png"));
			}catch(IOException e){
				System.out.println(e);
			}
		}else if(suit.equals("clubs")){
			try{
				suitImg = ImageIO.read(new File("images/clubs.png"));
			}catch(IOException e){
				System.out.println(e);
			}
		}else if(suit.equals("spades")){
			try{
				suitImg = ImageIO.read(new File("images/spades.png"));
			}catch(IOException e){
				System.out.println(e);
			}
		}
	}
	
	public String toString(){
		return value + " " + name + " " + suit;
	}
	
	public void drawMe(Graphics g, int x, int y){
		//draw card outline
		g.setColor(Color.WHITE);
		g.fillRect(x, y, 120, 150);
		g.setColor(Color.BLACK);
		g.drawRect(x, y ,120, 150);
		
		//drawName
		Font font1 = new Font("Arial", Font.PLAIN, 50);
		g.setFont(font1);
		
		if(suit.equals("heart") || suit.equals("diamonds")){
			g.setColor(Color.RED);
		}else if(suit.equals("clubs") || suit.equals("spades")){
			
		}
		g.drawString(name, x+35, y+100);
		g.drawImage(suitImg, x + 10, y + 10, 20, 30, null);
	}
	
	public int getValue(){
		return value;
	}
}
