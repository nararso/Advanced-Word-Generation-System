    // storing the current value
public class TrieNode<T> {
    private T data;
    private TrieNode<T>[] child;

    /**
     * storing the children of this node and this array is filled with 26 nulls
     */
    public TrieNode() {
        this.data = null;
        this.child = new TrieNode[26];
    }

    /**
     * This method gets the data
     */
    public T getData() {
        return data;
    }

    /**
     * This method sets the data
     */
    public void setData(T data) {
        this.data = data;
    }


    /**
     * method that returns the TrieNode with given letter
     */
    public TrieNode<T> getChild(char letter) {
        if (!Character.isLowerCase(letter)) {
            return null;
        }
        if (child[Character.getNumericValue(letter) - 10] == null) {
            TrieNode<T> node = new TrieNode<>();
            child[Character.getNumericValue(letter) - 10] = node;
            return node;
        } else {
            return child[Character.getNumericValue(letter) - 10];
        }
    }
}
