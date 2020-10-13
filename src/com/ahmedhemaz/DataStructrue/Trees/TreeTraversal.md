# Tree Traversal

1. [Pre order traversal](#Pre-order-traversal)
2. [In order traversal](#In-order-traversal)
3. [Post order traversal](#Post-order-traversal) 
4. [Breadth First traversal/ Level Order](#Breadth-First-traversal/-Level-Order)

## Pre order traversal
___
1. visit root
2. visit left
3. visit right

### tree representation
___

                                         1
                                       /   \
                                      /     \
                                     /       \
                                    /         \
                                   /           \
                                  /             \
                                 2               9
                                / \             / \
                               /   \           /   \
                              /     \         /     \
                             3       6      10      13
                            /\       /\     /\       /\
                           /  \     /  \   /  \     /  \
                          4    5   7    8 11  12   14  15
## In order traversal
___
1. visit left
2. visit root
3. visit right

### tree representation
___
                                         8
                                       /   \
                                      /     \
                                     /       \
                                    /         \
                                   /           \
                                  /             \
                                 4              12
                                / \             / \
                               /   \           /   \
                              /     \         /     \
                             2       6       10     14
                            /\       /\     /\       /\
                           /  \     /  \   /  \     /  \
                          1    3   5    7 9   11   13   15

# Important note:
- for every tree there are two important nodes 

  1. In order successor "Largest thing smaller than the root" -> 7
  2. In order predessor "smallest thing larger than the root" -> 9
  
## Post order traversal
___
1. visit left
2. visit right
3. visit root

### tree representation
___
                                         15
                                       /   \
                                      /     \
                                     /       \
                                    /         \
                                   /           \
                                  /             \
                                 7              14
                                / \             / \
                               /   \           /   \
                              /     \         /     \
                             3       6       10      13
                            /\       /\     /\       /\
                           /  \     /  \   /  \     /  \
                          1    2   4    5 8    9   11  12

## Breadth First traversal/ Level Order
___

- Traversal By Tree levels

### tree representation
___
                                         1
                                       /   \
                                      /     \
                                     /       \
                                    /         \
                                   /           \
                                  /             \
                                 2               3
                                / \             / \
                               /   \           /   \
                              /     \         /     \
                             4       5       6       7
                            /\       /\     /\       /\
                           /  \     /  \   /  \     /  \
                          8    9   10  11 12  13   14  15
