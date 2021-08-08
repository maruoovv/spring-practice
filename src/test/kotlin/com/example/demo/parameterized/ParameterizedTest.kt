package com.example.demo.parameterized

import org.apache.logging.log4j.util.Strings
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.*
import java.time.Month
import java.util.stream.Stream

class ParameterizedTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 3, 5, 7, 9])
    fun isOddTest(number: Int) {
        assertTrue(number % 2 != 0)
    }

    @ParameterizedTest
    @NullSource
    fun isBlankTrueWhenNullString(str: String?) {
        assertTrue(Strings.isEmpty(str))
    }

    @ParameterizedTest
    @EmptySource
    fun isBlankTrueWhenEmptyString(str: String?) {
        assertTrue(Strings.isEmpty(str))
    }

    @ParameterizedTest
    @EnumSource(Month::class)
    fun monthValueTest(month: Month) {
        val monthValue = month.value
        assertTrue(monthValue in 1..12)
    }

    @ParameterizedTest
    @EnumSource(value = Month::class,
            names = ["FEBRUARY", "APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"],
            mode = EnumSource.Mode.INCLUDE)
    fun notInclude31DayMonth(month: Month) {
        assertNotEquals(31, month.length(false))
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource
    fun stringCompareTest(description: String, origin: String, comp: String, result: Boolean) {
        assertEquals(result, origin == comp)
    }

    companion object {

        @JvmStatic
        fun stringCompareTest() = Stream.of(
                Arguments.of("같은 스트링", "hello", "hello", true),
                Arguments.of("다른 스트링", "hi", "hello", false)
        )
    }
}