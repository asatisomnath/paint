package com.creditsuisse.paint;

public enum Instruction {
    CANVAS("C"),
    LINE("L"),
    RECTANGLE("R"),
    BUCKET_FILL("B"),
    QUIT("Q");

    private String instruction;

    Instruction(String instruction){
        this.instruction = instruction;
    }

    public String getInstruction(){
        return instruction;
    }
}
