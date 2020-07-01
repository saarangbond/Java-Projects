package com.company;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;
import java.awt.Font;

import java.awt.*;

public class SlotMachine{
    private int num1;
    private int num2;
    private int num3;
    private int winnings;
    private int balance;
    public int bet;
    private int prevBet;
    private Random random;
    private Color black;
    private Color background;
    private Color darkBackground;
    private Color red;
    private boolean win;
    public boolean startDisplay;
    private boolean noMoney;

    public SlotMachine(){
        random = new Random();
        black = new Color(0, 0, 0);
        background = new Color(130, 171, 169);
        darkBackground = new Color(130, 171, 189);
        red = new Color(255, 64, 0);
        bet = 1;
        prevBet = bet;
        balance = 100;
        win = false;
        startDisplay = false;
        noMoney = false;
    }

    public void drawMe(Graphics g){

        //background
        g.setColor(background);
        g.fillRect(0, 0, 800, 800);
        g.setColor(darkBackground);
        g.fillRect(60, 140, 300, 100);

        g.setColor(black);
        Font font1 = new Font("Arial", Font.BOLD, 30);
        g.setFont(font1);
        g.drawString(num1 + " ", 100, 200);
        g.drawString(num2 + " ", 200, 200);
        g.drawString(num3 + " ", 300, 200);
        g.drawString("Balance: $" + balance, 400, 200);
        g.drawString("Bet: $" + bet, 400, 300);
        if(startDisplay){
            if(winnings > 0){
                g.setColor(black);
                g.drawString("You win $" + winnings + "!", 130, 100);
            }else if(winnings == 0){
                g.setColor(black);
                g.drawString("You don't win anything :(", 130, 100);
            }
        }
        if(balance == 0){
            g.setColor(black);
            g.drawString("You're out of luck (and money) !", 130, 475);
        }
        if(noMoney == true){
            g.setColor(red);
            g.drawString("You don't have enough money!", 325, 375);
        }
    }

    public void play(){
        if(balance >= bet && balance != 0){
            num1 = random.nextInt(8) + 1;
            num2 = random.nextInt(8) + 1;
            num3 = random.nextInt(8) + 1;
            if(num1 == 7 && num2 == 7 && num3 == 7){
                jackpot();
                win = true;
            }else if(num1 == num2 && num1 == num3){
                win3nums();
                win = true;
            }else if(num1 == num2 || num2 == num3 || num1 == num3){
                win2nums();
                win = true;
            }else{
                winnings = 0;
                prevBet = bet;
                if(bet == balance){
                    bet = 1;
                }
                win = false;
            }
            balance -= prevBet;
        }else if(balance <= bet){
            startDisplay = false;
            noMoney = true;
        }
    }

    public void jackpot(){
        winnings = 10*bet;
        prevBet = bet;
        if(bet == balance){
            bet = 1;
        }
        balance += winnings;
    }
    public void win3nums(){
        winnings = 5*bet;
        prevBet = bet;
        if(bet == balance){
            bet = 1;
        }
        balance += winnings;
    }
    public void win2nums(){
        winnings = 2*bet;
        prevBet = bet;
        if(bet == balance){
            bet = 1;
        }
        balance += winnings;
    }
    public int getBalance(){
        return balance;
    }
    public void reset(){
        balance = 100;
        bet = 1;
        winnings = 0;
        num1 = 0;
        num2 = 0;
        num3 = 0;
        startDisplay = false;
        noMoney = false;
    }
}