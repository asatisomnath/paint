package com.creditsuisse.paint;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LineTest extends TestCase {
    private Line line;

    @Test
    public void testHorizontalLinePixels() {
        line = new Line(new Pixel(1, 2), new Pixel(6, 2));

        List<Pixel> expectedPixels = new ArrayList<>();
        expectedPixels.add(new Pixel(1,2));
        expectedPixels.add(new Pixel(2,2));
        expectedPixels.add(new Pixel(3,2));
        expectedPixels.add(new Pixel(4,2));
        expectedPixels.add(new Pixel(5,2));
        expectedPixels.add(new Pixel(6,2));

        List<Pixel> pixels = line.getPixels();

        for (int i = 0; i < expectedPixels.size(); i++) {
            assertEquals(expectedPixels.get(i).getX(), pixels.get(i).getX());
            assertEquals(expectedPixels.get(i).getY(), pixels.get(i).getY());
        }
    }

    @Test
    public void testVerticalLinePixels() {
        line = new Line(new Pixel(6, 3), new Pixel(6, 4));

        List<Pixel> expectedPixels = new ArrayList<>();
        expectedPixels.add(new Pixel(6,3));
        expectedPixels.add(new Pixel(6,4));

        List<Pixel> pixels = line.getPixels();

        for (int i = 0; i < expectedPixels.size(); i++) {
            assertEquals(expectedPixels.get(i).getX(), pixels.get(i).getX());
            assertEquals(expectedPixels.get(i).getY(), pixels.get(i).getY());
        }
    }

}