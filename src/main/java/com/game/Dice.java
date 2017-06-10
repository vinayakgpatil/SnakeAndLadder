package com.game;


import java.util.Random;
import java.util.stream.IntStream;

public class Dice {

    private static int MAX_NUMBER = 6;
    private static int MIN_NUMBER = 1;
    private int noOfDice = 1;

    public void setNoOfDice(int noOfDice) {
        if(noOfDice <= 0){
            throw new RuntimeException("Invalid Input");
        }
        this.noOfDice = noOfDice;
    }

    public int roll() {
        Random random = new Random();
        IntStream intStream = random.ints(MIN_NUMBER, (MAX_NUMBER * noOfDice));
        return intStream.findAny().getAsInt();
    }
}
