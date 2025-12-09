package Lab_day4.Shape;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle());
        shapes.add(new Circle());
        TestShape.testDraw(shapes);
        ArrayList<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle());
        TestShape.testDraw(rectangles);

    }
}
