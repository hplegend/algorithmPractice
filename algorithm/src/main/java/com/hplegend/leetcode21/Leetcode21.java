package com.hplegend.leetcode21;

import com.hplegend.base.ListNode;

/**
 * @author hp.he
 * @date 2020/8/10 0:15
 */
public class Leetcode21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // 用作哨兵
        ListNode newHead = new ListNode(0);
        ListNode newNext = newHead;

        //
        if (null == l1) {
            return l2;
        }

        if (null == l2) {
            return l1;
        }

        ListNode l1Tmp = l1;
        ListNode l2Tmp = l2;

        while (l1Tmp != null && l2Tmp != null) {
            if (l1Tmp.val < l2Tmp.val) {
                newNext.next = l1Tmp;
                l1Tmp = l1Tmp.next;
            } else {
                newNext.next = l2Tmp;
                l2Tmp = l2Tmp.next;
            }
            newNext = newNext.next;
        }

        if (l1Tmp != null) {
            newNext.next = l1Tmp;
        }


        if (l2Tmp != null) {
            newNext.next = l2Tmp;
        }


        return newHead.next;
    }


    public static void main(String[] args) {


    }

}
