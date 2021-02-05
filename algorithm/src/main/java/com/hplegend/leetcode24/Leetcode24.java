package com.hplegend.leetcode24;

import com.hplegend.base.ListNode;

/**
 * @author hp.he
 * @date 2021/2/5 21:20
 */
public class Leetcode24 {

    public ListNode swapPairs(ListNode head) {
        // 递归模式
        // 每一次返回新的头节点，让前一次的尾部节点链接上返回的头节点
        // 递归的出口： 没有节点，或者只有一个节点
        if (null== head || head.next == null) {
            return head;
        }

        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;

    }
}
