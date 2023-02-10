package com.algorithm;

import java.util.HashMap;

/**
 * LRU缓存设计
 */
public class LruCache {

    static Solution solution = new Solution(15);

    public static void main(String[] args) {
        solution.set(1, 17);
        System.out.println(solution.get(1));
    }

}

class Solution {

    private HashMap<Integer, ListNode> map;
    private int capacity;
    private ListNode firstNode = null;
    private ListNode lastNode = null;

    public Solution(int capacity) {
        // write code here
        this.capacity = capacity;
        map = new HashMap(capacity);
    }

    public int get(int key) {
        // write code here
        ListNode node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            moveToFirst(node);
            return node.val;
        }
    }

    public void set(int key, int value) {
        // write code here
        ListNode node = map.get(key);
        if (node == null) {
            if (map.size() == capacity) {
                removeLastNode();
            }
            node = new ListNode(key, value);
            map.put(key, node);
            moveToFirst(node);
        } else {
            node.val = value;
            moveToFirst(node);
        }
    }

    private void moveToFirst(ListNode node) {
        if (firstNode == null) {
            firstNode = lastNode = node;
            return;
        }
        if (firstNode == node) {
            return;
        }
        if (lastNode == node) {
            lastNode = lastNode.prev;
            lastNode.next = null;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        firstNode.prev = node;
        node.next = firstNode;
        node.prev = null;
        firstNode = node;
    }

    private void removeLastNode() {
        if (lastNode == null) {
            map.clear();
            return;
        }
        ListNode node = lastNode;
        lastNode = lastNode.prev;
        if (lastNode != null) {
            lastNode.next = null;
        } else {
            firstNode = lastNode = null;
            map.clear();
        }
        map.remove(node.key);
    }

}

class ListNode {
    ListNode prev;
    ListNode next;
    int key;
    int val;

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
