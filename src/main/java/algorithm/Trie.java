package algorithm;

public class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode('#');
    }

    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int u = word.charAt(i) - 'a';
            if (p.child[u] == null) {
                p.child[u] = new TrieNode(word.charAt(i));
            }
            p = p.child[u];
        }
        p.isEndingChar = true;
    }

    public boolean search(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int u = word.charAt(i) - 'a';
            if (p.child[u] == null) {
                return false;
            }
            p = p.child[u];
        }

        return p.isEndingChar;
    }

    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (int i = 0; i < prefix.length(); i++) {
            int u = prefix.charAt(i) - 'a';
            if (p.child[u] == null) {
                return false;
            }
            p = p.child[u];
        }
        return true;
    }

    public static class TrieNode {
        char data;
        TrieNode[] child;
        boolean isEndingChar;

        TrieNode(char data) {
            this.data = data;
            this.child = new TrieNode[26];
            this.isEndingChar = false;
        }
    }

    public static void main(String[] args) {
        Trie tr = new Trie();

        tr.insert("aaaaa");
        System.out.println(tr.search("aa"));
        System.out.println(tr.startsWith("aa"));

        System.out.println(tr.search("aaaaa"));
    }
}
