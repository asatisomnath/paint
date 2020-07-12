package com.creditsuisse.paint;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RectangleTest extends TestCase {

    private Rectangle rectangle;

    @Test
    public void testGetPixels() {

        int[] attributes = {14, 1 , 18, 3};

        rectangle = new Rectangle(attributes);

        List<Pixel> expectedPixels = new ArrayList<>();

        expectedPixels.add(new Pixel(14, 1));
        expectedPixels.add(new Pixel(15, 1));
        expectedPixels.add(new Pixel(16, 1));
        expectedPixels.add(new Pixel(17, 1));
        expectedPixels.add(new Pixel(18, 1));
        expectedPixels.add(new Pixel(18, 1));
        expectedPixels.add(new Pixel(18, 2));
        expectedPixels.add(new Pixel(18, 3));
        expectedPixels.add(new Pixel(14, 3));
        expectedPixels.add(new Pixel(15, 3));
        expectedPixels.add(new Pixel(16, 3));
        expectedPixels.add(new Pixel(17, 3));
        expectedPixels.add(new Pixel(18, 3));
        expectedPixels.add(new Pixel(14, 1));
        expectedPixels.add(new Pixel(14, 2));
        expectedPixels.add(new Pixel(14, 3));

        List<Pixel> pixels = rectangle.getPixels();

        for (int i = 0; i < expectedPixels.size(); i++) {
            assertEquals(expectedPixels.get(i).getX(), pixels.get(i).getX());
            assertEquals(expectedPixels.get(i).getY(), pixels.get(i).getY());
        }

    }
}