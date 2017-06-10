package com.game;


public class Ladder {

    private int topPosition;
    private int bottomPosition;

    public Ladder(int bottomPosition, int topPosition) {
        if(topPosition <= bottomPosition){
            throw new RuntimeException("Invalid Positions");
        }
        this.topPosition = topPosition;
        this.bottomPosition = bottomPosition;
    }

    public int getTopPosition() {
        return topPosition;
    }

    public int getBottomPosition() {
        return bottomPosition;
    }
}
