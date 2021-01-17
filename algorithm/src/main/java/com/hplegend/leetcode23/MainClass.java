package com.hplegend.leetcode23;

import com.hplegend.base.ListNode;
import com.hplegend.base.ListUtils;

/**
 * @author hp.he
 * @date 2021/1/17 22:07
 */
public class MainClass {

    public static void main(String[] args) {
        Leetcode23 leetcode23 = new Leetcode23();


        ListNode node1 = new ListNode(1);
        ListNode node11 = new ListNode(2);
        ListNode node12 = new ListNode(4);
        ListNode node13 = new ListNode(6);
        node1.next = node11;
        node11.next = node12;
        node12.next = node13;


        ListNode node2 = new ListNode(1);
        ListNode node21 = new ListNode(3);
        ListNode node22 = new ListNode(5);
        ListNode node23 = new ListNode(9);
        node2.next = node21;
        node21.next = node22;
        node22.next = node23;


        ListNode node3 = new ListNode(7);
        ListNode []arr = new ListNode[]{node1, node2, node3};

        ListNode ret = leetcode23.mergeKLists(arr);

        ListUtils.printList(ret);
    }


}
