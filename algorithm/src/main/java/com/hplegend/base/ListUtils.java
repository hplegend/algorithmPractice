package com.hplegend.base;

/**
 * @author hp.he
 * @date 2021/1/17 22:35
 */
public class ListUtils {

    public static void printList(ListNode node) {

        ListNode next = node;

        while (next!=null) {
            System.out.println(next.val);
            next = next.next;
        }

    }


}
