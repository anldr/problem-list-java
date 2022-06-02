package algorithm;

public class SegementTree {
    public SegementTree() {
    }

    public void pushUp(SegementTreeNode node) {
        node.sum = node.lNode.sum + node.rNode.sum;
    }

    public void pushDown(SegementTreeNode node) {
        if (node.lazy != 0) {
            updateVal(node.lNode, node.lazy);
            updateVal(node.rNode, node.lazy);
            node.lNode.lazy += node.lazy;
            node.rNode.lazy += node.lazy;
            node.lazy = 0;
        }
    }

    public void updateVal(SegementTreeNode node, long val) {
        node.sum = node.sum + (node.rRng - node.lRng + 1) * val;
        node.lazy += val;
    }

    public void buildTree(SegementTreeNode node, int l, int r, int[] arr) {
        node.lRng = l;
        node.rRng = r;
        if (l == r) {
            node.sum = arr[l];
        } else {
            int mid = (l + r) >> 1;
            node.lNode = new SegementTreeNode();
            buildTree(node.lNode, l, mid, arr);
            node.rNode = new SegementTreeNode();
            buildTree(node.rNode, mid+1, r, arr);
            pushUp(node);
        }
    }

    public void modifyRange(SegementTreeNode node, int l, int r, long val) {
        int lRng = node.lRng;
        int rRng = node.rRng;
        if (l <= lRng && rRng <= r) {
            updateVal(node, val);
        } else {
            pushDown(node);
            int mid = (lRng + rRng) >> 1;
            if (mid >= l) {
                modifyRange(node.lNode, l, r, val);
            }
            if (r > mid) {
                modifyRange(node.rNode, l, r, val);
            }
            pushUp(node);
        }
    }

    public long query(SegementTreeNode node, int l, int r) {
        long ans = 0;
        int lRng = node.lRng;
        int rRng = node.rRng;
        if (l <= lRng && rRng <= r) {
            ans = node.sum;
        } else {
            pushDown(node);
            int mid = (lRng + rRng) >> 1;
            if (mid >= l) {
                ans = ans + query(node.lNode, l, r);
            }
            if (r > mid) {
                ans = ans + query(node.rNode, l, r);
            }
            pushUp(node);
        }
        return ans;
    }

    public static class SegementTreeNode {
        long sum = 0, lazy = 0;
        int lRng = -1, rRng = -1;
        SegementTreeNode lNode = null, rNode = null;

        // long sum, long lazy, int lRng, int rRng, SegementTreeNode lNode, SegementTreeNode rNode
        public SegementTreeNode() {
        }
    }

    public static void main(String[] args) {
        SegementTree tr = new SegementTree();
        SegementTreeNode root = new SegementTreeNode();

        int[] arr = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        tr.buildTree(root, 0, 9, arr);

        System.out.println(tr.query(root, 0, 2));

        tr.modifyRange(root, 0, 2, 3);
        System.out.println(tr.query(root, 0, 2));

        System.out.println(tr.query(root, 0, 3));
    }
}
