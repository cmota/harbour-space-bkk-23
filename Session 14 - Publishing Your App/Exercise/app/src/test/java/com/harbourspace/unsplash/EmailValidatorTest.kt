package com.harbourspace.unsplash

import com.harbourspace.unsplash.utils.isValidEmail
import junit.framework.Assert.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test

class EmailValidatorTest {
  @Test
  fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
    assertTrue("name@email.com".isValidEmail())
  }

  @Test
  fun emailValidator_WrongEmailSimple_ReturnsFalse() {
    assertFalse("nameemail.com".isValidEmail())
  }
}
