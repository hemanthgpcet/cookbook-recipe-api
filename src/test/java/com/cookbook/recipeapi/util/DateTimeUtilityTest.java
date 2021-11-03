package com.cookbook.recipeapi.util;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * This class is for DateTimeUtility test with Junit 
 * 
 * @author heman
 *
 */

@ExtendWith(SpringExtension.class)

@SpringBootTest
public class DateTimeUtilityTest {
	
  @InjectMocks
  private static DateTimeUtility dateTimeUtility;
  
  /**
   * Jnit test for datetime utility
   * 
   * @author heman
   *
   */
  
  @Test
@DisplayName("Test case for datetime format validation")
  void statestDateTimeFormat()
  {
	  String time=dateTimeUtility.getLocalDateTime();
	  assertNotNull(time);
	  
	  
  }
}