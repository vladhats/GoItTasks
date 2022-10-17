package Shapes.src;


import java.awt.*;
import java.util.Scanner;

public class Rectangle extends Shape {

   String name = "Rectangle";
   Scanner scanner = new Scanner(System.in);
    int first = scanner.nextInt();
    int second = scanner.nextInt();


    public void name() {
        System.out.println(name);
    }


    public void square() {
        System.out.println("Please, enter values for "+ name);
        System.out.println(first * second);
    }

}
