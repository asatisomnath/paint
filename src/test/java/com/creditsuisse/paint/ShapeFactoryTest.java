package com.creditsuisse.paint;

import junit.framework.TestCase;
import org.junit.Test;

public class ShapeFactoryTest extends TestCase {

    private ShapeFactory shapeFactory;

    @Test
    public void testGetLineShape() {
        shapeFactory = new ShapeFactory();
        Shape shape = shapeFactory.getShape(ShapeType.LINE, 6, 3, 6, 4);
        boolean isLine = shape instanceof Line;
        assertTrue(isLine);
    }

    @Test
    public void testGetRectangleShape() {
        shapeFactory = new ShapeFactory();
        Shape shape = shapeFactory.getShape(ShapeType.RECTANGLE, 14, 1, 18, 3);
        boolean isRect = shape instanceof Rectangle;
        assertTrue(isRect);
    }
}