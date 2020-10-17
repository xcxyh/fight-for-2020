package com.xiong.kotlin.leet

class Leet1_towSum {

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()

        for ((i, x: Int) in nums.withIndex()) {

            val otherVal = target - x

            if (map.containsKey(otherVal)) {
                return intArrayOf(map[otherVal] as Int, i)
            }

            map[x] = i
        }

        return IntArray(2) { -1 }
    }
}