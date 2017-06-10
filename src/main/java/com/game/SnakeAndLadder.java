package com.game;


import java.util.List;

public class SnakeAndLadder {

    private Board board;
    private Dice dice;

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void play(){
        Board board = setupBoard();
        while(true){
            if(start(board)){
                break;
            }
        }
    }

    private boolean start(Board board) {
        List<Player> playerList = board.getPlayers();
        for(Player player : playerList){
            int diceValue = player.rollDice(dice);
            board.updatePosition(player, diceValue);
            player.print();
            if(player.getPosition() == board.getSize()){
                System.out.println("Player "+player.getName()+" Won!!!");
                return true;
            }
        }
        System.out.println("---------------------------------------------------------");

        return false;
    }

    private Board setupBoard() {
        board.addSnake(new Snake(33, 15));
        board.addSnake(new Snake(67, 45));
        board.addSnake(new Snake(96, 75));

        board.addLadder(new Ladder(19, 30));
        board.addLadder(new Ladder(70, 90));

        board.addPlayer(new Player("A"));
        board.addPlayer(new Player("B"));

        return board;
    }

    public static void main(String[] args) {
        Board board = new Board(100);
        Dice dice = new Dice();
        dice.setNoOfDice(1);
        SnakeAndLadder snakeAndLadder = new SnakeAndLadder();
        snakeAndLadder.setBoard(board);
        snakeAndLadder.setDice(dice);
        snakeAndLadder.play();
    }
}
