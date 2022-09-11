package com.ahmedhemaz.DataStructrue.UnionFind;

public class RankedCompressedPathUnionFind {
    int[] root;
    int[] rank;
    int count;
    public RankedCompressedPathUnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        count = size;

        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if(x == root[x])
            return x;
        return root[x] = find(root[x]);
    }


    public void union(int x, int y) {
        int rootY = find(y);
        int rootX = find(x);
        if(rootX != rootY) {
            if(this.rank[rootY] > this.rank[rootX]) {
                root[rootY] = rootX;
            }else if(this.rank[rootX] > this.rank[rootY]){
                root[rootX] = rootY;
            }else{
                root[rootX] = rootY;
                rank[rootX]++;
            }
            count--;
        }
    }

    public static void main(String[] args) {
        int[][] edges = new int[][] {{0,1},{1,2},{3,4}};
        int size = 5;
        
        RankedCompressedPathUnionFind rankedCompressedPathUnionFind = new RankedCompressedPathUnionFind(size);
        for (int[] edge : edges) {
            rankedCompressedPathUnionFind.union(edge[0], edge[1]);
        }
        System.out.println(rankedCompressedPathUnionFind.count);
    }
}
