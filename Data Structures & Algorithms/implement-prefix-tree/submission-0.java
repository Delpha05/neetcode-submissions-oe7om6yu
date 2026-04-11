class TrieNode {
    public Map<Character, TrieNode> children;
    public boolean isEndOfWord;

    public TrieNode(){
        this.children = new HashMap<>();
        this.isEndOfWord = false;
    }
}
class PrefixTree {
    private TrieNode root;
    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
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
        for(char c : word.toCharArray()){
            if(curr.children.containsKey(c)){
                curr = curr.children.get(c);
            } else {
                return false;
            }
        }
        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
         for(char c : prefix.toCharArray()){
            if(curr.children.containsKey(c)){
                curr = curr.children.get(c);
            } else {
                return false;
            }
        }
        return true;
    }
}
