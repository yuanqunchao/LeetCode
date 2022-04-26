public class LFUCache {
    int minfreq, capacity;


    public LFUCache(int capacity) {

    }

    public int get(int key) {

    }

    public void put(int key, int value) {

    }
}

// 双向链表节点
class Node {
    int key, val, freq;
    Node prev, next;

    Node() {
        this(-1, -1, 0);
    }

    Node(int key, int val, int freq) {
        this.key = key;
        this.val = val;
        this.freq = freq;
    }
}

class DoublyLinkedList {
    Node dummyHead, dummyTail;
    int size;

}