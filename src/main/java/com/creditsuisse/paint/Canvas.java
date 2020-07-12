package com.creditsuisse.paint;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Canvas {

    private int width;
    private int height;
    private List<Pixel> pixels;

    public Canvas(){}

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.pixels = new ArrayList<>();

        for (int x = 0; x < width + 2; x++) {
            for (int y = 0; y < height + 2; y++) {
                pixels.add(new Pixel(x, y, ' '));
            }
        }

        for(int x = 0; x < width + 2; x++) {
            pixels.set(x, new Pixel(x,0,'-'));
            int offset = (width+2)* (height+1);
            pixels.set(offset+x, new Pixel(x,height+1,'-'))
        }

        for(int y = 1; y < height + 1; y++) {
            pixels[0][y] = new Pixel(0,y,'|');
            pixels[ width + 1][y] = new Pixel(width+1,y,'|');
        }


    }

    public Pixel[][] getPixels(){ return pixels; }

    public void drawShape(Shape shape) {
        List<Pixel> shapePixels = shape.getPixels();
        for(Pixel shapePixel: shapePixels){
            pixels[shapePixel.getX()][shapePixel.getY()].setValue(shapePixel.getValue());
        }
    }

    public void bucketFill(Pixel pixel, char color) {
        if (color == ' ') {
            return;
        }

        int x = pixel.getX();
        int y = pixel.getY();

        if (pixels[x][y].getValue() != ' ') {
            return;
        }

        pixels[x][y].setValue(color);

        //BFS
        Queue<Pixel> pixelQueue = new LinkedList<>();

        pixelQueue.add(pixel);

        while (pixelQueue.size() > 0) {
            Pixel frontPixel = pixelQueue.remove();
            x = frontPixel.getX();
            y = frontPixel.getY();

            if (pixels[x+1][y].getValue() == ' ') {
                pixels[x+1][y].setValue(color);
                pixelQueue.add(pixels[x+1][y]);
            }
            if (pixels[x][y+1].getValue() == ' ') {
                pixels[x][y+1].setValue(color);
                pixelQueue.add(pixels[x][y+1]);
            }
            if (pixels[x-1][y].getValue() == ' ') {
                pixels[x-1][y].setValue(color);
                pixelQueue.add(pixels[x-1][y]);
            }
            if (pixels[x][y-1].getValue() == ' ') {
                pixels[x][y-1].setValue(color);
                pixelQueue.add(pixels[x][y-1]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();
        for (int y = 0; y < height + 2; y++) {
            for (int x = 0; x < width + 2; x++) {
                print = print.append(pixels[x][y].getValue());
            }
            print.append(System.lineSeparator());
        }

        return print.toString();
    }

}
