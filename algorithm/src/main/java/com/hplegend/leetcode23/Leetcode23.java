package com.hplegend.leetcode23;

import com.hplegend.base.ListNode;

import java.util.List;

/**
 * @author hp.he
 * @date 2021/1/17 22:06
 */
public class Leetcode23 {

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode mergedList = null;
        for (ListNode ele : lists) {
            mergedList = mergeTwo(mergedList, ele);
        }

        return mergedList;

    }


    public ListNode mergeTwo(ListNode one, ListNode two) {

        ListNode sentialHead = new ListNode(0);
        ListNode mergeNext = sentialHead;


        ListNode oneNext = one;
        ListNode twoNet = two;

        //
        while (oneNext != null && twoNet != null) {
            if (oneNext.val < twoNet.val) {
                mergeNext.next = oneNext;
                oneNext = oneNext.next;

            } else {
                mergeNext.next = twoNet;
                twoNet = twoNet.next;
            }

            mergeNext = mergeNext.next;
        }

        if (twoNet != null) {
            mergeNext.next = twoNet;
        }

        if (oneNext != null) {
            mergeNext.next = oneNext;
        }


        return sentialHead.next;
    }

}
