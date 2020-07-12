package com.creditsuisse.paint;

public enum ShapeType {
    LINE("Line"),
    RECTANGLE("Rectangle");


    private String shapeType;

    ShapeType(String shapeType){
        this.shapeType = shapeType;
    }

    public String getShapeType(){
        return shapeType;
    }
}
