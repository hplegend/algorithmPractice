package com.hplegend.list.leetcode19;

import com.hplegend.base.ListNode;

/**
 * @author hp.he
 * @date 2020/11/12 19:39
 */
public class MainTestClass {

    public static void main(String[] args) {

        Leetcode19 leetcode19 = new Leetcode19();

        ListNode head = new ListNode(1);
        ListNode next1 = new ListNode(2);
        ListNode next2 = new ListNode(3);
        ListNode next3 = new ListNode(4);
        ListNode next4 = new ListNode(5);

        head.next = next1;
        next1.next = next2;
        next2.next = next3;
        next3.next = next4;
        ListNode ret = leetcode19.removeNthFromEnd(head, 5);
        while (ret != null) {
            System.out.println(ret.val);
            ret = ret.next;
        }

    }

}
