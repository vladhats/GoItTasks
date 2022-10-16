import java.util.Scanner;

public class Shit {

    public static void main (String args[]){

        Scanner scanner = new Scanner(System.in);
        int d = sum(scanner.nextInt(),scanner.nextInt());
        System.out.println(d);
    }
    static int sum(int a, int b){

        return a + b ;
    }
}

