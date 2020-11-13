package com.ahmedhemaz.Algorithms.Graphs.ShortestPath;

import com.ahmedhemaz.DataStructrue.Graphs.directed.Weighted.DirectedEdge;
import com.ahmedhemaz.DataStructrue.Graphs.directed.Weighted.DirectedWeightedGraph;

import java.util.*;

public class Dijkstra<T> {
    private final DirectedWeightedGraph<T> graph;
    private final HashSet<T> visitedVertices;
    private final HashMap<T, Double> distanceTo;
    private final HashMap<T, DirectedEdge<T>> edgeTo;
    private final PriorityQueue<DirectedEdge<T>> edgePriorityQueue;

    public Dijkstra(DirectedWeightedGraph<T> graph, List<T> vertices) {
        this.graph = graph;
        this.visitedVertices = new HashSet<>();
        this.distanceTo = new HashMap<>();
        this.edgeTo = new HashMap<>();
        this.edgePriorityQueue = new PriorityQueue<>();
        this.initializeDistanceTo(vertices);
    }

    public void findShortestPathFrom(T vertex) {
        this.distanceTo.put(vertex, 0.0);
        this.edgePriorityQueue.add(new DirectedEdge<>(vertex, vertex, 0.0));
        while (!this.edgePriorityQueue.isEmpty()) {
            DirectedEdge<T> currentEdge = this.edgePriorityQueue.poll();
            for (DirectedEdge<T> dEdge :
                    this.graph.getAdj(currentEdge.getTo())) {
                relax(dEdge.getFrom());
            }
        }
    }

    private void relax(T vertex) {
        for (DirectedEdge<T> edge :
                this.graph.getAdj(vertex)) {
            Double newDistance = this.distanceTo.get(vertex) + edge.getWeight();
            Double oldDistance = this.distanceTo.get(edge.getTo());
            if(oldDistance > newDistance) {
                this.distanceTo.put(edge.getTo(), newDistance);
                this.edgeTo.put(edge.getTo(), edge);
                if(this.edgePriorityQueue.contains(edge)) {
                    this.edgePriorityQueue.remove(new DirectedEdge<>(vertex, edge.getTo(), newDistance));
                }
                this.edgePriorityQueue.add(new DirectedEdge<>(vertex, edge.getTo(), newDistance));
            }
        }
    }

    private void initializeDistanceTo(List<T> vertices) {
        for (T vertex : vertices) {
            this.distanceTo.put(vertex, Double.POSITIVE_INFINITY);
        }
    }

    public static void main(String[] args) {
        Integer[] integers = {1 ,2, 3, 4, 5, 6, 7};
        DirectedWeightedGraph<Integer> graph = constructIntegerDirectedWeightedGraph();
        Dijkstra<Integer> dijkstra = new Dijkstra<>(graph, Arrays.asList(integers));
        dijkstra.findShortestPathFrom(0);
        for (Map.Entry<Integer, Double> entry :
                dijkstra.distanceTo.entrySet()) {
            System.out.println("Vertex: " + entry.getKey() + " Distance: " + entry.getValue());
        }
        for (Map.Entry<Integer, DirectedEdge<Integer>> entry :
                dijkstra.edgeTo.entrySet()) {
            System.out.println("From: " + entry.getKey() + " Edge: " + entry.getValue().getFrom() + "->" + entry.getValue().getTo());
        }

    }


    public static DirectedWeightedGraph<Integer> constructIntegerDirectedWeightedGraph() {
        Integer[] integers = {0, 1 ,2, 3, 4, 5, 6, 7};
        DirectedWeightedGraph<Integer> integerDirectedWeightedGraph = new DirectedWeightedGraph<>(Arrays.asList(integers));
        integerDirectedWeightedGraph.addEdge(new DirectedEdge<>(0, 1, 5.0));
        integerDirectedWeightedGraph.addEdge(new DirectedEdge<>(0, 4, 9.0));
        integerDirectedWeightedGraph.addEdge(new DirectedEdge<>(0, 7, 8.0));
        integerDirectedWeightedGraph.addEdge(new DirectedEdge<>(1, 2, 12.0));
        integerDirectedWeightedGraph.addEdge(new DirectedEdge<>(1, 3, 15.0));
        integerDirectedWeightedGraph.addEdge(new DirectedEdge<>(1, 7, 4.0));
        integerDirectedWeightedGraph.addEdge(new DirectedEdge<>(2, 3, 3.0));
        integerDirectedWeightedGraph.addEdge(new DirectedEdge<>(2, 6, 11.0));
        integerDirectedWeightedGraph.addEdge(new DirectedEdge<>(3, 6, 9.0));
        integerDirectedWeightedGraph.addEdge(new DirectedEdge<>(4, 5, 4.0));
        integerDirectedWeightedGraph.addEdge(new DirectedEdge<>(4, 6, 20.0));
        integerDirectedWeightedGraph.addEdge(new DirectedEdge<>(4, 7, 5.0));
        integerDirectedWeightedGraph.addEdge(new DirectedEdge<>(5, 2, 1.0));
        integerDirectedWeightedGraph.addEdge(new DirectedEdge<>(5, 6, 13.0));
        integerDirectedWeightedGraph.addEdge(new DirectedEdge<>(7, 5, 6.0));
        integerDirectedWeightedGraph.addEdge(new DirectedEdge<>(7, 2, 7.0));
        return integerDirectedWeightedGraph;
    }

}
