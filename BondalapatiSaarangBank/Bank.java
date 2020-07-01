package com.company;

public class Bank{
    private String name;
    private double balance;
    private int pin;
    private boolean access;

    public Bank(String name, double balance, int pin){
        this.name = name;
        this.balance = balance;
        this.pin = pin;
        this.access = false;
    }

    public String getName(){
        if(access == true){
            return name;
        }else{
            return "";
        }
    }

    public double getBalance(){
        if(access == true){
            return balance;
        }else{
            return 0;
        }
    }

    public void disableAccess(){
        access = false;
    }

    public boolean getAccess(){
        return access;
    }

    public void checkPin(int pinCheck){
        if(pin == pinCheck){
            access = true;
        }else{
            access = false;
        }
    }

    public void withdraw(double withdrawal){
        if(withdrawal <= balance){
            balance -= withdrawal;
        }
    }

    public void deposit(double deposit){
        balance += deposit;
    }

    public String updateName(String nameUpdate){
        name = nameUpdate;
        return name;
    }
}