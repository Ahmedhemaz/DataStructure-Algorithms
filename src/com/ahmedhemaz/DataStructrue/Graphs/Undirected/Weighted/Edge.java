package com.ahmedhemaz.DataStructrue.Graphs.Undirected.Weighted;

public class Edge<T> implements Comparable<Edge<T>> {
    private final Double weight;
    private final T v;
    private final T w;

    public Edge(T v, T w, Double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public T either() {
        return this.v;
    }

    public T other(T vertex) {
        if(vertex == this.v) return this.w;
        return this.v;
    }

    public Double getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Edge<T> thatEdge) {
        if (this.weight > thatEdge.weight) return 1;
        else if (this.weight < thatEdge.weight) return -1;
        else return 0;
    }
}
