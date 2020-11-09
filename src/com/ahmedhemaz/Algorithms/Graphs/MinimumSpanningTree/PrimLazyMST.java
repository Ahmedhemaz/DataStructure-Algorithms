package com.ahmedhemaz.Algorithms.Graphs.MinimumSpanningTree;

import com.ahmedhemaz.DataStructrue.Graphs.Weighted.Edge;
import com.ahmedhemaz.DataStructrue.Graphs.Weighted.WeightedGraph;

import java.util.*;

public class PrimLazyMST<T> {
    private final PriorityQueue<Edge<T>> edgesPQ;
    private final HashSet<T> visitedVertices;
    private final Queue<Edge<T>> mst;

    public PrimLazyMST(WeightedGraph<T> graph, T initialVertex) {
        this.edgesPQ = new PriorityQueue<>();
        this.visitedVertices = new HashSet<>();
        this.mst = new ArrayDeque<>();
        this.visit(graph, initialVertex);

        while (!this.edgesPQ.isEmpty() && this.mst.size() < graph.getVerticesMap().size() - 1) {
            Edge<T> currentEdge = this.edgesPQ.poll();
            assert currentEdge != null;
            T v = currentEdge.either();
            T w = currentEdge.other(v);
            if (this.visitedVertices.contains(v) && this.visitedVertices.contains(w)) continue;
            this.mst.add(currentEdge);
            if (!this.visitedVertices.contains(v)) this.visit(graph, v);
            if (!this.visitedVertices.contains(w)) this.visit(graph, w);
        }

    }

    private void visit(WeightedGraph<T> graph, T vertex) {
        this.visitedVertices.add(vertex);
        for (Edge<T> edge :
                graph.getVerticesMap().get(vertex)) {
//            if (vertex.equals(7)) {
//                T v = edge.either();
//                T w = edge.other(v);
//                System.out.println("(" + v + ", " + w + ", " + edge.getWeight() + ")");
//
//            }
            if (!this.visitedVertices.contains(edge.other(vertex))) {
                this.edgesPQ.add(edge);
            }
        }
    }

    public Queue<Edge<T>> getMst() {
        return mst;
    }

    public static void main(String[] args) {
        PrimLazyMST<Integer> primLazyMST = new PrimLazyMST<>(constructIntegerWG(), 0);
        for (Edge<Integer> edge:
                primLazyMST.getMst()) {
            int v = edge.either();
            int w = edge.other(v);
            System.out.println("(" + v + ", " + w + ", " + edge.getWeight() + ")");
        }
    }

    public static WeightedGraph<Integer> constructIntegerWG() {
        Integer [] vertices = {0, 1, 2, 3, 4, 5, 6, 7};
        WeightedGraph<Integer> integerWeightedGraph = new WeightedGraph<>(Arrays.asList(vertices));
        integerWeightedGraph.addEdge(new Edge<>(0,7,.16));
        integerWeightedGraph.addEdge(new Edge<>(2,3,.17));
        integerWeightedGraph.addEdge(new Edge<>(1,7,.19));
        integerWeightedGraph.addEdge(new Edge<>(0,2,.26));
        integerWeightedGraph.addEdge(new Edge<>(5,7,.28));
        integerWeightedGraph.addEdge(new Edge<>(1,3,.29));
        integerWeightedGraph.addEdge(new Edge<>(1,5,.32));
        integerWeightedGraph.addEdge(new Edge<>(2,7,.34));
        integerWeightedGraph.addEdge(new Edge<>(4,5,.35));
        integerWeightedGraph.addEdge(new Edge<>(1,2,.36));
        integerWeightedGraph.addEdge(new Edge<>(4,7,.37));
        integerWeightedGraph.addEdge(new Edge<>(0,4,.38));
        integerWeightedGraph.addEdge(new Edge<>(6,2,.40));
        integerWeightedGraph.addEdge(new Edge<>(3,6,.52));
        integerWeightedGraph.addEdge(new Edge<>(6,0,.58));
        integerWeightedGraph.addEdge(new Edge<>(6,4,.93));
        System.out.println(integerWeightedGraph.toString());
        return integerWeightedGraph;
    }
}
