package com.game;


public class Snake {

    private int headPosition;
    private int tailPosition;

    public Snake(int headPosition, int tailPosition) {
        if(headPosition <= tailPosition){
            throw new RuntimeException("Invalid Positions");
        }
        this.headPosition = headPosition;
        this.tailPosition = tailPosition;
    }

    public int getHeadPosition() {
        return headPosition;
    }

    public int getTailPosition() {
        return tailPosition;
    }
}
