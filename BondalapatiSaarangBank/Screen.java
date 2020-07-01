package com.company;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen extends JPanel implements ActionListener{

    private Bank c1;
    private Bank c2;
    private Bank c3;

    private Color black;
    private Color screen;
    private Color sky;

    private JTextField pinInput;
    private JTextField withdrawInput;
    private JTextField depositInput;
    private JTextField nameInput;

    private JButton loginButton;
    private JButton logoutButton;
    private JButton withdrawButton;
    private JButton depositButton;
    private JButton updateNameButton;

    public Screen(){
        setLayout(null);

        sky = new Color(93, 141, 217);
        screen = new Color(128, 166, 242);
        black = new Color(0, 0, 0);

        c1 = new Bank("John", 100.99, 1234);
        c2 = new Bank("Jen", 1000.01, 4321);
        c3 = new Bank("Jerry", 50.50, 1111);

        pinInput = new JTextField();
        pinInput.setBounds(130, 325, 100, 30);
        add(pinInput);

        withdrawInput = new JTextField();
        withdrawInput.setBounds(400, 200, 100, 30);
        add(withdrawInput);

        depositInput = new JTextField();
        depositInput.setBounds(400, 400, 100, 30);
        add(depositInput);

        nameInput = new JTextField();
        nameInput.setBounds(575, 300, 100, 30);
        add(nameInput);

        loginButton = new JButton("Login");
        loginButton.setBounds(130, 375, 100, 30);
        add(loginButton);
        loginButton.addActionListener(this);

        logoutButton = new JButton("Log Out");
        logoutButton.setBounds(130, 425, 100, 30);
        add(logoutButton);
        logoutButton.addActionListener(this);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(400, 250, 100, 30);
        add(withdrawButton);
        withdrawButton.addActionListener(this);

        depositButton = new JButton("Deposit");
        depositButton.setBounds(400, 450, 100, 30);
        add(depositButton);
        depositButton.addActionListener(this);

        updateNameButton = new JButton("Update Name");
        updateNameButton.setBounds(550, 350, 150, 30);
        add(updateNameButton);
        updateNameButton.addActionListener(this);

        setFocusable(true);
    }

    @Override
    public Dimension getPreferredSize(){
        return new Dimension(800,600);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        //use paintComponent only for drawing, and any calculations



        //atm picture
        g.setColor(sky);
        g.fillRect(0, 0, 800, 600);
        g.setColor(screen);
        g.fillRoundRect(80, 200, 180, 300, 10, 10);
        g.fillRoundRect(375, 50, 350, 500, 10, 10);

        g.setColor(black);
        Font font = new Font("Arial", Font.BOLD, 30);
        g.setFont(font);

        boolean check1 = c1.getAccess();
        boolean check2 = c2.getAccess();
        boolean check3 = c3.getAccess();
        if(check1 == true || check2 == true || check3 == true){
            g.drawString("Welcome!", 100, 280);
        }else{
            g.drawString("LOG IN", 100, 280);
        }



        Font font2 = new Font("Arial", Font.BOLD, 35);
        g.setFont(font);
        g.drawString("Aank of Bmerica ATM", 15, 100);
        Font font3 = new Font("Arial", Font.BOLD, 17);
        g.setFont(font3);
        g.drawString("What would power the like you do?", 25, 117);



        Font font4 = new Font("Arial", Font.BOLD, 12);
        g.setFont(font4);
        g.drawString("Cash out with Aank of Bmerica's", 90, 525);
        g.drawString("high fees and high interest!", 95, 537);
        g.drawLine(350, 0, 350, 800);

        String name1 = c1.getName();
        double balance1 = c1.getBalance();
        String name2 = c2.getName();
        double balance2 = c2.getBalance();
        String name3 = c3.getName();
        double balance3 = c3.getBalance();

        Font font5 = new Font("Arial", Font.BOLD, 15);
        g.setFont(font5);
        g.drawString("PIN", 100, 345);
        g.drawString("Withdraw: ", 400, 195);
        g.drawString("Deposit: ", 400, 395);
        g.drawString("Update Name:", 575, 295);

        Font font6 = new Font("Arial", Font.BOLD, 25);
        g.setFont(font6);

        if(c1.getAccess() == true){
            g.drawString(name1, 400, 100);
            g.drawString("Balance: $" + balance1, 400, 150);
        }else if(c2.getAccess() == true){
            g.drawString(name2, 400, 100);
            g.drawString("Balance: $" + balance2, 400, 150);
        }else if(c3.getAccess() == true){
            g.drawString(name3, 400, 100);
            g.drawString("Balance: $" + balance3, 400, 150);
        }
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == loginButton){
            System.out.println("Hello");

            String pinTxt = pinInput.getText();
            int pin = Integer.parseInt(pinTxt);

            c1.checkPin(pin);
            c2.checkPin(pin);
            c3.checkPin(pin);

            pinInput.setText("");
        }
        if(e.getSource() == logoutButton){
            pinInput.setText("");
            withdrawInput.setText("");
            depositInput.setText("");
            nameInput.setText("");

            c1.disableAccess();
            c2.disableAccess();
            c3.disableAccess();
        }
        if(e.getSource() == withdrawButton){
            boolean access1 = c1.getAccess();
            boolean access2 = c2.getAccess();
            boolean access3 = c3.getAccess();
            String withdrawTxt = withdrawInput.getText();
            double withdraw = Double.parseDouble(withdrawTxt);

            if(access1 == true){
                c1.withdraw(withdraw);
            }else if(access2 == true){
                c2.withdraw(withdraw);
            }else if(access3 == true){
                c3.withdraw(withdraw);
            }

            withdrawInput.setText("");
        }
        if(e.getSource() == depositButton){
            boolean access1 = c1.getAccess();
            boolean access2 = c2.getAccess();
            boolean access3 = c3.getAccess();
            String depositTxt = depositInput.getText();
            double deposit = Double.parseDouble(depositTxt);

            if(access1 == true){
                c1.deposit(deposit);
            }else if(access2 == true){
                c2.deposit(deposit);
            }else if(access3 == true){
                c3.deposit(deposit);
            }

            depositInput.setText("");
        }
        if(e.getSource() == updateNameButton){
            if(c1.getAccess() == true){
                c1.updateName(nameInput.getText());
            }else if(c2.getAccess() == true){
                c2.updateName(nameInput.getText());
            }else if(c3.getAccess() == true){
                c3.updateName(nameInput.getText());
            }
            nameInput.setText("");
        }

        repaint();
    }

}