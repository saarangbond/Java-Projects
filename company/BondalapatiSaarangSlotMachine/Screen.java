package com.company;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen extends JPanel implements ActionListener{

    private SlotMachine slot;
    private JButton spinButton;
    private JButton bet1Button;
    private JButton bet5Button;
    private JButton bet10Button;
    private JButton restartButton;
    private JButton betAllButton;

    public Screen(){
        slot = new SlotMachine();
        setLayout(null);

        bet1Button = new JButton("Bet $1");
        bet1Button.setBounds(90, 250, 80, 30);
        bet1Button.addActionListener(this);
        add(bet1Button);

        bet5Button = new JButton("Bet $5");
        bet5Button.setBounds(170, 250, 80, 30);
        bet5Button.addActionListener(this);
        add(bet5Button);

        bet10Button = new JButton("Bet $10");
        bet10Button.setBounds(250, 250, 80, 30);
        bet10Button.addActionListener(this);
        add(bet10Button);

        betAllButton = new JButton("BET EVERYTHING!");
        betAllButton.setBounds(135, 285, 160, 30);
        betAllButton.addActionListener(this);
        add(betAllButton);

        spinButton = new JButton("SPIN!");
        spinButton.setBounds(160, 350 ,100, 50);
        spinButton.addActionListener(this);
        add(spinButton);

        restartButton = new JButton("Restart");
        restartButton.setBounds(300, 525, 100, 50);
        restartButton.addActionListener(this);
        add(restartButton);
        restartButton.setVisible(false);
        setFocusable(true);
    }

    public Dimension getPreferredSize(){
        return new Dimension(800,600);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(slot.getBalance() == 0){
            restartButton.setVisible(true);
        }
        slot.drawMe(g);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == spinButton){
            slot.play();
            slot.startDisplay = true;
        }
        if(e.getSource() == bet1Button){
            slot.bet = 1;
        }
        if(e.getSource() == bet5Button){
            slot.bet = 5;
        }
        if(e.getSource() == bet10Button){
            slot.bet = 10;
        }
        if(e.getSource() == betAllButton){
            slot.bet = slot.getBalance();
        }
        if(e.getSource() == restartButton){
            slot.reset();
            restartButton.setVisible(false);
        }
        repaint();
    }
}