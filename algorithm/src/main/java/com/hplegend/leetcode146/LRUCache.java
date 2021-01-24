package com.hplegend.leetcode146;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hp.he
 * @date 2021/1/24 15:40
 */
public class LRUCache {

    // 自行维护双向链表
    // 目的在于维护删除策略

    static class DoubbleLinkedNode {
        // key和value都是作为冗余备份的
        int key;
        int value;

        DoubbleLinkedNode prev;
        DoubbleLinkedNode next;

        public DoubbleLinkedNode() {

        }

        public DoubbleLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // 缓存结构
    private Map<Integer, DoubbleLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;

    // 维护双向链表
    private DoubbleLinkedNode head, tail;


    public LRUCache(int capacity) {

        this.size = 0;
        this.capacity = capacity;

        head = new DoubbleLinkedNode();
        tail = new DoubbleLinkedNode();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        DoubbleLinkedNode node = cache.get(key);
        if (null == node) {
            return -1;
        }

        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {

        DoubbleLinkedNode node = cache.get(key);
        if (null == node) {

            DoubbleLinkedNode newNode = new DoubbleLinkedNode(key, value);
            cache.put(key, newNode);

            // 同时维护双向链表
            addToHead(newNode);

            ++size;

            if (size > capacity) {

                DoubbleLinkedNode deleted = removeTail();
                cache.remove(deleted.key);
                --size;

            }

        } else {
            node.value = value;
            moveToHead(node);
        }


    }


    // 对于新增的节点，要添加到头部
    private void addToHead(DoubbleLinkedNode node) {

        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }


    private void removeNode(DoubbleLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    private void moveToHead(DoubbleLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DoubbleLinkedNode removeTail() {
        // 伪头部和尾部，类似于哨兵节点
        DoubbleLinkedNode tailNode = tail.prev;

        removeNode(tailNode);

        return tailNode;
    }


}
