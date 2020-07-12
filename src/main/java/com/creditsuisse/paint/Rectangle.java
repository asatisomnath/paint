package com.creditsuisse.paint;

import java.util.ArrayList;
import java.util.List;

public class Rectangle implements Shape{
    private Pixel leftTop;
    private Pixel rightBottom;

    public Rectangle(int[] attributes) {
        this.leftTop = new Pixel(attributes[0], attributes[1]);
        this.rightBottom = new Pixel(attributes[2], attributes[3]);
    }

    @Override
    public List<Pixel> getPixels() {

        Pixel rightTop = new Pixel(rightBottom.getX(), leftTop.getY());
        Pixel leftBottom = new Pixel(leftTop.getX(), rightBottom.getY());

        Line topLine = new Line(leftTop, rightTop);
        Line bottomLine = new Line(leftBottom, rightBottom);
        Line leftLine = new Line(leftTop, leftBottom);
        Line rightLine = new Line(rightTop, rightBottom);

        List<Pixel> rectanglePixels = new ArrayList<>();

        rectanglePixels.addAll(topLine.getPixels());
        rectanglePixels.addAll(rightLine.getPixels());
        rectanglePixels.addAll(bottomLine.getPixels());
        rectanglePixels.addAll(leftLine.getPixels());

        return rectanglePixels;
    }



}
