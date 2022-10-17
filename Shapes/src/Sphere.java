package Shapes.src;

public class Sphere extends  Circle{
    String name = "Sphere";
    @Override
    public void name() {
        System.out.println(name);}
    @Override
    public void square() {
        System.out.println("Please, enter values for "+ name);
        System.out.println(3.14*radius*radius*4);
    }
}
