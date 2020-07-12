package com.creditsuisse.paint;

public class Pixel {

    private int x;
    private int y;
    private char value;

    public Pixel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pixel(int x, int y, char value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public char getValue() {
        return value;
    }
    public void setValue(char value) {
        this.value = value;
    }


}
