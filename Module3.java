import java.util.Arrays;
import java.lang.Math;
import java.util.Scanner;

public class Module3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        double [] x = solve(a, b, c);
        System.out.println(Arrays.toString(x));
    }

    public int calculateDistance(int distance) {
        if (distance < 0) {
            return -distance;
        } else return distance;
    }

    ;

    public String[] getPlanets(String galaxy) {
        String[] Miaru = {"Maux", "Reux", "Piax" };
        String[] Milkyway = {"Earth", "Mars", "Jupiter" };
        String[] DangerBanger = {"Fobius", "Demius", " " };
        String[] unknown = {};
        if (galaxy.equals("Miaru")) {
            return Miaru;
        } else if (galaxy.equals("Milkyway")) {
            return Milkyway;
        } else if (galaxy.equals("DangerBanger")) {
            return DangerBanger;
        } else {
            return unknown;
        }

    }

    public String choosePlanet(long distanceToEarth) {
        if (distanceToEarth < 45677l) {
            return new String("Earth");
        } else return new String("Pern");
    }

    ;

    public int calculateFuelPrice(String fuel, int count) {
        if (fuel.equals("STAR100")) {
            return count * 70;
        } else if (fuel.equals("STAR500")) {
            return count * 120;
        } else if (fuel.equals("STAR1000")) {
            return count * 200;
        }
        ;
        return 0;
    }

    public static double[] solve(int a, int b, int c) {
        double discriminant = (b * b) - (4 * a * c);

        double root1 ;
        double root2;

        if (discriminant >0) {
            root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            double[] roots = {root1, root2};
            if(root1>root2) {
                double temp = root1;
                root1=root2; root2=temp;
                return roots;
            }
            else return roots;

        } else if (discriminant==0){
            root1 = root2 = -b / (2 * a);
            double[] out = {root1};
            return out;
        } else return new double[0];
     }
    }






























    /*public static String aggregateSingle(String name, String age, String planet) {

        String res = "name - " + name + ", age - " + age + ", planet - " + planet;
        return res;
    }

    ;

    public String[] aggregateAll(String[] names, int[] ages, String[] planets) {
        String[] agg = new String[3];
        agg[0] = aggregateSingle(names[0], String.valueOf(ages[0]), planets[0]);
        agg[1] = aggregateSingle(names[1], String.valueOf(ages[1]), planets[1]);
        agg[2] = aggregateSingle(names[2], String.valueOf(ages[2]), planets[2]);
        return agg;
    }

    ;


    }

     */

