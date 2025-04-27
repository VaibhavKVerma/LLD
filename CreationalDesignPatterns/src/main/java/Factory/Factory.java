package Factory;

public class Factory {
    public static void main(String [] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape1 = shapeFactory.getShape("circle");
        shape1.draw();
        Shape shape3 = shapeFactory.getShape("rectangle");
        shape3.draw();
    }
}
