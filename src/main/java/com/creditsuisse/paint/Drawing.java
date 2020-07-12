package com.creditsuisse.paint;

import java.util.Scanner;


public class Drawing {

    private static Canvas canvas = new Canvas();

    public static void main(String[] args){
        System.out.print("enter command: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while(!input.equals("Q")) {
            drawCanvas(input);
            System.out.print("enter command: ");
            input = scanner.nextLine();
        }

        scanner.close();
    }

    public static void drawCanvas(String input) {
        String[] instructionValues = input.split(" ");
        Shape shape;
        switch(instructionValues[0]) {
            case "C":
                canvas = new Canvas(Integer.parseInt(instructionValues[1]), Integer.parseInt(instructionValues[2]));
                break;
            case "L":
                shape = ShapeFactory.getShape(ShapeType.LINE, Integer.parseInt(instructionValues[1]), Integer.parseInt(instructionValues[2]),
                        Integer.parseInt(instructionValues[3]), Integer.parseInt(instructionValues[4]));
                canvas.drawShape(shape);
                break;
            case "R":
                shape = ShapeFactory.getShape(ShapeType.RECTANGLE, Integer.parseInt(instructionValues[1]), Integer.parseInt(instructionValues[2]),
                        Integer.parseInt(instructionValues[3]), Integer.parseInt(instructionValues[4]));
                canvas.drawShape(shape);
                break;
            case "B":
                Pixel pixel = new Pixel(Integer.parseInt(instructionValues[1]), Integer.parseInt(instructionValues[2]));
                canvas.bucketFill(pixel, instructionValues[3].charAt(0));
                break;
            default:
                break;
        }

        System.out.println(canvas.toString());
    }

}
