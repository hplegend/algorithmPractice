package com.hplegend.leetcode203;

import com.hplegend.base.ListNode;

public class MainTestClass {

    public static void main(String []args) {

        ListNode head = new ListNode(1);
        ListNode one = new ListNode(5);
        ListNode two = new ListNode(5);
        ListNode three = new ListNode(9);
        ListNode four = new ListNode(59);
        ListNode five = new ListNode(53);

        head.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = null;

        Leetcode203 leetcode203 = new Leetcode203();

        leetcode203.removeElements(head,5);

        ListNode itr = head;
        while (itr != null) {
            System.out.println(itr.val);
            itr = itr.next;
        }



    }


}
