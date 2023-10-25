package Random.code_1206_设计跳表;

import java.util.Arrays;
import java.util.Random;

/**
 * completion time = 2023.10.25
 */
class Skiplist {

    private Random random;
    private static int MAX_LEVEL = 32;
    private static double P_FACTOR = 0.25;
    private int level;
    private Node head;

    class Node {
        int val;

        // 下一个节点
        Node[] forward;

        Node(int val, int size) {
            this.val = val;
            forward = new Node[size];
        }
    }

    public Skiplist() {
        this.random = new Random();
        this.head = new Node(-1, MAX_LEVEL);
        this.level = 0;
    }

    int genLevel() {
        int lv = 1;
        /* 随机生成 lv */
        while (random.nextDouble() < P_FACTOR && lv < MAX_LEVEL) {
            lv++;
        }
        return lv;
    }

    public boolean search(int target) {
        Node cur = head;
        for (int i = level - 1; i >= 0; i--) {
            while (cur.forward[i] != null && cur.forward[i].val < target) {
                // 找到第 i 层最接近 target 的元素
                cur = cur.forward[i];
            }
        }
        // 如果存在，一定会在最下面的一层
        cur = cur.forward[0];
        return cur != null && cur.val == target;
    }

    public void add(int num) {
        // update[i]的forward[i]指向新节点
        Node[] update = new Node[MAX_LEVEL];
        Arrays.fill(update, head);
        Node cur = head;
        for (int i = level - 1; i >= 0; i--) {
            while (cur.forward[i] != null && cur.forward[i].val < num) {
                // 找到第 i 层最接近 target 的元素
                cur = cur.forward[i];
            }
            update[i] = cur;
        }
        int lv = genLevel();
        level = Math.max(lv, level);
        Node newNode = new Node(num, lv);
        for (int i = 0; i < lv; i++) {
            newNode.forward[i] = update[i].forward[i];
            update[i].forward[i] = newNode;
        }
    }

    public boolean erase(int num) {
        Node[] update = new Node[MAX_LEVEL];
        Arrays.fill(update, head);
        Node cur = head;
        for (int i = level - 1; i >= 0; i--) {
            while (cur.forward[i] != null && cur.forward[i].val < num) {
                cur = cur.forward[i];
            }
            update[i] = cur;
        }
        // 最下面一层一定能找到它最准确的下一个
        cur = cur.forward[0];
        // 如果不存在，就直接返回false
        if (cur == null || cur.val != num) {
            return false;
        }
        for (int i = 0; i < level; i++) {
            if (update[i].forward[i] != cur) {
                break;
            }
            update[i].forward[i] = cur.forward[i];
        }
        while (level > 1 && head.forward[level - 1] == null) {
            level--;
        }
        return true;
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */
