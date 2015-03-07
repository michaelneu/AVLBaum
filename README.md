# AVLBaum
This project is a sample project of how to implement an AVL binary search tree using Java in a simple programming environment like BlueJ. 

-------


###Using as a library
* Data can be added by implementing the ```IData``` interface
* ```BinaryTree``` is a basic binary search tree, which inserts elements in a sorted manner
* ```AVLTree``` is the self balancing binary search tree using different rotations to ensure AVL properties

###Pre- and post-balance
In order to show the difference between insertions/deletions and how they impact the structure of the tree, it is reccommended to have a ```BinaryTree``` object and a ```AVLTree``` object. The ```BinaryTree``` class allows you to load JSON-like data as the tree's content. 

```java
  // ...
  
  // convert the avl tree into a Object[] representation using { self, leftSubTree, rightSubtree }
  Object[] json = avl.toJSON(); 
  
  // load the representation
  bst.fromJSON(json);
  
  // insertion
  bst.Insert(data);
  avl.Insert(data);
  
  // show differences in output
  System.out.println("After inserting '" + data.toString() + "': ");
  System.out.println(TreeVisualizer.Encode(bst.toJSON()));
  
  System.out.println("After balancing: ");
  System.out.println(TreeVisualizer.Encode(avl.toJSON()));
  
  // ...
```
