import java.util.*;
import java.io.*;
/**
Lab 7 main mehtod for testing Binary Search Tree Class
Ryan Madden
*/

public class TestBinarySearchTree
{

  public static void main(String[] args)
  {
    TestBinarySearchTree test = new TestBinarySearchTree();
	
    // make int array to pass to BST constructor
	Integer[] num = {67, 87, 55, 43, 48, 73, 91, 39, 59, 92, 34, 95, 81, 66, 40, 53, 84, 77};
    BinarySearchTree<Integer> tree = new BinarySearchTree<>(num);
    String[] words = {"s", "f", "g", "w", "z", "c", "h", "r", "t", "a", "l"};
    BinarySearchTree<String> tree2 = new BinarySearchTree<>(words);
	System.out.println();
	System.out.println("TEST INSERT METHOD............................");
	System.out.println("searching for 91 then 47");
	System.out.println(tree.search(91));
	System.out.println(tree.search(47));
	System.out.println("adding 47");
	System.out.println(tree.insert(47));
	System.out.println("search 47 again....");
	System.out.println(tree.search(47));
	System.out.println();
	System.out.println("Tree post order");
	tree.postorder();
	System.out.println();
	System.out.println("Tree pre order");
	tree.preorder();
	System.out.println();
	System.out.println("Tree in order");
	tree.inorder();
	System.out.println();
	System.out.println("delete....48");
	System.out.println(tree.delete(48));
	System.out.println("Tree in order");
	tree.inorder();
	System.out.println();
	System.out.println();
	System.out.println();
	//String tree
	System.out.println("Tree2  String Tree..........................");
	System.out.println("searching for a then d");
	System.out.println(tree2.search("a"));
	System.out.println(tree2.search("d"));
	System.out.println("adding d");
	System.out.println(tree2.insert("d"));
	System.out.println("search d again....");
	System.out.println(tree2.search("d"));
	System.out.println();
	System.out.println("Tree post order");
	tree2.postorder();
	System.out.println();
	System.out.println("Tree pre order");
	tree2.preorder();
	System.out.println();
	System.out.println("Tree in order");
	tree2.inorder();
	System.out.println();
	System.out.println("delete....t");
	System.out.println(tree2.delete("t"));
	System.out.println("Tree in order");
	tree2.inorder();
	System.out.println();
	System.out.println();
	System.out.println();
	
	//.....Number of Leaves...............................
	System.out.println("..............Number of Leaves...........................");
	System.out.println("number of leaves in tree");
	System.out.println(tree.getNumberOfLeaves());
	System.out.println("number of leaves in tree2");
	System.out.println(tree2.getNumberOfLeaves());
	
    
	//......Path to key..........................
	System.out.println(".........Path to Element E................................");
	int path = 59;
	System.out.println("Finding path to " + path);
    ArrayList<Integer> list = tree.path(path);
	System.out.println(Arrays.toString(list.toArray()));
	int path2 = 999;
	System.out.println("Finding path to " + path2);
    ArrayList<Integer> list2 = tree.path(path2);
	System.out.println(Arrays.toString(list2.toArray()));
	
	
	
	//......Sub Tree Left..........................................
	System.out.println(".............Left Sub Tree Pre Order.......55 & 999............................");
	ArrayList<Integer> lefty = tree.leftSubTree(55);
	System.out.println(Arrays.toString(lefty.toArray()));
	ArrayList<Integer> lefty1 = tree.leftSubTree(999);
	System.out.println(Arrays.toString(lefty1.toArray()));
	
	
	
	//......Sub Tree Left..........................................
	System.out.println(".............Rught Sub Tree Pre Order.......87 & 999............................");
	ArrayList<Integer> righty = tree.rightSubTree(87);
	System.out.println(Arrays.toString(righty.toArray())); 
	ArrayList<Integer> righty1 = tree.rightSubTree(999);
	System.out.println(Arrays.toString(righty1.toArray()));	
	
	System.out.println("......................sameTree method.................");
	Integer[] numSame = {67, 87, 55, 43, 48, 73, 91, 39, 59, 92, 34, 95, 81, 66, 40, 53, 84, 77};
    BinarySearchTree<Integer> treeSame = new BinarySearchTree<>(numSame);
		Integer[] numSame2 = {67, 87, 55, 43, 48, 73, 91, 39, 59, 92, 34, 95, 81, 66, 40, 53, 84, 77};
    BinarySearchTree<Integer> treeSame2 = new BinarySearchTree<>(numSame2);
	System.out.println(treeSame.sameTree(treeSame2));
	//..............................................................................
	System.out.println("both null.....................................................................................");
	Double[] doubleArray = {};
	BinarySearchTree<Double> doubletree  = new BinarySearchTree<>(doubleArray);
	System.out.println(doubletree.sameTree(doubletree)); 
    
    System.out.println("with same string tree.....................................................................................");
   	System.out.println(tree2.sameTree(tree2));
	    
    System.out.println("with same string tree.....................................................................................");
  
    String[] letters = {"a", "s", "r", "d"};
	BinarySearchTree<String> Stree  = new BinarySearchTree<>(letters);  
	System.out.println(tree2.sameTree(Stree));
	
	
	
	Integer[] rrrrrrrr = {22,17,};
    BinarySearchTree<Integer> poop = new BinarySearchTree<>(rrrrrrrr);
	poop.preorder();
	System.out.println();
	poop.postorder();
  }
}  
	
/**   Program Out Put
    
TEST INSERT METHOD............................
searching for 91 then 47
true
false
adding 47
true
search 47 again....
true

Tree post order
34 40 39 47 53 48 43 66 59 55 77 84 81 73 95 92 91 87 67 
Tree pre order
67 55 43 39 34 40 48 47 53 59 66 87 73 81 77 84 91 92 95 
Tree in order
34 39 40 43 47 48 53 55 59 66 67 73 77 81 84 87 91 92 95 
delete....48
true
Tree in order
34 39 40 43 47 53 55 59 66 67 73 77 81 84 87 91 92 95 


Tree2  String Tree..........................
searching for a then d
true
false
adding d
true
search d again....
true

Tree post order
a d c l r h g f t z w s 
Tree pre order
s f c a d g h r l w t z 
Tree in order
a c d f g h l r s t w z 
delete....t
true
Tree in order
a c d f g h l r s w z 


..............Number of Leaves...........................
number of leaves in tree
7
number of leaves in tree2
4
.........Path to Element E................................
Finding path to 59
[67, 55, 59]
Finding path to 999
[]
.............Left Sub Tree Pre Order.......55 & 999............................
start!
Made it to element 55 here is left sub
[43, 39, 34, 40, 47, 53]
start!
[]
.............Rught Sub Tree Pre Order.......87 & 999............................
start!
Made it to element 87 here is right sub
[91, 92, 95]
start!
[]
......................sameTree method.................
true
both null.....................................................................................
true
with same string tree.....................................................................................
true
with same string tree.....................................................................................
false
*/

      

