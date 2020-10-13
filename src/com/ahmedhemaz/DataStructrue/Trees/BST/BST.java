package com.ahmedhemaz.DataStructrue.Trees.BST;

public class BST<T extends Comparable<T>> {

    private BinaryTreeNode<T> root;
    private Integer size;

    public BST(){
        this.root = null;
        this.size = 0;
    }

    class BinaryTreeNode<T> {
         T data;
         BinaryTreeNode<T> left, right;
        public BinaryTreeNode(T data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    private void add(T data, BinaryTreeNode<T> node) {
        // if data bigger or equal to our node data then go right
        if (data.compareTo(node.data) >= 0) {
            if (node.right == null){
                node.right = new BinaryTreeNode<>(data);
                return;
            }
            add(data, node.right);
        }
        // if data less than out node data then go left
        // we can neglect this if condition as we covered bigger or equal with the last if
        // we leave it here for demonstration purposes
        if (data.compareTo(node.data) < 0) {
            if (node.left == null) {
                node.left = new BinaryTreeNode<>(data);
                return;
            }
            add(data, node.left);
        }
    }

    // we don't provide client to manipulate with our nodes so we provide this public method
    // to add data to our BST
    public void add(T data) {
         if (data == null) throw new IllegalArgumentException();
         if (this.root == null) {
             this.root = new BinaryTreeNode<>(data);
         }else{
             this.add(data, this.root);
         }
         this.size++;
    }
}
