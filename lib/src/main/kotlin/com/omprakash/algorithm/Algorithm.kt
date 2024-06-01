package com.omprakash.algorithm

import com.omprakash.algorithm.fixedwindow.FixedWindowStorage

interface Algorithm {
    val fixedWindowStorage: FixedWindowStorage
    fun validateRequest(): Result<Boolean>
}