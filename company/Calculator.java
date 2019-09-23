package com.company;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);

        System.out.println("Welcome to the Calculator!");
        System.out.println("Follow the instruction s on screen.");
        System.out.println();

        System.out.println("Enter your first number:");
        double num1 = kb.nextDouble();

        System.out.println("");

        System.out.println("Enter the operation(+, -, *, /, or ^) : ");
        String operation = kb.next();

        System.out.println("");

        System.out.println("Enter the second number:");
        double num2 = kb.nextDouble();

        System.out.println("");

        switch (operation){

            case "+" :
                double ans1 = num1 + num2;
                System.out.println(num1);
                System.out.println("+");
                System.out.println(num2);
                System.out.println("=");
                System.out.println(ans1);
                break;

            case "-" :
                double ans2 = num1 - num2;
                System.out.println(num1);
                System.out.println("-");
                System.out.println(num2);
                System.out.println("=");
                System.out.println(ans2);
                break;

            case "*" :
                double ans3 = num1 * num2;
                System.out.println(num1);
                System.out.println("*");
                System.out.println(num2);
                System.out.println("=");
                System.out.println(ans3);
                break;

            case "/" :
                double ans4 = num1 / num2;
                System.out.println(num1);
                System.out.println("/");
                System.out.println(num2);
                System.out.println("=");
                System.out.println(ans4);
                break;

            case "^" :
                double ans5 = Math.pow(num1, num2);
                System.out.println(num1);
                System.out.println("^");
                System.out.println(num2);
                System.out.println("=");
                System.out.println(ans5);
                break;

            default :
                System.out.println("That wasn't valid!");
                break;
        }


    }


}
