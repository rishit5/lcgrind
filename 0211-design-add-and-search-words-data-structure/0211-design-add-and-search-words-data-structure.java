class WordDictionary {

    class TrieNode {
        public static final int N = 26;
        public TrieNode[] nodes = new TrieNode[N];
        public boolean isEnd = false;
    }

    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = this.root;
        for (int i = 0; i < word.length(); i++) {
            if (curr.nodes[word.charAt(i) - 'a'] == null) {
                curr.nodes[word.charAt(i) - 'a'] = new TrieNode();
            }
            curr = curr.nodes[word.charAt(i) - 'a'];
        }
        curr.isEnd = true;
    }

    private boolean search(String word, int idx, TrieNode curr) {
        if (idx == word.length()) {
            return curr.isEnd;
        }
        if (word.charAt(idx) == '.') {
                for (int j = 0; j < 26; j++) {
                    if (curr.nodes[j] != null && search(word, idx + 1, curr.nodes[j])) {
                        return true;
                    }
                }
        } else if (curr.nodes[word.charAt(idx) - 'a'] != null) {
            return search(word, idx + 1, curr.nodes[word.charAt(idx) - 'a']);
        }
        return false;
    }
    
    public boolean search(String word) {
        TrieNode curr = this.root;
        return search(word, 0, curr);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */