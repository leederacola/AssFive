/**
Lab 7 C202
Binary Search Tree Class
Ryan Madden
some provided methods and some created my me.
*/
import java.io.*;
import java.util.*;

public class BinarySearchTree<E extends Comparable<E>> extends AbstractTree<E> {

  protected TreeNode<E> root;
  protected int size = 0;

  /** Create a default binary tree */
  public BinarySearchTree() { }

  /** Create a binary tree from an array of objects */
  public BinarySearchTree(E[] objects) {
    for (int i = 0; i < objects.length; i++)
      insert(objects[i]);
  }

  /** Returns true if the element is in the tree */
  public boolean search(E e) {
    TreeNode<E> current = root; // Start from the root
    while (current != null) {
      if (e.compareTo(current.element) < 0) {
        current = current.left;
      }
      else if (e.compareTo(current.element) > 0) {
        current = current.right;
      }
      else // element matches current.element
        return true; // Element is found
    }
    return false;
  }

  /** Insert element o into the binary tree
   * Return true if the element is inserted successfully. 
   *  Uses an iterative algorithm
   */
  public boolean insert(E e) {
    if (root == null)
      root = createNewNode(e); // Create a new root
    else {
      // Locate the parent node
      TreeNode<E> parent = null;
      TreeNode<E> current = root;
      while (current != null)
        if (e.compareTo(current.element) < 0) {
          parent = current;
          current = current.left;
        }
        else if (e.compareTo(current.element) > 0) {
          parent = current;
          current = current.right;
        }
        else
          return false; // Duplicate node not inserted
          
      // Create the new node and attach it to the parent node
      if (e.compareTo(parent.element) < 0)
        parent.left = createNewNode(e);
      else
        parent.right = createNewNode(e);
    }
    size++;
    return true; // Element inserted
  }

  protected TreeNode<E> createNewNode(E e) {
    return new TreeNode<E>(e);
  }

  /** Inorder traversal from the root*/
  public void inorder() {
    inorder(root);
  }

  /** Inorder traversal from a subtree */
  protected void inorder(TreeNode<E> root) {
    if (root == null) return;
    inorder(root.left);
    System.out.print(root.element + " ");
    inorder(root.right);
  }

   
  /** Postorder traversal from the root */
  public void postorder() {
    postorder(root);
  }

  /** Postorder traversal from a subtree */
  protected void postorder(TreeNode<E> root) {
    if (root == null) return;
    postorder(root.left);
    postorder(root.right);
    System.out.print(root.element + " ");
  }

  /** Preorder traversal from the root */
  public void preorder() {
    preorder(root);
  }

  /** Preorder traversal from a subtree */
  protected void preorder(TreeNode<E> root) {
    if (root == null) return;
    System.out.print(root.element + " ");
    preorder(root.left);
    preorder(root.right);
  }

  /** Inner class tree node */
  public static class TreeNode<E extends Comparable<E>> {
    E element;
    TreeNode<E> left;
    TreeNode<E> right;

    public TreeNode(E e) {
      element = e;
    }
  }

  /** Get the number of nodes in the tree */
  public int getSize() {
    return size;
  }

  /** Returns the root of the tree */
  public TreeNode getRoot() {
    return root;
  }
 //.........................START LAB 7 WORK HERE..................................................
 //.........................START LAB 7 WORK HERE..................................................
 //.........................START LAB 7 WORK HERE..................................................
 //.........................START LAB 7 WORK HERE..................................................
 //.........................START LAB 7 WORK HERE..................................................
    
    /** Returns an ArrayList containing elements in the path from the root leading to  t
     he specified element, returns an empty ArrayList if no  such element exists. */
    public ArrayList<E> path(E e)
    {
        TreeNode<E> current = root;
        ArrayList<E> list = new ArrayList<E>();
        while (current != null)
        {
            if (e.compareTo(current.element) < 0)  //go left
            {
                list.add(current.element);
				//System.out.println("added element " + current.element);
                current = current.left;
            }
            else if (e.compareTo(current.element) > 0)  //go right
            {
                list.add(current.element);
				//System.out.println("added element " + current.element);
                current = current.right;
            }
            else  //(e.compareTo(current.element) == 0)  //found it! stop
            {
				list.add(current.element);
				//System.out.println("added element " + current.element);
				return list;
			}             
        }
		list.clear();
        return list;
    }
	/**
	modifyed path does not clear arraylist in progress if element is not found.
	*/
	    public ArrayList<E> path2(E e)
    {
        TreeNode<E> current = root;
        ArrayList<E> list = new ArrayList<E>();
        while (current != null)
        {
            if (e.compareTo(current.element) < 0)  //go left
            {
                list.add(current.element);
				//System.out.println("added element " + current.element);
                current = current.left;
            }
            else if (e.compareTo(current.element) > 0)  //go right
            {
                list.add(current.element);
				//System.out.println("added element " + current.element);
                current = current.right;
            }
            else  //(e.compareTo(current.element) == 0)  //found it! stop
            {
				list.add(current.element);
				//System.out.println("added element " + current.element);
				return list;
			}             
        }
		//list.clear();
        return list;
    }

