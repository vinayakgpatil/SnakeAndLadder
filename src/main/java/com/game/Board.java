package com.game;


import java.util.ArrayList;
import java.util.List;

public class Board {

    private int size = 100;
    private List<Snake> snakes = new ArrayList<>();
    private List<Ladder> ladders = new ArrayList<>();
    private List<Player> players = new ArrayList<>();

    public Board(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void addSnake(Snake snake) {
        snakes.add(snake);
    }

    public void addLadder(Ladder ladder) {
        ladders.add(ladder);
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public List<Player> getPlayers() {
        return players;
    }


    public void updatePosition(Player player, int value) {
        int position = player.getPosition() + value;
        Integer tailPosition = getTailPositionIfMatched(position);
        if(tailPosition != null){
            player.setPosition(tailPosition);
        }else{
            Integer topPosition = getTopPositionIfMatched(position);
            if(topPosition != null) {
                player.setPosition(topPosition);
            }else {
                if (position <= size) {
                    player.setPosition(position);
                }
            }
        }
    }

    private Integer getTopPositionIfMatched(int position) {
        for(Ladder ladder : ladders){
            if(ladder.getBottomPosition() == position){
                System.out.println("Ladder position matched");
                return ladder.getTopPosition();
            }
        }
        return null;
    }

    private Integer getTailPositionIfMatched(int position) {
        for(Snake snake : snakes){
            if(snake.getHeadPosition() == position){
                System.out.println("Snake position matched");
                return snake.getTailPosition();
            }
        }
        return null;
    }
}
