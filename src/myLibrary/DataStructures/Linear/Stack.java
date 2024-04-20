package myLibrary.DataStructures.Linear;

/**
 * Implementation of a stack for integer data.
 * @author Dillon Pullano
 *
 */
public class Stack {
	
	// Define stack
	int maxSize;
	int[] stack;
	public int top;
	
	// Constructor
	public Stack(int stackSize)
	{
		this.maxSize = stackSize;
		this.stack = new int[this.maxSize];
		this.top = -1;
	}
	
	// Push 
	public void push(int data)
	{
		if(this.top == this.maxSize - 1) {
			System.out.println("Stack is Full - Overflow");
			return;
		}
		else {
			this.top = this.top + 1;
			this.stack[this.top] = data;
		}
	}
	
	// Pop
	public int pop()
	{
		int data;
		
		if(this.top < 0) {
			System.out.println("Stack is Empty - Under");
			return -1;
		}
		else {
			data = this.stack[this.top];
			this.stack[this.top] = 0;
			this.top = this.top - 1;
		}
		return data;
	}
	
	// Display stack
	public void display() 
	{
		for(int i = 0; i < this.maxSize; i++)
		{
			System.out.print(this.stack[i] + " ");
		}
	}
}