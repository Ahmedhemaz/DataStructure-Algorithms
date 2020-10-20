# Graph Definitions:

## Graph terminology:

- Path: Sequence of vertices connected by edges.
- Cycle: Path whose first and last vertices are the same.
- dense: a graph with many edges is dense 
    - a graph is dense in which |e| = O(|v^2|)
- sparse: a graph with relatively few edges is sparse
    - a graph is sparse in which |e| = O(|v|)

    **Two vertices are connected if there is a path between them.**
___
 ## Graph Representation: 
 1. [Edge List](#Edge-List)
 2. [Adjacency Matrix](#Adjacency-Matrix)
 3. [Adjacency List](#Adjacency-List)
 
___
## Edge List:

 - create edge type class with two points start, end

 - we present an array of vertices, an array of edges
    
        verteciesList = [0,1,2,3,4,5,6,7,8,9]
        edgesList = [(0,1), (1,2), (0,2) , .....]
 - **As we implement Edge List for undirected graph we need to add edges with no Repetition [UndirectedEdgeList](https://github.com/Ahmedhemaz/DataStructure-Algorithms/blob/main/src/com/ahmedhemaz/DataStructrue/Graphs/Undirected/UndirectedEdgeList.java)**

 ### **Cost**:
 - #### **Time Complexity**: 
    - O(|E|) for simple Graph with no parallel edges
    - O(|v(v-1)|) for directed with multi edges 
    - O(|v(v-1) / 2|) for undirected with multi edges 
    - O(|E|) for add edges if we want no repetition , O(1) with Repetition
 - #### **Space complexity**:
    - ##### **Undirected**:
        - O(|v|) for verticesList
        - O(|e|) for edgesList or  O(|v(v-1) / 2|) for multi edges
    - ##### **Directed**:
        - O(|v|) for verticesList
        - O(|e|) for edgesList or O(|v(v-1)|) for multi edges

**Note: Edge List is not efficent to represent graph**
___

## Adjacency Matrix: 
- create verticesList 
- create a (boolean/integer) matrix of size "verticesList"
- as we want to connect two vertices

  1- we look for the index of two vertices in verticesList ( i, j )

  2- we mark them as connected by making 

        matrix[i][j] = matrix[j][i] = true
- **Adjacency Matrix implementation [AdjacencyMatrix](https://github.com/Ahmedhemaz/DataStructure-Algorithms/blob/main/src/com/ahmedhemaz/DataStructrue/Graphs/Undirected/AdjacencyMatrix.java)**
### **Cost**:
 - #### **Time Complexity**: 
    - finding adjacent nodes O(|V|) 
    - finding if two nodes are connected 
      - if we have the indices O(1)
      - if we have the names/values we need to search for their indices with O(|V|)
      then we check the adjacency matrix in constant time O(1)
      so the total time complexity would be O(|V|)

      **Note**: "**we can improve linear search time by using HashMap<Name/value, index> instead of List of vertices to get the indices in constant time**"
 - #### **Space complexity**:
    - O(V^2) space as a trade off to improve time complexity

**Note: Adjacency Matrix is good for dense graphs not sparse graphs as we will use alot of wasted extra space**
___
## Adjacency List: 
- to solve unused space in Adjacency matrix as most of graphs are sparse graphs
we can store edges only 
- we can implement Adjacency List using List of vertices pointing to another (Array, LinkedList)
  - **verticesList with edges Array** 
       
        [0] -> [1,2]
        [1] -> [2,3]
        [2] -> [0]
        [3] -> [1,2,0]
    as we adding new edges exceeding the size of edges array we will create new array with new size, then copy all old elements to the new array, then add the new edge. However we can use linkedList to improve addtion and deletion performance 
  - **verticesList with edges LinkedList**

        [0] -> 1-> 2
        [1] -> 2-> 3
        [2] -> 0
        [3] -> 1-> 2-> 0
  - **vertices Hashmap with edges LinkedList**
    - as using verticesList if we don't have the index we will search for the value of vertex (linear search) then we access it's edges as improvement we can use Hashmap for vertices so we can get it in constant time O(1)

            ['A'] -> 'B'-> 'c'
            ['B'] -> 'C'-> 'D'
            ['C'] -> 'A'
            ['D'] -> 'B'-> 'C'-> 'A'

- **Adjacency List Hashmap/LinkedList implementation [AdjacencyList](https://github.com/Ahmedhemaz/DataStructure-Algorithms/blob/main/src/com/ahmedhemaz/DataStructrue/Graphs/Undirected/AdjacencyList.java)**
### **Cost**:
 - #### **Time Complexity**: 
    - finding adjacent nodes O(|V|) 
    - finding if two nodes are connected O(|V|)
    - add Edge O(1)
    - remove Edge O(|V|) 
        - iterate over adjacent till we find the node we want to remove from the linkedList then remove the vertex from edge Linkedlist
 - #### **Space complexity**:
    - O(|V| + |E|)

**Note: Adjacency List is used for sparse graphs**
___