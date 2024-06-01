package com.omprakash.algorithm.fixedwindow

import java.util.concurrent.atomic.AtomicInteger

class FixedWindowInMemoryStorage : FixedWindowStorage {
    private val activeRequests: AtomicInteger = AtomicInteger(0)
    override fun record_fixed_window(): Result<Int> {
        return Result.success(activeRequests.incrementAndGet())
    }

    override fun fetch_fixed_window(): Result<Int> {
        return Result.success(activeRequests.get())
    }
}