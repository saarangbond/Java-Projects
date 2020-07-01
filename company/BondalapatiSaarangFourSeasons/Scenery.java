import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
 
public class Scenery extends JPanel implements ActionListener{
 
	private RainDrop[] raindrops;
	private Snow[] snow;
	private Mountain[] mountains;
	private Tree[] trees;
	private Random rand;
	private Color black;
	private Color green;
	private Color white;
	private Color sky;
	private boolean spring;
	private boolean fall;
	private boolean summer;
	private boolean winter;
	private JButton springButton;
	private JButton summerButton;
	private JButton fallButton;
	private JButton winterButton;
	
	public Scenery(){
		raindrops = new RainDrop[100];
		mountains = new Mountain[15];
		snow = new Snow[100];
		trees = new Tree[20];
		rand = new Random();
		green = new Color(0, 200, 25);
		black = new Color(0, 0, 0);
		white = new Color(255, 255, 255);
		sky = new Color(50, 186, 179);
		
		setLayout(null);
		
		springButton = new JButton("Spring");
		springButton.setBounds(50, 750, 100, 25);
		add(springButton);
		springButton.addActionListener(this);
		
		summerButton = new JButton("Summer");
		summerButton.setBounds(250, 750, 100, 25);
		add(summerButton);
		summerButton.addActionListener(this);
		
		fallButton = new JButton("Fall");
		fallButton.setBounds(450, 750, 100, 25);
		add(fallButton);
		fallButton.addActionListener(this);
		
		winterButton = new JButton("Winter");
		winterButton.setBounds(650, 750, 100, 25);
		add(winterButton);
		winterButton.addActionListener(this);
		
		fall = true;
		spring = false;
		summer = false;
		winter = false;
		for(int i = 0; i < raindrops.length; i++){
			raindrops[i] = new RainDrop(rand.nextInt(800), rand.nextInt(800));
		}
		for(int i = 0; i < snow.length; i++){
			snow[i] = new Snow(rand.nextInt(800), rand.nextInt(800));
		}
		for(int i = 0; i < mountains.length; i++){
			mountains[i] = new Mountain(rand.nextInt(700) + 50, rand.nextInt(20) + 365);
		}
		for(int i = 0; i < trees.length; i++){
			trees[i] = new Tree(rand.nextInt(700) + 50, rand.nextInt(20) + 425);
		}
		
		setFocusable(true);
	}
     
    public Dimension getPreferredSize() {
        //Sets the size of the panel
        return new Dimension(800,800);
    }
 
    public void paintComponent(Graphics g){
        super.paintComponent(g);
		
		g.setColor(sky);
		g.fillRect(0, 0, 800, 800);
		g.setColor(green);
		g.fillRect(0, 350, 800, 450);
		
		for(int i = 0; i < mountains.length; i++){
			mountains[i].drawMe(g, winter);
		}
		for(int i = 0; i < trees.length; i++){
			trees[i].drawMe(g, summer, spring, fall, winter);
		}
		for(int i = 0; i < snow.length; i++){
			snow[i].drawMe(g, winter);
		} 
		for(int i = 0; i < raindrops.length; i++){
			raindrops[i].drawMe(g, spring);
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
			
			for(int i = 0; i < raindrops.length; i++){
				raindrops[i].moveDown();
			}
			for(int i = 0; i < snow.length; i++){
				snow[i].moveDown();
			}
			
            //repaint the graphics drawn
            repaint();
        }
 
    }
     
    public void actionPerformed(ActionEvent e){
		if(e.getSource() == springButton){
			spring = true;
			fall = false;
			summer = false;
			winter = false;
		}
		if(e.getSource() == summerButton){
			spring = false;
			fall = false;
			summer = true;
			winter = false;
		}
		if(e.getSource() == fallButton){
			spring = false;
			fall = true;
			summer = false;
			winter = false;
		}
		if(e.getSource() == winterButton){
			spring = false;
			fall = false;
			summer = false;
			winter = true;
		}
	}
     
}