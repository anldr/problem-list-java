package commonutils.leetcode;

/**
 * leetcode
 * 1、随机链表节点
 * 2、二叉树+next节点
 */
public class Node {
    public int val;

    public Node left;

    public Node right;

    public Node next;

    public Node random;

    public Node() {

    }

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
