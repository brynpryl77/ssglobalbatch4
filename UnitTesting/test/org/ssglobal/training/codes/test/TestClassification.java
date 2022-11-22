package org.ssglobal.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.ssglobal.training.codes.Classification;

public class TestClassification {
    private Classification classification;

    @BeforeEach
    public void setup() {
        classification = Classification.EXCELLENT;
    }

    @AfterEach
    public void teardown() {
        classification = null;
    }

    @Test
    public void testEvaluate() {
        Classification expected = Classification.PASS;
        Classification actual = Classification.evaluate(82);
        assertSame(expected, actual);
    }

    @ParameterizedTest
    @EnumSource(Classification.class)
    public void testEvaluateNew(Classification rating) {
        double expected = 60;
        double actual = Classification.computeWeights(rating);
        assertFalse(actual >= expected);
    }
}