    /** Returns the number of leaf nodes in this tree, returns 0 if tree is empty
     leaf = current left and right are both null.*/
    public int getNumberOfLeaves()
    {
        TreeNode<E> current = root;
        int count = getNumberOfLeaves(current);
        return count;
    }
    
    /** Returns the number of leaf nodes in this tree, returns 0 if tree is empty
     leaf = current left and right are both null.*/
    protected int getNumberOfLeaves(TreeNode<E> current)
    {
        // base case
        if(current.left == null && current.right == null)
        {
            return 1;
        }
        else if (current.left == null && current.right != null)
        {
            current = current.right;
            return getNumberOfLeaves(current);
        }
        else if (current.right == null && current.left != null)
        {
            current = current.left;
            return getNumberOfLeaves(current);
        }
        else
        {
            return getNumberOfLeaves(current.left) + getNumberOfLeaves(current.right);
        }
        
    }

    
    /* Returns an ArrayList containing all element	in preorder of the specified 
	* element’s left sub-tree, returns an empty ArrayList if no such element exists. 
	* Preorder traversal from the root == 1) process  2) rec left 3) rec right
	* -----This traverses to node left of key element, then calls with TreeNode
	*/
	public ArrayList<E> leftSubTree(E e)
	{
	ArrayList<E> list = new ArrayList<E>();
	TreeNode<E> current = root; // Start from the root
	System.out.println("start!"); 	
	while (current != null) 
	{
		if (e.compareTo(current.element) < 0) 
		{
			//System.out.println("going left");
			current = current.left;
		}
		else if (e.compareTo(current.element) > 0) 
		{
			//System.out.println("going right");
			current = current.right;
		}	
		else if (e.compareTo(current.element) == 0)
		{
			System.out.println("Made it to element " + current.element + " here is left sub"); // now go left because LEFT sub tree
			current = current.left;  // we now have root of left sub tree.....do preorder now!
			return subTree(current);
		}
		else	// element not here exit loop return empty
			break;
	}
		return list;		
	}
	 /* Returns an ArrayList containing all element	in preorder of the specified 
	* element’s left sub-tree, returns an empty ArrayList if no such element exists. 
	* Preorder traversal from the root == 1) process  2) rec left 3) rec right
	* -----This traverses to node left of key element, then calls with TreeNode
	*/
	public ArrayList<E> rightSubTree(E e)
	{
	ArrayList<E> list = new ArrayList<E>();
	TreeNode<E> current = root; // Start from the root
	System.out.println("start!"); 	
	while (current != null) 
	{
		if (e.compareTo(current.element) < 0) 
		{
			//System.out.println("going left");
			current = current.left;
		}
		else if (e.compareTo(current.element) > 0) 
		{
			//System.out.println("going right");
			current = current.right;
		}	
		else if (e.compareTo(current.element) == 0)
		{
			System.out.println("Made it to element " + current.element + " here is right sub"); // now go left because LEFT sub tree
			current = current.right;  // we now have root of left sub tree.....do preorder now!
			return subTree(current);
		}
		else	// element not here exit loop return empty
			break;
	}
		return list;		
	}
	
	
	/** Sub Tree Method--Preorder
	* returns array list
	*/
    protected ArrayList<E> subTree(TreeNode<E> n)
	{
	ArrayList<E> list = new ArrayList<E>();
	list.add(n.element);
	if(n.left != null) 
	{
	list.addAll(subTree(n.left));
	}
	if (n.right != null)
	{
		list.addAll(subTree(n.right));
	}
	return list;
    }
	
    
    /* Same see canvas............*/
	
	public boolean sameTree(BinarySearchTree<E> tree2)
	{
		return sameTree(this.root, tree2.root);
	}
	
