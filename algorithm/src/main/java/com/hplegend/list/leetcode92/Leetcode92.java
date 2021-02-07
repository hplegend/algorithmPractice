package com.hplegend.list.leetcode92;

import com.hplegend.base.ListNode;

/**
 * @author hp.he
 * @date 2021/2/6 22:34
 */
public class Leetcode92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        return reveserRange(head, m, n);
    }


    // 以某一个头节点，反转一部分

    ListNode lastSuccessor = null;

    // 返回新的头结点，把单前节点作为子节点的后继
    public ListNode reveserN(ListNode head, int n) {
        // 递归出口
        // 这里不判断head null？
        if (n == 1) {
            lastSuccessor = head.next;
            return head;
        }

        // 开始递归的正常逻辑
        ListNode lastHead = reveserN(head.next, n - 1);

        // 短链
        head.next.next = head;

        //这里要指向后继
        head.next = lastSuccessor;

        return lastHead;
    }


    // 从头结点开始，反转全部

    public ListNode reveserRange(ListNode head, int m, int n) {

        if (m == 1) {
            return reveserN(head, n);
        }


        // 指向新的头节点
        head.next = reveserRange(head.next, m - 1, n - 1);
        return head;
    }


}
