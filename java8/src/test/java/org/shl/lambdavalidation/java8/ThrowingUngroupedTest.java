package org.shl.lambdavalidation.java8;

import javax.validation.ConstraintViolationException;

import org.shl.lambdavalidation.ThrowingValidationTestHarness;
import org.shl.lambdavalidation.java8.testcases.ThrowingUngroupedTestCase;
import org.testng.annotations.Test;

public class ThrowingUngroupedTest extends ThrowingValidationTestHarness<ThrowingUngroupedTestCase> {

  public ThrowingUngroupedTest() {
    super(ThrowingUngroupedTestCase.class);
  }

  @Test(dataProvider = "positiveTestCases")
  public void positiveTests(ThrowingUngroupedTestCase testCase) {
    testValid(testCase);
  }

  @Test(dataProvider = "negativeTestCases", expectedExceptions = ConstraintViolationException.class)
  public void negativeTests(ThrowingUngroupedTestCase testCase) {
    testInvalid("start must be less than end", testCase);
  }
}