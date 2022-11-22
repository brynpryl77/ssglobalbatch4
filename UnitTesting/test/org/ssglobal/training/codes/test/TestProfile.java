package org.ssglobal.training.codes.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ssglobal.training.codes.Profile;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestProfile {
    // set up and initialization | fixtures
    private Profile profile;

    @BeforeAll
    public static void superSetup() {
       System.out.println("This is executed before all tests");
    }

    @AfterAll
    public static void superTeardown() {
       System.out.println("This is executed after all tests");
    }


    @BeforeEach
    public void setup() {
        profile = new Profile();
        System.out.println("Setting up...");
    }

    @AfterEach
    public void teardown() {
        profile = null;
        System.out.println("Tearing down...");
    }

    // test cases for the methods
    @Test
    public void testShowProfile() {
        String expected = "Juan 90";
        String actual = profile.showProfile();
        assertEquals(expected, actual);
        System.out.println("Testing showProfile()...");
    }

    @Test
    public void testIncreaseAge() {
        int expected = 28;
        int actual = profile.increaseAge(10);
        assertEquals(expected, actual);
        System.out.println("Testing increaseAge()...");
    }
    
    
}
