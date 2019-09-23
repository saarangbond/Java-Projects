package com.company;
import java.util.Scanner;

public class Fibonacci {
    public static void main( String[] args){
        Scanner s = new Scanner(System.in);
        int num1 = 1;
        int num2 = 2;
        int counter;

        System.out.println("Enter an integer that will be the upper limit of the Fibonacci numbers printed:");
        counter = s.nextInt();
        System.out.println();

        System.out.print(num1 + " ");
        System.out.print(num2 + " ");

        for(int num3 = 0;num3<=counter;){
            num3 = num1 + num2;

            if (num3 <= counter){
                System.out.print(num3 + " ");
            }

            num1 = num2;
            num2 = num3;

        }
        System.out.println();
    }
}
