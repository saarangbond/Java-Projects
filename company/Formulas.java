package com.company;
import java.util.Scanner;

public class Formulas{
    private double pi = Math.PI;
    private Scanner kb = new Scanner(System.in);
    private double gravity = 9.8;
    private double num1 = 4.0/3;
    private double num2 = 1.0/3;
    private double num3 = 1.0/2;

    public void areaSquare(){
        System.out.println("Area of a Square");
        System.out.println("Enter a side length:");
        double side = kb.nextDouble();
        double area = side * side;
        System.out.println("Area = " + area);
        System.out.println();
    }

    public void areaRect(){
        System.out.println("Area of a Rectangle");
        System.out.println("Enter a side length:");
        double side1 = kb.nextDouble();
        System.out.println("Enter another side length:");
        double side2 = kb.nextDouble();
        double area = side1 * side2;
        System.out.println("Area = " + area);
        System.out.println();
    }

    public void areaEqTri(){
        System.out.println("Area of an Equilateral Triangle");
        System.out.println("Enter a side length:");
        double side = kb.nextDouble();
        double area = Math.sqrt(3) / 4 * Math.pow(side, 2);
        System.out.println("Area = " + area);
        System.out.println();
    }

    public void areaCirc(){
        System.out.println("Area of a Circle");
        System.out.println("Enter a radius:");
        double radius = kb.nextDouble();
        double area = Math.pow(radius, 2) * pi;
        System.out.println("Area = " + area);
        System.out.println();
    }

    public void areaPara(){
        System.out.println("Area of a Parallelogram");
        System.out.println("Enter a value for the base:");
        double base = kb.nextDouble();
        System.out.println("Enter a value for the height:");
        double height = kb.nextDouble();
        double area = base * height;
        System.out.println("Area = " + area);
        System.out.println();
    }

    public void volSphere(){
        System.out.println("Volume of a Sphere");
        System.out.println("Enter a radius:");
        double radius = kb.nextDouble();
        double volume = num1 * pi * Math.pow(radius,3);
        System.out.println("Volume = " + volume);
        System.out.println();
    }

    public void volCyl(){
        System.out.println("Volume of a Cylinder");
        System.out.println("Enter a radius:");
        double radius = kb.nextDouble();
        System.out.println("Enter a height:");
        double height = kb.nextDouble();
        double volume = pi * Math.pow(radius, 2) * height;
        System.out.println("Volume = " + volume);
        System.out.println();
    }

    public void volSqPyra(){
        System.out.println("Volume of a Square Pyramid");
        System.out.println("Enter a side length of the base:");
        double side = kb.nextDouble();
        System.out.println("Enter a height:");
        double height = kb.nextDouble();
        double volume = num2 * side * side * height;
        System.out.println("Volume = " + volume);
        System.out.println();
    }

    public void volCube(){
        System.out.println("Volume of a Cube");
        System.out.println("Enter a side length:");
        double side = kb.nextDouble();
        double volume = Math.pow(side, 3);
        System.out.println("Volume = " + volume);
        System.out.println();
    }

    public void volRectPrism(){
        System.out.println("Volume of a Rectangular Prism:");
        System.out.println("Enter a width:");
        double width = kb.nextDouble();
        System.out.println("Enter a length:");
        double length = kb.nextDouble();
        System.out.println("Enter a height:");
        double height = kb.nextDouble();
        double volume = width * length * height;
        System.out.println("Volume = " + volume);
        System.out.println();
    }

    public void speedForm(){
        System.out.println("Speed Formula");
        System.out.println("Enter a distance in feet:");
        double distance = kb.nextDouble();
        System.out.println("Enter a time in seconds:");
        double time = kb.nextDouble();
        double speed = distance/time;
        System.out.println("Speed = " + speed + " feet per second.");
        System.out.println();
    }

    public void kineticEnergy(){
        System.out.println("Kinetic Energy Formula");
        System.out.println("Enter a mass in kilograms:");
        double mass = kb.nextDouble();
        System.out.println("Enter a velocity in meters/second:");
        double velocity = kb.nextDouble();
        double ke = num3 * mass * Math.pow(velocity, 2);
        System.out.println("Kinetic Energy = " + ke + " kilograms-meters per second.");
        System.out.println();
    }

    public void weightForm(){
        System.out.println("Weight Formula");
        System.out.println("Enter a mass in kg:");
        double mass =  kb.nextDouble();
        double weight = mass * gravity;
        System.out.println("Weight = " + weight + " newtons.");
        System.out.println();
    }

    public void workByGravity(){
        System.out.println("Work Done By Gravity Formula");
        System.out.println("Enter a mass in grams:");
        double mass = kb.nextDouble();
        System.out.println("Enter a height in cm:");
        double height = kb.nextDouble();
        double work = gravity * mass * height;
        System.out.println("Work = " + work + " joules.");
        System.out.println();
    }

    public void potentialEnergy(){
        System.out.println("Gravitational Potential Energy Formula");
        System.out.println("Enter a mass in kg:");
        double mass = kb.nextDouble();
        System.out.println("Enter a height in cm:");
        double height= kb.nextDouble();
        double pe = mass * gravity * height;
        System.out.println("Potential Energy = " + pe + " joules.");

    }
}