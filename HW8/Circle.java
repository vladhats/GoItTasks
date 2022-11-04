package HW8;

import java.util.Scanner;

public class Circle extends Shape {
    String name = "Circle";
    @Override
    public void name() {
        System.out.println(name);}
    Scanner scanner = new Scanner(System.in);
    int radius = scanner.nextInt();


    @Override
    public void square() {
        System.out.println("Please, enter values for "+ name);
        System.out.println(3.14*radius*radius);
    }


}
