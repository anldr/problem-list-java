package algorithm_template;

import java.util.LinkedList;
import java.util.Queue;

public class AcAutomaton {
    private final AcNode root;

    public AcAutomaton() {
        root = new AcNode('#');
    }

    public void insert(String word) {
        AcNode p = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            int u = word.charAt(i) - 'a';
            if (p.child[u] == null) {
                p.child[u] = new AcNode(word.charAt(i));
            }
            p = p.child[u];
        }
        p.len = len;
        p.isEndingChar = true;
    }

    /**
     * text是主串
     */
    public void match(String text) {
        int len = text.length();
        AcNode p = root;
        for (int i = 0; i < len; ++i) {
            int u = text.charAt(i) - 'a';
            while (p.child[u] == null && p != root) {
                // 失败指针发挥作用的地方
                p = p.failPtr;
            }
            p = p.child[u];
            if (p == null) {
                // 如果没有匹配的，从root开始重新匹配
                p = root;
            }
            AcNode tmp = p;
            // 打印出可以匹配的模式串
            while (tmp != root) {
                if (tmp.isEndingChar) {
                    int pos = i-tmp.len+1;
                    System.out.println("Begin Idx:" + pos + ", lenght:" + tmp.len);
                }
                tmp = tmp.failPtr;
            }
        }
    }

    /**
     * 构建失败指针
     */
    public void buildFailurePointer() {
        Queue<AcNode> queue = new LinkedList<>();
        root.failPtr = null;
        queue.add(root);
        while (!queue.isEmpty()) {
            AcNode parent = queue.remove();
            for (int i = 0; i < 26; ++i) {
                AcNode pChild = parent.child[i];
                if (pChild == null) continue;
                if (parent == root) {
                    pChild.failPtr = root;
                } else {
                    AcNode q = parent.failPtr;
                    while (q != null) {
                        AcNode qc = q.child[pChild.data - 'a'];
                        if (qc != null) {
                            pChild.failPtr = qc;
                            break;
                        }
                        q = q.failPtr;
                    }
                    if (q == null) {
                        pChild.failPtr = root;
                    }
                }
                queue.add(pChild);
            }
        }
    }

    public static class AcNode {
        // 当isEndingChar=true时，记录data长度
        int len;
        // 模式串的字符
        char data;

        AcNode failPtr;
        AcNode[] child;
        boolean isEndingChar;

        public AcNode(char data) {
            this.len = -1;
            this.data = data;
            this.child = new AcNode[26];
            this.failPtr = null;
            this.isEndingChar = false;
        }
    }

    public static void main(String[] args) {
        AcAutomaton acTree = new AcAutomaton();

        acTree.insert("abcd");
        acTree.insert("bcd");
        acTree.insert("c");

        acTree.buildFailurePointer();

        acTree.match("bcfabcd");
    }
    /* output :
        Begin Idx:1, lenght:1
        Begin Idx:5, lenght:1
        Begin Idx:3, lenght:4
        Begin Idx:4, lenght:3
     */
}