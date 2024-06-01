package com.omprakash.algorithm.fixedwindow

import com.omprakash.algorithm.Algorithm

class FixedWindow(private val maxRequests: Int, private val storage: FixedWindowStorage) : Algorithm {
    override val fixedWindowStorage: FixedWindowStorage
        get() = storage

    override fun validateRequest(): Result<Boolean> {
        val recordResult = storage.record_fixed_window()
        return if (recordResult.isSuccess) {
            val currentCount = storage.fetch_fixed_window().getOrDefault(Int.MAX_VALUE)
            if (currentCount <= maxRequests) {
                Result.success(true)
            } else {
                Result.failure(Exception("request exceeded limit"))
            }
        } else {
            Result.failure(Exception("record fixed window failure"))
        }
    }
}