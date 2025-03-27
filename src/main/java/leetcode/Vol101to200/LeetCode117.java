package leetcode.Vol101to200;

import commonutils.leetcode.Node;

public class LeetCode117 {
    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public Node connect(Node root) {
        Node result = root;
        if (root == null) {
            return null;
        }

        while (root != null) {
            Node dummyNode = new Node();
            Node preNode = dummyNode;
            while (root != null) {
                if (root.left != null) {
                    preNode.next = root.left;
                    preNode = preNode.next;
                }
                if (root.right != null) {
                    preNode.next = root.right;
                    preNode = preNode.next;
                }
                root = root.next;
            }
            root = dummyNode.next;
        }

        return result;
    }
}
