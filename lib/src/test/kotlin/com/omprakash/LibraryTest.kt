/*
 * This source file was generated by the Gradle 'init' task
 */
package com.omprakash

import com.omprakash.plugin.RateLimiterPlugin
import kotlin.test.Test
import kotlin.test.assertTrue

class LibraryTest {
    @Test fun someLibraryMethodReturnsTrue() {
        val classUnderTest = RateLimiterPlugin()
        assertTrue(classUnderTest.someLibraryMethod(), "someLibraryMethod should return 'true'")
    }
}
