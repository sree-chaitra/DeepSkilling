package com.advanced;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ TestClassOne.class, TestClassTwo.class })
public class AllTests {
    // This class is only used to run the suite
}
