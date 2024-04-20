package myLibrary.DataStructures.Tree;

/**
 * Implementation of a queue for data type node<integer>.
 * @author Dillon Pullano
 *
 */
public class QueueNode {
	
	// Define Queue
	int maxSize;
	Node[] queue;
	int head;
	int tail;
	
	// Constructor
	public QueueNode(int queueSize)
	{
		this.maxSize = queueSize;
		this.queue = new Node[this.maxSize];
		this.head = -1;
		this.tail = -1;		
	}
	
	// Enqueue
	public void enqueue(Node data)
	{	
		if(this.tail == this.maxSize - 1) {
			System.out.println("Queue is Full - Overflow");
			return;
		}
		else {
			if(this.head == -1 && this.tail == -1) {
				this.head = 0;
				this.tail = 0;
			}
			else {
				this.tail = this.tail + 1;
			}
			this.queue[this.tail] = data;
		}
	}
	
	// Dequeue
	public Node dequeue()
	{
		Node data;
		
		if(this.head < 0 || this.head > this.tail) {
			System.out.println("Queue is Empty - Underflow");
			return null;
		}
		else {
			data = this.queue[this.head];
			this.queue[this.head] = null;
			this.head = this.head + 1;
		}
		return data;
	}
	
	// Display queue
	public void display()
	{		
		for(int i = 0; i < this.maxSize; i++)
		{
			System.out.print(this.queue[i] + " ");
		}
	}
}