# Graph Definitions:

## Graph terminology:

- Path: Sequence of vertices connected by edges.
- Cycle: Path whose first and last vertices are the same.

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
___
