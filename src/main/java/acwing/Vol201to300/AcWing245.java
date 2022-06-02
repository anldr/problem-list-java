package acwing.Vol201to300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AcWing245 {
    public static void pushUp(SegementTreeNode node) {
        node.sum = node.lNode.sum + node.rNode.sum;
        node.prefixSumMax = Math.max(node.lNode.prefixSumMax, node.lNode.sum + node.rNode.prefixSumMax);
        node.suffixSumMax = Math.max(node.rNode.suffixSumMax, node.rNode.sum + node.lNode.suffixSumMax);
        node.ans = Math.max(Math.max(node.lNode.ans, node.rNode.ans), node.lNode.suffixSumMax + node.rNode.prefixSumMax);
    }

    public static void pushDown(SegementTreeNode node) {
    }

    public static void updateVal(SegementTreeNode node, long val) {
        node.sum = val;
        node.ans = val;
        node.prefixSumMax = val;
        node.suffixSumMax = val;
    }

    public static void buildTree(SegementTreeNode node, int l, int r, int[] arr) {
        node.lRng = l;
        node.rRng = r;
        if (l == r) {
            node.sum = arr[l];
            node.ans = arr[l];
            node.prefixSumMax = arr[l];
            node.suffixSumMax = arr[l];
        } else {
            int mid = (l + r) >> 1;
            node.lNode = new SegementTreeNode();
            buildTree(node.lNode, l, mid, arr);
            node.rNode = new SegementTreeNode();
            buildTree(node.rNode, mid+1, r, arr);
            pushUp(node);
        }
    }

    public static void modifyRange(SegementTreeNode node, int l, int r, long val) {
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

    public static SegementTreeNode query(SegementTreeNode node, int l, int r) {
        int lRng = node.lRng;
        int rRng = node.rRng;
        if (l <= lRng && rRng <= r) {
            return node;
        } else {
            int mid = (lRng + rRng) >> 1;
            SegementTreeNode retA = new SegementTreeNode();
            SegementTreeNode retB = new SegementTreeNode();
            SegementTreeNode retC = new SegementTreeNode();
            retA.ans = retA.sum = retA.prefixSumMax = retA.suffixSumMax = -(1 << 30);
            retB.ans = retB.sum = retB.prefixSumMax = retB.suffixSumMax = -(1 << 30);
            if (mid >= l) {
                retA = query(node.lNode, l, r);
                retC.sum += retA.sum;
            }
            if (r > mid) {
                retB = query(node.rNode, l, r);
                retC.sum += retB.sum;
            }
            retC.ans = Math.max(Math.max(retA.ans, retB.ans), retA.suffixSumMax + retB.prefixSumMax);
            retC.prefixSumMax = Math.max(retA.prefixSumMax, retA.sum + retB.prefixSumMax);
            if (l > mid) {
                retC.prefixSumMax = Math.max(retC.prefixSumMax, retB.prefixSumMax);
            }
            retC.suffixSumMax = Math.max(retB.suffixSumMax, retB.sum + retA.suffixSumMax);
            if (mid >= r) {
                retC.suffixSumMax = Math.max(retC.suffixSumMax, retA.suffixSumMax);
            }
            return retC;
        }
    }

    public static class SegementTreeNode {
        long ans = 0, sum = 0;
        long prefixSumMax = 0, suffixSumMax = 0;
        int lRng = -1, rRng = -1;
        SegementTreeNode lNode = null, rNode = null;

        // long sum, long lazy, int lRng, int rRng, SegementTreeNode lNode, SegementTreeNode rNode
        public SegementTreeNode() {
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String[] params = buf.readLine().split(" ");

        int n = Integer.parseInt(params[0]);
        int m = Integer.parseInt(params[1]);

        int[] arr = new int[n + 1];
        params = buf.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(params[i-1]);
        }

        SegementTreeNode tr = new SegementTreeNode();

        buildTree(tr, 1, n, arr);

        for (int i = 0; i < m; i++) {
            params = buf.readLine().split(" ");
            int op = Integer.parseInt(params[0]);
            int x = Integer.parseInt(params[1]), y = Integer.parseInt(params[2]);
            if (op == 1) {
                if (x > y) {
                    x = x ^ y;
                    y = x ^ y;
                    x = x ^ y;
                }
                System.out.println(query(tr, x, y).ans);
            } else {
                modifyRange(tr, x, x, y);
            }
        }
    }
}
