package myLibrary.DataStructures.Linear;

/**
 * Implementation of a singly linked list for integer data.
 * @author Dillon Pullano
 *
 */
public class SLL {

	// Define node
	int data;
	SLL next;
	
	// Initialize the head and tail Node (SLL)
	private SLL head = null;
	private SLL tail = null;
	
	// Constructor 1 for Node (SLL) 
	public SLL() 
	{
		this.next = null;
	}
	
	// Constructor 2 for Node (SLL) 
	public SLL(int data) 
	{
		this.data = data;
		this.next = null;
	}
    
	// Add node to SLL
    public void addNode(int data) 
    {   
    	SLL newNode = new SLL(data);
		
		if(this.head == null) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			this.tail.next = newNode;
			this.tail = newNode;
		}
    }   
    
    // Search node in SLL
    public int searchNode(int key)
    {
    	int counter = 0;
    	SLL temp = this.head;
    	
    	while(temp != null) {
    		
    		if(temp.data == key) {
    			return counter;
    		}
    		
    		temp = temp.next;
    		counter++;
    	}	
    	return -1;
    }
    
    // Delete node form SLL
    public void deleteNode(int key) 
    {
    	System.out.println("\nDeleting Node with Value " + key);
    	
    	SLL temp = this.head;
    	SLL prev = null;
    	
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
    
    // Display SLL
    public void display() 
    {         
    	SLL current = this.head;
    	
    	System.out.println("\nCurrent Nodes of the Singly Linked List:");
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