class TrieNode {
    public Map<Character, TrieNode> children;
    public boolean isEndOfWord;

    public TrieNode(){
        this.children = new HashMap<>();
        this.isEndOfWord = false;
    }
}
class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(!curr.children.containsKey(c)){
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        return dfs(word, 0,curr);
    }

    private boolean dfs(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.isEndOfWord;
        }

        char c = word.charAt(index);

        if (c != '.') {
            if (!node.children.containsKey(c)) {
                return false;
            }
            return dfs(word, index + 1, node.children.get(c));
        }

        // '.' case
        for (TrieNode child : node.children.values()) {
            if (dfs(word, index + 1, child)) {
                return true;
            }
        }

        return false;
    }
}
