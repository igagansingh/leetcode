class Trie {

    /**
    * Trie is a prefix-tree data structure used to search words and find if a prefix exists or not.
    * Implementation:
    * 1. Have a data structure which has 2 members and 2 functions
    *     i. An array of this data structure, generally length is 26 each indicating an alphabet 
    *    ii. A boolean indicating end of the word
    *   iii. get function
    *    iv. put function
    */
    class TrieNode {
        private TrieNode[] links;
        private final int R=26;
        private boolean isEnd;
        
        public TrieNode() {
            links=new TrieNode[R];
        }
        
        public boolean containsKey(char ch) {
            return links[ch-'a']!=null;
        }
        
        public TrieNode get(char ch) {
            return links[ch-'a'];
        }
        
        public void put(char ch, TrieNode node) {
            links[ch-'a']=node;
        }
        
        public void setEnd() {
            isEnd=true;
        }
        
        public boolean isEnd() {
            return isEnd;
        }
    }
    
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root=new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode temp=root;
        for(char c: word.toCharArray()) {
            if(!temp.containsKey(c)) temp.put(c, new TrieNode());
            temp=temp.get(c);
        }
        temp.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode temp=root;
        for(char c: word.toCharArray()) {
            if(temp.containsKey(c)) temp=temp.get(c);
            else return false;
        }
        return temp.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode temp=root;
        for(char c: prefix.toCharArray()) {
            if(temp.containsKey(c)) temp=temp.get(c);
            else return false;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */