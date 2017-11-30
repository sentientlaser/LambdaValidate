package org.shl.validation.execution.aspects;

import javax.validation.constraints.NotNull;
import javax.validation.executable.ValidateOnExecution;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestReturnValueValidation {
  
  private boolean breakIt = false;
  
  @BeforeTest
  public void resetBreakState() {
    breakIt = false;
  }

  @NotNull
  @NotAConstraint
  @ValidateOnExecution
  public String validReturn(String a) {
    if (breakIt) {
      return null;
    }
      
    return a.toUpperCase();
  }
  
  @NotAConstraint
  @ValidateOnExecution
  public String validParams(@NotAConstraint @NotNull String a) {
    return a.toUpperCase();
  }

  @NotNull
  @NotAConstraint
  @ValidateOnExecution
  public String validMixed(@NotAConstraint @NotNull String a) {
    if (breakIt) {
      return null;
    }
      
    return a.toUpperCase();
  }
  
  
  @Test()
  public void aspectTests() {
    System.out.println(1);
//    validReturn("");
    System.out.println(2);
    validParams("");
    System.out.println(3);
//    validMixed("");
    System.out.println(4);
  }

}