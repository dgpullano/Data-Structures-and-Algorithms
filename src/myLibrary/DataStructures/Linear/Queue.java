package myLibrary.DataStructures.Linear;

/**
 * Implementation of a queue for integer data.
 * @author Dillon Pullano
 *
 */
public class Queue {
	
	// Define Queue
	int maxSize;
	int[] queue;
	public int head;
	public int tail;
	
	// Constructor
	public Queue(int queueSize)
	{
		this.maxSize = queueSize;
		this.queue = new int[this.maxSize];
		this.head = -1;
		this.tail = -1;		
	}
	
	// Enqueue
	public void enqueue(int data)
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
	public int dequeue()
	{
		int data;
		
		if(this.head < 0 || this.head > this.tail) {
			System.out.println("Queue is Empty - Underflow");
			return -1;
		}
		else {
			data = this.queue[this.head];
			this.queue[this.head] = 0;
			this.head = this.head + 1;
		}
		return data;
	}
	
	// Display queue
	public void display()
	{		
		for(int i = 0; i < this.maxSize; i++)
		{
			System.out.print(this.queue[i] +" ");
		}
	}
}