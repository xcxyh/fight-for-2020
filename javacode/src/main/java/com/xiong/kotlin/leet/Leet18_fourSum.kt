package com.xiong.kotlin.leet

import java.util.*
import kotlin.test.currentStackTrace

class Leet18_fourSum {

    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {

        val ans = arrayListOf<List<Int>>()

        val n = nums.size

        Arrays.sort(nums)

        for ( a in 0 until n - 3){

            if (a > 0 && nums[a] == nums[a - 1]) {
                continue
            }

            for (b in a + 1 until n - 2) {

                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue
                }

                val sum = target - nums[a] - nums[b]
                var d = n - 1
                for (c in b + 1 until n - 1){

                    if (c > b + 1 && nums[c] == nums[c - 1]) {
                        continue
                    }

                    while (d > c && nums[c] + nums[d] > sum) {
                        d--
                    }
                    if (d == c) {
                        break
                    }

                    if (nums[c] + nums[d] == sum) {
                        ans.add(arrayListOf(nums[a], nums[b], nums[c], nums[d]))
                    }

                }
            }

        }

        return ans

    }
}