package com.game;


public class Player {

    private String name;
    private int position = 0;

    public Player(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public int rollDice(Dice dice){
        return dice.roll();
    }

    public void print() {
        System.out.println("Player : "+name+" ["+position+"]");
    }
}
