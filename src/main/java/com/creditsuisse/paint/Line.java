package com.creditsuisse.paint;

import java.util.ArrayList;
import java.util.List;

public class Line implements Shape {

    private Pixel first;
    private Pixel last;

    public Line(int[] attributes){
        this.first = new Pixel(attributes[0], attributes[1]);
        this.last = new Pixel(attributes[2], attributes[3]);
    }

    public Line(Pixel first, Pixel last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public List<Pixel> getPixels() {
        if (first.getX() == last.getX()) {
            return horizontalLinePixels();
        } else if (first.getY() == last.getY()) {
            return verticalLinePixels();
        } else {
            System.out.println("Currently only horizontal or vertical lines are supported");
            return new ArrayList<>();
        }
    }


    private List<Pixel> horizontalLinePixels() {
        List<Pixel> linePixels = new ArrayList<>();

        for (int y = first.getY(); y <= last.getY(); y++) {
            Pixel pixel = new Pixel(first.getX(), y, 'x');
            linePixels.add(pixel);
        }

        return linePixels;
    }


    private List<Pixel> verticalLinePixels() {
        List<Pixel> linePixels = new ArrayList<>();

        for (int x = first.getX(); x <= last.getX(); x++) {
            Pixel pixel = new Pixel(x, first.getY(), 'x');
            linePixels.add(pixel);
        }

        return linePixels;
    }

}
