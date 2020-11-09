package com.ahmedhemaz.Algorithms.Graphs.MinimumSpanningTree;

import com.ahmedhemaz.DataStructrue.Graphs.Weighted.Edge;
import com.ahmedhemaz.DataStructrue.Graphs.Weighted.WeightedGraph;
import com.ahmedhemaz.DataStructrue.UnionFind.WeightedQuickUnionUF;

import java.util.*;

public class KruskalMST {
    private final Queue<Edge<Integer>> mst;
    private final PriorityQueue<Edge<Integer>> edgePriorityQueue;
    private final WeightedQuickUnionUF weightedQuickUnionUF;

    public KruskalMST(WeightedGraph<Integer> graph) {
        this.mst = new ArrayDeque<>();
        this.edgePriorityQueue = new PriorityQueue<>();
        this.weightedQuickUnionUF = new WeightedQuickUnionUF(graph.getVerticesMap().size());

        this.edgePriorityQueue.addAll(graph.getEdgeList());

        while (!this.edgePriorityQueue.isEmpty() && mst.size() < graph.getVerticesMap().size() - 1) {
            Edge<Integer> edge = this.edgePriorityQueue.poll();
            assert edge != null;
            int v = edge.either();
            int w = edge.other(v);
            if(!weightedQuickUnionUF.connected(v,w)){
                weightedQuickUnionUF.union(v,w);
                this.mst.add(edge);
            }
        }
    }

    public Queue<Edge<Integer>> getMst() {
        return mst;
    }

    public static void main(String[] args) {
        KruskalMST kruskalMST = new KruskalMST(constructIntegerWG());
        for (Edge<Integer> edge:
             kruskalMST.getMst()) {
            int v = edge.either();
            int w = edge.other(v);
            System.out.println("(" + v + ", " + w + ", " + edge.getWeight() + ")");
        }

    }

    public static WeightedGraph<Integer> constructIntegerWG() {
        Integer [] vertices = {0, 1, 2, 3, 4, 5, 6, 7};
        WeightedGraph<Integer> integerWeightedGraph = new WeightedGraph<>(Arrays.asList(vertices));
        integerWeightedGraph.addEdge(new Edge<Integer>(0,7,.16));
        integerWeightedGraph.addEdge(new Edge<Integer>(2,3,.17));
        integerWeightedGraph.addEdge(new Edge<Integer>(1,7,.19));
        integerWeightedGraph.addEdge(new Edge<Integer>(0,2,.26));
        integerWeightedGraph.addEdge(new Edge<Integer>(5,7,.28));
        integerWeightedGraph.addEdge(new Edge<Integer>(1,3,.29));
        integerWeightedGraph.addEdge(new Edge<Integer>(1,5,.32));
        integerWeightedGraph.addEdge(new Edge<Integer>(2,7,.34));
        integerWeightedGraph.addEdge(new Edge<Integer>(4,5,.35));
        integerWeightedGraph.addEdge(new Edge<Integer>(1,2,.36));
        integerWeightedGraph.addEdge(new Edge<Integer>(4,7,.37));
        integerWeightedGraph.addEdge(new Edge<Integer>(0,4,.38));
        integerWeightedGraph.addEdge(new Edge<Integer>(6,2,.40));
        integerWeightedGraph.addEdge(new Edge<Integer>(3,6,.52));
        integerWeightedGraph.addEdge(new Edge<Integer>(6,0,.58));
        integerWeightedGraph.addEdge(new Edge<Integer>(6,4,.93));
        return integerWeightedGraph;
    }
}
