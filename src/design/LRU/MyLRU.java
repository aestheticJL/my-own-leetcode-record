package design.LRU;

import java.util.HashMap;
import java.util.Map;

public class MyLRU {
    public class Node {
        int key;
        int val;
        Node next;
        Node pre;
    }

    Node head;
    Node tail;
    Map<Integer, Node> map;
    int size;
    int maxSize;

    public MyLRU(int maxSize) {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>();
        size = 0;
        this.maxSize = maxSize;
    }

    public void addNode(Node node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    public void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            moveToHead(node);
            return node.val;
        }
    }

    public void set(int key, int val) {
        Node node = map.get(key);
        if (node == null) {
            size++;
            if (size > maxSize) {
                map.remove(tail.pre.key);
                removeNode(tail.pre);
            }
            Node newNode = new Node();
            newNode.val = val;
            newNode.key = key;
            map.put(key, newNode);
            addNode(node);
        } else {
            node.val = val;
            moveToHead(node);
        }
    }
}
