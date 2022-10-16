import java.util.Scanner;

public class Rectangle implements ShapeService {

   String name = "Rectangle";
   Scanner scanner = new Scanner(System.in);
    int first = scanner.nextInt();
    int second = scanner.nextInt();

    @Override
    public void name() {
        System.out.println(name);
    }

    @Override
    public void square() {
        System.out.println("Please, enter values for "+ name);
        System.out.println(first * second);
    }

}
