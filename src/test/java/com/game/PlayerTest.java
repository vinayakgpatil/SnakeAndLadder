package com.game;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class PlayerTest {


    @InjectMocks
    private Player player;

    @Test
    public void shouldGetPlayerName() {

        String actualName="Test";
        player.setName(actualName);

        String name = player.getName();

        assertThat(name, is(actualName));
    }

    @Test
    public void shouldGetPlayerPosition() {

        int position = 1;
        player.setPosition(position);

        int actualPosition = player.getPosition();

        assertThat(actualPosition, is(position));
    }

    @Test
    public void shouldGetDefaultPosition() {

        int actualPosition = player.getPosition();

        assertThat(actualPosition, is(0));
    }

    @Test
    public void shouldRollDice() {
        Dice dice = mock(Dice.class);

        player.rollDice(dice);

        verify(dice).roll();
    }
}