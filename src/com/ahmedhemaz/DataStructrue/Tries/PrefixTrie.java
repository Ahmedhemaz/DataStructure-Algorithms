package com.ahmedhemaz.DataStructrue.Tries;

import java.util.*;

public class PrefixTrie {
    class Node{
        Character ch;
        TreeMap<Character, Node> childs;
        Node parent;
        boolean endOfWord;
        Node(Character ch){
            this.ch = ch;
            this.childs = new TreeMap<>();
        }
        Node(){
            this.childs = new TreeMap<>();
        }
    }

    private final Node root;
    private  List<Node> wordsFinalNode;
    public PrefixTrie(){
        root = new Node();
        wordsFinalNode = new ArrayList<>();
    }

    public void addWord(String str){
        this.addWord(str, this.root, 0);
    }

    public void printTrie(){
        this.printTrie(this.root);
    }

    public List<String> suggestSearch(String str, int limit){
        List<String> result = new ArrayList<>();
        List<Node> wordsFinalNode = new ArrayList<>();
        Queue<Node> q = new ArrayDeque<>();
        System.out.println(dfs(str, this.root,0));
        return null;
    }

    private boolean dfs(String str, Node node, int pos){
        if (pos == str.length())
            return node.endOfWord;
        char ch = str.charAt(pos);
        if (node.childs.containsKey(ch))
            return dfs(str, node.childs.get(ch), pos+1);
        else
            return node.endOfWord;
    }

    private void dfs(Node node){
        if (this.wordsFinalNode.size() == 3)
            return;
        if (node.endOfWord){
            this.wordsFinalNode.add(node);
        }
            for (Node n :
                    node.childs.values()) {
                    dfs(n);
            }

    }

    private void dfsSuggestion(String str, Node node, int pos){
        if (pos == str.length()) {
            dfs(node);
            return;
        }
        char ch = str.charAt(pos);
        if (node.childs.containsKey(ch))
            dfsSuggestion(str, node.childs.get(ch), pos+1);
    }

    private void printTrie(Node node){
        if (!node.childs.isEmpty()){
            for (Node cn :
                    node.childs.values()) {
                if (cn.endOfWord && this.wordsFinalNode.size() < 3)
                    wordsFinalNode.add(cn);
                System.out.print(cn.ch);
                printTrie(cn);
            }
            System.out.println();
        }
    }

    private void addWord(String str, Node node,int pos){
        if (pos == str.length()){
            node.endOfWord = true;
            return;
        }
        char ch = str.charAt(pos);
        if (node.childs.containsKey(ch))
            this.addWord(str, node.childs.get(ch), pos+1);
        else{
            Node newNode = new Node(ch);
            newNode.ch = ch;
            newNode.parent = node;
            node.childs.put(ch, newNode);
        }

        this.addWord(str, node.childs.get(ch), pos+1);
    }

    private String buildStringFromLastNode(Node node, StringBuilder sb){
        if (node.parent != null){
            sb.append(node.ch);
            this.buildStringFromLastNode(node.parent, sb);
        }else{
            return  sb.reverse().toString();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        PrefixTrie pft = new PrefixTrie();
        pft.addWord("ahmed");
        pft.addWord("aml");
        pft.addWord("mobile");
        pft.addWord("monitor");
        pft.addWord("mouse");
        pft.addWord("mousepad");
        pft.addWord("moneypot");
        pft.addWord("bags");
        pft.addWord("baggage");
        pft.addWord("banner");
        pft.addWord("box");
        pft.addWord("cloths");
        pft.dfsSuggestion("bag", pft.root, 0);
//        System.out.println(pft.wordsFinalNode);
//        pft.suggestSearch("mousepad",3);
//        pft.printTrie();
        for (Node node :
                pft.wordsFinalNode) {
            System.out.println(pft.buildStringFromLastNode(node, new StringBuilder()));;
        }
//        System.out.println("monitor".compareTo("moneypot") );
    }

}
