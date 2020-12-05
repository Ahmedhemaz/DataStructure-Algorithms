package com.ahmedhemaz.DataStructrue.Tries;

import java.util.NoSuchElementException;

public class RWayTrie<T> {
    private final static int R = 265;
    private Node root = new Node();

    private static class Node {
        private Object value;
        private final Node[] next = new Node[R];
    }

    public void put(String key, T val) {
        this.root = put(root, key, val, 0);
    }

    public boolean contains(String key) {
        return this.get(key) != null;
    }

    public void delete(String key) {
        this.delete(root, key, 0);
    }

    public T get(String key) {
        Node x = this.get(root, key, 0);
        if (x == null) return null;
        return (T) x.value;
    }

    private Node put(Node x, String key, T val, int d) {
        if(x == null) x = new Node();
        if(d == key.length()) {
            x.value = val;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d+1);
        return x;
    }

    private Node get(Node x, String key, int d) {
        if(x == null) return null;
        if(d == key.length()) return x;
        char c = key.charAt(d);
        return this.get(x.next[c], key, d+1);
    }

    private Node delete(Node x, String key, int d) {
        if (x == null) return null;
        if(d == key.length()) {
            x.value = null;
        }else {
            char c = key.charAt(d);
            x.next[c] = this.delete(x.next[c], key, d+1) ;
        }
        // remove subtrie rooted at x if it is completely empty
        if (x.value != null) return x;
        for (char c = 0; c < R; c++)
            if (x.next[c] != null) return x;
        return null;
    }

    public static void main(String[] args) {
        RWayTrie<Boolean> trie = new RWayTrie<>();
        trie.put("ahmed", true);
        trie.put("aml", true);
        trie.put("mohamed", true);
        trie.put("ibrahim", true);
        trie.put("ahm", true);
        trie.delete("ahm");
        System.out.println(trie.get("ahmed"));
    }


}
