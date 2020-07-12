package com.creditsuisse.paint;

public class ShapeFactory {

    public static Shape getShape(ShapeType shapeType, int... attributes) {
        Shape shape;
        switch(shapeType) {
            case LINE:
                shape = new Line(attributes);
                break;
            case RECTANGLE:
                shape = new Rectangle(attributes);
                break;
            default:
                shape = null;
                break;
        }
        return shape;
    }
}
