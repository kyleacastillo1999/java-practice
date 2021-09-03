package com.practice.week2;

/**
 * A binary tree that utilizes 
 * @author castl
 *
 */
public class BinaryTree {
	
	public Node root;
	
	public BinaryTree() {
		super();
	}
	public BinaryTree(Node root) {
		this.root = root;
	}

	public Node getRoot() {
		return root;
	}
	
	public void setRoot(Node root) {
		this.root = root;
	}
	
	/**
	 * Utility function to return the height of a given node.
	 * @param n the node in question
	 * @return the height of the node or 0 if the node is null.
	 */
	public int getNodeHeight(Node n) {
		return n == null ? 0 : n.height;
	}
	
	/**
	 * Performs a right rotate on the subtree rooted with a node.
	 * @param y The node that needs to be rotated
	 * @return A newly rotated node.
	 */
	public Node rightRotate(Node y) {
		Node x = y.left;
		Node T2 = x.right;
		
		// Rotation
		x.right = y;
		y.left = T2;
		
		y.height = Math.max(getNodeHeight(y.left), getNodeHeight(y.right)) + 1;
		x.height = Math.max(getNodeHeight(x.left), getNodeHeight(x.right)) + 1;
		
		// Return the new root
		return x;
	}
	
	/**
	 * Performs a left rotate on the subtree rooted with a node.
	 * @param x The node that needs to be rotated
	 * @return A newly rotated node.
	 */
	public Node leftRotate(Node x) {
		Node y = x.right;
		Node T2 = y.left;
		
		// Rotation
		x.right = T2;
		y.left = x;
		
		y.height = Math.max(getNodeHeight(y.left), getNodeHeight(y.right)) + 1;
		x.height = Math.max(getNodeHeight(x.left), getNodeHeight(x.right)) + 1;
		
		// Return the new root
		return y;
	}
	
	public int getBalanceFactor(Node N) {
		return N == null ? 0 : getNodeHeight(N.left) - getNodeHeight(N.right); 
	}
	
	Node insert(Node node, int data) {
		// Normal insertion
		if(node == null)
			return (new Node(data));
		
		if(data < node.data)
			node.left = insert(node.left, data);
		else if(data > node.data)
			node.right = insert(node.right, data);
		else // No duplicates allowed
			return node;
		
		// Update the height of this ancestor node
		node.height = 1 + Math.max(getNodeHeight(node.left), getNodeHeight(node.right));
		
		// Check the balance factor
		int balance = getBalanceFactor(node);
		
		// Check to see if its balance or one of the 4 cases.
		if(balance > 1 && data < node.left.data)
			return rightRotate(node);
		if(balance < - 1 && data > node.right.data)
			return leftRotate(node);
		if(balance > 1 && data > node.left.data) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}
		if(balance < - 1 && data < node.right.data) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}
		
		return node;
	}
	
	public void printInOrder(Node node) {
		if(node != null) {
			printInOrder(node.left);
			System.out.print(node.data + " ");
			printInOrder(node.right);
		}
	}
}
