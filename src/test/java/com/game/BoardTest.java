package com.game;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class BoardTest {

    private Board board;

    @Before
    public void setUp(){
        board = new Board(100);
    }

    @Test
    public void shouldGetSize() {
        int actualSize = board.getSize();
        assertThat(actualSize, is(100));
    }

    @Test
    public void shouldGetPlayers() {
        Player player1 = new Player("A");
        Player player2 = new Player("B");

        board.addPlayer(player1);
        board.addPlayer(player2);

        assertThat(board.getPlayers(), containsInAnyOrder(player1, player2));
    }

    @Test
    public void shouldUpdatePosition() {
        Ladder ladder = new Ladder(12, 23);
        board.addLadder(ladder);
        Snake snake = new Snake(34, 21);
        board.addSnake(snake);
        Player player = new Player("A");
        player.setPosition(15);
        board.addPlayer(player);

        board.updatePosition(player, 3);

        assertThat(player.getPosition(), is(18));
    }

    @Test
    public void shouldUpdatePositionWhenSnakeBites() {
        Snake snake = new Snake(23, 12);
        board.addSnake(snake);
        Player player = new Player("A");
        player.setPosition(20);
        board.addPlayer(player);

        board.updatePosition(player, 3);

        assertThat(player.getPosition(), is(12));
    }

    @Test
    public void shouldUpdatePositionWhenPlayerGetsLadder() {
        Ladder ladder = new Ladder(12, 23);
        board.addLadder(ladder);
        Player player = new Player("A");
        player.setPosition(9);
        board.addPlayer(player);

        board.updatePosition(player, 3);

        assertThat(player.getPosition(), is(23));
    }
}