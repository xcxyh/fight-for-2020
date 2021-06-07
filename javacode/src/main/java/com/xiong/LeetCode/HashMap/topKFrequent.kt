package com.xiong.LeetCode.HashMap


fun topKFrequent(words: Array<String>, k: Int): List<String> {
    return words.asSequence()
            .groupBy { it }
            .entries
            .sortedWith(compareBy<Map.Entry<String, List<String>>> { -it.value.size }.thenBy { it.key })
            .map { it.key }
            .subList(0, k)
            .toList()
}