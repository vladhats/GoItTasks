public class ShapeTest {
    public static void main(String[] args) {
        ShapeService rectangle = new Rectangle();
        ShapeService triangle = new Triangle();
        ShapeService circle = new Circle();
        ShapeService cube = new Cube();
        ShapeService sphere= new Sphere();
        ShapeService pyramide = new Pyramide();
        rectangle.name();
        rectangle.square();
        triangle.name();
        triangle.square();
        circle.name();
        circle.square();
        cube.name();
        cube.square();
        sphere.name();
        sphere.square();
        pyramide.name();
        pyramide.square();
    }

}
