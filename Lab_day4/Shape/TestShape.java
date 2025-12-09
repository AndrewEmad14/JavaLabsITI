package Lab_day4.Shape;

import java.util.ArrayList;

public class TestShape {
    static public <T extends Shape> void testDraw(ArrayList<T> shapes) {
        for (T shape : shapes) {
            shape.draw();
        }
    }
}
