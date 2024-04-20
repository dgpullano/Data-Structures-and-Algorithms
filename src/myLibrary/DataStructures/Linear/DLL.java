package myLibrary.DataStructures.Linear;

/**
 * Implementation of a doubly linked list for integer data.
 * @author Dillon Pullano
 *
 */
public class DLL {

	// Define node
	int data;
	DLL prev;
	DLL next;
	
	// Initialize the head and tail Node (DLL)
	private DLL head = null;
	private DLL tail = null;
	
	// Constructor 1 for Node (DLL) 
	public DLL() 
	{
		this.prev = null;
		this.next = null;
	}
	
	// Constructor 2 for Node (DLL) 
	public DLL(int data) 
	{
		this.data = data;
		this.prev = null;
		this.next = null;
	}
	
	// Add node to DLL
    public void addNode(int data) 
    {   
    	DLL newNode = new DLL(data);
		
    	if(this.head == null) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			this.tail.next = newNode;
			newNode.prev = this.tail;
			this.tail = newNode;
		}
    }   
    
    // Search node in DLL
    public int searchNode(int key)
    {
    	int counter = 0;
    	DLL temp = this.head;
    	
    	while(temp != null) {
    		
    		if(temp.data == key) {
    			return counter;
    		}
    		
    		temp = temp.next;
    		counter++;
    	}	
    	return -1;
    }
    
    // Delete node
    public void deleteNode(int key) 
    {
    	System.out.println("\nDeleting Node with Value " + key);
    	
    	DLL temp = this.head;
    	DLL prev = null;
    	
    	if(temp != null && temp.data == key) {
    		this.head = temp.next;
    		return;
    	}
    	
    	while(temp != null && temp.data != key) {
    		prev = temp;
    		temp = temp.next;
    	}
    	
    	if(temp == null) {
    		return;
    	}
    	
    	prev.next = temp.next;
    }
    
    // Display the DLL
    public void display() 
    {   
    	DLL current = this.head;
    	
    	System.out.println("\nCurrent Nodes of the Doubly Linked List:");
    	if(this.head == null) {
    		System.out.println("Singly Linked List is Empty");
    		return;
    	}
    	
    	while(current !=  null) {
    		System.out.print(current.data + " ");
    		current = current.next;
    	}
    	System.out.println("");
    } 
}