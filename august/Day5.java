class WordDictionary {

    class TrieNode {
        private int R = 26;
        private TrieNode[] links;
        private boolean isEnd;
        
        public TrieNode() {
            links = new TrieNode[R];
        }
        
        public boolean isEnd() {
            return isEnd;
        }
        
        public void setEnd() {
            isEnd=true;
        }
        
        public boolean contains(char ch) {
            return links[ch-'a']!=null;
        }
        
        public TrieNode get(char ch) {
            return links[ch-'a'];
        }
        
        public void put(char ch, TrieNode node) {
            links[ch-'a']=node;
        }
    }
    
    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root=new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode temp=root;
        for(char c: word.toCharArray()) {
            if(!temp.contains(c)) temp.put(c, new TrieNode());
            temp=temp.get(c);
        }
        temp.setEnd();
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. 
    * Idea:
    * Have a recursive function which:
    * 1. goes from character by character (referenced by an index) of the word
    * 2. if the index equals word length, we have gone through the word now check the latest trie node if it is the end or not
    * 3. else 2 cases are possible
    *   i. if the character is '.' then loop through the entire possible tries characters and recursively call the function for the next character
    *  ii. else find the trie of the given character and recursively call this function for next character
    */
    public boolean search(String word) {
        TrieNode temp=root;
        return containsWord(word, temp, 0);
    }
    
    private boolean containsWord(String word, TrieNode trie, int i) {
        if(i==word.length()) return trie.isEnd();
        
        if(word.charAt(i)=='.') {
            for(int j=0; j<26;j++) {
                char c=(char)((int)'a'+j);
                if(trie.contains(c) && containsWord(word, trie.get(c), i+1)) {
                    return true;
                }
            }
            return false;
        } else {
            return trie.contains(word.charAt(i)) && containsWord(word, trie.get(word.charAt(i)), i+1);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */