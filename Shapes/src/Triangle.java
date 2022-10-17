package Shapes.src;

import java.util.Scanner;

public class Triangle extends Shape {
    String name = "Triangle";
    @Override
    public void name() {
        System.out.println(name);}

    Scanner scanner = new Scanner(System.in);
    int side = scanner.nextInt();
    int height = scanner.nextInt();

    @Override
    public void square() {
        System.out.println("Please, enter values for "+ name);
        System.out.println(side*height/2);
    }


}
