package leetcode.Vol101to200;

import java.util.*;

public class LeetCode133 {
    public Node cloneGraph(Node node) {
        if (Objects.isNull(node)) {
            return node;
        }

        Map<Integer, Node> copyMap = new HashMap<>();
        return dfsCopy(node, copyMap);
    }

    private Node dfsCopy(Node node, Map<Integer, Node> copyMap) {
        ArrayList<Node> neighbors = new ArrayList<>();
        Node copyNode = new Node(node.val, neighbors);

        copyMap.put(node.val, copyNode);

        if (Objects.nonNull(node.neighbors) && !node.neighbors.isEmpty()) {
            for (Node next : node.neighbors) {
                Node exist = copyMap.getOrDefault(next.val, null);
                if (exist != null) {
                    neighbors.add(exist);
                } else {
                    Node xx = dfsCopy(next, copyMap);
                    neighbors.add(xx);
                }
            }
        }

        return copyNode;
    }

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
