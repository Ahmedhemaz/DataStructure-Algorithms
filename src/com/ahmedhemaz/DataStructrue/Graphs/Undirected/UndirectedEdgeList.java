package com.ahmedhemaz.DataStructrue.Graphs.Undirected;

import java.util.ArrayList;
import java.util.List;

public class UndirectedEdgeList<T> {

    private List<T> verticesList;
    private List<Edge> edgesList;

    public UndirectedEdgeList() {
        this.verticesList = new ArrayList<>();
        this.edgesList = new ArrayList<>();
    }

    public UndirectedEdgeList(List<T> vertices){
        this.verticesList = new ArrayList<>();
        this.edgesList = new ArrayList<>();
        for (T vertex :
                vertices) {
            this.addVertex(vertex);
        }
    }

    public void addVertex(T vertex) {
        this.verticesList.add(vertex);
    }

    public void addEdge(T from, T to) {
        Edge newEdge = new Edge(this.verticesList.indexOf(from), this.verticesList.indexOf(to));
        for (Edge edge :
                edgesList) {
            if (edge.compareTo(newEdge) == 0 || edge.compareTo(newEdge) < 0) return;
        }
        this.edgesList.add(newEdge);
    }

    private static class Edge implements Comparable<Edge> {
        Integer start;
        Integer end;
        public Edge(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Edge edge) {
            if (edge.start.equals(this.start) && edge.end.equals(this.end)) return 0; // same (0,1) (0,1)
            if (edge.start.equals(this.end) && edge.end.equals(this.start)) return -1; // same but reversed (0,1) (1,0)
            else return 1;
        }
    }

    public static void main(String[] args) {
        UndirectedEdgeList<Integer> edgeList = new UndirectedEdgeList<>();
        for (int i = 0; i < 10; i++) {
            edgeList.addVertex(i);
        }
        edgeList.addEdge(0,1);
        edgeList.addEdge(1,0);
        edgeList.addEdge(2,0);
        for (Edge edge :
                edgeList.edgesList) {
            System.out.println(edge.start + "-" + edge.end);
        }
        System.out.println(edgeList.edgesList.size());
    }
}
