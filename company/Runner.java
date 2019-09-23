package com.company;

import java.util.Scanner;

public class Runner{
    public static void main(String[] args){
        String choose = "Blah";

        while( !choose.equals("0")){

            Formulas formula = new Formulas();
            Scanner s = new Scanner(System.in);

            System.out.println();
            System.out.println("Enter a number  to either choose a formula or Quit.");
            //0
            System.out.println("0: Quit");
            //1
            System.out.println("1: Area of a Square");
            //2
            System.out.println("2: Area of a Rectangle");
            //3
            System.out.println("3: Area of an Equilateral Triangle");
            //4
            System.out.println("4: Area of a Circle");
            //5
            System.out.println("5: Area of a Parallelogram");
            //6
            System.out.println("6: Volume of a Sphere");
            //7
            System.out.println("7: Volume of a Cylinder");
            //8
            System.out.println("8: Volume of a Square Pyramid");
            //9
            System.out.println("9: Volume of a Cube");
            //10
            System.out.println("10: Volume of a Rectangular Prism");
            //11
            System.out.println("11: Speed Formula");
            //12
            System.out.println("12: Kinetic Energy Formula");
            //13
            System.out.println("13: Weight Formula");
            //14
            System.out.println("14: Work Done By Gravity Formula");
            //15
            System.out.println("15: Gravitational Potential Energy Formula");

            System.out.println("Enter your number:");
            choose = s.next();

            switch(choose){
                case "1" :
                    formula.areaSquare();
                    break;
                case "2" :
                    formula.areaRect();
                    break;
                case "3" :
                    formula.areaEqTri();
                    break;
                case "4" :
                    formula.areaCirc();
                    break;
                case "5" :
                    formula.areaPara();
                    break;
                case "6" :
                    formula.volSphere();
                    break;
                case "7" :
                    formula.volCyl();
                    break;
                case "8" :
                    formula.volSqPyra();
                    break;
                case "9" :
                    formula.volCube();
                    break;
                case "10" :
                    formula.volRectPrism();
                    break;
                case "11" :
                    formula.speedForm();
                    break;
                case "12" :
                    formula.kineticEnergy();
                    break;
                case "13" :
                    formula.weightForm();
                    break;
                case "14" :
                    formula.workByGravity();
                    break;
                case "15" :
                    formula.potentialEnergy();
                    break;

                default:
                    System.out.println("That is not a valid choice.");
            }

        }
        System.out.println("You have quit.");
        System.out.println("Thanks for using this program!");
    }
}