public class Trie<T> {

    /** root */
    private TrieNode<T> root;


    // this gets to a new node
    public Trie() {
        this.root = new TrieNode<>();
    }


    /**
     * Takes a String and returns the appropriate trieNode
     */
    private TrieNode<T> getNode(String s) {
        char[] array = s.toCharArray();
        TrieNode<T> node = root;
        for (int i = 0; i < array.length; i++) {
            node = node.getChild(array[i]);
        }
        return node;
    }


    /**
     * Gets the data of the TrieNode currently stored in
     * */
    public T get(String s) {
        return getNode(s).getData();
    }


    /**
     * It sets the data currently stored in the TrieNode
     */
    public void put(String s, T t) {
        getNode(s).setData(t);
    }
}
