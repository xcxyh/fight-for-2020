package com.xiong.kotlin.leet

import java.util.*


class Leet1046_lastStoneWeight {


    fun lastStoneWeight(stones: IntArray): Int {

        val q = PriorityQueue<Int>(compareByDescending { it })

        stones.forEach {
            q.offer(it)
        }

        while (q.size > 1) {

            val y = q.poll()
            val x = q.poll()

            if (y - x > 0) {
                q.offer(y - x)
            }
        }

        return if (q.isEmpty()) 0 else q.poll()

    }
}