	protected boolean sameTree(TreeNode<E> root1, TreeNode<E> root2)
	{
		if (root1 == null && root2 == null)
		{
			//System.out.println("both null");
			return true;
		}
		else if (root1 != null || root2 != null)
		{
			//System.out.println("do we get here?");
			//System.out.println(" root1 e = " + root1.element + " root 2 e " + root2.element);
			return ((root1.element == root2.element) && sameTree(root1.right, root2.right) && sameTree(root1.left, root2.left)); 	
		}
		else
		{
			System.out.println("falied equals method");
			return false;
			
		}		
		//return true;
	}
	/*
	1. If both trees are empty then return 1.
	2. Else If both trees are non -empty
		(a) Check data of the root nodes (tree1.data ==  tree2.data)
		(b) Check left subtrees recursively  i.e., call sameTree(tree1.left_subtree, tree2.left_subtree)
		(c) Check right subtrees recursively  i.e., call sameTree(tree1.right_subtree, tree2.right_subtree)
		(d) If a,b and c are true then return true.
	3  Else return false (one is empty and other is not)
    
	public int sameTree(BinarySearchTree tree1, BinarySearchTree tree2)
	{
	if (tree1.root == null && tree2.root == null)
		return 1;
	
	}
    */
//.........................................................END LAB..................................................
//.........................................................END LAB..................................................
//.........................................................END LAB..................................................
//.........................................................END LAB..................................................
//.........................................................END LAB..................................................
//.........................................................END LAB..................................................
//.........................................................END LAB..................................................


  /** Delete an element from the binary tree.
   * Return true if the element is deleted successfully
   * Return false if the element is not in the tree */
  public boolean delete(E e) {
    // Locate the node to be deleted and also locate its parent node
    TreeNode<E> parent = null;
    TreeNode<E> current = root;
    while (current != null) {
      if (e.compareTo(current.element) < 0) {
        parent = current;
        current = current.left;
      }
      else if (e.compareTo(current.element) > 0) {
        parent = current;
        current = current.right;
      }
      else
        break; // Element is in the tree pointed by current
    }
    if (current == null)
      return false; // Element is not in the tree
    // Case 1: current has no left children
    if (current.left == null) {
      // Connect the parent with the right child of the current node
      if (parent == null) {
         root = current.right;
      }
      else {
        if (e.compareTo(parent.element) < 0)
          parent.left = current.right;
        else
          parent.right = current.right;
      }
    }
    else {
      // Case 2 & 3: The current node has a left child
      // Locate the rightmost node in the left subtree of
      // the current node and also its parent
      TreeNode<E> parentOfRightMost = current;
      TreeNode<E> rightMost = current.left;

      while (rightMost.right != null) {
        parentOfRightMost = rightMost;
        rightMost = rightMost.right; // Keep going to the right
      }
      // Replace the element in current by the element in rightMost
      current.element = rightMost.element;
      
      // Eliminate rightmost node
      if (parentOfRightMost.right == rightMost)
        parentOfRightMost.right = rightMost.left;
      else
        // Special case: parentOfRightMost == current
        parentOfRightMost.left = rightMost.left;
    }
    size--;
    return true; // Element inserted
  }
  
  /** Obtain an iterator. Use inorder. */
  public java.util.Iterator iterator() {
    return inorderIterator();
  }

  /** Obtain an inorder iterator */
  public java.util.Iterator inorderIterator() {
    return new InorderIterator();
  }

  // Inner class InorderIterator
  class InorderIterator implements java.util.Iterator {
    // Store the elements in a list
    private java.util.ArrayList<E> list = new java.util.ArrayList<E>();
    private int current = 0; // Point to the current element in list

    public InorderIterator() {
      inorder(); // Traverse binary tree and store elements in list
    }

    /** Inorder traversal from the root*/
    private void inorder() {
      inorder(root);
    }

    /** Inorder traversal from a subtree */
    private void inorder(TreeNode<E> root) {
      if (root == null)return;
      inorder(root.left);
      list.add(root.element);
      inorder(root.right);
    }

    /** Next element for traversing? */
    public boolean hasNext() {
      if (current < list.size())
        return true;
      return false;
    }

    /** Get the current element and move cursor to the next */
    public Object next() {
      return list.get(current++);
    }

    /** Remove the current element and refresh the list */
    public void remove() {
      delete(list.get(current)); // Delete the current element
      list.clear(); // Clear the list
      inorder(); // Rebuild the list
    }
  }

  /** Remove all elements from the tree */
  public void clear() {
    root = null;
    size = 0;
  }

	}   
    
    

