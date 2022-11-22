package org.ssglobal.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.ssglobal.training.codes.Fruits;

public class TestFruits {

    private Fruits fruits;

    @BeforeEach
    public void setup() {
        fruits = new Fruits();
    }

    @AfterEach
    public void teardown() {
        fruits = null;
    }

    // Sunny day approach
    // Development team

    @ParameterizedTest
    @ValueSource(strings = { "apple", "banana", "orange" })
    public void testAddFruits(String param) {
        boolean expected = true;
        boolean actual = fruits.addFruits(param);
        assertEquals(expected, actual);
    }

    @RepeatedTest(10)
    public void testAddFruitRainy() {
        boolean expected = true;
        boolean actual = fruits.addFruits("apple", "banana", "orange");
        assertNotEquals(expected, actual);
    }

    @EnabledOnOs(OS.LINUX)
    @Order(1)
    @Test
    public void testGetStandNotNull() {
        assertNotNull(fruits.getStand());
    }

    // @EnabledOnJre(JRE.JAVA_12)
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_19)
    @EnabledOnOs(OS.WINDOWS)
    @Order(2)
    @Test
    public void testGetStandContent() {
        List<String> expected = List.of("apple", "banana", "orange");
        List<String> actual = fruits.getStand();
        assertIterableEquals(expected, actual);
    }

    @RepeatedTest(10)
    @EnabledIf("toggleOnOff")
    @EnabledOnOs(OS.WINDOWS)
    @Order(3)
    public void testCountStand() {
        assertTimeout(Duration.ofMillis(50), () -> {
            int expected = 10;
            int actual = fruits.countFruits();
            assertTrue(actual >= expected);
        });
    }

    @EnabledIf("toggleOnOff")
    @EnabledOnOs(OS.WINDOWS)
    @Order(4)
    @Test
    public void testGetFruitStream() {
        Stream<String> expected = Stream.of("apple", "banana", "grapes");
        Stream<String> actual = fruits.getFruitStream();
        assertLinesMatch(expected, actual);
    }

    // switch
    public static boolean toggleOnOff() {
        return true;
    }
}
