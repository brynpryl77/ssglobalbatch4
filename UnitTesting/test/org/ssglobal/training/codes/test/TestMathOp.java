package org.ssglobal.training.codes.test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.ssglobal.training.codes.MathOp;

public class TestMathOp {

    private MathOp mathOp;

    @BeforeEach
    public void setup() {
        mathOp = new MathOp();
    }

    @AfterEach
    public void teardown() {
        mathOp = null;
    }

    @ParameterizedTest
    @ValueSource(ints = { 100, 50, 90, 10, 0, -1, -5, -10 })
    public void testDivide(int param) {
        int expected = 10;
        try {
            int actual = mathOp.divide(10, param);
            assertEquals(expected, actual);
        } catch (Exception e) {
            fail("did not apply exception handling");
        }
    }

    @ParameterizedTest
    @MethodSource("createParams")
    public void testDivideTwoParams(DivideParams params) {
        int expected = params.getExpected();
        try {
            int actual = mathOp.divide(params.getxParam(), params.getyParam());
            assertEquals(expected, actual);
        } catch (Exception e) {
            fail("did not apply exception handling");
        }
    }

    @Test
    public void testDivideNew() {
        int expected = 0;
        assertDoesNotThrow(() -> {
            int actual = mathOp.divide(10, 0);
            assertEquals(expected, actual);
        }, "did not apply exception handling");
    }

    public static Stream<DivideParams> createParams() {
        return Stream.of(
                new DivideParams(10, 10, 1),
                new DivideParams(-10, 5, -2),
                new DivideParams(3, 0, 0));
    }

}

class DivideParams {
    int xParam;
    int yParam;
    int expected;

    public DivideParams(int xParam, int yParam, int expected) {
        this.xParam = xParam;
        this.yParam = yParam;
        this.expected = expected;
    }

    public int getExpected() {
        return expected;
    }

    public void setExpected(int expected) {
        this.expected = expected;
    }

    public int getxParam() {
        return xParam;
    }

    public int getyParam() {
        return yParam;
    }

    public void setxParam(int xParam) {
        this.xParam = xParam;
    }

    public void setyParam(int yParam) {
        this.yParam = yParam;
    }

}