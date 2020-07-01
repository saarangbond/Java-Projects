import javax.swing.JFrame;
public class Runner{
	public static void main(String args[]){
		Table game2 = new Table();
		JFrame frame = new JFrame("BlackJack");
		
		frame.add(game2);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
