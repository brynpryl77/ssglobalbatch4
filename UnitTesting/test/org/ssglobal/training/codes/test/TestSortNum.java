package org.ssglobal.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ssglobal.training.codes.SortedNum;

public class TestSortNum {

    private SortedNum sortedNum;

    @BeforeEach
    public void setup() {
        sortedNum = new SortedNum();
    }

    @AfterEach
    public void teardown() {
        sortedNum = null;
    }

    @Test
    public void testSort() {
        int[] expected = {1, 2, 3, 4, 5};
        int[] actual = sortedNum.sortNum(new int[]{5, 4, 3, 2, 1});
        assertArrayEquals(expected, actual);
    }
}
