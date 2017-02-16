package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by gdiegel on 2/16/17.
 */
public class TestClassWithTwoMethods {

    @Test
    public void one() {
        assertThat(Math.random())
                .as("Should always be less than 1.0")
                .isGreaterThan(1.0);
    }

    @Test
    public void two() {
        assertThat(Boolean.TRUE)
                .as("Should always be true")
                .isFalse();
    }

}
