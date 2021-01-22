package com.hplegend.leetcode148;

import com.hplegend.base.ListNode;
import com.hplegend.base.ListUtils;

/**
 * @author hp.he
 * @date 2021/1/22 20:01
 */
public class MainClass {
    public static void main(String[] args) {
        Leetcode148 leetcode148 = new Leetcode148();
        ListNode head = new ListNode(1);
        ListNode one = new ListNode(80);
        ListNode two = new ListNode(5);
        ListNode three = new ListNode(-1);
        ListNode four = new ListNode(59);


        head.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = null;

        ListNode ret = leetcode148.sortList(head);

        ListUtils.printList(ret);


    }

}
