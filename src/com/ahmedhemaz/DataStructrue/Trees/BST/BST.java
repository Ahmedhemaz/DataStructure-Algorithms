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

    public boolean contains(T data) {
        if (data == null) throw new IllegalArgumentException();
        return contains(data, this.root);
    }

    public T getSuccessor() {
        return this.getSuccessor(root).data;
    }

    public T getPredecessor() {
        return  this.getPredecessor(root).data;
    }

    public Integer size() {
        return this.size;
    }

    public void remove(T data) {
        root = remove(data, this.root);
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

    private boolean contains(T data, BinaryTreeNode<T> node) {

        // if node is null then it's not found
        if (node == null) return false;

        // if data equals our node data then return true
        if (data.compareTo(node.data) == 0) return true;

        // if data bigger than node data then go right
        if (data.compareTo(node.data) > 0){
            return contains(data, node.right);
        }

        // if data less than node data then go left
        return contains(data, node.left);
    }

    private BinaryTreeNode<T> remove(T data, BinaryTreeNode<T> node) {

        // if node is null then the tree is empty or there is no need to travers more
        if (node == null) return null;

        // if the value of the data being searched for is less than the value of the current root node, then
        // traverse to the left node of the current root, setting the current left node to whatever gets returned
        // from the delete method
        else if (data.compareTo(node.data) < 0 ) {
            node.left = remove(data, node.left);
        }

        // if the value of the data being searched for is greater than the value of the current root node, then
        // traverse to the right node of the current root, setting the current right node to whatever gets returned
        // from the delete method
        else if (data.compareTo(node.data) > 0) {
            node.right = remove(data, node.right);
        }

        // we found our node lets delete it
        else {
            if (isLeafNode(node)) {
                return null;
            }
            if (isNodeWithOneChild(node)) {
                if (node.right == null) return node.left;
                if (node.left == null) return node.right;
            }
            // get the successor
            BinaryTreeNode<T> successor = getSuccessor(node);
            // set node data to successor data
            node.data = successor.data;
            // as the successor will be at the left of our node then we need to delete it
            // as it would be with the same data as our node
            node.left = remove(node.data, node.left);
        }
        return node;
    }

    private boolean isLeafNode(BinaryTreeNode<T> node) {
        return node.left == null && node.right == null;
    }
    private boolean isNodeWithOneChild(BinaryTreeNode<T> node) {
        return node.right != null || node.left != null;
    }

    private BinaryTreeNode<T> getSuccessor(BinaryTreeNode<T> node) {
        node = node.left;
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    private BinaryTreeNode<T> getPredecessor(BinaryTreeNode<T> node) {
        node = node.right;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }



    public static void main(String[] args) {
        BST<Integer> integerBST = new BST<>();
        integerBST.add(10);
        integerBST.add(15);
        integerBST.add(6);
        integerBST.add(4);
        integerBST.add(8);
        integerBST.add(12);
        integerBST.add(20);
        integerBST.remove(6);
//        System.out.println(integerBST.getSuccessor());
//        System.out.println(integerBST.getPredecessor());
    }
}
