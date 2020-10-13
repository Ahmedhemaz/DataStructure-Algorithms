package com.ahmedhemaz.DataStructrue.Trees.BST;

public class BST {
    private class Node<T> {
         T data;
         Node<T> left, right;
        public Node(T data){
            this.data = data;
            this.left = this.right = null;
        }
    }
}
