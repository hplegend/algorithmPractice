package com.hplegend.leetcode142;

import com.hplegend.base.ListNode;



public class Leetcode142 {

    public ListNode detectCycle(ListNode head) {
        // 判定是否有环的最简单

        ListNode fast, slow;
        fast = slow = head;
        while(null != fast && null != fast.next) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = ptr;
                }

                return ptr;
            }
        }

        return null;
    }

}
