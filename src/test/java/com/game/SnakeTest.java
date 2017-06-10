package com.game;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class SnakeTest {


    @Test
    public void shouldGetPositions() {
        Snake snake = new Snake(23, 12);
        assertThat(snake.getHeadPosition(), is(23));
        assertThat(snake.getTailPosition(), is(12));
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionIfHeadPositionIsLesserThanTailPosition() {
        new Snake(12, 23);
    }
}