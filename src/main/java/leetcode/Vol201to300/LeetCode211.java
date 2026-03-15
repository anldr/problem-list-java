package leetcode.Vol201to300;

public class LeetCode211 {
     class WordDictionary {
        private TrieNode root;

        public WordDictionary() {
            this.root = new TrieNode('#');
        }

        public void addWord(String word) {
            TrieNode pt = root;
            char[] wordChars = word.toCharArray();
            for (char ch : wordChars) {
                int idx = ch - 'a';
                if (pt.child[idx] == null) {
                    pt.child[idx] = new TrieNode(ch);
                }
                pt = pt.child[idx];
            }
            pt.isEnding = true;
        }

        public boolean search(String word) {
            return dfs(0, word, this.root);
        }

        private boolean dfs(int index, String word, TrieNode pt) {
            if (index == word.length()) {
                return pt.isEnding;
            }

            char ch = word.charAt(index);
            if (ch != '.') {
                TrieNode nextPt = pt.child[ch - 'a'];
                if (nextPt != null && dfs(index + 1, word, nextPt)) {
                    return true;
                }
            } else {
                for (char i = 'a'; i <= 'z'; i++) {
                    TrieNode nextPt = pt.child[i - 'a'];
                    if (nextPt != null && dfs(index + 1, word, nextPt)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public class TrieNode {
            char ch;
            TrieNode[] child;
            Boolean isEnding;

            public TrieNode(char ch) {
                this.ch = ch;
                child = new TrieNode[26];
                this.isEnding = false;
            }
        }
    }
}
