package leetcode.Vol101to200;

import commonutils.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode105 {
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int l, int r, int[] inorder, int ll, int rr) {
        if (l > r) {
            return null;
        }

        int inIndex = inorderIndexMap.get(preorder[l]);
        int len = inIndex - ll;
        TreeNode node = new TreeNode(preorder[l]);
        node.left = buildTree(preorder, l + 1, l + len, inorder, ll, inIndex - 1);
        node.right = buildTree(preorder, l + len + 1, r, inorder, inIndex + 1, rr);

        return node;
    }
}
