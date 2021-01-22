package com.hplegend.leetcode148;

import com.hplegend.base.ListNode;

/**
 * @author hp.he
 * @date 2021/1/22 19:39
 */
public class Leetcode148 {
    public ListNode sortList(ListNode head) {
        // 4步
        // 1、快慢指针拆分
        // 2、分割两部分
        // 3、递归分割
        // 4、合并两部分
        // 主要递归返回： head为空或者一个元素时返回
        return recussive(head);
    }


    public ListNode recussive(ListNode head) {

        if (null == head) {
            return head;
        }

        if (head.next == null) {
            return head;
        }

        // split
        ListNode slow, fast;

        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        ListNode newRightHead = slow;

        // 短链路
        ListNode tmp = head;
        while (tmp.next != null && tmp.next != slow) {
            tmp = tmp.next;
        }
        tmp.next = null;


        ListNode leftNew = recussive(head);
        ListNode rightNew = recussive(newRightHead);

        // merge
        return mergerTwo(leftNew, rightNew);
    }


    private ListNode mergerTwo(ListNode left, ListNode right) {

        ListNode newHead = new ListNode(0);
        ListNode newNext = newHead;

        ListNode lTmp = left;
        ListNode rTmp = right;

        while (lTmp != null && rTmp != null) {
            if (lTmp.val < rTmp.val) {
                newNext.next = lTmp;
                lTmp = lTmp.next;
            } else {
                newNext.next = rTmp;
                rTmp = rTmp.next;
            }
            newNext = newNext.next;
        }

        if (lTmp != null) {
            newNext.next = lTmp;
        }

        if (rTmp != null) {
            newNext.next = rTmp;
        }

        return newHead.next;
    }

}
