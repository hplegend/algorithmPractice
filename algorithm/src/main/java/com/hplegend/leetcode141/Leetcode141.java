package com.hplegend.leetcode141;

import com.hplegend.base.ListNode;


public class Leetcode141 {

    public Boolean hasCycle(ListNode head) {
        // 判定是否有环的最简单
        ListNode fast, slow;
        fast = slow = head;
        while(null != fast && null != fast.next) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

}
