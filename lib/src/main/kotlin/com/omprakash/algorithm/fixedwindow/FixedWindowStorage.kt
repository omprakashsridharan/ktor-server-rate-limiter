package com.omprakash.algorithm.fixedwindow

interface FixedWindowStorage {
    fun record_fixed_window(): Result<Int>
    fun fetch_fixed_window(): Result<Int>
}