package com.company;

public class VariableTest{
    public static void main(String[] args){
        System.out.println("Part 1");
        System.out.println();

        byte one = 5;
        System.out.println("one is a byte and has the value of " + one + ".");

        short two = 0;
        System.out.println("two is a byte and has the value of " + two + ".");

        long three = 42;
        System.out.println("three is a byte and has the value of " + three + ".");

        int four = 30;
        System.out.println("four is a byte and has the value of " + four + ".");

        double five = 16.8;
        System.out.println("five is a byte and has the value of " + five + ".");

        float six = 83.5f;
        System.out.println("six is a byte and has the value of " + six + ".");

        char seven = 65;
        System.out.println("seven is a byte and has the value of " + seven + ".");

        boolean eight = true;
        System.out.println("eight is a byte and has the value of " + eight + ".");

        System.out.println();

        System.out.println("Part 2");
        System.out.println();

        char num1 = 34;
        char num2 = 72;
        char num3 = 101;
        char num4 = 108;
        char num5 = 108;
        char num6 = 111;
        char spaceChar = 32;
        char num7 = 87;
        char num8 = 111;
        char num9 = 114;
        char num10 = 108;
        char num11 = 100;
        char num12 = 33;

        System.out.print(num1);
        System.out.print(num2);
        System.out.print(num3);
        System.out.print(num4);
        System.out.print(num5);
        System.out.print(num6);
        System.out.print(spaceChar);
        System.out.print(num7);
        System.out.print(num8);
        System.out.print(num9);
        System.out.print(num10);
        System.out.print(num11);
        System.out.print(num12);
        System.out.print(num1);
        System.out.println();

        System.out.println("Part 3");
        System.out.println();
        int length = 5;
        int width = 3;
        int area = length * width;
        System.out.println("Area of Rectangle");
        System.out.println("area = length * width");
        System.out.println("length = " + length + ", width = " + width);
        System.out.println("area = " + area);

        System.out.println();

        length = 3;
        area = length * length;
        System.out.println("Area of Square");
        System.out.println("Area = length squared");
        System.out.println("length = " + length);
        System.out.println("area = " + area);

        System.out.println();

        int base = 6;
        int height = 2;
        int area2 = base/2 * height;
        System.out.println("Area of triangele");
        System.out.println("Area = 1/2 * base * height");
        System.out.println("base = " + base + " height = " + height);
        System.out.println("area = " + area2);

        System.out.println();

        int side = 7;
        int volume = side * side * side;
        System.out.println("Volume of cube");
        System.out.println("Volume = side * side * side");
        System.out.println("side = " + side);
        System.out.println("volume = " + volume);

        System.out.println();

        side = 5;
        int perimeter = side + side + side;
        System.out.println("Perimeter of a triangle");
        System.out.println("Perimeter = side + side + side");
        System.out.println("side = " + side);
        System.out.println("perimeter " + perimeter);

        System.out.println();

        System.out.println("Part 4");
        System.out.println();

        double a = 5;
        double b = 18;
        double c = Math.sqrt(a*a + b*b);
        System.out.println("Pythagorean Theorem");
        System.out.println("a^2 + b^2 = c^2");
        System.out.println("a = " + a + " b = " + b);
        System.out.println("c = " + c);

        System.out.println();

        System.out.println("Distance Formula");
        double x1 = 3;
        double y1 = 8;
        double x2 = 7;
        double y2 = -1;
        double distance = Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
        System.out.println("Distance = square root of [(x2-x1)^2 + (y2-y1)^2]");
        System.out.println(x1 + " ");


    }
}