package com.ahmedhemaz.DataStructrue.Tries;

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

    public static void main(String[] args) {
        RWayTrie<Boolean> trie = new RWayTrie<>();
        trie.put("ahmed", true);
        trie.put("aml", true);
        trie.put("mohamed", true);
        trie.put("ibrahim", true);
        trie.put("ahm", true);
        System.out.println(trie.get("ah"));
    }


}
