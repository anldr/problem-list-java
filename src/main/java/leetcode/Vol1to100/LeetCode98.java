package leetcode.Vol1to100;


import commonutils.leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode98 {
//    class Solution {
//        public boolean isValidBST(TreeNode root) {
//            return solved(root, Long.MIN_VALUE, Long.MAX_VALUE);
//        }
//
//        public boolean solved(TreeNode root, long lower, long upper) {
//            if (root == null) {
//                return true;
//            }
//            if (root.val >= upper || root.val <= lower) {
//                return false;
//            }
//
//            return solved(root.left, lower, root.val) && solved(root.right, root.val, upper);
//        }
//    }

//    class Solution {
//        long preVal = Long.MIN_VALUE;
//
//        public boolean isValidBST(TreeNode root) {
//            if (root != null) {
//                boolean leftBool = isValidBST(root.left) && root.val > preVal;
//                preVal = root.val;
//                boolean rightBool = isValidBST(root.right);
//
//                return leftBool && rightBool;
//            }
//            return true;
//        }
//    }

    class Solution {
        public boolean isValidBST(TreeNode root) {
            long preVal = Long.MIN_VALUE;
            Deque<TreeNode> stack = new LinkedList<>();

            TreeNode current = root;
            while (!stack.isEmpty() || current != null) {
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
                current = stack.pop();
                if (current.val <= preVal) {
                    return false;
                }
                preVal = current.val;
                current = current.right;
            }
            return true;
        }
    }

    // test
    static class MorrisTraversal {
        public void morrisTraversal(TreeNode root) {
            TreeNode mostRight;
            TreeNode current = root;

            while (current != null) {
                mostRight = current.left;
                if (mostRight != null) {
                    while (mostRight.right != null && mostRight.right != current) {
                        mostRight = mostRight.right;
                    }

                    if (mostRight.right == null) {
                        mostRight.right = current;
                        current = current.left;
                        continue;
                    } else {
                        mostRight.right = null;
                        printNode(current.left);
                    }
                }
                current = current.right;
            }
            printNode(root);
        }

        // 这里搞成单链表的形式逆序输出
        public void printNode(TreeNode node) {
            TreeNode tail = reverseNode(node);
            TreeNode current = tail;
            while (current != null) {
                System.out.println(current.val);
                current = current.right;
            }
            reverseNode(tail);
        }

        public TreeNode reverseNode(TreeNode current) {
            TreeNode preNode = null;
            TreeNode nextNode = null;

            while (current != null) {
                nextNode = current.right;
                current.right = preNode;
                preNode = current;
                current = nextNode;
            }

            return preNode;
        }
    }

    public static void main(String[] args) {
        MorrisTraversal sol = new MorrisTraversal();

        TreeNode node1 = new TreeNode(1, null, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node9 = new TreeNode(9, null, null);
        TreeNode node4 = new TreeNode(4, node3, node5);
        TreeNode node2 = new TreeNode(2, node1, node4);
        TreeNode node8 = new TreeNode(8, node7, node9);
        TreeNode root = new TreeNode(6, node2, node8);

        sol.morrisTraversal(root);
    }
}
