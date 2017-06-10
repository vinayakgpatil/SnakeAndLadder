package com.game;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class LadderTest {


    @Test
    public void shouldGetPositions() {
        Ladder ladder = new Ladder(14, 26);
        assertThat(ladder.getTopPosition(), is(26));
        assertThat(ladder.getBottomPosition(), is(14));
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionIfTopPositionIsLesserThanBottomPosition() {
        new Ladder(34, 16);
    }
}