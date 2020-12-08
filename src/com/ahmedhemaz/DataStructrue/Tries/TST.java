package com.ahmedhemaz.DataStructrue.Tries;

public class TST<Value> {

    private Node root;

    private class Node {
        private Value value;
        private char aChar;
        private Node left, right, mid;
    }

    public void put(String key, Value value) {
        root = this.put(this.root, key, value, 0);
    }

    public boolean contains(String key) {
        return this.get(key) != null;
    }

    public Value get(String key) {
        if (key.length() == 0) throw new IllegalArgumentException("Empty String");
        Node x = this.get(this.root, key, 0);
        return  x == null ? null : x.value;
    }

    public void delete(String key) {
        this.delete(root, key, 0);
    }

    private Node put(Node x, String key, Value value, int index) {
        char c = key.charAt(index);
        if(x == null) {
            x = new Node();
            x.aChar = c;
        }
        if (c < x.aChar) x.left = this.put(x.left, key, value, index);
        else if (c > x.aChar) x.right = this.put(x.right, key, value, index);
        else if (index < key.length() - 1) x.mid = this.put(x.mid, key, value, index + 1);
        else x.value = value;
        return x;
    }

    private Node get(Node x, String key, int index) {
        char c = key.charAt(index);
        if(x == null) return null;
        if (c < x.aChar) return this.get(x.left, key, index);
        else if (c > x.aChar) return this.get(x.right, key, index);
        else if (index < key.length() - 1) return this.get(x.mid, key, index + 1);
        else return x;
    }

    private Node delete(Node x, String key, int index) {
        char c = key.charAt(index);
        if ( x == null) return null;
        if (c < x.aChar) x.left = this.delete(x.left, key, index);
        else if (c > x.aChar) x.right = this.delete(x.right, key, index);
        else if (index < key.length() - 1) x.mid = this.delete(x.mid, key, index + 1);
        else x.value = null;
        if (this.isLeaf(x) && x.value == null) {
            x = null;
        }
        return x;
    }

    private boolean isLeaf(Node x) {
        return x.left == null && x.right == null && x.mid == null;
    }

    public static void main(String[] args) {
        TST<Boolean> trie = new TST<>();
        trie.put("she", true);
        trie.put("sells", true);
        trie.put("sea", true);
        trie.put("shells", true);
        trie.put("by", true);
        trie.put("the", true);
        trie.put("sea", true);
        trie.put("shore", true);
        trie.delete("she");
        System.out.println(trie.get("she"));
    }

}
