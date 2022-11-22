package org.ssglobal.training.codes.test;


import java.util.List;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class MyTestRunner {
    public static void main(String[] args) {

        // create runner
        JUnitCore runner = new JUnitCore();
        runner.addListener(new TextListener(System.out));
        Result result = runner.run(TestAllClasses.class);
        System.out.println("Run count: " + result.getRunCount());
        System.out.println("Failure count: " + result.getFailureCount());
        System.out.println("Ignore count: " + result.getIgnoreCount());
        System.out.println("Run time: " + result.getRunTime());

        List<Failure> failures = result.getFailures();
        for (Failure failure : failures) {
            System.out.println(failure.toString());
        }
    }
}
