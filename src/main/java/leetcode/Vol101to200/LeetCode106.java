package leetcode.Vol101to200;

import commonutils.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode106 {
    private Map<Integer, Integer> inIndexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inIndexMap.put(inorder[i], i);
        }

        return buildTree(postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] postorder, int inL, int inR, int poL, int poR) {
        if (inL > inR) {
            return null;
        }

        int index = inIndexMap.get(postorder[poR]);
        int len = index - inL;
        TreeNode node = new TreeNode(postorder[poR]);
        node.left = buildTree(postorder, inL, index - 1, poL, poL + len - 1);
        node.right = buildTree(postorder, index + 1, inR, poL + len, poR - 1);

        return node;
    }
}
