package com.creditsuisse.paint;

import junit.framework.TestCase;
import org.junit.Test;

public class CanvasTest extends TestCase {
    private Canvas canvas;

    @Test
    public void testDrawCanvas(){
        canvas = new Canvas(20, 4);

        for(int x = 0; x < 22; x++) {
            assertEquals( canvas.getPixels()[x][0].getValue(), '-');
            assertEquals( canvas.getPixels()[x][5].getValue(), '-');
        }

        for(int y = 1; y < 5; y++) {
            assertEquals( canvas.getPixels()[0][y].getValue(), '|');
            assertEquals( canvas.getPixels()[21][y].getValue(), '|');
        }

        for (int x = 1; x <=20; x++) {
            for (int y = 1; y <=4; y++) {
                assertEquals( canvas.getPixels()[x][y].getValue(), ' ');
            }
        }

    }

    @Test
    public void testDrawLine() {
        canvas = new Canvas(20, 4);
        Line line = new Line(new Pixel(1, 2), new Pixel(6, 2));
        canvas.drawShape(line);

        for (int x = 1; x <= 20; x++) {
            for (int y = 1; y <= 4; y++) {
                if (y==2 && (x >=1 && x <= 6))
                    assertEquals('x', canvas.getPixels()[x][y].getValue());
                else
                    assertEquals(' ', canvas.getPixels()[x][y].getValue());
            }
        }
    }


    @Test
    public void testDrawRectangle() {
        canvas = new Canvas(20, 4);
        int[] attributes = {14, 1, 18, 3};
        Rectangle rectangle = new Rectangle(attributes);
        canvas.drawShape(rectangle);

        for (int x = 1; x <= 20; x++) {
            for (int y = 1; y <= 4; y++) {
                if ((y==1 || y==3) && (x >=14 && x <= 18))
                    assertEquals('x', canvas.getPixels()[x][y].getValue());
                else if ((x==14 || x==18) && (y >=1 && y <= 3))
                    assertEquals('x', canvas.getPixels()[x][y].getValue());
                else
                    assertEquals(' ', canvas.getPixels()[x][y].getValue());
            }
        }
    }

    @Test
    public void testBucketFill() {
        canvas = new Canvas(20, 4);
        canvas.bucketFill(new Pixel(10, 3), 'o');

        for (int x = 1; x <= 20; x++) {
            for (int y = 1; y <= 4; y++) {
                assertEquals('o', canvas.getPixels()[x][y].getValue());
            }
        }
    }
}