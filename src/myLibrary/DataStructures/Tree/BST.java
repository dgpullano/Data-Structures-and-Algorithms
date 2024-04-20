package myLibrary.DataStructures.Tree;

/**
 * Implementation of a Binary Search Tree.
 * @author Dillon Pullano
 *
 */
public class BST {

	// Create node
	public Node createNode(int data) {
		Node node = new Node();
		node.data = data;
		node.left = null;
		node.right = null;
		return node;
	}
	
	// Insert new node in BST - you can use recursive or iterative method
	public Node insert(int data, Node root) 
	{
		if(root == null) {
			return createNode(data);
		}
		
		if(data <= root.data) {
			root.left = insert(data, root.left);
		}
		else if(data > root.data) {
			root.right = insert(data, root.right);
		}
		return root;
	}
	
	// Inorder traversal - recursive OR iterative
	public void inOrder(Node node) 
	{
		if(node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.data + " ");
		inOrder(node.right);
	}

	// Preorder traversal - recursive OR iterative
	public void preOrder(Node node) 
	{
		if(node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	// Postorder traversal - recursive OR iterative
	public void postOrder(Node node) 
	{
		if(node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + " ");
	}
	
	// Breadth first traversal - recrsive OR iterative
	public void breadthFirstTraversal(Node root) 
	{
		QueueNode queue = new QueueNode(100);
		
		if(root == null) {
			return;
		}
		
		queue.enqueue(root);
		
		while(!(queue.head < 0 || queue.head > queue.tail)) {
			Node node = queue.dequeue();
			
			System.out.print(node.data + " ");
			
			if(node.left != null) {
				queue.enqueue(node.left);
			}
			
			if(node.right != null) {
				queue.enqueue(node.right);
			}
		}
	}
	
	// Search in BST
	public Node searchBinarySearchTree(Node node, int key)
	{
		while(node != null) {
			if(key == node.data) {
				return node;
			}
			
			else if(key < node.data) {
				node = node.left;
			}
			
			else {
				node = node.right;
			}
		}
		return null;
	}
	
	// Delete from BST
	public Node deleteNode(Node root, int key) 
	{
		// For case with empty queue
		if(root == null) {
			return root;
		}
		
		// For case where key is less than root:
		if(key < root.data) {
			root.left = deleteNode(root.left, key);
		}
		
		// For case where key is greater than root:
		else if(key > root.data) {
			root.right = deleteNode(root.right, key);
		}
		
		// For cases when there is only one child:
		else {
			
			if(root.left == null) {
				return root.right;
			}
			
			else if(root.right == null) {
				return root.left;
			}
			
			// Get min value successor to item being deleted:
			int min = findMin(root.right);
			
			root.data = min;
			
			while(root.right.left != null) {
				min = root.right.left.data;
				root.right = root.right.left;
			}
			
			// Delete successor:
			root.right = deleteNode(root.right, min);
		}
		
		return root;
	}
	
	// Gets next minimum Node:
	public int findMin(Node node) {
		int min = node.data;
		
		while(node.left != null) {
			min = node.left.data;
			node = node.left;
		}
		return min;
	}
}