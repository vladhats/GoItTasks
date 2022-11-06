package HW8;

public class Pyramide extends Triangle{
    String name = "Pyramide";
    @Override
    public void name() {
        System.out.println(name);}
    @Override
    public void square() {
        System.out.println("Please, enter values for "+ name);
        System.out.println(side*side*height/3);
    }
}
