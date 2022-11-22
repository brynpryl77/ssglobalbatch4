package org.ssglobal.training.codes.test;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;


@Suite
// @SelectClasses({ TestFruits.class, TestMathOp.class,
// TestClassification.class, TestProfile.class })
// Bulk testing
@SelectPackages({ "org.ssglobal.training.codes.test" })
public class TestAllClasses {

}
