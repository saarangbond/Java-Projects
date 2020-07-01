import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
 
 
public class Screen extends JPanel implements ActionListener{
 
    private ArrayList<Contact> contacts;
	private Color black;
	private Color background;
	private JButton firstNameButton;
	private JButton lastNameButton;
	private JButton usernameButton;
	private JButton domainNameButton;
	private JButton domainExtensionButton;
	private JTextPane allContactsPane;
	private JTextPane searchPane;
	private JTextField searchField;
	private int contactCount();
	
    public Screen(){
         
		contacts = new ArrayList<Contact>;
		
		contactCount = 6;
		
		contacts.add("Jenny", "Tals", "jtals@gmail.com");
		contacts.add("Aubrey", "Graham", "abgra@yahoo.com");
		contacts.add("Memer", "Jones", "mnm@gmail.com");
		contacts.add("Senor", "Stonks", "srstonks@hotmail.com");
		contacts.add("La", "Flame", "travis@gmail.com");
		contacts.add("Mark", "Zuckerberg", "zzzucc@russia.net");
		 
		black = new Color(0, 0, 0);
		 
        setLayout(null);
		
		allContactsPane = new JTextPane();
		allContactsPane.setBounds(450, 50, 225, 500);
		add(allContactsPane);
		
		searchPane = new JTextPane();
		searchPane.setBounds(700, 50, 225, 500);
		add(searchPane);
		
		searchField = new JTextField();
		searchField.setBounds(125, 100, 200, 35);
		add(searchField);
		
		firstNameButton = new JButton("By First Name");
		firstNameButton.setBounds(75, 200, 150, 50);
		add(firstNameButton);
		firstNameButton.addActionListener(this);
		
		lastNameButton = new JButton("By Last Name");
		lastNameButton.setBounds(225, 200, 150, 50);
		add(lastNameButton);
		lastNameButton.addActionListener(this);
		
		usernameButton = new JButton("By Username");
		usernameButton.setBounds(75, 250, 150, 50);
		add(usernameButton);
		usernameButton.addActionListener(this);
		
		domainNameButton = new JButton("By Domain Name");
		domainNameButton.setBounds(225, 250, 150, 50);
		add(domainNameButton);
		domainNameButton.addActionListener(this);
		
		domainExtensionButton = new JButton("By Domain Extension");
		domainExtensionButton.setBounds(125, 300, 200, 50);
		add(domainExtensionButton);
		domainExtensionButton.addActionListener(this);
		
		String str = " ";
		for(int i = 0; i < contacts.length; i++){
			str += contacts.get(i).toString() + "\n\n";
		}
		allContactsPane.setText(str);
		
		setAllContactsPane();
		
        setFocusable(true);
         
    }
     
	public void setAllContactsPane(){
		String str = " ";
		for(int i = 0; i < contacts.length; i++){
			str += contacts.get(i).toString() + "\n\n";
		}
		allContactsPane.setText(str);
	}
	 
    public Dimension getPreferredSize(){
        //Sets the size of the panel
        return new Dimension(1000,600);
    }
  
    public void paintComponent(Graphics g){
        super.paintComponent(g);
		g.setColor(black);
		Font font1 = new Font("ARIAL", Font.BOLD, 20);
		g.setFont(font1);
		g.drawString("All Contacts", 500, 30);
		g.drawString("Search Results", 725, 30);
    }
 
    public void actionPerformed(ActionEvent e) {
		if(e.getSource() == firstNameButton){
			String search = searchField.getText();
			searchContacts(search, 1);
		}else if(e.getSource() == lastNameButton){
			String search = searchField.getText();
			searchContacts(search, 2);
		}else if(e.getSource() == usernameButton){
			String search = searchField.getText();
			searchContacts(search, 3);
		}else if(e.getSource() == domainNameButton){
			String search = searchField.getText();
			searchContacts(search, 4);
		}else if(e.getSource() == domainExtensionButton){
			String search = searchField.getText();
			searchContacts(search, 5);
		}else if(e.getSource == addPersonButton){
			String str = searchField.getText();
			//split into three strings and add to the ArrayList
		}else if(e.getSource == subtractPersonButton){
			String str = searchFIeld.getText();
			//make buttons
		}
 
    }
	public void searchContacts(String search, int num){
		searchPane.setText("");
		setAllContactsPane();
		String str = "";
		
		if(search.equals("")){
			searchPane.setText("");
		}else if(num == 1){
			String firstName = " ";
			for(int i = 0; i < contacts.length; i++){
				firstName = contacts.get(i).getFirstName();
				if(firstName.indexOf(search) != -1){
					str += contacts.get(i).toString() + "\n\n";
				}
			}
			searchPane.setText(str);
		}else if(num == 2){
			String lastName = " ";
			for(int i = 0; i < contacts.length; i++){
				lastName = contacts.get(i).getLastName();
				if(lastName.indexOf(search) != -1){
					str += contacts.get(i).toString() + "\n\n";
				}
			}
			searchPane.setText(str);
		}else if(num == 3){
			String username = " ";
			for(int i = 0; i < contacts.length; i++){
				username = contacts.get(i).getUsername();
				if(username.indexOf(search) != -1){
					str += contacts.get(i).toString() + "\n\n";
				}
			}
			searchPane.setText(str);
		}else if(num == 4){
			String domainName = " ";
			for(int i = 0; i < contacts.length; i++){
				domainName = contacts.get(i).getDomainName();
				if(domainName.indexOf(search) != -1){
					str += contacts.get(i).toString() + "\n\n";
				}
			}
			searchPane.setText(str);
		}else if(num == 5){
			String domainExtension = " ";
			for(int i = 0; i < contacts.length; i++){
				domainExtension = contacts.get(i)].getDomainExtension();
				if(domainExtension.indexOf(search) != -1){
					str += contacts.get(i).toString() + "\n\n";
				}
			}
			searchPane.setText(str);
		}
		searchField.setText("");
	}
	
}