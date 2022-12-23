package TowardsOffer2_Special.day_21_前缀树.code_062_实现前缀树;

/**
 * completion time = 2022.11.1
 */
class Trie {

    Node root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new Node(27);
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node now = root;
        for (int i = 0; i < word.length(); i++) {
            if(now.tree[word.charAt(i)-'a'] == null){
                now.tree[word.charAt(i)-'a'] = new Node(27);
            }
            now = now.tree[word.charAt(i)-'a'];
        }
        now.tree[26] = new Node();
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node now = root;
        for (int i = 0; i < word.length(); i++) {
            if(now.tree[word.charAt(i)-'a'] == null){
                return false;
            }
            now = now.tree[word.charAt(i)-'a'];
        }
        return now.tree[26] != null;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node now = root;
        for (int i = 0; i < prefix.length(); i++) {
            if(now.tree[prefix.charAt(i)-'a'] == null){
                return false;
            }
            now = now.tree[prefix.charAt(i)-'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("apply");
    }

}

class Node{
    Node[] tree;

    public Node() {
        this.tree = new Node[0];
    }

    public Node(int size) {
        this.tree = new Node[size];
    }
}
