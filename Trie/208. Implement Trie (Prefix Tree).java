class Trie {
    TrieNode trieNode;

    public Trie() {
        trieNode = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode trieNode = this.trieNode;

        for(char c: word.toCharArray()){
            if(trieNode.children[c - 'a']== null){
                trieNode.children[c-'a'] = new TrieNode();
            }
            trieNode = trieNode.children[c-'a'];
        }

        trieNode.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode trieNode = this.trieNode;

         for(char c: word.toCharArray()){
            if(trieNode.children[c - 'a']== null){
                return false;
            }
            trieNode = trieNode.children[c-'a'];
        }
        return trieNode.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode trieNode = this.trieNode;
        String word = prefix;

         for(char c: word.toCharArray()){
            if(trieNode.children[c - 'a']== null){
                return false;
            }
            trieNode = trieNode.children[c-'a'];
        }
        return true;
    }

    private class TrieNode{
        boolean isEnd = false;
        TrieNode[] children;

        public TrieNode(){
            children = new TrieNode[26];
        }
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
