package com.xiong.kotlin.leet

class Leet2_addTwoNumbers {

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

        if (l1 == null) {
            return l2
        }

        if (l2 == null) {
            return l1
        }


        var carry = 0

        var cur1 = l1

        var cur2 = l2

        val head = ListNode(-1)

        var cur: ListNode?  = head

        while (cur1 != null || cur2 != null) {
            val v1 = cur1?.`val` ?: 0
            val v2 = cur2?.`val` ?: 0

            var sum = v1 + v2 + carry

            carry = sum / 10

            sum %= 10

            cur?.next = ListNode(sum)

            cur = cur?.next

            cur1 = cur1?.next
            cur2 = cur2?.next

        }

        if (carry == 1) {
            cur?.next = ListNode(carry)
        }

        return head.next
    }


    class ListNode(var `val`: Int) {

        var next: ListNode? = null
    }
}