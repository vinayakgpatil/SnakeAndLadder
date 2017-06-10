package com.game;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class DiceTest {

    @InjectMocks
    private Dice dice;

    @Test
    public void shouldRollSingleDice() {

        for(int i=0; i<10; i++) {
            int result = dice.roll();
            assertTrue(result >= 1 && result <= 6);
        }
    }

    @Test
    public void shouldRollDoubleDice() {

        dice.setNoOfDice(2);

        for(int i=0; i<100; i++) {
            int result = dice.roll();
            assertTrue(result >= 1 && result <= 12);
        }
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionIfLessThanZero() {
        dice.setNoOfDice(0);
    }
}