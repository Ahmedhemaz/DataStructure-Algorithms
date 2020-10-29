package com.ahmedhemaz.DataStructrue.Graphs.directed;


public class DirectedAdjacencyMatrix<T> {
    private T[] verticesList;
    private boolean[][] adjacencyMatrix;

    public DirectedAdjacencyMatrix(int size, T [] verticesList) {
        this.verticesList =(T[]) new Object[size];
        this.adjacencyMatrix =  new boolean[size][size];
        this.fillVerticesList(verticesList);
    }

    public void addEdge(T from, T to) {
        int fromIndex = this.indexOf(from);
        int toIndex = this.indexOf(to);
        if (fromIndex == -1 || toIndex == -1) throw new IllegalArgumentException("Vertex Not Exists");
        this.adjacencyMatrix[fromIndex][toIndex] = true;
    }

    public void fillVerticesList(T [] arr) {
        System.arraycopy(arr, 0, this.verticesList, 0, arr.length);
    }

    public int indexOf(T vertex) {
        for (int i = 0; i < this.verticesList.length; i++) {
            if (vertex.equals(this.verticesList[i])) {
                return i;
            }
        }
        return -1;
    }

    public T getVertexOfIndex(int index) {
        return this.verticesList[index];
    }

    public boolean[][] getAdjacencyMatrix() {
        return this.cloneOf(this.adjacencyMatrix);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("   0------1------2------3------4------5------6------7");
        stringBuilder.append('\n');
        for (int i = 0; i < this.adjacencyMatrix.length; i++) {
            stringBuilder.append(i).append("|");
            for (int j = 0; j < this.adjacencyMatrix.length; j++) {
                stringBuilder.append(this.adjacencyMatrix[i][j]);
                if (this.adjacencyMatrix[i][j]) {
                    stringBuilder.append("  |");
                }else {
                    stringBuilder.append(" |");
                }
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }

    private boolean[][] cloneOf(boolean[][] matrix) {
        boolean[][] matrixCopy = new boolean [matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            boolean[] aMatrix = matrix[i];
            int aLength = aMatrix.length;
            matrixCopy[i] = new boolean [aLength];
            System.arraycopy(aMatrix, 0, matrixCopy[i], 0, aLength);
        }
        return matrixCopy;
    }

    public static void main(String[] args) {
        Character[] characters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        DirectedAdjacencyMatrix<Character> characterAdjacencyMatrix = new DirectedAdjacencyMatrix<>(8, characters);
        characterAdjacencyMatrix.addEdge('A','B');
        characterAdjacencyMatrix.addEdge('A','C');
        characterAdjacencyMatrix.addEdge('A','D');
        characterAdjacencyMatrix.addEdge('B','F');
        characterAdjacencyMatrix.addEdge('B','E');
        characterAdjacencyMatrix.addEdge('C','G');
        characterAdjacencyMatrix.addEdge('G','H');
        characterAdjacencyMatrix.addEdge('D','H');
        characterAdjacencyMatrix.addEdge('E','H');
        characterAdjacencyMatrix.addEdge('F','H');
        System.out.println(characterAdjacencyMatrix.toString());
    }
}
