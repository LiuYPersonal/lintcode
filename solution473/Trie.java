package solution473;

class TrieNode {
    // Initialize your data structure here.
	private TrieNode[] children;
	boolean hasWord;
    public TrieNode() {
    	this.children=new TrieNode[26];
    	this.hasWord=false;
    }
    public void insert(String word, int index){
    	if(index==word.length()){
    		this.hasWord=true;
    		return;
    	}
    	int tmp=word.charAt(index)-'a';
    	if(children[tmp]==null){
    		children[tmp]=new TrieNode();
    	}
    	children[tmp].insert(word, index+1);
    	return;
    }
    
    public TrieNode search(String word, int index) {
    	if(index==word.length()){
    		return this;
    	}
    	int tmp=word.charAt(index)-'a';
    	if(children[tmp]!=null){
    		return children[tmp].search(word, index+1);
    	}
    	return null;
    }
}
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root.insert(word, 0);
        return;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode tmp=root.search(word, 0);
        if(tmp!=null && tmp.hasWord){
        	return true;
        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	TrieNode tmp=root.search(prefix, 0);
    	if(tmp!=null){
    		return true;
    	}
    	return false;
    }
    
    public static void main(String[] args) {
    	Trie trie = new Trie();
    	System.out.println(trie.search("lintcode"));
    	System.out.println(trie.startsWith("lint"));
    	trie.insert("lintcode");
    	System.out.println(trie.search("lintcode")); 
    	System.out.println(trie.startsWith("linterror"));
    }
}
